package Views;

import Models.*;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

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
    public GridPane firstPlayerPlayedCardsLayout;
    private GridPane piocheLayout;
    public GridPane secondPlayerPlayedCardsLayout;
    public GridPane secondPlayerDeckLayout;
    public GridPane firstPlayerDeckLayout;
    private GridPane IMGButtonGroup;

    public BorderPane popup;
    public HashMap<Point,ImageView> firstPlayerPlayedCards;
    public HashMap<Point,ImageView> firstPlayerDeck;
    public HashMap<Point,ImageView> piocheCards;
    public HashMap<Point,ImageView> secondPlayerPlayedCards;
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
        firstPlayerPlayedCardsLayout.setId("first-player-layout-in");
        firstPlayerDeckLayout = new GridPane();
        firstPlayerDeckLayout.setId("first-player-deck");
        piocheLayout = new GridPane();
        piocheLayout.setId("pioche-layout");
        secondPlayerPlayedCardsLayout = new GridPane();
        secondPlayerPlayedCardsLayout.setId("second-player-layout-in");
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

        for(int i=0;i<firstPlayerPlayedCardsLayout.getChildren().size();i++) {
            firstPlayerPlayedCardsLayout.getChildren().get(i).getStyleClass().remove(HUGE_FOCUS);
            if (empty_card.equals(((ImageView) firstPlayerPlayedCardsLayout.getChildren().get(i)).getImage()) && firstPlayerPlayedCardsLayout.getRowIndex(firstPlayerPlayedCardsLayout.getChildren().get(i)) != 1) {
                System.out.println("x:" + firstPlayerPlayedCardsLayout.getColumnIndex(firstPlayerPlayedCardsLayout.getChildren().get(i)) + " y:" + firstPlayerPlayedCardsLayout.getRowIndex(firstPlayerPlayedCardsLayout.getChildren().get(i)));
                for (Map.Entry<Point, ImageView> e : (model.turn == 0 ? firstPlayerPlayedCards.entrySet() : secondPlayerPlayedCards.entrySet()))
                    if (e.getKey().x == firstPlayerPlayedCardsLayout.getColumnIndex(firstPlayerPlayedCardsLayout.getChildren().get(i))  && e.getKey().y == 1)
                        if((mode == 2 && allCards.get(e.getValue()) instanceof Colonie)||
                                (mode == 3 && allCards.get(e.getValue()) instanceof Ville))
                            firstPlayerPlayedCardsLayout.getChildren().get(i).getStyleClass().add(HUGE_FOCUS);
            }
        }

        // Game content
        BorderPane j2 = new BorderPane();
        j2.setCenter(secondPlayerPlayedCardsLayout);
        Label t2 = new Label(model.joueur2.getNom());
        t2.getStyleClass().add("nom-joueur");
        j2.setLeft(new VBox(
                t2,
                new ImageView(new Image(
                        new File(ModelMenu.ASSETS_PATH+"/img/blasons/"+Joueur.COULEURS[model.joueur2.getCouleurBlason()]+"_shield.png").toURI().toString(),
                        IMG_MEDIUM_SIZE/1.6,IMG_MEDIUM_SIZE/1.6,
                        true,true
                ))
        ));
        j2.setId("second-player-layout");
        j2.getChildren().get(1).setId("second-player-blason");
        BorderPane j1 = new BorderPane();
        j1.setCenter(firstPlayerPlayedCardsLayout);
        Label t1 = new Label(model.joueur1.getNom());
        t1.getStyleClass().add("nom-joueur");
        j1.setLeft(new VBox(
                t1,
                new ImageView(new Image(
                        new File(ModelMenu.ASSETS_PATH+"/img/blasons/"+Joueur.COULEURS[model.joueur1.getCouleurBlason()]+"_shield.png").toURI().toString(),
                        IMG_MEDIUM_SIZE/1.6,IMG_MEDIUM_SIZE/1.6,
                        true,true
                ))
        ));
        j1.setId("first-player-layout");
        j1.getChildren().get(1).setId("first-player-blason");
        gameSection.getChildren().add(j2);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(j1);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);
        BorderPane bp = new BorderPane();
        bp.setCenter(firstPlayerDeckLayout);
        if(mode==0)
            bp.setRight(endTurn);
        ((BorderPane) stage.getScene().getRoot()).setBottom(bp);

        stage.getScene().getRoot().setVisible(true);
    }

    public void setSecondPlayerView(int mode){
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

        for(int i=0;i<secondPlayerPlayedCardsLayout.getChildren().size();i++) {
            secondPlayerPlayedCardsLayout.getChildren().get(i).getStyleClass().remove(HUGE_FOCUS);
            if (empty_card.equals(((ImageView) secondPlayerPlayedCardsLayout.getChildren().get(i)).getImage()) && secondPlayerPlayedCardsLayout.getRowIndex(secondPlayerPlayedCardsLayout.getChildren().get(i)) != 1) {
                System.out.println("x:" + secondPlayerPlayedCardsLayout.getColumnIndex(secondPlayerPlayedCardsLayout.getChildren().get(i)) + " y:" + secondPlayerPlayedCardsLayout.getRowIndex(secondPlayerPlayedCardsLayout.getChildren().get(i)));
                for (Map.Entry<Point, ImageView> e : (model.turn == 0 ? secondPlayerPlayedCards.entrySet() : secondPlayerPlayedCards.entrySet()))
                    if (e.getKey().x == secondPlayerPlayedCardsLayout.getColumnIndex(secondPlayerPlayedCardsLayout.getChildren().get(i))  && e.getKey().y == 1)
                        if((mode == 2 && allCards.get(e.getValue()) instanceof Colonie)||
                                (mode == 3 && allCards.get(e.getValue()) instanceof Ville))
                            secondPlayerPlayedCardsLayout.getChildren().get(i).getStyleClass().add(HUGE_FOCUS);
            }
        }


        // Game content
        BorderPane j2 = new BorderPane();
        j2.setCenter(secondPlayerPlayedCardsLayout);
        Label t2 = new Label(model.joueur2.getNom());
        t2.getStyleClass().add("nom-joueur");
        j2.setLeft(new VBox(
                t2,
                new ImageView(new Image(
                        new File(ModelMenu.ASSETS_PATH+"/img/blasons/"+Joueur.COULEURS[model.joueur2.getCouleurBlason()]+"_shield.png").toURI().toString(),
                        IMG_MEDIUM_SIZE/1.6,IMG_MEDIUM_SIZE/1.6,
                        true,true
                ))
        ));
        j2.setId("second-player-layout");
        j2.getChildren().get(1).setId("second-player-blason");
        BorderPane j1 = new BorderPane();
        j1.setCenter(firstPlayerPlayedCardsLayout);
        Label t1 = new Label(model.joueur1.getNom());
        t1.getStyleClass().add("nom-joueur");
        j1.setLeft(new VBox(
                t1,
                new ImageView(new Image(
                        new File(ModelMenu.ASSETS_PATH+"/img/blasons/"+Joueur.COULEURS[model.joueur1.getCouleurBlason()]+"_shield.png").toURI().toString(),
                        IMG_MEDIUM_SIZE/1.6,IMG_MEDIUM_SIZE/1.6,
                        true,true
                ))
        ));
        j1.setId("first-player-layout");
        j1.getChildren().get(1).setId("first-player-blason");
        gameSection.getChildren().add(j1);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(j2);
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
        popup.setId("popup");
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
        launchDe.setId("popup-button");
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
        for(Map.Entry<Point, ImageView> e : firstPlayerPlayedCards.entrySet())
            if(e.getKey().x%2==1 && e.getKey().y!=1) {
                e.getValue().setOnMouseClicked(eh);
                e.getValue().getStyleClass().add("selectable");
            }
        for(Map.Entry<Point, ImageView> e : secondPlayerPlayedCards.entrySet())
            if(e.getKey().x%2==1 && e.getKey().y!=1) {
                e.getValue().setOnMouseClicked(eh);
                e.getValue().getStyleClass().add("selectable");
            }
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
}
