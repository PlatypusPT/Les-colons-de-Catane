package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by admin on 11/01/2017.
 */
public class VilleUnitTest {

    @Test
    public void construireUneVilleUnitTest(){
        Ville ville = new Ville(null);
        Assert.assertEquals(ville.getBatiments().length, 4);
    }
}
