/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

/**
 *
 * @author Eros Infotech
 */

//import com.itextpdf.text.pdf.PdfDocument;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.sun.pdfview.PagePanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class PDFViewer {
    
   // PDFPageNo ppno=new PDFPageNo();
	static int pageno=1;
    public static void setup(String path) throws IOException {
    
        //set up the frame and panel
        JFrame frame = new JFrame("Home Practices");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //Code To Set Icon to Frame Start
        // the path must be relative to your *class* files
//        String imagePath = "/DeskImg/Home/home practice logo.png";
//        InputStream imgStream = PDFViewer.class.getResourceAsStream(imagePath );
//        BufferedImage myImg = ImageIO.read(imgStream);
        // ImageIcon icon = new ImageIcon(myImg);

        // use icon here
//        frame.setIconImage(myImg);
        //Code To Set Icon to Frame End
        
        
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        JButton jb1=new JButton("Priveus");
        jb1.setSize(100, 20);
        jb1.setVisible(true);
        frame.add(jb1);
        
        JButton jb2=new JButton("Next");
        jb2.setSize(100, 20);
        jb2.setVisible(true);
        jb2.setLocation(800, 0);
        frame.add(jb2);
        
        JButton jb3=new JButton("Print");
        jb3.setSize(100, 20);
        jb3.setVisible(true);
        jb3.setLocation(800, 30);
        frame.add(jb3);
        
        PagePanel panel = new PagePanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        panel.setBorder(new LineBorder(Color.BLACK));
        frame.setSize(900, 1000);
        
        //load a pdf from a byte buffer
        File file = new File(path);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY,
            0, channel.size());
        PDFFile pdffile = new PDFFile(buf);
        int totalpageno=pdffile.getNumPages();
        
        PDFPage page = pdffile.getPage(1);
        panel.showPage(page);
        //panel.setSize(1000, 1000);
        
        //open next Page
        jb2.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent e)
        {
            pageno++;
            if(pageno<totalpageno){
                PDFPage p=pdffile.getPage(pageno);
                System.out.println("Next Page is "+pageno);
                panel.showPage(p);
            }
            else{
                jb2.setEnabled(false);
            }
          }
        }); 
        
        //open Previous page 
        jb1.addActionListener(new ActionListener()
        {
         public void actionPerformed(ActionEvent e)
        {
            pageno--;
            if(pageno<totalpageno){
                PDFPage p=pdffile.getPage(pageno);
                System.out.println("previous Page is "+pageno);
                panel.showPage(p);
            }
            else{
                jb2.setEnabled(false);
            }
          }
        });
        
    }
    
    public static void display(String path){
        try {

		if ((new File(path)).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler "+path);
			p.waitFor();

		} else {

			System.out.println("File is not exists");

		}

		System.out.println("Done");

  	  } catch (Exception ex) {
		ex.printStackTrace();
	  }
    }
    
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
//                try {
//                    PDFViewer.setup();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
            }
        });
    }
    
}


