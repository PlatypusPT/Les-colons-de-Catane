package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class Fondation extends Carte{

    protected String dos;
    /*
    -bouclier rouge, bouclier noir, carte terrain, carte route, etc.
    -seule les cartes fondations peuvent avoir un bouclier (sauf les villes)
    */

    public Fondation(String dos, int nbPointsVictoire, int nbPointCommerce){
        super(nbPointsVictoire, nbPointCommerce);
        this.dos = dos;
    }
}
