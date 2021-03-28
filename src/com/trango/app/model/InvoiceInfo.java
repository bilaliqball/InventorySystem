package com.trango.app.model;

import com.trango.app.util.Utils;
import static com.trango.application.DBLiterals.CUSTOMER_TYPE_DEALER;
import java.util.List;



public class InvoiceInfo {
	
	private String invoiceNumber;
        private String datetime;
        private CustomerInfo customer;
        private BillingInfo bill;
	private List<ProductInfo> products;
        
        
        public InvoiceInfo(
        CustomerInfo customer,
        BillingInfo bill,
	List<ProductInfo> products
        ){
        this.invoiceNumber=Utils.generateRandomString();
        this.datetime=Utils.getCurrentDateTime();
        this.customer=customer;
        this.bill=bill;
        this.products=products;
        }
        
        public InvoiceInfo(){}
	
	public String getInvoiceNumber() {return invoiceNumber;}
	public void setInvoiceNumber(String invoiceNumber) {this.invoiceNumber = invoiceNumber;}

        public void setDatetime(String time){this.datetime=time;}
        public String getDatetime(){return this.datetime;}

       public BillingInfo getBill(){return bill;}
          
          
         public void setBill( 
         String subTotalPrice,
         String discountRate,
         String discountPrice,
         String taxRate,
         String taxPrice,
	 String totalPrice,
         String deposit,
         String balance){

             bill=new BillingInfo();
        bill.setSubTotalPrice(subTotalPrice);
        bill.setDiscountRate(discountRate);
        bill.setDiscountPrice(discountPrice);
        bill.setTaxRate(taxRate);
        bill.setTaxPrice(taxPrice);
        bill.setTotalPrice(totalPrice);
        bill.setTotalPrice(deposit);
        bill.setTotalPrice(balance);
                
 
        }
        
        public CustomerInfo getCustomer(){return customer;}
        
        public void setCustomer(String customername, String customercontact, String customeraddress){
        customer=new CustomerInfo();
        customer.setCustomerId(customercontact);
        customer.setCustomerName(customername);
        customer.setCustomerType(CUSTOMER_TYPE_DEALER);
        customer.setCustomerContact(customercontact);
        customer.setCustomerAddress(customeraddress);
        customer.setCustomerDetail(customername+ " "+customercontact);
 
        }
        
        
        
	public List<ProductInfo> getProducts() {return products;}
	public void setProducts(List<ProductInfo> products) {this.products = products;}
	
        
        @Override
	public String toString() {
            String tab="\t";
		return 
                invoiceNumber+tab+
                datetime+tab+
                customer.getCustomerName() + " "+ customer.getCustomerContact()+tab+
                products.get(0).getProductName()+" "+products.get(0).getProductType()+" "+products.get(0).getProductCategory()+tab+
                products.get(0).getNoOfUnits()+tab+
                products.size()+tab+
                bill.getTotalPrice();

	}
	
	
	
}
