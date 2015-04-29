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
        this.miinojenluoja = new Miinojenluoja();
        this.ruutu = new Ruutu(new JButton());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testaaRuudukko() {
    }
}
