package com.model;
import static Sample.FileDownloadTest.saveFileFromUrlWithJavaIO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class JavaDownloadFileFromURL {

	

//	
//    public static void main(String[] args) {
//    	    
//        String url = "http://www.facweb.iitkgp.ernet.in/~sourav/AES.pdf";
//        
//        try {
//            //downloadUsingNIO(url, "/Users/pankaj/sitemap.xml");
//            
//            downloadUsingStream(url, "C:/download/dwn.pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    
    /**
     * This method is use to accept key and call php web service and get file link to download
     * @param key
     */
    public String callWebServiceAndGetFileLinkForDownload(String key){
                String result="success";
    try {
        String url = "http://indiafont.in/IndiaFont-app/product_download_link.php";
        Client client = Client.create();
        WebResource webResource = client.resource(url);
        Map urlParameters = new LinkedHashMap();
                
        urlParameters.put("order_key", key);
		
        String str=new Gson().toJson(urlParameters);
        System.out.println("Json : "+str);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class,str);
        if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        String output2 = response.getEntity(String.class);

        JsonObject jobj = new Gson().fromJson(output2, JsonObject.class);

       String result1 = jobj.get("meta_value").toString();
       String status=jobj.get("status").toString();
       String msg=jobj.get("message").toString();
       
           System.out.println("Product Link : "+trimDoubleQuotes(result1));
           
           //Add by Ajinkya
           Pattern p = Pattern.compile("(\\bhttp\\b)(.*?)(\\bttf\\b)");
        Matcher m = p.matcher(result1);
        List<String> matches = new ArrayList<String>();
        List<String> paths=new ArrayList<String>();
        while (m.find()) {
          matches.add(m.group(2));
        }
        for(String s:matches){
            //System.out.println("Matches : "+s);
            paths.add("http"+s+"ttf");
        }
        
        for(String path:paths){
            File name=new File(path);
            String filename=name.getName();
            String textFinal=filename.replace("%", "");
            System.out.println("Paths : "+path);
            downloadUsingStream(path,"resources\\fonts\\"+textFinal);
        }
           //End
           
           //downloadUsingStream(trimDoubleQuotes(result1),"resources\\fonts\\FOnt1.ttf");
           
           
           //saveFileFromUrlWithJavaIO(dirName + "\\FOnt1.ttf",result1);

        System.out.println("\n============Plain Text Response============");
        System.out.println(output2);
       // if(!output2.equals(""))
       //     result="success";
       // 
        } catch (Exception e) {
            result="fail";
            e.printStackTrace();
        }
		return result;
    }
    
    //Remove double quote
    public static String trimDoubleQuotes(String text) {
//    int textLength = text.length();
//
//    if (textLength >= 2 && text.charAt(0) == '"' && text.charAt(textLength - 1) == '"' && text.charAt(textLength) == '%') {
//      return text.substring(1, textLength - 1);
//    }
//        System.out.println("******result : "+text);
    text=text.replace("\"", "");
    return text;
  }
    
    public static void downloadUsingStream(String urlStr, String filePath) throws IOException{
        URL url = new URL(urlStr);
        System.out.println("ttf  file Url : "+urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(filePath);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

//    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
//        URL url = new URL(urlStr);
//        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
//        FileOutputStream fos = new FileOutputStream(file);
//        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//        fos.close();
//        rbc.close();
//    }

}