/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author ezaalto
 */
public class Menukuuntelija implements ActionListener {
    private JFrame jfraami;
    
    public Menukuuntelija(JFrame jfraami) {
        this.jfraami = jfraami;
    }
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        jfraami.dispose();
        Lauta lauta = new Lauta();
    }
    
}
