package seasweeper.logiikka;

import java.io.IOException;

/**
 *
 * @author ez
 */
public class AlempiLogiikka {

    private final YlempiLogiikka ylempilogiikka;
    private final Raivaaja raivaaja;
    private final Voitontarkastaja voitontarkastaja;
    private final Miinojenluoja miinojenluoja;
    private boolean onkoEnsimmainenKlikkaus;
    private Boolean pelipaattynyt;
    private int k;
    private int l;
    private Ruutu[][] ruudukko;
    private long alkuaika;

    public AlempiLogiikka(YlempiLogiikka ylempilogiikka) {
        this.ylempilogiikka = ylempilogiikka;
        this.miinojenluoja = new Miinojenluoja();
        this.raivaaja = new Raivaaja(ylempilogiikka);
        this.voitontarkastaja = new Voitontarkastaja(ylempilogiikka);
    }

    public void napinpainallus(Object source, boolean oikeako) throws IOException {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < l; b++) {
                    if (source == ylempilogiikka.getNappi(a, b) && !(oikeako)) {
                        vasenKlikkaus(a, b);
                    } else if (source == ylempilogiikka.getNappi(a, b)) {
                        oikeaKlikkaus(a, b);
                    }
                }
            }
            tarkistetaanVoitettiinko();
        }
    }

    public void vasenKlikkaus(int a, int b) {
        if (onkoEnsimmainenKlikkaus) {
            if (k != 8 ) {
                ylempilogiikka.startKello();
            }
            onkoEnsimmainenKlikkaus = false;
            miinojenluoja.luoMiinat(a, b);
        }

        if (ruudukko[a][b].onkoMiina()) {
            raivaaja.rajahti();
            ylempilogiikka.rajahti();
            //kaikki miinat paljastuvat ruudulla
            this.pelipaattynyt = true;
        } else {
            raivaaja.raivaus(a, b, false);
            //ruudun sisältö paljastetaan, ja tyhjän tapauksessa leviää
        }
    }

    public void oikeaKlikkaus(int a, int b) {
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
    
    public void tarkistetaanVoitettiinko() throws IOException {
        if (voitontarkastaja.voitettiinko()) {
            ylempilogiikka.voitit();
            this.pelipaattynyt = true;
        }
    }
    
    public void setArvot(Ruutu[][] ruudukko, int k, int l) {
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
