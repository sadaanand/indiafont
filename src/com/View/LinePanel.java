
package com.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;


public class LinePanel extends JPanel{
    
     @Override
    protected void paintComponent(Graphics g) {
        //g.drawLine(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        AffineTransform at = new AffineTransform();
         Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        g2d.rotate(Math.toRadians(95), g.getClipBounds().width/2, g.getClipBounds().height/2);
    }
    
}
