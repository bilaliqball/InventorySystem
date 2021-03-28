package com.trango.app.model;

import com.trango.app.util.Utils;



public class CustomerInfo {
	
	private String invoiceNumber;
        private String customerId;
        private String customerType;
	private String customerName;
	private String customerContact;
	private String customerAddress;
        private String customerDetail;
	
        
        public CustomerInfo(){}
        
        public CustomerInfo(String customerid,String customername,String customertype, String customercontact, String customeraddress){
        this.customerId=customerid;
	this.customerName=customername;
        this.customerType=customertype;
	this.customerContact=customercontact;
	this.customerAddress=customeraddress;
	this.customerDetail=customertype+ " "+customername+ " "+ customeraddress;
        }
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
        
        public String getCustmerId() {
		return customerId;
	}
	public void setCustomerId(String cid) {
		this.customerId = cid;
	}
        
        
        public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String ctype) {
		this.customerType = ctype;
	}
        
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = Utils.toCamelCase(customerName);
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = Utils.toCamelCase(customerAddress);
	}
        
        
        public String getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(String customerDetail) {
		this.customerDetail = Utils.toCamelCase(customerDetail);
	}
  
	@Override
	public String toString() {
		return "BillingBean [invoiceNumber=" + invoiceNumber + ", customerName=" + customerName + ", customerContact="
				+ customerContact + ", customerAddress=" + customerAddress+ "]";
	}
	
	
	
}
