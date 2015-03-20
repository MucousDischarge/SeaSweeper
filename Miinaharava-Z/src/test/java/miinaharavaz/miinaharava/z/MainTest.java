/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.miinaharava.z;

import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ezaalto
 */
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testRuudunMitta() {
        Main n = new Main();
        assertEquals(16, n.r);
    }
    
    @Test
    public void testKokoMitta() {
        Main n = new Main();
        assertEquals(400, n.k);
    }
    
    @Test
    public void testTitle() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        
        assertEquals("Miinaharava-Z", raami.getTitle());
    }
    
    @Test
    public void testWidth(){
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        
        assertEquals(400, raami.getWidth());
    }
    @Test
    public void testHeight() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.setSize(400,400);
        
        assertEquals(400, raami.getHeight());
    }
    
    @Test
    public void testX() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
  
        assertEquals(515, raami.getX());
    }
    
    @Test
    public void testY() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
  
        assertEquals(196, raami.getY());
    }
    
    @Test
    public void testY2() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
        assertEquals(null, raami.getShape());
    }
    
    @Test
    public void testName() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
        assertEquals("frame0", raami.getName());
    }
    
    @Test
    public void testParent() {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
        assertEquals(null, raami.getParent());
    }
    
    
    
}
