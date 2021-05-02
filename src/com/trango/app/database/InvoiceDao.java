
package com.trango.app.database;
import com.trango.app.model.SaleInfo;
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
	     String invoicenumber;
	     String datetime;
	     String customerdetails;
	     String productdetails;
	     double subtotal;
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;
	     int productcount;
	     int units;


	     String sql = "SELECT * FROM INVOICE";  
	



	List<SaleInfo> salelist=new ArrayList<>();
	Statement statement=null;
	try {  

	statement  = ResourceManager.getConnection().createStatement();  
	ResultSet resultset    = statement.executeQuery(sql);  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAILS);
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
	} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}


	public List<SaleInfo> getInvoiceListCustomerDetails(String keyword) throws ClassNotFoundException, SQLException, Exception{
	     String invoicenumber;
	     String datetime;
	     String customerdetails;
	     String productdetails;
	     double subtotal;
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;
	     int productcount;
	     int units;


	String sql = "SELECT * FROM INVOICE where ( customer_Details like ?  or  customer_type like ?)";  
	



	List<SaleInfo> salelist=new ArrayList<>();
	PreparedStatement statement=null;
	try {  

	statement  = ResourceManager.getConnection().prepareStatement(sql);  
	statement.setString(1,"%"+keyword+"%");
	statement.setString(2,"%"+keyword+"%");

	ResultSet resultset    = statement.executeQuery();  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAILS);
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
	} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}

	public List<SaleInfo> getInvoiceListProductDetails(String keyword) throws ClassNotFoundException, SQLException, Exception{
	     String invoicenumber;
	     String datetime;
	     String customerdetails;
	     String productdetails;
	     double subtotal;
	     double discount;
	     double grosstotal;
	     double deposit;
	     double balance;
	     int productcount;
	     int units;


	String sql = "SELECT * FROM INVOICE where ( product_list like ?)";  




	List<SaleInfo> salelist=new ArrayList<>();
	PreparedStatement statement=null;
	try {  

	statement  = ResourceManager.getConnection().prepareStatement(sql);  
	statement.setString(1,"%"+keyword+"%");
	ResultSet resultset    = statement.executeQuery();  
	while (resultset.next()) {  
	invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
	customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAILS);
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
	} 
	catch (SQLException e) {  System.out.println(e.getMessage());  }  
	finally {statement.close();}

	return salelist;
	}


	public List<SaleInfo> getCustomerSaleList() throws ClassNotFoundException, SQLException, Exception{
     String invoicenumber;
     String datetime;
     String customerdetails;
     String productdetails;
     double unitprice;
     int units;
     double subtotal;

     String sql = "SELECT * FROM INVOICE";  





List<SaleInfo> salelist=new ArrayList<>();
Statement statement=null;
try {  

statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  
while (resultset.next()) {  
invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAILS);
productdetails=resultset.getString(COLUMN_PRODUCT_LIST);

units=resultset.getInt(COLUMN_NUMBER_OF_UNITS);

subtotal=resultset.getDouble(COLUMN_TOTAL_PRICE);
unitprice=subtotal/units;

datetime=resultset.getString(COLUMN_DATE_TIME);

salelist.add(new SaleInfo(invoicenumber,  datetime, customerdetails,  productdetails,  units, unitprice, subtotal));


}  
} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();}

return salelist;
}


	public List<SaleInfo> getDealerSaleList() throws ClassNotFoundException, SQLException, Exception{
     String invoicenumber;
     String datetime;
     String customerdetails;
     String productdetails;
     int productcount;

     int units;
     double subtotal;
    
     double discount;
     double grosstotal;
     double deposit;
     double balance;


String sql = "SELECT * FROM INVOICE";  





List<SaleInfo> salelist=new ArrayList<>();
Statement statement=null;
try {  

statement  = ResourceManager.getConnection().createStatement();  
ResultSet resultset    = statement.executeQuery(sql);  
while (resultset.next()) {  
invoicenumber=resultset.getString(COLUMN_INVOICE_NUMBER);
customerdetails=resultset.getString(COLUMN_CUSTOMER_DETAILS);
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
} 
catch (SQLException e) {  System.out.println(e.getMessage());  }  
finally {statement.close();}

return salelist;
}








}

