package utils;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class FontSizeConverter {
    public Font decryptFont(String fontNameStr,String fontSizeStr){
        Font font=null;
        
        try{
        	String key = "This is a secret";
        	Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
 	          Cipher cipher = Cipher.getInstance("AES");
 	       cipher.init(Cipher.DECRYPT_MODE, secretKey);
        	
 	      FileInputStream inputStream = new FileInputStream("resources\\fonts\\"+fontNameStr);
	       byte[] inputBytes = new byte[(int) new File("resources\\fonts\\"+fontNameStr).length()];
	       inputStream.read(inputBytes);

	       byte[] outputBytes = cipher.doFinal(inputBytes);
	       
               String userPathsString=System.getProperty("user.home");
                File userPathFile=new File(userPathsString,".indiaFont");
                userPathFile.mkdirs();
               
	       FileOutputStream outputStream = new FileOutputStream(userPathFile.toString()+"\\"+fontNameStr);
	       outputStream.write(outputBytes);

	       
            //InputStream is = EditorView.class.getResourceAsStream(".\\fonts\\"+fontNameStr);
        	InputStream is=new BufferedInputStream(
                    new FileInputStream(userPathFile.toString()+"\\"+fontNameStr));
        	
        	
            font = Font.createFont(Font.TRUETYPE_FONT, is);
	    font=font.deriveFont(Font.BOLD, Integer.parseInt(fontSizeStr));
            
            //txtOutPut.setFont(f1);
            //txtOutPut.setText(editorContent);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return font;
    }
}
