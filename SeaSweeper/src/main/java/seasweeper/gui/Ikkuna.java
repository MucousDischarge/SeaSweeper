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

    private final JFrame jfraami;
    private final JButton napisto[][];
    private final int k;
    private final int l;
    private AlempiLogiikka alempilogiikka;
    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private final Kuvaluokka kuvaluokka;
    private String vaikeustaso;

    public Ikkuna(String vaikeustaso, AlempiLogiikka alempilogiikka){
        this.vaikeustaso = vaikeustaso;
        this.alempilogiikka = alempilogiikka;
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
        this.lautakuuntelija = new Lautakuuntelija(alempilogiikka);
        this.menukuuntelija = new Menukuuntelija(jfraami, vaikeustaso);
        helppo.addActionListener(menukuuntelija);
        keskitaso.addActionListener(menukuuntelija);
        vaikea.addActionListener(menukuuntelija);
        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener(menukuuntelija);
        jfraami.setJMenuBar(valikko);
        alempilogiikka.setNapisto(napisto);
    }

    public JButton luoNappi(int i, int j) {
        this.napisto[i][j] = new JButton();
        this.napisto[i][j].setIcon(kuvaluokka.getKuva("tummavesi"));
        this.napisto[i][j].addMouseListener(lautakuuntelija);
        jfraami.add(this.napisto[i][j]);
        return this.napisto[i][j];
    }
    
    public void poistaNappi(int i, int j) {
        jfraami.remove(this.napisto[i][j]);
    }
    
    public void visible() {
        jfraami.setVisible(true);
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
    
    public JFrame getJFraami() {
        return jfraami;
    }
}
