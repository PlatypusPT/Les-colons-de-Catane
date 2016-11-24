package Models;


public class Developpement extends Carte {

	private String type; //type de la carte : action, dev colonie ou dev ville

	public Developpement(String dos, String type) {
		super(dos);
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
