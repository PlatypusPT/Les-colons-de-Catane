package Models;

/**
 * Created by alex on 21/11/16.
 */

public class Carte {

    protected String dos;//bouclier rouge, bouclier noir, carte terrain, carte route, etc.

    public Carte(String dos){
        this.dos = dos;
    }

    public void setDos(String dos){
        this.dos = dos;
    }

    public String getDos(){
        return dos;
    }
}
