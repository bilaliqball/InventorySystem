package com.trango.app.model;



public class ItemInfo {
	


    private String saleId;
	private String productDescription;
	private String serialNumber;
        private double unitPrice;
	private int noOfUnits;


        
        
    

    public ItemInfo() {}

    public ItemInfo(String saleid,String productDetails, double price, int quantity) throws Exception {
	this.saleId=saleid;
        this.productDescription=productDetails;
        this.unitPrice=price;
	this.noOfUnits=quantity;

    }

	

        

        
        
	@Override
	public String toString() {
        String tab="\t";
        return
	this.productDescription+tab+
	this.serialNumber+tab+
        this.unitPrice+tab+
	this.noOfUnits+tab;
	
	}
	
	
}
