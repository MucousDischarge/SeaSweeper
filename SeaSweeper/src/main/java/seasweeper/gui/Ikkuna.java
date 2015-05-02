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
    private int k;
    private int l;
    private JFrame jfraami;
    private JButton napisto[][];
    private JMenuItem aika;
    private JMenuItem highscore;

    /**
     * Konstruktorin yhteydessä annetaan liuta ylimmän logiikan luomia luokkia.
     * 
     * @param menukuuntelija Ylimmän logiikan luoma Menukuuntelija.
     * @param lautakuuntelija Ylimmän logiikan luoma Lautakuuntelija.
     * @param k Ylemmän logiikan tämänhetkinen laudan korkeus.
     * @param l Ylemmän logiikan tämänhetkinen laudan leveys.
     * @param keskitasotaulu Ylimmän logiikan luoma keskitasoarvoinen HighScore.
     * @param vaikeataulu Ylimmän logiikan luoma vaikeatasoinen HighScore.
     * @param kello Ylimmän logiikan luoma Kello.
     * @throws IOException
     * @throws URISyntaxException
     */
    public Ikkuna(Menukuuntelija menukuuntelija, Lautakuuntelija lautakuuntelija, int k, int l, HighScore keskitasotaulu, HighScore vaikeataulu, Kello kello) throws IOException, URISyntaxException {
        this.menukuuntelija = menukuuntelija;
        this.lautakuuntelija = lautakuuntelija;
        this.kuvaluokka = new Kuvaluokka();
        this.kello = kello;
        this.keskitasotaulu = keskitasotaulu;
        this.vaikeataulu = vaikeataulu;
        this.popup = new Popup(kello, keskitasotaulu, vaikeataulu, kuvaluokka, l);
        newFraami(k, l);
    }
    
    /**
     * Jatkuvien uusien ikkunaluokkien luomisen sijaan luodaan tarvittaessa
     * vain uusi fraami.
     * 
     * @param k Laudan korkeus.
     * @param l Laudan leveys.
     */
    public void newFraami(int k, int l) {
        this.k = k;
        this.l = l;
        this.napisto = new JButton[k][l];
        this.jfraami = new JFrame();
        popup.setArvot(this.jfraami, l);
        fraamiPerusasetukset();
        asetaMenu();
    }
    
    /**
     * Asetetaan fraami perusasetukset.
     */
    public final void fraamiPerusasetukset() {
        jfraami.setSize((l * 22), (k * 25));
        jfraami.setTitle("SeaSweeper");
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        jfraami.setLayout(new GridLayout(k, l));
    }
    
    /**
     * Asetetaan fraamiin menuvalikko.
     */
    public final void asetaMenu() {
        JMenuBar valikko = new JMenuBar();
        asetaVaikeusMenu(valikko);
        asetaMuutMenuItemit(valikko);
    }
    
    /**
     * Asetetaan fraamin menuvalikkoon vaikeusvalintavalikko.
     * 
     * @param valikko Menuvalikko, johon asetetaan vaikeusvalinta.
     */
    public void asetaVaikeusMenu(JMenuBar valikko) {
        JMenu vaikeusvalinta = new JMenu("Vaikeus");
        valikko.add(vaikeusvalinta);

        JMenuItem helppo = new JMenuItem("Helppo");
        vaikeusvalinta.add(helppo);
        JMenuItem keskitaso = new JMenuItem("Keskitaso");
        vaikeusvalinta.add(keskitaso);
        JMenuItem vaikea = new JMenuItem("Vaikea");
        vaikeusvalinta.add(vaikea);

        helppo.addActionListener(menukuuntelija);
        keskitaso.addActionListener(menukuuntelija);
        vaikea.addActionListener(menukuuntelija);
    }
    
    /**
     * Asetetaan menuvalikkoon muut halutut toiminnot.
     * 
     * @param valikko Menuvalikko, johon halutut toiminnot asetetaan.
     */
    public void asetaMuutMenuItemit(JMenuBar valikko) {
        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener(menukuuntelija);

        aika = new JMenuItem("00:00");
        highscore = new JMenuItem("HighScore");

        if (k != 8) {
            valikko.add(aika);
            highscore.addActionListener(menukuuntelija);
            valikko.add(highscore);
        }

        jfraami.setJMenuBar(valikko);
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
     */
    public void poistaNapit() {
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
        aika.setText(uusiAika);
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
        aika.setText("00:00");
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

    // TESTEJÄ VARTEN OLEVAT METODIT

    /**
     * Testimetodi
     * 
     * @return
     */
    public int getK() {
        return k;
    }

    /**
     * Testimetodi.
     * @return
     */
    public int getL() {
        return l;
    }
    
    /**
     * Testimetodi.
     * 
     * @return
     */
    public JFrame getFraami() {
        return jfraami;
    }
    
    /**
     * Testimetodi.
     * 
     * @return
     */
    public JButton[][] getNapisto() {
        return this.napisto;
    }
}
