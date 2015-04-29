package seasweeper.logiikka;

/**
 *
 * @author ez
 */
public class Voitontarkastaja {

    private final YlempiLogiikka ylempilogiikka;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;
    private int miinojenmaara;

    public Voitontarkastaja(YlempiLogiikka ylempilogiikka) {
        this.ylempilogiikka = ylempilogiikka;
    }

    public boolean voitettiinko() {
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
                        ylempilogiikka.kuva("lippu", x, y);
                    }
                }
            }
            return true;
        }
        
        return false;
    }
    
    public void setArvot(Ruutu[][] ruudukko, int k, int l, int miinojenmaara) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
        this.miinojenmaara = miinojenmaara;
    }
}