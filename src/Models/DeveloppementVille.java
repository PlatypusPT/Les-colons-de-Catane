package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class DeveloppementVille extends Developpement {

    protected Ville ville;

    public DeveloppementVille(int nbPointsVictoire, int nbPointsCommerce, String image){
        super(nbPointsVictoire, nbPointsCommerce, image);
        ville = null;
    }

    public void setVille(Ville ville){
        this.ville = ville;
    }

    public Ville getVille(){
        return ville;
    }
}
