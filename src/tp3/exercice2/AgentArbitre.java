package tp3.exercice2;

public class AgentArbitre {
//******************************************************************************************
    public static void affichage(Character[][] ticTacToe) {
        for (int i = 0; i < 3; i++) {
            System.out.print('|');
            for (int j = 0; j < 3; j++) {
                System.out.print(ticTacToe[i][j]);
                System.out.print('|');
            }
            System.out.println();
        }
    }
//******************************************************************************************
    public static boolean gagner(Character[][] ticTacToe, char symbole){
        boolean gagne = false;
        int counter;
//  par ligne
        for (int i = 0; i < 3; i++) {
            counter = 0;
            if (ticTacToe[i][0]==symbole){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[i][j]!=ticTacToe[i][0]){ break;}
                    counter ++;
                }
            }
            if (counter == 2){ gagne = true; break;}
        }
//  par colonne
        for (int i = 0; i < 3; i++) {
            counter = 0;
            if (ticTacToe[0][i]==symbole){
                for (int j = 1; j < 3; j++) {
                    if (ticTacToe[j][i]!=ticTacToe[0][i]){ break;}
                    counter ++;
                }
            }
            if (counter == 2){ gagne = true; break;}
        }
//  par diagonale
        if (ticTacToe[1][1]==symbole && ticTacToe[2][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[0][2]){
            gagne=true;
        }
        else if (ticTacToe[1][1]==symbole && ticTacToe[0][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][2]){
            gagne=true;
        }

        return gagne;
    }
//******************************************************************************************
    public static boolean gameOver(Character[][] ticTacToe) {
        boolean fini = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ticTacToe[i][j] == '_') {
                    fini = false;
                    break;
                }
            }
            if (!fini) {break;}
        }
        return fini;
    }
//******************************************************************************************
    public static AgentJoueur partie(int tour, Character[][] ticTacToe, AgentJoueur j1, AgentJoueur j2){
        AgentJoueur j=j1;
        if (tour == 1){
            j = j1;
        } else if (tour == 2){
            j = j2;
        }
        j.jouer(ticTacToe);
        affichage(ticTacToe);
        return j;
    }
//******************************************************************************************
    public static boolean resultat(Character[][] ticTacToe, AgentJoueur j){
        boolean flag = false;
        System.out.println("------------");
        affichage(ticTacToe);
        if (gagner(ticTacToe, j.getSymbole())) {
            System.out.println(j.getSymbole() + " a gagné");
            flag = true;
        }
        else if (gameOver(ticTacToe)) {
            System.out.println("Match nulle");
            flag = true;
        }
        return flag;
    }
}