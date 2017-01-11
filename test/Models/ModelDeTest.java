package Models;
import org.junit.*;

/**
 * Created by mdemesy on 22/11/16.
 */
public class ModelDeTest {

    @Test
    public void testDeComprisEntreUnEtSix() {
        ModelDe md = new ModelDe();
        for (int i=0;i<100;i++) {
            int de = ModelDe.lancerDeProduction();
            Assert.assertTrue(de <= 5 && de >= 0);
        }
    }

    @Test
    public void testDeComprisEntreUnEtSixEvent() {
        ModelDe md = new ModelDe();
        for (int i=0;i<100;i++) {
            int de = ModelDe.lancerDeEvenement();
            Assert.assertTrue(de <= 5 && de >= 0);
        }
    }
}
