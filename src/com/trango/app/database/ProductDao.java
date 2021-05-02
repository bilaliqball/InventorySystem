
package com.trango.app.database;
import com.trango.app.model.CustomerInfo;
import com.trango.app.model.ItemInfo;
import com.trango.app.model.ProductInfo;
import com.trango.app.util.Utils;
import static com.trango.application.DBLiterals.*;
import com.trango.application.ResourceManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;








public class ProductDao  {



public boolean addProductIntoInventory(ProductInfo product) throws SQLException, ClassNotFoundException, Exception {
PreparedStatement statement=null;
String sql = 
"INSERT INTO inventory ("+
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?)"
        // + " ON DUPLICATE KEY UPDATE "
         +"ON CONFLICT(product_id) DO UPDATE SET "
        + "no_of_units=no_of_units+?, "
        + "datetime=?";  
 
statement = ResourceManager.getConnection().prepareStatement(sql);  
statement.setString(1, product.getProductId());
statement.setString(2, product.getProductName());
statement.setString(3, product.getProductType());
statement.setString(4, product.getProductCategory());
statement.setString(5, product.getProductDetails());
statement.setString(6, product.getSerialNumber());
statement.setDouble(7, product.getUnitPrice());
statement.setInt(8, product.getNoOfUnits());
statement.setDouble(9, product.getTotalPrice());
statement.setString(10, Utils.getCurrentDateTime());
statement.setInt(11, product.getNoOfUnits());
statement.setString(12, product.getDatetime());
statement.executeUpdate();System.out.println("Product added + ");
statement.close();
return false;}

public boolean removeProductFromInventory(CustomerInfo customer, ProductInfo product) throws SQLException, ClassNotFoundException, Exception {
PreparedStatement statement=null;
String invoiceNumber=Utils.getInvoiceNumber();
String customerId=customer.getCustmerId();
String productList="";

String addIntoSaleQuery = 
"INSERT INTO sale ("+
COLUMN_INVOICE_NUMBER + SEPARATOR_COMMA+ 
COLUMN_SALE_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
 
statement = ResourceManager.getConnection().prepareStatement(addIntoSaleQuery);  
statement.setString(1,invoiceNumber );
statement.setString(2, Utils.getSALEID());
statement.setString(3, product.getProductId());
statement.setString(4, product.getProductName());
statement.setString(5, product.getProductType());
statement.setString(6, product.getProductCategory());
statement.setString(7, product.getProductDetails());
statement.setString(8, "Customer Details");
statement.setString(9, product.getSerialNumber());
statement.setDouble(10, product.getUnitPrice());
statement.setInt(11, product.getNoOfUnits());
statement.setDouble(12, product.getTotalPrice());
statement.setString(13, Utils.getCurrentDateTime());
int sold=statement.executeUpdate();

if(sold==1){

System.out.println("Product Sold -");
}


String sql = 
"INSERT INTO inventory ("+
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?)"
        // + " ON DUPLICATE KEY UPDATE "
         +"ON CONFLICT(product_id) DO UPDATE SET "
        + "no_of_units=no_of_units-?, "
        + "datetime=?";  
 
statement = ResourceManager.getConnection().prepareStatement(sql);  
statement.setString(1, product.getProductId());
statement.setString(2, product.getProductName());
statement.setString(3, product.getProductType());
statement.setString(4, product.getProductCategory());
statement.setString(5, product.getProductDetails());
statement.setString(6, product.getSerialNumber());
statement.setDouble(7, product.getUnitPrice());
statement.setInt(8, 0);
statement.setDouble(9, product.getTotalPrice());
statement.setString(10, Utils.getCurrentDateTime());
statement.setInt(11, product.getNoOfUnits());
statement.setString(12, product.getDatetime());
statement.executeUpdate();System.out.println("Product removed  from inventory - ");
statement.close();




String addIntoInvoiceQuery = 
"INSERT INTO invoice ("+
COLUMN_INVOICE_NUMBER  + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_ID  + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_TYPE  + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_DETAILS  + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS  + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_COUNT  + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE  + SEPARATOR_COMMA+ 
COLUMN_TAX_RATE  + SEPARATOR_COMMA+ 
COLUMN_DISCOUNT_RATE  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_TAX  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_DISCOUNT + SEPARATOR_COMMA+ 
COLUMN_GROSS_TOTAL  + SEPARATOR_COMMA+     
COLUMN_DEPOSIT  + SEPARATOR_COMMA+  
COLUMN_BALANCE  + SEPARATOR_COMMA+   
COLUMN_PRODUCT_LIST  + SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         
 
