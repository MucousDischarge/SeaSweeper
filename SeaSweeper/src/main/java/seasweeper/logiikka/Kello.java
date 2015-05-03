package seasweeper.logiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
/**
 *
 * Pelikello, joka hoitaa näkyvän kellon toiminnot.
 */
public class Kello {

    private final YlinLogiikka ylinlogiikka;
    private long alkuaika;
    private boolean ekako;
    private int aikaSekunneissa;
    private Timer ajastin;

    /**
     * Konstruktorissa annetaan viittaus ylimpään logiikkaan.
     * 
     * @param ylinlogiikka Ylimmän logiikan luokka.
     */
    public Kello(YlinLogiikka ylinlogiikka) {
        this.ylinlogiikka = ylinlogiikka;
        this.aikaSekunneissa = 0;
    }

    /**
     * Itse kello, joka joka sekunti antaa päivitetyn aikatekstin ylimmän logiikan
     * kautta ikkunaluokan näkyvälle kellolle.
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
     * Jonkin kysyessä nykyistä aikaa, annetaan se aina nelinumeroisena ja kaksoispiste välissä;
     * paitsi yli tunnin ajan kestossa pysäytetään tuntiin.
     * 
     * @return String-pätkä ajasta.
     */
    private String aika() {
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

    /**
     * Aikatekstipätkämetodin siistijä, jossa pidetään huoli nelinumeroisuudesta. 
     * 
     * @param puolikas Toinen osa aikaa.
     * @return Ajan puolikas, jossa on aina kaksi numeroa.
     */
    private String aikaSiistija(int puolikas) {
        if (puolikas < 10) {
            return "0" + puolikas;
        } else {
            return Integer.toString(puolikas);
        }
    }

    /**
     * Pelin päättyessä ajastin pysäytetään ja aika palautetaan Stringinä.
     * 
     * @return
     */
    public String peliPaattyi() {
        ajastin.stop();
        return aika();
    }

    /**
     * Aloittaessa uutta peliä nollataan aika.
     * 
     */
    public void nollaaAika() {
        ajastin.stop();
        aikaSekunneissa = 0;
    }

}
