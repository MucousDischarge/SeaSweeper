package seasweeper.logiikka;

import java.io.IOException;
import java.net.URISyntaxException;
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
    private YlinLogiikka ylinlogiikka;
    private Ruutu ruutu;
    
    /**
     *
     */
    public MiinojenluojaTest() throws IOException, URISyntaxException {
        this.miinojenluoja = new Miinojenluoja();
        this.ylinlogiikka = new YlinLogiikka();
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

    @Test
    public void testLuoMiinat() {
        int a = 0;
        int b = 0;
        Miinojenluoja instance = new Miinojenluoja();
        instance.luoMiinat(a, b);
    }

    @Test
    public void testSetRuudukko() {
        Ruutu[][] ruudukko = null;
        int miinojenmaara = 0;
        Miinojenluoja instance = new Miinojenluoja();
        instance.setRuudukko(ruudukko, miinojenmaara);
    }
}
