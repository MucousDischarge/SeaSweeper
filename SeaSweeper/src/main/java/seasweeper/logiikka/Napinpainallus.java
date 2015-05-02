package seasweeper.logiikka;

import java.io.IOException;

/**
 *
 * Alemman, tarkemman tason pelilogiikka
 */
public class Napinpainallus {

    private final YlinLogiikka ylinlogiikka;
    private final Raivaaja raivaaja;
    private final Voitontarkastaja voitontarkastaja;
    private final Miinojenluoja miinojenluoja;
    private boolean onkoEnsimmainenKlikkaus;
    private Boolean pelipaattynyt;
    private int k;
    private int l;
    private Ruutu[][] ruudukko;
    private int raivattujenmaara;

    /**
     *
     * @param ylempilogiikka
     */
    public Napinpainallus(YlinLogiikka ylempilogiikka) {
        this.ylinlogiikka = ylempilogiikka;
        this.miinojenluoja = new Miinojenluoja();
        this.raivaaja = new Raivaaja(this);
        this.voitontarkastaja = new Voitontarkastaja(this);
    }

    /**
     *
     * @param source
     * @param oikeako
     * @throws IOException
     */
    public void napinpainallus(Object source, boolean oikeako) throws IOException {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < l; b++) {
                    if (ruudukko[a][b].onkoNappi(source) && !(oikeako)) {
                        vasenKlikkaus(a, b);
                    } else if (ruudukko[a][b].onkoNappi(source)) {
                        oikeaKlikkaus(a, b);
                    }
                }
            }
            tarkistetaanVoitettiinko();
        }
    }

    /**
     *
     * @param a
     * @param b
     */
    public void vasenKlikkaus(int a, int b) {
        if (onkoEnsimmainenKlikkaus) {
            if (k != 8 ) {
                ylinlogiikka.startKello();
            }
            onkoEnsimmainenKlikkaus = false;
            miinojenluoja.luoMiinat(a, b);
        }

        if (ruudukko[a][b].onkoMiina()) {
            voitontarkastaja.havittiin();
            ylinlogiikka.rajahti();
            //kaikki miinat paljastuvat ruudulla
            this.pelipaattynyt = true;
        } else {
            raivaaja.raivaus(a, b);
            //ruudun sisältö paljastetaan, ja tyhjän tapauksessa leviää
        }
    }

    /**
     *
     * @param a
     * @param b
     */
    public void oikeaKlikkaus(int a, int b) {
        if (!(ruudukko[a][b].onkoRaivattu())) {
            if (ruudukko[a][b].onkoLippu()) {
                ylinlogiikka.kuva("tummavesi", a, b);
                ruudukko[a][b].poistaLippu();
            } else {
                ylinlogiikka.kuva("lippu", a, b);
                ruudukko[a][b].lisaaLippu();
            }
        }
    }
    
    /**
     *
     * @throws IOException
     */
    public void tarkistetaanVoitettiinko() throws IOException {
        if (voitontarkastaja.voitettiinko()) {
            ylinlogiikka.voitit();
            this.pelipaattynyt = true;
        }
    }
    
    /**
     *
     * @param ruudukko
     * @param k
     * @param l
     */
    public void setArvot(Ruutu[][] ruudukko, int k, int l) {
        raivattujenmaara = 0;
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
        int miinojenmaara;
        if (l == 8) {
            miinojenmaara = 10;
        } else if (l == 16) {
            miinojenmaara = 40;
        } else {
            miinojenmaara = 99;
        }
        miinojenluoja.setRuudukko(ruudukko, miinojenmaara);
        raivaaja.setArvot(ruudukko, k, l);
        voitontarkastaja.setArvot(ruudukko, k, l, miinojenmaara);
        onkoEnsimmainenKlikkaus = true;
        pelipaattynyt = false;
    }
    
    public void kuva(String kuva, int x, int y) {
        ylinlogiikka.kuva(kuva, x, y);
    }
    
    public int getRaivattujenmaara() {
        return raivattujenmaara;
    }
    
    public void lisaaRaivattu() {
        raivattujenmaara++;
    }

    // TESTEJÄ VARTEN OLEVAT METODIT

    /**
     *
     * @return
     */
        public boolean getOnkoEnsimmainenKlikkaus() {
        return onkoEnsimmainenKlikkaus;
    }

    /**
     *
     * @return
     */
    public int getK() {
        return k;
    }

    /**
     *
     * @return
     */
    public int getL() {
        return l;
    }

    /**
     *
     * @return
     */
    public boolean getPeliPaattynyt() {
        return pelipaattynyt;
    }
}
