package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alex on 22/11/16.
 */
public class TerrainUnitTest {

    @Test
    public void getRessourcesTest(){
        Terrain t = new Terrain("Bouclier noir", "Blé", 0);
        Assert.assertEquals("Blé", t.getRessource());
        Assert.assertEquals(0, t.getNbRessource());
    }
}
