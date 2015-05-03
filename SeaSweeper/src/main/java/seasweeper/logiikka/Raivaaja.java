package seasweeper.logiikka;

/**
 *
 * Suorittaa miinattoman ruudun klikkausta seuraavan raivauksen.
 */
public class Raivaaja {

    private final Napinpainallus napinpainallus;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    /**
     * Annetaan konstruktorissa yhteys napinpainallusluokkaan.
     *
     * @param napinpainallus Napinpainallusluokka.
     */
    public Raivaaja(Napinpainallus napinpainallus) {
        this.napinpainallus = napinpainallus;
    }

    /**
     * Miinattoman ruudun raivaus, joka klikkauksesta tai leviämisestä.
     *
     * @param a Raivattavan ruudun korkeussijainti.
     * @param b Raivattavan ruudun leveyssijainti.
     */
    public void raivaus(int a, int b) {
        if (tarkista(a, b)) {
            if (!(ruudukko[a][b].onkoRaivattu())) {
                int[][] x = luoLista(a, b);
                int luku = laskeLuku(x);

                ruudukko[a][b].kuva(String.valueOf(luku));

                napinpainallus.lisaaRaivattu();
                ruudukko[a][b].onRaivattu();

                rekursioRaivaus(luku, x);
            }
        }
    }

    /**
     * Nollaa klikattua leviava rekursioraivaus.
     * 
     * @param luku Käytetään tarkistamaan onko ruutu kelvollinen rekursioraivaukselle.
     * @param x Ruudun läheiset ruudut, joihin mahdollisesti leviää.
     */
    private void rekursioRaivaus(int luku, int[][] x) {
        if (luku == 0) {
            for (int i = 0; i < 8; i++) {
                if (leviaakoSinne(x[i][0], x[i][1])) {
                    raivaus(x[i][0], x[i][1]);
                }
            }
        }
    }

    /**
     * Siivoojametodi rekursioleviamisen tarkistamiselle.
     *
     * @param a Leviämiskohteena olevan ruudun korkeussijainti.
     * @param b Leviämiskohteena olevan ruudun leveyssijainti.
     * @return Onko kelvollinen leviamiselle.
     */
    private boolean leviaakoSinne(int a, int b) {
        return tarkista(a, b) && !(ruudukko[a][b].onkoRaivattu());
    }

    /**
     * Laaditaan lista ruudun läheisistä ruuduista.
     * 
     * @param a Raivattavan ruudun korkeussijainti.
     * @param b Raivattavan ruudun leveyssijainti.
     * @return Palautetaan lista.
     */
    private int[][] luoLista(int a, int b) {
        int[][] lista = new int[8][2];

        lista[0][0] = a;
        lista[0][1] = b + 1;
        lista[1][0] = a;
        lista[1][1] = b - 1;
        lista[2][0] = a + 1;
        lista[2][1] = b;
        lista[3][0] = a - 1;
        lista[3][1] = b;
        lista[4][0] = a + 1;
        lista[4][1] = b + 1;
        lista[5][0] = a - 1;
        lista[5][1] = b - 1;
        lista[6][0] = a + 1;
        lista[6][1] = b - 1;
        lista[7][0] = a - 1;
        lista[7][1] = b + 1;

        return lista;
    }

    /**
     * Lasketaan ruudun läheisten miinojen määrä, käyttämällä hyväksi aiempaa
     * läheisten ruutujen listaa.
     * 
     * @param x Ruudun läheisten ruutujen lista.
     * @return Palautetaan läheisten miinojen määrä.
     */
    private int laskeLuku(int[][] x) {
        int luku = 0;

        for (int i = 0; i < 8; i++) {
            if (tarkista(x[i][0], x[i][1]) && ruudukko[x[i][0]][x[i][1]].onkoMiina()) {
                luku++;
            }
        }

        return luku;
    }

    /**
     * Tarkistetaan onko korkeus- ja leveyssijainti kelvollisia, joka on tärkeää
     * tietää tarkistaessa ruudun läheisiä ruutuja.
     * 
     * @param a Korkeussijainti.
     * @param b Leveyssijainti.
     * @return Onko pelilaudan osa vai ei.
     */
    private boolean tarkista(int a, int b) {
        return a <= k - 1 && a >= 0 && b <= l - 1 && b >= 0;
    }

    /**
     * Uusia ruudukkoja laatiessa raivaajan arvot muutetaan usein.
     * 
     * @param ruudukko Uusi ruudukko.
     * @param k Pelilaudan korkeus.
     * @param l Pelilaudan leveys.
     */
    public void setArvot(Ruutu[][] ruudukko, int k, int l) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
    }
}
