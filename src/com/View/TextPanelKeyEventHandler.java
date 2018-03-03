/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Ajinkya
 */
public class TextPanelKeyEventHandler implements  KeyListener,Serializable{
    
    TextEditorBox txBox;
    TextBoxResizable res;
    ArtPanel artPanel;
    TextPanelKeyEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
        this.res=res;
        this.txBox=txBox;
        this.artPanel=artPanel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //This code use use to added bounded border when user click Esc button. Start
        if(code == KeyEvent.VK_ESCAPE){
            Dimension actualSize=res.getSize();
            Dimension requiredSize=res.getPreferredSize();
            if(actualSize.height<=requiredSize.height || actualSize.width <= requiredSize.width ){
                System.out.println("Esc Successfully");
                //txBox.g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                res.setSize(Integer.parseInt(((int)requiredSize.getWidth()+20)+""),Integer.parseInt(((int)requiredSize.getHeight()+20)+""));
                res.resize();
            }
            //txBox.setEditable(false);
            res.setBorder(new TextBoxResizableBorder(8));
            res.revalidate();
            res.repaint(); 
            txBox.isdeleteable=true;
        }//This code use use to added bounded border when user click Esc button. Ends
        
        String text = txBox.getSelectedText();
        //increment selected String font size by Crtl + > button : start
         if(code==46){           
            //int fontSize=getFont().getSize();
            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
            StyleConstants.getFontFamily(attrs);
            int fontSize=StyleConstants.getFontSize(attrs);
            int cursorPosition = txBox.getCaretPosition();
            StyleContext context = new StyleContext();
            Style style;
            txBox.replaceSelection("");
            style = context.addStyle("Parastyle", null);
            
            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize+2));
            int selectionStart=txBox.getSelectionStart();
            int selectionEnd=txBox.getSelectionEnd();
            try{
                txBox.getStyledDocument().insertString(selectionStart, text, style);
                txBox.setSelectionStart(selectionStart);
                txBox.setSelectionEnd(selectionStart+text.length());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }//increment selected String font size by Crtl + > button : Ends
         
        //Decrement selected String font size by Crtl + < button : start
        if(code==44){
            //int fontSize=getFont().getSize();
            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
            int fontSize=StyleConstants.getFontSize(attrs);
            int cursorPosition = txBox.getCaretPosition();
            StyleContext context = new StyleContext();
            Style style;
            txBox.replaceSelection("");
            style = context.addStyle("mystyle", null);
            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize-2));
           
            int selectionStart=txBox.getSelectionStart();
            int selectionEnd=txBox.getSelectionEnd();
            try{
                txBox.getStyledDocument().insertString(selectionStart, text, style);
                txBox.setSelectionStart(selectionStart);
                txBox.setSelectionEnd(selectionStart+text.length());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }//Decrement selected String font size by Crtl + < button : Ends
        
        //this is use to make JTextPane ready to paste calles after click on ctrl + c
        if(code==67){
            txBox.isClonable=true;
        }
        //this is use to create clone of the JTextPane (If User double click on JTextPane and ctrl+v)
        if(code==86){
            if(txBox.isClonable){
                try{
                    //TextEditorView txtView=(TextEditorView)this.clone();
                    TextEditorBox txtView=new TextEditorBox(artPanel, artPanel.variationPanel, txBox.x, txBox.y, txBox.fontName,txBox.fontSize,txBox.width,txBox.height);
                    StyledDocument styledDocument = txBox.getStyledDocument();   
                    Element element; 
                    Document doc2=txtView.getDocument();
                    doc2 = txtView.getDocument(); 
                    for(int i=0; i<styledDocument.getLength();i++) {
                        element = styledDocument.getCharacterElement(i);
                        AttributeSet attributeNew = element.getAttributes();   
                        System.out.println(i);
                        doc2.insertString(doc2.getLength(), styledDocument.getText(i, 1), attributeNew);
                    }
                    txtView.revalidate();
                    txtView.repaint();
                   // frame.textEditorList.add(txtView);
                    artPanel.validate();
                    artPanel.repaint();
                    
                    txBox.isClonable=false;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        
        //this code is use to delete the JTextPane From Jpanel
        if(code==127){
           txBox.deleteThisTextBoxFromArtPanel();
        }//Ends TextBox Deleted code
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String firstSelectedChar;
                    try{
                    String text = txBox.getText();
                    int selectionStart = txBox.getSelectionStart();
                    //firstSelectedChar = text.substring(selectionStart, selectionStart + 1);
                    firstSelectedChar = txBox.getDocument().getText(selectionStart, 1);
                    //this code aaded by Sumit to get variations of selected Character : start
                        txBox.getVariationForSelectedCharacter(firstSelectedChar,selectionStart);
                    //this code aaded by Sumit to get variations of selected Character : End
                    }catch(Exception ex){
                        //ex.printStackTrace();
                        System.err.println("No char Selected");
                    }
    }
}//key Event Handler Ends
