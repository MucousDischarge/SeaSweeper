package seasweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seasweeper.logiikka.Napinpainallus;

/**
 *
 * Luokka suorittaa pelinappuloiden kuuntelun
 */
public class Lautakuuntelija implements MouseListener {

    private final Napinpainallus napinpainallus;

    /**
     *
     * @param napinpainallus
     */
    public Lautakuuntelija(Napinpainallus napinpainallus) {
        this.napinpainallus = napinpainallus;
    }

    /**
     *
     * @param me
     */
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

    /**
     *
     * @param object
     * @param kumpi
     */
    public void tryCatchi(Object object, boolean kumpi) {
        try {
            napinpainallus.napinpainallus(object, kumpi);
        } catch (IOException ex) {
            Logger.getLogger(Lautakuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {

    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {

    }

}
