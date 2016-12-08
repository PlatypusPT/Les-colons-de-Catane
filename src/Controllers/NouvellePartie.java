package Controllers;

import Models.Joueur;
import Models.Plateau;

import java.util.Scanner;

/**
 * Created by alex on 02/12/16.
 */

public class NouvellePartie {

    public static Scanner input = new Scanner(System.in);

    public static void main(String agrs[]){
        System.out.print("Entrez le nom du joueur 1 : ");
        String nom1 = input.next();
        System.out.print("Entrez le blason du joueur 1 : ");
        String blason1 = input.next();
        Joueur joueur1 = new Joueur(nom1, blason1);

        System.out.print("Entrez le nom du joueur 2 : ");
        String nom2 = input.next();
        System.out.print("Entrez le blason du joueur 2 : ");
        String blason2 = input.next();
        Joueur joueur2 = new Joueur(nom2, blason2);

        joueur1.setPlateau(new Plateau(joueur1));
        joueur2.setPlateau(new Plateau(joueur2));
    }
}