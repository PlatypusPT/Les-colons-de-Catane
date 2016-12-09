package Models;

/**
 * Created by alex on 21/11/16.
 */

abstract public class Evenement extends Carte{

    public Evenement(int nbPointsVictoire, int nbPointsCommerce, String image){
        super(nbPointsVictoire, nbPointsCommerce, image);
    }

    abstract public void actionEvent();
}
