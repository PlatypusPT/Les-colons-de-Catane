package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 11/01/2017.
 */
public class ColonieUnitTest {

    Colonie colonie = new Colonie(null);

    @Test
    public void construireUneColonieUnitTest(){
        Assert.assertEquals(colonie.getTerrains().length, 4);
        Assert.assertEquals(colonie.getBatiments().length, 2);
    }

    @Test
    public void construireDesRoutesUnitTest(){
        Route rte1 = new Route(null);
        Route rte2 = new Route(null);
        colonie.setRoute(rte1, rte2);
        Assert.assertEquals(colonie.getRte1(), rte1);
        Assert.assertEquals(colonie.getRte2(), rte2);
    }

    @Test
    public void construireDesTerrainsUnitTest(){
        Terrain terrain = new Terrain("Blé", 1, 4, null);
        colonie.setTerrains(1, terrain);
        Assert.assertEquals(colonie.getTerrains()[1], terrain);
    }

    @Test
    public void construireUnBatimentUnitTest(){
        Monastere monastere = new Monastere(null);
        colonie.setBatiments(0, monastere);
        Assert.assertEquals(colonie.getBatiments()[0], monastere);
    }
}
