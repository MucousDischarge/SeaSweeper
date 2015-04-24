package seasweeper.logiikka;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ez
 */
public class YlempiLogiikkaTest {
    private YlempiLogiikka ylempilogiikka;
    public YlempiLogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testaaVaikeustasoString() {
        this.ylempilogiikka = new YlempiLogiikka("Vaikea");
        assertEquals("Vaikea", ylempilogiikka.getVaikeustaso());
    }
    
    @Test
    public void testK() {
        this.ylempilogiikka = new YlempiLogiikka("Vaikea");
        assertEquals(16, ylempilogiikka.getK());
    }
    
    @Test
    public void testL() {
        this.ylempilogiikka = new YlempiLogiikka("Vaikea");
        assertEquals(30, ylempilogiikka.getL());
    }
}
