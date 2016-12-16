import Controllers.Control_Menu;
import Models.ModelMenu;
import Views.Menu_View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Appli extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ModelMenu mm = new ModelMenu();
        Menu_View menu = new Menu_View(mm,stage);
        Control_Menu control_menu = new Control_Menu(mm,menu);
    }
}
