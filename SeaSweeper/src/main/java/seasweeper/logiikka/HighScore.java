package seasweeper.logiikka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 *
 * Hoitaa pelitilastotoiminnot, eli lukee tekstitiedostoja ja kirjoittaa niihin.
 */
public class HighScore {

    private final String[][] highscore;
    private boolean muutoksiako;
    private final File tiedosto;

    /**
     * Konstruktorin yhteydessä annetaan selvennys vaikeustasosta: eli joko keskitaso
     * tai vaikea; jonka perusteella luetaan kyseinen tiedosto.
     * 
     * @param vaikeako Boolean, jonka perusteella valitaan keskitaso tai vaikea.
     * @throws IOException
     * @throws URISyntaxException
     */
    public HighScore(Boolean vaikeako) throws IOException, URISyntaxException {
        this.highscore = new String[10][2];
        this.muutoksiako = false;
        if (vaikeako) {
            this.tiedosto = new File(getClass().getClassLoader().getResource("highscorevaikea.txt").toURI());
        } else {
            this.tiedosto = new File(getClass().getClassLoader().getResource("highscorekeskitaso.txt").toURI());
        }
        lue();
    }

    /**
     * Pistetilastoon lisätään uusi nimi uudella ajalla, jos aika päihittää jonkin aiemmista
     * ajoista - ja nimi lisätään aina parhausjärjestyksessä ylhäältä alas.
     * 
     * @param nimi Uuden ajan nimi.
     * @param aika Uuden ajan aika.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lisaa(String nimi, String aika) throws FileNotFoundException, IOException {
        for (int i = 0; i < highscore.length; i++) {
            String[] vanha = highscore[i][1].split(":");
            String[] uusi = aika.split(":");
            int V0 = Integer.parseInt(vanha[0]);
            int V1 = Integer.parseInt(vanha[1]);
            int U0 = Integer.parseInt(uusi[0]);
            int U1 = Integer.parseInt(uusi[1]);
            
            if (U0 < V0) {
                lisaaSiistija(i, nimi, aika);
                break;
            }

            if (U0 == V0) {
                if (U1 < V1) {
                    lisaaSiistija(i, nimi, aika);
                    break;
                }
            }
        }

        if (muutoksiako) {
            kirjoita();
        }
        muutoksiako = false;
    }

    /**
     * Lisayksen siistija, jossa lisayksen osio, jossa juuri laitetaan tilastoon uusi aika.
     * 
     * @param i Pistetilaston kohta.
     * @param nimi Uusi nimi. 
     * @param aika Uusi aika.
     */
    private void lisaaSiistija(int i, String nimi, String aika) {
        if (eiLiianPitkaTaiLyhyt(nimi)) {
            highscore[i][0] = nimi;
        } else {
            highscore[i][0] = uusiNimi(nimi);
        }
        highscore[i][1] = aika;
        muutoksiako = true;
    }

    /**
     * Luetaan pistetilastotiedosto.
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lue() throws FileNotFoundException, IOException {
        Scanner skanneri = new Scanner(tiedosto);
        int luku = 0;
        while (skanneri.hasNextLine()) {
            String rivi = skanneri.nextLine();
            String[] osat = rivi.split("~");
            highscore[luku][0] = osat[0];
            highscore[luku][1] = osat[1];
            luku++;
        }
        skanneri.close();
    }

    /**
     * Itse tiedostoon kirjoittaminen.
     * 
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void kirjoita() throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(tiedosto.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(kokoaTaulu());
        bw.close();
    }

    /**
     * Yhden Stringin kokoaminen pistetilastotiedoston tekstimassasta.
     * 
     * @return Haluttu yksi String pistetilastosta.
     */
    public String kokoaTaulu() {
        String palautettava = "";
        for (int i = 0; i < highscore.length; i++) {
            palautettava += highscore[i][0] + "~" + highscore[i][1] + "\n";
        }
        return palautettava;
    }

    /**
     * Tarkistetaan, ettei annettu nimi ole liian pitkä tai lyhyt.
     * 
     * @param nimi Annettu nimi.
     * @return Onko vai ei sopiva nimi.
     */
    private boolean eiLiianPitkaTaiLyhyt(String nimi) {
        return !(nimi.equals("")) && nimi.length() <= 30;
    }

    /**
     * Epäkelvon nimen tapauksessa muokataan nimeä.
     * 
     * @param nimi Annettu nimi.
     * @return Muokattu nimi.
     */
    private String uusiNimi(String nimi) {
        if (nimi.equals("")) {
            return "anon";
        } else {
            return nimi.substring(0, 30);
        }
    }
}
