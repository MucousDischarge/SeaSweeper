package seasweeper.logiikka;

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
        this.alempilogiikka = new AlempiLogiikka(new YlempiLogiikka());
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void setNapisto() {
    }
    
    @Test
    public void eiOllaPainettuVielaEiAnnettu() {
        assertEquals(false, alempilogiikka.getOnkoEnsimmainenKlikkaus());
    }
    
    //@Test
    //public void ensimmainenPainallus() {
    //    alempilogiikka.napinpainallus(alempilogiikka.getNapisto()[6][6], false);
    //    assertEquals(false, alempilogiikka.getOnkoEnsimmainenKlikkaus());
    //}
    
    @Test
    public void testaaK() {
    }
    
    @Test
    public void testaaL() {
    }
    
    @Test
    public void onkoPeliPaattynytEnnenaikaisesti() { 
    }
}
