package Models;

/**
 * Created by alex on 01/12/16.
 */

abstract public class Action extends Developpement {

    public Action(int nbPointsVictoire, int nbPointsCommerce) {
        super(nbPointsVictoire, nbPointsCommerce);
    }

    abstract public void ceQueDoitFaireLaCarte();
}
