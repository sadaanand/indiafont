/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncriptAndDecriptHash;

/**
 *
 * @author Shree
 */
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5HashingExample
{
    public static void main(String[] args)
    {
    	String password = "Ajinkya";
        try {
            String val=encr(password);
            System.out.println("Vakue is : "+val);
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        md.update(password.getBytes());
//
//        byte byteData[] = md.digest();
//
//        //convert the byte to hex format method 1
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < byteData.length; i++) {
//         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//        }
//
//        System.out.println("Digest(in hex format):: " + sb.toString());
//
//        //convert the byte to hex format method 2
//        StringBuffer hexString = new StringBuffer();
//    	for (int i=0;i<byteData.length;i++) {
//    		String hex=Integer.toHexString(0xff & byteData[i]);
//   	     	if(hex.length()==1) hexString.append('0');
//   	     	hexString.append(hex);
//    	}
//    	System.out.println("Digest(in hex format):: " + hexString.toString());
        } catch (Exception ex) {
            Logger.getLogger(MD5HashingExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String encr(String password)throws Exception{
        //String password = "Ajinkya";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	System.out.println("Digest(in hex format):: " + hexString.toString());
        return hexString.toString();
    }
}