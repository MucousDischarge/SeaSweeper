package seasweeper.logiikka;

import javax.swing.JButton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ez
 */
public class RuutuTest {
    private Ruutu ruutu;

    /**
     *
     */
    public RuutuTest() {
        this.ruutu = new Ruutu(new JButton());
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Test
    public void onkoKoskematonMiina() {
        assertEquals(false, ruutu.onkoMiina());
    }
    
    /**
     *
     */
    @Test
    public void onkoKoskematonRaivattu() {
        assertEquals(false, ruutu.onkoRaivattu());
    }
    
    /**
     *
     */
    @Test
    public void onkoKoskematonLippu() {
        assertEquals(false, ruutu.onkoLippu());
    }
    
    /**
     *
     */
    @Test
    public void onkoMiinoitettuMiina() {
        ruutu.laitaMiina();
        assertEquals(true, ruutu.onkoMiina());
    }
    
    /**
     *
     */
    @Test
    public void onkoRaivattuRaivattu() {
        ruutu.onRaivattu();
        assertEquals(true, ruutu.onkoRaivattu());
    }
    
    /**
     *
     */
    @Test
    public void onkoLiputettuLipullinen() {
        ruutu.lisaaLippu();
        assertEquals(true, ruutu.onkoLippu());
    }
    
}
