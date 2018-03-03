/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eros Infotech
 */
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.awt.*;
    
public class Main extends JFrame {
   public Main() {
      getContentPane().setLayout(new FlowLayout());
  
      final JLabel label = new JLabel("Move your mouse over this JLabel!");
      final JTextField textfield = new JTextField();
  
      final CardLayout cl = new CardLayout();
      final JPanel panel = new JPanel(cl);
  
      panel.add(label, "label component");
      panel.add(textfield, "textfield component");
  
      getContentPane().add(panel);
   
      label.addMouseListener(new MouseAdapter() {
         public final void mouseEntered(MouseEvent evt) {
            textfield.setText(label.getText());
            cl.show(panel, "textfield component");
         }
      });
  
      textfield.addMouseListener(new MouseAdapter() {
         public final void mouseExited(MouseEvent evt) {
            label.setText(textfield.getText());
            cl.show(panel, "label component");
         }
      });
  
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent event) {
            System.exit(0);  
         }     
      });
  
      setSize(300, 200);
   }
  
//   public static void main(String[] args) {
//      (new Main()).show();
//   }
}