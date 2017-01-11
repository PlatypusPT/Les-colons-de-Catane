package Models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vexy on 11/01/17.
 */
public class JoueurUnitTest
{
    Joueur joueur = new Joueur("John", 1);


    @Test
    public void creerJoueurUnitTest()
    {
        Assert.assertEquals(joueur.getNom(), "John");
        Assert.assertEquals(joueur.getCouleurBlason(), 1);
        Assert.assertEquals(joueur.getNbPointsVictoire(), 0);
    }

    @Test
    public void ajouterNomJoueur()
    {
        joueur.setNom("Adrien");
        Assert.assertEquals(joueur.getNom(), "Adrien");
    }

    @Test
    public void ajouterBlason()
    {
        joueur.setCouleurBlason(2);
        Assert.assertEquals(joueur.getCouleurBlason(), 2);
    }

    @Test
    public void testPointsDeVictoire()
    {
        joueur.setNbPointsVictoire(3);
        Assert.assertEquals(joueur.getNbPointsVictoire(), 3);
    }
}
