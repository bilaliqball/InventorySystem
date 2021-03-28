package com.trango.application;



import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;



public class Variables {

	
	
	public static String  TRANFERTYPE="general";
	public static String  TRANSFERMODE="0";
	public static String  INPUTTYPE="files";
	
	
	public static boolean ENCRYPT=false;
	
	

	public static boolean HOTSPOTREQUESTED=false;
	public static boolean HOTSPOTCREATED=false;
    public static String  HOTSPOTPASSWORD="";
    public static String  HOTSPOTNAME="";

	public static boolean REMEMBERME=false;


	public static Thread offlineReceiverThread;
	public static Thread onlineReceiverThread;
	public static Thread changeStateThread;
	


	public static String RESOURCEPATH ="resources/";
	public static String DEFAULTPATH;
	public static String TRANGOPATH;
	public static String MEDIADIR;
	public static String DOCUMENTDIR;

	public static String MEDIAEXT=".jpg .jpeg .png .mp4 .avi .flv .wmv .mov .mkv ";
	public static String DOCUMENTEXT=".doc .docx .xls .xlsx .pdf .ppt .txt .bin .zip";

	public static String MYAUTHTOKEN;
	public static String TRANSFERID;
	public static String FULLNAME;
	public static String IPADDRESS;
	public static String MACADDRESS;
	public static String DEVICETYPE;
	public static String DEVICENAME;
	public static String EMAIL;

	public static String ACCOUNTPASSWORD;
	public static String ACCOUNTDEVICES;
	public static String ACCOUNTEMAIL;
	public static String ACCOUNTTYPE;



    
    
	public static ArrayList<String> SELECTEDEMAILS=null;
	public static ArrayList<String> AVAILABLEEMAILS=null;
	public static ArrayList<String> SELECTEDUSERNAMES=null;
	public static ArrayList<String> AVAILABLEUSERNAMES=null;




	public static ArrayList<String> TRANSFERIDS;
	public static ArrayList<String> TRANSFERIPS;
	

	

	

	public static String SELECTEDUSERNAMESTRING=null;


	public static int SELECTEDUSERCOUNT=0;
	public static int SELECTEDUSERFOUND=0;
	public static int SELECTEDUSERSENT=0;

	public static boolean SCANNEDDONE=false;
	public static boolean SCANWINDOWDISPLAYED=false;



	public static boolean SENDERCANCELLED=false;
    public static boolean SENDERDECLINED=false;
	public static boolean RECEIVERACCEPTED=false;
	public static boolean RECEIVERCANCELLED=false;
	public static boolean RECEIVERDECLINED=false;
	public static boolean RECEIVERRECEIVED=false;
	public static boolean RECEIVERBUSY=false;
	public static boolean FILERECEIVED=false;
	public static boolean FILESENT=false;
	public static boolean INTRANSFER=false;
	public static boolean INWAITING=false;
	public static boolean INONLINETRANSFER=false;
	public static boolean SHOWPROGRESSBAR=false;


	
	
	public static File INPUTFILE=null;
	public static long STARTTIME=0;
	public static long TOTALBYTES=0;
	public static boolean FILEUPLOADED=false;
	public static boolean FILEACCEPTED=false;


	public static FileInputStream INPUTSTREAM=null;
	public static OutputStream OUTPUTSTREAM =null;
	public static HttpURLConnection CONNECTION=null;


	
	
	
	
	


	public static boolean DEACTIVATED=false;
	public static boolean LOGGEDOUT=false;

	public static String RECEIVERSTATUS="waiting";
	public static String ACTIONSTATUS="waiting";
	public static String ACTION="";
	public static int RECEIVERRESPONSE=-1;
	public static int ACTIONRESPONSE=-1;
	public static int OPENFILE=-1;
	public static File FILES[]=null;
	public static File FILE=null;


	public static String   UPLOADSPEED="4.00 Mbps";
	public static String DOWNLOADSPEED="4.00 Mbps";
	public static int AVERAGEUPLOAD=512*1024;
	public static int AVERAGEDOWNLOAD=512*1024;
	public static int AVERAGEBYTES=512;

	public static  int NOTIFICATION=0;
	public static  int CONTACTREQUEST=0;

	public static String webviewpage="";

	public static void RESETALLVARIABLES() {
	SELECTEDUSERCOUNT=0;
	SELECTEDUSERFOUND=0;
	SELECTEDUSERSENT=0;

	SCANNEDDONE=false;
	SCANWINDOWDISPLAYED=false;



	SENDERCANCELLED=false;
	RECEIVERACCEPTED=false;
	RECEIVERCANCELLED=false;
	RECEIVERRECEIVED=false;
	RECEIVERBUSY=false;
	FILERECEIVED=false;
	INTRANSFER=false;
	INWAITING=false;
	INONLINETRANSFER=false;



	RECEIVERSTATUS="waiting";
	ACTIONSTATUS="waiting";
	ACTION="";
	RECEIVERRESPONSE=-1;
	ACTIONRESPONSE=-1;
	OPENFILE=-1;}

	
}
