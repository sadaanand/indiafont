/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.FontUnicodeBundle;
import com.model.JavaDownloadFileFromURL;
import java.awt.AlphaComposite;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.beans.XMLEncoder;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicMenuBarUI;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGeneratorContext.GraphicContextDefaults;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.util.SVGConstants;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.DOMImplementation;
import org.apache.fop.svg.PDFTranscoder;
import org.w3c.dom.svg.SVGDocument;
import utils.FontSizeConverter;

/**
 *
 * @author Eros Infotech
 */
public class LandingPage extends javax.swing.JFrame {

    /**
     * Creates new form LandingPage
     */
    
    JPanel variationPanels[]=new JPanel[12];//decalre to create 12 variation panel in JPanel7 by Sumit on 24-Dec-17
    
    private static JFileChooser chooser = new JFileChooser();
    public boolean drawText = false;
    public boolean drawShapeBorder = true;
    int x, y, x2, y2;
    //TextEditorView jta;
    DefaultComboBoxModel<String> fontComboBoxModel;
    Font selectedFont;
    int fontSize;
    JLabel fontVariationLabel[] = new JLabel[12];
    //JLabel menuLabel[]=new JLabel[3];
    String fontNameStr,fontSizeStr;//line added by sumit 
    //ArrayList<TextEditorView> textEditorList = new ArrayList<TextEditorView>();
    public JLabel drawPanelBackgroundImage = new JLabel();//to set backround image to drawing panel
    //protected JSVGCanvas svgCanvas = new JSVGCanvas();
    //Colors
    String c1[] = {"#231F20","#FFFFFF","#404041","#58595B","#6D6E70","#808184","#929497","#A6A8AB","#BBBDBF","#D0D2D3","#E6E7E8","#FF0800","#EC1C24","#BE1E2D","#EE4036","#F05A28","#90278E","#9E1F63","#D91C5C","#EC297B","#EB008B","#F20530","#CC2014",
        "#ED3424","#B02E25","#F6F3AE","#F17280","#F27575","#7D293B","#E6765F","#F5E8A0","#00A551","#37B34A","#009345","#006838","#395919","#83A637","#1BA559","#98C93C","#3B4C08","#56FF00","#00ADEE","#0DFFF7","#56B9D1","#1071A8","#02B0A5","#67BC9A",
        "#B3D6A3","#70A8A5","#C4E6E4","#8CCEAC","#09B39A","#5E71FF","#33A5B1","#6CA0CE","#91C0E7","#0E348C","#003366","#124A57","#2B388F","#0E348C","#4E1F96","#0011140","#010A26","#5119E8","#473350","#9100FF","#516B68","#FFF100","#E8A50C","#F9B941",
        "#F3B032","#F3C531","#F9B931","#F4D04B","#FAAF40","#F0925A","#A4762B","#3B4042","#231F20","#401D15","#8C4A4A","#5A4A42","#9A8479","#603813","#3B2314","#401D15"};
    //END


    
    public LandingPage() {

//        //Add Dynamic Panel on jPanel7
//        int height=jPanel7.getHeight();
//        int width=jPanel7.getWidth()/12;
//        for(int i=0;i<12;i++){
//            JPanel jdynamicpanel=new JPanel();
//            jdynamicpanel.setSize(width, height);
//            jPanel7.add(jdynamicpanel);
//        }
//        //End
        File files = new File("resources\\fonts");
        String str[] = files.list();
        int count = 0;
        for (String string : str) {
            str[count++] = string.replaceAll(".ttf", "");
        }
        fontComboBoxModel = new DefaultComboBoxModel<String>(str);

        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("resources/india font.png"));
        setTitle("IndiaFont");
        setMinimumSize(new Dimension(1361, 757));
        System.out.println("*-*-*-**-*-Frame Size :-- "+this.getSize());
        
        
        //added By Sumit on 18-Dec-2017 Start
        Object fontSelector = jComboBox1.getSelectedItem();
        Object fontSize = jComboBox2.getSelectedItem();
        fontNameStr = fontSelector.toString();
        fontSizeStr = fontSize.toString();
        jPanel6.setFontName(fontNameStr);
        jPanel6.setFontSize(fontSizeStr);
        jPanel6.setVariationPanel(jPanel7);
        //added By Sumit 18-Dec-2017 Ends
        
     //   jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
        //jScrollPane3.getVerticalScrollBar().setUI(new MyScrollBarUI());

        jPanel9.setVisible(false);
        jPanel11.setVisible(false);
//        jPanel2.setVisible(false);
  //      jPanel25.setVisible(false);
        jPanel26.setVisible(false);

        jPanel27.setVisible(false);
        //jMenu8.setAlignmentX(RIGHT_ALIGNMENT);

