package Views;

import Controllers.Control_Game;
import Models.ModelMenu;
import Models.Partie;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhaffner on 08/12/16
 */
public class Game_View {
    public static int IMG_SMALL_SIZE = 64;
    public static int IMG_MEDIUM_SIZE = 100;
    public static int IMG_HUGE_SIZE = 400;


    private Partie model;
    private Stage stage;
    private Menu_View menu_view;

    private VBox gameSection;
    private GridPane firstPlayerPlayedCardsLayout;
    private GridPane piocheLayout;
    private GridPane secondPlayerPlayedCardsLayout;
    private GridPane secondPlayerDeckLayout;
    private GridPane firstPlayerDeckLayout;

    private HashMap<Point,ImageView> firstPlayerPlayedCards;
    private HashMap<Point,ImageView> firstPlayerDeck;
    private HashMap<Point,ImageView> piocheCards;
    private HashMap<Point,ImageView> secondPlayerPlayedCards;
    private HashMap<Point,ImageView> secondPlayerDeck;

    public Game_View(Partie model, Stage stage) {
        this.model = model;
        this.stage = stage;
        initAttributs();
    }

    public void initAttributs() {
        stage.getScene().getStylesheets().clear();
        stage.getScene().getStylesheets().add(new File(ModelMenu.ASSETS_PATH +"/css/game_view.css").toURI().toString());

        gameSection = new VBox();
        gameSection.setId("plateau-layout");

        firstPlayerPlayedCardsLayout = new GridPane();
        firstPlayerPlayedCardsLayout.setId("first-player-layout");
        firstPlayerDeckLayout = new GridPane();
        firstPlayerDeckLayout.setId("first-player-deck");
        piocheLayout = new GridPane();
        piocheLayout.setId("pioche-layout");
        secondPlayerPlayedCardsLayout = new GridPane();
        secondPlayerPlayedCardsLayout.setId("second-player-layout");
        secondPlayerDeckLayout = new GridPane();
        secondPlayerDeckLayout.setId("second-player-deck");

        firstPlayerPlayedCards = new HashMap<>();
        firstPlayerDeck = new HashMap<>();
        piocheCards = new HashMap<>();
        secondPlayerPlayedCards = new HashMap<>();
        secondPlayerDeck = new HashMap<>();

        actualizeCards();
    }

