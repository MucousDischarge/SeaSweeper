/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.gui;

/**
 * Luokka suorittaa pelilaudan ja sen kuuntelun (ja todennäköisesti myös kutsuu
 * pelilogiikan henkiin)
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import miinaharavaz.logiikka.Miinaluokka;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Lauta extends JFrame {

    final JButton napisto[][];
    final int k = 16;
    Miinaluokka miinaluokka;
    boolean onkoEnsimmainenKlikkaus;
    ImageIcon kuvat[];
    ImageIcon miina;
    ArrayList<String> raivattujenLista;
    String osoite;

    /**
     * Metodi luo graafisen laudan kutsuttuna mainista (ja todennäköisesti
     * suorittaa pelilogiikat)
     */
    public Lauta() {
        kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/" + i + ".png");
        }
        miina = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/miina.png");

        this.setLayout(new GridLayout(k, k));
        napisto = new JButton[k][k];
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < k; b++) {
                napisto[a][b] = new JButton();
                napisto[a][b].addActionListener((ActionListener) new Lautakuuntelija());
                add(napisto[a][b]);
            }
        }
        setTitle("Miinaharava-Z");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        miinaluokka = new Miinaluokka();
        onkoEnsimmainenKlikkaus = false;
        raivattujenLista = new ArrayList<String>();
    }

    /**
     * Luokka suorittaa graafisen pelilaudan kuuntelun
     */
    private class Lautakuuntelija implements ActionListener {

        /**
         * Metodi suorittaa halutun toiminnon napinpainalluksesta
         *
         * @param e Käyttäjän napin painallus
         * @return haluttu toiminto
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int a = 0; a < k; a++) {
                for (int b = 0; b < k; b++) {
                    if (e.getSource() == napisto[a][b]) {
                        String ruutu = "" + a + ":" + b;
                        if (!(onkoEnsimmainenKlikkaus)) {
                            onkoEnsimmainenKlikkaus = true;
                            miinaluokka.luoMiinat(ruutu);
                        }

                        if (miinaluokka.onkoMiina(ruutu)) {
                            System.out.println("kuolit");
                            Rajahti();
                            //kaikki miinat paljastuvat ruudulla
                        } else {
                            System.out.println("et kuollut");
                            Raivaaja(a, b, false);
                            //alta paljastuu muuta kuin miina, ja läheiset paljastuvat myös

                        }
                    }
                }
            }
        }

        public void Rajahti() {
            for (int x = 0; x < k; x++) {
                for (int y = 0; y < k; y++) {
                    String miinakohta = "" + x + ":" + y;
                    if (miinaluokka.onkoMiina(miinakohta)) {
                        napisto[x][y].setIcon(miina);
                    }
                }
            }
        }

        public void Raivaaja(int a, int b, boolean liianKaukainen) {
            String ruutu = "" + a + ":" + b;
            String[] osat = ruutu.split(":");
            if (Integer.parseInt(osat[0]) <= 15 && Integer.parseInt(osat[0]) >= 0 && Integer.parseInt(osat[1]) <= 15 && Integer.parseInt(osat[1]) >= 0) {
                ArrayList raivaajalista = new ArrayList<String>();
                
                if ((b - 1) <= 15 && (b - 1) >= 0) {
                    raivaajalista.add(("" + a + ":" + (b - 1)));
                    if ((a - 1) <= 15 && (a - 1) >= 0) {
                        raivaajalista.add(("" + (a - 1) + ":" + (b - 1)));
                    }
                    
                    if ((a + 1) <= 15 && (a + 1) >= 0) {
                        raivaajalista.add(("" + (a + 1) + ":" + (b - 1)));
                    }
                }
                
                if ((b + 1) <= 15 && (b + 1) >= 0) {
                    raivaajalista.add(("" + a + ":" + (b + 1)));
                    if ((a - 1) <= 15 && (a - 1) >= 0) {
                        raivaajalista.add(("" + (a - 1) + ":" + (b + 1)));
                    }
                    if ((a + 1) <= 15 && (a + 1) >= 0) {
                        raivaajalista.add(("" + (a + 1) + ":" + (b + 1)));
                    }
                }
                if ((a - 1) <= 15 && (a - 1) >= 0) {
                    raivaajalista.add(("" + (a - 1) + ":" + b));
                } 
                        
                if ((a + 1) <= 15 && (a + 1) >= 0) {    
                    raivaajalista.add(("" + (a + 1) + ":" + b));
                }
                
                int luku = 0;

                for (int i = 0; i < raivaajalista.size(); i++) {
                    if (miinaluokka.onkoMiina(raivaajalista.get(i).toString())) {
                        luku++;
                    }
                }

                for (int i = 0; i < 8; i++) {
                    if (luku == i) {
                        napisto[a][b].setIcon(kuvat[i]);
                    }
                }
                raivattujenLista.add(ruutu);
                if (!(raivaajalista.isEmpty())) {

                    for (int i = 0; i < raivaajalista.size(); i++) {
                        boolean raivattuko = false;
                        String raivaaja = raivaajalista.get(i).toString();
                        if (!(miinaluokka.onkoMiina(raivaaja)) && liianKaukainen == false) {
                            String[] uudetOsat = raivaaja.split(":");
                            for (int o = 0; o < raivattujenLista.size(); o++) {
                                String raivattu = raivattujenLista.get(o);
                                if (raivaaja.equals(raivattu)) {
                                    raivattuko = true;
                                }
                            }
                            if (!(raivattuko)) {
                                if (luku == 0) {
                                    Raivaaja(Integer.parseInt(uudetOsat[0]), Integer.parseInt(uudetOsat[1]), false);
                                } else {
                                    Raivaaja(Integer.parseInt(uudetOsat[0]), Integer.parseInt(uudetOsat[1]), true);
                                }
                            }

                        }

                    }
                }

            }
        }

    }
}
