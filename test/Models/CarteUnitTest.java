package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alex on 22/11/16.
 */
public class CarteUnitTest {

    @Test
    public void getCarteUnitTest(){
        Carte c = new Carte("Bouclier Rouge");
        Assert.assertEquals("Bouclier Rouge", c.getDos());
    }
}
