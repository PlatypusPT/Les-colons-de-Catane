package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Ville extends Fondation{

    private Colonie colonie; //colonie à partir de laquelle on construit this ville
    private DeveloppementVille Batiments[]; //différents bâtiments de la ville

    public Ville(){
        super(2, 0);
        this.colonie = null;
        Batiments = new DeveloppementVille[4];
    }

    public void setColonie(Colonie colonie){
        this.colonie = colonie;
    }

    public Colonie getColonie(){
        return colonie;
    }

    public void debitRessources(){
        /*
        code de la methode...
         */
    }

    public void setBatiments(int index, DeveloppementVille developpementVille){
        Batiments[index] = developpementVille;
    }

    public DeveloppementVille[] getBatiments(){
        return Batiments;
    }
}
