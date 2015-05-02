package seasweeper.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import seasweeper.gui.Ikkuna;

/**
 *
 * Pelikello, joka hoitaa näkyvän kellon toiminnot
 */
public class Kello {

    private final YlinLogiikka ylinlogiikka;
    private long alkuaika;
    private boolean ekako;
    private int aikaSekunneissa;
    private Timer ajastin;

    /**
     *
     * @param ylinlogiikka
     */
    public Kello(YlinLogiikka ylinlogiikka) {
        this.ylinlogiikka = ylinlogiikka;
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
                    ylinlogiikka.paivitaAika(aika());
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
        String stringMinuutit;
        String stringSekunnit;
        
        if (aikaSekunneissa / 60 > 60)   {
            stringMinuutit = "60";
        } else {
            stringMinuutit = aikaSiistija(aikaSekunneissa / 60);
        }

        if (stringMinuutit.equals("60")) {
            stringSekunnit = "00";
        } else {
            stringSekunnit = aikaSiistija(aikaSekunneissa % 60);
        }
        return stringMinuutit + ":" + stringSekunnit;
    }

    public String aikaSiistija(int puolikas) {
        if (puolikas < 10) {
            return "0" + puolikas;
        } else {
            return Integer.toString(puolikas);
        }
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
