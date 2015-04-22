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
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import seasweeper.logiikka.Miinaluokka;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import seasweeper.logiikka.Peruslogiikka;

public class Lauta extends JFrame {

    final JButton napisto[][];
    private int k;
    private Miinaluokka miinaluokka;
    private Peruslogiikka peruslogiikka;
    private ImageIcon kuvat[];
    private ImageIcon miina;
    private ImageIcon lippu;
    private ImageIcon tummavesi;

    /**
     * Metodi luo graafisen laudan kutsuttuna mainista
     */
    public Lauta() {
        JFrame jfraami = new JFrame();
        this.k = 16;
        kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/" + i + ".png");
        }
        this.miina = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/miina.png");
        this.lippu = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/lippu.png");
        this.tummavesi = new ImageIcon("/home/ezaalto/SeaSweeper/SeaSweeper/src/main/resources/icons/tummavesi.png");

        jfraami.setLayout(new GridLayout(k, k));
        this.napisto = new JButton[k][k];
        this.miinaluokka = new Miinaluokka();
        this.peruslogiikka = new Peruslogiikka(miinaluokka, k, napisto, miina, lippu, tummavesi, kuvat);
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < k; b++) {
                this.napisto[a][b] = new JButton();
                this.napisto[a][b].setIcon(this.tummavesi);
                this.napisto[a][b].addMouseListener((MouseListener) new Lautakuuntelija(peruslogiikka));
                jfraami.add(this.napisto[a][b]);
            }
        }
        JMenuBar valikko = new JMenuBar();
        JMenu vaikeustaso = new JMenu("Vaikeustaso");
        valikko.add(vaikeustaso);
        JMenuItem helppo = new JMenuItem("Helppo");
        JMenuItem keskitaso = new JMenuItem("Keskitaso");
        JMenuItem vaikea = new JMenuItem("Vaikea");
        vaikeustaso.add(helppo);
        vaikeustaso.add(keskitaso);
        vaikeustaso.add(vaikea);
        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener((ActionListener) new Menukuuntelija(jfraami));
        jfraami.setJMenuBar(valikko);
        jfraami.setTitle("SeaSweeper");
        jfraami.setSize(400, 400);
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        jfraami.setVisible(true);
    }
}
