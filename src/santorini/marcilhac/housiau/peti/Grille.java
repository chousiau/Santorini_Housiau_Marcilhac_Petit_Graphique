/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package santorini.marcilhac.housiau.peti;

/**
 *
 * @author marci
 */
public class Grille {

    Case cases[][] = new Case[5][5];

    public Grille() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                cases[i][j] = new Case(0, null, false);
            }
        }
    }

    public boolean deplacementAutorise(Batisseur unBatisseur, String direction) {
        int x = unBatisseur.x;
        int y = unBatisseur.y;
        if ("H".equals(direction)) {
            if (x == 0) {
                return false;
            }
            if (cases[x - 1][y].batisseurCourant != null) {
                return false;
            }
            if (cases[x - 1][y].nbEtage - cases[x][y].batisseurCourant.numEtage >= 2) {
                return false;
            }
            if (cases[x - 1][y].presenceDome) {
                return false;
            }

        }

        if ("D".equals(direction)) {
            if (y == 4) {
                return false;
            }
            if (cases[x][y + 1].batisseurCourant != null) {
                return false;
            }
            if (cases[x][y + 1].nbEtage - cases[x][y].batisseurCourant.numEtage >= 2) {
                return false;
            }
            if (cases[x][y + 1].presenceDome) {
                return false;
            }

        }
        if ("G".equals(direction)) {
            if (y == 0) {
                return false;
            }
            if (cases[x][y - 1].batisseurCourant != null) {
                return false;
            }
            if (cases[x][y - 1].nbEtage - cases[x][y].batisseurCourant.numEtage >= 2) {
                return false;
            }
            if (cases[x][y - 1].presenceDome) {
                return false;
            }

        }
        if ("B".equals(direction)) {
            if (x == 4) {
                return false;
            }
            if (cases[x + 1][y].batisseurCourant != null) {
                return false;
            }
            if (cases[x + 1][y].nbEtage - cases[x][y].batisseurCourant.numEtage >= 2) {
                return false;
            }
            if (cases[x + 1][y].presenceDome) {
                return false;
            }

        }
        return true;
    }

    public void deplacerBatisseur(Batisseur unBatisseur, String Direction) {
        
        
        if (deplacementAutorise(unBatisseur, Direction)) {
            //On supprime le batisseur de la case actuelle car celui ci va être
            //déplacé
            cases[unBatisseur.x][unBatisseur.y].batisseurCourant = null;

            if ("H".equals(Direction)) {
                unBatisseur.x--;
            }
            if ("B".equals(Direction)) {
                unBatisseur.x++;
            }
            if ("D".equals(Direction)) {
                unBatisseur.y++;
            }
            if ("G".equals(Direction)) {
                unBatisseur.y--;
            }
        }
        //On réaffecte le battiseur à sa case après déplacement
        cases[unBatisseur.x][unBatisseur.y].batisseurCourant = unBatisseur;

    }

    public void afficherGrilleSurConsole() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cases[i][j].batisseurCourant != null) {
                    System.out.print("B");
                } else if (cases[i][j].presenceDome) {
                    System.out.print("D");
                } else if (cases[i][j].nbEtage != 0) {
                    System.out.print(cases[i][j].nbEtage);
                } else if (cases[i][j].nbEtage == 0) {
                    System.out.print("O");
                    
                }
            
            }
            System.out.print("\n");
        }
            
    }
    
    public boolean construireEtage(int numLigne, int numColonne){
        if (cases[numLigne][numColonne].nbEtage<3){
            cases[numLigne][numColonne].nbEtage++;
            return true;
        }
        return false;
    }
}
