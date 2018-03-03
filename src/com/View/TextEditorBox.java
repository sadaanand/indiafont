/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.View;
//
//import com.model.FontUnicodeBundle;
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.GridLayout;
//import java.awt.Insets;
//import java.awt.Point;
//import java.awt.Rectangle;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.util.ArrayList;
//import java.util.Arrays;
//import javax.swing.BorderFactory;
//import javax.swing.JComponent;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextPane;
//import javax.swing.SwingConstants;
//import javax.swing.border.Border;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.CaretEvent;
//import javax.swing.event.CaretListener;
//import javax.swing.event.MouseInputAdapter;
//import javax.swing.event.MouseInputListener;
//import javax.swing.event.UndoableEditEvent;
//import javax.swing.event.UndoableEditListener;
//import javax.swing.text.AbstractDocument;
//import javax.swing.text.AttributeSet;
//import javax.swing.text.BoxView;
//import javax.swing.text.Caret;
//import javax.swing.text.ComponentView;
//import javax.swing.text.Document;
//import javax.swing.text.Element;
//import javax.swing.text.IconView;
//import javax.swing.text.LabelView;
//import javax.swing.text.MutableAttributeSet;
//import javax.swing.text.ParagraphView;
//import javax.swing.text.SimpleAttributeSet;
//import javax.swing.text.Style;
//import javax.swing.text.StyleConstants;
//import javax.swing.text.StyleContext;
//import javax.swing.text.StyledDocument;
//import javax.swing.text.StyledEditorKit;
//import javax.swing.text.View;
//import javax.swing.text.ViewFactory;
//import javax.swing.undo.UndoManager;
//import utils.FontSizeConverter;
//
//public class TextEditorBox extends  JTextPane{
//    ArtPanel artPanel;
//    TextBoxResizable res;
//    int x,y;
//    private UndoManager undoMgr__;
//    Font selectedFont;
//    String fontName,fontSize;
//    JPanel variationPanel;
//    boolean isClonable=false;
//    public void setFontName(String fontName) {this.fontName = fontName;}
//    public void setFontSize(String fontSize) {this.fontSize = fontSize;}
//    public void setVariationPanel(JPanel variationPanel) {this.variationPanel = variationPanel;}
//    
//    
//    
//    public TextEditorBox(ArtPanel artPanel,JPanel variationPanel,int x,int y,String fontName,String fontSize) {
//        this.artPanel=artPanel;
//        this.x=x;this.y=y;
//        this.variationPanel=variationPanel;
//        this.fontName=fontName;
//        this.fontSize=fontSize;
//        undoMgr__ = new UndoManager();
//        initCompoent();
//        
//        this.getDocument().addUndoableEditListener(new UndoEditListener());
//        res= new TextBoxResizable(this,BorderFactory.createEmptyBorder());
//        res.setBounds(x, y, 30, 40);
//        changeFontOrSize(fontName,fontSize);
//        addCaretListener(new TextPanelCaretEventHandler(this,res,artPanel));
//        addKeyListener(new TextPanelKeyEventHandler(this,res,artPanel));
//        addMouseListener(new TextPanelMouseEventHandler(this,res,artPanel));
//        addMouseMotionListener(new TextPanelMouseEventHandler(this,res,artPanel));
//        artPanel.add(res);
//        artPanel.textBoxList.add(res);
//        artPanel.textEditorBox=this;
//        refreshPanel();
//    }
//    
//    
//    public void initCompoent(){
//        setContentType("text/html");
//        setEditable(true);
//        setLocation(x, y);
//        setSize(10, 20);    
//        setEditorKit(new WrapEditorKit());
//        setBackground(new Color(0,0,0,0));
//        setVisible(true);
//    }
//    
//    public void refreshPanel(){
//        res.revalidate();
//        res.repaint();
//        artPanel.revalidate();
//        artPanel.repaint();
//    }
//
//    
//    
//    /**
//     * This method is use to set font and size to the text.
//     * This method gets called when user select font or size from Combo box.
//     * @param fontNameStr name of the selected font
//     * @param fontSizeStr size of the font
//     * @author Sumit
//     * Since : 18-Nov-2017 
//     */
//    public void changeFontOrSize(String fontNameStr,String fontSizeStr){
//        String editorContent = getText();
//        selectedFont= new FontSizeConverter().decryptFont(fontNameStr+".ttf", fontSizeStr);
//        //setFont= new FontSizeConverter().decryptFont(fontNameStr, "30");
//        setFont(selectedFont);
//        //setFont(setFont);
//        
//        MutableAttributeSet attr = new SimpleAttributeSet();
//        StyleConstants.setFontSize(attr, Integer.parseInt(fontSizeStr));
//        
//        //StyleConstants.setFontFamily(attr, family);
//        //StyleConstants.setFontFamily(attr, selectedFont.getFamily());
//        setCharacterAttributes( attr, false);
//        
//        //setText(editorContent);
//        refreshPanel();
//        requestFocusInWindow();
//    }
//    
//    /**
//     * This method is use to set foreground color to selected text
//     * This method gets called when user select text from TextPane and change color.
//     * @param color to get a color class object
//     * @author Sumit
//     * Since : 18-Nov-2017 
//     */
//    public void changeColorOfSelectedText(Color color){
//        SimpleAttributeSet attr = new SimpleAttributeSet(); 
//        StyleConstants.setForeground(attr, color);
//	setCharacterAttributes(attr, false);
//	refreshPanel();
//        requestFocusInWindow();
//        
//    }
//    
//    /**
//     * This method is use to change alignment of selected text
//     * @param alignment name of the alignment (left,right,center) 
//     * @author Sumit
//     * Since : 18-Nov-2017 
//     */
//    public void changeTextAlignment(String alignment){
//        StyledDocument doc = getStyledDocument();
//        SimpleAttributeSet simpleAttribute = new SimpleAttributeSet();
//        switch(alignment){
//            case "left" :
//                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_LEFT);
//                break;
//            case "right" :
//                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_RIGHT);
//                break;
//            case "center" :
//                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_CENTER);
//                break;
//        }
//        doc.setParagraphAttributes(getSelectionStart(), getSelectionEnd(), simpleAttribute, false);
//        refreshPanel();
//    }
//    
//    /**
//     * This method is use to accept selected character and display variation(formation) 
//     * for selected char
//     * @param selectedChar to accept selected character 
//     * @since 7-Nov-2017
//     */
//    public void getVariationForSelectedCharacter(String selectedChar,final int selectedCharIndex){
//            ArrayList<String> listInString=FontUnicodeBundle.unicodeBundleArrayList;
//            variationPanel.removeAll();
//            variationPanel.setLayout(new GridLayout(1,12,2,2));
//            variationPanel.setBorder(new EmptyBorder(2, 2, 2, 20));
//            for (String string : listInString) {
//                String variations[]=string.split(",");
//                ArrayList list=new ArrayList(Arrays.asList(variations));
//                if(list.contains((int)selectedChar.charAt(0)+"")){
//                    for (String variation : variations) { 
//                        JPanel jpanel=new JPanel();
//                    JLabel lbl=new JLabel();
//                    lbl.addMouseListener(new MouseAdapter() {
//                        public void mouseClicked(MouseEvent e) {
//                            JLabel lbl=(JLabel)e.getSource();
//                            int startSelectionIndex=getSelectionStart();
//                            int endSelectionIndex=getSelectionEnd();
//                            if(startSelectionIndex<endSelectionIndex && (endSelectionIndex-startSelectionIndex)==1){
//                                try{
//                                    replaceSelection(""+lbl.getText().charAt(0));
//                                    setSelectionStart(startSelectionIndex);
//                                    setSelectionEnd(startSelectionIndex+getSelectedText().length());
//                                    artPanel.textEditorBox.revalidate();
//                                    artPanel.textEditorBox.repaint();
//                                    
//                                }catch(Exception e1){
//                                    e1.printStackTrace();
//                                }
//                            }
//                            requestFocusInWindow();
//                        }
//                    });
//                    int height=variationPanel.getHeight();
//                    int width=variationPanel.getWidth()/12;
//                    //lbl.setSize(height,width);
//                    lbl.setPreferredSize(new Dimension(65,65));//to set the size of dynamically generated label
//                    Font selectedFont=this.selectedFont.deriveFont(20.0f);//code is use to se font size for label text
//                    lbl.setFont(selectedFont);
//                    lbl.setHorizontalTextPosition(JLabel.CENTER);
//                        //frame.getjPanel7().add(lbl);
//                    Border paddingBorder = BorderFactory.createEmptyBorder(10,5,10,5);
//                    //JLabel will be involved for this border
//                    Border border = BorderFactory.createLineBorder(Color.BLACK);
//                    lbl.setHorizontalAlignment(lbl.CENTER);
//                    lbl.setVerticalAlignment(lbl.CENTER);
//                    lbl.setText(""+((char)Integer.parseInt(variation)));
//                    Color c=Color.decode("#D1D2D4");
//                    jpanel.setBackground(c);
//                    jpanel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
//                    jpanel.setLayout(new CardLayout());
//                    jpanel.add(lbl);
//                    jpanel.setSize(height,width);
//                    jpanel.setVisible(true);
//                     variationPanel.add(jpanel);
//                    }break;
//                }
//                }
//                    variationPanel.validate();
//                    variationPanel.repaint();
//                    refreshPanel();
//                  //this.validate();
//                  //this.repaint();
//        //this code aaded by Sumit to get variations of selected Character : End
//    }
//    
//   /* 
//    public void getVariationForSelectedCharacter(String selectedChar, int selectedCharIndex)
//  {
//      
//      ArrayList<String> listInString = FontUnicodeBundle.unicodeBundleArrayList;
//    this.variationPanel.removeAll();
//    this.variationPanel.setLayout(new GridLayout(1, 12, 2, 2));
//    this.variationPanel.setBorder(new EmptyBorder(2, 2, 2, 20));
//    for (String string : listInString)
//    {
//        
//      String[] variations = string.split(",");
//      ArrayList list = new ArrayList(Arrays.asList(variations));
//        System.out.println("List : "+list);
//        System.out.println("Containes : "+selectedChar.charAt(0) + "");
//      if (list.contains(selectedChar.charAt(0) + ""))
//      {
//          System.out.println("List Of Valiration : "+variations.length);
//        for (String variation : variations)
//        {
//            
//          JPanel jpanel = new JPanel();
//          JLabel lbl = new JLabel();
//          lbl.addMouseListener(new MouseAdapter()
//          {
//            public void mouseClicked(MouseEvent e)
//            {
//              JLabel lbl = (JLabel)e.getSource();
//              int startSelectionIndex = artPanel.textEditorBox.getSelectionStart();
//              int endSelectionIndex = artPanel.textEditorBox.getSelectionEnd();
//              if ((startSelectionIndex < endSelectionIndex) && (endSelectionIndex - startSelectionIndex == 1)) {
//                try
//                {
//                  artPanel.textEditorBox.replaceSelection("" + lbl.getText().charAt(0));
//                  artPanel.textEditorBox.setSelectionStart(startSelectionIndex);
//                  artPanel.textEditorBox.setSelectionEnd(startSelectionIndex + artPanel.textEditorBox.getSelectedText().length());
//                  artPanel.textEditorBox.revalidate();
//                  artPanel.textEditorBox.repaint();
//                }
//                catch (Exception e1)
//                {
//                  e1.printStackTrace();
//                }
//              }
//              artPanel.textEditorBox.requestFocusInWindow();
//            }
//          });
//          int height = this.variationPanel.getHeight();
//          int width = this.variationPanel.getWidth() / 12;
//          
//          lbl.setPreferredSize(new Dimension(65, 65));
//          Font selectedFont = this.selectedFont.deriveFont(20.0F);
//          lbl.setFont(selectedFont);
//          lbl.setHorizontalTextPosition(0);
//          
//          Border paddingBorder = BorderFactory.createEmptyBorder(10, 5, 10, 5);
//          
//          Border border = BorderFactory.createLineBorder(Color.BLACK);
//          lbl.setHorizontalAlignment(0);
//          lbl.setVerticalAlignment(0);
//          lbl.setText("" + (char)Integer.parseInt(variation));
//          Color c = Color.decode("#D1D2D4");
//          jpanel.setBackground(c);
//          jpanel.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
//          jpanel.setLayout(new CardLayout());
//          jpanel.add(lbl);
//          jpanel.setSize(height, width);
//          jpanel.setVisible(true);
//          this.variationPanel.add(jpanel);
//        }
//        break;
//      }
//    }
//    this.variationPanel.validate();
//    this.variationPanel.repaint();
//    refreshPanel();
//  }//getVariationForSlectedChar ends*/
//
//    public class UndoEditListener implements UndoableEditListener {
//		@Override
//		public void undoableEditHappened(UndoableEditEvent e) {
//			undoMgr__.addEdit(e.getEdit()); // remember the edit
//		}
//	}
//    enum UndoActionType {UNDO, REDO};
//    public class UndoActionListener implements ActionListener {        
//        private UndoActionType undoActionType;
//	public UndoActionListener(UndoActionType type) {
//            undoActionType = type;
//            undoRedoLogic(undoActionType);
//	}
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            undoRedoLogic(undoActionType);
//        }
//    } // UndoActionListener
//    
//    /**
//     * This method is use to Undo or redo the TextPane operation as per input type
//     * @param undoActionType Type of Operation (Undo or Redo)
//     * @author Sumit
//     * @Since 19-Nov-2017
//     */
//    public void undoRedoLogic(UndoActionType undoActionType){
//        switch (undoActionType) {
//            case UNDO:
//                if (! undoMgr__.canUndo()) {
//                    requestFocusInWindow();
//                    return; // no edits to undo
//                }
//		undoMgr__.undo();
//		break;
//					
//            case REDO:
//                if (! undoMgr__.canRedo()) {
//                    requestFocusInWindow();
//                    return; // no edits to redo
//                }
//            undoMgr__.redo();
//	}
//        requestFocusInWindow();
//        revalidate();
//        repaint();
//    }
//    
//    
//    class WrapEditorKit extends StyledEditorKit {
//        ViewFactory defaultFactory=new WrapColumnFactory();
//        public ViewFactory getViewFactory() {
//            return defaultFactory;
//        }
//
//    }
//
//    class WrapColumnFactory implements ViewFactory {
//        public View create(Element elem) {
//            String kind = elem.getName();
//            if (kind != null) {
//                if (kind.equals(AbstractDocument.ContentElementName)) {
//                    return new WrapLabelView(elem);
//                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
//                    return new ParagraphView(elem);
//                } else if (kind.equals(AbstractDocument.SectionElementName)) {
//                    return new CenteredBoxView(elem, View.Y_AXIS);
//                } else if (kind.equals(StyleConstants.ComponentElementName)) {
//                    return new ComponentView(elem);
//                } else if (kind.equals(StyleConstants.IconElementName)) {
//                    return new IconView(elem);
//                }
//            }
//
//            // default to text display
//            return new LabelView(elem);
//        }
//    }
//class CenteredBoxView extends BoxView {
//    public CenteredBoxView(Element elem, int axis) {
//
//        super(elem,axis);
//    }
//    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
//
//        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
//        int textBlockHeight = 0;
//        int offset = 0;
// 
//        for (int i = 0; i < spans.length; i++) {
//
//            textBlockHeight = spans[i];
//        }
//        offset = (targetSpan - textBlockHeight) / 2;
//        for (int i = 0; i < offsets.length; i++) {
//            offsets[i] += offset;
//        }
//
//    }
//} 
//    class WrapLabelView extends LabelView {
//        public WrapLabelView(Element elem) {
//            super(elem);
//        }
//
//        public float getMinimumSpan(int axis) {
//            switch (axis) {
//                case View.X_AXIS:
//                    return 0;
//                case View.Y_AXIS:
//                    return super.getMinimumSpan(axis);
//                default:
//                    throw new IllegalArgumentException("Invalid axis: " + axis);
//            }
//        }
//
//    }
//    
//}
//
///*
// * this class is use to handle all the caret events occour inseide textBox 
// * @auther : Sumit
//*/
//class TextPanelCaretEventHandler implements  CaretListener{
//    
//    TextEditorBox txBox;
//    TextBoxResizable res;
//    ArtPanel artPanel;
//    TextPanelCaretEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
//        this.res=res;
//        this.txBox=txBox;
//        this.artPanel=artPanel;
//    }
//    @Override
//    public void caretUpdate(CaretEvent e) {
//        //txBox.setSize(txBox.getPreferredSize());
//        //txBox.setBorder(new ResizableBorder(8));
//        Dimension actualSize=res.getSize();
//        Dimension requiredSize=res.getPreferredSize();
//        if(actualSize.height<requiredSize.height || actualSize.width < requiredSize.width ){
//            res.setSize(res.getPreferredSize());
//            res.resize();
//        }
//        res.revalidate();
//        res.repaint();   
//    }   
//}//caret Event Handler Ends
//
///*
// * this class is use to handle all the key events occour inseide textBox 
// * @auther : Sumit
//*/
//class TextPanelKeyEventHandler implements  KeyListener{
//    
//    TextEditorBox txBox;
//    TextBoxResizable res;
//    ArtPanel artPanel;
//    TextPanelKeyEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
//        this.res=res;
//        this.txBox=txBox;
//        this.artPanel=artPanel;
//    }
//    
//    @Override
//    public void keyTyped(KeyEvent e) {
//        
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int code = e.getKeyCode();
//        if(code == KeyEvent.VK_ESCAPE){
//            Dimension actualSize=res.getSize();
//            Dimension requiredSize=res.getPreferredSize();
//            if(actualSize.height<=requiredSize.height || actualSize.width <= requiredSize.width ){
//                System.out.println("Esc Successfully");
//                res.setSize(Integer.parseInt(((int)requiredSize.getWidth()+20)+""),Integer.parseInt(((int)requiredSize.getHeight()+20)+""));
//                res.resize();
//            }
//            txBox.setEditable(false);
//            res.setBorder(new TextBoxResizableBorder(8));
//            res.revalidate();
//            res.repaint();  
//        }
//        
//        String text = txBox.getSelectedText();
//        //increment selected font size 
//         if(code==46){
//            
//            //int fontSize=getFont().getSize();
//            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
//            StyleConstants.getFontFamily(attrs);
//            int fontSize=StyleConstants.getFontSize(attrs);
//            int cursorPosition = txBox.getCaretPosition();
//            StyleContext context = new StyleContext();
//            Style style;
//            txBox.replaceSelection("");
//            style = context.addStyle("Parastyle", null);
//            
//            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize+2));
//            int selectionStart=txBox.getSelectionStart();
//            int selectionEnd=txBox.getSelectionEnd();
//            try{
//                txBox.getStyledDocument().insertString(cursorPosition - text.length(), text, style);
//                txBox.setSelectionStart(selectionStart);
//                txBox.setSelectionEnd(selectionStart+text.length());
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//            
//        }
//        //decrement selected font size 
//        if(code==44){
//            //int fontSize=getFont().getSize();
//            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
//            int fontSize=StyleConstants.getFontSize(attrs);
//            int cursorPosition = txBox.getCaretPosition();
//            StyleContext context = new StyleContext();
//            Style style;
//            txBox.replaceSelection("");
//            style = context.addStyle("mystyle", null);
//            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize-2));
//           
//            int selectionStart=txBox.getSelectionStart();
//            int selectionEnd=txBox.getSelectionEnd();
//            try{
//                txBox.getStyledDocument().insertString(cursorPosition - text.length(), text, style);
//                txBox.setSelectionStart(selectionStart);
//                txBox.setSelectionEnd(selectionStart+text.length());
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//            
//        }
//        //this is use to make JTextPane ready to paste
//        if(code==67){
//            txBox.isClonable=true;
//        }
//        //this is use to create clone of the JTextPane (If User double click on JTextPane and ctrl+v)
//        if(code==86){
//            if(txBox.isClonable){
//                try{
//                    //TextEditorView txtView=(TextEditorView)this.clone();
//                    TextEditorBox txtView=new TextEditorBox(artPanel, artPanel.variationPanel, txBox.x, txBox.y, txBox.fontName,txBox.fontSize);
//                    StyledDocument styledDocument = txBox.getStyledDocument();   
//                    Element element; 
//                    Document doc2=txtView.getDocument();
//                    doc2 = txtView.getDocument(); 
//                    for(int i=0; i<styledDocument.getLength();i++) {
//                        element = styledDocument.getCharacterElement(i);
//                        AttributeSet attributeNew = element.getAttributes();   
//                        System.out.println(i);
//                        doc2.insertString(doc2.getLength(), styledDocument.getText(i, 1), attributeNew);
//                    }
//                    
//                    /*
//                    //this code is use to copy all the properties from one JTextPae To another 
//                    //but it cannot copy and paste the color of the text
//                    txtView.setText(getText());
//                    txtView.setCharacterAttributes(getCharacterAttributes(),true);
//                    txtView.setParagraphAttributes(getParagraphAttributes(), true);
//                    MutableAttributeSet attrs=((StyledEditorKit)getEditorKit()).getInputAttributes();
//                    txtView.setCharacterAttributes(attrs,true);
//                    */
//                    txtView.revalidate();
//                    txtView.repaint();
//                   // frame.textEditorList.add(txtView);
//                    artPanel.validate();
//                    artPanel.repaint();
//                    
//                    txBox.isClonable=false;
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        String firstSelectedChar;
//                    try{
//                    String text = txBox.getText();
//                    int selectionStart = txBox.getSelectionStart();
//                    //firstSelectedChar = text.substring(selectionStart, selectionStart + 1);
//                    firstSelectedChar = txBox.getDocument().getText(selectionStart, 1);
//                    //this code aaded by Sumit to get variations of selected Character : start
//                        txBox.getVariationForSelectedCharacter(firstSelectedChar,selectionStart);
//                    //this code aaded by Sumit to get variations of selected Character : End
//                    }catch(Exception ex){
//                        //ex.printStackTrace();
//                        System.err.println("No char Selected");
//                    }
//    }
//}//key Event Handler Ends
//
//
///*
// * This class is use to handle mouse events of TextBox
//*/
//class TextPanelMouseEventHandler extends MouseAdapter{
//    TextEditorBox txBox;
//    TextBoxResizable res;
//    ArtPanel artPanel;
//    TextPanelMouseEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
//        this.res=res;
//        this.txBox=txBox;
//        this.artPanel=artPanel;
//    }
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        int clickCount=e.getClickCount();
//        artPanel.textEditorBox=txBox;
////        if(clickCount==1){
////            txBox.setEditable(false);
////        }
//        if(clickCount==2){
//            res.setBorder(BorderFactory.createEmptyBorder());
//            txBox.setEditable(true);
//            Caret caret=txBox.getCaret();
//                caret.setBlinkRate(10);
//            txBox.setCaret(caret);
//            txBox.setCaretPosition(txBox.getDocument().getLength());
//            res.revalidate();
//            res.repaint();  
//        }
//    }
//    
//}// mouse event Handler ends
//
//
//class TextBoxResizableBorder implements Border {
//
//    private int dist = 8;
//
//    int locations[] = {
//        SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.WEST,
//        SwingConstants.EAST, SwingConstants.NORTH_WEST,
//        SwingConstants.NORTH_EAST, SwingConstants.SOUTH_WEST,
//        SwingConstants.SOUTH_EAST
//    };
//
//    int cursors[] = {
//        Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR,
//        Cursor.E_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR,
//        Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR
//    };
//
//    public TextBoxResizableBorder(int dist) {
//        this.dist = dist;
//    }
//
//    @Override
//    public Insets getBorderInsets(Component component) {
//        return new Insets(dist, dist, dist, dist);
//    }
//
//    @Override
//    public boolean isBorderOpaque() {
//        return false;
//    }
//
//    @Override
//    public void paintBorder(Component component, Graphics g, int x, int y,
//            int w, int h) {
//        Graphics2D g2d = (Graphics2D)g;
//        g.setColor(Color.black);
//        g.drawRect(x + dist / 2, y + dist / 2, w - dist, h - dist);
//        
//        //if (component.hasFocus()) {
//
//            for (int i = 0; i < locations.length; i++) {
//                Rectangle rect = getRectangle(x, y, w, h, locations[i]);
//                g.setColor(Color.WHITE);
//                g.fillRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
//                g.setColor(Color.BLACK);
//                g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
//            }
//       //}
//    }
//
//    private Rectangle getRectangle(int x, int y, int w, int h, int location) {
//
//        switch (location) {
//            case SwingConstants.NORTH:
//                return new Rectangle(x + w / 2 - dist / 2, y, dist, dist);
//            case SwingConstants.SOUTH:
//                return new Rectangle(x + w / 2 - dist / 2, y + h - dist, dist,
//                        dist);
//            case SwingConstants.WEST:
//                return new Rectangle(x, y + h / 2 - dist / 2, dist, dist);
//            case SwingConstants.EAST:
//                return new Rectangle(x + w - dist, y + h / 2 - dist / 2, dist,
//                        dist);
//            case SwingConstants.NORTH_WEST:
//                return new Rectangle(x, y, dist, dist);
//            case SwingConstants.NORTH_EAST:
//                return new Rectangle(x + w - dist, y, dist, dist);
//            case SwingConstants.SOUTH_WEST:
//                return new Rectangle(x, y + h - dist, dist, dist);
//            case SwingConstants.SOUTH_EAST:
//                return new Rectangle(x + w - dist, y + h - dist, dist, dist);
//        }
//        return null;
//    }
//
//    public int getCursor(MouseEvent me) {
//
//        Component c = me.getComponent();
//        int w = c.getWidth();
//        int h = c.getHeight();
//
//        for (int i = 0; i < locations.length; i++) {
//            Rectangle rect = getRectangle(0, 0, w, h, locations[i]);
//            if (rect.contains(me.getPoint())) {
//                return cursors[i];
//            }
//        }
//
//        return Cursor.MOVE_CURSOR;
//    }
//}//TextBoxResizableBoder Ends
//
//class TextBoxResizable extends JComponent {
//    public Border border;
//    public TextBoxResizable(Component comp) {
//        this(comp, new TextBoxResizableBorder(8));
//    }
//
//    public TextBoxResizable(Component comp, Border border) {
//        this.border=border;
//        setLayout(new BorderLayout());
//        add(comp);
//        addMouseListener(resizeListener);
//        addMouseMotionListener(resizeListener);
//        setBorder(border);
//    }
//
//    public void resize() {
//        if (getParent() != null) {
//            ((JComponent) getParent()).revalidate();
//        }
//    }
//
//    MouseInputListener resizeListener = new MouseInputAdapter() {
//        
//        @Override
//        public void mouseMoved(MouseEvent me) {
//            if (hasFocus()) {
//                TextBoxResizableBorder border = (TextBoxResizableBorder) getBorder();
//                setCursor(Cursor.getPredefinedCursor(border.getCursor(me)));
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent mouseEvent) {
//            setCursor(Cursor.getDefaultCursor());
//        }
//
//        private int cursor;
//        private Point startPos = null;
//
//        @Override
//        public void mousePressed(MouseEvent me) {
//            
//            TextBoxResizableBorder border = (TextBoxResizableBorder) getBorder();
//            cursor = border.getCursor(me);
//            startPos = me.getPoint();
//            requestFocus();
//            repaint();
//        }
//
//        @Override
//        public void mouseDragged(MouseEvent me) {
//
//            if (startPos != null) {
//
//                int x = getX();
//                int y = getY();
//                int w = getWidth();
//                int h = getHeight();
//
//                int dx = me.getX() - startPos.x;
//                int dy = me.getY() - startPos.y;
//
//                switch (cursor) {
//                    case Cursor.N_RESIZE_CURSOR:
//                        if (!(h - dy < 50)) {
//                            setBounds(x, y + dy, w, h - dy);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.S_RESIZE_CURSOR:
//                        if (!(h + dy < 50)) {
//                            setBounds(x, y, w, h + dy);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.W_RESIZE_CURSOR:
//                        if (!(w - dx < 50)) {
//                            setBounds(x + dx, y, w - dx, h);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.E_RESIZE_CURSOR:
//                        if (!(w + dx < 50)) {
//                            setBounds(x, y, w + dx, h);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.NW_RESIZE_CURSOR:
//                        if (!(w - dx < 50) && !(h - dy < 50)) {
//                            setBounds(x + dx, y + dy, w - dx, h - dy);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.NE_RESIZE_CURSOR:
//                        if (!(w + dx < 50) && !(h - dy < 50)) {
//                            setBounds(x, y + dy, w + dx, h - dy);
//                            startPos = new Point(me.getX(), startPos.y);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.SW_RESIZE_CURSOR:
//                        if (!(w - dx < 50) && !(h + dy < 50)) {
//                            setBounds(x + dx, y, w - dx, h + dy);
//                            startPos = new Point(startPos.x, me.getY());
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.SE_RESIZE_CURSOR:
//                        if (!(w + dx < 50) && !(h + dy < 50)) {
//                            setBounds(x, y, w + dx, h + dy);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.MOVE_CURSOR:
//                        Rectangle bounds = getBounds();
//                        bounds.translate(dx, dy);
//                        setBounds(bounds);
//                        resize();
//                }
//
//                setCursor(Cursor.getPredefinedCursor(cursor));
//            }
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent mouseEvent) {
//            startPos = null;
//        }
//    };
//}//TextBoxResizable Ends
//
//
//
//
//

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import com.model.FontUnicodeBundle;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BoxView;
import javax.swing.text.Caret;
import javax.swing.text.ComponentView;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;
import javax.swing.undo.UndoManager;
import utils.FontSizeConverter;

public class TextEditorBox extends  JTextPane implements  Serializable{
    ArtPanel artPanel;
    TextBoxResizable res;
    int x,y;
    private UndoManager undoMgr__;
    Font selectedFont;
    String fontName,fontSize;
    JPanel variationPanel;
    int width=10,height=20;
    boolean isClonable=false;
    boolean isdeleteable=false;
    public void setFontName(String fontName) {this.fontName = fontName;}
    public void setFontSize(String fontSize) {this.fontSize = fontSize;}
    public void setVariationPanel(JPanel variationPanel) {this.variationPanel = variationPanel;}

    public TextEditorBox() {
    }
    
    public TextEditorBox(ArtPanel artPanel,JPanel variationPanel,int x,int y,String fontName,String fontSize,int width,int height) {
        this.artPanel=artPanel;
        this.x=x;this.y=y;
        this.variationPanel=variationPanel;
        this.fontName=fontName;
        this.fontSize=fontSize;
        undoMgr__ = new UndoManager();
        initCompoent();
        
        this.getDocument().addUndoableEditListener(new UndoEditListener());
        res= new TextBoxResizable(this,BorderFactory.createEmptyBorder());
        res.setBounds(x, y, 30, 40);
        changeFontOrSize(fontName,fontSize);
        addCaretListener(new TextPanelCaretEventHandler(this,res,artPanel));
        addKeyListener(new TextPanelKeyEventHandler(this,res,artPanel));
        addMouseListener(new TextPanelMouseEventHandler(this,res,artPanel));
        addMouseMotionListener(new TextPanelMouseEventHandler(this,res,artPanel));
        artPanel.add(res);
        artPanel.textBoxList.add(res);
        artPanel.textEditorBox=this;
        refreshPanel();
    }
    
    
    public void initCompoent(){
        setContentType("text/html");
        setEditable(true);
        setLocation(x, y);
        setSize(width, height);    
        setEditorKit(new WrapEditorKit());
        setBackground(new Color(0,0,0,0));
        setVisible(true);
    }
    
    public void refreshPanel(){
        res.revalidate();
        res.repaint();
        artPanel.revalidate();
        artPanel.repaint();
    }

    
    
    /**
     * This method is use to set font and size to the text.
     * This method gets called when user select font or size from Combo box.
     * @param fontNameStr name of the selected font
     * @param fontSizeStr size of the font
     * @author Sumit
     * Since : 18-Nov-2017 
     */
    public void changeFontOrSize(String fontNameStr,String fontSizeStr){
        String editorContent = getText();
        this.fontName=fontNameStr;
        this.fontSize=fontSizeStr;
        selectedFont= new FontSizeConverter().decryptFont(fontNameStr+".ttf", fontSizeStr);
        //setFont= new FontSizeConverter().decryptFont(fontNameStr, "30");
        setFont(selectedFont);
        //setFont(setFont);
        
        MutableAttributeSet attr = new SimpleAttributeSet();
        //MutableAttributeSet attr = this.getInputAttributes();

        StyleConstants.setFontSize(attr, Integer.parseInt(fontSizeStr));
        //StyleConstants.setFontFamily(attr, selectedFont.getFamily());
        setCharacterAttributes( attr, false);
        
        setPreferedSizeForTextEditorPanel();

    }

    /**
     * This method is use to remove border of the textbox and repaint TextBox with empty border
     * @author : Sumit
     * @since 24-Dec-2017
     */
    public void removeTextBoxBorder(){
        res.setBorder(BorderFactory.createEmptyBorder());
        res.revalidate();
        res.repaint(); 
    }
    
     /**
     * This method is use to delete the textbox from ArtPanel
     * @author : Sumit
     * @since 24-Dec-2017
     */
    public void deleteThisTextBoxFromArtPanel(){
         if(isdeleteable){
                artPanel.remove(res);
                artPanel.textBoxList.remove(res);
                artPanel.textEditorBox=null;
                artPanel.validate();
                artPanel.repaint();
            }
            isdeleteable=false;
    }
    
    /**
     * This method is use to set foreground color to selected text
     * This method gets called when user select text from TextPane and change color.
     * @param color to get a color class object
     * @author Sumit
     * Since : 18-Nov-2017 
     */
    public void changeColorOfSelectedText(Color color){
        SimpleAttributeSet attr = new SimpleAttributeSet(); 
        StyleConstants.setForeground(attr, color);
	setCharacterAttributes(attr, false);
	refreshPanel();
        requestFocusInWindow();
        
    }
    
    /**
     * This method is use to change alignment of selected text
     * @param alignment name of the alignment (left,right,center) 
     * @author Sumit
     * Since : 18-Nov-2017 
     */
    public void changeTextAlignment(String alignment){
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet simpleAttribute = new SimpleAttributeSet();
        switch(alignment){
            case "left" :
                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_LEFT);
                break;
            case "right" :
                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_RIGHT);
                break;
            case "center" :
                StyleConstants.setAlignment(simpleAttribute, StyleConstants.ALIGN_CENTER);
                break;
        }
        doc.setParagraphAttributes(getSelectionStart(), getSelectionEnd(), simpleAttribute, false);
        refreshPanel();
    }
    
    /**
     * This method is use to accept selected character and display variation(formation) 
     * for selected char
     * @param selectedChar to accept selected character 
     * @since 7-Nov-2017
     */
    public void getVariationForSelectedCharacter(String selectedChar,final int selectedCharIndex){
            ArrayList<String> listInString=FontUnicodeBundle.unicodeBundleArrayList;
            Component variationPanels[]=variationPanel.getComponents();
            for (Component variationPanel1 : variationPanels) {
                JPanel pnl=(JPanel)variationPanel1;
                pnl.removeAll();
            }
            //variationPanel.removeAll();
            variationPanel.setLayout(new GridLayout(1,12,2,2));
            variationPanel.setBorder(new EmptyBorder(2, 2, 2, 20));
            for (String string : listInString) {
                String variations[]=string.split(",");
                ArrayList list=new ArrayList(Arrays.asList(variations));
                if(list.contains((int)selectedChar.charAt(0)+"")){
                    int index=0;
                    for (String variation : variations) { 
                        JPanel jpanel=(JPanel)variationPanels[index];
                    JLabel lbl=new JLabel();
                    lbl.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            JLabel lbl=(JLabel)e.getSource();
                            int startSelectionIndex=getSelectionStart();
                            int endSelectionIndex=getSelectionEnd();
                            if(startSelectionIndex<endSelectionIndex && (endSelectionIndex-startSelectionIndex)==1){
                                try{
                                    replaceSelection(""+lbl.getText().charAt(0));
                                    setSelectionStart(startSelectionIndex);
                                    setSelectionEnd(startSelectionIndex+getSelectedText().length());
                                    artPanel.textEditorBox.revalidate();
                                    artPanel.textEditorBox.repaint();
                                    
                                }catch(Exception e1){
                                    e1.printStackTrace();
                                }
                            }
                            requestFocusInWindow();
                        }
                    });
                    int height=variationPanel.getHeight();
                    int width=variationPanel.getWidth()/12;
                    //lbl.setSize(height,width);
                    lbl.setPreferredSize(new Dimension(65,65));//to set the size of dynamically generated label
                    Font selectedFont=this.selectedFont.deriveFont(20.0f);//code is use to se font size for label text
                    lbl.setFont(selectedFont);
                    lbl.setHorizontalTextPosition(JLabel.CENTER);
                        //frame.getjPanel7().add(lbl);
                    Border paddingBorder = BorderFactory.createEmptyBorder(10,5,10,5);
                    //JLabel will be involved for this border
                    Border border = BorderFactory.createLineBorder(Color.BLACK);
                    lbl.setHorizontalAlignment(lbl.CENTER);
                    lbl.setVerticalAlignment(lbl.CENTER);
                    lbl.setText(""+((char)Integer.parseInt(variation)));
                    Color c=Color.decode("#D1D2D4");
                    jpanel.setBackground(c);
                    jpanel.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
                    jpanel.setLayout(new CardLayout());
                    jpanel.add(lbl);
                    jpanel.setSize(height,width);
                    jpanel.setVisible(true);
                    jpanel.repaint();
                    variationPanels[index++]=jpanel;
                     //variationPanel.add(jpanel);
                    }break;
                }
                //this else added to display blank variation panels if varirations not found by Sumit on 24-Dec-17 :Start
                else{
                        int index=0;
                        for (Component variationPanel1 : variationPanels) {
//                            JPanel pnl=(JPanel)variationPanel1;
//                            JLabel lbl=new JLabel();
//                            lbl.setPreferredSize(new Dimension(65,65));//to set the size of dynamically generated label
//                            Font selectedFont=this.selectedFont.deriveFont(20.0f);//code is use to se font size for label text
//                            lbl.setFont(selectedFont);
//                            lbl.setHorizontalTextPosition(JLabel.CENTER);
//                                //frame.getjPanel7().add(lbl);
//                            Border paddingBorder = BorderFactory.createEmptyBorder(10,5,10,5);
//                            //JLabel will be involved for this border
//                            Border border = BorderFactory.createLineBorder(Color.BLACK);
//                            lbl.setHorizontalAlignment(lbl.CENTER);
//                            lbl.setVerticalAlignment(lbl.CENTER);
//                            lbl.setText("");    
//                            Color c=Color.decode("#D1D2D4");
//                            pnl.setBackground(c);
//                            pnl.setBorder(BorderFactory.createCompoundBorder(border,paddingBorder));
//                            pnl.setLayout(new CardLayout());
//                            pnl.add(lbl);
//                            pnl.setSize(height,width);
//                            pnl.setVisible(true);
//                            pnl.repaint();
//                            variationPanels[index++]=pnl;

                            
                            JPanel pnl=(JPanel)variationPanel1;
                                JLabel lbl = new JLabel();
                                int height=variationPanel.getHeight();
                        int width=variationPanel.getWidth()/12;
            
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
            pnl.setBackground(c);
            pnl.setBorder(BorderFactory.createCompoundBorder(border, paddingBorder));
            pnl.setLayout(new CardLayout());
            pnl.add(lbl);
            pnl.setSize(height, width);
            pnl.setVisible(true);
            pnl.repaint();
            variationPanels[index++]=pnl;
            
            //change by Sumit on 24-Dec-2017 : Start
            variationPanel.add(pnl);
            //change by Sumit on 24-Dec-2017 : End
                         }
                    }//this else added to display blank variation panels if varirations not found by Sumit on 24-Dec-17 :Ends
                }
                    variationPanel.validate();
                    variationPanel.repaint();
                    refreshPanel();
                  //this.validate();
                  //this.repaint();
        //this code aaded by Sumit to get variations of selected Character : End
    }
    
    
    public void getCloneOfTextEditorBox(){
        if(this.isClonable){
                try{
                    //TextEditorView txtView=(TextEditorView)this.clone();
                    this.width=getWidth();
                    this.height=getHeight();
                    TextEditorBox txtView=new TextEditorBox(artPanel, artPanel.variationPanel, this.x, this.y, this.fontName,this.fontSize,width,height);
                    StyledDocument styledDocument = this.getStyledDocument();   
                    Element element; 
                    Document doc2=txtView.getDocument();
                    doc2 = txtView.getDocument(); 
                    for(int i=0; i<styledDocument.getLength();i++) {
                        element = styledDocument.getCharacterElement(i);
                        AttributeSet attributeNew = element.getAttributes();   
                        System.out.println(i);
                        doc2.insertString(doc2.getLength(), styledDocument.getText(i, 1), attributeNew);
                    }
                    
                    /*
                    //this code is use to copy all the properties from one JTextPae To another 
                    //but it cannot copy and paste the color of the text
                    txtView.setText(getText());
                    txtView.setCharacterAttributes(getCharacterAttributes(),true);
                    txtView.setParagraphAttributes(getParagraphAttributes(), true);
                    MutableAttributeSet attrs=((StyledEditorKit)getEditorKit()).getInputAttributes();
                    txtView.setCharacterAttributes(attrs,true);
                    */
                    txtView.revalidate();
                    txtView.repaint();
                   // frame.textEditorList.add(txtView);
                    artPanel.validate();
                    artPanel.repaint();
                    
                    this.isClonable=false;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
    }
    
    
    public class UndoEditListener implements UndoableEditListener {
		@Override
		public void undoableEditHappened(UndoableEditEvent e) {
			undoMgr__.addEdit(e.getEdit()); // remember the edit
		}
	}
    enum UndoActionType {UNDO, REDO};
    public class UndoActionListener implements ActionListener {        
        private UndoActionType undoActionType;
	public UndoActionListener(UndoActionType type) {
            undoActionType = type;
            undoRedoLogic(undoActionType);
	}
        @Override
        public void actionPerformed(ActionEvent e) {
            undoRedoLogic(undoActionType);
        }
    } // UndoActionListener
    
    /**
     * This method is use to Undo or redo the TextPane operation as per input type
     * @param undoActionType Type of Operation (Undo or Redo)
     * @author Sumit
     * @Since 19-Nov-2017
     */
    public void undoRedoLogic(UndoActionType undoActionType){
        switch (undoActionType) {
            case UNDO:
                if (! undoMgr__.canUndo()) {
                    requestFocusInWindow();
                    return; // no edits to undo
                }
		undoMgr__.undo();
		break;
					
            case REDO:
                if (! undoMgr__.canRedo()) {
                    requestFocusInWindow();
                    return; // no edits to redo
                }
            undoMgr__.redo();
	}
        requestFocusInWindow();
        revalidate();
        repaint();
    }
Graphics2D g2d;
    @Override
    public void paint(Graphics g) {
        this.g2d=(Graphics2D) g;
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * This method is use to set prefer size to an text box
     * @since  21-Dec-2017
     */
    public void setPreferedSizeForTextEditorPanel(){
        //g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        Dimension actualSize=res.getSize();
        Dimension requiredSize=res.getPreferredSize();
        if(actualSize.height<requiredSize.height || actualSize.width < requiredSize.width ){
            res.setSize(res.getPreferredSize());
            res.resize();
            this.width=res.getWidth();
            this.height=res.getHeight();
            //g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        }
        res.revalidate();
        res.repaint();
    }
    
    public class WrapEditorKit extends StyledEditorKit implements Serializable{

        public WrapEditorKit() {
        }
        
        ViewFactory defaultFactory=new WrapColumnFactory();
        public ViewFactory getViewFactory() {
            return defaultFactory;
        }

    }

    public class WrapColumnFactory implements ViewFactory,Serializable {

        public WrapColumnFactory() {
        }
        
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new WrapLabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new CenteredBoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
            }

            // default to text display
            return new LabelView(elem);
        }
    }
public class CenteredBoxView extends BoxView implements  Serializable{
    public CenteredBoxView(Element elem, int axis) {
        super(elem,axis);
    }
    public CenteredBoxView() {
            super(null, 0);
     }
    
    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {

        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
        int textBlockHeight = 0;
        int offset = 0;
 
        for (int i = 0; i < spans.length; i++) {

            textBlockHeight = spans[i];
        }
        offset = (targetSpan - textBlockHeight) / 2;
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] += offset;
        }

    }
    } 
    public class WrapLabelView extends LabelView implements  Serializable{
        public WrapLabelView(Element elem) {
            super(elem);
        }

        public WrapLabelView() {
            super(null);
        }

        public float getMinimumSpan(int axis) {
            switch (axis) {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }

    }
    
}

