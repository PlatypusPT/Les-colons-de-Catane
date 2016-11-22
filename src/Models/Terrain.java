package Models;

/**
 * Created by alex on 21/11/16.
 */
public class Terrain extends Carte {

    private String ressource; //ressource correspondante
    private int nbRessource; //quantité de ressource dispo (0, 1, 2 ou 3)

    public Terrain(String dos, String ressource, int nbRessource){
        super(dos);
        this.ressource = ressource;
        this.nbRessource = nbRessource;
    }
}