        //to add empty variation panel into Jpanel7
        jPanel7.setLayout(new GridLayout(1, 12));
        for (int i = 0; i < 12; i++) {
            JPanel jpanel = new JPanel();
            JLabel lbl = new JLabel();

            int height = getjPanel7().getHeight();
            int width = getjPanel7().getWidth() / 12;
            //lbl.setSize(height,width);
            lbl.setPreferredSize(new Dimension(65, 65));//to set the size of dynamically generated label
            //Font selectedFont=this.selectedFont.deriveFont(20.0f);//code is use to se font size for label text
            //lbl.setFont(selectedFont);
            lbl.setHorizontalTextPosition(JLabel.CENTER);
            //frame.getjPanel7().add(lbl);
            Border paddingBorder = BorderFactory.createEmptyBorder(10, 5, 10, 5);
            //JLabel will be involved for this border
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            lbl.setHorizontalAlignment(lbl.CENTER);
            lbl.setVerticalAlignment(lbl.CENTER);
            //lbl.setText(""+((char)Integer.parseInt(variation)));
            Color c = Color.decode("#D1D2D4");
            jpanel.setBackground(c);
            jpanel.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
            jpanel.setLayout(new CardLayout());
            jpanel.add(lbl);
            jpanel.setSize(height, width);
            jpanel.setVisible(true);
            
            //change by Sumit on 24-Dec-2017 : Start
            variationPanels[i]=jpanel;
            getjPanel7().add(variationPanels[i]);
            //change by Sumit on 24-Dec-2017 : End

        }
        jPanel7.repaint();

        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Color co = new Color(51, 51, 51);
        this.setBackground(new Color(102, 102, 102));
        jMenuBar1.setUI(new BasicMenuBarUI() {
            public void paint(Graphics g, JComponent c) {

                g.setColor(co);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });

        //Add JPanels and Colors into Switches
        for (int i = 0; i < c1.length; i++) {
            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(Color.decode(c1[i]));
            colorPanel.setSize(new Dimension(250, 250));
            //Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
            //colorPanel.setBorder(border);
            jPanel15.add(colorPanel);
            colorPanel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    //System.out.println("Color Panel Size : "+colorPanel.getName());
                    //jPanel6.setBackground(colorPanel.getBackground());
                    jPanel6.textEditorBox.changeColorOfSelectedText(colorPanel.getBackground());
                    //System.out.println("Panel 15 Size : "+jPanel15.getName());
                }
            });
        }
        jPanel15.setLayout(new GridLayout(10, 8, 2, 2));
        //End

        //Add JPanels and Background Images 
        String path="resources/background/panel/";
        chageImageSize(path);
         File backgroundFiles = new File("resources\\background\\4040");
        String backgroungStr[] = backgroundFiles.list();
        for (int i = 0; i < backgroungStr.length; i++) {
            System.out.println("Name : " + backgroungStr[i]);
        }
       // System.out.println("");
        //Icon icon = new ImageIcon("C:\\Users\\Shree\\Documents\\NetBeansProjects\\IndiaFont(14-11-2017)\\resources\\5050\\5_40x40.png");
        for (int i = 0; i < backgroungStr.length; i++) {
            Icon icon = new ImageIcon("resources\\background\\4040\\" + backgroungStr[i]);
            JPanel backgroundPanel = new JPanel();
            backgroundPanel.setSize(20, 20);
            backgroundPanel.setMaximumSize(new Dimension(20, 20));
            backgroundPanel.setPreferredSize(new Dimension(20, 20));
            backgroundPanel.setMinimumSize(new Dimension(20, 20));
            
            
            JLabel jl = new JLabel();
            backgroundPanel.setLayout(new CardLayout(1,1));
            jl.setIcon(icon);
            backgroundPanel.add(jl);
            //backgroundPanel.setLayout(new GridLayout());
            backgroundPanel.setBackground(new Color(73,73,73));
            System.out.println("**********Panel size : "+backgroundPanel.getSize());
            //backgroundPanel.setLayout(new GridLayout(5, 2));
            //backgroundPanel.setBackground(Color.decode("#3366FF"));

            jl.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    // you can open a new frame here as
                    // i have assumed you have declared "frame" as instance variable
                   // System.out.println("************" + jl.getIcon().toString());

                    File f = new File(jl.getIcon().toString());
                    Icon ic = new ImageIcon("resources\\background\\panel\\" + f.getName());
                    if(f.getName().equals("0.png")){
                        Icon ic1=new ImageIcon("");
                        drawPanelBackgroundImage.setIcon(ic1);
                    }else{
                    drawPanelBackgroundImage.setLayout(new GridLayout());
                    drawPanelBackgroundImage.setMaximumSize(new Dimension(20, 20));
                    drawPanelBackgroundImage.setPreferredSize(new Dimension(20, 20));
                    drawPanelBackgroundImage.setMinimumSize(new Dimension(20, 20));
                    drawPanelBackgroundImage.setIcon(ic);
                    drawPanelBackgroundImage.setVerticalAlignment(jl.CENTER);
                    drawPanelBackgroundImage.setHorizontalAlignment(jl.CENTER);
                    //Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
                    //drawPanelBackgroundImage.setBorder(border);
                    drawPanelBackgroundImage.setSize(jPanel6.getSize());
                    //System.out.println("jl size : " + drawPanelBackgroundImage.getSize());
                    drawPanelBackgroundImage.setVisible(true);
                    jPanel6.add(drawPanelBackgroundImage);
                    jPanel6.repaint();
                    }
                }
            });
            //backgroundPanel.setSize(new Dimension(36, 36));
            System.out.println("Background Image Panel Size : " + backgroundPanel.getSize());
            jPanel18.add(backgroundPanel);
        }
        //jPanel18.setLayout(new GridLayout(8, 4, 1, 1));
        jPanel18.setLayout(new GridLayout(5, 5,2,2));
        
        //End Back Ground Images

        //Add JPanels and Decorative Items
