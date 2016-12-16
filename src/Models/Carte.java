package Models;

/**
 * Created by alex on 21/11/16.
 */

abstract public class Carte {

    protected int nbPointsVictoire; //nb de points de victoire que rapporte this carte
    protected int nbPointsCommerce; //nb de points de commerce que rapporte this carte
    protected String image; //image de la carte
    protected int x,y;

    public Carte(int nbPointsVictoire, int nbPointsCommerce, String image){
        this.nbPointsVictoire = nbPointsVictoire;
        this.nbPointsCommerce = nbPointsCommerce;
        this.image = image;
    }

    public int getNbPointsVictoire(){
        return nbPointsVictoire;
    }

    public void setNbPointsVictoire(int nbPointsVictoire){
        this.nbPointsVictoire = nbPointsVictoire;
    }

    public int getNbPointsCommerce(){
        return nbPointsCommerce;
    }

    public void setNbPointsCommerce(int nbPointsCommerce){
        this.nbPointsCommerce = nbPointsCommerce;
    }

    public String getImage() {return image;}
}
