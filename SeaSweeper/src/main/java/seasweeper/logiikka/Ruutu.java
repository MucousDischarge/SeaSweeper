package seasweeper.logiikka;

import javax.swing.JButton;

/**
 * Ruutu tietää ominaisuutensa, ja on osa ruudukkoa eli loogista pelilautaa
 */
public class Ruutu {
    private final JButton nappi;
    private boolean onkoMiina;
    private boolean onkoRaivattu;
    private boolean onkoLippu;
    
    /**
     *
     * @param nappi
     */
    public Ruutu(JButton nappi) {
        this.nappi = nappi;
        this.onkoMiina = false;
        this.onkoRaivattu = false;
        this.onkoLippu = false;
    }
    
    public Boolean onkoNappi(Object object) {
        return this.nappi == object;
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
     * @return
     */
    public boolean onkoLippu() {
        return onkoLippu;
    }
    
    /**
     *
     */
    public void laitaMiina() {
        this.onkoMiina = true;
    }
    
    /**
     *
     */
    public void onRaivattu() {
        onkoRaivattu = true;
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