/*
 * this class is use to handle all the caret events occour inseide textBox 
 * @auther : Sumit
*/

class TextPanelCaretEventHandler implements  CaretListener{
    
    TextEditorBox txBox;
    TextBoxResizable res;
    ArtPanel artPanel;
    TextPanelCaretEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
        this.res=res;
        this.txBox=txBox;
        this.artPanel=artPanel;
    }
    @Override
    public void caretUpdate(CaretEvent e) {
        
        
        
        //txBox.setSize(txBox.getPreferredSize());
        //txBox.setBorder(new ResizableBorder(8));
        
        //this is actual code to resize textbox as user go on typing : Start
        Dimension actualSize=res.getSize();
        Dimension requiredSize=res.getPreferredSize();
        if(actualSize.height<requiredSize.height || actualSize.width < requiredSize.width ){
            res.setSize(res.getPreferredSize());
            res.resize();
        }//this is actual code to resize textbox as user go on typing : Ends
        
        
        res.revalidate();
        res.repaint();   
    }   
}//caret Event Handler Ends

/*
 * this class is use to handle all the key events occour inseide textBox 
 * @auther : Sumit
*/

//class TextPanelKeyEventHandler implements  KeyListener{
//    
//    TextEditorBox txBox;
//    TextBoxResizable res;
//    ArtPanel artPanel;
//    TextPanelKeyEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
//        this.res=res;
//        this.txBox=txBox;
//        this.artPanel=artPanel;
//    }
//    
//    @Override
//    public void keyTyped(KeyEvent e) {
//        
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        int code = e.getKeyCode();
//        //This code use use to added bounded border when user click Esc button. Start
//        if(code == KeyEvent.VK_ESCAPE){
//            Dimension actualSize=res.getSize();
//            Dimension requiredSize=res.getPreferredSize();
//            if(actualSize.height<=requiredSize.height || actualSize.width <= requiredSize.width ){
//                System.out.println("Esc Successfully");
//                //txBox.g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//                res.setSize(Integer.parseInt(((int)requiredSize.getWidth()+20)+""),Integer.parseInt(((int)requiredSize.getHeight()+20)+""));
//                res.resize();
//            }
//            //txBox.setEditable(false);
//            res.setBorder(new TextBoxResizableBorder(8));
//            res.revalidate();
//            res.repaint(); 
//            txBox.isdeleteable=true;
//        }//This code use use to added bounded border when user click Esc button. Ends
//        
//        String text = txBox.getSelectedText();
//        //increment selected String font size by Crtl + > button : start
//         if(code==46){           
//            //int fontSize=getFont().getSize();
//            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
//            StyleConstants.getFontFamily(attrs);
//            int fontSize=StyleConstants.getFontSize(attrs);
//            int cursorPosition = txBox.getCaretPosition();
//            StyleContext context = new StyleContext();
//            Style style;
//            txBox.replaceSelection("");
//            style = context.addStyle("Parastyle", null);
//            
//            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize+2));
//            int selectionStart=txBox.getSelectionStart();
//            int selectionEnd=txBox.getSelectionEnd();
//            try{
//                txBox.getStyledDocument().insertString(selectionStart, text, style);
//                txBox.setSelectionStart(selectionStart);
//                txBox.setSelectionEnd(selectionStart+text.length());
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//            
//        }//increment selected String font size by Crtl + > button : Ends
//         
//        //Decrement selected String font size by Crtl + < button : start
//        if(code==44){
//            //int fontSize=getFont().getSize();
//            AttributeSet attrs=((StyledEditorKit)txBox.getEditorKit()).getInputAttributes();
//            int fontSize=StyleConstants.getFontSize(attrs);
//            int cursorPosition = txBox.getCaretPosition();
//            StyleContext context = new StyleContext();
//            Style style;
//            txBox.replaceSelection("");
//            style = context.addStyle("mystyle", null);
//            style.addAttribute(StyleConstants.FontSize, new Integer(fontSize-2));
//           
//            int selectionStart=txBox.getSelectionStart();
//            int selectionEnd=txBox.getSelectionEnd();
//            try{
//                txBox.getStyledDocument().insertString(selectionStart, text, style);
//                txBox.setSelectionStart(selectionStart);
//                txBox.setSelectionEnd(selectionStart+text.length());
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
//            
//        }//Decrement selected String font size by Crtl + < button : Ends
//        
//        //this is use to make JTextPane ready to paste calles after click on ctrl + c
//        if(code==67){
//            txBox.isClonable=true;
//        }
//        //this is use to create clone of the JTextPane (If User double click on JTextPane and ctrl+v)
//        if(code==86){
//            if(txBox.isClonable){
//                try{
//                    //TextEditorView txtView=(TextEditorView)this.clone();
//                    TextEditorBox txtView=new TextEditorBox(artPanel, artPanel.variationPanel, txBox.x, txBox.y, txBox.fontName,txBox.fontSize,txBox.width,txBox.height);
//                    StyledDocument styledDocument = txBox.getStyledDocument();   
//                    Element element; 
//                    Document doc2=txtView.getDocument();
//                    doc2 = txtView.getDocument(); 
//                    for(int i=0; i<styledDocument.getLength();i++) {
//                        element = styledDocument.getCharacterElement(i);
//                        AttributeSet attributeNew = element.getAttributes();   
//                        System.out.println(i);
//                        doc2.insertString(doc2.getLength(), styledDocument.getText(i, 1), attributeNew);
//                    }
//                    txtView.revalidate();
//                    txtView.repaint();
//                   // frame.textEditorList.add(txtView);
//                    artPanel.validate();
//                    artPanel.repaint();
//                    
//                    txBox.isClonable=false;
//                }catch(Exception ex){
//                    ex.printStackTrace();
//                }
//            }
//        }
//        
//        //this code is use to delete the JTextPane From Jpanel
//        if(code==127){
//           txBox.deleteThisTextBoxFromArtPanel();
//        }//Ends TextBox Deleted code
//        
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        String firstSelectedChar;
//                    try{
//                    String text = txBox.getText();
//                    int selectionStart = txBox.getSelectionStart();
//                    //firstSelectedChar = text.substring(selectionStart, selectionStart + 1);
//                    firstSelectedChar = txBox.getDocument().getText(selectionStart, 1);
//                    //this code aaded by Sumit to get variations of selected Character : start
//                        txBox.getVariationForSelectedCharacter(firstSelectedChar,selectionStart);
//                    //this code aaded by Sumit to get variations of selected Character : End
//                    }catch(Exception ex){
//                        //ex.printStackTrace();
//                        System.err.println("No char Selected");
//                    }
//    }
//}//key Event Handler Ends


