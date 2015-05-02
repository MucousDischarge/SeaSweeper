package seasweeper.logiikka;

import java.io.IOException;
import java.net.URISyntaxException;
import seasweeper.gui.Ikkuna;
import seasweeper.gui.Lautakuuntelija;
import seasweeper.gui.Menukuuntelija;

/**
 *
 * Ylimmän tason ohjelmatoiminnot ja logiikka.
 */
public final class YlinLogiikka {

    private final Napinpainallus napinpainallus;
    private final Lautakuuntelija lautakuuntelija;
    private final Menukuuntelija menukuuntelija;
    private final HighScore keskitasotaulu;
    private final HighScore vaikeataulu;
    private final Kello kello;
    private Ikkuna ikkuna;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    /**
     * Luodaan luokat ja perustason 16x16-lauta aluksi konstruktorissa.
     * 
     * @throws IOException
     * @throws URISyntaxException
     */
    public YlinLogiikka() throws IOException, URISyntaxException {
        this.napinpainallus = new Napinpainallus(this);
        this.lautakuuntelija = new Lautakuuntelija(napinpainallus);
        this.menukuuntelija = new Menukuuntelija(this);
        this.keskitasotaulu = new HighScore(false);
        this.vaikeataulu = new HighScore(true);
        this.kello = new Kello(this);
        uusiIkkuna(true, 16, 16);
    }

    /**
     * Luodaan uusi ikkuna joko pelin alussa tai vaikeustasoa vaihtaessa,
     * ja samalla luodaan ruudukko ja pistetaululuokat - ikkunaluokka luodaan vain
     * kerran alussa, ja sen jälkeen kutsutaan vain uutta fraamia.
     * 
     * @param ekako Tarkistetaan onko ensimmäinen kutsukerta.
     * @param a Pelilaudan korkeus.
     * @param b Pelilaudan leveys.
     * @throws IOException
     * @throws URISyntaxException
     */
    public void uusiIkkuna(boolean ekako, int a, int b) throws IOException, URISyntaxException {
        k = a;
        l = b;
        if (ekako) {
            ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l, keskitasotaulu, vaikeataulu, kello);
        } else {
            ikkuna.newFraami(k, l);
        }
        uusiRuudukko(k, l);
        ikkuna.visible();
    }

    /**
     * Piirretään uusi ruudukko ruuduista ja jbuttoneista.
     * 
     * @param a Pelilaudan korkeus.
     * @param b Pelilaudan leveys.
     */
    public void uusiRuudukko(int a, int b) {
        this.ruudukko = new Ruutu[a][b];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                this.ruudukko[i][j] = new Ruutu(ikkuna.luoNappi(i, j), ikkuna);
            }
        }
        napinpainallus.setArvot(ruudukko, k, l);
    }

    /**
     * Uusi ruudukko resetoidessa; eli piirretään vain uusi ruudukko tuhoamatta ikkunaa.
     */
    public void resetUusiRuudukko() {
        if (!(napinpainallus.getOnkoEnsimmainenKlikkaus())) {
            ikkuna.poistaNapit();
            if (k != 8) {
                ikkuna.nollaaAika();
            }

            uusiRuudukko(k, l);
            ikkuna.piirraUudelleen();
        }
    }
    
    /**
     * Menukuuntelija kutsuu tämän, käyttäjän vaihtaessa vaikeustasoa ja ikkunaa.
     */
    public void ikkunaDispose() {
        ikkuna.tuhoa();
    }

    /**
     * Ensimmainen klikkaus aloittaa kellon; tämä kutsutaan 
     * lautakuuntelijan kutsuessa vasenta klikkausmetodia napinpainallusluokassa.
     */
    public void startKello() {
        ikkuna.aloitaAjanlasku();
    }
    
    //rajahti tai voitit: kaksi pelin loppua
    
    /**
     * Napinpainallusluokasta tulee metodikutsu, joka ohjautuu ikkunaluokkaan 
     * ja avaa miinaloppuikkunan.
     */
    public void rajahti() {
        ikkuna.rajahti();
    }

    /**
     * Napinpainallusluokasta tulee rajahtamisen tapaan metodikutsu.
     * 
     * @throws IOException
     */
    public void voitit() throws IOException {
        ikkuna.voitit();
    }

    /**
     * Menukuuntelija kutsuu ikkunaa popauttamaan pistetilastoikkunan auki
     * käyttäjän klikatessa sitä menunapistossa.
     */
    public void highscoreIkkuna() {
        ikkuna.highscore();
    }
    
    /**
     * Kellon timer päivittää ikkunaluokan näkyvän graafisen kellon joka sekunti,
     * ylimmän logiikan kautta.
     * 
     * @param aika Uusi näkyvä aika.
     * @throws IOException
     */
    public void paivitaAika(String aika) throws IOException {
        ikkuna.paivitaAika(aika);
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
    
    /**
     * Testimetodi.
     * 
     * @return
     */
        
    public Ikkuna getIkkuna() {
        return ikkuna;
    }
}
