package seasweeper.logiikka;

/**
 *
 * Tarkastaa joka klikkauksen jälkeen ollaanko voitettu
 */
public class Voitontarkastaja {

    private final Napinpainallus napinpainallus;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;
    private int miinojenmaara;

    /**
     *
     * @param napinpainallus
     */
    public Voitontarkastaja(Napinpainallus napinpainallus) {
        this.napinpainallus = napinpainallus;
    }

    /**
     *
     * @return
     */
    public boolean voitettiinko() {

        if ((k * l) - napinpainallus.getRaivattujenmaara() == miinojenmaara) {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < l; y++) {
                    if (ruudukko[x][y].onkoMiina()) {
                        napinpainallus.kuva("lippu", x, y);
                    }
                }
            }
            return true;
        }
        
        return false;
    }
    
    public void havittiin() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (ruudukko[x][y].onkoMiina()) {
                    napinpainallus.kuva("miina", x, y);
                }
            }
        }
    }
    
    /**
     *
     * @param ruudukko
     * @param k
     * @param l
     * @param miinojenmaara
     */
    public void setArvot(Ruutu[][] ruudukko, int k, int l, int miinojenmaara) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
        this.miinojenmaara = miinojenmaara;
    }
}
