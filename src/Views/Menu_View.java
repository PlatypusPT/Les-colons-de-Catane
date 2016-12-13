package Views;

import Controllers.Partie;
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
import java.util.ArrayList;

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

    private Label jLabel;
    public ArrayList<RadioButton> blasonsIMGJ;
    public TextField jnomTextField;

    public ToggleGroup groupJ = new ToggleGroup();
    private GridPane blasonsJ;
    public Button realStartButton;
    public Button continueButton;

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
        continueButton = new Button("CONTINUER");
        continueButton.setId("real-start-button");
        realStartButton = new Button("DÉMARRER LA PARTIE");
        realStartButton.setId("real-start-button");
        optionButton = new Button("OPTIONS");
        optionButton.setId("option-button");

        groupJ = new ToggleGroup();
        blasonsJ = new GridPane();
        jLabel = new Label();
        jLabel.getStyleClass().add("fieldset");

        jnomTextField = new TextField();

        blasonsIMGJ = new ArrayList<>();
        for(int i=0;i<Joueur.COULEURS.length;i++) {
            blasonsIMGJ.add(new RadioButton());
            blasonsIMGJ.get(i).setGraphic(new ImageView(new Image(new File(model.ASSETS_PATH+"/img/blasons/"+ Joueur.COULEURS[i]+"_shield.png").toURI().toString(),60,60,true,true)));
        }
        for(RadioButton rb:blasonsIMGJ) rb.setToggleGroup(groupJ);
        blasonsIMGJ.get(0).setSelected(true);
    }

    public void setWidgetMenuPrincipal() {
        stage.hide();
        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        menuSection.getChildren().clear();
        menuSection.getChildren().add(startButton);
        menuSection.getChildren().add(optionButton);
        ((BorderPane) stage.getScene().getRoot()).setCenter(menuSection);
        stage.show();
    }

    public void setWidgetAskFirstPlayer() {
        stage.hide();
        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        menuSection.getChildren().clear();
        blasonsJ.getChildren().clear();
        jLabel.setText("JOUEUR 1");
        jnomTextField.setPromptText("J1");
        for (int i = 0; i< blasonsIMGJ.size(); i++) blasonsJ.add(blasonsIMGJ.get(i),i%(blasonsIMGJ.size()/2),i/(blasonsIMGJ.size()/2));
        menuSection.getChildren().add(jLabel);
        menuSection.getChildren().add(jnomTextField);
        menuSection.getChildren().add(blasonsJ);
        menuSection.getChildren().add(continueButton);
        ((BorderPane) stage.getScene().getRoot()).setCenter(menuSection);
        stage.show();
    }

    public void setWidgetAskSecondPlayer() {
        stage.hide();
        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        menuSection.getChildren().clear();
        blasonsJ.getChildren().clear();
        jLabel.setText("JOUEUR 2");
        jnomTextField.setPromptText("J2");
        for (int i = 0; i< blasonsIMGJ.size(); i++) blasonsJ.add(blasonsIMGJ.get(i),i%(blasonsIMGJ.size()/2),i/(blasonsIMGJ.size()/2));
        menuSection.getChildren().add(jLabel);
        menuSection.getChildren().add(jnomTextField);
        menuSection.getChildren().add(blasonsJ);
        menuSection.getChildren().add(realStartButton);
        ((BorderPane) stage.getScene().getRoot()).setCenter(menuSection);
        stage.show();
    }


    public void startGame(Partie partie){
        if(game_view==null) game_view=new Game_View(model,stage,this);
        game_view.initAttributs();
        game_view.setPartyView();
    }

    public void setController(EventHandler<ActionEvent> control_menu) {
        startButton.setOnAction(control_menu);
        realStartButton.setOnAction(control_menu);
        optionButton.setOnAction(control_menu);
        continueButton.setOnAction(control_menu);
    }
}
