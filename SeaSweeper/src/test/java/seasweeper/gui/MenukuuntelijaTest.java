package seasweeper.gui;

import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ez
 */
public class MenukuuntelijaTest {
    private Menukuuntelija menukuuntelija;
    
    public MenukuuntelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testVaikeustasoString() {
        this.menukuuntelija = new Menukuuntelija(new JFrame(), "Vaikea");
        assertEquals("Vaikea", menukuuntelija.getVaikeustaso());
    }
    
}
