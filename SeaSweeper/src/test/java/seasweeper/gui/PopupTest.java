package seasweeper.gui;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.HighScore;
import seasweeper.logiikka.Kello;
import seasweeper.logiikka.YlinLogiikka;

/**
 *
 * @author ez
 */
public class PopupTest {
    private YlinLogiikka ylinlogiikka;
    private Kello kello;
    private HighScore keskitasotaulu;
    private HighScore vaikeataulu;
    private Kuvaluokka kuvaluokka;
    private int l;

    public PopupTest() throws IOException, URISyntaxException {
        this.ylinlogiikka = new YlinLogiikka();
        this.kello = new Kello(ylinlogiikka);
        this.keskitasotaulu = new HighScore(false);
        this.vaikeataulu = new HighScore(true);
        this.kuvaluokka = new Kuvaluokka();
        this.l = 16;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of rajahti method, of class Popup.
     */
    @Test
    public void testRajahti() {
    }

    /**
     * Test of voitit method, of class Popup.
     */
    @Test
    public void testVoitit() throws Exception {
    }

    /**
     * Test of highscore method, of class Popup.
     */
    @Test
    public void testHighscore() {
    }

    /**
     * Test of setArvot method, of class Popup.
     */
    @Test
    public void testSetArvot() {
    }

}
