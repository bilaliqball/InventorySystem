package com.trango.app.appui;

import java.awt.Toolkit;






public class DialogAlerts {








public static void makeAlert(String message, String title) {
//Alert alert=null;Toolkit.getDefaultToolkit().beep();
//alert = new Alert(Alert.AlertType.WARNING);
//alert.setTitle(title);
//alert.setHeaderText(null);
//alert.setContentText(message);
//DialogPane dialogPane = alert.getDialogPane();
//dialogPane.setStyle("-fx-background-radius: 15 15 15 15;fx-background-color:transparent;-fx-border-radius: 0 0 0 0;");
//dialogPane.getStyleClass().add("rescanDialogbox");
////alert.initStyle(UNDECORATED);
//
//alert.show();
}



//public  String  showRescanOrSendOnlineConfirmation(String message) {
//Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("No scanned user found");
//alert.setHeaderText("No scanned user found:");
//alert.setHeaderText(null);
//alert.setContentText(message);
//DialogPane dialogPane = alert.getDialogPane();
//dialogPane.getScene().setFill(Color.TRANSPARENT);
//dialogPane.setStyle("-fx-background-radius: 15 15 15 15;fx-background-color:transparent;-fx-border-radius: 0 0 0 0;");
//dialogPane.getStylesheets().add(getClass().getResource("receivefile.css").toExternalForm());
//dialogPane.getStyleClass().add("rescanDialogbox");
//ButtonType Decline = new ButtonType("Decline");
//ButtonType Rescan = new ButtonType("Rescan");
//ButtonType Online = new ButtonType("Send Online");
//alert.getButtonTypes().clear();
//alert.getButtonTypes().addAll(Decline, Rescan, Online);
////alert.initStyle(UNDECORATED);
//Optional<ButtonType> option = alert.showAndWait();
//String selected=null;   
//     if (option.get() == null) {selected="No selection!";} 
//else if (option.get() == Decline) {selected="decline";} 
//else if (option.get() == Rescan) {selected="rescan";} 
//else if (option.get() == Online) {selected="online";} 
//return selected;}
//
//
//
//
//
//
//
//
//
//
//
//public int showConfirmDialog(String message,String title) {
//Alert alert = new Alert(AlertType.CONFIRMATION);int res=-1;
//alert.setTitle(title);
//alert.setHeaderText(null);
//alert.setContentText(message);
//Optional<ButtonType> result = alert.showAndWait();
//if (result.get() == ButtonType.OK){res=0;} 
//else {res=1;}
//return res;}
//
//
//
//public  void showNotification(String message,String title) throws AWTException {
//Toolkit.getDefaultToolkit().beep();
//SystemTray tray = SystemTray.getSystemTray();
//java.awt.Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
//TrayIcon trayIcon = new TrayIcon(image, "Notification");
//trayIcon.setImageAutoSize(true);
//trayIcon.setToolTip("Notification");
//tray.add(trayIcon);
//trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);}
//
//
//
//
//
//
//public static void showProgressDialog(String message, String title) {
//ImageIcon icon = new ImageIcon("loading (8).gif");
//String[] options = {"Stop "+message};
//Toolkit.getDefaultToolkit().beep();
//JFrame frame = new JFrame();frame.toFront();
//int x = JOptionPane.showOptionDialog(frame, message,title,JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
//System.out.println(x);
//frame.dispose();}












}
