package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alex on 02/12/16.
 */

public class Partie {

    public Joueur joueur1;
    public Joueur joueur2;
    private ArrayList<Carte> pioche;
    private Random random;
    private ArrayList<Carte> tas1;
    private ArrayList<Carte> tas2;
    private ArrayList<Carte> tas3;
    private ArrayList<Carte> tas4;
    private ArrayList<Carte> tas5;
    private ArrayList<Carte> evenements;
    public ArrayList<Carte> ressources;
    public ArrayList<Carte> routes;
    public ArrayList<Carte> colonies;
    public ArrayList<Carte> ville;

    public int turn;
    public boolean deLance;
    public int actualDe;
    public int actualPioche;
    public boolean firstTurn;

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
        ressources = new ArrayList<>();
        routes = new ArrayList<>();
        colonies = new ArrayList<>();
        ville = new ArrayList<>();
        initPlayers();
        initPioche();
        initTas();
        initEvenement();
        initFondation();
        turn = 0;
        deLance = false;
        actualDe = 1;
        actualPioche = -1;
        firstTurn = true;
    }

    private void initFondation() {
        ressources.add(new Terrain("Laine", 1, 6, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_05_d6.png"));
        ressources.add(new Terrain("Laine", 1, 5, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_05_d5.png"));
        ressources.add(new Terrain("Minerai", 1, 5, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_02_d5.png"));
        ressources.add(new Terrain("Minerai", 1, 4, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_02_d4.png"));
        ressources.add(new Terrain("Bois", 1, 1, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_04_d1.png"));
        ressources.add(new Terrain("Bois", 1, 6, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_04_d6.png"));
        ressources.add(new Terrain("Blé", 1, 3, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_01_d3.png"));
        ressources.add(new Terrain("Blé", 1, 4, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_01_d4.png"));
        ressources.add(new Terrain("Argile", 1, 1, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_03_d1.png"));
        ressources.add(new Terrain("Argile", 1, 2, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_03_d2.png"));
        ressources.add(new Terrain("Or", 1, 3, ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_06_d3.png"));
        for(int i=0;i<20;i++) ressources.add(ressources.remove(random.nextInt(ressources.size()-1)));

        for(int i=0;i<7;i++) routes.add(new Route(ModelMenu.ASSETS_PATH+"/img/cards/card_route.png"));
        for(int i=0;i<5;i++) colonies.add(new Colonie(ModelMenu.ASSETS_PATH+"/img/cards/card_colonie.png"));
        for(int i=0;i<7;i++) ville.add(new Ville(ModelMenu.ASSETS_PATH+"/img/cards/card_ville.png"));
    }

    private void initPlayers() {
        joueur1.principaute.add(new Terrain("Minerai", 1, 2,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_02_d2.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Terrain("Bois", 1, 4,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_04_d4.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Terrain("Or", 1, 6,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_06_d6.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Colonie(ModelMenu.ASSETS_PATH+"/img/cards/card_colonie.png"));
        joueur1.principaute.add(new Route(ModelMenu.ASSETS_PATH+"/img/cards/card_route.png"));
        joueur1.principaute.add(new Colonie(ModelMenu.ASSETS_PATH+"/img/cards/card_colonie.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Terrain("Laine", 1, 3,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_05_d3.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Terrain("Blé", 1, 1,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_01_d1.png"));
        joueur1.principaute.add(null);
        joueur1.principaute.add(new Terrain("Argile", 1, 5,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_03_d5.png"));

        joueur2.principaute.add(new Terrain("Minerai", 1, 3,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_02_d3.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Terrain("Bois", 1, 4,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_04_d5.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Terrain("Or", 1, 6,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_06_d1.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Colonie(ModelMenu.ASSETS_PATH+"/img/cards/card_colonie.png"));
        joueur2.principaute.add(new Route(ModelMenu.ASSETS_PATH+"/img/cards/card_route.png"));
        joueur2.principaute.add(new Colonie(ModelMenu.ASSETS_PATH+"/img/cards/card_colonie.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Terrain("Laine", 1, 3,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_05_d4.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Terrain("Blé", 1, 2,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_01_d2.png"));
        joueur2.principaute.add(null);
        joueur2.principaute.add(new Terrain("Argile", 1, 5,ModelMenu.ASSETS_PATH+"/img/cards/card_ressources_03_d6.png"));
    }

    public void initPioche() {
        pioche.add(new Alchimiste(ModelMenu.ASSETS_PATH+"/img/cards/card_action_01.png"));
        pioche.add(new Alchimiste(ModelMenu.ASSETS_PATH+"/img/cards/card_action_01.png"));
        pioche.add(new Marchand(ModelMenu.ASSETS_PATH+"/img/cards/card_action_04.png"));
        pioche.add(new Marchand(ModelMenu.ASSETS_PATH+"/img/cards/card_action_04.png"));
        pioche.add(new Eveque(ModelMenu.ASSETS_PATH+"/img/cards/card_action_02.png"));
        pioche.add(new Eveque(ModelMenu.ASSETS_PATH+"/img/cards/card_action_02.png"));
        pioche.add(new Caravane(ModelMenu.ASSETS_PATH+"/img/cards/card_action_05.png"));
        pioche.add(new Rebouteuse(ModelMenu.ASSETS_PATH+"/img/cards/card_action_06.png"));
        pioche.add(new Rebouteuse(ModelMenu.ASSETS_PATH+"/img/cards/card_action_06.png"));
        pioche.add(new Incendiaire(ModelMenu.ASSETS_PATH+"/img/cards/card_action_03.png"));
        pioche.add(new Incendiaire(ModelMenu.ASSETS_PATH+"/img/cards/card_action_03.png"));
        pioche.add(new Eclaireur(ModelMenu.ASSETS_PATH+"/img/cards/card_action_07.png"));
        pioche.add(new Eclaireur(ModelMenu.ASSETS_PATH+"/img/cards/card_action_07.png"));
        pioche.add(new Brigands(ModelMenu.ASSETS_PATH+"/img/cards/card_action_08.png"));
        pioche.add(new ChevalierNoir(ModelMenu.ASSETS_PATH+"/img/cards/card_action_09.png"));
        pioche.add(new ChevalierNoir(ModelMenu.ASSETS_PATH+"/img/cards/card_action_09.png"));
        pioche.add(new ChevalierNoir(ModelMenu.ASSETS_PATH+"/img/cards/card_action_09.png"));
        pioche.add(new Espion(ModelMenu.ASSETS_PATH+"/img/cards/card_action_10.png"));
        pioche.add(new Espion(ModelMenu.ASSETS_PATH+"/img/cards/card_action_10.png"));
        pioche.add(new Espion(ModelMenu.ASSETS_PATH+"/img/cards/card_action_10.png"));
        pioche.add(new CampFortifie(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_06.png"));
        pioche.add(new CampFortifie(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_06.png"));
        pioche.add(new CampFortifie(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_06.png"));
        pioche.add(new ProductionUp("Minerai",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_01.png"));
        pioche.add(new ProductionUp("Argile",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_02.png"));
        pioche.add(new ProductionUp("Blé",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_03.png"));
        pioche.add(new ProductionUp("Bois",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_04.png"));
        pioche.add(new ProductionUp("Laine",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_05.png"));
        pioche.add(new FlotteDeCommerce("Bois",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_07.png"));
        pioche.add(new FlotteDeCommerce("Argile",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_08.png"));
        pioche.add(new FlotteDeCommerce("Minerai",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_09.png"));
        pioche.add(new FlotteDeCommerce("Blé",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_10.png"));
        pioche.add(new FlotteDeCommerce("Laine",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_11.png"));
        pioche.add(new FlotteDeCommerce("Or",ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_12.png"));
        pioche.add(new Monastere(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_13.png"));
        pioche.add(new Monastere(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_13.png"));
        pioche.add(new Forge(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_23.png"));
        pioche.add(new Chevalier(1,2,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_14.png"));
        pioche.add(new Chevalier(3,1,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_15.png"));
        pioche.add(new Chevalier(3,2,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_16.png"));
        pioche.add(new Chevalier(3,3,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_17.png"));
        pioche.add(new Chevalier(2,5,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_18.png"));
        pioche.add(new Chevalier(7,1,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_19.png"));
        pioche.add(new Chevalier(5,4,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_20.png"));
        pioche.add(new Chevalier(5,4,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_21.png"));
        pioche.add(new Chevalier(6,5,ModelMenu.ASSETS_PATH+"/img/cards/card_dev_colonie_22.png"));
        pioche.add(new Bain(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_04.png"));
        pioche.add(new Bain(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_04.png"));
        pioche.add(new Bibliotheque(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_05.png"));
        pioche.add(new Bibliotheque(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_05.png"));
        pioche.add(new ColosseDeCatane(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_06.png"));
        pioche.add(new Port(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_07.png"));
        pioche.add(new Eglise(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_08.png"));
        pioche.add(new Eglise(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_08.png"));
        pioche.add(new Marche(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_01.png"));
        pioche.add(new Comptoir(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_02.png"));
        pioche.add(new ChambreDeCommerce(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_03.png"));
        pioche.add(new HotelDeMonnaie(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_09.png"));
        pioche.add(new HotelDeVille(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_10.png"));
        pioche.add(new HotelDeVille(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_10.png"));
        pioche.add(new Aqueduc(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_11.png"));
        pioche.add(new Aqueduc(ModelMenu.ASSETS_PATH+"/img/cards/card_dev_ville_11.png"));
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
        evenements.add(new Architecte(ModelMenu.ASSETS_PATH+"/img/cards/card_event_01.png"));
        evenements.add(new GuerreCivile(ModelMenu.ASSETS_PATH+"/img/cards/card_event_02.png"));
        evenements.add(new AnneeFaste(ModelMenu.ASSETS_PATH+"/img/cards/card_event_03.png"));
        evenements.add(new AnneeFaste(ModelMenu.ASSETS_PATH+"/img/cards/card_event_03.png"));
        evenements.add(new Progres(ModelMenu.ASSETS_PATH+"/img/cards/card_event_04.png"));
        evenements.add(new Progres(ModelMenu.ASSETS_PATH+"/img/cards/card_event_04.png"));
        evenements.add(new NouvelAn(ModelMenu.ASSETS_PATH+"/img/cards/card_event_05.png"));
        evenements.add(new Conflit(ModelMenu.ASSETS_PATH+"/img/cards/card_event_06.png"));
        evenements.add(new Epidemie(ModelMenu.ASSETS_PATH+"/img/cards/card_event_07.png"));
        evenements.add(new Epidemie(ModelMenu.ASSETS_PATH+"/img/cards/card_event_07.png"));

        //shuffle
        for(int i=0;i<20;i++) evenements.add(evenements.remove(random.nextInt(evenements.size()-1)));
    }

    public Carte piocheCarteEvenement(int index){
        return evenements.get(index);
    }

    public Carte piocheCarteDeveloppement(int index, int numeroPioche) {
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

    public ArrayList<Carte> getTasDeveloppement(int i){
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

    public ArrayList<Carte> getMainJoueur(int index){
        switch (index){
            case 1:
                return joueur1.getMain();
            case 2:
                return joueur2.getMain();
            default:
                return null;
        }
    }

    public ArrayList<Carte> getPrincipauteJoueur(int index){
        switch (index){
            case 1:
                return joueur1.getPrincipaute();
            case 2:
                return joueur2.getPrincipaute();
            default:
                return null;
        }
    }

    public void addRessources(int actualDeResult) {
        for (Carte c : turn == 0 ? joueur1.principaute : joueur2.principaute)
            if (c instanceof Terrain) if (((Terrain) c).getNbRessource() < 3 && ((Terrain) c).getFaceDé()==actualDeResult+1)
                ((Terrain) c).setNbRessource(((Terrain) c).getNbRessource() + 1);
    }
}