package Models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alex on 07/12/16.
 */
public class Plateau {

    ArrayList<Carte> principaute;
    Joueur joueur;

    public Plateau(Joueur joueur){
        this.joueur = joueur;
        principaute = new ArrayList<>();
        principaute.add(new Terrain("Blé", 1, 1));
        principaute.add(new Terrain("Fer", 1, 2));
        principaute.add(new Terrain("Laine", 1, 3));
        principaute.add(new Terrain("Bois", 1, 4));
        principaute.add(new Terrain("Argile", 1, 5));
        principaute.add(new Terrain("Or", 1, 6));
        principaute.add(new Colonie());
        principaute.add(new Colonie());
        principaute.add(new Route());
        setRoute();
        setTerrains();
        joueur.setNbPointsVictoire(compteNbPointsVictoire());
    }

    public void setRoute(){
        Colonie col1 = (Colonie) principaute.get(6);
        col1.setRte1((Route) principaute.get(8));
        Colonie col2 = (Colonie) principaute.get(7);
        col2.setRte2((Route) principaute.get(8));
    }

    public void setTerrains(){
        Colonie col1 = (Colonie) principaute.get(6);
        Colonie col2 = (Colonie) principaute.get(7);
        for (int i=0; i<4; i++){
            col1.setTerrains(i, (Terrain) principaute.get(i));
            col2.setTerrains(i, (Terrain) principaute.get(i+2));
        }
    }

    public int compteNbPointsVictoire(){
        int somme = 0;
        Iterator<Carte> itC = principaute.iterator();
        while (itC.hasNext()){
            somme += itC.next().getNbPointsVictoire();
        }
        return somme;
    }
}