/*
 * This class is use to handle mouse events of TextBox
*/

//class TextPanelMouseEventHandler extends MouseAdapter{
//    TextEditorBox txBox;
//    TextBoxResizable res;
//    ArtPanel artPanel;
//    TextPanelMouseEventHandler(TextEditorBox txBox,TextBoxResizable res,ArtPanel artPanel){
//        this.res=res;
//        this.txBox=txBox;
//        this.artPanel=artPanel;
//    }
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        int clickCount=e.getClickCount();
//        artPanel.textEditorBox=txBox;
////        if(clickCount==1){
////            txBox.setEditable(false);
////        }
//        if(clickCount==2){
//            txBox.isdeleteable=false;
//            res.setBorder(BorderFactory.createEmptyBorder());
//            txBox.setEditable(true);
//            //txBox.setFocusable(true);
//            Caret caret=txBox.getCaret();
//                caret.setBlinkRate(10);
//            txBox.setCaret(caret);
//            txBox.setCaretPosition(txBox.getDocument().getLength());
//            res.revalidate();
//            res.repaint();  
//        }
//    }
//    
//}// mouse event Handler ends



//class TextBoxResizableBorder implements Border {
//
//    private int dist = 8;
//
//    int locations[] = {
//        SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.WEST,
//        SwingConstants.EAST, SwingConstants.NORTH_WEST,
//        SwingConstants.NORTH_EAST, SwingConstants.SOUTH_WEST,
//        SwingConstants.SOUTH_EAST
//    };
//
//    int cursors[] = {
//        Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR,
//        Cursor.E_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR,
//        Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR
//    };
//
//    public TextBoxResizableBorder(int dist) {
//        this.dist = dist;
//    }
//
//    @Override
//    public Insets getBorderInsets(Component component) {
//        return new Insets(dist, dist, dist, dist);
//    }
//
//    @Override
//    public boolean isBorderOpaque() {
//        return false;
//    }
//
//    @Override
//    public void paintBorder(Component component, Graphics g, int x, int y,
//            int w, int h) {
//        Graphics2D g2d = (Graphics2D)g;
//        g.setColor(Color.black);
//        g.drawRect(x + dist / 2, y + dist / 2, w - dist, h - dist);
//        
//        //if (component.hasFocus()) {
//
//            for (int i = 0; i < locations.length; i++) {
//                Rectangle rect = getRectangle(x, y, w, h, locations[i]);
//                g.setColor(Color.WHITE);
//                g.fillRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
//                g.setColor(Color.BLACK);
//                g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
//            }
//       //}
//    }
//
//    private Rectangle getRectangle(int x, int y, int w, int h, int location) {
//
//        switch (location) {
//            case SwingConstants.NORTH:
//                return new Rectangle(x + w / 2 - dist / 2, y, dist, dist);
//            case SwingConstants.SOUTH:
//                return new Rectangle(x + w / 2 - dist / 2, y + h - dist, dist,
//                        dist);
//            case SwingConstants.WEST:
//                return new Rectangle(x, y + h / 2 - dist / 2, dist, dist);
//            case SwingConstants.EAST:
//                return new Rectangle(x + w - dist, y + h / 2 - dist / 2, dist,
//                        dist);
//            case SwingConstants.NORTH_WEST:
//                return new Rectangle(x, y, dist, dist);
//            case SwingConstants.NORTH_EAST:
//                return new Rectangle(x + w - dist, y, dist, dist);
//            case SwingConstants.SOUTH_WEST:
//                return new Rectangle(x, y + h - dist, dist, dist);
//            case SwingConstants.SOUTH_EAST:
//                return new Rectangle(x + w - dist, y + h - dist, dist, dist);
//        }
//        return null;
//    }
//
//    public int getCursor(MouseEvent me) {
//
//        Component c = me.getComponent();
//        int w = c.getWidth();
//        int h = c.getHeight();
//
//        for (int i = 0; i < locations.length; i++) {
//            Rectangle rect = getRectangle(0, 0, w, h, locations[i]);
//            if (rect.contains(me.getPoint())) {
//                return cursors[i];
//            }
//        }
//
//        return Cursor.MOVE_CURSOR;
//    }
//}//TextBoxResizableBoder Ends



