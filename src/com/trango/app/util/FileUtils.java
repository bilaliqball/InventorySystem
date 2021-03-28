package com.trango.app.util;
import static com.trango.app.util.Utils.generateRandomString;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileUtils {
public static FileUtils compress;
public static File[] selectedfiles;

private FileUtils() {}



public static FileUtils getInstance() {
if (compress == null)
compress = new FileUtils();
return compress;}


public  static String zipDirectory(File dir) throws IOException {
String pardir=dir.getParent();
String filename=dir.getName();
String outputZipFile =pardir+"\\_"+filename+".zip";
byte[] buffer = new byte[4096];
try{
File files[]=dir.listFiles();
FileOutputStream fos = new FileOutputStream(outputZipFile);
ZipOutputStream zos = new ZipOutputStream(fos);
for(File file:files) {
System.out.println(file);
ZipEntry ze= new ZipEntry(file.getName().toString());
zos.putNextEntry(ze);
FileInputStream in = new FileInputStream(file);
int len;while ((len = in.read(buffer)) > 0) {zos.write(buffer, 0, len);}
in.close();}
zos.closeEntry();zos.close();}
catch(IOException ex){ex.printStackTrace();}
System.out.println("Compressed");
return outputZipFile;}








public static void writeExceptionLog(String exception) throws IOException {
System.out.println(exception);
File exceptionLogfile=new File("errorlog.txt");
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
String datenow = sdf.format(new Date());String timestamp="["+datenow.toString()+"] ";
BufferedWriter writer = new BufferedWriter(new FileWriter(exceptionLogfile,true));
writer.write(timestamp+ exception);writer.newLine();writer.close();}


public static void clearExceptionLog() throws IOException {
File exceptionLogfile=new File("errorlog.txt");
BufferedWriter writer = new BufferedWriter(new FileWriter(exceptionLogfile));
writer.write("");writer.close();}

public  static File zipMultiFiles(File files[]) throws IOException {
String pardir=files[0].getParent();
String filename="";
filename="TRANGO_"+generateRandomString()+".zip";
//for(File file:files) {
//filename=file.getName();
//name=filename.substring(0,filename.lastIndexOf('.'));
//filenames+=name+"_";}


String outputZipFile =pardir+"/"+filename;
byte[] buffer = new byte[4096];
try{
FileOutputStream fos = new FileOutputStream(outputZipFile);
ZipOutputStream zos = new ZipOutputStream(fos);
for(File file:files) {
ZipEntry ze= new ZipEntry(file.getName().toString());
zos.putNextEntry(ze);
FileInputStream in = new FileInputStream(file);
int len;while ((len = in.read(buffer)) > 0) {zos.write(buffer, 0, len);}
in.close();}
zos.closeEntry();zos.close();}
catch(IOException ex){ex.printStackTrace();}
return new File(outputZipFile);}


public  void unzip(File zipFile) throws IOException{
String par=zipFile.getParent();
String filename=zipFile.getName(); 
String name=filename.substring(0,filename.lastIndexOf('.'));
String comdir=par+"\\"+name+"\\_comp";
new File(comdir).mkdirs();
byte[] buffer = new byte[4096];
ZipInputStream zis=null;
ZipEntry ze=null;
FileOutputStream fos = null;
try{
zis= new ZipInputStream(new FileInputStream(zipFile));
ze= zis.getNextEntry();
while(ze!=null){
String fileName = ze.getName();
File newFile = new File(comdir+"\\"+fileName);
fos = new FileOutputStream(newFile);             
int len;
while ((len = zis.read(buffer)) > 0) {fos.write(buffer, 0, len);}
fos.close();ze = zis.getNextEntry();}}
catch(IOException ex){ex.printStackTrace(); }
finally{fos.close();zis.closeEntry();zis.close();}}


public static File[] chooseFiles() throws IOException {
String username = System.getProperty("user.name");
final FileDialog fileDialog = new FileDialog((Frame) null, "Choose File");
fileDialog.setMultipleMode(true);
fileDialog.setDirectory(username);
fileDialog.setVisible(true);
File files[] = fileDialog.getFiles();
for (File file : files) {System.out.println(file);}
return files;}






public  static String chooseDefaultDirectory(Stage stage,String path) throws Exception{
DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory=directoryChooser.showDialog(stage);
directoryChooser.setTitle("Change default directory for storage");
directoryChooser.setInitialDirectory(new File(path));
return selectedDirectory.getAbsolutePath();}

public static File[] chooseFiles(Stage stage,String message){
FileChooser fileChooser = new FileChooser();
fileChooser.setTitle(message);File[] files =null;
List<File> selectedFiles=fileChooser.showOpenMultipleDialog(stage);
if(selectedFiles!=null){
files= selectedFiles.toArray(new File[selectedFiles.size()]);return files;}
return null;}


public static File chooseFile(Stage stage,String message) throws IOException{
FileChooser fileChooser = new FileChooser();
fileChooser.setTitle(message);File[] files =null;File file=null;
List<File> selectedFiles=fileChooser.showOpenMultipleDialog(stage);
if(selectedFiles!=null){
files= selectedFiles.toArray(new File[selectedFiles.size()]);}
if(files.length==1) {file=files[0];}
else if(files.length>1) {

file=zipMultiFiles(files);

}
return file;}


public static File[] chooseFileArray(Stage stage,String message) throws IOException{
FileChooser fileChooser = new FileChooser();
fileChooser.setTitle(message);selectedfiles = null;
List<File> selectedFilelist=fileChooser.showOpenMultipleDialog(stage);
if(selectedFilelist!=null){
selectedfiles= selectedFilelist.toArray(new File[selectedFilelist.size()]);}
else if(selectedfiles.length>1) {
System.out.println("Creating archive for " );

File  zipFile=zipMultiFiles(selectedfiles);
selectedfiles=new File[] {zipFile};

}
return selectedfiles;}


public  static String chooseDirectory(Stage stage,String message) throws Exception{
DirectoryChooser directoryChooser = new DirectoryChooser();
File selectedDirectory=directoryChooser.showDialog(stage);
directoryChooser.setTitle(message);
directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
System.out.println(selectedDirectory);
String fileout="";

return fileout;}



public static String chooseInput() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
JFileChooser chooser;String fileout="";
//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
String username = System.getProperty("user.name");
String path = "C:\\Users\\"+username+"\\Pictures\\";
chooser = new JFileChooser(); 
chooser.setCurrentDirectory(new File(path));
chooser.setDialogTitle("Choose File");
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
chooser.setMultiSelectionEnabled(true);
chooser.setAcceptAllFileFilterUsed(false);
String filterfiles="png";
FileNameExtensionFilter filter = new FileNameExtensionFilter("FILES",filterfiles );
chooser.addChoosableFileFilter(filter);
if(chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
String choosed=chooser.getSelectedFile().toString();
File file=new File(choosed);
File files[]= chooser.getSelectedFiles();
for (File fi : files) {System.out.println(fi);}
if(file.isFile()) {System.out.println("File choosed: "+file.getName());}
if(file.isDirectory()) {System.out.println("Directory choosed: "+file.getName());
fileout=zipDirectory(file);}}
return fileout;
}

public static void getHashmap(String[] args) {
HashMap<String, String> USERS = new HashMap<>();
USERS.put("Beelal", "...");
USERS.put("Zain", "...");
USERS.put("Abdullah", "...");
USERS.put("Ayesha", "...");
USERS.put("Beelal", "Sent");
System.out.println(USERS);
System.out.println(USERS.get("Beelal"));
for (String i : USERS.keySet()) {System.out.println(i);}
for (String i : USERS.values()) {System.out.println(i);}
for (String i : USERS.keySet()) {System.out.println("key: " + i + " value: " + USERS.get(i));}
USERS.clear();System.out.println(USERS.get("Beelal"));}

public static void openFile(String filepath) throws IOException{
File file=new File(filepath);
if (Desktop.isDesktopSupported()) {Desktop.getDesktop().open(file);}}

public static void openDirectory(String dirpath) throws IOException{
File file=new File(dirpath);
if (Desktop.isDesktopSupported()) {Desktop.getDesktop().open(file);}}






}

