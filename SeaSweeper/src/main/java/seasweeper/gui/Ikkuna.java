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
 * Pääasiallinen GUI-luokka
 */
public class Ikkuna {

    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private final Kuvaluokka kuvaluokka;
    private final Kello kello;
    private final HighScore keskitasotaulu;
    private final HighScore vaikeataulu;
    private final Popup popup;
    private final int k;
    private final int l;
    private final JFrame jfraami;
    private final JButton napisto[][];
    private JMenuItem aika;
    private JMenuItem highscore;

    /**
     *
     * @param menukuuntelija
     * @param lautakuuntelija
     * @param k
     * @param l
     * @param keskitasotaulu
     * @param vaikeataulu
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
        this.k = k;
        this.l = l;
        this.napisto = new JButton[k][l];
        this.jfraami = new JFrame();
        this.popup = new Popup(kello, keskitasotaulu, vaikeataulu, kuvaluokka, jfraami, l);
        fraamiPerusasetukset();
        asetaMenu();
    }
    
    public final void fraamiPerusasetukset() {
        jfraami.setSize((l * 22), (k * 25));
        jfraami.setTitle("SeaSweeper");
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        jfraami.setLayout(new GridLayout(k, l));
    }
    
    public final void asetaMenu() {
        JMenuBar valikko = new JMenuBar();
        asetaVaikeusMenu(valikko);
        asetaMuutMenuItemit(valikko);
    }
    
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
     *
     * @param i
     * @param j
     * @return
     */
    public JButton luoNappi(int i, int j) {
        this.napisto[i][j] = new JButton();
        this.napisto[i][j].setIcon(kuvaluokka.getKuva("tummavesi"));
        this.napisto[i][j].addMouseListener(lautakuuntelija);
        jfraami.add(this.napisto[i][j]);
        return this.napisto[i][j];
    }

    /**
     *
     * @param i
     * @param j
     */
    public void poistaNapit(int i, int j) {
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                jfraami.remove(this.napisto[a][b]);
            }
        }
    }

    /**
     *
     */
    public void visible() {
        jfraami.setVisible(true);
    }

    /**
     *
     */
    public void tuhoa() {
        jfraami.dispose();
    }
    
    public void piirraUudelleen() {
        jfraami.validate();
        jfraami.repaint();
    }

    /**
     *
     * @param kuva
     * @param a
     * @param b
     */
    public void kuva(String kuva, int a, int b) {
        napisto[a][b].setIcon(kuvaluokka.getKuva(kuva));
    }

    /**
     *
     * @param uusiAika
     * @throws IOException
     */
    public void paivitaAika(String uusiAika) throws IOException {
        aika.setText(uusiAika);
    }

    /**
     *
     */
    public void aloitaAjanlasku() {
        kello.aikaTimer();
    }

    /**
     *
     */
    public void nollaaAika() {
        kello.nollaaAika();
        aika.setText("00:00");
    }

    /**
     *
     */
    public void rajahti() {
       popup.rajahti();
    }

    /**
     *
     * @throws IOException
     */
    public void voitit() throws IOException {
        popup.voitit();
    }
    
    /**
     *
     */
    public void highscore() {
        popup.highscore();
    }

    // TESTEJÄ VARTEN OLEVAT METODIT

    /**
     *
     * @return
     */
        public int getK() {
        return k;
    }

    /**
     *
     * @return
     */
    public int getL() {
        return l;
    }
    
    public JFrame getFraami() {
        return jfraami;
    }
    
    /**
     *
     * @return
     */
    public JButton[][] getNapisto() {
        return this.napisto;
    }
}
