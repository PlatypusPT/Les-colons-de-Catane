package Models;


import java.util.ArrayList;

public class Joueur {

	private String nom; //nom du joueur #groscommentaire
	private int nbPointsVictoire; //nombre de PV du joueur. maximum : 12
	private int couleurBlason; //noir ou rouge
	public ArrayList<Carte> principaute;
	public ArrayList<Carte> main;
    public final static String[] COULEURS = {"jaune","rouge","vert","bleu","magenta","blanc"};

	public Joueur(String nom, int couleurBlason) {
		this.nom = nom;
		this.couleurBlason = couleurBlason;
		nbPointsVictoire = 0;
		principaute = new ArrayList<>();
		setColoniesAttributs();
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

	public void setColoniesAttributs(){
		for(int i=0;i<principaute.size();i++) {
			Carte c = principaute.get(i);
			if(c instanceof Colonie) {
				if(principaute.get(i-1)!=null && principaute.get(i-1) instanceof Route)
					((Colonie) c).setRte1((Route) principaute.get(i-1));
				if(principaute.get(i+1)!=null && principaute.get(i+1) instanceof Route)
					((Colonie) c).setRte2((Route) principaute.get(i+1));


				if(principaute.get(i-(principaute.size()/3)-1)!=null && principaute.get(i-(principaute.size()/3)-1) instanceof Terrain)
					((Colonie) c).setTerrains(0,(Terrain) principaute.get(i-(principaute.size()/3)-1));
				if(principaute.get(i-(principaute.size()/3)+1)!=null && principaute.get(i-(principaute.size()/3)+1) instanceof Terrain)
					((Colonie) c).setTerrains(1,(Terrain) principaute.get(i-(principaute.size()/3)+1));
				if(principaute.get(i+(principaute.size()/3)-1)!=null && principaute.get(i+(principaute.size()/3)-1) instanceof Terrain)
					((Colonie) c).setTerrains(2,(Terrain) principaute.get(i+(principaute.size()/3)-1));
				if(principaute.get(i+(principaute.size()/3)+1)!=null && principaute.get(i+(principaute.size()/3)+1) instanceof Terrain)
					((Colonie) c).setTerrains(3,(Terrain) principaute.get(i+(principaute.size()/3)+1));
			}
		}
	}

	public ArrayList<Carte> getMain(){
	    return main;
    }

    public ArrayList<Carte> getPrincipaute(){
	    return principaute;
    }

    public void ajouterCarteMain(Carte carte){
	    main.add(carte);
    }
}
