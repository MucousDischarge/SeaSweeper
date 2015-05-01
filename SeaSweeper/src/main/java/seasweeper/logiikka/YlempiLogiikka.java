package seasweeper.logiikka;

import java.io.IOException;
import java.net.URISyntaxException;
import seasweeper.gui.Ikkuna;
import seasweeper.gui.Lautakuuntelija;
import seasweeper.gui.Menukuuntelija;

/**
 *
 * Ylemmän tason ohjelmatoiminnot ja logiikka
 */
public final class YlempiLogiikka {

    private final AlempiLogiikka alempilogiikka;
    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private HighScore keskitasotaulu;
    private HighScore vaikeataulu;
    private Ikkuna ikkuna;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public YlempiLogiikka() throws IOException, URISyntaxException {
        this.alempilogiikka = new AlempiLogiikka(this);
        this.lautakuuntelija = new Lautakuuntelija(alempilogiikka);
        this.menukuuntelija = new Menukuuntelija(this);
        uusiIkkuna(true, 16, 16);
    }

    /**
     *
     * @param ekako
     * @param a
     * @param b
     * @throws IOException
     * @throws URISyntaxException
     */
    public void uusiIkkuna(boolean ekako, int a, int b) throws IOException, URISyntaxException {
        k = a;
        l = b;
        
        
        this.keskitasotaulu = new HighScore(false);
        this.vaikeataulu = new HighScore(true);

        if (ekako) {
            ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l, keskitasotaulu, vaikeataulu);
        } else {
            ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l, keskitasotaulu, vaikeataulu);
        }
        uusiRuudukko(k, l);
        ikkuna.visible();
    }

    /**
     *
     * @param a
     * @param b
     */
    public void uusiRuudukko(int a, int b) {
        this.ruudukko = new Ruutu[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                this.ruudukko[i][j] = new Ruutu(ikkuna.luoNappi(i, j));
            }
        }
        alempilogiikka.setArvot(ruudukko, k, l);
    }

    /**
     *
     */
    public void resetUusiRuudukko() {
        if (!(alempilogiikka.getOnkoEnsimmainenKlikkaus())) {
            ikkuna.poistaNapit(k, l);
            if (k != 8) {
                ikkuna.nollaaAika();
            }
            ikkuna.getFraami().validate();
            ikkuna.getFraami().repaint();

            uusiRuudukko(k, l);
            ikkuna.getFraami().validate();
            ikkuna.getFraami().repaint();
        }
    }

    /**
     *
     * @return
     */
    public Ikkuna getIkkuna() {
        return ikkuna;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public Object getNappi(int a, int b) {
        return ikkuna.getNappi(a, b);
    }

    /**
     *
     */
    public void startKello() {
        ikkuna.ajanPaivittaja();
    }

    /**
     *
     */
    public void rajahti() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (ruudukko[x][y].onkoMiina()) {
                    kuva("miina", x, y);
                }
            }
        }
        
        ikkuna.rajahti();
    }
    
    
    /**
     *
     * @param kuva
     * @param a
     * @param b
     */
    public void kuva(String kuva, int a, int b) {
        ikkuna.kuva(kuva, a, b);
    }

    /**
     *
     * @throws IOException
     */
    public void voitit() throws IOException {
        ikkuna.voitit();
    }

    /**
     *
     */
    public void highscoreIkkuna() {
        ikkuna.highscore();
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
}
