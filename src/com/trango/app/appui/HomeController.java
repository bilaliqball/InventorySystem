package com.trango.app.appui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.swing.JWindow;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;



import static com.trango.app.appui.UIResources.*;





import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;





import static com.trango.app.util.FileUtils.chooseDefaultDirectory;
import static com.trango.app.appui.TooltipText.*;
import static com.trango.application.Variables.CONTACTREQUEST;
import static com.trango.application.Variables.DEACTIVATED;
import static com.trango.application.Variables.NOTIFICATION;
import static com.trango.application.Variables.webviewpage;


import java.awt.Desktop;
import java.net.URI;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import javafx.scene.text.Text;





public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeAnchorpane;
    @FXML
    private BorderPane homeBorderpane;
    @FXML
    private Label slogenLabel;
    @FXML
    private Menu profilemenu;
    @FXML
    private Circle contactrequestBadge;
    @FXML
    private Label contactrequestLabel;
    @FXML
    private Circle notificationBadge;
    @FXML
    private Label notificationLabel;
    @FXML
    private MenuItem Settingitem;
    @FXML
    private ImageView userprofilePicture;
    @FXML
    private Circle profileBadge;
    @FXML
    private Label usernameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ImageView parentScreen;
    @FXML
    private AnchorPane navList;
    @FXML
    private Button changeDirectory;
    @FXML
    private Button changePassword;
    @FXML
    private Button aboutUs;
    @FXML
    private Button signedinDevices;
    @FXML
    private Button deactivateAccount;
    @FXML
    private Button checkUpdates;

 






    







public void hideAllBadges(){
contactrequestBadge.setVisible(false);
notificationBadge.setVisible(false);
profileBadge.setVisible(false);
contactrequestLabel.setVisible(false);
notificationLabel.setVisible(false);} 

public void showAllBadges(){}
 
   
public void showNotificationBadge(int count) {
notificationBadge.setVisible(true);
notificationLabel.setVisible(true);
notificationLabel.setText(""+count);}

public void showContactRequestBadge(int count) {
contactrequestBadge.setVisible(true);
contactrequestLabel.setVisible(true);
contactrequestLabel.setText(""+count);}


public void hideNotificationBadge() {
profileBadge.setVisible(false);
notificationBadge.setVisible(false);
notificationLabel.setVisible(false);}

public void hideContactRequestBadge() {
profileBadge.setVisible(false);
contactrequestBadge.setVisible(false);
contactrequestLabel.setVisible(false);}
 

public void showProfileBadge() {
profileBadge.setVisible(true);}


public void showInTransferButton() {
try{progressUpdateButton.setVisible(true);progressUpdateButton.setText("Transfer Update");
progressUpdateButton.setStyle(setBackgroundColor);}catch(Exception e) {}}


public void showInWaitingButton() {
try{progressUpdateButton.setVisible(true);progressUpdateButton.setText("Receive Files");
progressUpdateButton.setStyle(setBackgroundColor);}catch(Exception e) {}}

public void checkBackgroundActivity(){
if(INFILETRANSFER==true) {
Platform.runLater(()-> showInTransferButton());}

else if(INRECEIVERWAITING==true) {
Platform.runLater(()-> showInWaitingButton());}


}


@FXML
public void nullifiedcenter()throws IOException{
homeBorderpane.getChildren();homeBorderpane.setCenter(null);}


@FXML
public void hidePreviousResources(MouseEvent event) {
if(Contactanchor!=null){Contactanchor.setVisible(false);}	
if(NOTIFICATION>0)     {showNotificationBadge(NOTIFICATION);}
if(CONTACTREQUEST>0)   {showContactRequestBadge(CONTACTREQUEST);}
}

public void clearScreen(){
homeBorderpane.setOnKeyPressed((KeyEvent ke) -> {
    if (ke.getCode() == KeyCode.ESCAPE) {
        if(Contactanchor!=null){
            Contactanchor.setVisible(false);
        }}
});
}



public void prepareSlideMenuAnimation() {
TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
openNav.setToX(0);
TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
Settingitem.setOnAction((ActionEvent event)->{
if(navList.getTranslateX()!=0){
openNav.play();}
else{
closeNav.setToX((navList.getWidth()));
closeNav.play();}});}


