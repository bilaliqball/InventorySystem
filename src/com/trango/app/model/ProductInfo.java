package com.trango.app.model;

import com.trango.app.util.Utils;
import javafx.beans.property.SimpleStringProperty;



public class ProductInfo {
	
        private String productId;
        private String productName;
        private String productCategory;
	private String productType;
	private String productDescription;
	private String serialNumber;
        private double unitPrice;
	private int noOfUnits;
        private double discount;
	private double totalPrice;
        private String datetime;
        
        
    

    public ProductInfo() {}

    public ProductInfo(String id, String name, String type, String category, double discount, double price, int quantity, double total) throws Exception {
        this.productId=Utils.getProductId(name);
        this.productName=name;
        this.productCategory=category;
	this.productType=type;
	this.productDescription=category+ " "+type+ " "+name;
	this.serialNumber=type+" "+id;
        this.unitPrice=price;
	this.noOfUnits=quantity;
        this.discount=discount;
	this.totalPrice= total;
        this.datetime=Utils.getCurrentDateTime();
    }

        public ProductInfo(String id, String name, String brand, int count) throws Exception {
        this.productId=id;
        this.productName=name;
        this.productCategory=brand;

	this.noOfUnits=count;

    }
    

	

	
        public String getProductId(){return this.productId;}
	public String getProductName(){return this.productName;}
        public String getProductCategory(){return this.productCategory;}
	public String getProductType(){return this.productType;}
	public String getProductDescription(){return this.productDescription;}
	public String getSerialNumber(){return this.serialNumber;}
        public double getUnitPrice(){return this.unitPrice;}
	public int getNoOfUnits(){return this.noOfUnits;}
        public double getDiscount(){return this.discount;}
	public double getTotalPrice(){return this.totalPrice;}
        public String getDatetime(){return this.datetime;}
        
        public void setProductId(String id){this.productId=id;}
        public void setProductName(String name){this.productName=name;}
        public void setProductCategory(String category){ this.productCategory=category;}
	public void setProductType(String type){ this.productType=type;}
	public void setProductDescription(String description){ this.productDescription=description;}
	public void setSerialNumber(String serial){ this.serialNumber=serial;}
        public void setUnitPrice(double uprice){ this.unitPrice=uprice;}
	public void setNoOfUnits(int quantity){ this.noOfUnits=quantity;}
        public void setDiscount(double discount){ this.discount=discount;}
	public void setTotalPrice(double tprice){ this.totalPrice=tprice;}
        public void setDatetime(String time){this.datetime=time;}
        
        

        
        public String getItemInfo() {
        String tab="\t";
        return
	this.productDescription+tab+
	this.serialNumber+tab+
        this.unitPrice+tab+
	this.noOfUnits+" , ";
	
	}
        
        
             public String getInventoryInfo() {
        String tab="\t";
        return
	this.productId+tab+
	this.productName+tab+
        this.productType+tab+
	this.noOfUnits+" , ";
	
	}
        
	@Override
	public String toString() {
        String tab="\t";
        return this.productId+tab+
        this.productName+tab+
        this.productCategory+tab+
	this.productType+tab+
	this.productDescription+tab+
	this.serialNumber+tab+
        this.unitPrice+tab+
	this.noOfUnits+tab+
	this.totalPrice+tab+
        this.datetime+"";
	}
	
	
}
