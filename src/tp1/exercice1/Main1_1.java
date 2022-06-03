package tp1.exercice1;

import java.util.ArrayList;

public class Main1_1 {
    public static void main(String[] args) {
        RegleSimple r1 = new RegleSimple("P","Q");
        RegleSimple r2 = new RegleSimple("Q","R");
        RegleSimple r3 = new RegleSimple("T","R");
        RegleSimple r4 = new RegleSimple("L","M");

        ArrayList<RegleSimple> bR1 = new ArrayList<>();
        bR1.add(r1); bR1.add(r4); bR1.add(r2); bR1.add(r3);

        ArrayList<String> bF1 = new ArrayList<>();
        bF1.add("P");

        System.out.println(MoteurInference.chainageAvant(bF1, bR1, "M"));

    }
}
