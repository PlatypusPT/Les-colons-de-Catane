package Views;

import Models.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yhaffner on 08/12/16
 */
public class Game_View {
    public static int IMG_SMALL_SIZE = 64;
    public static int IMG_MEDIUM_SIZE = 100;
    public static int IMG_HUGE_SIZE = 500;
    public static String HUGE_FOCUS = "huge-focus";


    private Partie model;
    public Stage stage;
    private Menu_View menu_view;

    private VBox gameSection;
    private GridPane firstPlayerPlayedCardsLayout;
    private GridPane piocheLayout;
    private GridPane secondPlayerPlayedCardsLayout;
    private GridPane secondPlayerDeckLayout;
    private GridPane firstPlayerDeckLayout;
    private GridPane IMGButtonGroup;

    public BorderPane popup;
    public HashMap<Point,ImageView> firstPlayerPlayedCards;
    public HashMap<Point,ImageView> firstPlayerDeck;
    public HashMap<Point,ImageView> piocheCards;
    private HashMap<Point,ImageView> secondPlayerPlayedCards;
    public HashMap<Point,ImageView> secondPlayerDeck;
    public HashMap<ImageView, Carte> allCards;

    private ImageView[][] des;
    private Image empty_card;
    public Button close;
    public Button endTurn;
    public Button launchDe;
    public Button actionImageFocus;
    private Label nothingToShow;
    public int actualDeResult;
    public ImageView onFocusIMG;
    public int bufferedActualPioche;

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
        IMGButtonGroup = new GridPane();
        IMGButtonGroup.setId("button-group");

        firstPlayerPlayedCards = new HashMap<>();
        firstPlayerDeck = new HashMap<>();
        piocheCards = new HashMap<>();
        secondPlayerPlayedCards = new HashMap<>();
        secondPlayerDeck = new HashMap<>();

                empty_card = new Image(
                        new File(ModelMenu.ASSETS_PATH+"/img/cards/no_card.png").toURI().toString(),
                        IMG_SMALL_SIZE,IMG_SMALL_SIZE,
                        true,true
                );
        allCards = new HashMap<>();
        popup = new BorderPane();
        popup.setId("popup");

        close = new Button("X");
        close.setId("close");
        endTurn = new Button("Finir tour");
        endTurn.setId("switch-turn");
        launchDe = new Button("");
        launchDe.getStyleClass().add("popup-button");
        nothingToShow = new Label("Il n'y a rien à faire avec cette carte.");
        nothingToShow.setId("nothing-to-show");
        actionImageFocus = new Button("");
        actionImageFocus.getStyleClass().add("popup-button");

