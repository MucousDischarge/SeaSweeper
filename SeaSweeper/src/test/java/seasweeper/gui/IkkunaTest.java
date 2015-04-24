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
        this.alempilogiikka = new AlempiLogiikka(new Ruutu[16][16], 16, 16);
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
        this.ikkuna = new Ikkuna("Helppo", alempilogiikka);
        int luku = ikkuna.getK();
        assertEquals(8, luku);
    }
    
    @Test
    public void testHelppoL() {
        this.ikkuna = new Ikkuna("Helppo", alempilogiikka);
        int luku = ikkuna.getL();
        assertEquals(8, luku);
    }
    
    @Test
    public void testKeskitasoK() {
        this.ikkuna = new Ikkuna("Keskitaso", alempilogiikka);
        int luku = ikkuna.getK();
        assertEquals(16, luku);
    }
    
    @Test
    public void testKeskitasoL() {
        this.ikkuna = new Ikkuna("Keskitaso", alempilogiikka);
        int luku = ikkuna.getL();
        assertEquals(16, luku);
    }
    
    @Test
    public void testVaikeaK() {
        this.ikkuna = new Ikkuna("Vaikea", alempilogiikka);
        int luku = ikkuna.getK();
        assertEquals(16, luku);
    }
    
    @Test
    public void testVaikeaL() {
        this.ikkuna = new Ikkuna("Vaikea", alempilogiikka);
        int luku = ikkuna.getL();
        assertEquals(30, luku);
    }
    
    @Test
    public void testJFraamiTitle() {
        this.ikkuna = new Ikkuna("Vaikea", alempilogiikka);
        JFrame jfraami = ikkuna.getJFraami();
        assertEquals("SeaSweeper", jfraami.getTitle());
    }
    
}
