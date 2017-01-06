package Controllers;

import Models.Joueur;
import Models.ModelMenu;
import Models.Partie;
import Views.Game_View;
import Views.Menu_View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Control_Menu implements EventHandler<ActionEvent>{
    protected Menu_View view;
    private ModelMenu model;

    private String j1,j2;
    private int c1,c2;

    public Control_Menu(ModelMenu model, Menu_View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        int i=0;
        System.out.println("Button clicked: "+event.getSource());

        if(view.startButton.equals(event.getSource())) view.setWidgetAskFirstPlayer();

        if(view.continueButton.equals(event.getSource())) {
            if(view.jnomTextField.getText().replaceAll(" ", "").length() == 0) j1 = "J1";
            else j1 = view.jnomTextField.getText();
            for (RadioButton rb:view.blasonsIMGJ) if(rb.isSelected()) c1=i; else i++;
            if(view.blasonsIMGJ.get(0).isSelected()) view.blasonsIMGJ.get(1).setSelected(true);
            else view.blasonsIMGJ.get(0).setSelected(true);
            view.blasonsIMGJ.get(c1).setDisable(true);
            view.setWidgetAskSecondPlayer();
        }

        if(view.realStartButton.equals(event.getSource())) {
            if(view.jnomTextField.getText().replaceAll(" ", "").length() == 0) j2 = "J2";
            else j2 = view.jnomTextField.getText();
            for (RadioButton rb:view.blasonsIMGJ) if(rb.isSelected()) c2=i; else i++;

            //game_view=new Game_View(new Partie(new Joueur(j1,c1),new Joueur(j2,c2)),view.stage,this);
            Control_Game control_game = new Control_Game(
                    new Partie(new Joueur(j1,c1),new Joueur(j2,c2)),
                    this
            );
        }
    }
}
