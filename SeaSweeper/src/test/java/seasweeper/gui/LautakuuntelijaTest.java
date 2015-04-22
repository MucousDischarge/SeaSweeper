/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.gui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import seasweeper.logiikka.Peruslogiikka;

/**
 *
 * @author ez
 */
public class LautakuuntelijaTest {

    final JButton napisto[][];
    private int k;
    private int l;
    private final Peruslogiikka peruslogiikka;
    private final ImageIcon kuvat[];
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;
    private Lautakuuntelija lautakuuntelija;
    Robot robotti;

    public LautakuuntelijaTest() throws AWTException {
        this.robotti = new Robot();
        this.napisto = new JButton[k][l];
        kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/" + i + ".png");
        }

        this.miina = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/miina.png");

        this.lippu = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/lippu.png");

        this.tummavesi = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/tummavesi.png");

        this.peruslogiikka = new Peruslogiikka(k, l, napisto, miina, lippu, tummavesi, kuvat);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of mousePressed method, of class Lautakuuntelija.
     */
    @Test
    public void testMousePressed() {
        robotti.keyPress(MouseEvent.BUTTON1);
        System.out.println("mousePressed");
    }

}
