package seasweeper.gui;

import javax.swing.ImageIcon;

/**
 *
 * @author ez
 */
public class Kuvaluokka {
    private final ImageIcon kuvat[];
    private final ImageIcon miina;
    private final ImageIcon lippu;
    private final ImageIcon tummavesi;

    public Kuvaluokka() {
        this.kuvat = new ImageIcon[9];
        for (int i = 0; i < 9; i++) {
            kuvat[i] = new ImageIcon(getClass().getClassLoader().getResource("icons/" + i + ".png"));
        }
        this.miina = new ImageIcon(getClass().getClassLoader().getResource("icons/miina.png"));
        this.lippu = new ImageIcon(getClass().getClassLoader().getResource("icons/lippu.png"));
        this.tummavesi = new ImageIcon(getClass().getClassLoader().getResource("icons/tummavesi.png"));
    }
    
    public ImageIcon getKuva(String kuva) { 
        switch (kuva) {
            case "miina.png":
                return miina;
            case "lippu.png":
                return lippu;
            case "tummavesi.png":
                return tummavesi;
            default:
                String[] osat = kuva.split("\\.");
                return kuvat[Integer.parseInt(osat[0])];
        }
    }
}
