package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class Fondation extends Carte{

    public Fondation(int nbPointsVictoire, int nbPointCommerce){
        super(nbPointsVictoire, nbPointCommerce);
    }

    abstract public void debitRessources();
}
