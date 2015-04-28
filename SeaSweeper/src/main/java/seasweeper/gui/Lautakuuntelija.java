package seasweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import seasweeper.logiikka.AlempiLogiikka;

/**
 *
 * @author ez
 */

/**
 * 
 * Luokka suorittaa graafisen pelilaudan kuuntelun
 */
public class Lautakuuntelija implements MouseListener {

    private AlempiLogiikka alempilogiikka;
    

    /**
     *
     * @param alempilogiikka
     */
    
    public Lautakuuntelija(AlempiLogiikka alempilogiikka) {
        this.alempilogiikka = alempilogiikka;
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
            alempilogiikka.napinpainallus(me.getSource(), false);
        }
        
        if (me.getButton() == MouseEvent.BUTTON3) {
            alempilogiikka.napinpainallus(me.getSource(), true);
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