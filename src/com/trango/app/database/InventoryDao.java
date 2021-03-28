/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.database;

import com.trango.app.model.ProductInfo;
import static com.trango.application.DBLiterals.COLUMN_DATE_TIME;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_CATEGORY;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_DETAILS;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_ID;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_NAME;
import static com.trango.application.DBLiterals.COLUMN_NUMBER_OF_UNITS;
import static com.trango.application.DBLiterals.COLUMN_SERIAL_NUMBER;
import static com.trango.application.DBLiterals.COLUMN_TOTAL_PRICE;
import static com.trango.application.DBLiterals.COLUMN_UNIT_PRICE;
import com.trango.application.ResourceManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilaliqbal
 */
public class InventoryDao {
    
   
    
    public String getProductId(String productName) throws Exception{
 PreparedStatement statement;
	    ResultSet rs;
		
        String productid="000";
        //String exitstquery="SELECT EXISTS(SELECT * from INVENTORY WHERE productName=?) as productexist";
        String exitstquery="SELECT * from INVENTORY WHERE productName=?";
    statement = ResourceManager.getConnection().prepareStatement(exitstquery);
    statement.setString(1, productName.trim());
    rs=statement.executeQuery();
    if(rs.next()){
        productid = rs.getString("productId");}
return productid;
}


public int getProductCount(String productname) throws Exception{
int productCount = 0;
        try
{
    PreparedStatement statement;
    //String sql = "select count(productName) as productCount from INVENTORY where productName=?";
    String sql = "select * from INVENTORY where productName=?";
    statement = ResourceManager.getConnection().prepareStatement(sql);
    statement.setString(1,productname);
    ResultSet rs = statement.executeQuery();
    
    if(rs.next())
    {
        productCount = rs.getInt("noOfUnits");

    }
    return productCount;
}
catch(SQLException ex)
{

}
return 0;
}
    


public List<String>  getProductNamelist(String keyword) throws Exception{

List<String> productnameList=new ArrayList<>();
        try
{
    PreparedStatement statement;
    //String sql = "select count(productName) as productCount from INVENTORY where productName=?";
    String sql = "select * from INVENTORY where productName like?";
    statement = ResourceManager.getConnection().prepareStatement(sql);
    statement.setString(1,"%"+keyword+"%");
    ResultSet rs = statement.executeQuery();
    
    while(rs.next())
    {
      productnameList.add(rs.getString("productName"));

    }
  
}
catch(SQLException ex)
{

}
  return productnameList;
}
    


public List<ProductInfo>  getProductData() throws Exception{
List<ProductInfo> productlist=new ArrayList<>();


        try
{
    PreparedStatement statement;

    String sql = "select * from INVENTORY";
    statement = ResourceManager.getConnection().prepareStatement(sql);
 
    ResultSet rs = statement.executeQuery();
    
    while(rs.next())
    {
   
      
      productlist.add(new ProductInfo(rs.getString("productId"),rs.getString("productName"),rs.getString("productType"),rs.getInt("noOfUnits")));
      
      

    }
  
}
catch(SQLException ex)
{

}
  return productlist;
}

    public List<ProductInfo> getAvailableInventory() throws ClassNotFoundException, SQLException, Exception{
List<ProductInfo> availableInventory=new ArrayList<>();

String productid = null;
String productname = null;
String productcategory = null;
String productdescription = null;
String serialnumber = null;
double unitprice ;
int noofunits ;
double totalprice;

String datetime = null;

String sql = "SELECT * FROM INVENTORY";  
String row=""; String tab="\t";

String title=
"ProductID"+tab+
"ProductName"+tab+
"ProductCategory"+tab+
"ProductDescription"+tab+
"SerialNumber"+tab+
"UnitPrice"+tab+
"NoFfUnits"+tab+
"TotalPrice"+tab+
"Datetime"+"\n";


ProductInfo product;
Statement statement = null;

System.out.println(title);

try {  
statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  


while (resultset.next()) {  

productid=resultset.getString(COLUMN_PRODUCT_ID);
productname=resultset.getString(COLUMN_PRODUCT_NAME);
productcategory=resultset.getString(COLUMN_PRODUCT_CATEGORY);
productdescription=resultset.getString(COLUMN_PRODUCT_DETAILS);
serialnumber=resultset.getString(COLUMN_SERIAL_NUMBER);
unitprice=resultset.getDouble(COLUMN_UNIT_PRICE);
noofunits=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
totalprice=resultset.getDouble(COLUMN_TOTAL_PRICE);
datetime=resultset.getString(COLUMN_DATE_TIME);

product=new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits, totalprice);
availableInventory.add(product);
//System.out.println(product.toString());



}  
System.out.println(row);} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();

}

