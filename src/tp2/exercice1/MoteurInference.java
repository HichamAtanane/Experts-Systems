package tp2.exercice1;

import java.util.ArrayList;
import java.util.ListIterator;

public class MoteurInference {
    public static boolean chainageArriere(ArrayList<String> baseFaits, ArrayList<RegleSimple> baseRegles, String propVerif){
        boolean butResolu = false;
        if (baseFaits.contains(propVerif)){
            butResolu = true;
        }
        else {
            ListIterator<RegleSimple> iter = baseRegles.listIterator();
            while (iter.hasNext() && !butResolu){
                RegleSimple regle= iter.next();
                if (regle.getConclusion().equals(propVerif)){
                    if (chainageArriere(baseFaits, baseRegles, regle.getPremisse())){
                        butResolu = true;
                    }
                }
            }
        }
        return butResolu;
    }
}
