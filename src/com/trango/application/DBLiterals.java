package com.trango.application;

import com.trango.app.model.ProductInfo;

import static com.trango.application.DBLiterals.COLUMN_BALANCE;
import static com.trango.application.DBLiterals.COLUMN_CUSTOMER_DETAIL;
import static com.trango.application.DBLiterals.COLUMN_CUSTOMER_ID;
import static com.trango.application.DBLiterals.COLUMN_DATE_TIME;
import static com.trango.application.DBLiterals.COLUMN_DEPOSIT;
import static com.trango.application.DBLiterals.COLUMN_DISCOUNT_RATE;
import static com.trango.application.DBLiterals.COLUMN_GROSS_TOTAL;
import static com.trango.application.DBLiterals.COLUMN_INVOICE_NUMBER;
import static com.trango.application.DBLiterals.COLUMN_NUMBER_OF_UNITS;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_CATEGORY;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_COUNT;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_DETAILS;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_ID;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_LIST;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_NAME;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_TYPE;
import static com.trango.application.DBLiterals.COLUMN_SALE_ID;
import static com.trango.application.DBLiterals.COLUMN_SERIAL_NUMBER;
import static com.trango.application.DBLiterals.COLUMN_TAX_RATE;
import static com.trango.application.DBLiterals.COLUMN_TOTAL_DISCOUNT;
import static com.trango.application.DBLiterals.COLUMN_TOTAL_PRICE;
import static com.trango.application.DBLiterals.COLUMN_TOTAL_TAX;
import static com.trango.application.DBLiterals.COLUMN_UNIT_PRICE;
import static com.trango.application.DBLiterals.SEPARATOR_BRACKET_END;
import static com.trango.application.DBLiterals.SEPARATOR_COMMA;

import java.util.List;

public class DBLiterals {
    //Database info
    public static final String DATABASE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;




    //for query creation
    public static final String QUERY_CREATE = "CREATE TABLE ";
    public static final String SEPARATOR_COMMA = ", ";
    public static final String SEPARATOR_BRACKET_START = "( ";
    public static final String SEPARATOR_BRACKET_END = " )";
    public static final String DEFAULT_ZERO = " DEFAULT 0";

    //Datatypes
    public static final String TYPE_INT = " INTEGER";
    public static final String TYPE_TEXT = " TEXT";
    public static final String TYPE_DATETIME = " DATETIME";
    public static final String TYPE_JSON = " JSON";
    public static final String TYPE_DOUBLE = " DOUBLE";
    
        public static final String CUSTOMER_TYPE_CLIENT = "Customer";
        public static final String CUSTOMER_TYPE_DEALER = "Dealer";

    //Table names
    public static final String TABLE_INVENTORY = "INVENTORY";
    public static final String TABLE_INVOICE = "INVOICE";
    public static final String TABLE_CUSTOMER = "CUSTOMER";
    public static final String TABLE_SALE = "SALE";

    public static final String COLUMN_DATE_TIME="dateTime";
    
        public static final String COLUMN_PRODUCT_ID="productId";
        public static final String COLUMN_PRODUCT_NAME="productName";
        public static final String COLUMN_PRODUCT_CATEGORY= "productCategory";
        public static final String COLUMN_PRODUCT_TYPE= "productType";
        public static final String COLUMN_PRODUCT_DETAILS= "productDetails";
        public static final String COLUMN_SERIAL_NUMBER= "serialNumber";
        public static final String COLUMN_UNIT_PRICE="unitPrice";
        public static final String COLUMN_NUMBER_OF_UNITS="noOfUnits";
        public static final String COLUMN_TOTAL_PRICE= "totalPrice";
        
        
        public static final String COLUMN_CUSTOMER_ID="customerId";
        public static final String COLUMN_CUSTOMER_NAME="customerName";
        public static final String COLUMN_CUSTOMER_CONTACT ="customerContact";
        public static final String COLUMN_CUSTOMER_TYPE="customerType";
        public static final String COLUMN_CUSTOMER_ADDRESS= "customerAddress";
        public static final String COLUMN_CUSTOMER_DETAIL= "customerDetails";
	
       

        public static final String COLUMN_SALE_ID ="saleId";
        public static final String COLUMN_INVOICE_NUMBER ="invoiceNumber";
     
