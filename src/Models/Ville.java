package Models;

/**
 * Created by alex on 21/11/16.
 */
public class Ville extends Carte{

    protected Colonie col; //colonie à partir de laquelle on construit la ville
    protected Carte Batiments[]; //différents bâtiments de la ville

    public Ville(String dos, Colonie col){
        super(dos);
        this.col = col;
        Batiments = new Carte[4];
    }
}
