package com.trango.application;
import static com.trango.application.DBLiterals.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ResourceManager  {



	
     



public  void createInventoryTable() throws Exception {  
try{  
    System.out.println(DBLiterals.CREATE_TABLE_INVENTORY_QUERY);
Statement stmt = getConnection().createStatement();  
stmt.execute(CREATE_TABLE_INVENTORY_QUERY);  
System.out.println("INVENTORY Table CREATED");} 
catch (SQLException e) {  System.out.println(e.getMessage());  }} 

public  void createInvoiceTable() throws Exception {   
try{  
Statement stmt = getConnection().createStatement();   
stmt.execute(CREATE_TABLE_INVOICE_QUERY);  System.out.println("INVOICE Table CREATED");} 
catch (SQLException e) {  System.out.println(e.getMessage());  }} 


public  void createCustomerTable() throws Exception {  
try{   
Statement stmt =getConnection().createStatement();  
stmt.execute(CREATE_TABLE_CUSTOMER_QUERY);  System.out.println("CUSTOMER Table CREATED");} 
catch (SQLException e) {  System.out.println(e.getMessage());  }} 

public  void createSaleTable() throws Exception {  
try{  
Statement stmt = getConnection().createStatement();  
stmt.execute(CREATE_TABLE_SALE_QUERY);  System.out.println("SALE Table CREATED");} 
catch (SQLException e) {  System.out.println(e.getMessage());  }} 


public  void dropInventoryTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "DROP Table INVENTORY"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {
            System.out.println("INVENTORY dropped!");
        }

    }
    catch(Exception e){}
}

public  void dropInvoiceTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "Drop Table INVOICE";  
    
        PreparedStatement statement = getConnection().prepareStatement(sql);
            
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {System.out.println("INVOICE dropped!");}
}


public  void dropCustomerTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "Drop Table CUSTOMER"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {System.out.println("CUSTOMER dropped!");}
    }
      catch(Exception e){}

}

public  void dropSaleTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "Drop Table SALE"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {
            System.out.println("SALE drop!");
        }

    }
      catch(Exception e){}
}


public  void clearInventoryTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "DELETE from INVENTORY"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {System.out.println("INVENTORY cleared!");}
    }
      catch(Exception e){}

}

public  void clearInvoiceTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "DELETE from INVOICE";  
    
        PreparedStatement statement = getConnection().prepareStatement(sql);
            
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {System.out.println("INVOICE cleared!");}
}


public  void clearCustomerTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "DELETE from CUSTOMER"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {
            System.out.println("CUSTOMER cleared!");
        }

    }
      catch(Exception e){}
}

public  void clearSaleTable() throws SQLException, ClassNotFoundException, Exception{
String sql = "DELETE from SALE"; 
    try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
        int rowsdeleted = statement.executeUpdate();
        if (rowsdeleted > 0) {System.out.println("SALE cleared!");}
    }
    
      catch(Exception e){}

}


public static void main(String args[]) throws ClassNotFoundException, Exception {
//new ResourceManager().initDatabaseResources();


//new ResourceManager().createInvoiceTable();
//new ResourceManager().showAllTables();

//new ResourceManager().clearDatabaseResources();
//new ResourceManager().dropDatabaseResources();

//try{new ResourceManager().dropSaleTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Sale Table");}
//try{new ResourceManager().createSaleTable();}catch(Exception e){System.out.println("Error creating Sale Table");}

	try{new ResourceManager().dropInvoiceTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Invoice Table");}
	try{new ResourceManager().createInvoiceTable();}catch(Exception e){System.out.println("Error creating Invoice Table");}
	
}

public void initDatabaseResources(){
System.out.println("Creating local DB");
//try{createNewDatabase();} catch(Exception e){System.out.println("Error creatring  Table");}
try{createInventoryTable();}catch(Exception e){System.out.println("Error creating Inventory Table");}
try{createInvoiceTable();}catch(Exception e){System.out.println("Error creating Invoice Table");}
try{createCustomerTable();}catch(Exception e){System.out.println("Error creating Customer Table");}
try{createSaleTable();}catch(Exception e){System.out.println("Error creating Sale Table");}


}
    
public void clearDatabaseResources() {
try{clearInventoryTable();}catch(Exception e){System.out.println("Error clearing Inventory Table");}
try{clearInvoiceTable();}catch(Exception e){System.out.println("Error clearing Invoice Table");}
try{clearCustomerTable();}catch(Exception e){System.out.println("Error clearing Customer Table");}
try{clearSaleTable();}catch(Exception e){System.out.println("Error clearing Sale Table");}

}

public void dropDatabaseResources() {
try{dropInventoryTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Inventory Table");}
try{dropInvoiceTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Invoice Table");}
try{dropCustomerTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Customer Table");}
try{dropSaleTable();}catch(Exception e){e.printStackTrace();System.out.println("Error dropping Sale Table");}

}



public void showAllTables() throws ClassNotFoundException, SQLException, Exception {
System.out.println("Showing all tables:");
try {  
ResultSet rs = getConnection().getMetaData().getTables(null, null, null, null);
while (rs.next()) {System.out.println(rs.getString("TABLE_NAME"));}}
catch (SQLException e) {  System.out.println(e.getMessage());  }  
}



public  void createNewDatabase() throws ClassNotFoundException {

	
	
   
  URL uri =ResourceManager.class.getResource(DBPATH);  
  System.out.println(uri);
  
  String url = "jdbc:sqlite:"+DBPATH;
  Class.forName(driverName);
    try (Connection conn = DriverManager.getConnection(DBPATH)) {
        if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

public static String DBPATH="/resources/others/database.db";
public static Connection connection=null;
public static String dbUrl="";
public static String driverName="org.sqlite.JDBC";

public static Connection getConnection() throws ClassNotFoundException, Exception {  

	  String dbpath="C:/Users/bee/eclipse-workspace/FXApplication/src/resources/others/database.db";

       try{
        Class.forName(driverName);
        try{
        if(connection==null){
            //dbUrl= "jdbc:sqlite::resource:resources/others/database.db";  
        	//dbUrl = "jdbc:sqlite:"+ResourceManager.class.getResource(DBPATH);       
        	//dbUrl = "jdbc:sqlite::resource:"+ResourceManager.class.getResource(DBPATH);
        	dbUrl = "jdbc:sqlite:"+dbpath;
        	
            
        connection= DriverManager.getConnection(dbUrl);
        System.out.println(">>Connection established with database");}} 
        
        catch(SQLException ex){
        System.out.println("Failed to create a connection with database due to following reason: ");
        ex.printStackTrace();}
        } 
        catch(ClassNotFoundException ex){System.out.println("Driver Not Found");}
   

return connection;}  




    
public static void closeConnection() throws ClassNotFoundException, Exception {  
Class.forName(driverName);connection.close();

} 






}
