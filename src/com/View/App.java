/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.View;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 *
 * @author Shree
 */
public class App{

   public static void main(String[] args) throws UnknownHostException{

       InetAddress ip;
       ip = InetAddress.getLocalHost();
	String mac=mac(ip);
        System.out.println("Mac Address is  : "+mac);
   }

   public static String mac(InetAddress ip){
       String macadd=null;
	try {

		
		System.out.println("Current IP address : " + ip.getHostAddress());

		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();

		System.out.print("Current MAC address : ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		System.out.println("*****"+sb.toString());
                macadd=sb.toString();
        } catch (SocketException e){

		e.printStackTrace();

	}
        return macadd;
   }
   
}