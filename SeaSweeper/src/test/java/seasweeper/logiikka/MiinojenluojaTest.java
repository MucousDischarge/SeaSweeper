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
        this.ruutu = new Ruutu(new JButton(), ylinlogiikka.getIkkuna());
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
    public void testaaRuudukko() {
    }
}