//        File decorativeFiles = new File("resources\\decorative\\4040\\");
//        String decorativeStr[] = decorativeFiles.list();
////        for (int i = 0; i < decorativeStr.length; i++) {
////            System.out.println("Name : " + backgroungStr[i]);
////        }
//        //Icon icon1 = new ImageIcon("C:\\Users\\Shree\\Documents\\NetBeansProjects\\IndiaFont(14-11-2017)\\resources\\5050\\5_40x40.png");
//        jPanel21.setLayout(new GridLayout(10, 4,2,2));
//        for (int i = 0; i < decorativeStr.length; i++) {
//            JSVGCanvas svgCanvas = new JSVGCanvas();
//            System.out.println("resources\\decorative\\4040\\" + decorativeStr[i]);
//            Icon icon = new ImageIcon("resources\\decorative\\4040\\" + decorativeStr[i]);
//            File f=new File("resources\\decorative\\4040\\" + decorativeStr[i]);
//            JPanel decorativePanel = new JPanel();
//            //JLabel decorativeLabel = new JLabel();
//            decorativePanel.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    System.out.println("Click on  Decorative Panel");
//                }
//            });
//            //JLabel jl = new JLabel();
//           // jl.setIcon(icon);
//            //decorativePanel.add(jl);
//            
//             try {
//                 System.out.println("*****************############"+f.toURL().toString());
//                        svgCanvas.setURI(f.toURL().toString());
//                        svgCanvas.setVisible(true);
//                        decorativePanel.add("center",svgCanvas);
//                        
//                    
//              
//            decorativePanel.setLayout(new GridLayout());
//            decorativePanel.setBackground(Color.white);
//            decorativePanel.setSize(20, 20);
//            decorativePanel.setMaximumSize(new Dimension(20, 20));
//            decorativePanel.setPreferredSize(new Dimension(20, 20));
//            decorativePanel.setMinimumSize(new Dimension(20, 20));
//            decorativePanel.setMaximumSize(new Dimension(20,20));
//            //decorativeLabel.add(decorativePanel);
//
//            //decorativePanel.setSize(new Dimension(50,50));
//            System.out.println("Decorative Item Panel Size : " + decorativePanel.getSize());
//            
//            jPanel21.add(decorativePanel);
//            } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//        }
//        //jPanel21.setLayout(new GridLayout(10, 8,4,4));
//        
        //End

        //Set height and width ti Menus and sub menus
        //jMenuItem17.setAccelerator(KeyStroke.getKeyStroke(']', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        //this.repaint();

    }
    
    public static void chageImageSize(String path){
            try{
                
                System.out.println("Pathe is : "+path);
		File folder = new File(path);
	    File[] listOfFiles = folder.listFiles();
		System.out.println("Total No of Files:"+listOfFiles.length);
		java.awt.Image img = null;
		BufferedImage tempPNG = null;
		BufferedImage tempJPG = null;
		File newFilePNG = null;
		File newFileJPG = null;
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        img = ImageIO.read(new File(path+listOfFiles[i].getName()));
		        tempPNG = resizeImage(img, 55, 80);
		        tempJPG = resizeImage(img, 55, 80);
		        newFilePNG = new File("resources/background/4040/"+listOfFiles[i].getName());
		        newFileJPG = new File("resources/background/4040/"+listOfFiles[i].getName());
		        ImageIO.write(tempPNG, "png", newFilePNG);
		        ImageIO.write(tempJPG, "jpg", newFileJPG);
		      }
		}
		System.out.println("DONE");
            }catch(Exception e){}
            
        }
    
    public static void chageImageSizePanel(String path){
            try{
                
                System.out.println("Pathe is : "+path);
		File folder = new File(path);
	    File[] listOfFiles = folder.listFiles();
		System.out.println("Total No of Files:"+listOfFiles.length);
		java.awt.Image img = null;
		BufferedImage tempPNG = null;
		BufferedImage tempJPG = null;
		File newFilePNG = null;
		File newFileJPG = null;
		for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        img = ImageIO.read(new File(path+listOfFiles[i].getName()));
		        tempPNG = resizeImage(img, 1920, 1080);
		        tempJPG = resizeImage(img, 1920, 1080);
		        newFilePNG = new File("resources/background/panel/"+listOfFiles[i].getName());
		        newFileJPG = new File("resources/background/panel/"+listOfFiles[i].getName());
		        ImageIO.write(tempPNG, "png", newFilePNG);
		        ImageIO.write(tempJPG, "jpg", newFileJPG);
		      }
		}
		System.out.println("DONE");
            }catch(Exception e){}
            
        }

	/**
	 * This function resize the image file and returns the BufferedImage object that can be saved to file system.
	 */
	public static BufferedImage resizeImage(final java.awt.Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
    
    public String[] getFilesNameList(){
        File backgroundFiles = new File("resources\\background\\panel");
        String backgroungStr[] = backgroundFiles.list();
        return backgroungStr;
    }
    
    //Grid Code Add 
//    public void grid(){
//        new javax.swing.JPanel(){
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            System.out.println("Paint");
//            //Grid start
//            
//            int sideLength = 8;
//            int nRowCount = getHeight() / sideLength;
//            int currentX = sideLength;
//            for (int i = 0; i < nRowCount; i++) {
//                g.setColor(new Color(240, 243, 244));
//                g.drawLine(0, currentX, getWidth(), currentX);
//                currentX = currentX + sideLength;
//            }
//
//            int nColumnCount = getWidth() / sideLength;
//              
//            int currentY = sideLength;
//            for (int i = 0; i < nColumnCount; i++) {
//                g.drawLine(currentY, 0, currentY, getHeight());
//                currentY = currentY + sideLength;
//            }
//            g.setColor(Color.white);
//        }
//
//};
//    }

    public int count() {
        Component[] comp = jPanel6.getComponents();
        int cout = 0;
        for (int i = 0; i < comp.length; i++) {
            cout++;
        }

        return cout;
    }

    //Read Jpanel6 as a image in java
    public BufferedImage createImage(JPanel panel) {

        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    //Shapes Code Start
    private Resizable res;

    //Draw Circle
    public void circle(int width, int height) {

        //JPanel pnl = new JPanel(null);
        CirclePanel panel = new CirclePanel();

        res = new Resizable(panel);
        res.setBounds(50, 50, 200, 150);
        jPanel6.add(res);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {

                requestFocus();
                res.repaint();
            }
        });
        System.out.println("Width : " + width + "Height : " + height);
        setSize(width, height);
    }

    //Rectangle Code
    private void Rect(int width, int height) {

        //JPanel pnl = new JPanel(null);
        JPanel area = new JPanel();
        res = new Resizable(area);
        res.setBounds(50, 50, 200, 150);
        jPanel6.add(res);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {

                requestFocus();
                res.repaint();
            }
        });
        System.out.println("Width : " + width + "Height : " + height);
        setSize(width, height);
    }

    //Draw line
    public void line(int width, int height) {
        LinePanel panel = new LinePanel();

        res = new Resizable(panel);
        res.setBounds(50, 50, 200, 150);
        jPanel6.add(res);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {

                requestFocus();
                res.repaint();
            }
        });
        System.out.println("Width : " + width + "Height : " + height);
        setSize(width, height);
    }

    //Draw hexgon
    public void hex(int width, int height) {
        HexagonPanel panel = new HexagonPanel();

        res = new Resizable(panel);
        res.setBounds(50, 50, 200, 150);
        jPanel6.add(res);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {

                requestFocus();
                res.repaint();
            }
        });
        System.out.println("Width : " + width + "Height : " + height);
        setSize(width, height);
    }

    //End Of Shapes
    //Get File name and Path
    public String getPathAndName() {
        JFileChooser c = new JFileChooser();
        String result = "fail";
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(LandingPage.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getSelectedFile().getName());
            System.out.println(c.getCurrentDirectory().toString());
            result = saveFile(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
        }
        return result;
    }

    private String showOpenFileDialog() {
        String result1 = "fail";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("default.png"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        //fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG Document", "jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images JPG", "jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images PNG", "png"));
        fileChooser.setAcceptAllFileFilterUsed(true);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            //result1 = saveFile(fileChooser.getCurrentDirectory().toString() + "\\" + fileChooser.getSelectedFile().getName());
            result1 = saveFile(selectedFile.getAbsolutePath());

        }
        return result1;
    }
    
    private String showOpenFileDialogForJPG() {
        String result1 = "fail";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setSelectedFile(new File("default.jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        //fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JPG Document", "jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images JPG", "jpg"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images PNG", "png"));
        fileChooser.setAcceptAllFileFilterUsed(true);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            //result1 = saveFile(fileChooser.getCurrentDirectory().toString() + "\\" + fileChooser.getSelectedFile().getName());
            result1 = saveFile1(selectedFile.getAbsolutePath());

        }
        return result1;
    }

    //Get name for PDF
    public String getPathAndNameForPDF() {
        JFileChooser c = new JFileChooser();
        c.setSelectedFile(new File("default.svg"));
        String result = "fail";
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(LandingPage.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getSelectedFile().getName());
            System.out.println(c.getCurrentDirectory().toString());
            result = savePDFFile(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
        }
        return result;
    }
    //

    //Export File in particular Folder 
    public String saveFile(String value) {
        //String value=getPathAndName();
        String result = "fail";
        BufferedImage bi = createImage(jPanel6);
        Graphics2D ig2 = bi.createGraphics();
        try {
            ImageIO.write(bi, "PNG", new File(value));
            //JOptionPane.showMessageDialog(this, "Export Image Successuflly");
            result = "success";
        } catch (IOException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public String savePDFFile(String value) {
            String result = "fail"; 
 		DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
 		String namespaceURI = SVGConstants.SVG_NAMESPACE_URI;
 		org.w3c.dom.Document domFactory = impl.createDocument(namespaceURI, "svg", null);
 		SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(domFactory);
 		ctx.setEmbeddedFontsOn(true);
 		GraphicContextDefaults defaults = new GraphicContextDefaults();
 		defaults.setFont(new Font("Arial", Font.PLAIN, 12));
 		ctx.setGraphicContextDefaults(defaults);
 		ctx.setPrecision(12);

 		SVGGraphics2D g2d = new SVGGraphics2D(ctx, false);
                g2d.setSVGCanvasSize(new Dimension(getWidth(),getHeight()));
 		jPanel6.paintComponents(g2d);
 		PDFTranscoder pdfTranscoder = new PDFTranscoder();
 		
// 		pdfTranscoder.addTranscodingHint(PDFTranscoder.KEY_MAX_HEIGHT,new Float(19200)); 
// 		pdfTranscoder.addTranscodingHint(PDFTranscoder.KEY_MAX_WIDTH,new Float(19200));
 			  
 			  org.w3c.dom.Document doc = g2d.getDOMFactory(); 
 			 org.w3c.dom.Element rootE = doc.getDocumentElement(); 
 			  g2d.getRoot(rootE); 
 			  org.apache.batik.transcoder.TranscoderInput input = new org.apache.batik.transcoder.TranscoderInput(doc); 
 			  FileOutputStream ostream = null;
 			try {
 				ostream = new FileOutputStream(value+"_vector.pdf");
                                result="success";
 			} catch (FileNotFoundException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} 
 			  final BufferedOutputStream bufStream = new BufferedOutputStream(ostream); 
 			  org.apache.batik.transcoder.TranscoderOutput output = new org.apache.batik.transcoder.TranscoderOutput(bufStream); 
 			  // save the image 
 			  try {
 				pdfTranscoder.transcode(input, output);
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} 
 			  // flush and close the stream then exit 
 			  try {
 				ostream.flush();
 				ostream.close();
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 		 return result;
    }
    
    //Get name for Save
    public String getSaveFile() {
        JFileChooser c = new JFileChooser();
        String result = "fail";
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(LandingPage.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getSelectedFile().getName());
            System.out.println(c.getCurrentDirectory().toString());
            result = saveFile1(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
        }
        return result;
    }
    //

    //Export File in particular Folder 
    public String saveFile1(String value) {
        //String value=getPathAndName();
        String result = "fail";
        BufferedImage bi = createImage(jPanel6);
        Graphics2D ig2 = bi.createGraphics();
        try {
            ImageIO.write(bi, "JPG", new File(value+".jpg"));
            //JOptionPane.showMessageDialog(this, "Export Image Successuflly");
            result = "success";
        } catch (IOException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    //Save into .if
    public String getIfFileName() {
        JFileChooser c = new JFileChooser();
        c.setSelectedFile(new File("default.svg"));
        String result = "fail";
        // Demonstrate "Save" dialog:
        int rVal = c.showSaveDialog(LandingPage.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getSelectedFile().getName());
            System.out.println(c.getCurrentDirectory().toString());
            result = saveIFFile(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
        }
        return result;
    }
    
     public String saveIFFile(String value) {
         String result = "fail"; 
 		DOMImplementation impl = GenericDOMImplementation.getDOMImplementation();
 		String namespaceURI = SVGConstants.SVG_NAMESPACE_URI;
 		org.w3c.dom.Document domFactory = impl.createDocument(namespaceURI, "svg", null);
 		SVGGeneratorContext ctx = SVGGeneratorContext.createDefault(domFactory);
 		ctx.setEmbeddedFontsOn(true);
 		GraphicContextDefaults defaults = new GraphicContextDefaults();
 		defaults.setFont(new Font("Arial", Font.PLAIN, 12));
 		ctx.setGraphicContextDefaults(defaults);
 		ctx.setPrecision(12);

 		SVGGraphics2D g2d = new SVGGraphics2D(ctx, false);
                g2d.setSVGCanvasSize(new Dimension(getWidth(),getHeight()));
 		jPanel6.paintComponents(g2d);
                
                BufferedImage bi = createImage(jPanel6);
                
                Graphics2D ig2 = bi.createGraphics();
        try {
            ImageIO.write(bi, "SVG", new File(value+".svg"));
            //JOptionPane.showMessageDialog(this, "Export Image Successuflly");
            result = "success";
        } catch (IOException ex) {
            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
            return result;
    }
     
     //End
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel18 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel6 = new com.View.ArtPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(93, 93, 93));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel8.setBackground(new java.awt.Color(64, 64, 65));
        jPanel8.setPreferredSize(new java.awt.Dimension(226, 535));

        jPanel13.setBackground(new java.awt.Color(73, 73, 73));

        jPanel14.setBackground(new java.awt.Color(64, 64, 65));

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(167, 169, 171));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" Color Swatches");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jScrollPane3.setAutoscrolls(true);

        jPanel15.setBackground(new java.awt.Color(73, 73, 73));
        jPanel15.setForeground(new java.awt.Color(102, 102, 102));
        jPanel15.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel15);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel16.setBackground(new java.awt.Color(73, 73, 73));

        jPanel17.setBackground(new java.awt.Color(64, 64, 65));

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(167, 169, 171));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("   Background Images");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        jPanel18.setBackground(new java.awt.Color(73, 73, 73));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel18);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBackground(new java.awt.Color(64, 64, 65));

        jPanel7.setBackground(new java.awt.Color(73, 73, 73));
        jPanel7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel7.setAutoscrolls(true);
        //jPanel7.setLayout(new GridLayout(1,12,10,10));
        //for(int i=0;i<12;i++){
            //    JLabel lbl=new JLabel();
            //    lbl.setSize(10, 10);
            //    fontVariationLabel[i]=lbl;
            //    jPanel7.add(fontVariationLabel[i]);
            //}

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Letter Variables");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(1035, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(672, 31));

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Font");

        jComboBox1.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(fontComboBoxModel);

        //jComboBox1.setModel(fontComboBoxModel);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Size");

        jComboBox2.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        for(int i=12;i<=72;i+=2){
            jComboBox2.addItem(""+i);
        }
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setPreferredSize(new java.awt.Dimension(79, 28));

        jPanel50.setBackground(new java.awt.Color(51, 51, 51));
        jPanel50.setPreferredSize(new java.awt.Dimension(16, 15));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder/Left.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

        jPanel51.setBackground(new java.awt.Color(51, 51, 51));
        jPanel51.setPreferredSize(new java.awt.Dimension(16, 15));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder/Middle.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

        jPanel52.setBackground(new java.awt.Color(51, 51, 51));
        jPanel52.setPreferredSize(new java.awt.Dimension(16, 15));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder/Right.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jLabel15))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder (2)/indiay font symbol 1.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(84, 15));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(100, 15));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder (2)/indiay font symbol 3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
        );

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/New folder (2)/indiay font symbol 2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setPreferredSize(new java.awt.Dimension(19, 19));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon1/03 Text Tool - Standard.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(19, 19));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel47.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(823, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jMenuBar1.setBackground(new java.awt.Color(72, 72, 72));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(175, 31));

        jMenu9.setPreferredSize(new java.awt.Dimension(12, 5));
        jMenuBar1.add(jMenu9);

        jMenu1.setForeground(new java.awt.Color(167, 169, 171));
        jMenu1.setText("File     ");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(40, 19));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jMenu1MouseEntered(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setText("New");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setText("Open");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Save");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenu7.setText("Export");
        jMenu7.setPreferredSize(new java.awt.Dimension(213, 30));

        jMenuItem15.setText("JPG");
        jMenuItem15.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuItem16.setText("PNG");
        jMenuItem16.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem16);

        jMenuItem39.setText("PDF");
        jMenuItem39.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem39);

        jMenu1.add(jMenu7);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Close");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Exit");
        jMenuItem14.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(167, 169, 171));
        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(40, 19));

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Undo");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Redo");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Cut");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Copy");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem8.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenuItem8MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Paste");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem9MouseClicked(evt);
            }
        });
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem10.setText("Delete");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu11.setForeground(new java.awt.Color(167, 169, 171));
        jMenu11.setText("Activation");
        jMenu11.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jMenu11.setPreferredSize(new java.awt.Dimension(72, 19));

        jMenuItem43.setText("Buy Now!");
        jMenuItem43.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem43);

        jMenuItem44.setText("Activate Now");
        jMenuItem44.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem44);

        jMenuBar1.add(jMenu11);

        jMenu4.setForeground(new java.awt.Color(167, 169, 171));
        jMenu4.setText("Help");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jMenu4.setMaximumSize(new java.awt.Dimension(40, 32767));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });

        jMenu8.setText("Guidline of Use");
        jMenu8.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu8.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu8MenuSelected(evt);
            }
        });

        jMenuItem26.setText("Basic");
        jMenuItem26.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu8.add(jMenuItem26);

        jMenuItem25.setText("Letter Variables");
        jMenuItem25.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu8.add(jMenuItem25);

        jMenuItem27.setText("Applying Background");
        jMenuItem27.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu8.add(jMenuItem27);

        jMenuItem28.setText("Decorative Items");
        jMenuItem28.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu8.add(jMenuItem28);

        jMenu4.add(jMenu8);

        jMenuItem29.setText("Hindi / Marathi Keyboard");
        jMenuItem29.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu4.add(jMenuItem29);

        jMenuItem22.setText("About IndiaFont");
        jMenuItem22.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu4.add(jMenuItem22);
        jMenu4.add(jSeparator5);

        jMenuItem23.setText("Terms & Conditions");
        jMenuItem23.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu4.add(jMenuItem23);

        jMenuItem24.setText(" Disclaimer");
        jMenuItem24.setPreferredSize(new java.awt.Dimension(213, 30));
        jMenu4.add(jMenuItem24);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
