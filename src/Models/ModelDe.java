package Models;
import java.util.concurrent.ThreadLocalRandom;
public class ModelDe {
	private static String deEvent[] = {"Action 1", "Action 2", "Action 3","Action 4","Action 5", "Action 6"};
	public static int lanceDe() {	return ThreadLocalRandom.current().nextInt(1, 6 + 1);	}
	public static String getAction() {	return deEvent[lanceDe()-1];	}
}