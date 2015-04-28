package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import seasweeper.logiikka.YlempiLogiikka;

/**
 *
 * @author ez
 */
public class Menukuuntelija implements ActionListener {

    private YlempiLogiikka ylempilogiikka;
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
                ikkunanLuonti(8, 8);
                break;
            case "Keskitaso":
                ikkunanLuonti(16, 16);
                break;
            case "Vaikea":
                ikkunanLuonti(16, 30);
                break;
            default:
                ylempilogiikka.uusiRuudukko();
                break;
        }

    }

    public void ikkunanLuonti(int a, int b) {
        this.ikkuna = ylempilogiikka.getIkkuna();
        ikkuna.getFraami().dispose();
        ylempilogiikka.uusiIkkuna(true, a, b);
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
}
