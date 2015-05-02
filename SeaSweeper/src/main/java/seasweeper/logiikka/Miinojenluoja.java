package seasweeper.logiikka;

import java.util.Random;

/**
 *
 * Luo miinat ja ripottelee ne ruudukolle satunnaisesti
 */
public class Miinojenluoja {

    private Ruutu[][] ruudukko;
    private int miinojenmaara;
    private int miinaY;
    private int miinaX;

    /**
     * Luodaan miinat, muttei klikatulle ruudulle, jonka sijainti annetaan parametrinä
     * - lisäksi laudan koko päätellään miinojen määrästä.
     * 
     * @param a Klikatun ruudun korkeussijainti.
     * @param b Klikatun ruudun leveyssijainti.
     */
    public void luoMiinat(int a, int b) {
        int w = 0;

        while (w < miinojenmaara) {
            vaihdaXjaY();

            if (!(miinaY == a && miinaX == b)) {
                if (!(ruudukko[miinaY][miinaX].onkoMiina())) {
                    ruudukko[miinaY][miinaX].laitaMiina();
                    w++;
                }
            }

        }
    }

    /**
     * While-loopin sisällä miinojen generoimiseen satunnaisia sijainti antava metodi.
     */
    public void vaihdaXjaY() {
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
    }

    /**
     * Itse satunnaislukugeneraattori, jolle annetaan minimiluku ja maksimiluku, joiden
     * välillä arvotaan satunnaisluku.
     * 
     * @param minimi Halutun välin minimiluku.
     * @param maksimi Halutun välin maksimiluku
     * @return Satunnainen luku halutulta väliltä.
     */
    public static int satunnainenLukuValilta(int minimi, int maksimi) {

        Random randomi = new Random();

        int satunnainenLuku = randomi.nextInt((maksimi - minimi) + 1) + minimi;

        return satunnainenLuku;
    }

    /**
     * Uusien ruudukkojen luonnissa annetaan uudet arvot.
     * 
     * @param ruudukko Uusi ruudukko.
     * @param miinojenmaara Uusi miinojenmaara.
     */
    public void setRuudukko(Ruutu[][] ruudukko, int miinojenmaara) {
        this.ruudukko = ruudukko;
        this.miinojenmaara = miinojenmaara;
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
    /**
     * Testimetodi.
     * 
     * @return
     */
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
}
