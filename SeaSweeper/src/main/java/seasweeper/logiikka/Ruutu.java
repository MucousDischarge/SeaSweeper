package seasweeper.logiikka;

import javax.swing.JButton;

/**
 * K
 * @author ez
 */
public class Ruutu {
    private boolean onkoMiina;
    private boolean onkoRaivattu;
    private boolean onkoLippu;
    
    /**
     *
     * @param nappi
     */
    public Ruutu(JButton nappi) {
        this.onkoMiina = false;
        this.onkoRaivattu = false;
        this.onkoLippu = false;
    }
    
    /**
     *
     */
    public void laitaMiina() {
        this.onkoMiina = true;
    }
    
    /**
     *
     * @return
     */
    public boolean onkoMiina() {
        return this.onkoMiina;
    }
    
    /**
     *
     * @return 
     */
    public boolean onkoRaivattu() {
        return onkoRaivattu;
    }
    
    /**
     *
     */
    public void onRaivattu() {
        onkoRaivattu = true;
    }
    
    /**
     *
     * @return
     */
    public boolean onkoLippu() {
        return onkoLippu;
    }
    
    /**
     *
     */
    public void lisaaLippu() {
        onkoLippu = true;
    }
    
    /**
     *
     */
    public void poistaLippu() {
        onkoLippu = false;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
}