productList=product.getItemInfo()+ " \n"+product.getItemInfo();

statement = ResourceManager.getConnection().prepareStatement(addIntoInvoiceQuery);  
statement.setString(1, invoiceNumber);
statement.setString(2, customerId);
statement.setString(3, customer.getCustomerType());
statement.setString(4, customer.getCustomerDetail());
statement.setString(5, product.getProductDetails());
statement.setInt(6, 1);//productCount
statement.setInt(7, 1);//itemCount
statement.setDouble(8, product.getTotalPrice());
statement.setDouble(9, 0);//taxRate
statement.setDouble(10, 0);//discoubtRate
statement.setDouble(11, 0);//totaltax
statement.setDouble(12, 0);//totalDiscount
statement.setDouble(13, product.getTotalPrice());//grossTotal
statement.setDouble(14, product.getTotalPrice());//deposit
statement.setDouble(15, 0);//balance
statement.setString(16, productList);//productlist
statement.setString(17, Utils.getCurrentDateTime());//datetime


statement.executeUpdate();System.out.println("invoice added + ");
statement.close();


return false;}


public boolean addProductIntoInventory(List<ProductInfo> products) throws SQLException, ClassNotFoundException, Exception {
PreparedStatement statement;
String addInventoryQuery = 
"INSERT INTO inventory ("+
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?)"
 // + " ON DUPLICATE KEY UPDATE "
+"ON CONFLICT(product_id) DO UPDATE SET "
        + "no_of_units=no_of_units+?, "
        + "datetime=?";  


statement = ResourceManager.getConnection().prepareStatement(addInventoryQuery);  
System.out.println(statement);
for(ProductInfo product:products){
statement.setString(1, product.getProductId());
statement.setString(2, product.getProductName());
statement.setString(3, product.getProductType());
statement.setString(4, product.getProductCategory());
statement.setString(5, product.getProductDetails());
statement.setString(6, product.getSerialNumber());
statement.setDouble(7, product.getUnitPrice());
statement.setInt(8, product.getNoOfUnits());
statement.setDouble(9, product.getTotalPrice());
statement.setString(10, Utils.getCurrentDateTime());
statement.setInt(11, product.getNoOfUnits());
statement.setString(12, product.getDatetime());

statement.addBatch();
System.out.println("Row Inserted "+ product.getProductId());

int rowsInserted=statement.executeBatch()[0]; 

if(rowsInserted>0){
System.out.println("Row Inserted "+ product.getProductId());
}


}









//statement.close();

return false;}


