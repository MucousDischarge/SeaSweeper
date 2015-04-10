/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.logiikka;

/**
 *
 * @author ezaalto
 */
public class Ruutu {
    private int ruudunsisalto;
    
    public Ruutu() {
        this.ruudunsisalto = 0;
    }
    
    public void onMiina() {
        this.ruudunsisalto = 2;
    }
    
    public void onNumero() {
        this.ruudunsisalto = 1;
    }
    
    public String getSisalto() {
        if (this.ruudunsisalto == 0) {
            return "tyhja";
        } else if (this.ruudunsisalto == 1) {
            return "numero";
        } else if (this.ruudunsisalto == 2) {
            return "miina";
        } else {
            return "mutantti";
        }
    }
}
