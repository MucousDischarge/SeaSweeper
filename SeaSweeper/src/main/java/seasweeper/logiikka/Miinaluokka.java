/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.logiikka;

import java.util.Random;

/**
 *
 * @author ezaalto
 */
public class Miinaluokka {

    final int[][] miinat;

    public Miinaluokka() {
        this.miinat = new int[40][2];
    }

    public void luoMiinat(int a, int b) {
        int w = 0;

        while (w < 40) {
            int miinaY = satunnainenLukuValilta(0, 15);
            int miinaX = satunnainenLukuValilta(0, 15);

            if (!(miinaY == a && miinaX == b)) {
                if (!(onkoMiina(miinaY, miinaX))) {
                    this.miinat[w][0] = miinaY;
                    this.miinat[w][1] = miinaX;
                    w++;
                }
            }

        }
    }

    public boolean onkoMiina(int a, int b) {
        for (int i = 0; i < 40; i++) {
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
