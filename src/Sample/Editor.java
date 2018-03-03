/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample;

/**
 *
 * @author Eros Infotech
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

public class Editor {

    public static void main(String[] args) {
        JFrame frame = new Window();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30, 30, 1000, 700);
        frame.getContentPane().setBackground(Color.white);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.repaint();
    }
}

class Window extends JFrame {
    MyPanel myPanel = new MyPanel();

    private static final long serialVersionUID = 1L;

    public Window() {
        addMenus();
    }

    public void addMenus() {

        getContentPane().add(myPanel);

        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public MyPanel() {
        JTextArea textArea = new JTextArea("Some text\nSome other text");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
        DragListener drag = new DragListener();
        textArea.addMouseListener(drag);
        textArea.addMouseMotionListener(drag);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public class DragListener extends MouseInputAdapter {
        Point location;
        MouseEvent pressed;

        public void mousePressed(MouseEvent me) {
            pressed = me;
        }

        public void mouseDragged(MouseEvent me) {
            Component component = me.getComponent();
            location = component.getLocation(location);
            int x = location.x - pressed.getX() + me.getX();
            int y = location.y - pressed.getY() + me.getY();
            component.setLocation(x, y);
        }
    }

}