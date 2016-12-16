package Models;

import java.util.concurrent.ThreadLocalRandom;

public class ModelDe {

	private static String deEvent[] = {"Tournoi de Chevaliers", "Puissance marchande", "Attaque de voleur","Anne faste","Carte enenement", "Carte evenement"};

	/*
	Lancé du dé de production
	 */
	public static int lancerDeProduction() {
	    return ThreadLocalRandom.current().nextInt(1, 6 + 1);
	}

	/*
	Lancé du dé événement
	 */
	public static String lancerDeEvenement() {
	    return deEvent[ThreadLocalRandom.current().nextInt(1, 6 + 1)];
	}
}