return availableInventory;
}


    
    
    public List<ProductInfo> getAvailableInventory(String keyword) throws ClassNotFoundException, SQLException, Exception{
List<ProductInfo> availableInventory=new ArrayList<>();

String productid = null;
String productname = null;
String productcategory = null;
String productdescription = null;
String serialnumber = null;
double unitprice ;
int noofunits ;
double totalprice;

String datetime = null;

String sql = "SELECT * FROM INVENTORY where productName like ?";  
String row=""; String tab="\t";

String title=
"ProductID"+tab+
"ProductName"+tab+
"ProductCategory"+tab+
"ProductDescription"+tab+
"SerialNumber"+tab+
"UnitPrice"+tab+
"NoFfUnits"+tab+
"TotalPrice"+tab+
"Datetime"+"\n";


ProductInfo product;
PreparedStatement statement = null;

System.out.println(title);

try {  
statement  = ResourceManager.getConnection().prepareStatement(sql);
statement.setString(1,"%"+keyword+"%");
ResultSet resultset    = statement.executeQuery();  


while (resultset.next()) {  

productid=resultset.getString(COLUMN_PRODUCT_ID);
productname=resultset.getString(COLUMN_PRODUCT_NAME);
productcategory=resultset.getString(COLUMN_PRODUCT_CATEGORY);
productdescription=resultset.getString(COLUMN_PRODUCT_DETAILS);
serialnumber=resultset.getString(COLUMN_SERIAL_NUMBER);
unitprice=resultset.getDouble(COLUMN_UNIT_PRICE);
noofunits=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
totalprice=resultset.getDouble(COLUMN_TOTAL_PRICE);
datetime=resultset.getString(COLUMN_DATE_TIME);

product=new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits, totalprice);
availableInventory.add(product);
//System.out.println(product.toString());



}  
System.out.println(row);} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();

}

return availableInventory;
}
    
public List<ProductInfo> getSoldInventory() throws ClassNotFoundException, SQLException, Exception{
String productid = null;
String productname = null;
String productcategory = null;
String productdescription = null;
String serialnumber = null;
double unitprice;
int noofunits;
double totalprice;

String datetime = null;

List<ProductInfo> remainingInventory=new ArrayList<>();

String sql = "SELECT * FROM SALE";  
String tab="\t";

String title=
"ProductID"+tab+
"ProductName"+tab+
"ProductCategory"+tab+
"ProductDescription"+tab+
"SerialNumber"+tab+
"UnitPrice"+tab+
"NoFfUnits"+tab+
"TotalPrice"+tab+
"Datetime"+"\n";

System.out.println(title);

Statement statement=null;
ProductInfo product;
try {  

statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  

while (resultset.next()) {  
productid=resultset.getString(COLUMN_PRODUCT_ID);
productname=resultset.getString(COLUMN_PRODUCT_NAME);
productcategory=resultset.getString(COLUMN_PRODUCT_CATEGORY);
productdescription=resultset.getString(COLUMN_PRODUCT_DETAILS);
serialnumber=resultset.getString(COLUMN_SERIAL_NUMBER);
unitprice=resultset.getDouble(COLUMN_UNIT_PRICE);
noofunits=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
totalprice=resultset.getDouble(COLUMN_TOTAL_PRICE);
datetime=resultset.getString(COLUMN_DATE_TIME);

product=new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits, totalprice);
remainingInventory.add(product);
//System.out.println(product.toString());



}  


} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();
//conn.close();
//ResourceManager.closeConnection();
}

return remainingInventory;
}

public List<ProductInfo> getSoldInventory(String keyword) throws ClassNotFoundException, SQLException, Exception{
String productid = null;
String productname = null;
String productcategory = null;
String productdescription = null;
String serialnumber = null;
double unitprice;
int noofunits;
double totalprice;

String datetime = null;

List<ProductInfo> remainingInventory=new ArrayList<>();

String sql = "SELECT * FROM SALE where productName like ?";  
String tab="\t";

String title=
"ProductID"+tab+
"ProductName"+tab+
"ProductCategory"+tab+
"ProductDescription"+tab+
"SerialNumber"+tab+
"UnitPrice"+tab+
"NoFfUnits"+tab+
"TotalPrice"+tab+
"Datetime"+"\n";

System.out.println(title);

PreparedStatement statement = null;
ProductInfo product;
try {  

statement  = ResourceManager.getConnection().prepareStatement(sql);  
statement.setString(1,"%"+keyword+"%");
ResultSet resultset    = statement.executeQuery();  

while (resultset.next()) {  
productid=resultset.getString(COLUMN_PRODUCT_ID);
productname=resultset.getString(COLUMN_PRODUCT_NAME);
productcategory=resultset.getString(COLUMN_PRODUCT_CATEGORY);
productdescription=resultset.getString(COLUMN_PRODUCT_DETAILS);
serialnumber=resultset.getString(COLUMN_SERIAL_NUMBER);
unitprice=resultset.getDouble(COLUMN_UNIT_PRICE);
noofunits=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
totalprice=resultset.getDouble(COLUMN_TOTAL_PRICE);
datetime=resultset.getString(COLUMN_DATE_TIME);

product=new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits, totalprice);
remainingInventory.add(product);
//System.out.println(product.toString());



}  


} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();
//conn.close();
//ResourceManager.closeConnection();
}

return remainingInventory;
}
    

}
