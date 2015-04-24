package seasweeper.logiikka;

import seasweeper.gui.Ikkuna;

/**
 *
 * @author ez
 */
public final class YlempiLogiikka {

    private Ikkuna ikkuna;
    private AlempiLogiikka alempilogiikka;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;
    private String vaikeustaso;

    public YlempiLogiikka() {
        this.k = 16;
        this.l = 16;
        this.ruudukko = new Ruutu[k][l];
        this.alempilogiikka = new AlempiLogiikka(ruudukko, k, l);
        ikkuna = new Ikkuna("Keskitaso", alempilogiikka);
        uusiIkkuna(true);
    }

    public YlempiLogiikka(String vaikeustaso) {
        this.vaikeustaso = vaikeustaso;
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
        this.ruudukko = new Ruutu[k][l];
        this.alempilogiikka = new AlempiLogiikka(ruudukko, k, l);
        uusiIkkuna(false);
    }

    public void uusiRuudukko(boolean ekako) {
        //mahdollisuus laudan uusimisille ilman uuden ikkunan luomista
        //en tieda miten kutsua tätä metodia menukuuntelijassa
        
        //if (false) {
        //    for (int i = 0; i < k; i++) {
        //        for (int j = 0; j < l; j++) {
        //            ikkuna.poistaNappi(i, j);
        //        }
        //   }
        //}
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                ruudukko[i][j] = new Ruutu(i, j, ikkuna.luoNappi(i, j));
            }
        }

    }

    public void uusiIkkuna(boolean ekako) {
        if (ekako) {
            ikkuna = new Ikkuna("Keskitaso", alempilogiikka);
        } else {
            ikkuna = new Ikkuna(vaikeustaso, alempilogiikka);
        }
        uusiRuudukko(ekako);
        ikkuna.visible();
    }
    
    // TESTEJÄ VARTEN OLEVAT METODIT
    public int getK() {
        return k;
    }
    
    public int getL() {
        return l;
    }
    
    public String getVaikeustaso() {
        return vaikeustaso;
    }
}
