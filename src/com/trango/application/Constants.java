package com.trango.application;

import java.io.File;

public class Constants {
public static final String BUILDVERSION="1.0.2";
public static final String TAG = "Trango.io";
public static final String SSID = "TRANGO";





public static final String ACCOUNT_TYPE_REGISTERED="registered"; 
public static final String ACCOUNT_TYPE_UNREGISTERED="unregistered"; 

public static final String STATUS_SIGNEDIN="signedin"; 
public static final String STATUS_SIGNEDOUT="signedout"; 
public static final String STATUS_NOTDEFINED=""; 


//For separating the data
public static final String ACKNOWLEDGEMENTYES = "y";
public static final String ACKNOWLEDGEMENTNO = "n";
public static final String SEPARATOR = "#";
public static final String PINGINFOCMD = "i";
public static final String FILETRANSFERCMD = "f";
public static final String MULTIFILETRANSFERCMD = "f";
public static final String FILECANCELCMD = "c";
public static final String ALREADYINTRANSFERCMD = "a";
public static final String TIMEOUTCMD = "t";
public static final String SENDERDECLINECMD = "d";




public static final int INFOPORT = 43594;
public static int CONNECTIONTIMEOUT=10000;
public static int ACCEPTTIMEOUT=10000;
public static final int BUFFERSIZE = 4*1024;







//public static final String SERVERPATH ="http://192.168.1.232:8585/api/";
//public static final String BASE_URL   ="http://192.168.1.232:8585/api/";

public static final String SERVERPATH = "https://api.trango.io/";
public static final String BASE_URL = "https://api.trango.io/api/";

public static final String WEBSOCKETPATH ="wss://test.trango.io:8443";
//public static final String WEBSOCKETPATH ="ws://35.196.58.202:8082";



//Request codes for Intents
public static final int REQUEST_FILE_PICKER = 12321;
public static final int REQUEST_DIRECTORY_PICKER = 46844;
public static final int MY_PERMISSIONS_REQUEST = 22331;
public static final int INTENT_OPEN_WIFI_SETTINGS = 21343;
public static final int GPS_REQUEST = 48686;

public static final int OFFLINE_REQUEST_TIMEOUT=180;
public static final int ONLINE_REQUEST_TIMEOUT=180;


public static int START=51;
public static int END=100;
public static int counter=25;
public static final String PAGE_START="/pageStart";
public static final String PAGE_END="/pageEnd";
public static final String GET_TRANSFER_LOGS_2="/getTransLogs";


public static String SERVICEACCOUNT;
public static String APPLICATIONNAME;
public static File CREDENTIALFILE;
public static String PROJECTID="bellstone-priviate-limted";
public static String BUCKETNAME="trango_sharing_bucket";



//Communication Commands
public static final String OFFLINEMODE = "0";
public static final String ONLINEMODE = "1";
public static final String SHAREABLEMODE = "2";
public static final String HOTSPOTMODE = "3";
public static final String MYSELFMODE = "4";



public static final String CMD_PING_INFO = "i";
public static final String CMD_INIT_FILE_TRANSFER = "f";
public static final String CMD_INIT_MULTI_FILE_TRANSFER = "f";
public static final String CMD_CANCEL_FILE_TRANSFER = "c";

// Acknowledgements
public static final String ACKNOWLEDGEMENT_YES = "y";
public static final String ACKNOWLEDGEMENT_NO = "n";
public static final String ACKNOWLEDGEMENT_IN_TRANSFER = "a";




// for File Transfer Dialog  updates
public static final int SHOW_PROGRESS_DIALOG = 0;
public static final int UPDATE_PROGRESS_IN_DIALOG = -1;
public static final int UPDATE_FILENAME_IN_DIALOG = -2;
public static final int SHOW_CONFIRMATION_DIALOG = -3;
public static final int RECEIVE_FILE_INIT = -4;
public static final int UPDATE_STATUS_TRANSFER_CANCELLED = -6;
public static final int UPDATE_STATUS_TRANSFER_REJECTED = -7;
public static final int UPDATE_STATUS_ALREADY_IN_TRANSFER = -8;

//Keys for SharedPreferences
public static final String KEY_FIRST_START = "KEY_FIRST_START";
public static final String KEY_BASE_PATH = "KEY_BASE_PATH";
public static final String KEY_TEMP_PATH = "KEY_TEMP_PATH";
public static final String KEY_AUTH_TOKEN = "KEY_AUTH_TOKEN";
public static final String KEY_PREFERRED_ONLINE = "KEY_PREFERRED_ONLINE";
public static final String KEY_AUTO_ACKNOWLEDGE = "KEY_AUTO_ACKNOWLEDGE";



//Transfer statuses for each phase
public static final String STATUS_TRANSFER_WAITING= "0";
public static final String STATUS_TRANSFER_ACCEPTED = "1";
public static final String STATUS_TRANSFER_UPLOADING = "2";
public static final String STATUS_TRANSFER_UPLOADED = "3";
public static final String STATUS_TRANSFER_DOWNLOADING = "4";
public static final String STATUS_TRANSFER_DOWNLOADED = "5";
public static final String STATUS_TRANSFER_COMPLETED = "6";
public static final String STATUS_TRANSFER_REJECTED = "7";
public static final String STATUS_TRANSFER_CANCELLED= "8";
public static final String STATUS_TRANSFER_INTERRUPTED = "9";
public static final String STATUS_TRANSFER_ALREADYUSED = "10";
public static final String STATUS_TRANSFER_SENDERDECLINED= "11";
public static final String STATUS_TRANSFER_TIMEOUT = "12";




// Controllers
public static final String USER_CONTROLLER = "/userAcc";
public static final String CONTACT_CONTROLLER = "/contact";
public static final String TRANSFER_HISTORY_CONTROLLER =  "/transferHistory";
public static final String ONLINE_TRANSFER_CONTROLLER = "/onlineTransfer";
public static final String NOTIFICATION_CONTROLLER = "/onlineTransfer";
public static final String SHAREABLELINK_CONTROLLER = "/shareableLink";
public static final String SENDTOMYSELF_CONTROLLER = "/SendToMySelfController";
public static final String APPINFO_CONTROLLER = "/app";


// User account API paths
public static final String LOGIN = "/login";
public static final String SIGNUP = "/signup";
public static final String CHANGE_PASSWORD = "/changePassword";
public static final String LOGOUT = "/logout";
public static final String DELETE_ACCOUNT = "/deleteAccount";
public static final String IM_ONLINE="/iamOnline";
public static final String CHECK_ONLINE_REQUEST="/checkOnlineTransferRequest";



//Contacts
public static final String SEND_ADD_REQUEST = "/sendRequest";
public static final String GET_ALL_REQUESTS = "/getAllFriendRequests";
public static final String GET_ALL_CONTACTS = "/getAllContacts";
public static final String ACCEPT_REQUEST = "/acceptRequest";
public static final String REJECT_REQUEST = "/cancelRequest";
public static final String REMOVE_CONTACT = "/removeContact";
public static final String ADD_TRUSTED = "/addToTrusted";
public static final String REMOVE_TRUSTED = "/removeFromTrusted";
public static final String GET_ALL_TRUSTED = "/getAllTrusted";
public static final String SEARCHBY_EMAIL="/searchEmail";
public static final String GETONLINE_FRIENDS="/getOnlineFriends";

//Transfer Logs
public static final String ADD_TRANSFER_LOG = "/addSingleLog";
public static final String ADD_MULTIPLE_TRANSFERS_LOG = "/addMultipleLog";
public static final String GET_TRANSFER_LOGS = "/getTransferLogs";
public static final String SYNC_LOCAL_TRANSFER_LOGS="/transfer_logs";

public static final String INITIATE_ONLINE_TRANSFER="/initiateOnlineTransfer";
public static final String ACCEPT_TRANSFER="/acceptTransfer";
public static final String REJECT_TRANSFER="/rejectTransfer";
public static final String SAVE_LOCAL_TRANSFER="/saveLocalTransfer";
public static final String GET_SENDING_LOGS = "/getSendingLog";
public static final String GET_RECEIVING_LOGS = "/getReceivingLog";
public static final String PARAM_SET_TRANSFER_STATUS="/setTransferStatus";
public static final String PARAM_GET_TRANSFER_STATUS="/getTransferStatus";

public static final String PARAM_SET_TRANSFER_PROGRESS="/setTransferProgress";
public static final String PARAM_GET_TRANSFER_PROGRESS="/getTransferProgress";
public static final String PARAM_TRANSFER_LOG="transfer_logs";


public static final String INITIATE_SHAREABLE_LINK="/initiateShareableLink";
public static final String PARAM_SET_SHAREABLELINK_STATUS="/setShareAbleTransferStatus";
public static final String PARAM_GET_SHAREABLELINK_STATUS="/getShareAbleStatus";
public static final String PARAM_SET_SHAREABLELINK_PROGRESS="/setShareAbleProgress";
public static final String PARAM_UPDATE_SHAREABLE_FILELINK="/updateShareAbleTransferLink";
public static final String PARAM_SHAREABLE_FILELINK="transferLink";
public static final String INITIATE_SHAREABLE_LINK_UNREGISTERED="/initShareableLinkUnregisterUser";




//Online Transfer
public static final String GET_SIGNED_URL = "/getUploadSignedUrl";  
public static final String GET_DOWNLOAD_URL = "/getDownloadUrl";  
public static final String UPDATE_FILE_TRANSFER_STATUS = "";
public static final String GET_FILE_TRANSFER_STATUS = "";
public static final String UPDATE_FILE_TRANSFER_PROGRESS = "";
public static final String GET_FILE_TRANSFER_PROGRESS = "";
public static final String SEND_FILE_TRANSFER_REQUEST = "";
public static final String GET_FILE_TRANSFER_REQUEST_RESPONSE = "";
public static final String GET_FILE_TRANSFER_REQUEST = "";
public static final String SEND_FILE_TRANSFER_REQUEST_RESPONSE = "";
public static final String REJECT_FILE_TRANSFER_REQUEST = "";

//API params
public static final String PARAM_AUTH_TOKEN = "authToken";
public static final String PARAM_USERNAME = "username";
public static final String PARAM_FULLNAME = "fullname";
public static final String PARAM_FIRSTNAME="firstname";
public static final String PARAM_LASTNAME="lastname";
public static final String PARAM_EMAIL = "email";
public static final String PARAM_OCCUPATION = "occupation";
public static final String PARAM_PASSWORD = "password";
public static final String PARAM_DEVICE_NAME = "deviceName";
public static final String PARAM_DEVICE_TYPE = "deviceType";
public static final String PARAM_MAC_ADDRESS = "macAddress";
public static final String PARAM_OLD_PASSWORD = "oldPassword";
public static final String PARAM_NEW_PASSWORD = "newPassword";
public static final String PARAM_USERNAME_OR_EMAIL = "userNameOrEmail";
public static final String PARAM_CONTACT_ID = "contact_id";
public static final String PARAM_DEVICE_ID="deviceId";
public static final String PARAM_ACCOUNT_TYPE="accountType";

public static final String PARAM_TRANSFER_STATUS="status";
public static final String PARAM_TRANSFER_PROGRESS="progress";


public static final String PARAM_TRANSFER_ID = "transferId";
public static final String PARAM_SENDER_ID = "senderId";
public static final String PARAM_RECEIVER_ID = "receiverId";
public static final String PARAM_RECEIVER_EMAIL = "receiverEmail";
public static final String PARAM_SENDER_EMAIL = "senderEmail";
public static final String PARAM_FILENAME = "filename";
public static final String PARAM_FILESIZE = "filesize";
public static final String PARAM_FILETYPE = "filetype";
public static final String PARAM_DOWNLOAD_TIME = "downloadtime";
public static final String PARAM_TRANSFER_MEDIUM = "transfer_medium";


//Response API Params
public static final String PARAM_STATUS = "status";
public static final String PARAM_MESSAGE = "message";

}
