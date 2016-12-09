package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class Fondation extends Carte{

    public Fondation(int nbPointsVictoire, int nbPointCommerce, String image){
        super(nbPointsVictoire, nbPointCommerce, image);
    }

    abstract public void debitRessources();
}
