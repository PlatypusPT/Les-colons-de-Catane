package Controllers;

import Models.Carte;
import Models.Partie;
import Views.Game_View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


/**
 * Created by yhaffner on 15/12/16.
 */
public class Control_Game implements EventHandler<MouseEvent> {
    private final Partie model;
    private final Game_View view;
    private final Control_Menu menu;

    public Control_Game(Partie model, Control_Menu control_menu) {
        this.model = model;
        this.view = new Game_View(model,control_menu.view.stage);
        this.menu = control_menu;
        this.view.setController(this);

        view.setFirstPlayerView(0);
    }

    @Override
    public void handle(MouseEvent event) {
        if(view.close.equals(event.getSource())) view.setFirstPlayerView(0);
        else if(view.allCards.containsKey((ImageView) event.getSource())) {
            Carte c = view.allCards.get(event.getSource());
            //if(c instanceof )
            view.showImage(((ImageView) event.getSource()).getImage().impl_getUrl().split(":")[1], 0);
        }
        else view.showImage(((ImageView) event.getSource()).getImage().impl_getUrl().split(":")[1], 0);
    }
}
