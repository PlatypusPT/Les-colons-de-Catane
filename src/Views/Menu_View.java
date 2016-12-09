package Views;

import Models.Joueur;
import Models.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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

    private Label j1Label;
    private RadioButton[] blasonsIMGJ1;
    private RadioButton[] blasonsIMGJ2;
    private Label j2Label;
    private TextField j1nomTextField;

    private TextField j2nomTextField;
    public ToggleGroup groupJ1 = new ToggleGroup();
    public ToggleGroup groupJ2 = new ToggleGroup();
    private GridPane blasonsJ1;
    private GridPane blasonsJ2;
    public Button realStartButton;

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
        stage.setScene(scene);
    }

    private void initAttributs() {
        stage.getScene().getStylesheets().clear();
        stage.getScene().getStylesheets().add(new File(model.ASSETS_PATH+"/css/menu_view.css").toURI().toString());

        // Instanciate menu :3
        menuSection = new VBox();

        menuSection.getStyleClass().add("menu-section");
        startButton = new Button("COMMENCER");
        startButton.setId("start-button");
        realStartButton = new Button("DÉMARRER LA PARTIE");
        realStartButton.setId("real-start-button");
        optionButton = new Button("OPTIONS");
        optionButton.setId("option-button");

        groupJ1 = new ToggleGroup();
        groupJ2 = new ToggleGroup();
        blasonsJ1 = new GridPane();
        blasonsJ2 = new GridPane();
        j1Label = new Label("JOUEUR 1");
        j1Label.getStyleClass().add("fieldset");
        j2Label = new Label("JOUEUR 2");
        j2Label.getStyleClass().add("fieldset");

        j1nomTextField = new TextField();
        j1nomTextField.setPromptText("J1");
        j2nomTextField = new TextField();
        j2nomTextField.setPromptText("J2");

        blasonsIMGJ1 = new RadioButton[Joueur.COULEURS.length];
        for(int i=0;i<Joueur.COULEURS.length;i++) {
            blasonsIMGJ1[i] = new RadioButton();
            blasonsIMGJ1[i].setGraphic(new ImageView(new Image(new File(model.ASSETS_PATH+"/img/blasons/"+ Joueur.COULEURS[i]+"_shield.png").toURI().toString(),60,60,true,true)));
        }
        for(RadioButton rb:blasonsIMGJ1) rb.setToggleGroup(groupJ1);
        blasonsIMGJ1[0].setSelected(true);
        blasonsIMGJ2 = new RadioButton[Joueur.COULEURS.length];
        for(int i=0;i<Joueur.COULEURS.length;i++) {
            blasonsIMGJ2[i] = new RadioButton();
            blasonsIMGJ2[i].setGraphic(new ImageView(new Image(new File(model.ASSETS_PATH+"/img/blasons/"+ Joueur.COULEURS[i]+"_shield.png").toURI().toString(),60,60,true,true)));
        }
        for(RadioButton rb:blasonsIMGJ2) rb.setToggleGroup(groupJ2);
        blasonsIMGJ2[1].setSelected(true);
    }

    public void setWidgetMenuPrincipal() {
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

    public void setWidgetStartGameParam() {
        // Suppression de l'ancien contenu
        stage.hide();

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        menuSection.getChildren().clear();
        blasonsJ1.getChildren().clear();
        blasonsJ2.getChildren().clear();

        // BlasonJ1
        for (int i = 0; i< blasonsIMGJ1.length; i++) blasonsJ1.add(blasonsIMGJ1[i],i%(blasonsIMGJ1.length/2),i/(blasonsIMGJ1.length/2));
        // BlasonJ2
        for (int i = 0; i< blasonsIMGJ2.length; i++) blasonsJ2.add(blasonsIMGJ2[i],i%(blasonsIMGJ2.length/2),i/(blasonsIMGJ1.length/2));



        // Menu content
        menuSection.getChildren().add(j1Label);
        menuSection.getChildren().add(j1nomTextField);
        menuSection.getChildren().add(blasonsJ1);
        menuSection.getChildren().add(j2Label);
        menuSection.getChildren().add(j2nomTextField);
        menuSection.getChildren().add(blasonsJ2);
        menuSection.getChildren().add(realStartButton);
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
        realStartButton.setOnAction(control_menu);
        optionButton.setOnAction(control_menu);
    }
}
