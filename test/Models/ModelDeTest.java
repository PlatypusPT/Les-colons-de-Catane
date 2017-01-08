package Models;
import org.junit.*;


/**
 * Created by mdemesy on 22/11/16.
 */
public class ModelDeTest {
    @Test
    public void testDeComprisEntreUnEtSix() {
        for (int i=0;i<100;i++) {
            int de = ModelDe.lancerDeProduction();
            Assert.assertTrue(de <= 6 && de >= 1);
        }
    }

    // TEST OBSOLETE A REFAIRE?
    /*@Test
    public void testActionNonVide() {
        ModelDe md = new ModelDe();
        for (int i=0;i<100;i++) {
            //String action = ModelDe.lancerDeEvenement();
            //Assert.assertTrue(!action.equals(""));
        }
    }*/
}
