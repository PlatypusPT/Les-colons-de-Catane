package Controllers;

import Models.Carte;
import Models.Joueur;

import java.util.ArrayList;

/**
 * Created by alex on 02/12/16.
 */

public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;
    private ArrayList<Carte> pioche;

    public Partie(Joueur joueur1, Joueur joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        pioche = new ArrayList<>();
    }
}