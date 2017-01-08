package Models;

import java.util.concurrent.ThreadLocalRandom;

public class ModelDe {

	public static String deEvent[] = {"Tournoi de Chevaliers", "Puissance marchande", "Attaque de voleur","Anne faste","Carte enenement", "Carte evenement"};

	/*
	Lancé du dé de production
	 */
	public static int lancerDeProduction() {
	    return ThreadLocalRandom.current().nextInt(0, 5 + 1);
	}

	/*
	Lancé du dé événement
	 */
	public static int lancerDeEvenement() {
	    int r = ThreadLocalRandom.current().nextInt(0, 5 + 1);
	    if(r==5) r--;
		return r;
	}
}