        public static final String COLUMN_SUB_TOTAL= "subTotal";
        public static final String COLUMN_DISCOUNT_RATE="discountRate";
        public static final String COLUMN_TAX_RATE= "taxRate";
	
        
        	public static final String COLUMN_TOTAL_TAX="totalTax";
        	public static final String COLUMN_TOTAL_DISCOUNT= "totalDiscount";
        
        public static final String COLUMN_GROSS_TOTAL= "grossTotal";
        public static final String COLUMN_DEPOSIT= "deposit";
        public static final String COLUMN_BALANCE= "balance";
        public static final String COLUMN_PRODUCT_COUNT ="productCount";
        public static final String COLUMN_PRODUCT_LIST="productList";
    



 
    

public static String CREATE_TABLE_INVENTORY_QUERY =
QUERY_CREATE + TABLE_INVENTORY + SEPARATOR_BRACKET_START+ 
COLUMN_PRODUCT_ID + TYPE_TEXT +" NOT NULL PRIMARY KEY " +SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER + TYPE_TEXT + SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE + TYPE_DOUBLE + SEPARATOR_COMMA+ 
COLUMN_DATE_TIME + TYPE_DATETIME + 
SEPARATOR_BRACKET_END;


public static String CREATE_TABLE_SALE_QUERY =
QUERY_CREATE + TABLE_SALE + SEPARATOR_BRACKET_START+ 
COLUMN_INVOICE_NUMBER + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_SALE_ID +TYPE_TEXT+ SEPARATOR_COMMA+ 
COLUMN_PRODUCT_ID + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_NAME + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_TYPE + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_CATEGORY + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_SERIAL_NUMBER + TYPE_TEXT + SEPARATOR_COMMA+         
COLUMN_UNIT_PRICE + TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS + TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE + TYPE_DOUBLE + SEPARATOR_COMMA+ 
COLUMN_DATE_TIME + TYPE_DATETIME + 





SEPARATOR_BRACKET_END;




public static String CREATE_TABLE_CUSTOMER_QUERY =
QUERY_CREATE + TABLE_CUSTOMER + SEPARATOR_BRACKET_START+ 
COLUMN_CUSTOMER_ID + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_NAME + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_TYPE + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_CONTACT + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_ADDRESS + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_DATE_TIME + TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_DISCOUNT_RATE + TYPE_TEXT + 
SEPARATOR_BRACKET_END;


        
public static String CREATE_TABLE_INVOICE_QUERY =
QUERY_CREATE + TABLE_INVOICE + SEPARATOR_BRACKET_START+ 
COLUMN_INVOICE_NUMBER   + TYPE_TEXT +SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_ID  + TYPE_TEXT +SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_TYPE  +TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_CUSTOMER_DETAIL  +TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_DETAILS  +TYPE_TEXT + SEPARATOR_COMMA+ 
COLUMN_PRODUCT_COUNT  +TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_NUMBER_OF_UNITS  +TYPE_INT + SEPARATOR_COMMA+ 
COLUMN_TOTAL_PRICE  + TYPE_DOUBLE+SEPARATOR_COMMA+ 
COLUMN_TAX_RATE  + TYPE_DOUBLE+SEPARATOR_COMMA+ 
COLUMN_DISCOUNT_RATE  +TYPE_DOUBLE+ SEPARATOR_COMMA+ 
COLUMN_TOTAL_TAX  +TYPE_DOUBLE+ SEPARATOR_COMMA+ 
COLUMN_TOTAL_DISCOUNT + TYPE_DOUBLE+SEPARATOR_COMMA+ 
COLUMN_GROSS_TOTAL  +TYPE_DOUBLE+ SEPARATOR_COMMA+     
COLUMN_DEPOSIT  +TYPE_DOUBLE+ SEPARATOR_COMMA+  
COLUMN_BALANCE  +TYPE_DOUBLE+ SEPARATOR_COMMA+   
COLUMN_PRODUCT_LIST  +TYPE_TEXT+ SEPARATOR_COMMA+ 
COLUMN_DATE_TIME+TYPE_DATETIME+
SEPARATOR_BRACKET_END; 
    

    
    
    
 
    
    
  


    
}
