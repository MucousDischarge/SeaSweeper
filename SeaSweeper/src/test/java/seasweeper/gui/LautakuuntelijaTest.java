package seasweeper.gui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.AlempiLogiikka;
import seasweeper.logiikka.Ruutu;

/**
 *
 * @author ez
 */
public class LautakuuntelijaTest {

    private Robot robotti;
    private JButton nappi;
    private AlempiLogiikka alempilogiikka;
    private Lautakuuntelija lautakuuntelija;

    public LautakuuntelijaTest() throws AWTException {
        this.robotti = new Robot();
        this.alempilogiikka = new AlempiLogiikka(new Ruutu[16][16], 16, 16);
        this.lautakuuntelija = new Lautakuuntelija(alempilogiikka);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testLeftClick() {
        this.nappi = new JButton();
        nappi.addMouseListener(lautakuuntelija);
        nappi.doClick();
        assertEquals(false, alempilogiikka.getOnkoEnsimmainenKlikkaus());
    }
    
    @Test
    public void testRightClick() {
        
    }

    public void leftClick() {
        robotti.mousePress(InputEvent.BUTTON1_MASK);
        robotti.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
