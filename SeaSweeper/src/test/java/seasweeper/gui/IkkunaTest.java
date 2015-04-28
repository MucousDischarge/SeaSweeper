package seasweeper.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.AlempiLogiikka;
import seasweeper.logiikka.Ruutu;

/**
 *
 * @author ezaalto
 */
public class IkkunaTest {
    private Ikkuna ikkuna;
    private AlempiLogiikka alempilogiikka;
    
    public IkkunaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of luoNappi method, of class Ikkuna.
     */
    @Test
    public void testLuoNappi() {
    }
    
    @Test
    public void testHelppoK() {
    }
    
    @Test
    public void testHelppoL() {
    }
    
    @Test
    public void testKeskitasoK() {
    }
    
    @Test
    public void testKeskitasoL() {
    }
    
    @Test
    public void testVaikeaK() {
    }
    
    @Test
    public void testVaikeaL() {
    }
    
    @Test
    public void testJFraamiTitle() {
        JFrame jfraami = ikkuna.getFraami();
        assertEquals("SeaSweeper", jfraami.getTitle());
    }
    
}
