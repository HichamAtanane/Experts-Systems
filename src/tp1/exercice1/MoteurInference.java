package tp1.exercice1;

import java.util.ArrayList;

public class MoteurInference {
    public MoteurInference() {
    }

    //---------------------------------------------------------------------------------------------------------------------------------------

    public static boolean chainageAvant(ArrayList<String> baseFaits, ArrayList<RegleSimple> baseRegles, String propVerif) {
        ArrayList<RegleSimple> baseReglesCopy = new ArrayList<>(baseRegles);
        int c = baseRegles.size();
        while (!baseFaits.contains(propVerif) && !baseRegles.isEmpty()){
            for (RegleSimple regle: baseReglesCopy) {
                if (baseFaits.contains(regle.getPremisse()) && !baseFaits.contains(regle.getConclusion())) {
                    baseFaits.add(regle.getConclusion());
                    baseRegles.remove(regle);
                }
            }
            if (c == baseRegles.size()){
                break;
            }
            c = baseRegles.size();
        }
//        vérifier si elle s’est arrêtée parce que la propVerif est retrouvée dans la liste des baseFaits ou non
        return baseFaits.contains(propVerif);
    }
}