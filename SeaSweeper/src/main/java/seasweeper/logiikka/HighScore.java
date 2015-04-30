package seasweeper.logiikka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author ez
 */
public class HighScore {

    private String[][] highscore;
    private boolean muutoksiako;
    private String tiedosto;

    public HighScore() throws IOException {
        this.highscore = new String[10][2];
        this.muutoksiako = false;
        this.tiedosto = getClass().getClassLoader().getResource("highscore.txt").toString();
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
        try (FileReader tiedostolukija = new FileReader(tiedosto)) {
            BufferedReader lukija = new BufferedReader(tiedostolukija);
            String rivi = lukija.readLine();
            int luku = 0;
            while (rivi != null) {
                String[] osat = rivi.split("-");
                highscore[luku][0] = osat[0];
                highscore[luku][1] = osat[1];
                luku++;
            }
        }
    }

    public void kirjoita() throws FileNotFoundException, IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(tiedosto)))) {
            writer.write(kokoaKirjoitettava());
        }
    }
    
    public String kokoaKirjoitettava() {
        String palautettava = "";
        for (int i = 0; i < highscore.length; i++) {
            palautettava += highscore[i][0] + "-" + highscore[i][1] + "\n";
        }
        return palautettava;
    }
}
