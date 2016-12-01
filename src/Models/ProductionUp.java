package Models;

/**
 * Created by alex on 01/12/16.
 */

public class ProductionUp extends DeveloppementColonie {

    private String ressource; //ressource concernee par this batiment
    private Terrain terrainsVoisins[]; //terrain(s) sous l'influence de this batiment de production

    public ProductionUp(String ressource){
        super(0, 1);
        this.ressource = ressource;
        terrainsVoisins = new Terrain[2];
    }

    public void setTerrainsVoisins(Terrain t1, Terrain t2){
        terrainsVoisins[0] = t1;
        t1.doublerProduction();
        terrainsVoisins[1] = t2;
        t2.doublerProduction();
    }
}
