/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.model;

/**
 *
 * @author bilal.iqbal
 */
public class NotificationInfo {

	String currentTime;String actionType;String notificationType;String notificationText;

	
	public String  datetime, actiontype, notificationMessage;

public NotificationInfo(String time, String type, String message) {
this.datetime = time;
this.actiontype = type;
this.notificationMessage=message;}

public String getDatetime() {return datetime;}
public void setDatetime(String time) {this.datetime = time;}

public String getActionType() {return actiontype;}
public void getActionType(String type) {this.actiontype = type;}

public String getNotificationMessage() {return notificationMessage;}
public void setNotificationMessage(String message) {this.notificationMessage = message;}

public NotificationInfo(String currenttime,String actiontype,String notificationtype,String notificationtext) {
this.currentTime=currenttime;
this.actionType=actiontype;
this.notificationType=notificationtype;
this.notificationText=notificationtext;}
    
public String getStrings() {
String tab="\t";String res=
this.currentTime+tab+
this.actionType+tab+
this.notificationType+tab+
this.notificationText+tab;
return res;}


  
}
