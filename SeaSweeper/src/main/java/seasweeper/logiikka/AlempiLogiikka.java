package seasweeper.logiikka;

/**
 *
 * @author ez
 */
public class AlempiLogiikka {

    private boolean onkoEnsimmainenKlikkaus;
    private Miinojenluoja miinojenluoja;
    private Raivaaja raivaaja;
    private Voitontarkastaja voitontarkastaja;
    private int k;
    private int l;
    private Ruutu[][] ruudukko;
    private final YlempiLogiikka ylempilogiikka;
    private Boolean pelipaattynyt;
    private int miinojenmaara;
    private long alkuaika;

    public AlempiLogiikka(YlempiLogiikka ylempilogiikka) {
        this.ylempilogiikka = ylempilogiikka;
        this.raivaaja = new Raivaaja(ylempilogiikka);
        this.voitontarkastaja = new Voitontarkastaja(ylempilogiikka);
    }

    public void napinpainallus(Object source, boolean oikeako) {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < l; b++) {
                    if (source == ylempilogiikka.getNappi(a, b) && !(oikeako)) {
                        if (onkoEnsimmainenKlikkaus) {
                            alkuaika = System.currentTimeMillis();
                            onkoEnsimmainenKlikkaus = false;
                            miinojenluoja.luoMiinat(a, b, miinojenmaara);
                        }

                        if (ruudukko[a][b].onkoMiina()) {
                            System.out.println("Osuit miinaan...");
                            raivaaja.rajahti();
                            this.pelipaattynyt = true;
                            //kaikki miinat paljastuvat ruudulla
                        } else {
                            raivaaja.raivaus(a, b, false);
                            //alta paljastuu muuta kuin miina, ja läheiset paljastuvat myös
                        }
                    } else if (source == ylempilogiikka.getNappi(a, b)) {
                        if (!(ruudukko[a][b].onkoRaivattu())) {
                            if (ruudukko[a][b].onkoLippu()) {
                                ylempilogiikka.kuva("tummavesi", a, b);
                                ruudukko[a][b].poistaLippu();
                            } else {
                                ylempilogiikka.kuva("lippu", a, b);
                                ruudukko[a][b].lisaaLippu();
                            }
                        }
                    }
                }
            }
            if (voitontarkastaja.voitettiinko()) {
                System.out.println("Voitit!");
                System.out.println("Aikasi: " + Math.round((System.currentTimeMillis() - alkuaika) / 1000) + " sekuntia.");
                this.pelipaattynyt = true;
            }
        }
    }

    public void setArvot(Ruutu[][] ruudukko, int k, int l) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
        this.miinojenluoja = new Miinojenluoja(ruudukko);
        if (l == 8) {
            miinojenmaara = 10;
        } else if (l == 16) {
            miinojenmaara = 40;
        } else {
            miinojenmaara = 99;
        }
        raivaaja.setArvot(ruudukko, k, l);
        voitontarkastaja.setArvot(ruudukko, k, l, miinojenmaara);
        onkoEnsimmainenKlikkaus = true;
        pelipaattynyt = false;
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
