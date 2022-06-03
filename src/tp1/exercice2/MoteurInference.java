package tp1.exercice2;

import java.util.ArrayList;

public class MoteurInference {
    public MoteurInference() {
    }
    public static boolean chainageAvantComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseRegles, String propVerif) {
        ArrayList<RegleComposee> baseReglesCopy = new ArrayList<>(baseRegles);
        int c = baseRegles.size();
        while (!baseFaits.contains(propVerif) && !baseRegles.isEmpty()){
            for (RegleComposee regle: baseReglesCopy) {
                boolean toutExiste = true;
                for (String premisse: regle.getPremisse()){
                    if (!baseFaits.contains(premisse)) {
                        toutExiste = false;
                        break;
                    }
                }
                if (toutExiste) {
//                  ne pas ajouter un doublon
                    if (!baseFaits.contains(regle.getConclusion())) {
                        baseFaits.add(regle.getConclusion());
                    }
                    baseRegles.remove(regle);
                }
            }
//          verifier si on a deja parcouru toutes les regles restantes sans trouver une solution
            if (c == baseRegles.size()){
                break;
            }
            c = baseRegles.size();
        }
//        vérifier si elle s’est arrêtée parce que la propVerif est retrouvée dans la liste des baseFaits ou non
        return baseFaits.contains(propVerif);
    }
}