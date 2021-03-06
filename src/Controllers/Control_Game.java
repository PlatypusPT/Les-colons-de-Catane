package Controllers;

import Models.*;
import Views.Game_View;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
import java.util.Map;


/**
 * Created by yhaffner on 15/12/16.
 */
public class Control_Game implements EventHandler<MouseEvent> {
    private final Partie model;
    private final Game_View view;
    private final Control_Menu menu;
    private Timeline t;

    public Control_Game(Partie model, Control_Menu control_menu) {
        this.model = model;
        this.view = new Game_View(model,control_menu.view.stage);
        this.menu = control_menu;
        this.view.setController(this);

        view.setFirstPlayerView(1);
    }

    @Override
    public void handle(MouseEvent event) {
        Joueur j = model.turn == 0 ? model.joueur1 : model.joueur2;


        if (view.close.equals(event.getSource())) {
            if (model.actualPioche < 1) {
                if (model.turn == 0) view.setFirstPlayerView(0);
                else view.setSecondPlayerView(0);
            } else view.showCards(model.actualPioche);
        } else if (view.endTurn.equals(event.getSource())) {
            model.turn = (model.turn + 1) % 2;
            j = model.turn == 0 ? model.joueur1 : model.joueur2;
            if (j.main.size() >= 3) {
                view.launchDe(ModelDe.lancerDeProduction(), model.actualDe, "Lancer le dé");
            } else if (model.turn == 0) {
                    if (model.firstTurn) model.firstTurn = false;
                    view.setFirstPlayerView(0);
            } else {
                view.setSecondPlayerView(model.firstTurn ? 1 : 0);
            }
        } else if ((event.getPickResult().getIntersectedNode() instanceof Text &&
                view.launchDe.getText().equals(((Text) event.getPickResult().getIntersectedNode()).getText()))
                || view.launchDe.equals(event.getSource())) {
            if (view.launchDe.getText().equals("Continuer")) {
                model.actualDe = (model.actualDe + 1) % 2;
                if (model.actualDe == 0) {
                    view.launchDe(ModelDe.lancerDeProduction(), model.actualDe, "Lancer le dé");
                } else {
                    view.turnCardsAfterDice(model.turn);
                    model.addRessources(view.actualDeResult);
                    if (model.turn == 0) view.setFirstPlayerView(0);
                    else view.setSecondPlayerView(0);
                }
            } else if (!model.deLance) {
                model.deLance = true;
                t = new Timeline(new KeyFrame(
                        Duration.millis(10),
                        ae -> timer()));
                t.setCycleCount(Animation.INDEFINITE);
                t.play();
            } else {
                t.stop();
                model.deLance = false;
                view.launchDe.setText("Continuer");
            }
        } else if (view.actionImageFocus.equals(event.getSource())) {
            if (view.actionImageFocus.getText().equals("Utiliser carte")) {
                if(view.allCards.get(view.onFocusIMG) instanceof DeveloppementColonie) {
                    if (model.turn == 0) view.setFirstPlayerView(2);
                    else view.setSecondPlayerView(2);
                } else if(view.allCards.get(view.onFocusIMG) instanceof DeveloppementVille) {
                    if (model.turn == 0) view.setFirstPlayerView(3);
                    else view.setSecondPlayerView(3);
                } else if(view.allCards.get(view.onFocusIMG) instanceof Evenement||
                        view.allCards.get(view.onFocusIMG) instanceof Action) {

                }
            } else {
                model.actualPioche = view.bufferedActualPioche;
                for (int i = 0; i < model.getTasDeveloppement(model.actualPioche).size(); i++)
                    if (model.getTasDeveloppement(model.actualPioche).get(i).equals(view.allCards.get(view.onFocusIMG))) {
                        for (Map.Entry<ImageView, Carte> e : view.allCards.entrySet())
                            if (e.getValue().equals(model.getTasDeveloppement(model.actualPioche).get(i))) {
                                if (model.turn == 0)
                                    view.firstPlayerDeck.put(new Point(view.firstPlayerDeck.size(), 0), e.getKey());
                                else view.secondPlayerDeck.put(new Point(view.secondPlayerDeck.size(), 0), e.getKey());
                        }
                        j.main.add(model.getTasDeveloppement(model.actualPioche).remove(i));
                    }
                if (j.main.size() < 3) {
                    view.showCards(model.actualPioche);
                } else {
                    //for(ImageView imageView:model.turn==0?view.firstPlayerDeck.values():view.secondPlayerDeck.values())
                    //imageView.setOnMouseClicked(this);
                    model.actualPioche = -1;
                    view.launchDe(ModelDe.lancerDeEvenement(), model.actualDe, "Lancer le dé");
                }
            }
        } else if (!view.stage.getScene().equals(event.getSource())) {
            ImageView carte = (ImageView) event.getSource();
            if (view.piocheCards.containsValue(carte)) {
                view.bufferedActualPioche = Integer.parseInt(carte.getId()) - 4;
                view.showImage((ImageView) event.getSource(), 2);
            } else if (view.firstPlayerDeck.containsValue(carte) || view.secondPlayerDeck.containsValue(carte))
                view.showImage((ImageView) event.getSource(), 1);
            else if (carte.getStyleClass().contains(Game_View.HUGE_FOCUS)) {
                Point i2=null;
                GridPane list = model.turn==0 ? view.firstPlayerPlayedCardsLayout : view.secondPlayerPlayedCardsLayout;
                for(Node n:list.getChildren()) for(Map.Entry<Point,ImageView> e:(model.turn==0 ? view.firstPlayerPlayedCards.entrySet() : view.secondPlayerPlayedCards.entrySet()))
                    if(e.getKey().x==list.getColumnIndex(n) && e.getKey().y==list.getRowIndex(n) && e.getValue().equals(carte)) {
                        i2=e.getKey();
                    }

                Point i=null;
                j.principaute.remove(i2.y*list.getChildren().size()/3+i2.x);
                System.out.println(j.main.indexOf(view.allCards.get(view.onFocusIMG)));
                System.out.println(view.allCards.get(view.onFocusIMG));

                j.principaute.add(
                        i2.y*list.getChildren().size()/3+i2.x,
                        j.main.remove(j.main.indexOf(view.allCards.get(view.onFocusIMG)))
                );
                if(model.turn==0) {
                    for(Map.Entry<Point,ImageView> e2:view.firstPlayerDeck.entrySet())
                        if(e2.getValue().equals(view.onFocusIMG)) i=e2.getKey();
                    view.firstPlayerPlayedCards.put(i2,view.firstPlayerDeck.remove(i));
                    view.firstPlayerPlayedCards.get(i2).setFitHeight(view.IMG_SMALL_SIZE);
                    view.firstPlayerPlayedCards.get(i2).setFitWidth(view.IMG_SMALL_SIZE);
                } else {
                    for(Map.Entry<Point,ImageView> e2:view.secondPlayerDeck.entrySet())
                        if(e2.getValue().equals(view.onFocusIMG)) i=e2.getKey();
                    view.secondPlayerPlayedCards.put(i2,view.secondPlayerDeck.remove(i));
                    view.secondPlayerPlayedCards.get(i2).setFitHeight(view.IMG_SMALL_SIZE);
                    view.secondPlayerPlayedCards.get(i2).setFitWidth(view.IMG_SMALL_SIZE);
                }
                if(model.turn==0) view.setFirstPlayerView(0);
                else view.setSecondPlayerView(0);
            } else if (view.allCards.containsKey(carte))
                view.showImage((ImageView) event.getSource(), 0);
        }
    }


    private void timer() {
        if(model.deLance)
            view.launchDe(model.actualDe == 1 ? ModelDe.lancerDeEvenement() : ModelDe.lancerDeProduction(), model.actualDe, "Arrêter le dé");
    }
}
