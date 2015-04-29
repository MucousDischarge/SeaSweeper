package seasweeper.logiikka;

/**
 *
 * @author ez
 */
public class Raivaaja {

    private final YlempiLogiikka ylempilogiikka;
    private Ruutu[][] ruudukko;
    private int k;
    private int l;

    public Raivaaja(YlempiLogiikka ylempilogiikka) {
        this.ylempilogiikka = ylempilogiikka;
    }
    
    public void rajahti() {
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < l; y++) {
                if (ruudukko[x][y].onkoMiina()) {
                    ylempilogiikka.kuva("miina", x, y);
                }
            }
        }
    }

    public void raivaus(int a, int b, boolean alaLevia) {
        if (tarkista(a, b)) {
            int[][] x = luoLista(a, b);
            int luku = laskeLuku(x);

            ylempilogiikka.kuva(String.valueOf(luku), a, b);

            ruudukko[a][b].onRaivattu();

            if (!(alaLevia) && !(luku > 0)) {
                for (int i = 0; i < 8; i++) {
                    if (leviaako(x[i][0], x[i][1])) {
                        int[][] uusiLista = luoLista(x[i][0], x[i][1]);
                        if (laskeLuku(uusiLista) == 0) {
                            raivaus(x[i][0], x[i][1], false);
                        } else {
                            raivaus(x[i][0], x[i][1], true);
                        }
                    }
                }
            }
        }
    }
    
    public boolean leviaako(int a, int b) {
        return tarkista(a, b) && !(ruudukko[a][b].onkoMiina()) && !(ruudukko[a][b].onkoRaivattu());
    }

    public int[][] luoLista(int a, int b) {
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

    public int laskeLuku(int[][] x) {
        int luku = 0;

        for (int i = 0; i < 8; i++) {
            if (tarkista(x[i][0], x[i][1]) && ruudukko[x[i][0]][x[i][1]].onkoMiina()) {
                luku++;
            }
        }

        return luku;
    }

    public boolean tarkista(int a, int b) {
        return a <= k - 1 && a >= 0 && b <= l - 1 && b >= 0;
    }

    public void setArvot(Ruutu[][] ruudukko, int k, int l) {
        this.ruudukko = ruudukko;
        this.k = k;
        this.l = l;
    }
}
