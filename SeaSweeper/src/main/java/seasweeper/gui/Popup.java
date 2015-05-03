package seasweeper.gui;

import seasweeper.logiikka.Kello;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import seasweeper.logiikka.HighScore;

/**
 *
 * Popup-ikkunoiden luokka.
 */
public class Popup {

    private final HighScore keskitasotaulu;
    private final HighScore vaikeataulu;
    private final Kello kello;
    private final Kuvaluokka kuvaluokka;
    private JFrame jfraami;
    private int l;

    /**
     * Konstruktorissa annetaan ylimmässä logiikassa luotuja luokkia ja laudan
     * leveys.
     *
     * @param kello Ylimmässä logiikassa luotu Kello.
     * @param keskitasotaulu Ylimmässä logiikassa luotu keskitasoarvoinen
     * HighScore.
     * @param vaikeataulu Ylimmässä logiikassa luotu vaikea-arvoinen HighScore.
     * @param kuvaluokka Ylimmässä logiikassa luotu Kuvaluokka.
     */
    public Popup(Kello kello, HighScore keskitasotaulu, HighScore vaikeataulu, Kuvaluokka kuvaluokka) {
        this.kello = kello;
        this.keskitasotaulu = keskitasotaulu;
        this.vaikeataulu = vaikeataulu;
        this.kuvaluokka = kuvaluokka;
    }

    /**
     * Miinan klikkausta seuraava häviö-popup.
     */
    public void rajahti() {
        String stringi;
        if (l != 8) {
            stringi = "                Osuit miinaan...\nKokeile uudestaan painamalla reset.\n" + "                 Aikasi: " + kello.peliPaattyi();
        } else {
            stringi = "                Osuit miinaan...\nKokeile uudestaan painamalla reset.";
        }

        JOptionPane.showMessageDialog(jfraami, stringi, "Nyt kävi köpelösti", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("miina"));
    }

    /**
     * Kaikkien miinattomien ruutujen klikkausta seuraava voitto-popup.
     *
     * @throws IOException
     */
    public void voitit() throws IOException {
        String stringi;
        if (l != 8) {
            String aikasi = kello.peliPaattyi();
            stringi = "                Onnistuit!\n       Haravoit kaikki miinat!\n" + "              Aikasi: " + aikasi;
            String s = (String) JOptionPane.showInputDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"), null, "nimesi");
            if (s != null) {
                if (l == 16) {
                    keskitasotaulu.lisaa(s, aikasi);
                } else {
                    vaikeataulu.lisaa(s, aikasi);
                }
            }
        } else {
            stringi = "              Onnistuit!\n     Haravoit kaikki miinat!";
            JOptionPane.showMessageDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"));
        }
    }

    /**
     * HighScore-menupainikkeen klikkausta seuraava pistetilasto-popup.
     */
    public void highscore() {
        if (l == 16) {
            JOptionPane.showMessageDialog(jfraami, keskitasotaulu.kokoaTaulu(), "Top 10 Keskitaso", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(jfraami, vaikeataulu.kokoaTaulu(), "Top 10 Vaikea", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Uusien ruudukkojen luonnissa asetetaan aina uudet arvot.
     *
     * @param jfraami
     * @param l
     */
    public void setArvot(JFrame jfraami, int l) {
        this.jfraami = jfraami;
        this.l = l;
    }
}
