package com.trango.app.model;

import com.trango.app.util.Utils;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;



public class SaleInfo {
	
    private String productId;
    private String serialNumber;
    private String invoiceNumber;
    private String datetime;
    
    private String customerType;
    private String customerDetails;
    private String productDetails;
    
    private int productCount;
    private double unitPrice;
    private int noOfUnits;
    private double totalPrice;
    
    private double discount;
    private double grossTotal;
    private double deposit;
    private double balance;

        
    

    public SaleInfo() {}

public SaleInfo(String invoice, String datetime,String customerdetails, String productdetails, int productcount, int units, double subtotal,double totaldiscount, double gross, double totaldeposit, double remainingbalance) throws Exception {
this.invoiceNumber=invoice;
this.customerDetails=customerdetails;
this.productDetails="Here";
this.productCount=productcount;
this.noOfUnits=units;
this.totalPrice=subtotal;
this.discount=totaldiscount;
this.grossTotal=gross;
this.deposit=totaldeposit;
this.balance=remainingbalance;
this.datetime=datetime;
    }

    
public SaleInfo(String invoice, String datetime,String customerdetails, String productdetails, int units,double unitprice, double subtotal) throws Exception {
this.invoiceNumber=invoice;
this.customerDetails=customerdetails;
this.productDetails=productdetails;
this.noOfUnits=units;
this.unitPrice=unitprice;
this.totalPrice=subtotal;
this.datetime=datetime;
    }
    

	

        public String getInvoiceNumber() {return invoiceNumber;}
        public String getProductId(){return this.productId;}
        public String getSerialNumber(){return this.serialNumber;}
        public String getDatetime(){return this.datetime;}
	
        public String getCustomerDetails(){return this.customerDetails;}
	public String getProductDetails(){return this.productDetails;}
        public String getCustomerType(){return this.customerType;}
	
        public int getProductCount(){return this.productCount;}
        public double getUnitPrice(){return this.unitPrice;}
	public int getNoOfUnits(){return this.noOfUnits;}
	public double getTotalPrice(){return this.totalPrice;}
        
        public double getDiscount(){return this.discount;}
        public double getGrossTotal(){return this.grossTotal;}
        public double getDeposit(){return this.deposit;} 
        public double getBalance(){return this.balance;}
                 
                 
        
        public void setInvoiceNumber(String invoice) { invoiceNumber=invoice;}
        public void setProductId(String productid){ this.productId=productid;}
        public void setSerialNumber(String serial){ this.serialNumber=serial;}
        public void setDatetime(String datetime){ this.datetime=datetime;}
	
        public void setCustomerDetails(String customerdetails){ this.customerDetails=customerdetails;}
	public void setProductDetails(String productdetails){ this.productDetails=productdetails;}
        public void setCustomerType(String customertype){ this.customerType=customertype;}
	
        public void setProductCount(int productcount){ this.productCount=productcount;}
        public void setUnitPrice(int unitprice){ this.unitPrice=unitprice;}
	public void setNoOfUnits(int units){ this.noOfUnits=units;}
	public void setTotalPrice(double subtotal){ this.totalPrice=subtotal;}
        
        public void setDiscount(double discount){ this.discount=discount;}
        public void setGrossTotal(double gross){ this.grossTotal=gross;}
        public void setDeposit(double cash){ this.deposit=cash;} 
        public void setBalance(double balance){ this.balance=balance;}
        
      
	

   

        
    
        
	@Override
	public String toString() {
        String tab="\t";
        return this.invoiceNumber+tab+
        this.productDetails+tab+
        this.customerDetails+tab+
        this.unitPrice+tab+
        this.noOfUnits+tab+
        this.totalPrice+tab+
        this.datetime+"";
	}
	
	
}
