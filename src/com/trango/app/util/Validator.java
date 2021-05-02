package com.trango.app.util;


import com.trango.app.model.InvoiceInfo;
import com.trango.app.model.ProductInfo;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Validator {



        
        
        
	public static ProductInfo getProductData(ComboBox<String> productType,ComboBox<String> productName,ComboBox<String> productBrand,TextField productSerial,
		TextField productPrice,TextField productQuantity,TextField ptotalPrice) throws Exception {
		ProductInfo bean =new ProductInfo(productName.getEditor().getText());
		
		//ProductInfo bean=new ProductInfo("000","MOB1000", "Mobile", "Samsung", 0,12309, 4, 24600);
		
		bean.setProductName(productName.getEditor().getText());
		bean.setProductType(productType.getSelectionModel().getSelectedItem());;
		bean.setProductDetails(productType.getEditor().getText()+" "+productName.getEditor().getText());
		bean.setSerialNumber(productSerial.getText().toUpperCase());
		bean.setUnitPrice(Double.parseDouble(productPrice.getText()));
		bean.setNoOfUnits(Integer.parseInt(productQuantity.getText()));
		bean.setTotalPrice(Double.parseDouble(ptotalPrice.getText()));		
		return bean;	
	}
        
        public static String validateCustomer(String cname, String ccontact, String caddress){
        
        	 if(cname.isEmpty() || cname.equals(null) || cname.equals("")){
			return "Customer Name is Not Entered.";
		}else if(ccontact.isEmpty() || ccontact.equals(null) || ccontact.equals("")){
			return "Customer Contact is Not Entered.";
		}else if(caddress.isEmpty() || caddress.equals(null) || caddress.equals("")){
			return "Customer Address is Not Entered.";
		}else {
			return "OK";
		}
        }
        
        
        	public static String validateProduct(String productType,String productBrand,String productName,String discountRate,String unitPrice,String units) {
		if(productType.isEmpty()) {
			return "Product Type is Not Selected.";
		}
		else if(productName.isEmpty()) {
			return "Product Name is Not Entered.";
		}else if(productBrand.isEmpty()) {
			return "Brand Name is Not Entered.";
		}else if(discountRate.isEmpty()) {
			return "discountRate  is Not Entered.";
		}
                else if(unitPrice.isEmpty()) {
			return "Unit Price is Not Entered.";
		}else if(units.isEmpty()) {
			return "Number of Units is Not Entered.";
		}else {
			return "OK";
		}

	}


	public static InvoiceInfo getBillingData(TableView<ProductInfo> table,TextField invoice,TextField customername,
		TextField customercontact,TextArea customeraddress,TextField subTotal,TextField discount,
		TextField discountTotal,TextField tax,TextField taxTotal,TextField total) {
		InvoiceInfo bean = new InvoiceInfo();
		bean.setInvoiceNumber(invoice.getText());	
                bean.setCustomer(customername.getText(), customercontact.getText(), customeraddress.getText());   
                bean.setBill(subTotal.getText(), discount.getText(), discountTotal.getText(), tax.getText(), taxTotal.getText(), total.getText(), total.getText(), "0.0");
		bean.setProducts(table.getItems());
		
		return bean;	
	}
        
        
        
       
}
