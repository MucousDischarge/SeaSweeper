package seasweeper.logiikka;

import java.util.Random;

/**
 *
 * @author ez
 */
public class Miinojenluoja {
    private final Ruutu[][] ruudukko;

    public Miinojenluoja(Ruutu[][] ruudukko) {
        this.ruudukko = ruudukko;
    }

    public void luoMiinat(int a, int b, int miinamaara) {
        int w = 0;

        int miinaY;
        int miinaX;

        while (w < miinamaara) {

            switch (miinamaara) {
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

    public boolean onkoRuutuMiina(Ruutu ruutu) {
        if (ruutu.onkoMiina()) {
            return true;
        }

        return false;
    }

    public static int satunnainenLukuValilta(int minimi, int maksimi) {

        Random randomi = new Random();

        int satunnainenLuku = randomi.nextInt((maksimi - minimi) + 1) + minimi;

        return satunnainenLuku;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
}
