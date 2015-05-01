package seasweeper.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * Pelikello, joka hoitaa näkyvän kellon toiminnot
 */
public class Kello {

    private final Ikkuna ikkuna;
    private long alkuaika;
    private boolean ekako;
    private int aikaSekunneissa;
    private Timer ajastin;

    /**
     *
     * @param ikkuna
     */
    public Kello(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
        this.aikaSekunneissa = 0;
    }

    /**
     *
     */
    public void aikaTimer() {
        ActionListener aikaKuuntelija = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    aikaSekunneissa++;
                    ikkuna.paivitaAika(aika());
                } catch (IOException ex) {
                    Logger.getLogger(Kello.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        ajastin = new Timer(1000, aikaKuuntelija);
        ajastin.start();
    }

    /**
     *
     * @return
     */
    public String aika() {
        int intMinuutit = aikaSekunneissa / 60;
        boolean taysi = false;
        String stringMinuutit;
        String stringSekunnit;
        if (intMinuutit < 10) {
            stringMinuutit = "0" + intMinuutit;
        } else if (intMinuutit > 60) {
            stringMinuutit = "60";
            taysi = true;
        } else {
            stringMinuutit = Integer.toString(intMinuutit);
        }
        int intSekunnit = aikaSekunneissa % 60;
        if (taysi) {
            stringSekunnit = "00";
        } else if (intSekunnit < 10) {
            stringSekunnit = "0" + intSekunnit;
        } else {
            stringSekunnit = Integer.toString(intSekunnit);
        }
        return stringMinuutit + ":" + stringSekunnit;
    }
    
    /**
     *
     * @return
     */
    public String peliPaattyi() {
        ajastin.stop();
        return aika();
    }
    
    /**
     *
     */
    public void nollaaAika() {
        ajastin.stop();
        aikaSekunneissa = 0;
    }

}
