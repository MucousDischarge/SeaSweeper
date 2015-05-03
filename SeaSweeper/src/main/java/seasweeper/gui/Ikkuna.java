package seasweeper.gui;

import seasweeper.logiikka.Kello;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import seasweeper.logiikka.HighScore;

/**
 *
 * Pääasiallinen GUI-luokka.
 */
public class Ikkuna {

    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private final Kuvaluokka kuvaluokka;
    private final Kello kello;
    private final HighScore keskitasotaulu;
    private final HighScore vaikeataulu;
    private final Popup popup;
    private Fraami fraami;
    private JFrame jfraami;
    private JButton napisto[][];
    private JMenuItem aika;
    private JMenuItem highscore;

    /**
     * Konstruktorin yhteydessä annetaan liuta ylimmän logiikan luomia luokkia.
     * 
     * @param menukuuntelija Ylimmän logiikan luoma Menukuuntelija.
     * @param lautakuuntelija Ylimmän logiikan luoma Lautakuuntelija.
     * @param keskitasotaulu Ylimmän logiikan luoma keskitasoarvoinen HighScore.
     * @param vaikeataulu Ylimmän logiikan luoma vaikeatasoinen HighScore.
     * @param kello Ylimmän logiikan luoma Kello.
     * @throws IOException
     * @throws URISyntaxException
     */
    public Ikkuna(Menukuuntelija menukuuntelija, Lautakuuntelija lautakuuntelija, HighScore keskitasotaulu, HighScore vaikeataulu, Kello kello) throws IOException, URISyntaxException {
        this.menukuuntelija = menukuuntelija;
        this.lautakuuntelija = lautakuuntelija;
        this.kuvaluokka = new Kuvaluokka();
        this.kello = kello;
        this.keskitasotaulu = keskitasotaulu;
        this.vaikeataulu = vaikeataulu;
        this.popup = new Popup(kello, keskitasotaulu, vaikeataulu, kuvaluokka);
        this.fraami = new Fraami(this);
    }
    
    /**
     * Asennetaan fraami.
     * 
     * @param a Laudan korkeus.
     * @param b Laudan leveys.
     */
    public void setFraami(int a, int b) {
        this.jfraami = uusiFraami(a, b);
    }
    
    /**
     * Haetaan fraami fraamiluokasta.
     * 
     * @param k Laudan korkeus.
     * @param l Laudan leveys.
     * @return Palautetaan uunituore fraami.
     */
    public JFrame uusiFraami(int k, int l) {
        return fraami.getFraami(k, l);
    }
    
    /**
     * Asetetaan popupin arvot.
     * 
     * @param jfraami 
     * @param l
     */
    public void setPopup(JFrame jfraami, int l) {
        popup.setArvot(jfraami, l);
    }
    
    /**
     * Annetaan menukuuntelija fraamiluokalle.
     * 
     * @return Menukuuntelija.
     */
    public Menukuuntelija getMenukuuntelija() {
        return menukuuntelija;
    }
    
    /**
     * Luodaan napisto.
     * 
     * @param k Laudan korkeus.
     * @param l Laudan leveys.
     */
    public void napisto(int k, int l) {
        this.napisto = new JButton[k][l];
    }

    /**
     * Luodaan JButton, johon asetetaan kuuntelija ja aluksi tummavesikuva.
     * 
     * @param i Napin korkeussijainti.
     * @param j Napin leveyssijainti.
     * @return Palautetaan luotu nappi.
     */
    public JButton luoNappi(int i, int j) {
        this.napisto[i][j] = new JButton();
        this.napisto[i][j].setIcon(kuvaluokka.getKuva("tummavesi"));
        this.napisto[i][j].addMouseListener(lautakuuntelija);
        jfraami.add(this.napisto[i][j]);
        return this.napisto[i][j];
    }

    /**
     * Uusien ruudukkojen luomisen yhteydessä kutsutaan tämä metodi, jossa
     * poistetaan fraamilta kaikki vanhat JButtonit.
     * @param k
     * @param l
     */
    public void poistaNapit(int k, int l) {
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < l; b++) {
                jfraami.remove(this.napisto[a][b]);
            }
        }
    }

    /**
     * Asetetaan fraami näkyväksi erikseen, sillä napit luodaan tavallisten 
     * fraamiasetusten jälkeen.
     */
    public void visible() {
        jfraami.setVisible(true);
    }

    /**
     * Tuhotaan vanha fraami uuden tieltä.
     */
    public void tuhoa() {
        jfraami.dispose();
    }
    
    /**
     * Uuden ruudukon luonnissa tärkeä ikkunan uudelleenpiirto.
     */
    public void piirraUudelleen() {
        jfraami.validate();
        jfraami.repaint();
    }

    /**
     * Ruutujen antama käsky kuvan annosta itsensä JButtonille.
     * 
     * @param nappi Ruudun JButton, jolle kuva annetaan.
     * @param kuva Haluttu kuva.
     */
    public void kuva(JButton nappi, String kuva) {
        nappi.setIcon(kuvaluokka.getKuva(kuva));
    }

    /**
     * Näkyvän ajan jokasekuntinen päivitys.
     * 
     * @param uusiAika Uusi aika String-muodossa.
     * @throws IOException
     */
    public void paivitaAika(String uusiAika) throws IOException {
        fraami.getAikaMenu().setText(uusiAika);
    }

    /**
     * Kellonkäynnin aloitus.
     */
    public void aloitaAjanlasku() {
        kello.aikaTimer();
    }

    /**
     * Ajan nollaus, resetoidessa ruudukkoa.
     */
    public void nollaaAika() {
        kello.nollaaAika();
        fraami.getAikaMenu().setText("00:00");
    }

    /**
     * Miinaan osuminen, josta seuraa miina-popup.
     */
    public void rajahti() {
       popup.rajahti();
    }

    /**
     * Kaikkia miinattomia ruutuja klikattua avautuu voitto-popup.
     * 
     * @throws IOException
     */
    public void voitit() throws IOException {
        popup.voitit();
    }
    
    /**
     * Menun highscore-nappia klikatessa avautuu highscore-popup.
     */
    public void highscore() {
        popup.highscore();
    }
}
