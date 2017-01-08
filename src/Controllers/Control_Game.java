package Controllers;

import Models.Carte;
import Models.ModelDe;
import Models.Partie;
import Views.Game_View;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


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



        view.launchDe(ModelDe.lancerDeEvenement(),model.actualDe,"Lancer le dé");
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(view.launchDe.getText());
        if(view.close.equals(event.getSource())) view.setFirstPlayerView(0);
        else if(view.launchDe.getText().equals(((Text) event.getPickResult().getIntersectedNode()).getText())
                        || view.launchDe.equals(event.getSource())) {
            if(view.launchDe.getText().equals("Continuer")) {
                model.actualDe = (model.actualDe+1)%2;
                if(model.actualDe==0)
                    view.launchDe(ModelDe.lancerDeProduction(),model.actualDe,"Lancer le dé");
                else
                    if(model.turn==0) view.setFirstPlayerView(0);
                    else view.setSecondPlayerView(0);
            } else if(!model.deLance) {
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
        } else if(!view.stage.getScene().equals(event.getSource())){
            ImageView carte = (ImageView) event.getSource();
            if(carte.getStyleClass().get(carte.getStyleClass().size()-2).equals("pioche"))
                view.showImage(((ImageView) event.getSource()).getImage().impl_getUrl().split(":")[1], 2);
            else if(carte.getStyleClass().get(carte.getStyleClass().size()-2).equals("main"))
                view.showImage(((ImageView) event.getSource()).getImage().impl_getUrl().split(":")[1], 1);
            else view.showImage(((ImageView) event.getSource()).getImage().impl_getUrl().split(":")[1], 0);
        }
    }

    private void timer() {
        if(model.deLance)
            view.launchDe(model.actualDe == 1 ? ModelDe.lancerDeEvenement() : ModelDe.lancerDeProduction(), model.actualDe, "Arrêter le dé");
    }
}
