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
public class AlempiLogiikkaTest {
    private AlempiLogiikka alempilogiikka;
    
    public AlempiLogiikkaTest() {
        this.alempilogiikka = new AlempiLogiikka(new Ruutu[8][8], 8, 8);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void getNapisto() {
        assertEquals(8, alempilogiikka.getNapisto().length);
    }
    
    @Test
    public void eiOllaPainettuViela() {
        assertEquals(true, alempilogiikka.getOnkoEnsimmainenKlikkaus());
    }
    
    //@Test
    //public void ensimmainenPainallus() {
    //    alempilogiikka.napinpainallus(alempilogiikka.getNapisto()[6][6], false);
    //    assertEquals(false, alempilogiikka.getOnkoEnsimmainenKlikkaus());
    //}
    
    @Test
    public void testaaK() {
      assertEquals(8, alempilogiikka.getK());  
    }
    
    @Test
    public void testaaL() {
        assertEquals(8, alempilogiikka.getL()); 
    }
    
    @Test
    public void onkoPeliPaattynytEnnenaikaisesti() {
        assertEquals(false, alempilogiikka.getPeliPaattynyt()); 
    }
}
