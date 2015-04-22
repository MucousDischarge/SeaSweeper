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
 * @author ez
 */
public class Menukuuntelija implements ActionListener {
    private final JFrame jfraami;
    private final String vaikeustaso;
    
    public Menukuuntelija(JFrame jfraami, String vaikeustaso) {
        this.jfraami = jfraami;
        this.vaikeustaso = vaikeustaso;
    }
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        jfraami.dispose();
        
        switch (e.getActionCommand()) {
            case "Helppo":
                Lauta lauta1 = new Lauta("Helppo");
                break;
            case "Keskitaso":
                Lauta lauta2 = new Lauta("Keskitaso");
                break;
            case "Vaikea":
                Lauta lauta3 = new Lauta("Vaikea");
                break;
            default:
                Lauta lauta4 = new Lauta(vaikeustaso);
                break;
        }

    }
    
}
