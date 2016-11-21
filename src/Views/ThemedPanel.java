package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yhaffner on 16/05/16.
 * Classe dérivée de JPanel pour pouvoir insérer une image de fond
 */
public class ThemedPanel extends JPanel {
    Image bgImg;
    Graphics g;

    public ThemedPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ThemedPanel(LayoutManager layout) {
        super(layout);
    }

    public ThemedPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public ThemedPanel() {
        super();
    }


    public void setBackground(String path) {
        super.setBackground(new Color(0, 0, 0, 0));
        bgImg = Toolkit.getDefaultToolkit().createImage(path);
    }

    public void setBackground(Image img) {
        super.setBackground(new Color(0, 0, 0, 0));
        bgImg = img;
    }

    public Image getBackgroundImage() {
        return bgImg;
    }

    @Override
    public void setBackground(Color bg) {
        bgImg = null;
        super.setBackground(bg);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImg, 0, 0, this);
    }

    public void setFinalSize(Dimension d) {
        setMinimumSize(d);
        setPreferredSize(d);
        setMaximumSize(d);
    }
}
