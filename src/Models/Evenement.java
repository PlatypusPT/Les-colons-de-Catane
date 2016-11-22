package Models;

/**
 * Created by alex on 21/11/16.
 */
public class Evenement extends Carte{

    private String event; //événement...

    public Evenement(String dos, String event){
        super(dos);
        this.event = event;
    }
}
