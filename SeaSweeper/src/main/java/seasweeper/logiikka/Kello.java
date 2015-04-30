package seasweeper.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import seasweeper.gui.Ikkuna;

/**
 *
 * @author ez
 */
public class Kello {

    private final Ikkuna ikkuna;
    private long alkuaika;
    private boolean ekako;
    private int aikaSekunneissa;
    private Timer ajastin;

    public Kello(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
        this.aikaSekunneissa = 0;
    }

    public void aikaTimer() {
        ActionListener aikaKuuntelija = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                aikaSekunneissa++;
                ikkuna.paivitaAika(aika());
            }
        };
        ajastin = new Timer(1000, aikaKuuntelija);
        ajastin.start();
    }

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
    
    public String peliPaattyi() {
        ajastin.stop();
        return aika();
    }
    
    public void nollaaAika() {
        aikaSekunneissa = 0;
    }

}
