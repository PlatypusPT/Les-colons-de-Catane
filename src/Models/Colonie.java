package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Colonie extends Fondation {

    private Terrain terrains[]; //terrains sur les diagonales de la colonie
    private DeveloppementColonie batiments[];
    private Route rte1;
    private Route rte2;//rte1 & rte2 sont les routes qui partent de this colonie

    public Colonie(){
        super(1, 0);
        terrains = new Terrain[4];
        batiments = new DeveloppementColonie[2];
        this.rte1 = null;
        this.rte2 = null;
    }

    public void setRte1(Route rte1){
        this.rte1 = rte1;
    }

    public void setRte2(Route rte2){
        this.rte2 = rte2;
    }

    public void setRoute(Route rte1, Route rte2){
        this.rte1 = rte1;
        this.rte2 = rte2;
    }

    public Route getRte1(){
        return rte1;
    }

    public Route getRte2(){
        return rte2;
    }

    public void debitRessources(){
        /*
        code de la methode...
         */
    }

    public void setTerrains(int index, Terrain terrain){
        terrains[index] = terrain;
    }

    public void setBatiments(int index, DeveloppementColonie developpementColonie){
        batiments[index] = developpementColonie;
    }

    public Terrain[] getTerrains(){
        return terrains;
    }

    public DeveloppementColonie[] getBatiments(){
        return batiments;
    }
}
