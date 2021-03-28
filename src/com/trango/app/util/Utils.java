package com.trango.app.util;

import com.trango.app.database.InventoryDao;
import com.trango.app.database.InvoiceDao;
import com.trango.app.database.ProductDao;
import com.trango.app.model.ProductInfo;
import com.trango.app.model.SaleInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {


public static void main(String argsp[]) throws Exception{
	System.out.println("****************************AVAIALBLE*****************************");
List<ProductInfo> avaiablelist=new InventoryDao().getAvailableInventory();
for(ProductInfo i:avaiablelist){System.out.println(i.getInventoryInfo());}

System.out.println("****************************SOLD*****************************");

List<ProductInfo> list=new InventoryDao().getSoldInventory();
for(ProductInfo i:list){System.out.println(i.getInventoryInfo());}

System.out.println("****************************INVOICE*****************************");

List<SaleInfo> salelist=new InvoiceDao().getInvoiceListProduct("AGSX");
for(SaleInfo sale:salelist) {
	System.out.println(sale.toString());
}
	
	
	
	
	
	
}
    
public static String generatePassword() {
final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
final SecureRandom RANDOM = new SecureRandom();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 8; ++i) {sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));}
return sb.toString();}


public static String getProductId(String productName) throws Exception {
StringBuilder sb = new StringBuilder();
String  productid=new InventoryDao().getProductId(productName);
if(productid.equals("000")){
SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHH");
Date date = new Date(System.currentTimeMillis());
final String NUMERIC = "0123456789987654321";
final SecureRandom RANDOM = new SecureRandom();

sb.append("P");sb.append(formatter.format(date));
for (int i = 0; i < 3; ++i) {sb.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));}
    
    }
    
    else{
    sb.append(productid);
    }

return sb.toString();
}


public static String getInvoiceNumber() throws Exception {
StringBuilder sb = new StringBuilder();

SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHss");
Date date = new Date(System.currentTimeMillis());
final String NUMERIC = "0123456789987654321";
final SecureRandom RANDOM = new SecureRandom();

sb.append("INV");sb.append(formatter.format(date));
for (int i = 0; i < 3; ++i) {sb.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));}
return sb.toString();
}


public static String getSALEID() throws Exception {
StringBuilder sb = new StringBuilder();
SimpleDateFormat formatter = new SimpleDateFormat("YYMMddHHss");
Date date = new Date(System.currentTimeMillis());
final String NUMERIC = "0123456789987654321";
final SecureRandom RANDOM = new SecureRandom();

sb.append("SAL");sb.append(formatter.format(date));
for (int i = 0; i < 3; ++i) {sb.append(NUMERIC.charAt(RANDOM.nextInt(NUMERIC.length())));}
    
    
  

return sb.toString();
}
public static String generateRandomString() {
final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
final SecureRandom RANDOM = new SecureRandom();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 8; ++i) {sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));}
return sb.toString();}



public static String getCurrentDateTime() 
{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());
    return formatter.format(date);
}

//public static String generateHotspotPassword() {
//final String ALPHABET = "123456789qwertyupkjhgfdsazxcvbnm";
//final SecureRandom RANDOM = new SecureRandom();
//StringBuilder sb = new StringBuilder();
//for (int i = 0; i < 8; ++i) {sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));}
//return sb.toString();}


public static String generateHotspotPassword() {
final String ALPHABET = "0123456789";
final SecureRandom RANDOM = new SecureRandom();
StringBuilder sb = new StringBuilder();char character='0';
for (int i = 0; i < 4; ++i) {
character=ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length()));
sb.append(character);sb.append(character);}
return sb.toString();}

public static boolean validEmail(String email) {
String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
return email.matches(regex);}




public static void log(String s) {System.out.println(s);}




		

public static String getFilesize(long numbytes) {
double filesizeInBS=numbytes;
double filesizeInKBS=filesizeInBS/(1024);
double filesizeInMBS=filesizeInKBS/(1024);
double filesizeInGBS=filesizeInMBS/(1024);
String filesizestring="";
DecimalFormat df = new DecimalFormat("#.##");try{
     if(filesizeInBS<1024) {filesizestring=df.format(filesizeInBS)+ " BYTES";}
else if(filesizeInKBS<1024){filesizestring=df.format(filesizeInKBS)+ " KB";}
else if(filesizeInMBS<1024){filesizestring=df.format(filesizeInMBS)+ " MB";}
else if(filesizeInGBS<1024){filesizestring=df.format(filesizeInGBS)+ " GB";}
System.out.println("File size "+filesizestring);}catch(Exception e) {}
return filesizestring;}


public  static void showNotification(String message,String title) throws AWTException {
Toolkit.getDefaultToolkit().beep();
SystemTray tray = SystemTray.getSystemTray();
Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
TrayIcon trayIcon = new TrayIcon(image, "Notification");
trayIcon.setImageAutoSize(true);
trayIcon.setToolTip("Notification");
tray.add(trayIcon);
trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);}



public static String getDeviceName() {
String usr=System.getProperty("user.name");
String oss=System.getProperty("os.name");
String devicename=usr +" "+oss;
return devicename;}


public static String getDeviceType() {
String devicetype=System.getProperty("os.name");
return devicetype;}

public static String getMacAddress() throws SocketException, UnknownHostException {
InetAddress internetAddress=InetAddress.getLocalHost();
NetworkInterface network = NetworkInterface.getByInetAddress(internetAddress);
byte[] mac = network.getHardwareAddress();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < mac.length; i++) {
sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));}
return sb.toString();}


public static String getUnregisterUsername() throws SocketException, UnknownHostException {
	String usr=System.getProperty("user.name");
	String oss=System.getProperty("os.name");String mac="";try{
		   mac=getMacAddress();}catch(Exception e) {}
	//System.out.println(mac);
	String id="";
if(mac.contains("-")) {
id=mac.substring(mac.lastIndexOf("-")+1, mac.length());}
String username=usr+"."+id+"."+oss;
return username.replaceAll(" ", ".");}


public static String getUnregisterDisplayName() throws SocketException, UnknownHostException {
String usr=System.getProperty("user.name");
String mac="";try{
mac=getMacAddress();}catch(Exception e) {}
String id="";
if(mac.contains("-")) {
id=mac.substring(mac.lastIndexOf("-")+1, mac.length());}
String username=usr+"."+id;
return username.replaceAll(" ", ".");}


public static String getPublicIP() throws IOException {
URL whatismyip = new URL("http://checkip.amazonaws.com");String PublicIP="";
BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
PublicIP = in.readLine();return PublicIP;}






	public static String toCamelCase(final String init) {
	    if (init==null)
	        return null;

	    final StringBuilder ret = new StringBuilder(init.length());

	    for (final String word : init.split(" ")) {
	        if (!word.isEmpty()) {
	            ret.append(word.substring(0, 1).toUpperCase());
	            ret.append(word.substring(1).toLowerCase());
	        }
	        if (!(ret.length()==init.length()))
	            ret.append(" ");
	    }

	    return ret.toString();
	}



		

}
