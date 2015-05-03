package seasweeper.gui;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JButton;
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
    private YlinLogiikka ylinlogiikka;
    
    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public IkkunaTest() throws IOException, URISyntaxException {
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
}
