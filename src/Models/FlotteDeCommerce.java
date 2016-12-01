package Models;

/**
 * Created by alex on 01/12/16.
 */

public class FlotteDeCommerce extends DeveloppementColonie {

    private String ressource; //ressource concernee par this flotte de commerce
    private boolean eglise; //true si il y a une eglise dans la ville ou y'a this flotte

    public FlotteDeCommerce(String ressource){
        super(0, 1);
        this.ressource = ressource;
        eglise = false;
    }

    public void ajouterFlotte(Terrain t){
        t.mettreUneFlotteCommerce();
    }

    public void proteger(){
        eglise = true;
    }

    public boolean isProtege(){
        return true;
    }
}
