package tp2.exercice2;

import java.util.ArrayList;
import java.util.ListIterator;

public class MoteurInference {
    public static boolean chainageArriereComp(ArrayList<String> baseFaits, ArrayList<RegleComposee> baseRegles, String propVerif){
        boolean butResolu = false;
        if (baseFaits.contains(propVerif)){
            butResolu = true;
        }
        else {
            ListIterator<RegleComposee> iter = baseRegles.listIterator();
            while (iter.hasNext() && !butResolu){
                RegleComposee regle= iter.next();
                if (regle.getConclusion().equals(propVerif)){
                    for (String premisse: regle.getPremisse()){
                        if (chainageArriereComp(baseFaits, baseRegles, premisse)){
                            butResolu = true;
                        } else {
                            butResolu = false;
                            break;
                        }
                    }
                }
            }
        }
        return butResolu;
    }
}
