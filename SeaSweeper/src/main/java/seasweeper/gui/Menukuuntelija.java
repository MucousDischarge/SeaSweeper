package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seasweeper.logiikka.YlinLogiikka;

/**
 *
 * Kuuntelee yllä olevia menunappeja
 */
public class Menukuuntelija implements ActionListener {

    private final YlinLogiikka ylinlogiikka;

    /**
     *
     * @param ylinlogiikka
     */
    public Menukuuntelija(YlinLogiikka ylinlogiikka) {
        this.ylinlogiikka = ylinlogiikka;
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Helppo":
                ongelma(8, 8);
                break;
            case "Keskitaso":
                ongelma(16, 16);
                break;
            case "Vaikea":
                ongelma(16, 30);
                break;
            case "HighScore":
                ylinlogiikka.highscoreIkkuna();
                break;
            default:
                ylinlogiikka.resetUusiRuudukko();
                break;
        }

    }

    /**
     *
     * @param a
     * @param b
     * @throws IOException
     * @throws URISyntaxException
     */
    public void ikkunanLuonti(int a, int b) throws IOException, URISyntaxException {
        ylinlogiikka.ikkunaDispose();
        ylinlogiikka.uusiIkkuna(a, b);
    }

    /**
     *
     * @param a
     * @param b
     */
    public void ongelma(int a, int b) {

        try {
            try {
                ikkunanLuonti(a, b);
            } catch (IOException ex) {
                Logger.getLogger(Menukuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(Menukuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
}
