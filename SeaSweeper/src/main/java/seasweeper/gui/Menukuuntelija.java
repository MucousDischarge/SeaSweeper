package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
                IOOngelma(8, 8);
                break;
            case "Keskitaso":
                IOOngelma(16, 16);
                break;
            case "Vaikea":
                IOOngelma(16, 30);
                break;
            default:
                ylempilogiikka.resetUusiRuudukko();
                break;
        }

    }

    public void ikkunanLuonti(int a, int b) throws IOException {
        this.ikkuna = ylempilogiikka.getIkkuna();
        ikkuna.getFraami().dispose();
        ylempilogiikka.uusiIkkuna(true, a, b);
    }
    
    public void IOOngelma(int a, int b) {
        try {
                ikkunanLuonti(a, b);
            } catch (IOException ex) {
                Logger.getLogger(Menukuuntelija.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    

    // TESTEJÄ VARTEN OLEVAT METODIT
}