    public void actualizeCards() {
        firstPlayerPlayedCards.clear();
        firstPlayerDeck.clear();
        piocheCards.clear();
        secondPlayerPlayedCards.clear();
        secondPlayerDeck.clear();

        /* MODELE???
        for(int i=0;i<model.getFirstPlayerPlayedCards().size();i++) {
            ImageView imageView = new ImageView(model.getFirstPlayerPlayedCards().get(i).getImage());
            firstPlayerPlayedCards.add(i,imageView);
        }
        for(int i=0;i<model.getFirstPlayerDeck().size();i++) {
            ImageView imageView = new ImageView(model.getFirstPlayerDeck().get(i).getImage());
            firstPlayerPlayedCards.add(i,imageView);
        }
        for(int i=0;i<model.getPiocheCards().size();i++) {
            ImageView imageView = new ImageView(model.getPiocheCards().get(i).getImage());
            firstPlayerPlayedCards.add(i,imageView);
        }
        for(int i=0;i<model.getSecondPlayerPlayedCards().size();i++) {
            ImageView imageView = new ImageView(model.getSecondPlayerPlayedCards().get(i).getImage());
            firstPlayerPlayedCards.add(i,imageView);
        }
        for(int i=0;i<model.getSecondPlayerDeck().size();i++) {
            ImageView imageView = new ImageView(model.getSecondPlayerDeck().get(i).getImage());
            firstPlayerPlayedCards.add(i,imageView);
        }*/

        Image dos = new Image(new File(ModelMenu.ASSETS_PATH+"/img/cards/card_dos.png").toURI().toString(),IMG_SMALL_SIZE,IMG_SMALL_SIZE,true,true);
        Image emplacement = new Image(new File(ModelMenu.ASSETS_PATH+"/img/cards/no_card.png").toURI().toString(),IMG_SMALL_SIZE,IMG_SMALL_SIZE,true,true);
        Image visible1 = new Image(new File(ModelMenu.ASSETS_PATH+"/img/cards/card_action_01.png").toURI().toString(),IMG_MEDIUM_SIZE,IMG_MEDIUM_SIZE,true,true);
        Image visible2 = new Image(new File(ModelMenu.ASSETS_PATH+"/img/cards/card_action_02.png").toURI().toString(),IMG_MEDIUM_SIZE,IMG_MEDIUM_SIZE,true,true);
        firstPlayerPlayedCards.put(new Point(0,0),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(1,0),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(2,0),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(3,0),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(4,0),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(0,1),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(1,1),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(2,1),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(3,1),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(4,1),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(0,2),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(1,2),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(2,2),new ImageView(dos));
        firstPlayerPlayedCards.put(new Point(3,2),new ImageView(emplacement));
        firstPlayerPlayedCards.put(new Point(4,2),new ImageView(dos));
        for(int i=0;i<5;i++) firstPlayerDeck.put(new Point(i,0),new ImageView(visible1));
        for(int i=0;i<10;i++) piocheCards.put(new Point(i,0),new ImageView(dos));
        for(int i=0;i<5;i++) secondPlayerDeck.put(new Point(i,0),new ImageView(visible2));
        secondPlayerPlayedCards.put(new Point(0,0),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(1,0),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(2,0),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(3,0),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(4,0),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(0,1),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(1,1),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(2,1),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(3,1),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(4,1),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(0,2),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(1,2),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(2,2),new ImageView(dos));
        secondPlayerPlayedCards.put(new Point(3,2),new ImageView(emplacement));
        secondPlayerPlayedCards.put(new Point(4,2),new ImageView(dos));



        stage.getScene().getRoot().setVisible(false);
        firstPlayerPlayedCardsLayout.getChildren().clear();
        for(Map.Entry<Point, ImageView> e : firstPlayerPlayedCards.entrySet())
            {firstPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);e.getValue().getStyleClass().add("selectable");}
        for(Map.Entry<Point, ImageView> e : firstPlayerDeck.entrySet())
            {firstPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);e.getValue().getStyleClass().add("selectable");}
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet())
            {piocheLayout.add(e.getValue(),e.getKey().x,e.getKey().y);e.getValue().getStyleClass().add("selectable");}
        for(Map.Entry<Point, ImageView> e : secondPlayerPlayedCards.entrySet())
            {secondPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);e.getValue().getStyleClass().add("selectable");}
        for(Map.Entry<Point, ImageView> e : secondPlayerDeck.entrySet())
            {secondPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);e.getValue().getStyleClass().add("selectable");}
        stage.getScene().getRoot().setVisible(true);
    }

    public void setFirstPlayerView(){
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        gameSection.getChildren().clear();

        // Game content
        gameSection.getChildren().add(secondPlayerPlayedCardsLayout);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(firstPlayerPlayedCardsLayout);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);
        ((BorderPane) stage.getScene().getRoot()).setBottom(firstPlayerDeckLayout);

        stage.getScene().getRoot().setVisible(true);
    }

    public void setSecondPlayerView(){
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        gameSection.getChildren().clear();

        // Game content
        gameSection.getChildren().add(firstPlayerPlayedCardsLayout);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(secondPlayerPlayedCardsLayout);
        gameSection.getChildren().add(secondPlayerDeckLayout);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);

        stage.getScene().getRoot().setVisible(true);
    }

    public void setController(EventHandler<MouseEvent> eh){
        for(Map.Entry<Point, ImageView> e : firstPlayerPlayedCards.entrySet())
            e.getValue().setOnMouseClicked(eh);
        for(Map.Entry<Point, ImageView> e : firstPlayerDeck.entrySet())
            e.getValue().setOnMouseClicked(eh);
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet())
            e.getValue().setOnMouseClicked(eh);
        for(Map.Entry<Point, ImageView> e : secondPlayerPlayedCards.entrySet())
            e.getValue().setOnMouseClicked(eh);
        for(Map.Entry<Point, ImageView> e : secondPlayerDeck.entrySet())
            e.getValue().setOnMouseClicked(eh);
    }
}
