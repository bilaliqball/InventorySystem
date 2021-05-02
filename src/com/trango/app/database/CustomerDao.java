
package com.trango.app.database;
import com.trango.app.model.CustomerInfo;
import com.trango.app.util.Utils;
import static com.trango.application.DBLiterals.*;
import com.trango.application.ResourceManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;








public class CustomerDao  {

 
    


	public boolean addUserInfo(CustomerInfo customer) throws SQLException, ClassNotFoundException, Exception {
		PreparedStatement statement=null;
		boolean res=false;
		String sql = 
		"INSERT INTO user ("+
		COLUMN_USER_NAME +SEPARATOR_COMMA+ 
		COLUMN_GENDER + SEPARATOR_COMMA+ 
		COLUMN_DESIGNATION +  SEPARATOR_COMMA+ 
		COLUMN_DEPARTMENT +  SEPARATOR_COMMA+ 
		COLUMN_AGE +  SEPARATOR_COMMA+ 
		COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
		"VALUES(?,?,?,?,?,?)";  

		statement = ResourceManager.getConnection().prepareStatement(sql);  
		statement.setString(1, customer.getCustomerName());
		statement.setString(2, "Male");
		statement.setString(3, "Software Eniginneer");
		statement.setString(4, "IT");
		statement.setInt(5, 28);
		statement.setString(6, Utils.getCurrentDateTime());
		statement.executeUpdate();
		System.out.println("User added");
		statement.close();
		res=true;
		return res;}


public boolean addCustomerInfo(CustomerInfo customer) throws SQLException, ClassNotFoundException, Exception {
PreparedStatement statement=null;
boolean res=false;
String sql = 
"INSERT INTO CUSTOMER ("+
COLUMN_CUSTOMER_ID + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_NAME +SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_TYPE + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_CONTACT +  SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_ADDRESS +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?)";  

statement = ResourceManager.getConnection().prepareStatement(sql);  
statement.setString(1, customer.getCustmerId());
statement.setString(2, customer.getCustomerName());
statement.setString(3, customer.getCustomerType());
statement.setString(4, customer.getCustomerContact());
statement.setString(5, customer.getCustomerAddress());
statement.setString(6, Utils.getCurrentDateTime());
statement.executeUpdate();
System.out.println("Customer added");
statement.close();
res=true;
return res;}







public void displayTableData() throws ClassNotFoundException, SQLException, Exception{
String customerid = "";
String customername = "";
String customertype = "";
String customercontact = "";
String customeraddress = "";
String datetime = "";

String sql = "SELECT * FROM CUSTOMER";  
String row=""; String tab="\t";

String title=
"customerid"+tab+
"customername"+tab+
"customertype"+tab+
"customercontact"+tab+
"customeraddress"+tab+
"datetime"+"\n";

Connection conn=null;
Statement statement=null;
try {  
conn =ResourceManager.getConnection();  
statement  = conn.createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  
row=title;
while (resultset.next()) {  


    
customerid=resultset.getString(COLUMN_CUSTOMER_ID);
customername=resultset.getString(COLUMN_CUSTOMER_NAME);
customertype=resultset.getString(COLUMN_CUSTOMER_TYPE);
customercontact=resultset.getString(COLUMN_CUSTOMER_CONTACT);
customeraddress=resultset.getString(COLUMN_CUSTOMER_ADDRESS);
datetime=resultset.getString(COLUMN_DATE_TIME);



row+=
customerid+tab+
customername+tab+
customertype+tab+
customercontact+tab+
customeraddress+tab+
datetime+
"\n";}  
System.out.println(row);} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();conn.close();//ResourceManager.closeConnection();
}
}








}

