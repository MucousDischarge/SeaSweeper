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
public class RuutuTest {
    private Ruutu ruutu;
    private YlinLogiikka ylinlogiikka;

    /**
     *
     */
    public RuutuTest() throws IOException, URISyntaxException {
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
    public void onkoKoskematonMiina() {
        assertEquals(false, ruutu.onkoMiina());
    }
    
    /**
     *
     */
    @Test
    public void onkoKoskematonRaivattu() {
        assertEquals(false, ruutu.onkoRaivattu());
    }
    
    /**
     *
     */
    @Test
    public void onkoKoskematonLippu() {
        assertEquals(false, ruutu.onkoLippu());
    }
    
    /**
     *
     */
    @Test
    public void onkoMiinoitettuMiina() {
        ruutu.laitaMiina();
        assertEquals(true, ruutu.onkoMiina());
    }
    
    /**
     *
     */
    @Test
    public void onkoRaivattuRaivattu() {
        ruutu.onRaivattu();
        assertEquals(true, ruutu.onkoRaivattu());
    }
    
    /**
     *
     */
    @Test
    public void onkoLiputettuLipullinen() {
        ruutu.lisaaLippu();
        assertEquals(true, ruutu.onkoLippu());
    }
    
}