//class TextBoxResizable extends JComponent {
//    public Border border;
//    public TextBoxResizable(Component comp) {
//        this(comp, new TextBoxResizableBorder(8));
//    }
//    
//
//    public TextBoxResizable(Component comp, Border border) {
//        this.border=border;
//        setLayout(new BorderLayout());
//        add(comp);
//        addMouseListener(resizeListener);
//        addMouseMotionListener(resizeListener);
//        setBorder(border);
//    }
//
//    public void resize() {
//        if (getParent() != null) {
//          TextBoxResizable  ((JComponent) getParent()).revalidate();
//        }
//    }
//
//    MouseInputListener resizeListener = new MouseInputAdapter() {
//        
//        @Override
//        public void mouseMoved(MouseEvent me) {
//            if (hasFocus()) {
//                TextBoxResizableBorder border = (TextBoxResizableBorder) getBorder();
//                setCursor(Cursor.getPredefinedCursor(border.getCursor(me)));
//            }
//        }
//
//        @Override
//        public void mouseExited(MouseEvent mouseEvent) {
//            setCursor(Cursor.getDefaultCursor());
//        }
//
//        private int cursor;
//        private Point startPos = null;
//
//        @Override
//        public void mousePressed(MouseEvent me) {
//            
//            TextBoxResizableBorder border = (TextBoxResizableBorder) getBorder();
//            cursor = border.getCursor(me);
//            startPos = me.getPoint();
//            requestFocus();
//            repaint();
//        }
//
//        @Override
//        public void mouseDragged(MouseEvent me) {
//
//            if (startPos != null) {
//
//                int x = getX();
//                int y = getY();
//                int w = getWidth();
//                int h = getHeight();
//
//                int dx = me.getX() - startPos.x;
//                int dy = me.getY() - startPos.y;
//
//                switch (cursor) {
//                    case Cursor.N_RESIZE_CURSOR:
//                        if (!(h - dy < 50)) {
//                            setBounds(x, y + dy, w, h - dy);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.S_RESIZE_CURSOR:
//                        if (!(h + dy < 50)) {
//                            setBounds(x, y, w, h + dy);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.W_RESIZE_CURSOR:
//                        if (!(w - dx < 50)) {
//                            setBounds(x + dx, y, w - dx, h);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.E_RESIZE_CURSOR:
//                        if (!(w + dx < 50)) {
//                            setBounds(x, y, w + dx, h);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.NW_RESIZE_CURSOR:
//                        if (!(w - dx < 50) && !(h - dy < 50)) {
//                            setBounds(x + dx, y + dy, w - dx, h - dy);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.NE_RESIZE_CURSOR:
//                        if (!(w + dx < 50) && !(h - dy < 50)) {
//                            setBounds(x, y + dy, w + dx, h - dy);
//                            startPos = new Point(me.getX(), startPos.y);
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.SW_RESIZE_CURSOR:
//                        if (!(w - dx < 50) && !(h + dy < 50)) {
//                            setBounds(x + dx, y, w - dx, h + dy);
//                            startPos = new Point(startPos.x, me.getY());
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.SE_RESIZE_CURSOR:
//                        if (!(w + dx < 50) && !(h + dy < 50)) {
//                            setBounds(x, y, w + dx, h + dy);
//                            startPos = me.getPoint();
//                            resize();
//                        }
//                        break;
//
//                    case Cursor.MOVE_CURSOR:
//                        Rectangle bounds = getBounds();
//                        bounds.translate(dx, dy);
//                        setBounds(bounds);
//                        resize();
//                }
//
//                setCursor(Cursor.getPredefinedCursor(cursor));
//            }
//        }
//
//        @Override
//        public void mouseReleased(MouseEvent mouseEvent) {
//            startPos = null;
//        }
//    };
//}//TextBoxResizable Ends






