package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alex on 02/12/16.
 */

public class Partie {

    private Joueur joueur1;
    private Joueur joueur2;
    private ArrayList<Carte> pioche;
    private Random random;
    private ArrayList<Carte> tas1;
    private ArrayList<Carte> tas2;
    private ArrayList<Carte> tas3;
    private ArrayList<Carte> tas4;
    private ArrayList<Carte> tas5;

    public Partie(Joueur joueur1, Joueur joueur2){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        pioche = new ArrayList<>();
        random = new Random();
        tas1 = new ArrayList<>();
        tas2 = new ArrayList<>();
        tas3 = new ArrayList<>();
        tas4 = new ArrayList<>();
        tas5 = new ArrayList<>();
    }

    public void initPioche() {
        String img = "card_dos.png";
        String ressource = "";
        int tournoi = 0;
        int combat = 0;
        pioche.add(new Alchimiste(img));
        pioche.add(new Alchimiste(img));
        pioche.add(new Marchand(img));
        pioche.add(new Marchand(img));
        pioche.add(new Eveque(img));
        pioche.add(new Eveque(img));
        pioche.add(new Caravane(img));
        pioche.add(new Rebouteuse(img));
        pioche.add(new Rebouteuse(img));
        pioche.add(new Incendiaire(img));
        pioche.add(new Incendiaire(img));
        pioche.add(new Eclaireur(img));
        pioche.add(new Eclaireur(img));
        pioche.add(new Brigands(img));
        pioche.add(new ChevalierNoir(img));
        pioche.add(new ChevalierNoir(img));
        pioche.add(new ChevalierNoir(img));
        pioche.add(new Espion(img));
        pioche.add(new Espion(img));
        pioche.add(new Espion(img));
        pioche.add(new CampFortifie(img));
        pioche.add(new CampFortifie(img));
        pioche.add(new CampFortifie(img));
        pioche.add(new ProductionUp(ressource,img));
        pioche.add(new ProductionUp(ressource,img));
        pioche.add(new ProductionUp(ressource,img));
        pioche.add(new ProductionUp(ressource,img));
        pioche.add(new ProductionUp(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new FlotteDeCommerce(ressource,img));
        pioche.add(new Monastere(img));
        pioche.add(new Monastere(img));
        pioche.add(new Forge(img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Chevalier(tournoi,combat,img));
        pioche.add(new Bain(img));
        pioche.add(new Bain(img));
        pioche.add(new Bibliotheque(img));
        pioche.add(new Bibliotheque(img));
        pioche.add(new ColosseDeCatane(img));
        pioche.add(new Port(img));
        pioche.add(new Eglise(img));
        pioche.add(new Eglise(img));
        pioche.add(new Marche(img));
        pioche.add(new Comptoir(img));
        pioche.add(new ChambreDeCommerce(img));
        pioche.add(new HotelDeMonnaie(img));
        pioche.add(new HotelDeVille(img));
        pioche.add(new HotelDeVille(img));
        pioche.add(new Aqueduc(img));
        pioche.add(new Aqueduc(img));
    }

    public void initTas() {
        for (int i=0; i<12; i++) {
            tas1.add(pioche.remove(random.nextInt(pioche.size())));
        }
        for (int i=0; i<12; i++) {
            tas2.add(pioche.remove(random.nextInt(pioche.size())));
        }
        for (int i=0; i<13; i++) {
            tas3.add(pioche.remove(random.nextInt(pioche.size())));
        }
        for (int i=0; i<13; i++) {
            tas4.add(pioche.remove(random.nextInt(pioche.size())));
        }
        for (int i=0; i<12; i++) {
            tas5.add(pioche.remove(random.nextInt(pioche.size())));
        }
    }

    public void piocheCarte() {

    }
}
