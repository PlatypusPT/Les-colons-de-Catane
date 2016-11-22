import Controllers.Control_Menu;
import Models.Model;
import Views.Menu_View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Appli extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        Menu_View menu = new Menu_View(model,stage);
        Control_Menu control_menu = new Control_Menu(model,menu);
    }
}
