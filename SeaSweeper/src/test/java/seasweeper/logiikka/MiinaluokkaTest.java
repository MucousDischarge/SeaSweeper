/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.logiikka;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ez
 */
public class MiinaluokkaTest {
    Miinaluokka miinaluokka;
    public MiinaluokkaTest() {
        this.miinaluokka = new Miinaluokka(16);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of onkoMiina method, of class Miinaluokka.
     */
    @Test
    public void testOnkoMiinaNolla() {
        assertTrue(miinaluokka.onkoMiina(0, 0, 40));
    }
    
    @Test
    public void testOnkoMiinaYksiOmituisellaMiinamaaralla() {
        assertFalse(miinaluokka.onkoMiina(1, 1, 16));
    }

    /**
     * Test of satunnainenLukuValilta method, of class Miinaluokka.
     */
    @Test
    public void testSatunnainenLukuValilta0() {
        System.out.println("satunnainenLukuValilta");
        int minimi = 0;
        int maksimi = 0;
        int expResult = 0;
        int result = Miinaluokka.satunnainenLukuValilta(minimi, maksimi);
        assertEquals(expResult, result);
    }
    
}
