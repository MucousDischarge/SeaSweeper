package seasweeper.logiikka;

/**
 *
 * Tarkastaa joka klikkauksen jälkeen ollaanko voitettu.
 */
public class Voitontarkastaja {

    private final Napinpainallus napinpainallus;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;
    private int miinojenmaara;

    /**
     * Annetaan konstruktorissa yhteys napinpainallusluokkaan.
     * 
     * @param napinpainallus Napinpainallusluokka.
     */
    public Voitontarkastaja(Napinpainallus napinpainallus) {
        this.napinpainallus = napinpainallus;
    }

    /**
     * Napinpainalluksessa kutsutaan tämä voitontarkistus joka pelilaudan nappuloita 
     * kohtaan osuvan vasemman klikkauksen jälkeen.
     * 
     * @return Totuusarvo voitosta vai ei vielä voitosta.
     */
    public boolean voitettiinko() {

        if ((k * l) - napinpainallus.getRaivattujenmaara() == miinojenmaara) {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < l; y++) {
                    if (ruudukko[x][y].onkoMiina()) {
                        ruudukko[x][y].kuva("lippu");
                    }
                }
            }
            return true;
        }
        
        return false;
    }
    
    /**
     * Joskun ei voi voittaa, ja miinaa klikatessa napinpainallusluokassa 
     * kaikki miinat paljastetaan. 
     */
    public void havittiin() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (ruudukko[x][y].onkoMiina()) {
                    ruudukko[x][y].kuva("miina");
                }
            }
        }
    }
    
    /**
     * Uusien ruudukoiden luonnin takia arvoja pitää tulla voida antaa uudelleen.
     * 
     * @param ruudukko Pelilaudan nappulat, Ruutu-oliot.
     * @param k Pelilaudan korkeus.
     * @param l Pelilaudan leveys.
     * @param miinojenmaara Miinojen määrä pelilaudalla.
     */
    public void setArvot(Ruutu[][] ruudukko, int k, int l, int miinojenmaara) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
        this.miinojenmaara = miinojenmaara;
    }
}
