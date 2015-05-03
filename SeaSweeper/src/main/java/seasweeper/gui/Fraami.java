package seasweeper.gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * Hoitaa JFramen toiminnot ja määritelmän.
 */
public class Fraami {
    private final Ikkuna ikkuna;
    private JFrame jfraami;
    private JMenuItem aika;
    private int k;
    private int l;

    /**
     * Yhteys ikkunaan.
     * 
     * @param ikkuna
     */
    public Fraami(Ikkuna ikkuna) {
        this.ikkuna = ikkuna;
    }
    
    /**
     * Palautetaan valmis fraami.
     * 
     * @param a Laudan korkeus.
     * @param b Laudan leveys.
     * @return Valmis fraami.
     */
    public JFrame getFraami(int a, int b) {
        newFraami(a, b);
        return jfraami;
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
        this.jfraami = new JFrame();
        ikkuna.setPopup(this.jfraami, l);
        fraamiPerusasetukset();
        asetaMenu();
    }
    
    /**
     * Asetetaan fraami perusasetukset.
     */
    private void fraamiPerusasetukset() {
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
    private void asetaMenu() {
        JMenuBar valikko = new JMenuBar();
        asetaVaikeusMenu(valikko);
        asetaMuutMenuItemit(valikko);
    }
    
    /**
     * Asetetaan fraamin menuvalikkoon vaikeusvalintavalikko.
     * 
     * @param valikko Menuvalikko, johon asetetaan vaikeusvalinta.
     */
    private void asetaVaikeusMenu(JMenuBar valikko) {
        JMenu vaikeusvalinta = new JMenu("Vaikeus");
        valikko.add(vaikeusvalinta);

        JMenuItem helppo = new JMenuItem("Helppo");
        vaikeusvalinta.add(helppo);
        JMenuItem keskitaso = new JMenuItem("Keskitaso");
        vaikeusvalinta.add(keskitaso);
        JMenuItem vaikea = new JMenuItem("Vaikea");
        vaikeusvalinta.add(vaikea);

        helppo.addActionListener(getMenukuuntelija());
        keskitaso.addActionListener(getMenukuuntelija());
        vaikea.addActionListener(getMenukuuntelija());
    }
    
    /**
     * Asetetaan menuvalikkoon muut halutut toiminnot.
     * 
     * @param valikko Menuvalikko, johon halutut toiminnot asetetaan.
     */
    private void asetaMuutMenuItemit(JMenuBar valikko) {
        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener(getMenukuuntelija());

        aika = new JMenuItem("00:00");
        JMenuItem highscore = new JMenuItem("HighScore");

        if (k != 8) {
            valikko.add(aika);
            highscore.addActionListener(getMenukuuntelija());
            valikko.add(highscore);
        }

        jfraami.setJMenuBar(valikko);
    } 
    
    /**
     * @return Palautetaan aikamenunappi.
     */
    public JMenuItem getAikaMenu() {
        return aika;
    }
    
    /**
     *
     * @return Haetaan menukuuntelija.
     */
    public Menukuuntelija getMenukuuntelija() {
        return ikkuna.getMenukuuntelija();
    }
 }