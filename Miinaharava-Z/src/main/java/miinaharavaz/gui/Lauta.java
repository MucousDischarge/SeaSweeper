/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.gui;

/**
 * Luokka suorittaa pelilaudan ja sen kuuntelun
 * (ja todennäköisesti myös kutsuu pelilogiikan henkiin)
 */
import miinaharavaz.logiikka.Ruutu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lauta extends JFrame {
    final JButton napisto[][];
    final int k = 16;
    
    /**
     * Metodi luo graafisen laudan kutsuttuna mainista
     * (ja todennäköisesti suorittaa pelilogiikat)
     */
    
    public Lauta() {
  
        this.setLayout(new GridLayout(k,k));
        napisto = new JButton[k][k];
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < k; b++) {
                napisto[a][b] = new JButton();
                napisto[a][b].addActionListener(new Lautakuuntelija());
                add(napisto[a][b]);
            }
        }
        setTitle("Miinaharava-Z");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    /**
     * Luokka suorittaa graafisen pelilaudan kuuntelun
     */
    
    private class Lautakuuntelija implements ActionListener {
        
        /**
        * Metodi suorittaa halutun toiminnon napinpainalluksesta
        * 
        * @param   e   Käyttäjän napin painallus 
        * @return haluttu toiminto
        */
        
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < k; b++) {
                    if (e.getSource() == napisto[a][b]) {
                        if (a <= 8 && b <= 4) {
                            System.out.println("vasen yläkulma");
                        } else if (a <= 8 && b > 8) {
                            System.out.println("oikea yläkulma");
                        } else if (a > 8 && b <= 8) {
                            System.out.println("vasen alakulma");
                        } else {
                            System.out.println("oikea alakulma");
                        }
                    }
                }
            }
        }
    }   
}