@FXML
public void Setting() throws IOException{
TranslateTransition openNav=new TranslateTransition(new Duration(350), navList);
openNav.setToX(0);
TranslateTransition closeNav=new TranslateTransition(new Duration(350), navList);
if(navList.getTranslateX()!=0){
openNav.play();}
else{
closeNav.setToX((navList.getWidth()));
closeNav.play();}}



    @FXML
    private void addCustomerInvoice(ActionEvent event) throws IOException {
        Node root1 =null;prepareSlideMenuAnimation();
root1=FXMLLoader.load(getClass().getResource("CustomerInvoice.fxml"));
homeBorderpane.setCenter(root1);
 
    }

    @FXML
    private void addDealerInvoice(ActionEvent event) throws IOException {
        Node root1 =null;prepareSlideMenuAnimation();
root1=FXMLLoader.load(getClass().getResource("DealerInvoice.fxml"));
homeBorderpane.setCenter(root1);
    }

    @FXML
    private void checkInvoice(ActionEvent event) throws IOException {
        Node root1 =null;prepareSlideMenuAnimation();
        System.out.println("Check Invoices");
root1=FXMLLoader.load(getClass().getResource("CheckDealerInvoice.fxml"));
homeBorderpane.setCenter(root1);
    }

    @FXML
    private void addInventoryStock(ActionEvent event) throws IOException {
        Node root1 =null;prepareSlideMenuAnimation();
root1=FXMLLoader.load(getClass().getResource("AddInventory.fxml"));
homeBorderpane.setCenter(root1);
    }

    @FXML
    private void checkInventoryStock(ActionEvent event) throws IOException {
        Node root1 =null;prepareSlideMenuAnimation();
root1=FXMLLoader.load(getClass().getResource("CheckAvailableInventory.fxml"));
homeBorderpane.setCenter(root1);
    }
    
      @FXML
    private void checkSoldProducts(ActionEvent event) throws IOException {
              Node root1 =null;prepareSlideMenuAnimation();
root1=FXMLLoader.load(getClass().getResource("CheckSoldInventory.fxml"));
homeBorderpane.setCenter(root1);
    }

    @FXML
    private void settings(ActionEvent event) {
        System.out.println("Settings");
    }














public void showtransferhistory(ActionEvent event) throws IOException{
prepareSlideMenuAnimation();
Node root1 =null;checkBackgroundActivity();
root1=FXMLLoader.load(getClass().getResource("TransferHistory.fxml"));
homeBorderpane.setCenter(root1);}




public void showLoading(ActionEvent event) throws IOException{
ProgressIndicator PI=new ProgressIndicator(); 
PI.setStyle(" -fx-progress-color: white;");
Label label = new Label("Waiting for receiver to accept, Please wait ... ");
label.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-font-size:14px;");
//label.setPadding(new Insets(5,5,5,5));   
PI.setMinWidth(35);
PI.setMinHeight(35);
PI.setPrefWidth(35);
PI.setPrefHeight(35);
PI.setMaxWidth(35);
PI.setMaxHeight(35);
VBox root = new VBox(); 
root.getChildren().add(PI);
root.getChildren().add(label);
root.setAlignment(Pos.CENTER);
homeBorderpane.setCenter(root);}






@FXML
public void changePassword(ActionEvent event) throws IOException{
prepareSlideMenuAnimation();System.out.println("changePassword");
Node root1 =null;checkBackgroundActivity();
root1=FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
homeBorderpane.setCenter(root1);}


@FXML
public void changeDirectory(ActionEvent event) throws Exception{
prepareSlideMenuAnimation();System.out.println("changeDirectory");
String currentpath="";String newpath="";checkBackgroundActivity();
System.out.println("Current path is: "+currentpath);
try{newpath=chooseDefaultDirectory(new Stage(),currentpath);}catch(Exception e) {}
System.out.println(newpath);
}



public void redirectToURL(String url) {
Desktop desktop;
if (Desktop.isDesktopSupported()) {
try{
desktop = Desktop.getDesktop();
URI uri = new URI(url);desktop.browse(uri);}catch(IOException | URISyntaxException e){}}
else{System.out.println("Not supported on this machine");}}

public void infoButtonAction() throws URISyntaxException, IOException{
JWindow frame=new JWindow();
frame.setSize(480,300);
final JFXPanel fxpanel=new JFXPanel();
frame.getContentPane().add(fxpanel);
frame.setAlwaysOnTop(true);
frame.setLocationRelativeTo(null);
Platform.runLater(() -> {
WebEngine engine;URL url = null;
WebView wv=new WebView();
engine=wv.getEngine();
engine.setJavaScriptEnabled(true);
fxpanel.setScene(new Scene(wv));
File file = new File("webview/trango.html");
try {url = file.toURI().toURL();} catch (MalformedURLException ex) {}
engine.load(url.toString());});
frame.setVisible(true);}





public void loadurl(){
WebView webView = new WebView();
webView.getEngine().load("https://trango.io/");
Pane pane = new Pane();
pane.setMinWidth(720);
pane.setMinHeight(480);
pane.getChildren().add(webView);
homeBorderpane.getChildren().add(pane);}

public void showInfo(ActionEvent event) throws IOException, URISyntaxException{
prepareSlideMenuAnimation();System.out.println("showInfo");
try {redirectToURL("https://www.trango.io/whatistrango.html");}catch(Exception e) {}}
















@FXML
public void logout(ActionEvent event)throws IOException {
boolean logout=false;
if(logout) {
Parent root=FXMLLoader.load(getClass().getResource("Trango.fxml"));
homeAnchorpane.getChildren().setAll(root);}}

public void termandconditionAction(ActionEvent event) throws IOException {
homeBorderpane.setCenter(null);
webviewpage="termandconditionAction";System.out.println(webviewpage);
Node root=FXMLLoader.load(getClass().getResource("ShowWebview.fxml"));
homeBorderpane.setCenter(root);}


