package seasweeper.logiikka;

import javax.swing.JButton;
import seasweeper.gui.Ikkuna;
import seasweeper.gui.Lautakuuntelija;
import seasweeper.gui.Menukuuntelija;

/**
 *
 * @author ez
 */
public final class YlempiLogiikka {

    private Ikkuna ikkuna;
    private AlempiLogiikka alempilogiikka;
    private Lautakuuntelija lautakuuntelija;
    private Menukuuntelija menukuuntelija;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    public YlempiLogiikka() {
        this.alempilogiikka = new AlempiLogiikka(this);
        this.lautakuuntelija = new Lautakuuntelija(alempilogiikka);
        this.menukuuntelija = new Menukuuntelija(this);
        uusiIkkuna(true, 16, 16);
    } 
    
    public void uusiRuudukko() {
        ikkuna.poistaNapit(k, l);
        ikkuna.getFraami().validate();
        ikkuna.getFraami().repaint();
        
        ruudukonLuonti(k, l);
        ikkuna.getFraami().validate();
        ikkuna.getFraami().repaint();
    }

    public void uusiRuudukko(int a, int b) {
        ruudukonLuonti(a, b);
    }

    public void uusiIkkuna(boolean ekako, int a, int b) {
        k = a;
        l = b;
        
        if (ekako) {
            ikkuna = new Ikkuna(getMenukuuntelija(), getLautakuuntelija(), k, l);
        } else {
            ikkuna = new Ikkuna(getMenukuuntelija(), getLautakuuntelija(), k, l);
        }
        uusiRuudukko(k, l);
        ikkuna.visible();
    }
    
    public void ruudukonLuonti(int a, int b) {
        this.ruudukko = new Ruutu[a][b];
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                this.ruudukko[i][j] = new Ruutu(ikkuna.luoNappi(i, j));
            }
        }
        
        alempilogiikka.setOnEnsimmainenKlikkaus();
        alempilogiikka.setPeliEiPaattynyt();
    }
    
    public Menukuuntelija getMenukuuntelija() {
        return menukuuntelija;
    }
    
    public Lautakuuntelija getLautakuuntelija() {
        return lautakuuntelija;
    }
    
    public Ikkuna getIkkuna() {
        return ikkuna;
    }
    
    public JButton[][] getNapisto() {
        return ikkuna.getNapisto();
    }
    
    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }
    
    public int getK() {
        return k;
    }
    
    public int getL() {
        return l;
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
}
