package Views;

import Models.Model;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.print.DocFlavor;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Menu_View{
    private Stage stage;
    private Model model;
    private VBox menuSection;
    public Button startButton;
    public Button optionButton;
    private BorderPane root;
    private Scene scene;

    public Menu_View(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;

        stage.setTitle("Les princes de Catane");
        stage.getIcons().add(new Image(new File(model.ASSETS_PATH+"/img/icon.png").toURI().toString()));
        stage.centerOnScreen();
        stage.setResizable(false);

        initAttributs();
        setWidgetMenuPrincipal();
    }

    private void initAttributs() {
        stage.hide();

        // Instanciate global layout :3
        root = new BorderPane();
        root.getStyleClass().add("body");
        scene = new Scene(root, 700, 700, Color.BLACK);
        scene.getStylesheets().add(new File(model.ASSETS_PATH+"/css/menu_view.css").toURI().toString());
        stage.setScene(scene);

        // Instanciate menu :3
        menuSection = new VBox();
        menuSection.getStyleClass().add("menu-section");
        startButton = new Button("COMMENCER");
        startButton.setId("start-button");
        optionButton = new Button("OPTIONS");
        optionButton.setId("option-button");


        stage.show();
    }

    private void setWidgetMenuPrincipal() {
        // Suppression de l'ancien contenu
        stage.hide();
        root.getChildren().clear();
        menuSection.getChildren().clear();

        // Menu content
        menuSection.getChildren().add(startButton);
        menuSection.getChildren().add(optionButton);
        root.setCenter(menuSection);

        // Affichage du nouveau contenu
        stage.show();
    }


    public void setController(EventHandler<ActionEvent> control_menu) {
        startButton.setOnAction(control_menu);
        optionButton.setOnAction(control_menu);
    }
}
