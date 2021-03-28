package com.trango.app.appui;
import static com.trango.app.appui.UIResources.parentHomeborder;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;




public class Dialog {
    
public Node getRoot(String xmlfile) throws IOException {
Node root=null;
File f=new File("src/trango/"+xmlfile);
URL url = f.toURI().toURL();
root= FXMLLoader.load(url);
return root;}




public void showInfoDialog(String message,String action,String title) throws IOException{
Node root=null;
root=FXMLLoader.load(getClass().getResource("ShowAlertMessage.fxml"));
//File f=new File("src/trango/ShowAlertMessage.fxml");
//URL url = f.toURI().toURL();root= FXMLLoader.load(url);
Label titleString=(Label)root.lookup("#titleString");
Label messageString=(Label)root.lookup("#messageString");
Label actionString=(Label)root.lookup("#actionString");
titleString.setText(title);
messageString.setText(message);
actionString.setText(action);
messageString.setWrapText(true);
messageString.setTextAlignment(TextAlignment.JUSTIFY);
actionString.setText(action);
parentHomeborder.setCenter(root);}


public void showInfoPrompt(String message,String action,String title) throws IOException{
Node root=null;
root=FXMLLoader.load(getClass().getResource("ShowAlertPrompt.fxml"));
Label titleString=(Label)root.lookup("#titleString");
Text messageString=(Text)root.lookup("#messageString");
Label actionString=(Label)root.lookup("#actionString");
titleString.setText(title);
messageString.setText(message);
actionString.setText(action);
messageString.setTextAlignment(TextAlignment.JUSTIFY);
parentHomeborder.setCenter(root);}

//public void showMessageDialog(String message,String action,String title) throws IOException{
//Node root=null;
//root=FXMLLoader.load(getClass().getResource("ShowAlertMessage.fxml"));
////File f=new File("src/trango/ShowAlertMessage.fxml");
////URL url = f.toURI().toURL();root= FXMLLoader.load(url);
//Label titleString=(Label)root.lookup("#titleString");
//Label messageString=(Label)root.lookup("#messageString");
//Label actionString=(Label)root.lookup("#actionString");
//titleString.setText(title);
//messageString.setText(message);
//messageString.setWrapText(true);
//messageString.setTextAlignment(TextAlignment.JUSTIFY);
//actionString.setText(action);
//parentMenuborder.setCenter(root);}
    



//public void showPasswordDialog(String message,String action,String title) throws IOException{
//Node root=null;
//root=FXMLLoader.load(getClass().getResource("ShowInfoMessage.fxml"));
//Label titleString=(Label)root.lookup("#titleString");
//Label messageString=(Label)root.lookup("#messageString");
//Label actionString=(Label)root.lookup("#actionString");
//titleString.setText(title);
//messageString.setText("Hotspot Name: "+ HOTSPOTNAME);
//actionString.setText("Hotspot Pass: "+HOTSPOTPASSWORD);
//parentMenuborder.setCenter(root);}


public void createshareablelink(String url) throws IOException{
Node root=null;
root=FXMLLoader.load(getClass().getResource("Shareablelink.fxml"));
TextField shareablelinkTextfield=(TextField)root.lookup("#shareablelinkTextfield");
shareablelinkTextfield.setText(url);
StringSelection stringSelection = new StringSelection(url);
Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
clipboard.setContents(stringSelection, null);
parentHomeborder.setCenter(root);}


public void createshareablelinkUnregister(String url,String message) throws IOException{
Node root=null;
root=FXMLLoader.load(getClass().getResource("ShareablelinkUnregister.fxml"));
TextField shareablelinkTextfield=(TextField)root.lookup("#shareablelinkTextfield");
Text messageString=(Text)root.lookup("#messageString");
Label usagelabel=(Label)root.lookup("#usagelabel");
shareablelinkTextfield.setText(url);
messageString.setText(message );
usagelabel.setText("You can Sign Up for unlimited sharing and powerful features.");
StringSelection stringSelection = new StringSelection(url);
Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
clipboard.setContents(stringSelection, null);
parentHomeborder.setCenter(root);}


public void showProgressIndicator(String text) throws IOException{
ProgressIndicator PI=new ProgressIndicator(); 
PI.setStyle(" -fx-progress-color: white;");
Label label = new Label(text);
label.setStyle("-fx-background-color:transparent;-fx-text-fill:white;-fx-font-size:14px;");
PI.setMinWidth(35);PI.setMinHeight(35);
PI.setPrefWidth(35);PI.setPrefHeight(35);
PI.setMaxWidth(35);PI.setMaxHeight(35);
VBox root = new VBox(); 
root.getChildren().add(PI);
root.getChildren().add(label);
root.setAlignment(Pos.CENTER);
parentHomeborder.setCenter(root);}


















}
