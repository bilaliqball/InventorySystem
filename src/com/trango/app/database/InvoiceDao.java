
package com.trango.app.database;
import com.trango.app.model.BillingInfo;
import com.trango.app.model.CustomerInfo;
import com.trango.app.model.ProductInfo;
import com.trango.app.model.SaleInfo;
import com.trango.app.util.Utils;
import static com.trango.application.DBLiterals.*;
import com.trango.application.ResourceManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;








public class InvoiceDao  {

 
    







	public List<SaleInfo> getAllInvoiceList() throws ClassNotFoundException, SQLException, Exception{
	     String productid;
	     String serialnumber;
	     String invoicenumber;
	     String datetime;
	    
	     String customertype;
	     String customerdetails;
	     String productdetails;
	    
	     int productcount;
	     double unitprice;
	     int units;
	     double subtotal;
	    
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;


	String sql = "SELECT * FROM INVOICE";  
	String row=""; String tab="\t";



	List<SaleInfo> salelist=new ArrayList<>();
	Statement statement=null;
	try {  

	statement  = ResourceManager.getConnection().createStatement();  
	ResultSet resultset    = statement.executeQuery(sql);  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAIL);
	productcount=resultset.getInt(COLUMN_PRODUCT_COUNT);
	units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
	subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
	discount=resultset.getDouble(COLUMN_DISCOUNT_RATE);
	grosstotal=resultset.getDouble(COLUMN_GROSS_TOTAL);
	deposit=resultset.getDouble(COLUMN_DEPOSIT);
	balance=resultset.getDouble(COLUMN_BALANCE);
	productdetails=resultset.getString(COLUMN_PRODUCT_LIST);
	datetime=resultset.getString(COLUMN_DATE_TIME);
	salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails, productdetails ,  productcount, units,subtotal, discount, grosstotal,deposit,balance));


	}  
	System.out.println(row);} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}


	public List<SaleInfo> getInvoiceListCustomer(String keyword) throws ClassNotFoundException, SQLException, Exception{
	     String productid;
	     String serialnumber;
	     String invoicenumber;
	     String datetime;
	    
	     String customertype;
	     String customerdetails;
	     String productdetails;
	    
	     int productcount;
	     double unitprice;
	     int units;
	     double subtotal;
	    
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;


	String sql = "SELECT * FROM INVOICE where ( customerDetails like ?  or  customerType like ?)";  
	String row=""; String tab="\t";



	List<SaleInfo> salelist=new ArrayList<>();
	PreparedStatement statement=null;
	try {  

	statement  = ResourceManager.getConnection().prepareStatement(sql);  
	statement.setString(1,"%"+keyword+"%");
	statement.setString(2,"%"+keyword+"%");

	ResultSet resultset    = statement.executeQuery();  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAIL);
	productcount=resultset.getInt(COLUMN_PRODUCT_COUNT);
	units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
	subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
	discount=resultset.getDouble(COLUMN_DISCOUNT_RATE);
	grosstotal=resultset.getDouble(COLUMN_GROSS_TOTAL);
	deposit=resultset.getDouble(COLUMN_DEPOSIT);
	balance=resultset.getDouble(COLUMN_BALANCE);
	productdetails=resultset.getString(COLUMN_PRODUCT_LIST);
	datetime=resultset.getString(COLUMN_DATE_TIME);
	salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails, productdetails ,  productcount, units,subtotal, discount, grosstotal,deposit,balance));


	}  
	System.out.println(row);} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}

	public List<SaleInfo> getInvoiceListProduct(String keyword) throws ClassNotFoundException, SQLException, Exception{
	     String productid;
	     String serialnumber;
	     String invoicenumber;
	     String datetime;
	    
	     String customertype;
	     String customerdetails;
	     String productdetails;
	    
	     int productcount;
	     double unitprice;
	     int units;
	     double subtotal;
	    
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;


	String sql = "SELECT * FROM INVOICE where ( productList like ?)";  
	String row=""; String tab="\t";



	List<SaleInfo> salelist=new ArrayList<>();
	PreparedStatement statement=null;
	try {  

	statement  = ResourceManager.getConnection().prepareStatement(sql);  
	statement.setString(1,"%"+keyword+"%");
	ResultSet resultset    = statement.executeQuery();  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAIL);
	productcount=resultset.getInt(COLUMN_PRODUCT_COUNT);
	units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
	subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
	discount=resultset.getDouble(COLUMN_DISCOUNT_RATE);
	grosstotal=resultset.getDouble(COLUMN_GROSS_TOTAL);
	deposit=resultset.getDouble(COLUMN_DEPOSIT);
	balance=resultset.getDouble(COLUMN_BALANCE);
	productdetails=resultset.getString(COLUMN_PRODUCT_LIST);
	datetime=resultset.getString(COLUMN_DATE_TIME);
	salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails, productdetails ,  productcount, units,subtotal, discount, grosstotal,deposit,balance));


	}  
	System.out.println(row);} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}


public List<SaleInfo> getCustomerSaleList() throws ClassNotFoundException, SQLException, Exception{
     String productid;
     String serialnumber;
     String invoicenumber;
     String datetime;
    
     String customertype;
     String customerdetails;
     String productdetails;
    

     double unitprice;
     int units;
     double subtotal;
    
 


String sql = "SELECT * FROM INVOICE";  
String row=""; String tab="\t";




List<SaleInfo> salelist=new ArrayList<>();
Statement statement=null;
try {  

statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  
while (resultset.next()) {  
invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAIL);
productdetails=resultset.getString(COLUMN_PRODUCT_LIST);

units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);

subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
unitprice=subtotal/units;

datetime=resultset.getString(COLUMN_DATE_TIME);

salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails,  productdetails,  units, unitprice, subtotal));


}  
System.out.println(row);} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();}

return salelist;
}




public List<SaleInfo> getDealerSaleList() throws ClassNotFoundException, SQLException, Exception{
     String productid;
     String serialnumber;
     String invoicenumber;
     String datetime;
    
     String customertype;
     String customerdetails;
     String productdetails;
    
     int productcount;
     double unitprice;
     int units;
     double subtotal;
    
     double discount;
     double grosstotal;
     double deposit;
     double balance;


String sql = "SELECT * FROM INVOICE";  
String row=""; String tab="\t";

String title=
"InvoiceNo."+tab+
"CustomerDetails"+tab+
"Product Count"+tab+
"No of Units"+tab+
"SubTotal"+tab+
"DiscountPrice"+tab+
"GrossTotal"+tab+
"Deposit"+tab+
"Balance"+tab+
"datetime"+tab+
"Product\n";


List<SaleInfo> salelist=new ArrayList<>();
Statement statement=null;
try {  

statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  
while (resultset.next()) {  
invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAIL);
productcount=resultset.getInt(COLUMN_PRODUCT_COUNT);
units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);
subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
discount=resultset.getDouble(COLUMN_DISCOUNT_RATE);
grosstotal=resultset.getDouble(COLUMN_GROSS_TOTAL);
deposit=resultset.getDouble(COLUMN_DEPOSIT);
balance=resultset.getDouble(COLUMN_BALANCE);
productdetails=resultset.getString(COLUMN_PRODUCT_LIST);
datetime=resultset.getString(COLUMN_DATE_TIME);

salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails, productdetails ,  productcount, units,subtotal, discount, grosstotal,deposit,balance));

System.out.println(productdetails);

}  
System.out.println(row);} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();}

return salelist;
}








}

