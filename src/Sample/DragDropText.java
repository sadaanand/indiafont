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
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DragDropText extends JFrame {

  public static void main(String[] args) {
    new DragDropText().setVisible(true);
  }

  public DragDropText() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField field1 = new JTextField("Life's a drag", 20);
    JTextField field2 = new JTextField("and then you drop", 20);
    field1.setDragEnabled(true);
    field2.setDragEnabled(true);
    Container content = getContentPane();

    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    content.add(field1);
    content.add(field2);

    pack();
  }
}