public void privacypolicyAction(ActionEvent event) throws IOException {
homeBorderpane.setCenter(null);
webviewpage="privacypolicyAction";System.out.println(webviewpage);
Node root=FXMLLoader.load(getClass().getResource("ShowWebview.fxml"));
homeBorderpane.setCenter(root);}





@FXML
public void about(ActionEvent event) {
try{redirectToURL("https://trango.io/");}catch(Exception e){}}

public  void help(ActionEvent event) {
try{redirectToURL("https://www.trango.io/help.html");}catch(Exception e){}}


public static Task<?> checkResponseTask;
public static Task<Object> runCheckResponseTask() {
return new Task<Object>() {
@Override
protected Object call() throws Exception {
waitforresponse();return true;}};}

public  void initCheckResponseTask(){
checkResponseTask = runCheckResponseTask();
checkResponseTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, (WorkerStateEvent t) -> {
    Parent root1 = null;
    try {
        root1 = FXMLLoader.load(getClass().getResource("Trango.fxml"));
        homeAnchorpane.getChildren().setAll(root1);
    }catch (IOException e) {}
});
new Thread(checkResponseTask).start();}


public static void waitforresponse() throws InterruptedException {
while(true){
if(DEACTIVATED==true) {break;}
else {TimeUnit.SECONDS.sleep(1);}}}






public void setUserInfo() throws MalformedURLException{
usernameLabel.setText("Name");emailLabel.setText(	"Email");
String image=HomeController.class.getResource("img/Profile.png").toExternalForm();
usernameLabel.setTooltip(new Tooltip("Fullname"));
emailLabel.setTooltip(new Tooltip("Email"));
userprofilePicture.setImage(new Image(image));}


public void showInforText(String text) throws IOException{
Node root=FXMLLoader.load(getClass().getResource("ShowInfoMessage.fxml"));
Text infoText=(Text)root.lookup("#infoText");
infoText.setText(text);
homeBorderpane.setCenter(root);}



























//ScaleTransition transition=null;
//
//public void highlightUploadButton(){
//uploadbutton.setStyle(setBackgroundColor+"-fx-background-radius: 5em;");
//transition = new ScaleTransition(Duration.millis(2000), uploadbutton);
//transition.setByX(0.3f);
//transition.setByY(0.3f);
//transition.setRate(2.5);
//transition.setCycleCount(4);
//transition.setAutoReverse(true);
//transition.play();}
//
//
//public void dehighlightUploadButton() {uploadbutton.setStyle("-fx-background-color: white;"+"-fx-background-radius: 5em;");}









public void setTooltipText() {
notificationLabel.setTooltip(new Tooltip(messsageNotificationLabel));
contactrequestLabel.setTooltip(new Tooltip(messsageContactrequestLabel));
changeDirectory.setTooltip(new Tooltip(messsageChangeDirectory));
changePassword.setTooltip(new Tooltip(messsageChangePassword));
aboutUs.setTooltip(new Tooltip(messsageAboutUs));
signedinDevices.setTooltip(new Tooltip(messsageSignedinDevices));
deactivateAccount.setTooltip(new Tooltip(messagedeactivateAccount));


}




public void hideUIResources() throws IOException{
dehighlightUploadButton();

slogenLabel.setVisible(false);

}


public void disableUIResources(){
}




















public void startBackgroundTasks() {
//try {checkNotification();}	      catch(Exception e) {e.printStackTrace();}
//try {checkCrashlogs();} 	      catch(Exception e) {e.printStackTrace();}
//try {checkForUpdates();}		  catch(Exception e) {e.printStackTrace();}
//try {checkForAnnouncement();}		  catch(Exception e) {e.printStackTrace();}

}








public void loadHomeScreen() {
parentHomeborder=homeBorderpane;
parentHomeAnchor=homeAnchorpane;



try {setTooltipText();} 	catch(Exception e) {e.printStackTrace();}
try {clearScreen();} 		catch(Exception e) {e.printStackTrace();}
try {hideUIResources();} 	catch(Exception e) {e.printStackTrace();}
try {hideAllBadges();}		catch(Exception e) {e.printStackTrace();}
prepareSlideMenuAnimation();
	
}



@Override
public void initialize(URL url, ResourceBundle rb) {

try{loadHomeScreen();}catch(Exception e) {}}     





public static void loadRoot(String root) throws IOException{
PROGRESSROOT=null;PROGRESSBORDER=null;
URL RESOURCEURL=UIResources.class.getClassLoader().
getResource(root);
PROGRESSROOT=FXMLLoader.load(RESOURCEURL);
PROGRESSBORDER=parentHomeborder;
PROGRESSBORDER.setCenter(PROGRESSROOT);}

    @FXML
    private void showSignedinDevices(ActionEvent event) {
    }

    @FXML
    private void deactivate(ActionEvent event) {
    }

    @FXML
    private void checkforUpdates(ActionEvent event) {
    }

  







  
 }
