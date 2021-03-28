
package com.trango.app.appui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class ShowLoadingMessageController implements Initializable {



    
public Label titleString;
public Button okButton;
@FXML public static Label messageString;
@FXML public Label actionString;
public ScrollPane progressScrollpane;
public BorderPane progressBorderpane;
@FXML public AnchorPane alertMessageanchor;
@FXML public Button alertMessageclose;
@FXML private Button loadingButton;


@FXML
public void closerecieve(ActionEvent event){
alertMessageanchor.getChildren();
alertMessageanchor.setVisible(false);}

public void okButtonAction(){
alertMessageanchor.getChildren();
alertMessageanchor.setVisible(false);}



@SuppressWarnings("static-access")
@Override
public void initialize(URL url, ResourceBundle rb) {



}    

}
