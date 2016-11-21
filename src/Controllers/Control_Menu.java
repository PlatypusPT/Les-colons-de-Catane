package Controllers;

import Models.Model;
import Views.Menu_View;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Control_Menu {
    private Menu_View view;
    private Model model;

    public Control_Menu(Model model, Menu_View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }
}