//        try {
//            // TODO add your handling code here:
//            //File file=new File("E:\\java_tutorial.pdf");
//            String file = "resources\\Requirements of IndiaFont Software.pdf";
//            PDFViewer.setup(file);
//            //PDFViewer.display(file);
//        } catch (IOException ex) {
//            //Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        JFileChooser c = new JFileChooser();
        String result = "fail";
        // Demonstrate "Save" dialog:
        int rVal = c.showOpenDialog(LandingPage.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            System.out.println(c.getSelectedFile().getName());
            System.out.println(c.getCurrentDirectory().toString()+ "\\" + c.getSelectedFile().getName());
            String path=c.getCurrentDirectory().toString()+ "\\" + c.getSelectedFile().getName();
            try {
                //result = savePDFFile(c.getCurrentDirectory().toString() + "\\" + c.getSelectedFile().getName());
                BufferedImage img=ImageIO.read(new File(path));
                new JPanel(){
              public void paintComponent(Graphics g){
                  g.drawImage(img, 0, 0, jPanel6);
              }
              
            };
            } catch (IOException ex) {
                Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            JLabel jlb=new JLabel();
            jlb.setIcon(new ImageIcon(c.getCurrentDirectory().toString()+ "\\" + c.getSelectedFile().getName()));
            jlb.setSize(jPanel6.getSize());
            jlb.setVisible(true);
            jPanel6.add(jlb);
            repaint();
        }
        if (rVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("You pressed cancel");
            System.out.println("");
        }
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new LandingPage().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:

        //String value = getPathAndName();
        String value = showOpenFileDialog();
        JOptionPane.showMessageDialog(this, value);
//         BufferedImage bi= createImage(jPanel6);
//        Graphics2D ig2 = bi.createGraphics();
//        try {
//            ImageIO.write(bi, "PNG", new File(value));
//            JOptionPane.showMessageDialog(this, "Export Image Successuflly");
//        } catch (IOException ex) {
//            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        //String value = getPathAndName();
        String value = showOpenFileDialogForJPG();
        JOptionPane.showMessageDialog(this, value);
//        System.out.println("Value is  : " +value);
//       BufferedImage bi= createImage(jPanel6);
//        Graphics2D ig2 = bi.createGraphics();
//        try {
//            ImageIO.write(bi, "JPG", new File(value));
//            JOptionPane.showMessageDialog(this, "Export Image Successuflly");
//        } catch (IOException ex) {
//            Logger.getLogger(LandingPage.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenu8MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu8MenuSelected
        // TODO add your handling code here:
        //jMenu8.setBackground(Color.red);
    }//GEN-LAST:event_jMenu8MenuSelected

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        // TODO add your handling code here:
        String value = getPathAndNameForPDF();
        JOptionPane.showMessageDialog(this, value);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        // TODO add your handling code here:
        //Add by Ajinkya
        //this.setVisible(false);
        boolean flag = false;
        try {
            File files = new File("resources\\secretekey.txt");
            Scanner scan = new Scanner(files);
            String cdKey = scan.nextLine();
            String startDate = scan.nextLine();
            String endDate = scan.nextLine();
            Date sd = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").parse(startDate);
            Date ed = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").parse(endDate);
            Date testDate = new Date();
            flag = (testDate.after(sd) && testDate.before(ed));

            if (flag) {
                String exipreDate = " Your trial period expired in " + getDateDifference(endDate);
                //JOptionPane.showMessageDialog(null, exipreDate, "Triel version details", JOptionPane.INFORMATION_MESSAGE);
                //new ActivationKey(exipreDate).setVisible(true);
                System.out.println("*---*-*-*-*-*-**-" + exipreDate);
                new ActivationKey(exipreDate).setVisible(true);
//                try {
//                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Nimbus".equals(info.getName())) {
//                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                            break;
//                        }
//                    }
//                } catch (ClassNotFoundException ex) {
//                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (InstantiationException ex) {
//                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//                }
                //</editor-fold>

//                /* Create and display the form */
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//                        new LandingPage().setVisible(true);
//                    }
//                });
            } else {
                JOptionPane.showMessageDialog(null, "Your trial version is expired.", "Expire", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            new ActivationForm().setVisible(true);
            e.printStackTrace();
        }
        //End

    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        // TODO add your handling code here:
        try {
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://indiafont.in/product/ams-aaditya-3\"");
        } catch (Exception e) {
        }
        /*
        //old code repalce by above new on 3-Dec-2017
        System.out.println("Font Menu Click");
        JDialog fontDialog = new JDialog(this);
        fontDialog.add(new FontView());
        fontDialog.setLocationRelativeTo(this);
        fontDialog.setBounds(350, 200, 300, 500);
        fontDialog.setVisible(true);
         */
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseEntered
        // TODO add your handling code here:
        jMenu1.setBackground(Color.decode("#FF0000"));
    }//GEN-LAST:event_jMenu1MouseEntered

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Value :- " + jta.getPropertyChangeListeners());
//        String value = getIfFileName();
//        JOptionPane.showMessageDialog(this, value);

System.out.println("**-*-JTextEditorList :-- "+jPanel6.textBoxList);
 System.out.println("**-*-JTextEditorList :-- "+jPanel6.textEditorBox.toString());
        Component[] cm=jPanel6.getComponents();
        System.out.println("Size of Component Array is : "+cm.length);
        save(cm);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void save(Component[] comps) {
                
		chooser.setCurrentDirectory(new File("."));
		if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			FileOutputStream out = null;
			try {
				File file = chooser.getSelectedFile();
				File newFile = new File(file.getName()+".if");
				file.renameTo(newFile);
				out = new FileOutputStream(file);
				XMLEncoder encoder = new XMLEncoder(out);
//                                for(int i=0;i<comps.length;i++){
//                                    System.out.println("*-*-*-*-"+comps[i]);
                                    encoder.writeObject(comps);
                                //}
				encoder.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}

	}
    
    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
        jPanel52.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        jPanel52.setBackground(Color.decode("#58585B"));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        jPanel52.setBackground(Color.decode("#232323"));
        //        jPanel28.setBackground(new Color(51,51,51));
        //jPanel29.setBackground(new Color(51,51,51));
        //jPanel30.setBackground(new Color(51,51,51));
        //jPanel34.setBackground(new Color(51,51,51));
        //jPanel42.setBackground(new Color(51,51,51));
        //jPanel50.setBackground(new Color(51,51,51));
        //jPanel51.setBackground(new Color(51,51,51));
        jPanel6.textEditorBox.changeTextAlignment("right");
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
        jPanel51.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        jPanel51.setBackground(Color.decode("#58585B"));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        jPanel51.setBackground(Color.decode("#232323"));
        //        jPanel28.setBackground(new Color(51,51,51));
        //jPanel29.setBackground(new Color(51,51,51));
        //jPanel30.setBackground(new Color(51,51,51));
        //jPanel34.setBackground(new Color(51,51,51));
        //jPanel42.setBackground(new Color(51,51,51));
        //jPanel50.setBackground(new Color(51,51,51));
        //jPanel52.setBackground(new Color(51,51,51));
        jPanel6.textEditorBox.changeTextAlignment("center");
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        jPanel50.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jPanel50.setBackground(Color.decode("#58585B"));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        jPanel50.setBackground(Color.decode("#232323"));
        //        jPanel28.setBackground(new Color(51,51,51));
        //jPanel29.setBackground(new Color(51,51,51));
        //jPanel30.setBackground(new Color(51,51,51));
        //jPanel34.setBackground(new Color(51,51,51));
        //jPanel42.setBackground(new Color(51,51,51));
        //jPanel51.setBackground(new Color(51,51,51));
        //jPanel52.setBackground(new Color(51,51,51));
        jPanel6.textEditorBox.changeTextAlignment("left");
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        Object fontSelector = jComboBox1.getSelectedItem();
        Object fontSize = jComboBox2.getSelectedItem();
        fontNameStr = fontSelector.toString();
        fontSizeStr = fontSize.toString();
        jPanel6.setFontName(fontNameStr);
        jPanel6.setFontSize(fontSizeStr);
        jPanel6.textEditorBox.changeFontOrSize(fontNameStr, fontSizeStr);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Object fontSelector = jComboBox1.getSelectedItem();
        Object fontSize = jComboBox2.getSelectedItem();
        fontNameStr = fontSelector.toString();
        fontSizeStr = fontSize.toString();
        jPanel6.setFontName(fontNameStr);
        jPanel6.setFontSize(fontSizeStr);
        jPanel6.textEditorBox.changeFontOrSize(fontNameStr, fontSizeStr);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jPanel28.setBackground(new Color(51, 51, 51));
        //        System.out.println("jPanel28 Size : "+jPanel28.getSize());
        //        jLabel1.setIcon(null);
        //        ImageIcon imageIcon = new ImageIcon("resources\\New Icon\\icons\\03 Text Tool - Standard.png");
        //        //JLabel label = new JLabel(imageIcon);
        //        jLabel1.setIcon(imageIcon);
        //        jLabel1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jPanel28.setBackground(Color.decode("#58585B"));
        System.out.println("Jpanel Position : "+jPanel28.getLocation());
        //        System.out.println("jPanel28 Size : "+jPanel28.getSize());
        //        jLabel1.setIcon(null);
        //        ImageIcon imageIcon = new ImageIcon("resources\\New Icon\\icons\\1.png");
        //        //JLabel label = new JLabel(imageIcon);
        //        jLabel1.setIcon(imageIcon);
        //        jLabel1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        //int count=count();
        jPanel28.setBackground(Color.decode("#232323"));
        //       jPanel29.setBackground(new Color(51,51,51));
        //jPanel30.setBackground(new Color(51,51,51));
        //jPanel34.setBackground(new Color(51,51,51));
        //jPanel42.setBackground(new Color(51,51,51));
        //jPanel50.setBackground(new Color(51,51,51));
        //jPanel51.setBackground(new Color(51,51,51));
        //jPanel52.setBackground(new Color(51,51,51));
        setCursor(new Cursor(Cursor.TEXT_CURSOR));
        drawText = true;
        jPanel6.setDrawTextBox(true);
        jPanel2.setVisible(true);
        jPanel9.setVisible(true);
        jPanel11.setVisible(true);
        jPanel25.setVisible(true);
        jPanel26.setVisible(true);
        jPanel27.setVisible(true);

        //this new code is added by Sumit to get Multiple TextPane on Single ArtBoard : Start
        /*TextEditorView textEditor=new TextEditorView(this);
        textEditorList.add(textEditor);
        jta=textEditor;*///commented on 27-Nov-2017
        //this code is added by Sumit to get Multiple TextPane on Single ArtBoard : End
        /* //old code : This code is comment because of added new code (refer above code)
        jta.setVisible(true);
        Color c = new Color(240, 240, 240);
        jta.setBackground(c);
        jta.setSize(200, 100);
        jta.setLocation(10, 10);
        jta.setEditable(false);
        //jta.setEnabled(false);
        //jta.setDragEnabled(true);
        Border border = BorderFactory.createDashedBorder(Color.BLACK);
        jta.setBorder(border);
        DragListener drag = new DragListener();
        jta.addMouseListener(drag);
        jta.addMouseMotionListener(drag);
        jta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 0) {
                    Color c = new Color(255, 255, 255);
                    jta.setBackground(c);
                    jta.setEditable(true);
                    String firstSelectedChar;
                    String text = jta.getText();
                    int selectionStart = jta.getSelectionStart();
                    firstSelectedChar = text.substring(selectionStart, selectionStart + 1);
                    System.out.println("Value is : " + firstSelectedChar);

                    //this code aaded by Sumit to get variations of selected Character : start
                    getVariationForSelectedCharacter(firstSelectedChar,selectionStart);
                    //this code aaded by Sumit to get variations of selected Character : End

                } else {
                    Color c = new Color(240, 240, 240);
                    jta.setBackground(c);
                    jta.setEditable(false);
                }
            }
        });
        //        jta.addMouseListener(new MouseAdapter() {
            //            public void mouseClicked(MouseEvent e){
                //                if(e.getClickCount()==2){
                    //                    jta.setEditable(true);
                    //                }
                //            }
            //        });
    jPanel6.add(jta);
    repaint();*/
    //jPanel6.add(jta);
    //textEditorList.add(jta);
    //repaint();
    //x = y = x2 = y2 = 0; //
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        jPanel6.textEditorBox.deleteThisTextBoxFromArtPanel(); // to Delete TextBox
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        jPanel6.textEditorBox.getCloneOfTextEditorBox();// to Paste TextBox
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem9MouseClicked
        // TODO add your handling code here:
        //        jta.setSize(100, 100);
        //
        //        Color c = new Color(240, 240, 240);
        //        jta.setBackground(c);
        //        jta.setLocation(50, 50);
        //        Border border = BorderFactory.createDashedBorder(Color.BLACK);
        //        jta.setBorder(border);
        //        jta.setVisible(true);
        //        jPanel6.add(jta);
        //        repaint();
    }//GEN-LAST:event_jMenuItem9MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jPanel6.textEditorBox.isClonable=true; // to Copy TextBox
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem8MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuItem8MenuKeyPressed
        // TODO add your handling code here:
        //TextEditorView j = new TextEditorView(this);
        //jta = j;
    }//GEN-LAST:event_jMenuItem8MenuKeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jPanel6.textEditorBox.new UndoActionListener(TextEditorBox.UndoActionType.REDO);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jPanel6.textEditorBox.new UndoActionListener(TextEditorBox.UndoActionType.UNDO);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void addFontIntoComboBox(String fontName) {
        fontComboBoxModel.addElement(fontName);
        jComboBox1.setModel(fontComboBoxModel);
        System.out.println("Items Size : " + jComboBox1.getItemCount());

    }

    /**
     * THis method is use to display purchase dialog box which accept download
     * lick from user and pass request to download file from given link
     *
     * @since 26-Oct-2017
     */
    public void purchaseFontDialog(String fontName) {
        JDialog fontDialog = new JDialog(this, "Download Font");
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Enter Purchase Link");
        JTextField txt = new JTextField(50);
        JButton btnDownload = new JButton("Download");

        btnDownload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String downloadLink = txt.getText();
                System.out.println("Download Key :- " + downloadLink);
                String[] a = downloadLink.split(",");
                System.out.println("Size of a : " + a.length);
                for (String key : a) {
                    try {
                        //old code which is use to download file by getting link
                        //JavaDownloadFileFromURL.downloadUsingStream(downloadLink, "C:/download/dwn.pdf");

                        //new code which is use to download file by random key
                        new JavaDownloadFileFromURL().callWebServiceAndGetFileLinkForDownload(key);
                        JOptionPane.showMessageDialog(fontDialog, "Font has been successfully download", "Download Success", JOptionPane.INFORMATION_MESSAGE);
                        addFontIntoComboBox(downloadLink);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(fontDialog, "Fail to download font", "Download Fail", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        panel.add(lbl);
        panel.add(txt);
        panel.add(btnDownload);
        fontDialog.add(panel);
        fontDialog.setLocationRelativeTo(this);
        fontDialog.setBounds(100, 100, 800, 100);
        fontDialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        boolean flag = false;
        try {
            File files = new File("resources\\secretekey.txt");
            Scanner scan = new Scanner(files);
            String cdKey = scan.nextLine();
            String startDate = scan.nextLine();
            String endDate = scan.nextLine();
            Date sd = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").parse(startDate);
            Date ed = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy").parse(endDate);
            Date testDate = new Date();
            flag = (testDate.after(sd) && testDate.before(ed));

            if (flag) {
                String exipreDate = " Your trial period expired in " + getDateDifference(endDate);
                //JOptionPane.showMessageDialog(null, exipreDate, "Triel version details", JOptionPane.INFORMATION_MESSAGE);
                new ActivationKey(exipreDate).setVisible(true);
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//                        new LandingPage().setVisible(true);
//                    }
//                });
            } else {
                JOptionPane.showMessageDialog(null, "Your trial version is expired.", "Expire", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            new ActivationForm().setVisible(true);
            e.printStackTrace();
        }

    }

    public static String getDateDifference(String endDate) {
        String remaningDate = "";
        SimpleDateFormat format = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");

        Date d1 = new Date();
        Date d2 = null;

        try {
            d2 = format.parse(endDate);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");
            remaningDate = diffDays + " days";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return remaningDate;
    }

//    /**
//     * This method is use to accept selected character and display
//     * variation(formation) for selected char
//     *
//     * @param selectedChar to accept selected character
//     * @since 7-Nov-2017
//     */
//    public void getVariationForSelectedCharacter(String selectedChar, final int selectedCharIndex) {
//        //String selectedCharUnicode=String.format("%04x", (int) selectedChar.charAt(0));
//        //System.out.println("******* : "+selectedCharUnicode);
//        //this code aaded by Sumit to get variations of selected Character : start
//        //ArrayList<Integer> list=FontUnicodeBundle.unicodeBundle.get(selectedChar);
//        ArrayList<String> listInString = FontUnicodeBundle.unicodeBundleArrayList;
//        jPanel7.removeAll();
//        jPanel7.setLayout(new GridLayout(1, 12, 2, 2));
//        jPanel7.setBorder(new EmptyBorder(2, 2, 2, 20));
//
//        for (String string : listInString) {
//            String variations[] = string.split(",");
//            ArrayList list = new ArrayList(Arrays.asList(variations));
//            if (list.contains((int) selectedChar.charAt(0) + "")) {
//                //String variations[]=string.split(",");
//                for (String variation : variations) {
//                    //for (Integer integer : list) { //old code
//                    //System.out.println((char)integer.intValue());
//                    JLabel lbl = new JLabel();
//                    String textAreaContent = jPanel6.textEditorBox.getText();
//                    lbl.addMouseListener(new MouseAdapter() {
//                        public void mouseClicked(MouseEvent e) {
//                            JLabel lbl = (JLabel) e.getSource();
//                            //to get replaced selected char
//                            String variationAppliedString = textAreaContent.replace(textAreaContent.charAt(selectedCharIndex), lbl.getText().charAt(0));
//                            jPanel6.textEditorBox.setText(variationAppliedString);
//                        }
//
//                    });
//
//                    lbl.setSize(lbl.getPreferredSize());
//                    lbl.setFont(selectedFont);
//                    lbl.setText("" + ((char) Integer.parseInt(variation)));
//                    lbl.setHorizontalTextPosition(JLabel.CENTER);
//                    jPanel7.add(lbl);
//                    Border paddingBorder = BorderFactory.createEmptyBorder(10, 5, 10, 5);
//                    //JLabel will be involved for this border
//                    Border border = BorderFactory.createLineBorder(Color.BLACK);
//                    lbl.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
//
//                }
//                break;
//            }
//        }
////                dig.setBounds(200, 200, 200, 200);
////                dig.setVisible(true);
//        this.validate();
//        this.repaint();
//        //this code aaded by Sumit to get variations of selected Character : End
//
//    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public JComboBox<String> getjComboBox2() {
        return jComboBox2;
    }

    @Override
    public JMenuBar getJMenuBar() {
        return super.getJMenuBar(); //To change body of generated methods, choose Tools | Templates.
    }

    class DrawGrid {

        protected void paintComponent(Graphics g) {
            System.out.println("Paint");
            //Grid start
            g.setColor(Color.lightGray);
            int sideLength = 10;
            int nRowCount = getHeight() / sideLength;
            int currentX = sideLength;
            for (int i = 0; i < nRowCount; i++) {
                g.setColor(Color.GRAY);
                g.drawLine(0, currentX, getWidth(), currentX);
                currentX = currentX + sideLength;
            }

            int nColumnCount = getWidth() / sideLength;
            int currentY = sideLength;
            for (int i = 0; i < nColumnCount; i++) {
                g.drawLine(currentY, 0, currentY, getHeight());
                currentY = currentY + sideLength;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private com.View.ArtPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
