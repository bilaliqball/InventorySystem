package com.trango.app.appui;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class TrangoController implements Initializable {


@FXML public BorderPane Borderpane;
@FXML public AnchorPane trangoanchor;
public Label appclose;
public PasswordField signinpassword;
public TextField passwordtextfiels;


public void LoadForgetPasssword() throws IOException{
Node root2 =null;
root2=FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
Borderpane.setCenter(root2);}

public void LoadSignup() throws IOException{
Node root3 =null;
root3=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
Borderpane.setCenter(root3);}

public void loadSignin() throws IOException{
Node root1 =null;
root1=FXMLLoader.load(getClass().getResource("SignIn.fxml"));
Borderpane.setCenter(root1);}

public void appclose(ActionEvent event) throws IOException{
Stage stage;
stage = (Stage)((Button)event.getSource()).getScene().getWindow();
stage.close();}






@Override
public void initialize(URL url, ResourceBundle rb) {}    

}
