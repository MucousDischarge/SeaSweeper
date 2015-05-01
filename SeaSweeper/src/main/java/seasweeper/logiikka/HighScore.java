package seasweeper.logiikka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 *
 * @author ez
 */
public class HighScore {

    private String[][] highscore;
    private boolean muutoksiako;
    private File tiedosto;

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

    public void lisaa(String nimi, String aika) throws FileNotFoundException, IOException {
        for (int i = 0; i < highscore.length; i++) {
            String[] osat1 = highscore[i][1].split(":");
            String[] osat2 = aika.split(":");
            if (Integer.parseInt(osat1[0]) > Integer.parseInt(osat2[0])) {
                highscore[i][0] = nimi;
                highscore[i][1] = aika;
                muutoksiako = true;
                break;
            }

            if (Integer.parseInt(osat1[0]) == Integer.parseInt(osat2[0])) {
                if (Integer.parseInt(osat1[1]) > Integer.parseInt(osat2[1])) {
                    highscore[i][0] = nimi;
                    highscore[i][1] = aika;
                    muutoksiako = true;
                    break;
                }
            }
        }

        if (muutoksiako) {
            kirjoita();
        }
    }

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

    public void kirjoita() throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(tiedosto.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(kokoaTaulu());
        bw.close();
    }

    public String kokoaTaulu() {
        String palautettava = "";
        for (int i = 0; i < highscore.length; i++) {
            palautettava += highscore[i][0] + "~" + highscore[i][1] + "\n";
        }
        return palautettava;
    }
}
