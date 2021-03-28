/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.trango.app.appui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class Webviews extends JFrame {


private static final long serialVersionUID = 1L;
private final JFXPanel jfxPanel = new JFXPanel();
private WebEngine engine;

String url = "https://www.trango.io/privacy-policy.html";

public Webviews() {
super();
initComponents();
getContentPane().add(jfxPanel);
setSize(680, 360);
// Kill everything on closing the frame
addWindowListener(new WindowAdapter() {
public void windowClosing(WindowEvent e) {}});}

public void initComponents() {
Platform.runLater(new Runnable() {
@Override
public void run() {
WebView view = new WebView();
engine = view.getEngine();
engine.load(url);
Scene scene = new Scene(view);
jfxPanel.setScene(scene);}});}

public static void run() {
Webviews main = new Webviews();
main.setVisible(true);}



public void infoButtonAction() throws URISyntaxException, IOException{
JWindow frame=new JWindow();
frame.setSize(480,300);
final JFXPanel fxpanel=new JFXPanel();
frame.getContentPane().add(fxpanel);
frame.setAlwaysOnTop(true);
frame.setLocationRelativeTo(null);
Platform.runLater(new Runnable() {
@Override
public void run(){
WebEngine engine;
WebView wv=new WebView();
engine=wv.getEngine();
engine.setJavaScriptEnabled(true);
fxpanel.setScene(new Scene(wv));

  String html = Webviews.class.getResource("/webviews/TermandConditions.html").toExternalForm();
engine.load(html);}});
frame.setVisible(true);}




}
