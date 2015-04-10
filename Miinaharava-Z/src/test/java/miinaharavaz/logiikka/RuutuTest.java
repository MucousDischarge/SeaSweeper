/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.logiikka;

import miinaharavaz.logiikka.Ruutu;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ezaalto
 */
public class RuutuTest {
    
    public RuutuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testaaTyhja() {
       Ruutu ruutu = new Ruutu();
       assertEquals("tyhja", ruutu.getSisalto());
    }
    
    @Test
    public void testaaMiina() {
       Ruutu ruutu = new Ruutu();
       ruutu.onMiina();
       assertEquals("miina", ruutu.getSisalto());
    }
    
    @Test
    public void testaaNumero() {
       Ruutu ruutu = new Ruutu();
       ruutu.onNumero();
       assertEquals("numero", ruutu.getSisalto());
    }
}
