package Models;

/**
 * Created by alex on 21/11/16.
 */

abstract public class Evenement extends Carte{

    public Evenement(int nbPointsVictoire, int nbPointsCommerce){
        super(nbPointsVictoire, nbPointsCommerce);
    }

    abstract public void actionEvent();
}
