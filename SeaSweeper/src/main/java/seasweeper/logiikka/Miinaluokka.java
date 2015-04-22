/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.logiikka;

import java.util.Random;

/**
 *
 * @author ez
 */
public class Miinaluokka {

    private final int[][] miinat;

    public Miinaluokka(int l) {
        switch (l) {
            case 8:
                this.miinat = new int[10][2];
                break;
            case 30:
                this.miinat = new int[99][2];
                break;
            default:
                this.miinat = new int[40][2];
                break;
        }
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
                if (!(onkoMiina(miinaY, miinaX, miinamaara))) {
                    this.miinat[w][0] = miinaY;
                    this.miinat[w][1] = miinaX;
                    w++;
                }
            }

        }
    }

    public boolean onkoMiina(int a, int b, int miinamaara) {
        for (int i = 0; i < miinamaara; i++) {
            if (this.miinat[i][0] == a && this.miinat[i][1] == b) {
                return true;
            }
        }

        return false;
    }

    public static int satunnainenLukuValilta(int minimi, int maksimi) {

        Random randomi = new Random();

        int satunnainenLuku = randomi.nextInt((maksimi - minimi) + 1) + minimi;

        return satunnainenLuku;
    }
}
