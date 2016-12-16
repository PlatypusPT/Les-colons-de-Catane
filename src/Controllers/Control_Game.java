package Controllers;

import Models.Partie;
import Views.Game_View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        view.setFirstPlayerView();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("You clicked on an image");
    }
}
