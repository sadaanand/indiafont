/*
 * This class is use to list out all the avaliable fonts and all the fonts which can be buy by user.
 */
package com.View;
import java.awt.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.*;
/**
 * @since 24-Oct-2017
 * @author SuMiT
 */
public class FontView extends javax.swing.JPanel {

     DefaultListModel<ListEntry> dlm;
    public FontView() {
        dlm = new DefaultListModel();
//        File files=new File("resources\\fonts");
//        String str[]=files.list();
//        for (String string : str) {
//            dlm.addElement(new ListEntry(string.split(".ttf")[0], new ImageIcon(getClass().getResource("..\\..\\Fonts\\ok.png"))));  
//        }
        File file=new File("resources\\docs\\fontsList.txt");
        try{
        BufferedReader brIn=new BufferedReader(new FileReader(file));
        String fontName="";
        while((fontName=brIn.readLine())!=null) {
            System.out.println("File Name : "+fontName);
            if(!fontName.isEmpty()){
            String fontStatus[]=fontName.split("->");
            if(fontStatus[1].equals("ok")){
                dlm.addElement(new ListEntry(fontStatus[0], new ImageIcon("resources\\images\\ok.png")));  
            }else{
                dlm.addElement(new ListEntry(fontStatus[0], new ImageIcon("resources\\images\\buynow.png")));  
            }
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setBackground(new java.awt.Color(102, 102, 102));

        jList1.setBackground(new java.awt.Color(204, 204, 204));
        jList1.setModel(dlm);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList1.setCellRenderer(new ListEntryCellRenderer());
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        ListEntry le= jList1.getSelectedValue();
        String fontName=le.getValue();
        int choice=JOptionPane.showConfirmDialog(this, "Do you want to Buy "+fontName+"..?", "Buy Font" ,JOptionPane.YES_NO_OPTION);
        if(choice==0){
            new LandingPage().purchaseFontDialog(fontName);
            try {
				Process p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://indiafont.in/product/ams-aaditya-3\"");
				//Thread.sleep(5000);
				//p.destroy();
				System.out.println("Return value was " + p.waitFor());
			} catch (Exception e) {}
            
        }
        
        System.out.println(choice+" : Selected List Item : "+fontName);
    }//GEN-LAST:event_jList1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ListEntry> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

class ListEntry
{
   private String value;
   private ImageIcon icon;
  
   public ListEntry(String value, ImageIcon icon) {
      this.value = value;
      this.icon = icon;
   }
  
   public String getValue() {
      return value;
   }
  
   public ImageIcon getIcon() {
      return icon;
   }
  
   public String toString() {
      return value;
   }
}

class ListEntryCellRenderer
 extends JLabel implements ListCellRenderer
{
   private JLabel label;
  
   public Component getListCellRendererComponent(JList list, Object value,
                                                 int index, boolean isSelected,
                                                 boolean cellHasFocus) {
      ListEntry entry = (ListEntry) value;
  
      
      setText("<html><div align=left width=100px>" + value.toString() + "</div></html>");
      setHorizontalTextPosition(SwingConstants.LEADING);
      setAlignmentX(SwingConstants.RIGHT);
      setIcon(entry.getIcon());
       
      if (isSelected) {
         setBackground(list.getSelectionBackground());
         setForeground(list.getSelectionForeground());
      }
      else {
         setBackground(list.getBackground());
         setForeground(list.getForeground());
      }
  
      setEnabled(list.isEnabled());
      setFont(list.getFont());
      setOpaque(true);
  
      return this;
   }
}
