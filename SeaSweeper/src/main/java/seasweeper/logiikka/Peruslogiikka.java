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
 * @author ezaalto
 */
public class Peruslogiikka {

    private boolean onkoEnsimmainenKlikkaus;
    private Miinaluokka miinaluokka;
    private int k;
    private JButton[][] napisto;
    private ImageIcon miina;
    private ImageIcon lippu;
    private ImageIcon tummavesi;
    private ImageIcon kuvat[];
    private Boolean[][] raivattujenlista;
    private Boolean[][] lippulista;
    private Boolean pelipaattynyt;

    public Peruslogiikka(Miinaluokka miinaluokka, int k, JButton[][] napisto, ImageIcon miina, ImageIcon lippu, ImageIcon tummavesi, ImageIcon[] kuvat) {
        this.onkoEnsimmainenKlikkaus = false;
        this.raivattujenlista = new Boolean[k][k];
        this.lippulista = new Boolean[k][k];
        this.miinaluokka = miinaluokka;
        this.k = k;
        this.napisto = napisto;
        this.miina = miina;
        this.lippu = lippu;
        this.tummavesi = tummavesi;
        this.kuvat = kuvat;
        this.pelipaattynyt = false;
    }

    public void napinpainallus(Object source, boolean oikeako) {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < k; b++) {
                    tarkistaVoitettiinko();
                    if (source == napisto[a][b] && !(oikeako)) {
                        if (!(onkoEnsimmainenKlikkaus)) {
                            onkoEnsimmainenKlikkaus = true;
                            miinaluokka.luoMiinat(a, b);
                        }

                        if (miinaluokka.onkoMiina(a, b)) {
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
                        } else {
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

                    }
                }
            }
        }
    }

    public void Rajahti() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                if (miinaluokka.onkoMiina(x, y)) {
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
                    if (tarkista(lista[i][0], lista[i][1]) && !(miinaluokka.onkoMiina(lista[i][0], lista[i][1]))) {

                        if (raivattujenlista[lista[i][0]][lista[i][1]] != null) {
                            if (!(raivattujenlista[lista[i][0]][lista[i][1]])) {
                                int[][] uusiLista = luoLista(lista[i][0], lista[i][1]);
                                if (laskeLuku(uusiLista) == 0) {
                                    Raivaaja(lista[i][0], lista[i][1], false);
                                } else {
                                    Raivaaja(lista[i][0], lista[i][1], true);
                                }
                            }
                        } else {
                            int[][] uusiLista = luoLista(lista[i][0], lista[i][1]);
                            if (laskeLuku(uusiLista) == 0) {
                                Raivaaja(lista[i][0], lista[i][1], false);
                            } else {
                                Raivaaja(lista[i][0], lista[i][1], true);
                            }
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
                if (miinaluokka.onkoMiina(lista[i][0], lista[i][1])) {
                    luku++;
                }
            }
        }

        return luku;
    }

    public boolean tarkista(int a, int b) {
        if (a <= 15 && a >= 0 && b <= 15 && b >= 0) {
            return true;
        }

        return false;
    }

    public void tarkistaVoitettiinko() {
        int raivattujenmaara = 0;

        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                if (raivattujenlista[x][y] != null) {
                    if (raivattujenlista[x][y]) {
                        raivattujenmaara++;
                    }
                }
            }
        }

        if (256 - raivattujenmaara == 216) {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < k; y++) {
                    if (miinaluokka.onkoMiina(x, y)) {
                        napisto[x][y].setIcon(lippu);
                        System.out.println("Voitit!");
                    }
                }
            }
            
            this.pelipaattynyt = true;
        }
    }
}
