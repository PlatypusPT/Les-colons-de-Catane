package Models;

/**
 * Created by alex on 21/11/16.
 */
public class Colonie extends Carte {

    protected Carte Ressources[]; //Ressources sur les diago de la colonie
    protected Route rte1;
    protected Route rte2;//rte1 & rte2 sont les routes qui partent de this colonie

    public Colonie(String dos, Route rte1, Route rte2){
        super(dos);
        Ressources = new Carte[4];
        this.rte1 = rte1;
        this.rte2 = rte2;
    }

    public Colonie(String dos){
        super(dos);
    }

    public void setRte1(Route rte1){
        this.rte1 = rte1;
    }

    public void setRte2(Route rte2){
        this.rte2 = rte2;
    }

    public void setRoute(Route r1, Route r2){
        rte1 = r1;
        rte2 = r2;
    }

    public Route getRte1(){
        return rte1;
    }

    public Route getRte2(){
        return rte2;
    }
}
