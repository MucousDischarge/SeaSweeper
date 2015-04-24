package seasweeper.logiikka;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import seasweeper.gui.Kuvaluokka;

/**
 *
 * @author ez
 */
public class AlempiLogiikka {

    private boolean onkoEnsimmainenKlikkaus;
    private final Miinojenluoja miinojenluoja;
    private final int k;
    private final int l;
    private final Ruutu[][] ruudukko;
    private JButton[][] napisto;
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;
    private final ImageIcon kuvat[];
    private final Boolean[][] raivattujenlista;
    private final Boolean[][] lippulista;
    private Boolean pelipaattynyt;
    private final int miinojenmaara;
    private long alkuaika;
    private final Kuvaluokka kuvaluokka;

    public AlempiLogiikka(Ruutu[][] ruudukko, int k, int l) {
        this.onkoEnsimmainenKlikkaus = true;
        this.k = k;
        this.l = l;
        this.ruudukko = ruudukko;
        this.kuvaluokka = new Kuvaluokka();
        this.raivattujenlista = new Boolean[k][l];
        this.lippulista = new Boolean[k][l];
        this.miinojenluoja = new Miinojenluoja(ruudukko);
        this.napisto = new JButton[k][l];
        this.miina = kuvaluokka.getKuva("miina.png");
        this.lippu = kuvaluokka.getKuva("lippu.png");
        this.tummavesi = kuvaluokka.getKuva("tummavesi.png");
        this.kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = kuvaluokka.getKuva(i + ".png");
        }
        this.pelipaattynyt = false;
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
                        if (onkoEnsimmainenKlikkaus) {
                            alkuaika = System.currentTimeMillis();
                            onkoEnsimmainenKlikkaus = false;
                            miinojenluoja.luoMiinat(a, b, miinojenmaara);
                        }

                        if (miinojenluoja.onkoRuutuMiina(ruudukko[a][b])) {
                            System.out.println("Osuit miinaan...");
                            Rajahti();
                            //kaikki miinat paljastuvat ruudulla
                        } else {
                            Raivaaja(a, b, false);
                            //alta paljastuu muuta kuin miina, ja läheiset paljastuvat myös

                        }
                    } else if (source == napisto[a][b]) {
                        if (!(ruudukko[a][b].onkoRaivattu())) {
                            if (ruudukko[a][b].onkoLippu()) {
                                napisto[a][b].setIcon(tummavesi);
                                ruudukko[a][b].poistaLippu();
                            } else {
                                napisto[a][b].setIcon(lippu);
                                ruudukko[a][b].lisaaLippu();
                            }
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
                if (miinojenluoja.onkoRuutuMiina(ruudukko[x][y])) {
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

            ruudukko[a][b].onRaivattu();

            if (!(liianKaukainen || luku > 0)) {
                for (int i = 0; i < 8; i++) {
                    if (tarkista(lista[i][0], lista[i][1]) && !(ruudukko[lista[i][0]][lista[i][1]].onkoMiina())) {

                        if (!(ruudukko[lista[i][0]][lista[i][1]].onkoRaivattu())) {
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
                if (ruudukko[lista[i][0]][lista[i][1]].onkoMiina()) {
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
                if (ruudukko[x][y].onkoRaivattu()) {
                    raivattujenmaara++;
                }
            }
        }

        if ((k * l) - raivattujenmaara == miinojenmaara) {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < l; y++) {
                    if (ruudukko[x][y].onkoMiina()) {
                        napisto[x][y].setIcon(lippu);
                    }
                }
            }
            System.out.println("Voitit!");
            System.out.println("Aikasi: " + Math.round((System.currentTimeMillis() - alkuaika) / 1000) + " sekuntia.");
            this.pelipaattynyt = true;
        }
    }
    
    public JButton[][] getNapisto() {
        return napisto;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    
    public boolean getOnkoEnsimmainenKlikkaus() {
        return onkoEnsimmainenKlikkaus;
    }
    
    public int getK() {
        return k;
    }
    
    public int getL() {
        return l;
    }
    
    public boolean getPeliPaattynyt() {
        return pelipaattynyt;
    }
}
