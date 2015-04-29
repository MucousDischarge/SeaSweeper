package seasweeper.gui;

import javax.swing.ImageIcon;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ez
 */
public class KuvaluokkaTest {
    private Kuvaluokka kuvaluokka;
    
    public KuvaluokkaTest() {
        this.kuvaluokka = new Kuvaluokka();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testGetKuvaMiina() {
        ImageIcon miina = kuvaluokka.getKuva("miina");
        assertEquals(getClass().getClassLoader().getResource("icons/miina.png").toString(), miina.toString());
    }
    
    @Test
    public void testGetKuvaLippu() {
        ImageIcon lippu = kuvaluokka.getKuva("lippu");
        assertEquals(getClass().getClassLoader().getResource("icons/lippu.png").toString(), lippu.toString());
    }
    
    @Test
    public void testGetKuvaTummavesi() {
        ImageIcon tummavesi = kuvaluokka.getKuva("tummavesi");
        assertEquals(getClass().getClassLoader().getResource("icons/tummavesi.png").toString(), tummavesi.toString());
    }
    
    @Test
    public void testGetKuvaNolla() {
        ImageIcon nolla = kuvaluokka.getKuva("0");
        assertEquals(getClass().getClassLoader().getResource("icons/0.png").toString(), nolla.toString());
    }
    
    @Test
    public void testGetKuvaYksi() {
        ImageIcon yksi = kuvaluokka.getKuva("1");
        assertEquals(getClass().getClassLoader().getResource("icons/1.png").toString(), yksi.toString());
    }
    
    @Test
    public void testGetKuvaKaksi() {
        ImageIcon kaksi = kuvaluokka.getKuva("2");
        assertEquals(getClass().getClassLoader().getResource("icons/2.png").toString(), kaksi.toString());
    }
    
    @Test
    public void testGetKuvaKolme() {
        ImageIcon kolme = kuvaluokka.getKuva("3");
        assertEquals(getClass().getClassLoader().getResource("icons/3.png").toString(), kolme.toString());
    }
    
    @Test
    public void testGetKuvaNelja() {
        ImageIcon nelja = kuvaluokka.getKuva("4");
        assertEquals(getClass().getClassLoader().getResource("icons/4.png").toString(), nelja.toString());
    }
    
    @Test
    public void testGetKuvaViisi() {
        ImageIcon viisi = kuvaluokka.getKuva("5");
        assertEquals(getClass().getClassLoader().getResource("icons/5.png").toString(), viisi.toString());
    }
    
    @Test
    public void testGetKuvaKuusi() {
        ImageIcon kuusi = kuvaluokka.getKuva("6");
        assertEquals(getClass().getClassLoader().getResource("icons/6.png").toString(), kuusi.toString());
    }
    
    @Test
    public void testGetKuvaSeitseman() {
        ImageIcon seitseman = kuvaluokka.getKuva("7");
        assertEquals(getClass().getClassLoader().getResource("icons/7.png").toString(), seitseman.toString());
    }
    
    @Test
    public void testGetKuvaKahdeksan() {
        ImageIcon kahdeksan = kuvaluokka.getKuva("8");
        assertEquals(getClass().getClassLoader().getResource("icons/8.png").toString(), kahdeksan.toString());
    }
}
