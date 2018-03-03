/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Shree
 */
public class DecorativePanel extends JPanel {
    
   public BufferedImage image;
   
   public DecorativePanel(){}
    
    public DecorativePanel(BufferedImage image){
       this.image=image;      
       new DecorativePanel();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Image Path : "+image.toString());
        //g.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
         g.drawImage(image, 0, 0, null);
    }
}
