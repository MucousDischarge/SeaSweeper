/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seasweeper.gui;

/**
 * Luokka suorittaa pelilaudan ja sen kuuntelun (ja todennäköisesti myös kutsuu
 * pelilogiikan henkiin)
 */
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import seasweeper.logiikka.Peruslogiikka;

public class Lauta extends JFrame {

    private JFrame jfraami;
    private final JButton napisto[][];
    private int k;
    private int l;
    private final Peruslogiikka peruslogiikka;
    private final ImageIcon kuvat[];
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;

    /**
     * Metodi luo graafisen laudan kutsuttuna mainista
     * @param vaikeustaso
     */
    public Lauta(String vaikeustaso) {
        this.jfraami = new JFrame();
        
        switch (vaikeustaso) {
            case "Helppo":
                this.k = 8;
                this.l = 8;
                break;
            case "Vaikea":
                this.k = 16;
                this.l = 30;
                break;
            default:
                this.k = 16;
                this.l = 16;
                break;
        }
        jfraami.setSize((l*22), (k*25));
        jfraami.setTitle("SeaSweeper");
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        
        kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/" + i + ".png");
        }
        this.miina = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/miina.png");
        this.lippu = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/lippu.png");
        this.tummavesi = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/tummavesi.png");

        jfraami.setLayout(new GridLayout(k, l));
        this.napisto = new JButton[k][l];
        this.peruslogiikka = new Peruslogiikka(k, l, napisto, miina, lippu, tummavesi, kuvat);
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < l; b++) {
                this.napisto[a][b] = new JButton();
                this.napisto[a][b].setIcon(this.tummavesi);
                this.napisto[a][b].addMouseListener((MouseListener) new Lautakuuntelija(peruslogiikka));
                jfraami.add(this.napisto[a][b]);
            }
        }
        Menukuuntelija menukuuntelija = new Menukuuntelija(jfraami, vaikeustaso);
        JMenuBar valikko = new JMenuBar();
        JMenu vaikeusvalinta = new JMenu("Vaikeustaso");
        valikko.add(vaikeusvalinta);
        JMenuItem helppo = new JMenuItem("Helppo");
        JMenuItem keskitaso = new JMenuItem("Keskitaso");
        JMenuItem vaikea = new JMenuItem("Vaikea");
        vaikeusvalinta.add(helppo);
        vaikeusvalinta.add(keskitaso);
        vaikeusvalinta.add(vaikea);
        helppo.addActionListener(menukuuntelija);
        keskitaso.addActionListener(menukuuntelija);
        vaikea.addActionListener(menukuuntelija);
        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener(menukuuntelija);
        jfraami.setJMenuBar(valikko);
        jfraami.setVisible(true);
    }
}
