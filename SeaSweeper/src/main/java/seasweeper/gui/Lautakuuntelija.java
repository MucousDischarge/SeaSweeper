package seasweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private final AlempiLogiikka alempilogiikka;

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
            tryCatchi(me.getSource(), false);
        }

        if (me.getButton() == MouseEvent.BUTTON3) {
            tryCatchi(me.getSource(), true);
        }
    }

    public void tryCatchi(Object object, boolean kumpi) {
        try {
            alempilogiikka.napinpainallus(object, kumpi);
        } catch (IOException ex) {
            Logger.getLogger(Lautakuuntelija.class.getName()).log(Level.SEVERE, null, ex);
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
