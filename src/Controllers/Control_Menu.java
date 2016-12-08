package Controllers;

import Models.Model;
import Views.Menu_View;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Control_Menu implements EventHandler<ActionEvent>{
    private Menu_View view;
    private Model model;

    public Control_Menu(Model model, Menu_View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Button clicked: "+event.getSource());
        if(view.startButton.equals(event.getSource())) view.startGame();
    }
}
