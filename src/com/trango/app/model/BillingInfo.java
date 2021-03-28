package com.trango.app.model;



public class BillingInfo {
	
	private String invoiceNumber;

	private String subTotalPrice;
        private String taxPrice;
	private String totalPrice;
	private String discountPrice;
        
        private String discountRate;
	private String taxRate;
        private String deposit;
        private String balance;
        
        
      
	      public  BillingInfo( 
         String subTotalPrice,
         String discountRate,
         String discountPrice,
         String taxRate,
         String taxPrice,
	 String totalPrice,
         String deposit,
         String balance){

          this.subTotalPrice=subTotalPrice;
          this.discountRate=discountRate;
          this.discountPrice=discountPrice;
          this.taxRate=taxRate;
          this.taxPrice=taxPrice;
	  this.totalPrice=totalPrice;
          this.deposit=deposit;
          this.balance=balance;
                
 
        }

   public  BillingInfo() {
        
    }
	

	public String getSubTotalPrice() {
		return subTotalPrice;
	}
	public void setSubTotalPrice(String subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discount) {
		this.discountRate = discount;
	}
	public String getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(String discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(String tax) {
		this.taxRate = tax;
	}
	public String getTaxPrice() {
		return taxPrice;
	}
	public void setTaxPrice(String taxPrice) {
		this.taxPrice = taxPrice;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
        
        
        public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
        
            public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
      
       
        
	
	@Override
	public String toString() {
		return "BillingBean [invoiceNumber=" + invoiceNumber + ", subTotalPrice=" + subTotalPrice
				+ ", discount=" + discountRate + ", discountPrice=" + discountPrice + ", tax=" + taxRate + ", taxPrice="
				+ taxPrice + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
}
