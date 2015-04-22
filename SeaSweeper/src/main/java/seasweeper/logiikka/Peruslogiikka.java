/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.logiikka;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author ez
 */
public class Peruslogiikka {

    private boolean onkoEnsimmainenKlikkaus;
    private final Miinaluokka miinaluokka;
    private final int k;
    private final int l;
    private final JButton[][] napisto;
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;
    private final ImageIcon kuvat[];
    private final Boolean[][] raivattujenlista;
    private final Boolean[][] lippulista;
    private Boolean pelipaattynyt;
    private int miinojenmaara;
    private long alkuaika;

    public Peruslogiikka(int k, int l, JButton[][] napisto, ImageIcon miina, ImageIcon lippu, ImageIcon tummavesi, ImageIcon[] kuvat) {
        this.onkoEnsimmainenKlikkaus = false;
        this.k = k;
        this.l = l;
        this.raivattujenlista = new Boolean[k][l];
        this.lippulista = new Boolean[k][l];
        this.miinaluokka = new Miinaluokka(l);
        this.napisto = napisto;
        this.miina = miina;
        this.lippu = lippu;
        this.tummavesi = tummavesi;
        this.kuvat = kuvat;
        this.pelipaattynyt = false;
        this.miinojenmaara = 8;
        if (l == 8) {
            miinojenmaara = 10;
        } else if (l == 16) {
            miinojenmaara = 40;
        } else {
            miinojenmaara = 99;
        }
    }

    public void napinpainallus(Object source, boolean oikeako) {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < l; b++) {
                    if (source == napisto[a][b] && !(oikeako)) {
                        if (!(onkoEnsimmainenKlikkaus)) {
                            alkuaika = System.currentTimeMillis();
                            onkoEnsimmainenKlikkaus = true;
                            miinaluokka.luoMiinat(a, b, miinojenmaara);
                        }

                        if (miinaluokka.onkoMiina(a, b, miinojenmaara)) {
                            System.out.println("Osuit miinaan...");
                            Rajahti();
                            //kaikki miinat paljastuvat ruudulla
                        } else {
                            Raivaaja(a, b, false);
                            //alta paljastuu muuta kuin miina, ja läheiset paljastuvat myös

                        }
                    } else if (source == napisto[a][b]) {
                        if (raivattujenlista[a][b] != null) {
                            if (!(raivattujenlista[a][b])) {
                                napinpainalluksenSiistija(a, b);
                            }
                        } else {
                            napinpainalluksenSiistija(a, b);
                        }

                    }
                }
            }
            tarkistaVoitettiinko();
        }
    }

    public void Rajahti() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (miinaluokka.onkoMiina(x, y, miinojenmaara)) {
                    napisto[x][y].setIcon(miina);
                }
            }
        }
        this.pelipaattynyt = true;
    }

    public void Raivaaja(int a, int b, boolean liianKaukainen) {
        if (tarkista(a, b)) {
            int[][] lista = luoLista(a, b);
            int luku = laskeLuku(lista);

            napisto[a][b].setIcon(kuvat[luku]);

            raivattujenlista[a][b] = true;

            if (!(liianKaukainen || luku > 0)) {
                for (int i = 0; i < 8; i++) {
                    if (tarkista(lista[i][0], lista[i][1]) && !(miinaluokka.onkoMiina(lista[i][0], lista[i][1], miinojenmaara))) {

                        if (raivattujenlista[lista[i][0]][lista[i][1]] != null) {
                            if (!(raivattujenlista[lista[i][0]][lista[i][1]])) {
                                raivaajaSiistija(i, lista);
                            }
                        } else {
                            raivaajaSiistija(i, lista);
                        }

                    }
                }
            }
        }
    }

    public int[][] luoLista(int a, int b) {
        int[][] lista = new int[8][2];

        lista[0][0] = a;
        lista[0][1] = b + 1;
        lista[1][0] = a;
        lista[1][1] = b - 1;
        lista[2][0] = a + 1;
        lista[2][1] = b;
        lista[3][0] = a - 1;
        lista[3][1] = b;
        lista[4][0] = a + 1;
        lista[4][1] = b + 1;
        lista[5][0] = a - 1;
        lista[5][1] = b - 1;
        lista[6][0] = a + 1;
        lista[6][1] = b - 1;
        lista[7][0] = a - 1;
        lista[7][1] = b + 1;

        return lista;
    }

    public int laskeLuku(int[][] lista) {
        int luku = 0;

        for (int i = 0; i < 8; i++) {
            if (tarkista(lista[i][0], lista[i][1])) {
                if (miinaluokka.onkoMiina(lista[i][0], lista[i][1], miinojenmaara)) {
                    luku++;
                }
            }
        }

        return luku;
    }

    public boolean tarkista(int a, int b) {
        if (a <= k - 1 && a >= 0 && b <= l - 1 && b >= 0) {
            return true;
        }

        return false;
    }

    public void tarkistaVoitettiinko() {
        int raivattujenmaara = 0;

        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (raivattujenlista[x][y] != null) {
                    if (raivattujenlista[x][y]) {
                        raivattujenmaara++;
                    }
                }
            }
        }

        if ((k * l) - raivattujenmaara == miinojenmaara) {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < l; y++) {
                    if (miinaluokka.onkoMiina(x, y, miinojenmaara)) {
                        napisto[x][y].setIcon(lippu);
                    }
                }
            }
            System.out.println("Voitit!");
            System.out.println("Aikasi: " + Math.round((System.currentTimeMillis() - alkuaika) / 1000) + " sekuntia.");
            this.pelipaattynyt = true;
        }
    }

    public void napinpainalluksenSiistija(int a, int b) {
        if (lippulista[a][b] != null) {
            if (lippulista[a][b]) {
                napisto[a][b].setIcon(tummavesi);
                lippulista[a][b] = false;
            } else {
                napisto[a][b].setIcon(lippu);
                lippulista[a][b] = true;
            }
        } else {
            napisto[a][b].setIcon(lippu);
            lippulista[a][b] = true;
        }
    }

    public void raivaajaSiistija(int i, int[][] lista) {
        int[][] uusiLista = luoLista(lista[i][0], lista[i][1]);
        if (laskeLuku(uusiLista) == 0) {
            Raivaaja(lista[i][0], lista[i][1], false);
        } else {
            Raivaaja(lista[i][0], lista[i][1], true);
        }
    }
}
