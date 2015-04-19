/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ezaalto
 */


public class Miinaluokka {
    final Map<String, Boolean> miinat;
    final ArrayList<String> lista;
    final ArrayList<Integer> pistetyt;
        
    public Miinaluokka() {
        this.miinat = new HashMap<String, Boolean>();
        this.lista = new ArrayList<String>();
        this.pistetyt = new ArrayList<Integer>();
    }
    
    public void luoMiinat(String ensimmainen) {
        luoListat();
        int w = 0;
        
        while (w < 40) {
            boolean onko = false;
            int miina = satunnainenLukuValilta(0, 255);
            for (int i = 0; i < pistetyt.size(); i++) {
                if (pistetyt.get(i) == miina) {
                    onko = true;
                }
            }
            if (!(lista.get(miina).equals(ensimmainen)) && !(onko)) {
                this.miinat.put(lista.get(miina), true);
                pistetyt.add(miina);
                w++;   
            }
        }
        
    }
    
    public void luoListat() {
        String nykyinen;
        
        for (int a = 0; a < 16; a++) {
            for (int b = 0; b < 16; b++) {
                nykyinen = "" + a + ":" + b;
                this.miinat.put(nykyinen, false);
                this.lista.add(nykyinen);
                nykyinen = "";
            }
        }
    }
    
    public boolean onkoMiina(String ruutu) {
        if (this.miinat.get(ruutu)) {
            return true;
        }
        
        return false;
    }
    
    public static int satunnainenLukuValilta(int minimi, int maksimi) {

        Random randomi = new Random();

        int satunnainenLuku = randomi.nextInt((maksimi - minimi) + 1) + minimi;

        return satunnainenLuku;
    }
}
