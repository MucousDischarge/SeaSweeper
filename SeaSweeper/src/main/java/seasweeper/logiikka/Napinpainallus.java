package seasweeper.logiikka;

import java.io.IOException;

/**
 *
 * Napinpainalluksen tarkempi logiikka.
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
     * Tuodaan ylinlogiikkaluokka  käytettäväksi, ja luodaan miinojenluoja, 
     * raivaaja ja voitontarkistaja, joille kuitenkin annetaan arvot vasta
     * myöhemmin ensimmäisen klikkauksen jälkeen.
     * 
     * @param ylinlogiikka Yhteys hierarkiassa ylempään luokkaan.
     */
    public Napinpainallus(YlinLogiikka ylinlogiikka) {
        this.ylinlogiikka = ylinlogiikka;
        this.miinojenluoja = new Miinojenluoja();
        this.raivaaja = new Raivaaja(this);
        this.voitontarkastaja = new Voitontarkastaja(this);
    }

    /**
     * Tämä metodi kutsutaan aina lautakuuntelijan havannoidessa klikkauksen.
     * 
     * @param source Klikattu JButton.
     * @param oikeako Boolean, joka kertoo onko klikattu oikeaa vaiko vasenta hiirenpainiketta.
     * @throws IOException
     */
    public void napinpainallus(Object source, boolean oikeako) throws IOException {
        if (!pelipaattynyt) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < l; b++) {
                    if (ruudukko[a][b].onkoNappi(source) && !(oikeako)) {
                        vasenKlikkaus(a, b);
                        tarkistetaanVoitettiinko();
                    } else if (ruudukko[a][b].onkoNappi(source)) {
                        oikeaKlikkaus(a, b);
                    }
                }
            }
        }
    }

    /**
     * Tämä kutsutaan aina vasenta hiirenpainiketta klikattua laudan JButtoneille,
     * ja tämä suorittaa oleellisimmat kutsut ja tarkistukset.
     * 
     * @param a Klikatun napin korkeussijainti.
     * @param b Klikatun napin leveyssijainti.
     */
    private void vasenKlikkaus(int a, int b) {
        ensimmainenKlikkaus(a, b);

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
     * Suoritetaan ensimmäisen klikkauksen yhteydessä, ja tämä suorittaa 
     * kellonkäynnin aloittamisen, miinojenluonnin ja raivaamisen/rajahtamisen kutsut.
     * 
     * @param a Klikatun napin korkeussijainti.
     * @param b Klikatun napin leveyssijainti.
     */
    private void ensimmainenKlikkaus(int a, int b) {
        if (onkoEnsimmainenKlikkaus) {
            if (k != 8 ) {
                ylinlogiikka.startKello();
            }
            onkoEnsimmainenKlikkaus = false;
            miinojenluoja.luoMiinat(a, b);
        }
    }

    /**
     * Tämä kutsutaan klikattua laudan JButtonia oikealla hiirenpainikkeella,
     * ja tämä ainoa toiminto onkin liputtaminen ja epäliputtaminen.
     * 
     * @param a Klikatun napin korkeussijainti.
     * @param b Klikatun napin leveyssijainti.
     */
    private void oikeaKlikkaus(int a, int b) {
        if (!(ruudukko[a][b].onkoRaivattu())) {
            if (ruudukko[a][b].onkoLippu()) {
                ruudukko[a][b].kuva("tummavesi");
                ruudukko[a][b].poistaLippu();
            } else {
                ruudukko[a][b].kuva("lippu");
                ruudukko[a][b].lisaaLippu();
            }
        }
    }
    
    /**
     * Tarkistetaan joka vasemman klikkauksen jälkeen voitettiinko.
     * 
     * @throws IOException
     */
    private void tarkistetaanVoitettiinko() throws IOException {
        if (voitontarkastaja.voitettiinko()) {
            ylinlogiikka.voitit();
            this.pelipaattynyt = true;
        }
    }
    
    /**
     * Asetetaan ylimmän logiikan käskemänä aina uuden ruudukon luonnin yhteydessä uudet arvot.
     * 
     * @param ruudukko Nykyinen pelilauta Ruutu-objekteja
     * @param k Ruudukon eli pelilaudan korkeus.
     * @param l Ruudukon eli pelilaudan leveys.
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
    
    /**
     * Voitontarkistuksen yhteydessä tarvitaan raivattujen määrää, jonka
     * seuraaminen napinpainalluksessa on resurssisesti halvempaa kuin sen
     * laskeminen joka kerta voitontarkistuksen yhteydessä uudelleen.
     * 
     * @return Raivattujen määrä.
     */
    public int getRaivattujenmaara() {
        return raivattujenmaara;
    }
    
    /**
     * Lisätään raivattujen määrään yksi.
     */
    public void lisaaRaivattu() {
        raivattujenmaara++;
    }

    /**
     * Erään harvinaisen ongelman ratkaisemiseen tarkoitettu tarkistus.
     * 
     * @return Onko lautaa klikattu vielä.
     */
        public boolean getOnkoEnsimmainenKlikkaus() {
        return onkoEnsimmainenKlikkaus;
    }
}
