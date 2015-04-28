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
public class MiinojenluojaTest {
    private Miinojenluoja miinojenluoja;
    private Ruutu ruutu;
    
    public MiinojenluojaTest() {
        this.miinojenluoja = new Miinojenluoja(new Ruutu[16][16]);
        this.ruutu = new Ruutu(8, 8, new JButton());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testaaHavaitaankoMiinaaton() {
        assertEquals(false, miinojenluoja.onkoRuutuMiina(ruutu));
    }
      
    @Test
    public void testaaHavaitaankoMiina() {
        this.ruutu.laitaMiina();
        assertEquals(true, miinojenluoja.onkoRuutuMiina(ruutu));
    }
    
    @Test
    public void testaaRuudukko() {
        assertEquals(16, miinojenluoja.getRuudukko().length);
    }
}