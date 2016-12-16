package Models;

import java.util.concurrent.ThreadLocalRandom;

public class ModelDe {

	private static String deEvent[] = {"Action 1", "Action 2", "Action 3","Action 4","Action 5", "Action 6"};

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