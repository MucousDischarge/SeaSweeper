package seasweeper.gui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import seasweeper.logiikka.AlempiLogiikka;

/**
 *
 * @author ez
 */
public class Ikkuna {

    private JFrame jfraami;
    private JButton napisto[][];
    private int k;
    private int l;
    private Lautakuuntelija lautakuuntelija;
    private Menukuuntelija menukuuntelija;
    private Kuvaluokka kuvaluokka;

    public Ikkuna(Menukuuntelija menukuuntelija, Lautakuuntelija lautakuuntelija, int k, int l){
        this.menukuuntelija = menukuuntelija;
        this.lautakuuntelija = lautakuuntelija;
        this.k = k;
        this.l = l;
        this.jfraami = new JFrame();
        this.kuvaluokka = new Kuvaluokka();
        
        jfraami.setSize((l * 22), (k * 25));
        jfraami.setTitle("SeaSweeper");
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        jfraami.setLayout(new GridLayout(k, l));
        this.napisto = new JButton[k][l];
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
    }

    public JButton luoNappi(int i, int j) {
        this.napisto[i][j] = new JButton();
        this.napisto[i][j].setIcon(kuvaluokka.getKuva("tummavesi"));
        this.napisto[i][j].addMouseListener(lautakuuntelija);
        jfraami.add(this.napisto[i][j]);
        return this.napisto[i][j];
    }
    
    public void poistaNapit(int i, int j) {
        for (int a = 0; a < i; a++) {
            for (int b = 0; b < j; b++) {
                jfraami.remove(this.napisto[a][b]);
            }
        }
    }
    
    public void visible() {
        jfraami.setVisible(true);
    }
    
    public JFrame getFraami() {
        return jfraami;
    }
    
    public JButton[][] getNapisto() {
        return this.napisto;
    }
    
    public void kuva(String kuva, int a, int b) {
        napisto[a][b].setIcon(kuvaluokka.getKuva(kuva));
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    
    

    public JButton getNappi(int i, int j) {
        return this.napisto[i][j];
    }
    
    public int getK() {
        return k;
    }
    
    public int getL() {
        return l;
    }
}
