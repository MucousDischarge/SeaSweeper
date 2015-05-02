package seasweeper.gui;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.Napinpainallus;
import seasweeper.logiikka.HighScore;
import seasweeper.logiikka.Kello;
import seasweeper.logiikka.YlinLogiikka;

/**
 *
 * @author ezaalto
 */
public class IkkunaTest {
    private Ikkuna ikkuna;
    private YlinLogiikka ylempilogiikka;
    
    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public IkkunaTest() throws IOException, URISyntaxException {
        this.ylempilogiikka = new YlinLogiikka();
        ikkuna = new Ikkuna(new Menukuuntelija(ylempilogiikka), new Lautakuuntelija(new Napinpainallus(ylempilogiikka)), 8, 8, new HighScore(false), new HighScore(true), new Kello(ylempilogiikka));
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
     * Test of luoNappi method, of class Ikkuna.
     */
    @Test
    public void testLuoNappi() {
    }
    
    /**
     *
     */
    @Test
    public void testHelppoK() {
    }
    
    /**
     *
     */
    @Test
    public void testHelppoL() {
    }
    
    /**
     *
     */
    @Test
    public void testKeskitasoK() {
    }
    
    /**
     *
     */
    @Test
    public void testKeskitasoL() {
    }
    
    /**
     *
     */
    @Test
    public void testVaikeaK() {
    }
    
    /**
     *
     */
    @Test
    public void testVaikeaL() {
    }
    
    /**
     *
     */
    @Test
    public void testJFraamiTitle() {
        JFrame jfraami = ikkuna.getFraami();
        assertEquals("SeaSweeper", jfraami.getTitle());
    }
    
}
