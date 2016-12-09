package Models;


import java.util.ArrayList;

public class Joueur {

	private String nom; //nom du joueur #groscommentaire
	private int nbPointsVictoire; //nombre de PV du joueur. maximum : 12
	private int couleurBlason; //noir ou rouge
	//private Plateau plateau;
	private ArrayList<Carte> principaute;
	private ArrayList<Carte> main;
    	public final static String[] COULEURS = {"jaune","rouge","vert","bleu","magenta","blanc"};

	public Joueur(String nom, int couleurBlason) {
		this.nom = nom;
		this.couleurBlason = couleurBlason;
		nbPointsVictoire = 0;
		//plateau = null;
		principaute = new ArrayList<>();
		principaute.add(new Terrain("Blé", 1, 1));
		principaute.add(new Terrain("Fer", 1, 2));
		principaute.add(new Terrain("Laine", 1, 3));
		principaute.add(new Terrain("Bois", 1, 4));
		principaute.add(new Terrain("Argile", 1, 5));
		principaute.add(new Terrain("Or", 1, 6));
		principaute.add(new Colonie());
		principaute.add(new Colonie());
		principaute.add(new Route());
		setRoute();
		setTerrains();
        main = new ArrayList<>();
	}

	/*
	public Joueur(String nom, String couleurBlason, int nbPointsVictoire) {
		this.nom = nom;
		this.couleurBlason = couleurBlason;
		this.nbPointsVictoire = nbPointsVictoire;
		//plateau = null;
	}
	*/

	public void setNom(String nom) {
		this.nom = nom;
	}

	//public void setPlateau(Plateau plateau){ this.plateau = plateau; }

	//public Plateau getPlateau(){ return plateau ;}

	public void setNbPointsVictoire(int nbPointsVictoire) {
		this.nbPointsVictoire = nbPointsVictoire;
	}

	public void setCouleurBlason(int couleurBlason) {
		this.couleurBlason = couleurBlason;
	}

	public String getNom() {
		return nom;
	}

	public int getNbPointsVictoire() {
		return nbPointsVictoire;
	}

	public int getCouleurBlason() {
		return couleurBlason;
	}

	public void setRoute(){
		Colonie col1 = (Colonie) principaute.get(6);
		col1.setRte1((Route) principaute.get(8));
		Colonie col2 = (Colonie) principaute.get(7);
		col2.setRte2((Route) principaute.get(8));
	}

	public void setTerrains(){
		Colonie col1 = (Colonie) principaute.get(6);
		Colonie col2 = (Colonie) principaute.get(7);
		for (int i=0; i<4; i++){
			col1.setTerrains(i, (Terrain) principaute.get(i));
			col2.setTerrains(i, (Terrain) principaute.get(i+2));
		}
	}
}
