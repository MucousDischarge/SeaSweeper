package seasweeper.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seasweeper.logiikka.Napinpainallus;

/**
 *
 * Luokka suorittaa pelinappuloiden kuuntelun.
 */
public class Lautakuuntelija implements MouseListener {

    private final Napinpainallus napinpainallus;

    /**
     * Konstruktorissa annetaan yhteys napinpainallusluokkaan.
     * 
     * @param napinpainallus Napinpainallusluokka.
     */
    public Lautakuuntelija(Napinpainallus napinpainallus) {
        this.napinpainallus = napinpainallus;
    }

    /**
     * Käyttämätön metodi.
     * 
     * @param me 
     */
    @Override
    public void mouseClicked(MouseEvent me) {

    }

    /**
     * Laudan nappia klikatessa tämä herää henkiin, joka välittää tiedon klikatusta JButtonista
     * sekä hiirenpainikkeesta napinpainallusluokalle.
     *
     * @param me Hiirenklikkaustapahtuma, jonka tiedoissa lukee klikattu nappi ja hiirenpainike.
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
     * Siivoojametodi trycatch-sokkeloille.
     * 
     * @param object Klikattu JButton.
     * @param kumpi Painettu hiirenpainike.
     */
    public void tryCatchi(Object object, boolean kumpi) {
        try {
            napinpainallus.napinpainallus(object, kumpi);
        } catch (IOException ex) {
            Logger.getLogger(Lautakuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Käyttämätön metodi.
     * 
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {

    }

    /**
     * Käyttämätön metodi.
     * 
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {

    }

    /**
     * Käyttämätön metodi.
     * 
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {

    }

}
