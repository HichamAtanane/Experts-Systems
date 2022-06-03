package tp2.exercice1;

import java.util.ArrayList;

public class Main2_1 {
    public static void main(String[] args) {
        RegleSimple r1 = new RegleSimple("P","Q");
        RegleSimple r2 = new RegleSimple("Q5","R");
        RegleSimple r3 = new RegleSimple("T","R");
        RegleSimple r4 = new RegleSimple("L","M");

        ArrayList<String> bF1 = new ArrayList<>();
        ArrayList<RegleSimple> bR1 = new ArrayList<>();

        bR1.add(r1);
        bR1.add(r3);
        bR1.add(r4);
        bR1.add(r2);

        bF1.add("P");

        System.out.println("Exercice2 chainage arriere");
        System.out.println(MoteurInference.chainageArriere(bF1, bR1, "R"));

    }
}
