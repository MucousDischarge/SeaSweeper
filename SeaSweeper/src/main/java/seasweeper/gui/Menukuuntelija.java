package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seasweeper.logiikka.YlempiLogiikka;

/**
 *
 * @author ez
 */
public class Menukuuntelija implements ActionListener {

    private final YlempiLogiikka ylempilogiikka;
    private Ikkuna ikkuna;

    public Menukuuntelija(YlempiLogiikka ylempilogiikka) {
        this.ylempilogiikka = ylempilogiikka;
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
                ylempilogiikka.highscoreIkkuna();
                break;
            default:
                ylempilogiikka.resetUusiRuudukko();
                break;
        }

    }

    public void ikkunanLuonti(int a, int b) throws IOException, URISyntaxException {
        this.ikkuna = ylempilogiikka.getIkkuna();
        ikkuna.getFraami().dispose();
        ylempilogiikka.uusiIkkuna(true, a, b);
    }

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
