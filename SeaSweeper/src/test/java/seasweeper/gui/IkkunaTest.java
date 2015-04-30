package seasweeper.gui;

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.AlempiLogiikka;
import seasweeper.logiikka.Ruutu;
import seasweeper.logiikka.YlempiLogiikka;

/**
 *
 * @author ezaalto
 */
public class IkkunaTest {
    private Ikkuna ikkuna;
    
    public IkkunaTest() throws IOException {
        
        ikkuna = new Ikkuna(new Menukuuntelija(new YlempiLogiikka()), new Lautakuuntelija(new AlempiLogiikka(new YlempiLogiikka())), 8, 8);
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
