import Controllers.Control_Menu;
import Models.Model;
import Views.Menu_View;

class Appli {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Model model = new Model();

            Menu_View menu = new Menu_View(model);
            menu.setVisible(true);

            Control_Menu control_menu = new Control_Menu(model,menu);
        });
    }
}
