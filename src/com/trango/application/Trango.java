package com.trango.application;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;





import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.stage.WindowEvent;



public class Trango extends Application {

private double xOffset = 0;
private double yOffset = 0;


public Parent root;
public Scene scene;
public Stage splashstage;



public void setbackgroundImage() throws MalformedURLException{
URL RESOURCEURL=null;
try{RESOURCEURL=Trango.class.getClassLoader().getResource("trango/img/background.jpg");}catch(Exception e) {}
System.out.println(RESOURCEURL);
root.setStyle("-fx-background-image: url(" +RESOURCEURL+ ");" + "-fx-background-size: 100% 100%;");}









@Override
public void start(Stage stage) throws Exception {
root = FXMLLoader.load(getClass().getResource("/com/trango/app/appui/Home.fxml"));
scene = new Scene(root);




stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, e->{
e.consume();
stage.close();System.exit(0);});

root.setOnMousePressed(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
xOffset = event.getSceneX();
yOffset = event.getSceneY();}});
root.setOnMouseDragged(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
stage.setX(event.getScreenX() - xOffset);
stage.setY(event.getScreenY() - yOffset);}}); 



Image image = new Image("/resources/imgs/icon.png");






stage.setScene(scene);
stage.setResizable(false);
stage.setTitle("TRANGO"); 
stage.getIcons().add(image);
stage.sizeToScene();
stage.setResizable(true);
stage.show();


}

public static boolean lock=false;
public static void main(String[] args) {
    launch(args);


}




}