        des = new ImageView[2][6];
        for(int i=0;i<2;i++) for(int j=0;j<6-(i*2+j)/6;j++)
            des[i][j]=new ImageView(new Image(
                    new File(ModelMenu.ASSETS_PATH+"/img/des/de"+i+"_face"+j+".png").toURI().toString(),
                    IMG_MEDIUM_SIZE,IMG_MEDIUM_SIZE,
                    true,true
            ));
        actualizeCards();
    }

    public void actualizeCards() {
        firstPlayerPlayedCards.clear();
        firstPlayerDeck.clear();
        piocheCards.clear();
        secondPlayerPlayedCards.clear();
        secondPlayerDeck.clear();

        ImageView imageView;
        for(int i=0;i<model.getPrincipauteJoueur(1).size();i++) {

            if (model.getPrincipauteJoueur(1).get(i) != null) imageView = new ImageView(new Image(
                            new File(model.getPrincipauteJoueur(1).get(i).getImage()).toURI().toString(),
                            IMG_SMALL_SIZE, IMG_SMALL_SIZE,
                            true, true
                    )
            );
            else imageView = new ImageView(empty_card);
            if(model.getPrincipauteJoueur(1).get(i)!=null)
                allCards.put(imageView, model.getPrincipauteJoueur(1).get(i));
            firstPlayerPlayedCards.put(
                    new Point(
                            i % (model.getPrincipauteJoueur(1).size() / 3),
                            i / (model.getPrincipauteJoueur(1).size() / 3)
                    ),
                    imageView
            );
        }
        for(int i=0;i<model.getMainJoueur(1).size();i++) {
            imageView = new ImageView(new Image(
                    new File(model.getMainJoueur(1).get(i).getImage()).toURI().toString(),
                    IMG_MEDIUM_SIZE, IMG_MEDIUM_SIZE,
                    true, true
            ));
            imageView.getStyleClass().add("main");
            allCards.put(imageView, model.getMainJoueur(1).get(i));
            firstPlayerDeck.put(
                    new Point(i, 0),
                    imageView
            );
        }
        for(int i=0;i<model.getPrincipauteJoueur(2).size();i++) {
            if (model.getPrincipauteJoueur(2).get(i) != null)
                imageView = new ImageView(new Image(
                            new File(model.getPrincipauteJoueur(2).get(i).getImage()).toURI().toString(),
                            IMG_SMALL_SIZE, IMG_SMALL_SIZE,
                            true, true
                ));
            else imageView = new ImageView(empty_card);
            if(model.getPrincipauteJoueur(2).get(i)!=null) allCards.put(imageView,model.getPrincipauteJoueur(2).get(i));
            secondPlayerPlayedCards.put(
                    new Point(
                            i % (model.getPrincipauteJoueur(2).size() / 3),
                            i / (model.getPrincipauteJoueur(2).size() / 3)
                    ),
                    imageView
            );
        }
        for(int i=0;i<model.getMainJoueur(2).size();i++) {
            imageView = new ImageView(new Image(
                    new File(model.getMainJoueur(2).get(i).getImage()).toURI().toString(),
                    IMG_MEDIUM_SIZE, IMG_MEDIUM_SIZE,
                    true, true
            ));
            imageView.getStyleClass().add("main");
            allCards.put(imageView, model.getMainJoueur(2).get(i));
            secondPlayerDeck.put(
                    new Point(i, 0),
                    imageView
            );
        }
        for(int i=0;i<6;i++) {
            imageView = new ImageView(new Image(
                    new File(ModelMenu.ASSETS_PATH + "/img/cards/card_dos_" + (i + 1) + ".png").toURI().toString(),
                    IMG_SMALL_SIZE, IMG_SMALL_SIZE,
                    true, true
            ));
            imageView.getStyleClass().add("pioche");
            imageView.setId(i+"");
            piocheCards.put(
                    new Point(i, 0),
                    imageView
            );
        }
        for(int i=6;i<10;i++) {
            imageView = new ImageView(new Image(
                    new File(ModelMenu.ASSETS_PATH + "/img/cards/card_dos_6.png").toURI().toString(),
                    IMG_HUGE_SIZE, IMG_HUGE_SIZE,
                    true, true
            ));
            imageView.setFitHeight(IMG_SMALL_SIZE);
            imageView.setFitWidth(IMG_SMALL_SIZE);
            imageView.getStyleClass().add("pioche");
            imageView.setId(i+"");
            piocheCards.put(
                    new Point(i, 0),
                    imageView);
        }

        int j,i;
        for(j=1; j<6; j++) for(i=0;i<model.getTasDeveloppement(j).size();i++) {
            imageView = new ImageView(new Image(
                    new File(model.getTasDeveloppement(j).get(i).getImage()).toURI().toString(),
                    IMG_MEDIUM_SIZE, IMG_MEDIUM_SIZE,
                    true, true
            ));
            imageView.setFitHeight(IMG_SMALL_SIZE);
            imageView.setFitWidth(IMG_SMALL_SIZE);
            allCards.put(imageView, model.getTasDeveloppement(j).get(i));
        }
        for(i=0;i<model.ressources.size();i++) allCards.put(new ImageView(new Image(new File(model.ressources.get(i).getImage()).toURI().toString(), IMG_SMALL_SIZE, IMG_SMALL_SIZE, true, true)), model.ressources.get(i));
        for(i=0;i<model.routes.size();i++) allCards.put(new ImageView(new Image(new File(model.routes.get(i).getImage()).toURI().toString(), IMG_SMALL_SIZE, IMG_SMALL_SIZE, true, true)), model.routes.get(i));
        for(i=0;i<model.ville.size();i++) allCards.put(new ImageView(new Image(new File(model.ville.get(i).getImage()).toURI().toString(), IMG_SMALL_SIZE, IMG_SMALL_SIZE, true, true)), model.ville.get(i));
        for(i=0;i<model.colonies.size();i++) allCards.put(new ImageView(new Image(new File(model.colonies.get(i).getImage()).toURI().toString(), IMG_SMALL_SIZE, IMG_SMALL_SIZE, true, true)), model.colonies.get(i));


        for(Map.Entry<ImageView,Carte> e:allCards.entrySet()) e.getKey().getStyleClass().add("selectable");
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet()) e.getValue().getStyleClass().add("selectable");
    }

    public void setFirstPlayerView(int mode){
        higlightDevelopmentColoniesCase(mode==2);
        higlightDevelopmentVilleCase(mode==3);
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        gameSection.getChildren().clear();

        firstPlayerPlayedCardsLayout.getChildren().clear();
        firstPlayerDeckLayout.getChildren().clear();
        piocheLayout.getChildren().clear();
        secondPlayerPlayedCardsLayout.getChildren().clear();
        secondPlayerDeckLayout.getChildren().clear();
        for(Map.Entry<Point, ImageView> e : firstPlayerPlayedCards.entrySet())
            firstPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : firstPlayerDeck.entrySet())
            firstPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet())
            piocheLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : secondPlayerPlayedCards.entrySet())
            secondPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : secondPlayerDeck.entrySet())
            secondPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);

        // Game content
        gameSection.getChildren().add(secondPlayerPlayedCardsLayout);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(firstPlayerPlayedCardsLayout);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);
        BorderPane bp = new BorderPane();
        bp.setCenter(firstPlayerDeckLayout);
        if(mode==0)
            bp.setRight(endTurn);
        ((BorderPane) stage.getScene().getRoot()).setBottom(bp);

        stage.getScene().getRoot().setVisible(true);
    }

    public void setSecondPlayerView(int mode){
        higlightDevelopmentColoniesCase(mode==2);
        higlightDevelopmentVilleCase(mode==3);
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        gameSection.getChildren().clear();

        firstPlayerPlayedCardsLayout.getChildren().clear();
        firstPlayerDeckLayout.getChildren().clear();
        piocheLayout.getChildren().clear();
        secondPlayerPlayedCardsLayout.getChildren().clear();
        secondPlayerDeckLayout.getChildren().clear();
        for(Map.Entry<Point, ImageView> e : firstPlayerPlayedCards.entrySet())
            firstPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : firstPlayerDeck.entrySet())
            firstPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet())
            piocheLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : secondPlayerPlayedCards.entrySet())
            secondPlayerPlayedCardsLayout.add(e.getValue(),e.getKey().x,e.getKey().y);
        for(Map.Entry<Point, ImageView> e : secondPlayerDeck.entrySet())
            secondPlayerDeckLayout.add(e.getValue(),e.getKey().x,e.getKey().y);



        // Game content
        gameSection.getChildren().add(firstPlayerPlayedCardsLayout);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(secondPlayerPlayedCardsLayout);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);
        BorderPane bp = new BorderPane();
        bp.setCenter(secondPlayerDeckLayout);
        if(mode==0)
            bp.setRight(endTurn);
        ((BorderPane) stage.getScene().getRoot()).setBottom(bp);

        stage.getScene().getRoot().setVisible(true);
    }

    public void showImage(ImageView iv, int mode) {
        onFocusIMG = iv;

        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        popup.getChildren().clear();
        IMGButtonGroup.getChildren().clear();

        // Game content
        ImageView imv = null;
        if (piocheLayout.getChildren().contains(iv) && model.actualPioche<0) {
            for(Map.Entry<Point,ImageView> e:piocheCards.entrySet())
                if(e.getValue().equals(iv)){
                    if(e.getKey().x<6)
                        imv = new ImageView(new Image(
                                new File(ModelMenu.ASSETS_PATH + "/img/cards/card_dos_" + (e.getKey().x + 1) + ".png").toURI().toString(),
                                IMG_HUGE_SIZE, IMG_HUGE_SIZE,
                                true, true
                        ));
                    else
                        imv = new ImageView(new Image(
                                new File(ModelMenu.ASSETS_PATH + "/img/cards/card_dos_6.png").toURI().toString(),
                                IMG_HUGE_SIZE, IMG_HUGE_SIZE,
                                true, true
                        ));
                }

            popup.setCenter(iv);
        }else {
            imv = new ImageView(new Image(
                    new File(allCards.get(iv).getImage()).toURI().toString(),
                    IMG_HUGE_SIZE, IMG_HUGE_SIZE,
                    true, true
            ));
            imv.setRotate(iv.getRotate());
        }
        popup.setCenter(imv);
        popup.setRight(close);
        close.setId("close-button");
        actionImageFocus.setId("popup-button");

        switch(mode){
            case 1:
                actionImageFocus.setText("Utiliser carte");
                IMGButtonGroup.add(actionImageFocus,0,0);
                break;
            case 2:
                actionImageFocus.setText("Piocher une carte");
                IMGButtonGroup.add(actionImageFocus,0,0);
                break;
            default:
                if(model.actualPioche<1) IMGButtonGroup.add(nothingToShow,0,0);
                else {
                    actionImageFocus.setText("Selectionner carte");
                    IMGButtonGroup.add(actionImageFocus, 0, 0);
                }
        }
        popup.setBottom(IMGButtonGroup);

        ((BorderPane) stage.getScene().getRoot()).setCenter(popup);

        stage.getScene().getRoot().setVisible(true);
    }

    public void launchDe(int id_face, int de, String msg_button) {
        actualDeResult = id_face;
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        popup.getChildren().clear();
        IMGButtonGroup.getChildren().clear();

        // Game content
        popup.setCenter(des[de][id_face]);
        launchDe.setText(msg_button);
        IMGButtonGroup.add(launchDe,0,0);
        popup.setBottom(IMGButtonGroup);

        ((BorderPane) stage.getScene().getRoot()).setCenter(popup);

        stage.getScene().getRoot().setVisible(true);
    }

    public void showCards(int mode) {
        stage.getScene().getRoot().setVisible(false);

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        popup.getChildren().clear();
        piocheLayout.getChildren().clear();
        IMGButtonGroup.getChildren().clear();

        // Game content
        ImageView imageView;
        for (int i = 0; i < model.getTasDeveloppement(mode).size(); i++)
            for (Map.Entry<ImageView, Carte> hm : allCards.entrySet())
                    if (hm.getValue().equals(model.getTasDeveloppement(mode).get(i))) {
                        hm.getKey().setFitHeight(IMG_MEDIUM_SIZE);
                        hm.getKey().setFitWidth(IMG_MEDIUM_SIZE);
                        piocheLayout.add(hm.getKey(), i/3, i%3);
                    }

        popup.setCenter(piocheLayout);

        ((BorderPane) stage.getScene().getRoot()).setCenter(popup);

        stage.getScene().getRoot().setVisible(true);
    }

    public void setController(EventHandler<MouseEvent> eh){
        for(Map.Entry<ImageView,Carte> e:allCards.entrySet())
            e.getKey().setOnMouseClicked(eh);
        for(Map.Entry<Point, ImageView> e : piocheCards.entrySet())
            e.getValue().setOnMouseClicked(eh);
        close.setOnMouseClicked(eh);
        launchDe.setOnMouseClicked(eh);
        stage.getScene().setOnMouseClicked(eh);
        actionImageFocus.setOnMouseClicked(eh);
        endTurn.setOnMouseClicked(eh);
    }

    public void turnCardsAfterDice(int turn) {
        for (ImageView i : (turn == 0 ? firstPlayerPlayedCards.values() : secondPlayerPlayedCards.values())){
            if (allCards.get(i) instanceof Terrain) {
                System.out.println("\nFace dé: "+((Terrain) allCards.get(i)).getFaceDé());
                System.out.println("Nb Ressources: "+((Terrain) allCards.get(i)).getNbRessource());
                System.out.println("Dé actuel: "+(actualDeResult+1));
                if (((Terrain) allCards.get(i)).getFaceDé() == actualDeResult+1 && ((Terrain) allCards.get(i)).getNbRessource() < 3)
                    i.setRotate(i.getRotate() - 90);
            }
        }
    }
    private void higlightDevelopmentVilleCase(boolean highlight) {
        for(Map.Entry<Point,ImageView> e:(model.turn==0?firstPlayerPlayedCards.entrySet():secondPlayerPlayedCards.entrySet()))
            if(e.getKey().x%2==1 && e.getKey().y%2==0) {
                for (Map.Entry<Point, ImageView> e2 : (model.turn == 0 ? firstPlayerPlayedCards.entrySet() : secondPlayerPlayedCards.entrySet()))
                    if (highlight && e2.getKey().y == 1 && e2.getKey().x == e.getKey().x && allCards.get(e2.getValue()) instanceof Ville)
                        e.getValue().getStyleClass().add(HUGE_FOCUS);
                    else e.getValue().getStyleClass().remove(HUGE_FOCUS);
            }
    }
    private void higlightDevelopmentColoniesCase(boolean highlight) {
        for(Map.Entry<Point,ImageView> e:(model.turn==0?firstPlayerPlayedCards.entrySet():secondPlayerPlayedCards.entrySet()))
            if(e.getKey().x%2==1 && e.getKey().y%2==0) {
                for (Map.Entry<Point, ImageView> e2 : (model.turn == 0 ? firstPlayerPlayedCards.entrySet() : secondPlayerPlayedCards.entrySet()))
                    if (highlight && e2.getKey().y == 1 && e2.getKey().x == e.getKey().x && allCards.get(e2.getValue()) instanceof Colonie)
                        e.getValue().getStyleClass().add(HUGE_FOCUS);
                    else e.getValue().getStyleClass().remove(HUGE_FOCUS);
            }
    }
}
