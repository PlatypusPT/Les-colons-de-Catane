package Views;

import Controllers.Control_Menu;
import Models.Model;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Menu_View extends JFrame{
    public final int XS_FONT_SIZE = 15;
    public final int S_FONT_SIZE = 25;
    public final int N_FONT_SIZE = 30;
    public final int L_FONT_SIZE = 35;
    public final int XL_FONT_SIZE = 40;
    public final int XXL_FONT_SIZE = 45;
    public final String FONT_NAME = "Gentium";


    private Model model;
    private ThemedPanel fenetre;
    private JPanel menuSection;
    private JPanel startButton;
    private JPanel optionButton;

    public Menu_View(Model model) {
        this.model = model;

        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Assets/icon.png"));
        this.setTitle("Les princes de Catane");
        this.setSize(700, 728);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setCursor(Cursor.CROSSHAIR_CURSOR);

        initAttributs();
        setWidgetMenuPrincipal();
    }

    private void initAttributs() {
        // IU création
        this.setLayout(null);
        fenetre = new ThemedPanel();
        fenetre.setBackground(Toolkit.getDefaultToolkit().getImage("src/Assets/menu.jpg"));
        fenetre.setLayout(null);
        fenetre.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(fenetre);


        // Instanciate some layout :3
        menuSection = new JPanel();
        menuSection.setLayout(new BoxLayout(menuSection,BoxLayout.Y_AXIS));
        startButton = new JPanel(new BorderLayout());
        startButton.setBackground(new Color(148,34,44));
        startButton.setBorder(new LineBorder(Color.BLACK, 15, false));
        optionButton = new JPanel(new BorderLayout());
        optionButton.setBackground(new Color(148,34,44));
        optionButton.setBorder(new LineBorder(Color.BLACK, 15, false));
    }

    private void setWidgetMenuPrincipal() {
        // Suppression de l'ancien contenu
        fenetre.setVisible(false);
        fenetre.removeAll();
        menuSection.removeAll();

        // Menu content
        JLabel bwaaa = new JLabel("COMMENCER");
        bwaaa.setFont(new Font(FONT_NAME, Font.BOLD, S_FONT_SIZE));
        bwaaa.setForeground(new Color(245,204,34));
        bwaaa.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.removeAll();
        startButton.add(bwaaa, BorderLayout.CENTER);
        menuSection.add(startButton);
        JLabel bwaaa2 = new JLabel("OPTIONS");
        bwaaa2.setFont(new Font(FONT_NAME, Font.BOLD, S_FONT_SIZE));
        bwaaa2.setForeground(new Color(245,204,34));
        bwaaa2.setHorizontalAlignment(SwingConstants.CENTER);
        optionButton.removeAll();
        optionButton.add(bwaaa2, BorderLayout.CENTER);
        menuSection.add(optionButton);

        // Menu panel
        menuSection.setBounds(this.getSize().width / 2 - 150, this.getSize().height / 2 - 100 -20, 300, 200);
        fenetre.add(menuSection);


        // Affichage du nouveau contenu
        fenetre.setVisible(true);
    }

    public void setController(Control_Menu control_menu) {
        /* Completer */
    }
}
