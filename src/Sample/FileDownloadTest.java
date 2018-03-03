/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample;

/**
 *
 * @author Shree
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/*
 * @author Singaram Subramanian
 */
public class FileDownloadTest {

public static void main(String[] args) {

 // Make sure that this directory exists
 String dirName = "D:\\sample";

 try {

System.out.println("Downloading \'Maven, Eclipse and OSGi working together\' PDF document...");

 saveFileFromUrlWithJavaIO(
 dirName + "\\abc.ttf",
 "http://indiafont.in/wp-content/uploads/woocommerce_uploads/2017/03/FOnt1.ttf");

 //System.out.println("Downloaded \'Maven, Eclipse and OSGi working together\' PDF document.");

 //System.out.println("Downloading \'InnoQ Web Services Standards Poster\' PDF document...");

// saveFileFromUrlWithCommonsIO(
// dirName + "\\abc.ttf",
// "http://indiafont.in/wp-content/uploads/woocommerce_uploads/2017/03/FOnt1.ttf");

 //System.out.println("Downloaded \'InnoQ Web Services Standards Poster\' PDF document.");

 } catch (MalformedURLException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 }

}

// Using Java IO
 public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
 throws MalformedURLException, IOException {
 BufferedInputStream in = null;
 FileOutputStream fout = null;
 try {
 in = new BufferedInputStream(new URL(fileUrl).openStream());
 fout = new FileOutputStream(fileName);

byte data[] = new byte[1024];
 int count;
 while ((count = in.read(data, 0, 1024)) != -1) {
 fout.write(data, 0, count);
 }
 } finally {
 if (in != null)
 in.close();
 if (fout != null)
 fout.close();
 }
 }

// Using Commons IO library
 // Available at http://commons.apache.org/io/download_io.cgi
 public static void saveFileFromUrlWithCommonsIO(String fileName,
 String fileUrl) throws MalformedURLException, IOException {
 FileUtils.copyURLToFile(new URL(fileUrl), new File(fileName));
 }

}