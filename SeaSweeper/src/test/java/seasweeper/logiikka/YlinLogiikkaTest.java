package seasweeper.logiikka;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import seasweeper.gui.Ikkuna;

/**
 *
 * @author ez
 */
public class YlinLogiikkaTest {
    private YlinLogiikka ylinlogiikka;
    private Ikkuna ikkuna;
    /**
     *
     */
    public YlinLogiikkaTest() throws IOException, URISyntaxException {
        this.ylinlogiikka = new YlinLogiikka();
        this.ikkuna = ylinlogiikka.uusiIkkuna(true, 16, 16);
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
     * Test of uusiIkkuna method, of class YlinLogiikka.
     */
    @Test
    public void testUusiIkkuna() throws Exception {
        if (!(ylinlogiikka.uusiIkkuna(true, 16, 16) instanceof Ikkuna)) {
            fail();
        }
    }

    /**
     * Test of resetUusiRuudukko method, of class YlinLogiikka.
     */
    @Test
    public void testResetUusiRuudukko() {
        
    }

    /**
     * Test of ikkunaDispose method, of class YlinLogiikka.
     */
    @Test
    public void testIkkunaDispose() {
        ylinlogiikka.ikkunaDispose();
    }

    /**
     * Test of startKello method, of class YlinLogiikka.
     */
    @Test
    public void testStartKello() {
        
    }

    /**
     * Test of rajahti method, of class YlinLogiikka.
     */
    @Test
    public void testRajahti() {
        
    }

    /**
     * Test of voitit method, of class YlinLogiikka.
     */
    @Test
    public void testVoitit() throws Exception {
        
    }

    /**
     * Test of highscoreIkkuna method, of class YlinLogiikka.
     */
    @Test
    public void testHighscoreIkkuna() {
        
    }

    /**
     * Test of paivitaAika method, of class YlinLogiikka.
     * @throws java.lang.Exception
     */
    @Test
    public void testPaivitaAika() throws Exception {
        
    }
}
