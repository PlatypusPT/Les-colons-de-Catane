package Models;

/**
 * Created by alex on 01/12/16.
 */

public class CampFortifie extends DeveloppementColonie {

    private Terrain terrainVoisins[];

    public CampFortifie(String image){
        super(0, 1, image);
        terrainVoisins = new Terrain[2];
    }

    public void setTerrainVoisins(Terrain t1, Terrain t2){
        terrainVoisins[0] = t1;
        t1.proteger();
        terrainVoisins[1] = t2;
        t2.proteger();
    }

    public void debitRessources(){
        /*
        code de la methode...
         */
    }
}
