package Models;

/**
 * Created by alex on 21/11/16.
 */
public class Terrain extends Carte {

    protected String ressource; //ressource correspondante
    protected int nbRessource; //quantité de ressource dispo (0, 1, 2 ou 3)

    public Terrain(String dos, String ressource, int nbRessource){
        super(dos);
        this.ressource = ressource;
        this.nbRessource = nbRessource;
    }
}
