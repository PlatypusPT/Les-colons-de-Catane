package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Ville extends Fondation{

    protected Colonie col; //colonie à partir de laquelle on construit la ville
    protected Carte Batiments[]; //différents bâtiments de la ville
    private int NBPOINT = 2;//une ville rapporte 2 pv

    public Ville(String dos, Colonie col){
        super(dos);
        this.col = col;
        Batiments = new Carte[4];
    }
}
