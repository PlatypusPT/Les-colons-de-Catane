package Views;

import Models.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

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
    private Game_View game_view;

    public Menu_View(Model model, Stage stage) {
        this.model = model;
        this.stage = stage;

        firstTimeInitAttribute();
        initAttributs();
        setWidgetMenuPrincipal();
    }

    private void firstTimeInitAttribute() {
        stage.setTitle("Les princes de Catane");
        stage.getIcons().add(new Image(new File(model.ASSETS_PATH+"/img/icon.png").toURI().toString()));
        stage.centerOnScreen();
        stage.setResizable(false);

        // Instanciate global layout :3
        root = new BorderPane();
        root.getStyleClass().add("body");
        scene = new Scene(root, 700, 700, Color.BLACK);
        scene.getStylesheets().add(new File(model.ASSETS_PATH+"/css/menu_view.css").toURI().toString());
        stage.setScene(scene);
    }

    private void initAttributs() {
        // Instanciate menu :3
        menuSection = new VBox();
        menuSection.getStyleClass().add("menu-section");
        startButton = new Button("COMMENCER");
        startButton.setId("start-button");
        optionButton = new Button("OPTIONS");
        optionButton.setId("option-button");
    }

    private void setWidgetMenuPrincipal() {
        // Suppression de l'ancien contenu
        stage.hide();

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        menuSection.getChildren().clear();

        // Menu content
        menuSection.getChildren().add(startButton);
        menuSection.getChildren().add(optionButton);
        ((BorderPane) stage.getScene().getRoot()).setCenter(menuSection);

        // Affichage du nouveau contenu
        stage.show();
    }

    public void startGame(){
        if(game_view==null) game_view=new Game_View(model,stage,this);
        game_view.initAttributs();
        game_view.setPartyView();
    }

    public void setController(EventHandler<ActionEvent> control_menu) {
        startButton.setOnAction(control_menu);
        optionButton.setOnAction(control_menu);
    }
}
