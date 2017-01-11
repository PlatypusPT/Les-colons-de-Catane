package Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yhaffner on 11/01/17.
 */
public class PartieUnitTest {
    Partie partie;

    @Before
    public void init(){
        partie = new Partie(new Joueur("J1",0),new Joueur("J2",1));
    }

    @Test
    public void partieBienInitialisee(){
        Assert.assertEquals(partie.turn,0);
        Assert.assertEquals(partie.deLance,false);
        Assert.assertEquals(partie.actualDe,1);
        Assert.assertEquals(partie.actualPioche,-1);
        Assert.assertEquals(partie.firstTurn,true);
    }

    @Test
    public void addRessource() {
        int somme=0;
        for(Carte c:partie.joueur1.principaute)
            if(c instanceof Terrain)
                somme += ((Terrain)c).getNbRessource();

        Assert.assertEquals(somme,6);
        partie.addRessources(0);
        somme=0;
        for(Carte c:partie.joueur1.principaute)
            if(c instanceof Terrain)
                somme += ((Terrain)c).getNbRessource();

        Assert.assertEquals(somme,7);
    }
}
