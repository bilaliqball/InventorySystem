package com.trango.application;



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
    public static final String TYPE_VARCHAR = " VARCHAR(45)";
    public static final String TYPE_DATETIME = " DATETIME";
    public static final String TYPE_JSON = " JSON";
    public static final String TYPE_DOUBLE = " DOUBLE";
    
 

    //Table names
    public static final String TABLE_INVENTORY = "inventory";
    public static final String TABLE_INVOICE = "invoice";
    public static final String TABLE_CUSTOMER = "customer";
    public static final String TABLE_SALE = "sale";
    public static final String TABLE_USER = "user";

    public static final String COLUMN_DATE_TIME="datetime";
    
        public static final String COLUMN_PRODUCT_ID="product_id";
        public static final String COLUMN_PRODUCT_NAME="product_name";
        public static final String COLUMN_PRODUCT_CATEGORY= "product_category";
        public static final String COLUMN_PRODUCT_TYPE= "product_type";
        public static final String COLUMN_PRODUCT_DETAILS= "product_details";
        public static final String COLUMN_SERIAL_NUMBER= "serial_number";
        public static final String COLUMN_UNIT_PRICE="unitP_price";
        public static final String COLUMN_NUMBER_OF_UNITS="no_of_units";
        public static final String COLUMN_TOTAL_PRICE= "total_price";
        
        
        public static final String COLUMN_CUSTOMER_ID="customer_id";
        public static final String COLUMN_CUSTOMER_NAME="customer_name";
        public static final String COLUMN_CUSTOMER_CONTACT ="customer_contact";
        public static final String COLUMN_CUSTOMER_TYPE="customer_type";
        public static final String COLUMN_CUSTOMER_ADDRESS= "customer_address";
        public static final String COLUMN_CUSTOMER_DETAILS= "customer_details";
	
       

        public static final String COLUMN_SALE_ID ="sale_id";
        public static final String COLUMN_INVOICE_NUMBER ="invoice_number";
     
        public static final String COLUMN_SUB_TOTAL= "sub_total";
        public static final String COLUMN_DISCOUNT_RATE="discount_rate";
        public static final String COLUMN_TAX_RATE= "tax_rate";
	
        
        	public static final String COLUMN_TOTAL_TAX="total_tax";
        	public static final String COLUMN_TOTAL_DISCOUNT= "total_discount";
        
        public static final String COLUMN_GROSS_TOTAL= "gross_total";
        public static final String COLUMN_DEPOSIT= "deposit";
        public static final String COLUMN_BALANCE= "balance";
        public static final String COLUMN_PRODUCT_COUNT ="product_count";
        public static final String COLUMN_PRODUCT_LIST="product_list";
    

   

        public static final String COLUMN_USER_ID= "id";
        public static final String COLUMN_USER_NAME= "name";
        public static final String COLUMN_GENDER= "gender";
        public static final String COLUMN_DESIGNATION= "designation";
        public static final String COLUMN_DEPARTMENT ="department";
        public static final String COLUMN_AGE="age";

 
    
        public static String CREATE_TABLE_USER_QUERY =
        		QUERY_CREATE + TABLE_USER + SEPARATOR_BRACKET_START+ 
        		COLUMN_USER_ID + TYPE_INT +" NOT NULL PRIMARY KEY " +SEPARATOR_COMMA+ 
        		COLUMN_USER_NAME + TYPE_TEXT + SEPARATOR_COMMA+ 
        		COLUMN_GENDER + TYPE_TEXT + SEPARATOR_COMMA+ 
        		COLUMN_DESIGNATION + TYPE_TEXT + SEPARATOR_COMMA+ 
        		COLUMN_DEPARTMENT + TYPE_TEXT + SEPARATOR_COMMA+         
        		COLUMN_AGE + TYPE_INT + SEPARATOR_COMMA+ 
        		COLUMN_DATE_TIME + TYPE_DATETIME + 
        		SEPARATOR_BRACKET_END;
        

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
COLUMN_CUSTOMER_DETAILS + TYPE_TEXT + SEPARATOR_COMMA+ 
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
COLUMN_CUSTOMER_DETAILS  +TYPE_TEXT + SEPARATOR_COMMA+ 
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
