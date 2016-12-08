package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Terrain extends Fondation {

    private String ressource; //ressource correspondante
    private int nbRessource; //quantité de ressource dispo (0, 1, 2 ou 3)
    private int faceDé; //face du dé qui doit sortir pour incrémenter le nombre de ressource
    private boolean isInfluenceParBatimentProduUp; //this terrain est-il sous l'influence d'un ProductionUp ?
    private boolean isFlotteCommerce; //y'a-t-il une flotte de commerce pour this terrain.ressource ?
    private boolean isProtege; //this terrain est-il sous la protection d'un camp fortifie ?
    private boolean yaUnBain;

    public Terrain(String ressource, int nbRessource, int faceDé){
        super(0, 0);
        this.ressource = ressource;
        this.setNbRessource(nbRessource);
        this.faceDé = faceDé;
        isFlotteCommerce = false;
        isInfluenceParBatimentProduUp = false;
        isProtege = false;
        yaUnBain = false;
    }


    public String getRessource() {
        return ressource;
    }

    public int getNbRessource() {
        return nbRessource;
    }

    public void setNbRessource(int nbRessource) {
        this.nbRessource = nbRessource;
    }

    public int getFaceDé() {
        return faceDé;
    }

    public void debitRessources(){
        /*
        code de la methode...
         */
    }

    public boolean batimentProdOuPas(){
        return isInfluenceParBatimentProduUp;
    }

    public void doublerProduction(){
        isInfluenceParBatimentProduUp = true;
    }

    public boolean yaUneFlotteOuPas(){
        return isFlotteCommerce;
    }

    public void mettreUneFlotteCommerce(){
        isFlotteCommerce = true;
    }

    public boolean estIlProtegeOuPas(){
        return isProtege;
    }

    public void proteger(){
        isProtege = true;
    }

    public boolean yaUnBainOuPas(){
        return yaUnBain;
    }

    public void ajouterBain(){
        yaUnBain = true;
    }
}
