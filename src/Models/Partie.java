package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alex on 02/12/16.
 */

public class Partie {

    private static Joueur joueur1;
    private static Joueur joueur2;
    private ArrayList<Carte> pioche;
    private Random random;
    private static ArrayList<Carte> tas1;
    private static ArrayList<Carte> tas2;
    private static ArrayList<Carte> tas3;
    private static ArrayList<Carte> tas4;
    private static ArrayList<Carte> tas5;
    private static ArrayList<Carte> evenements;

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
        evenements = new ArrayList<>();
        initPioche();
        initTas();
        initEvenement();
    }

    public void initPioche() {
        String img = "Assets/img/cards/card_dos.png";
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

    private void initTas() {
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

    private void initEvenement(){
        String img = "Assets/img/cards/card_dos.png";
        evenements.add(new Architecte(img));
        evenements.add(new GuerreCivile(img));
        evenements.add(new AnneeFaste(img));
        evenements.add(new AnneeFaste(img));
        evenements.add(new Progres(img));
        evenements.add(new Progres(img));
        evenements.add(new NouvelAn(img));
        evenements.add(new Conflit(img));
        evenements.add(new Epidemie(img));
        evenements.add(new Epidemie(img));
    }

    public static Carte piocheCarteEvenement(int index){
        return evenements.get(index);
    }

    public static Carte piocheCarteDeveloppement(int index, int numeroPioche) {
        switch (numeroPioche){
            case 1:
                return tas1.get(index);
            case 2:
                return tas2.get(index);
            case 3:
                return tas3.get(index);
            case 4:
                return tas4.get(index);
            case 5:
                return tas5.get(index);
            default:
                return null;
        }
    }

    public static ArrayList<Carte> getTasDeveloppement(int i){
        switch (i) {
            case 1:
                return tas1;
            case 2:
                return tas2;
            case 3:
                return tas3;
            case 4:
                return tas4;
            case 5:
                return tas5;
            default:
                return null;
        }
    }

    public static ArrayList<Carte> getMainJoueur(int index){
        switch (index){
            case 1:
                return joueur1.getMain();
            case 2:
                return joueur2.getMain();
            default:
                return null;
        }
    }

    public static ArrayList<Carte> getPrincipauteJoueur(int index){
        switch (index){
            case 1:
                return joueur1.getPrincipaute();
            case 2:
                return joueur2.getPrincipaute();
            default:
                return null;
        }
    }
}
