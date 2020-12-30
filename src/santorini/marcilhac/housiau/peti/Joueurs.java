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
public class Joueurs {
    
    String nom;
    String Couleur;
    
    
    // Constructeur
      public Joueurs (String unNom){ 
        nom=unNom;
    }
      
      public String lireCouleur(){
        return Couleur;
    }
    
    public void affecterCouleur(String uneCouleur){
        
        Couleur=uneCouleur;
       
    }
      
}
