package seasweeper.logiikka;

import seasweeper.gui.Ikkuna;
import seasweeper.gui.Lautakuuntelija;
import seasweeper.gui.Menukuuntelija;

/**
 *
 * @author ez
 */
public final class YlempiLogiikka {

    private Ikkuna ikkuna;
    private final AlempiLogiikka alempilogiikka;
    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    public YlempiLogiikka() {
        this.alempilogiikka = new AlempiLogiikka(this);
        this.lautakuuntelija = new Lautakuuntelija(alempilogiikka);
        this.menukuuntelija = new Menukuuntelija(this);
        uusiIkkuna(true, 16, 16);
    }
    
    public void uusiIkkuna(boolean ekako, int a, int b) {
        k = a;
        l = b;
        
        if (ekako) {
            ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l);
        } else {
            ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l);
        }
        uusiRuudukko(k, l);
        ikkuna.visible();
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
    
    public void ruudukonLuonti(int a, int b) {
        this.ruudukko = new Ruutu[a][b];
        
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                this.ruudukko[i][j] = new Ruutu(ikkuna.luoNappi(i, j));
            }
        }
        alempilogiikka.setArvot(ruudukko, k, l);
    }
    
    public void kuva(String kuva, int a, int b) {
        ikkuna.kuva(kuva, a, b);
    }
    
    public Ikkuna getIkkuna() {
        return ikkuna;
    }
    
    public Object getNappi(int a, int b) {
        return ikkuna.getNappi(a, b);
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
}
