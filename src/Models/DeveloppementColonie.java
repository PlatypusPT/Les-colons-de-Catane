package Models;

/**
 * Created by alex on 30/11/16.
 */

abstract public class DeveloppementColonie extends Developpement {

    protected Colonie colonie;

    public DeveloppementColonie(int nbPointsVictoire, int nbPointsCommerce){
        super(nbPointsVictoire, nbPointsCommerce);
        colonie = null;
    }

    public void setColonie(Colonie colonie){
        this.colonie = colonie;
    }

    public Colonie getColonie(){
        return colonie;
    }
}
