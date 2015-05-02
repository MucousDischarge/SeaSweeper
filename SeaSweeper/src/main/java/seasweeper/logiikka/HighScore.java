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
 * Hoitaa pelitilastotoiminnot, eli lukee tekstitiedostoja ja kirjoittaa niihin
 */
public class HighScore {

    private final String[][] highscore;
    private boolean muutoksiako;
    private final File tiedosto;

    /**
     *
     * @param vaikeako
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
     *
     * @param nimi
     * @param aika
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

    public void lisaaSiistija(int i, String nimi, String aika) {
        if (eiLiianPitkaTaiLyhyt(nimi)) {
            highscore[i][0] = nimi;
        } else {
            highscore[i][0] = uusiNimi(nimi);
        }
        highscore[i][1] = aika;
        muutoksiako = true;
    }

    /**
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
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void kirjoita() throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(tiedosto.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(kokoaTaulu());
        bw.close();
    }

    /**
     *
     * @return
     */
    public String kokoaTaulu() {
        String palautettava = "";
        for (int i = 0; i < highscore.length; i++) {
            palautettava += highscore[i][0] + "~" + highscore[i][1] + "\n";
        }
        return palautettava;
    }

    public boolean eiLiianPitkaTaiLyhyt(String nimi) {
        return !(nimi.equals("")) && nimi.length() <= 30;
    }

    public String uusiNimi(String nimi) {
        if (nimi.equals("")) {
            return "anon";
        } else {
            return nimi.substring(0, 30);
        }
    }
}
