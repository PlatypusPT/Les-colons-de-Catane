package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class Developpement extends Carte {

	public Developpement(int nbPointsVictoire, int nbPointsCommerce) {
		super(nbPointsVictoire, nbPointsCommerce);
	}

	abstract public void actionDeveloppement();
}
