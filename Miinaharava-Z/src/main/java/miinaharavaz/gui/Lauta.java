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
import miinaharavaz.logiikka.Miinaluokka;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Lauta extends JFrame {

    final JButton napisto[][];
    final int k = 16;
    Miinaluokka miinaluokka;
    boolean onkoEnsimmainenKlikkaus;
    ImageIcon miina = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/miina.png");
    ImageIcon nolla = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/0.png");
    ImageIcon yksi = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/1.png");
    ImageIcon kaksi = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/2.png");
    ImageIcon kolme = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/3.png");
    ImageIcon nelja = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/4.png");
    ImageIcon viisi = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/5.png");
    ImageIcon kuusi = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/6.png");
    ImageIcon seitseman = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/7.png");
    ImageIcon kahdeksan = new ImageIcon("/home/ezaalto/Miinaharava-Z/Miinaharava-Z/src/main/resources/icons/8.png");

    /**
     * Metodi luo graafisen laudan kutsuttuna mainista (ja todennäköisesti
     * suorittaa pelilogiikat)
     */
    public Lauta() {
        this.setLayout(new GridLayout(k, k));
        napisto = new JButton[k][k];
        for (int a = 0; a < k; a++) {
            for (int b = 0; b < k; b++) {
                napisto[a][b] = new JButton();
                napisto[a][b].addActionListener(new Lautakuuntelija());
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
    }

    private ImageIcon createImageIcon(String iconsmiinapng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                        String ruutu = "" + a + "-" + b;
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
                    String miinakohta = "" + x + "-" + y;
                    if (miinaluokka.onkoMiina(miinakohta)) {
                        napisto[x][y].setIcon(miina);
                    }
                }
            }
        }

        public void Raivaaja(int a, int b, boolean liianKaukainen) {
            int luku = 0;
            if (miinaluokka.onkoMiina("" + (a) + "-" + (b - 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja(a, (b - 1), true);
            }

            if (miinaluokka.onkoMiina("" + (a) + "-" + (b + 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja(a, (b + 1), true);
            }

            if (miinaluokka.onkoMiina("" + (a - 1) + "-" + (b))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a - 1), b, true);
            }

            if (miinaluokka.onkoMiina("" + (a + 1) + "-" + (b))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a + 1), b, true);
            }

            if (miinaluokka.onkoMiina("" + (a - 1) + "-" + (b - 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a - 1), (b - 1), true);
            }

            if (miinaluokka.onkoMiina("" + (a - 1) + "-" + (b + 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a - 1), (b + 1), true);
            }

            if (miinaluokka.onkoMiina("" + (a + 1) + "-" + (b - 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a + 1), (b - 1), true);
            }

            if (miinaluokka.onkoMiina("" + (a + 1) + "-" + (b + 1))) {
                luku++;
            } else if (liianKaukainen == false) {
                Raivaaja((a + 1), (b + 1), true);
            }
            
            if (luku == 0) {
                napisto[a][b].setIcon(nolla);
            }
            
            if (luku == 1) {
                napisto[a][b].setIcon(yksi);
            }
            
            if (luku == 2) {
                napisto[a][b].setIcon(kaksi);
            }
            
            if (luku == 3) {
                napisto[a][b].setIcon(kolme);
            }
            
            if (luku == 4) {
                napisto[a][b].setIcon(nelja);
            }
            
            if (luku == 5) {
                napisto[a][b].setIcon(viisi);
            }
            
            if (luku == 6) {
                napisto[a][b].setIcon(kuusi);
            }
            
            if (luku == 7) {
                napisto[a][b].setIcon(seitseman);
            }
            
            if (luku == 8) {
                napisto[a][b].setIcon(kahdeksan);
            }
            
        }
    }
}
