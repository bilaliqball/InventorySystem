/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;


import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UIResources {
    
public static Node root =null;


public static Parent  PARENT;



public static Parent parentroot;
public static BorderPane menuborder;
public static Scene scene ;
public static Stage stage;
public static ActionEvent actionevent;
public static AnchorPane signinanchorpane;
public static Stage trangostage;




public static Parent PROGRESSROOT=null;
public static BorderPane PROGRESSBORDER=null; 

public static BorderPane RECEIVEFILEBORDER=null; 

public static  BorderPane parentHomeborder=null; 
public static AnchorPane parentHomeAnchor=null;;




public static VBox parentprogressVbox;
public static Label receiverlabel;
public static AnchorPane Contactanchor;



public static AnchorPane loadingMessageanchor;
public static Label messagelabel;
public static Label actionlabel;








public static Circle contactrequestBadge;
public static Circle notificationBadge;
public static Circle profileBadge;
public static Label contactrequestLabel;
public static Label notificationLabel;
public static Button progressUpdateButton;


public static Float[] progressValue;
public static Label [] receiverName;
public static Label [] progressUpdate;
public static Label [] progressStatus;
public static Button[] crossButton; 
public static ProgressBar[] progressBars;
public static HBox [] progressHbox;
public static Pane [] progressPane;

public static String[] userarray;






public static Button uploadbutton;
public static Hyperlink showWifiPassword;

public static boolean INFILETRANSFER=false;
public static boolean INRECEIVERWAITING=false;


public static String setBackgroundColor="-fx-background-color: #22da8d;";
public static String setTextColor="-fx-text-fill: #419c04;";
    public static String TRANFERTYPE;

public static void initRoot(Parent root) {System.out.println("Resources stat: initializing home");PARENT=root;}

public  static void setProg(int index, float pro){progressValue[index]=pro;}


public  static void updateProgressbar(int pro, String rec){
final float prog = (float) (pro * 0.01);
for (int i = 0; i < userarray.length; i++) {
try {
if(userarray[i].equals(rec)){setProg(i,prog);}
}catch(Exception e) {}

}}



public static void showProfilebadge() {
profileBadge=(Circle)PARENT.lookup("#profileBadge");
try{profileBadge.setVisible(true);}catch(Exception e) {}}




public static void showInTransferButton(){
progressUpdateButton=(Button) PARENT.lookup("#progressUpdateButton");
try{progressUpdateButton.setVisible(true);
progressUpdateButton.setText("Transfer Update");
progressUpdateButton.setStyle(setBackgroundColor);
}catch(Exception e) {}}

public static void hideInTransferButton(){
INFILETRANSFER=false;
progressUpdateButton=(Button) PARENT.lookup("#progressUpdateButton");
try{progressUpdateButton.setVisible(false);}catch(Exception e) {}}


public static void showInWaitingButton(){
progressUpdateButton=(Button) PARENT.lookup("#progressUpdateButton");
try{progressUpdateButton.setVisible(true);
progressUpdateButton.setText("Receive File");
progressUpdateButton.setStyle(setBackgroundColor);
}catch(Exception e) {}}

public static void hideInWaitingButton(){
INRECEIVERWAITING=false;
progressUpdateButton=(Button) PARENT.lookup("#progressUpdateButton");
try{progressUpdateButton.setVisible(false);}catch(Exception e) {}}



public static void highlightUploadButton(){
try{
uploadbutton=(Button) PARENT.lookup("#uploadbutton");
uploadbutton.setStyle(setBackgroundColor+"-fx-background-radius: 5em;");}catch(Exception e){}}


public static void dehighlightUploadButton() {
try{
uploadbutton=(Button) PARENT.lookup("#uploadbutton");
uploadbutton.setStyle("-fx-background-color: white;"+"-fx-background-radius: 5em;");}catch(Exception e){}}


public static void showWifiPasswordlink(){
try{
showWifiPassword=(Hyperlink) PARENT.lookup("#showWifiPassword");
showWifiPassword.setVisible(true);}catch(Exception e){}}

public static void hideWifiPasswordlink(){
try{
showWifiPassword=(Hyperlink) PARENT.lookup("#showWifiPassword");
showWifiPassword.setVisible(false);}catch(Exception e){}}

public static void deselectSendHotspotOption() {
RadioButton sendHotspotOption=(RadioButton)PARENT.lookup("#sendHotspotOption");
Hyperlink showWifiPassword=(Hyperlink)PARENT.lookup("#showWifiPassword");
Button uploadbutton=(Button)PARENT.lookup("#uploadbutton");
Text sendHotspottext=(Text)PARENT.lookup("#sendHotspottext");
if(sendHotspotOption.isSelected()){sendHotspotOption.setSelected(false);sendHotspottext.setText("");}
if(showWifiPassword.isVisible()){showWifiPassword.setVisible(false);}TRANFERTYPE="general";
uploadbutton.setStyle("-fx-background-color: white;"+"-fx-background-radius: 5em;");}

public static void hideBadges() {
notificationBadge=(Circle)PARENT.lookup("#notificationBadge");
notificationBadge.setVisible(false);}


public static void showBadges() {
contactrequestBadge.setVisible(true);
notificationBadge.setVisible(true);
profileBadge.setVisible(true);
contactrequestLabel.setVisible(true);contactrequestLabel.setText("1");
notificationLabel.setVisible(true);notificationLabel.setText("2");}





public static void checkUpdates() throws IOException{
URL RESOURCEURL=UIResources.class.getClassLoader().
getResource("trango/UpdatesCheck.fxml");
PROGRESSROOT=null;PROGRESSBORDER=null;
PROGRESSROOT=FXMLLoader.load(RESOURCEURL);
PROGRESSBORDER=parentHomeborder;
PROGRESSBORDER.setCenter(PROGRESSROOT);}


public static void installUpdates() throws IOException{
PROGRESSROOT=null;PROGRESSBORDER=null;
URL RESOURCEURL=UIResources.class.getClassLoader().
getResource("trango/Updater.fxml");
PROGRESSROOT=FXMLLoader.load(RESOURCEURL);
PROGRESSBORDER=parentHomeborder;
PROGRESSBORDER.setCenter(PROGRESSROOT);}

public static void loadRoot(String root) throws IOException{
PROGRESSROOT=null;PROGRESSBORDER=null;
URL RESOURCEURL=UIResources.class.getClassLoader().
getResource(root);
PROGRESSROOT=FXMLLoader.load(RESOURCEURL);
PROGRESSBORDER=parentHomeborder;
PROGRESSBORDER.setCenter(PROGRESSROOT);}






}
