import Controllers.Control_Menu;
import Models.Model;

/**
 * Created by yhaffner on 21/11/16.
 */
class Appli {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model model = new Model();
                Control_Menu control_menu = new Control_Menu(model);
            }
        });
    }
}