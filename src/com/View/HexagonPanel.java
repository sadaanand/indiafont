/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Shree
 */
public class HexagonPanel extends JPanel{
    
     public void paintComponent(Graphics g) {
         Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    super.paintComponent(g);
    int radius = 80;
    int centerX = (g2d.getClipBounds().width)/2;
    int centerY = (g2d.getClipBounds().height)/2;
   

    Polygon p = new Polygon();
    centerX = (g2d.getClipBounds().width)/2;
    for (int i = 0; i < 6; i++)
      p.addPoint((int) (centerX + radius * Math.cos(i * 2 * Math.PI / 6)),
          (int) (centerY + radius * Math.sin(i * 2 * Math.PI / 6)));

    g2d.drawPolygon(p);
  }
    
}
