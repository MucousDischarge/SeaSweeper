package seasweeper.logiikka;

import java.util.Random;

/**
 *
 * Luo miinat ja ripottelee ne ruudukolle satunnaisesti
 */
public class Miinojenluoja {
    private Ruutu[][] ruudukko;
    private int miinojenmaara;

    /**
     *
     */
    public Miinojenluoja() {
    }

    /**
     *
     * @param a
     * @param b
     */
    public void luoMiinat(int a, int b) {
        int w = 0;

        int miinaY;
        int miinaX;

        while (w < miinojenmaara) {

            switch (miinojenmaara) {
                case 10:
                    miinaY = satunnainenLukuValilta(0, 7);
                    miinaX = satunnainenLukuValilta(0, 7);
                    break;
                case 99:
                    miinaY = satunnainenLukuValilta(0, 15);
                    miinaX = satunnainenLukuValilta(0, 29);
                    break;
                default:
                    miinaY = satunnainenLukuValilta(0, 15);
                    miinaX = satunnainenLukuValilta(0, 15);
                    break;
            }

            if (!(miinaY == a && miinaX == b)) {
                if (!(ruudukko[miinaY][miinaX].onkoMiina())) {
                    ruudukko[miinaY][miinaX].laitaMiina();
                    w++;
                }
            }

        }
    }

    /**
     *
     * @param minimi
     * @param maksimi
     * @return
     */
    public static int satunnainenLukuValilta(int minimi, int maksimi) {

        Random randomi = new Random();

        int satunnainenLuku = randomi.nextInt((maksimi - minimi) + 1) + minimi;

        return satunnainenLuku;
    }
    
    /**
     *
     * @param ruudukko
     * @param miinojenmaara
     */
    public void setRuudukko(Ruutu[][] ruudukko, int miinojenmaara) {
        this.ruudukko = ruudukko;
        this.miinojenmaara = miinojenmaara;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    
    /**
     *
     * @return
     */
        
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
}
