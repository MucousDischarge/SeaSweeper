/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seasweeper.logiikka.Peruslogiikka;

/**
 * Luokka suorittaa graafisen pelilaudan kuuntelun
 */
public class Lautakuuntelija implements MouseListener {

    Peruslogiikka peruslogiikka;

    /**
     *
     * @param peruslogiikka
     */
    public Lautakuuntelija(Peruslogiikka peruslogiikka) {
        this.peruslogiikka = peruslogiikka;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       
    }
    
    /**
     * Metodi suorittaa halutun toiminnon napinpainalluksesta
     *
     * @param me
     */

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            peruslogiikka.napinpainallus(me.getSource(), false);
        }
        
        if (me.getButton() == MouseEvent.BUTTON3) {
            peruslogiikka.napinpainallus(me.getSource(), true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

}