public boolean removeProductFromInventory(CustomerInfo customer, List<ProductInfo> products) throws SQLException, ClassNotFoundException, Exception {
PreparedStatement saleStatement=null;
PreparedStatement inventoryStatement=null;
PreparedStatement invoiceStatement=null;



String invoiceNumber=Utils.getInvoiceNumber();
String customerId=customer.getCustmerId();

List<ItemInfo> itemSoldList=new ArrayList<>();

StringBuilder productList= new StringBuilder();

String saleId="";


int saleAddes=0;

int inventoryUpdated=0;


double subTotal=0;
int items=0;


for(ProductInfo product:products){

String addIntoSaleQuery = 
"INSERT INTO sale ("+
COLUMN_INVOICE_NUMBER + SEPARATOR_COMMA+ 
COLUMN_SALE_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
 
saleId=Utils.getSALEID();
saleStatement = ResourceManager.getConnection().prepareStatement(addIntoSaleQuery);  
saleStatement.setString(1,invoiceNumber );
saleStatement.setString(2, saleId);
saleStatement.setString(3, product.getProductId());
saleStatement.setString(4, product.getProductName());
saleStatement.setString(5, product.getProductType());
saleStatement.setString(6, product.getProductCategory());
saleStatement.setString(7, product.getProductDetails());
saleStatement.setString(8, "Customer Detaills");
saleStatement.setString(9, product.getSerialNumber());
saleStatement.setDouble(10, product.getUnitPrice());
saleStatement.setInt(11, product.getNoOfUnits());
saleStatement.setDouble(12, product.getTotalPrice());
saleStatement.setString(13, Utils.getCurrentDateTime());
saleStatement.addBatch();



String updateInventoryQuery = 
"INSERT INTO inventory ("+
COLUMN_PRODUCT_ID + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE +  SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS +  SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER +SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE +  SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?)"
        // + " ON DUPLICATE KEY UPDATE "
         +"ON CONFLICT(product_id) DO UPDATE SET "
        + "no_Of_units=no_of_units-?, "
        + "datetime=?";  
 
inventoryStatement = ResourceManager.getConnection().prepareStatement(updateInventoryQuery);  
inventoryStatement.setString(1, product.getProductId());
inventoryStatement.setString(2, product.getProductName());
inventoryStatement.setString(3, product.getProductType());
inventoryStatement.setString(4, product.getProductCategory());
inventoryStatement.setString(5, product.getProductDetails());
inventoryStatement.setString(6, product.getSerialNumber());
inventoryStatement.setDouble(7, product.getUnitPrice());
inventoryStatement.setInt(8, 0);
inventoryStatement.setDouble(9, product.getTotalPrice());
inventoryStatement.setString(10, Utils.getCurrentDateTime());
inventoryStatement.setInt(11, product.getNoOfUnits());
inventoryStatement.setString(12, product.getDatetime());
inventoryStatement.addBatch();


try{

saleAddes=saleStatement.executeBatch()[0]; 
inventoryUpdated=inventoryStatement.executeBatch()[0]; 


System.out.println("saleAddes Sold   from       inventory -"+saleAddes );
System.out.println("inventoryUpdated count  updated in inventory - "+inventoryUpdated);
System.out.println("Product Sold   from       inventory -"+saleId );
System.out.println("Product count  updated in inventory - "+product.getSerialNumber());

}catch(SQLException e ){e.printStackTrace();}


itemSoldList.add(new ItemInfo(
        saleId,
        product.getProductDetails(),
        product.getUnitPrice(),
        product.getNoOfUnits()));

items+=product.getNoOfUnits();
subTotal+=product.getTotalPrice();
productList.append(product.getItemInfo());



}




String addIntoInvoiceQuery = 
"INSERT INTO invoice ("+
COLUMN_INVOICE_NUMBER  + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_ID  + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_DETAILS  + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS  + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_COUNT  + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE  + SEPARATOR_COMMA+ 
COLUMN_TAX_RATE  + SEPARATOR_COMMA+ 
COLUMN_DISCOUNT_RATE  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_TAX  + SEPARATOR_COMMA+ 
COLUMN_TOTAL_DISCOUNT + SEPARATOR_COMMA+ 
COLUMN_GROSS_TOTAL  + SEPARATOR_COMMA+     
COLUMN_DEPOSIT  + SEPARATOR_COMMA+  
COLUMN_BALANCE  + SEPARATOR_COMMA+   
COLUMN_PRODUCT_LIST  + SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+SEPARATOR_BRACKET_END+
"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         
 


invoiceStatement = ResourceManager.getConnection().prepareStatement(addIntoInvoiceQuery);  
invoiceStatement.setString(1, invoiceNumber);//invoiceNumber
invoiceStatement.setString(2, customerId);//customerid
invoiceStatement.setString(3, customer.getCustomerDetail());//customerDetails
invoiceStatement.setString(4, "");//productdetails
invoiceStatement.setInt(5, products.size());//productCount
invoiceStatement.setInt(6, items);//itemCount
invoiceStatement.setDouble(7, subTotal);//subTotal
invoiceStatement.setDouble(8, 0);//taxRate
invoiceStatement.setDouble(9, 0);//discoubtRate
invoiceStatement.setDouble(10, 0);//totaltax
invoiceStatement.setDouble(11, 0);//totalDiscount
invoiceStatement.setDouble(12, subTotal);//grossTotal
invoiceStatement.setDouble(13, subTotal);//deposit
invoiceStatement.setDouble(14, 0);//balance
invoiceStatement.setString(15, productList.toString());//productlist
invoiceStatement.setString(16, Utils.getCurrentDateTime());//datetime
invoiceStatement.executeUpdate();System.out.println("invoice added + ");

invoiceStatement.close();




return true;}








}

