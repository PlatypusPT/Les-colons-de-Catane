package Controllers;

import Models.Model;
import Views.Menu_View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by yhaffner on 21/11/16.
 */
public class Control_Menu implements MouseListener {
    private Menu_View view;
    private Model model;

    public Control_Menu(Model model, Menu_View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(view.startButton.equals(e.getSource()) || view.optionButton.equals(e.getSource()))
            ((JPanel)e.getSource()).setBackground(new Color(70,10,10));

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(view.startButton.equals(e.getSource()) || view.optionButton.equals(e.getSource()))
            ((JPanel)e.getSource()).setBackground(new Color(124,28,37));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(view.startButton.equals(e.getSource()) || view.optionButton.equals(e.getSource()))
            ((JPanel)e.getSource()).setBackground(new Color(148,34,44));

    }
}
