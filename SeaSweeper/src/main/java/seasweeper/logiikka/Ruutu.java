package seasweeper.logiikka;

import javax.swing.JButton;

/**
 *
 * @author ez
 */
public class Ruutu {
    private boolean onkoMiina;
    private boolean onkoRaivattu;
    private boolean onkoLippu;
    private final int k;
    private final int l;
    private final JButton nappi;
    
    public Ruutu(int k, int l, JButton nappi) {
        this.onkoMiina = false;
        this.onkoRaivattu = false;
        this.onkoLippu = false;
        this.k = k;
        this.l = l;
        this.nappi = nappi;
    }
    
    public void laitaMiina() {
        this.onkoMiina = true;
    }
    
    public boolean onkoMiina() {
        return this.onkoMiina;
    }
    
    public boolean onkoRaivattu() {
        return onkoRaivattu;
    }
    
    public void onRaivattu() {
        onkoRaivattu = true;
    }
    
    public boolean onkoLippu() {
        return onkoLippu;
    }
    
    public void lisaaLippu() {
        onkoLippu = true;
    }
    
    public void poistaLippu() {
        onkoLippu = false;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT

    
    public int getK() {
        return this.k;
    }
    
    public int getL() {
        return this.l;
    }
    
    public JButton getNappi() {
        return this.nappi;
    }
}
