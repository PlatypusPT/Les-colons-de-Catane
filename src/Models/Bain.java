package Models;

/**
 * Created by alex on 01/12/16.
 */

public class Bain extends DeveloppementVille {

    public Bain(String image){
        super(1,0, image);
    }

    public void ajouterUnBain(){
        for (int i=0; i<4; i++){
            ville.getColonie().getTerrains()[i].ajouterBain();
        }
    }
}
