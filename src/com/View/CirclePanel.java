package com.View;


import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.JPanel;

    public class CirclePanel extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
        //g2d.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}