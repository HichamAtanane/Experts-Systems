package tp1.exercice3;
import java.util.ArrayList;

public class Main1_3 {
    public static void main(String[] args) {
        RegleComposee rc1  = new RegleComposee("fleur&graine","phanérogame");
        RegleComposee rc2  = new RegleComposee("phanérogame&graine_nue","sapin");
        RegleComposee rc3  = new RegleComposee("phanérogame&1_cotylédone","monocotylédone");
        RegleComposee rc4  = new RegleComposee("phanérogame&2_cotylédone","dicotylédone");
        RegleComposee rc5  = new RegleComposee("monocotylédone&rhyzome","muguet");
        RegleComposee rc6  = new RegleComposee("dicotylédone","anémone");
        RegleComposee rc7  = new RegleComposee("monocotylédone&non_rhyzome","lilas");
        RegleComposee rc8  = new RegleComposee("feuille&fleur","cryptogame");
        RegleComposee rc9  = new RegleComposee("cryptogame&non_racine","mousse");
        RegleComposee rc10 = new RegleComposee("cryptogame&racine","fougère");
        RegleComposee rc11 = new RegleComposee("non_feuille&plante","thallophyte");
        RegleComposee rc12 = new RegleComposee("thallophyte&chlorophylle","algue");
        RegleComposee rc13 = new RegleComposee("thallophyte&non_chlorophylle","champion");
        RegleComposee rc14 = new RegleComposee("non_feuilles&non_fleur&non_plante","colibacile");

        ArrayList<RegleComposee> bR3 = new ArrayList<>();
        bR3.add(rc1); bR3.add(rc2); bR3.add(rc3);  bR3.add(rc4);  bR3.add(rc5);  bR3.add(rc6);  bR3.add(rc7);
        bR3.add(rc8); bR3.add(rc9); bR3.add(rc10); bR3.add(rc11); bR3.add(rc12); bR3.add(rc13); bR3.add(rc14);

        ArrayList<String> bF3 = new ArrayList<>();
        bF3.add("non_feuille"); bF3.add("chlorophylle");
        bF3.add("fleur");       bF3.add("graine");
        bF3.add("plante");

        System.out.println(MoteurInference.chainageAvantComp(bF3, bR3));
    }
}
