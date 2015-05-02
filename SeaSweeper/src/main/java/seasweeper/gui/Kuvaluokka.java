package seasweeper.gui;

import javax.swing.ImageIcon;

/**
 * Kuvien luokka; palauttaa pyynnöstä ImageIconit kuvista.
 */
public class Kuvaluokka {
    private final ImageIcon kuvat[];
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;

    /**
     * Konstruktorin yhteydessä annetaan kuvien sijainti.
     */
    public Kuvaluokka() {
        this.kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon(getClass().getClassLoader().getResource("icons/" + i + ".png"));
        }
        this.miina = new ImageIcon(getClass().getClassLoader().getResource("icons/miina.png"));
        this.lippu = new ImageIcon(getClass().getClassLoader().getResource("icons/lippu.png"));
        this.tummavesi = new ImageIcon(getClass().getClassLoader().getResource("icons/tummavesi.png"));
    }
    
    /**
     * Ikkuna kutsuu kuvaluokasta ImageIconin tämän metodin kautta, joka palauttaa
     * parametrinä annetun Stringin perusteella halutun kuvan.
     * 
     * @param kuva Tulleen metodikutsun yhteydessä annettu haluttu kuva.
     * @return Palautetaan haluttu kuva ImageIconina.
     */
    public ImageIcon getKuva(String kuva) { 
        switch (kuva) {
            case "miina":
                return miina;
            case "lippu":
                return lippu;
            case "tummavesi":
                return tummavesi;
            default:
                return kuvat[Integer.parseInt(kuva)];
        }
    }
}
