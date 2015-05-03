package seasweeper.logiikka;

import javax.swing.JButton;
import seasweeper.gui.Ikkuna;

/**
 * Ruutu tietää ominaisuutensa, ja on osa ruudukkoa eli loogista pelilautaa.
 */
public class Ruutu {
    private final JButton nappi;
    private final Ikkuna ikkuna;
    private boolean onkoMiina;
    private boolean onkoRaivattu;
    private boolean onkoLippu;
    
    /**
     * Konstruktorin yhteydessä ruudulle annetaan tieto omasta JButtonistaan
     * ja yhteys ikkunaan.
     * 
     * @param nappi Ruudun oma JButton.
     * @param ikkuna Yhteys ikkunaluokkaan.
     */
    public Ruutu(JButton nappi, Ikkuna ikkuna) {
        this.nappi = nappi;
        this.ikkuna = ikkuna;
        this.onkoMiina = false;
        this.onkoRaivattu = false;
        this.onkoLippu = false;
    }
    
    /**
     * Kahden nappiviittauksen pääteaseman vertailulle, eli tarkistetaan
     * muissa luokissa onko jokin nappi sama kuin tämän ruudun nappi.
     * 
     * @param object Vertailtava nappi.
     * @return Ovatko sama nappi.
     */
    public Boolean onkoNappi(Object object) {
        return this.nappi == object;
    }
    
    /**
     * Yksinkertainen kysely siitä onko tämä ruutu miinoitettu vai ei.
     * 
     * @return Onko miina vai ei.
     */
    public boolean onkoMiina() {
        return this.onkoMiina;
    }
    
    /**
     * Yksinkertainen kysely siitä onko tämä ruutu raivattu vai ei.
     * 
     * @return Onko raivattu vai ei.
     */
    public boolean onkoRaivattu() {
        return onkoRaivattu;
    }
    
    /**
     * Yksinkertainen kysely siitä onko tämä ruutu liputettu vai ei.
     * 
     * @return Onko liputettu vai ei.
     */
    public boolean onkoLippu() {
        return onkoLippu;
    }
    
    /**
     * Yksinkertainen käsky siitä, että ruutu on nyt miinoitettu.
     */
    public void laitaMiina() {
        this.onkoMiina = true;
    }
    
    /**
     * Yksinkertainen käsky siitä, että ruutu on nyt raivattu.
     */
    public void onRaivattu() {
        onkoRaivattu = true;
    }
    
    /**
     * Yksinkertainen käsky siitä, että ruutu on nyt liputettu.
     */
    public void lisaaLippu() {
        onkoLippu = true;
    }
    
    /**
     * Yksinkertainen käsky siitä, että lippu poistetaan.
     */
    public void poistaLippu() {
        onkoLippu = false;
    }
    
    /**
     * Ruudulle pistetään uusi kuva, ja se tekee tämän viittauksella ikkunaluokan
     * kuvametodiin.
     * 
     * @param kuva Haluttu kuva.
     */
    public void kuva(String kuva) {
        ikkuna.kuva(this.nappi, kuva);
    }
}
