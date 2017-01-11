package Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alex on 22/11/16.
 */
public class TerrainUnitTest {

    Terrain terrain = new Terrain("Blé", 1, 1, null);

    @Test
    public void construireUnTerraintUnitTest(){
        Assert.assertEquals(terrain.getRessource(),"Blé");
        Assert.assertEquals(terrain.getNbRessource(), 1);
        Assert.assertEquals(terrain.getFaceDé(), 1);
        Assert.assertEquals(terrain.batimentProdOuPas(), false);
        Assert.assertEquals(terrain.yaUneFlotteOuPas(), false);
        Assert.assertEquals(terrain.estIlProtegeOuPas(), false);
        Assert.assertEquals(terrain.yaUnBainOuPas(), false);
    }

    @Test
    public void ajouterUneRessourceUnitTest(){
        terrain.setNbRessource(2);
        Assert.assertEquals(terrain.getNbRessource(), 2);
    }

    @Test
    public void construireUnBatimentQuiDoubleLaProductionUnitTest(){
        terrain.doublerProduction();
        Assert.assertEquals(terrain.batimentProdOuPas(), true);
    }

    @Test
    public void mettreUneFlotteDeCommerceUnitTest(){
        terrain.mettreUneFlotteCommerce();
        Assert.assertEquals(terrain.yaUneFlotteOuPas(), true);
    }

    @Test
    public void construireUnFortUnitTest(){
        terrain.proteger();
        Assert.assertEquals(terrain.estIlProtegeOuPas(), true);
    }

    @Test
    public void construireUnBainUnitTest(){
        terrain.ajouterBain();
        Assert.assertEquals(terrain.yaUnBainOuPas(), true);
    }
}
