/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.miinaharava.z;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.awt.*;
import java.awt.event.InputEvent;

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
    public void testToimiiko() {
        Lauta lauta = new Lauta();
        try {
        Robot robotti = new Robot();
        robotti.mouseMove(600,400);
        robotti.mousePress(InputEvent.BUTTON1_MASK);
        robotti.delay(200);
        robotti.mouseRelease(InputEvent.BUTTON1_MASK);
        robotti.delay(200);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        String s = lauta.testiruutu.getSisalto();
        
        assertTrue(s == "tyhja");
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
    
    @Test
    public void testRuudunMitta() {
        Lauta lauta = new Lauta();
        assertEquals(16, lauta.k);
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
