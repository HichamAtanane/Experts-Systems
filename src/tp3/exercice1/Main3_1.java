package tp3.exercice1;

public class Main3_1 {
    public static void main(String[] args) {
        Character[][] ticTacToe = new Character[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = '_';
            }
        }
        AgentJoueur j1 = new AgentJoueur('X');
        AgentJoueur j2 = new AgentJoueur('O');

        AgentJoueur j = j1;
        while (!gameOver(ticTacToe) && (!gagner(ticTacToe, j.getSymbole()))) {
            j.jouer(ticTacToe);
            System.out.println("-----------------");
            affichage(ticTacToe);
            if (gagner(ticTacToe, j.getSymbole())) {
                System.out.println(j.getSymbole() + " a gagné");
            }
            else if (gameOver(ticTacToe)) {
                System.out.println("Match nulle");
            }
            else {
                if (j == j1) {
                    j = j2;
                } else {
                    j = j1;
                }
            }
        }
    }

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
        if (ticTacToe[1][1]==symbole && ticTacToe[2][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[0][2]){gagne=true;}
        else if (ticTacToe[1][1]==symbole && ticTacToe[0][0]==ticTacToe[1][1] && ticTacToe[1][1]==ticTacToe[2][2]){gagne=true;}

        return gagne;
    }
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
}