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
import javax.swing.JOptionPane;
import seasweeper.logiikka.HighScore;

/**
 *
 * @author ez
 */
public class Ikkuna {

    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private final Kuvaluokka kuvaluokka;
    private final Kello kello;
    private final HighScore highscore;
    private final int k;
    private final int l;
    private final JFrame jfraami;
    private final JButton napisto[][];
    private final JMenuItem aika;

    public Ikkuna(Menukuuntelija menukuuntelija, Lautakuuntelija lautakuuntelija, int k, int l) throws IOException, URISyntaxException {
        this.menukuuntelija = menukuuntelija;
        this.lautakuuntelija = lautakuuntelija;
        this.kuvaluokka = new Kuvaluokka();
        this.kello = new Kello(this);
        this.highscore = new HighScore();
        this.k = k;
        this.l = l;
        this.napisto = new JButton[k][l];
        this.jfraami = new JFrame();

        jfraami.setSize((l * 22), (k * 25));
        jfraami.setTitle("SeaSweeper");
        jfraami.setLocationRelativeTo(null);
        jfraami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfraami.setResizable(false);
        jfraami.setLayout(new GridLayout(k, l));

        JMenuBar valikko = new JMenuBar();
        JMenu vaikeusvalinta = new JMenu("Vaikeustaso");
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

        JMenuItem reset = new JMenuItem("Reset");
        valikko.add(reset);
        reset.addActionListener(menukuuntelija);

        aika = new JMenuItem("00:00");

        if (k != 8) {
            valikko.add(aika);
        }

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

    public JButton getNappi(int i, int j) {
        return this.napisto[i][j];
    }

    public void paivitaAika(String uusiAika) {
        aika.setText(uusiAika);
    }

    public void ajanPaivittaja() {
        kello.aikaTimer();
    }

    public void nollaaAika() {
        kello.nollaaAika();
        aika.setText("00:00");
    }

    public void rajahti() {
        String stringi;
        if (k != 8) {
            stringi = "               Osuit miinaan...\nKokeile uudestaan painamalla reset.\n" + "                 Aikasi: " + kello.peliPaattyi();
        } else {
            stringi = "               Osuit miinaan...\nKokeile uudestaan painamalla reset.";
        }

        JOptionPane.showMessageDialog(jfraami, stringi, "Nyt kävi köpelösti", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("miina"));
    }

    public void voitit() throws IOException {
        String stringi;
        if (k != 8) {
            String aikasi = kello.peliPaattyi();
            stringi = "                Onnistuit!\n       Haravoit kaikki miinat!\n" + "              Aikasi: " + aikasi;
            String s = (String)JOptionPane.showInputDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"), null, "nimesi");
            highscore.lisaa(s, aikasi);
        } else {
            stringi = "              Onnistuit!\n     Haravoit kaikki miinat!";
            JOptionPane.showMessageDialog(jfraami, stringi, "Voitit!", JOptionPane.INFORMATION_MESSAGE, kuvaluokka.getKuva("lippu"));
        }
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
    public int getK() {
        return k;
    }

    public int getL() {
        return l;
    }
}
