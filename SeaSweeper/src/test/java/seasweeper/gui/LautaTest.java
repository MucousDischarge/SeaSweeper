/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.gui;

import seasweeper.gui.Lauta;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ezaalto
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LautaTest {
    
    public LautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testTitle() {
        Lauta lauta = new Lauta();
        
        assertEquals("Miinaharava-Z", lauta.getTitle());
    }
    
    @Test
    public void testWidth(){
        Lauta lauta = new Lauta();
        
        assertEquals(400, lauta.getWidth());
    }
    
    @Test
    public void testHeight(){
        Lauta lauta = new Lauta();
        
        assertEquals(400, lauta.getHeight());
    }
    
    // sitten nämä "testit"
    
    @Test
    public void testX() {
        Lauta lauta = new Lauta();
        assertEquals(515, lauta.getX());
    }
    
    @Test
    public void testY() {
        Lauta lauta = new Lauta();
        assertEquals(196, lauta.getY());
    }
    
    @Test
    public void testShape() {
        Lauta lauta = new Lauta();
        assertEquals(null, lauta.getShape());
    }
    
    @Test
    public void testParent() {
        Lauta lauta = new Lauta();
        assertEquals(null, lauta.getParent());
    }
}
