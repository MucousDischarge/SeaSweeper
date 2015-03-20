/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miinaharavaz.miinaharava.z;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author ezaalto
 */
public class Main extends JPanel {
    private JButton ruutu[][];
    final int r = 16;
    final int k = 400;
    
    public Main() {
        this.setLayout(new GridLayout(r,r));
        ruutu = new JButton[r][r];
        nappulat();
    }
    
    private void nappulat() {
        for (int a = 0; a < r; a++) {
            for (int b = 0; b < r; b++) {
                ruutu[a][b] = new JButton();
                ruutu[a][b].setSize(k,k);
                this.add(ruutu[a][b]);
            }
        }
    }
    
    public static void main(String[] args) {
        Main lauta1 = new Main();
        JFrame raami = new JFrame("Miinaharava-Z");
        raami.add(lauta1);
        raami.setSize(400,400);
        raami.setLocationRelativeTo(null);
        raami.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        raami.setResizable(false);
        raami.setVisible(true);
    }
}
