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
        uusiIkkuna(16, 16);
    }

    /**
     * Luodaan uusi ikkuna joko pelin alussa tai vaikeustasoa vaihtaessa 
     * - samalla luodaan ruudukko ja pistetaululuokat.
     * @param a
     * @param b
     * @throws IOException
     * @throws URISyntaxException
     */
    public void uusiIkkuna(int a, int b) throws IOException, URISyntaxException {
        k = a;
        l = b;

        ikkuna = new Ikkuna(menukuuntelija, lautakuuntelija, k, l, keskitasotaulu, vaikeataulu, kello);

        uusiRuudukko(k, l);
        ikkuna.visible();
    }

    /**
     * Piirretään uusi ruudukko ruuduista ja jbuttoneista.
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
        napinpainallus.setArvot(ruudukko, k, l);
    }

    /**
     * Uusi ruudukko resetoituessa; eli piirretään vain uusi ruudukko,
     * tuhoamatta ikkunaa.
     */
    public void resetUusiRuudukko() {
        if (!(napinpainallus.getOnkoEnsimmainenKlikkaus())) {
            ikkuna.poistaNapit(k, l);
            if (k != 8) {
                ikkuna.nollaaAika();
            }

            uusiRuudukko(k, l);
            ikkuna.piirraUudelleen();
        }
    }
    
    /**
     * Menukuuntelija kutsuu tämän, käyttäjän vaihtaessa vaikeustaso ja ikkunaa.
     */
    public void ikkunaDispose() {
        ikkuna.tuhoa();
    }

    /**
     * Ensimmainen klikkaus aloittaa kellon; tämä kutsutaan 
     * lautakuuntelijan kutsuessa vasenta klikkausmetodia alempilogiikassa.
     */
    public void startKello() {
        ikkuna.aloitaAjanlasku();
    }
    
    //rajahti tai voitit: kaksi pelin loppua
    
    /**
     * Alempilogiikasta tulee metodikutsu, joka ohjautuu ikkunaluokkaan ja avaa
     * miinaloppuikkunan.
     */
    public void rajahti() {
        ikkuna.rajahti();
    }

    /**
     * Alempilogiikasta tulee hyvin paljon rajahtamisen tapaan metodikutsu.
     * @throws IOException
     */
    public void voitit() throws IOException {
        ikkuna.voitit();
    }
    
    /**
     * Alempilogiikka käskee ylempilogiikan kautta ikkunaa laittamaan haluamansa 
     * kuvan antamillensa arvojen määrittämälle sijainnille.
     * @param kuva
     * @param a
     * @param b
     */
    public void kuva(String kuva, int a, int b) {
        ikkuna.kuva(kuva, a, b);
    }

    /**
     * Menukuuntelija kutsuu ikkunaa popauttamaan pistetilastoikkunan auki
     * käyttäjän klikatessa sitä menunapistossa.
     */
    public void highscoreIkkuna() {
        ikkuna.highscore();
    }
    
    public void paivitaAika(String aika) throws IOException {
        ikkuna.paivitaAika(aika);
    }

    // TESTEJÄ VARTEN OLEVAT METODIT
}
