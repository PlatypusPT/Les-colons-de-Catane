package Models;


public class Joueur {

	private String nom; //nom du joueur #groscommentaire
	private int nbPointsVictoire; //nombre de PV du joueur. maximum : 12
	private String couleurBlason; //noir ou rouge

	public Joueur(String nom, String couleurBlason) {
		this.nom = nom;
		this.couleurBlason = couleurBlason;
		nbPointsVictoire = 0;
	}

	public Joueur(String nom, String couleurBlason, int nbPointsVictoire) {
		this.nom = nom;
		this.couleurBlason = couleurBlason;
		this.nbPointsVictoire = nbPointsVictoire;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNbPointsVictoire(int nbPointsVictoire) {
		this.nbPointsVictoire = nbPointsVictoire;
	}

	public void setCouleurBlason(String couleurBlason) {
		this.couleurBlason = couleurBlason;
	}

	public String getNom() {
		return nom;
	}

	public int getNbPointsVictoire() {
		return nbPointsVictoire;
	}

	public String getCouleurBlason() {
		return couleurBlason;
	}
}
