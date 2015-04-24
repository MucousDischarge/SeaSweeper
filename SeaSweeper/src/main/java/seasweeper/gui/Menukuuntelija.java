package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import seasweeper.logiikka.YlempiLogiikka;

/**
 *
 * @author ez
 */
public class Menukuuntelija implements ActionListener {
    private final JFrame jfraami;
    private final String vaikeustaso;
    
    public Menukuuntelija(JFrame jfraami, String vaikeustaso) {
        this.jfraami = jfraami;
        this.vaikeustaso = vaikeustaso;
    }
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        jfraami.dispose();
        
        switch (e.getActionCommand()) {
            case "Helppo":
                YlempiLogiikka lauta1 = new YlempiLogiikka("Helppo");
                break;
            case "Keskitaso":
                YlempiLogiikka lauta2 = new YlempiLogiikka("Keskitaso");
                break;
            case "Vaikea":
                YlempiLogiikka lauta3 = new YlempiLogiikka("Vaikea");
                break;
            default:
                YlempiLogiikka lauta4 = new YlempiLogiikka(vaikeustaso);
                break;
        }

    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    
    public String getVaikeustaso() {
        return vaikeustaso;
    }
    
}