package Models;

/**
 * Created by alex on 01/12/16.
 */

public class Chevalier extends DeveloppementColonie {

    private int nbPointsTournoi; //nombre de points de tournoi de this chevalier
    private int nbPointsCombat; //nombre de points de combat de this chevalier
    private boolean eglise; //true si il y a une eglise dans la ville ou y'a this chevalier

    public Chevalier(int nbPointsTournoi, int nbPointsCombat){
        super(0, 0);
        this.nbPointsTournoi = nbPointsTournoi;
        this.nbPointsCombat = nbPointsCombat;
        eglise = false;
    }

    public int getNbPointsTournoi() {
        return nbPointsTournoi;
    }

    public int getNbPointsCombat() {
        return nbPointsCombat;
    }

    public void setNbPointsCombat(int nbPointsCombat){
        this.nbPointsCombat = nbPointsCombat;
    }

    public void proteger(){
        eglise = true;
    }

    public boolean isProtege(){
        return true;
    }
}
