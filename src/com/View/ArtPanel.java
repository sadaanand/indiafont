/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SuMiT
 */
public class ArtPanel extends javax.swing.JPanel {
    List<TextBoxResizable> textBoxList=new ArrayList<TextBoxResizable>();
    TextEditorBox textEditorBox;
    String fontName,fontSize;
    JPanel variationPanel;
    boolean drawTextBox=false; 
    public void setFontName(String fontName) {this.fontName = fontName;}
    public void setFontSize(String fontSize) {this.fontSize = fontSize;}
    public void setVariationPanel(JPanel variationPanel) {this.variationPanel = variationPanel;}
    public void setDrawTextBox(boolean drawTextBox) {this.drawTextBox = drawTextBox;}
    
    public ArtPanel() {
        initComponents();
        PanelMouseEventHandler panelMouseEventHandler=new PanelMouseEventHandler(this);
        addMouseListener(panelMouseEventHandler);
        addMouseMotionListener(panelMouseEventHandler);
    }
    
    public static void main(String a[]){
        JFrame frame=new JFrame();
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width,dimension.height);
        ArtPanel artPanel=new ArtPanel();
        frame.add(artPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //Grid start
            
            int sideLength = 8;
            int nRowCount = getHeight() / sideLength;
            int currentX = sideLength;
            for (int i = 0; i < nRowCount; i++) {
                g.setColor(new Color(240, 243, 244));
                g.drawLine(0, currentX, getWidth(), currentX);
                currentX = currentX + sideLength;
            }

            int nColumnCount = getWidth() / sideLength;
              
            int currentY = sideLength;
            for (int i = 0; i < nColumnCount; i++) {
                g.drawLine(currentY, 0, currentY, getHeight());
                currentY = currentY + sideLength;
            }
            g.setColor(Color.white);
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class PanelMouseEventHandler implements MouseListener,MouseMotionListener{
    ArtPanel artPanel;
    public PanelMouseEventHandler (ArtPanel artPanel){
        this.artPanel=artPanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Draw Text : "+artPanel.drawTextBox);
        if(artPanel.drawTextBox){
            int x=e.getX();int y=e.getY();
            TextEditorBox textBox=new TextEditorBox(artPanel,artPanel.variationPanel, x, y,artPanel.fontName,artPanel.fontSize,10,20);
            textBox.requestFocus();
            artPanel.drawTextBox=false;
        }
        //code is aaded to remove textbox bounded border after click on any where in JPanel by Sumit on 24-Dec-17
        for (TextBoxResizable textBoxResizable : artPanel.textBoxList) {
            TextEditorBox txBox=(TextEditorBox)textBoxResizable.getComponent(0);
            txBox.removeTextBoxBorder();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
