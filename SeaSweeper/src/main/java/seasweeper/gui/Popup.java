package seasweeper.gui;

import seasweeper.logiikka.Kello;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import seasweeper.logiikka.HighScore;

/**
 *
 * @author ez
 */
public class Popup {
    private final HighScore keskitasotaulu;
    private final HighScore vaikeataulu;
    private final Kello kello;
    private final Kuvaluokka kuvaluokka;
    private final JFrame jfraami;
    private final int l;
    
    public Popup(Kello kello, HighScore keskitasotaulu, HighScore vaikeataulu, Kuvaluokka kuvaluokka, JFrame jfraami, int l) {
        this.kello = kello;
        this.keskitasotaulu = keskitasotaulu;
        this.vaikeataulu = vaikeataulu;
        this.kuvaluokka = kuvaluokka;
        this.jfraami = jfraami;
        this.l = l;
    }
    
    /**
     *
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
     *
     * @throws IOException
     */
    public void voitit() throws IOException {
        String stringi;
        if (l != 8) {
            String aikasi = kello.peliPaattyi();
            stringi = "                Onnistuit!\n       Haravoit kaikki miinat!\n" + "              Aikasi: " + aikasi;
            String s = (String)JOptionPane.showInputDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"), null, "nimesi");
            if (l == 16) {
                keskitasotaulu.lisaa(s, aikasi);
            } else {
                vaikeataulu.lisaa(s, aikasi);
            }
        } else {
            stringi = "              Onnistuit!\n     Haravoit kaikki miinat!";
            JOptionPane.showMessageDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"));
        }
    }
    
    /**
     *
     */
    public void highscore() {
        if (l ==  16) {
            JOptionPane.showMessageDialog(jfraami, keskitasotaulu.kokoaTaulu(), "Top 10 Keskitaso", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(jfraami, vaikeataulu.kokoaTaulu(), "Top 10 Vaikea", JOptionPane.PLAIN_MESSAGE);
        }
    }
 }