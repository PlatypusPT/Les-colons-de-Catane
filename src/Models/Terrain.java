package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Terrain extends Fondation {

    private String ressource; //ressource correspondante
    private int nbRessource; //quantité de ressource dispo (0, 1, 2 ou 3)
    private int faceDé; //face du dé qui doit sortir pour incrémenter le nombre de ressource

    public Terrain(String dos, String ressource, int nbRessource, int faceDé){
        super(dos);
        this.setRessource(ressource);
        this.setNbRessource(nbRessource);
        this.faceDé = faceDé;
    }


    public String getRessource() {
        return ressource;
    }

    public void setRessource(String ressource) {
        this.ressource = ressource;
    }

    public int getNbRessource() {
        return nbRessource;
    }

    public void setNbRessource(int nbRessource) {
        this.nbRessource = nbRessource;
    }

    public int getFaceDé() {
        return faceDé;
    }

    public void setFaceDé(int faceDé) {
        this.faceDé = faceDé;
    }
}
