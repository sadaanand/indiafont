/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.text.Caret;

/**
 *
 * @author SuMiT
 */
public class TextPanelMouseEventHandler extends MouseAdapter implements Serializable{
    TextEditorBox txBox;
    TextBoxResizable res;
    ArtPanel artPanel;

    public TextPanelMouseEventHandler() {
    }
    
    
    TextPanelMouseEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
        this.res=res;
        this.txBox=txBox;
        this.artPanel=artPanel;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int clickCount=e.getClickCount();
        artPanel.textEditorBox=txBox;
//        if(clickCount==1){
//            txBox.setEditable(false);
//        }
        if(clickCount==2){
            res.setBorder(BorderFactory.createEmptyBorder());
            txBox.setEditable(true);
            Caret caret=txBox.getCaret();
                caret.setBlinkRate(10);
            txBox.setCaret(caret);
            txBox.setCaretPosition(txBox.getDocument().getLength());
            res.revalidate();
            res.repaint();  
        }
    }
    
}
