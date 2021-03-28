package com.trango.app.model;

public class TransferInfo {
String transferid;
String senderid;
String receiverid;
String receivername;
String filesize;
String filename;
String transferspeed;
String transfertime;
String transfertype;
String transferstatus;



String toorfrom;
String contact;

public TransferInfo(String Toorfrom, String Contact, String Filename, String Filesize, String Transferdateandtime, String Transfertype) {
this.toorfrom = Toorfrom;
this.contact = Contact;
this.filename = Filename;
this.filesize = Filesize;
this.transfertime = Transferdateandtime;
this.transfertype = Transfertype;}

public String getToorfrom() {return this.toorfrom;}
public void setToorfrom(String Toorfrom) {this.toorfrom = Toorfrom;}
public String getContact() {return this.contact;}
public void setContact(String Contact) {this.contact = Contact;}
public String getFilename() {return this.filename;}
public void setFilename(String Filename) {this.filename = Filename;}
public String getFilesize() {return this.filesize;}
public void setFilesize(String Filesize) {this.filesize = Filesize;}
public String getTransferdateandtime() {return this.transfertime;}
public void setTransferdateandtime(String Transferdateandtime) {this.transfertime = Transferdateandtime;}
public String getTransfertype() {return this.transfertype;}
public void setTransfertype(String Transfertype) {this.transfertype = Transfertype;}


public TransferInfo(String tid, String sid, String rid, String receivername, String filesize, String filename, String transfer_time, String transfer_speed, String status, String typeOfTransfer) {
this.transferid = tid;
this.senderid = sid;
this.receiverid = rid;
this.receivername = receivername;
this.filesize = filesize;
this.filename = filename;
this.transferspeed = transfer_speed;
this.transfertime = transfer_time;
this.transferstatus = status;
this.transfertype = typeOfTransfer;}
    
public String getStrings() {
String tab="\t";String res=
this.transferid+tab+
this.senderid+tab+
this.receiverid+tab+
this.receivername+tab+
this.filesize+tab+
this.filename+tab+
this.transferspeed +tab+
this.transfertime+tab+
this.transferstatus+tab+
this.transfertype;
return res;}


public String getTransferid() {return transferid;}
public String getSenderid() {return senderid;}
public String getReceivername() {return receivername;}
public String getReceiverid() {return receiverid;}
public String getTransfeSpeed() {return transferspeed;}
public String getTransferTime() {return transfertime;}
public String getTransferType() {return transfertype;}
public String getTransferStatus() {return transferstatus;}
}
