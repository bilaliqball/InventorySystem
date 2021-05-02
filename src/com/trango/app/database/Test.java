package com.trango.app.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trango.app.model.CustomerInfo;
import com.trango.app.model.ProductInfo;
import com.trango.app.model.SaleInfo;

public class Test {
	
	
	public static void process() throws ClassNotFoundException, SQLException, Exception {
		 List<ProductInfo> productlist=new ArrayList<>();

		 CustomerInfo customer=new CustomerInfo("1234","Bilal Iqbal", "Cutomer", "0300", "Lahore");



		 ProductInfo product1=new ProductInfo("000","MOB1000", "Mobile", "Samsung", 0,12309, 4, 24600);
		 ProductInfo product2=new ProductInfo("000","MOB2000", "Mobile", "Apple", 0,12309, 4, 24600);
		 ProductInfo product3=new ProductInfo("000","MOB3000", "Mobile", "Nokia", 0,12300, 4, 24600);
		 ProductInfo product4=new ProductInfo("000","LAP4000", "Laptop", "Dell", 0,12300, 4, 24600);
		 ProductInfo product5=new ProductInfo("000","LAP5000", "Laptop", "HP", 0,12300, 4, 24600);
		 ProductInfo product6=new ProductInfo("000","LAP6000", "Laptop", "Accer", 0,12300, 4, 24600);
		 ProductInfo product7=new ProductInfo("000","COM7000", "Computer", "Dell", 0,12300, 4, 24600);
		 ProductInfo product8=new ProductInfo("000","COM8000", "Computer", "Dell", 0,12300, 4, 24600);
		 ProductInfo product9=new ProductInfo("000","COM9000", "Computer", "HP", 0,12300, 4, 24600);
		 productlist.add(product1);
		 productlist.add(product2);   
		 productlist.add(product3);
		 productlist.add(product4);   
		 productlist.add(product5);
		 productlist.add(product6);   
		 productlist.add(product7);
		 productlist.add(product8);   
		 productlist.add(product9);


		 //new ProductDao().addProductIntoInventory(product2);
		//new ProductDao().removeProductFromInventory(customer,product5);

		// new ProductDao().addProductIntoInventory(productlist);
		new ProductDao().removeProductFromInventory(customer,productlist);



		   

	}
	
	
	public static void display() throws ClassNotFoundException, SQLException, Exception {
		System.out.println("****************************AVAIALBLE*****************************");
	List<ProductInfo> avaiablelist=new InventoryDao().getAvailableInventory();
	for(ProductInfo i:avaiablelist){System.out.println(i.toString());

	}

	System.out.println("****************************SOLD*****************************");

	List<SaleInfo> list=new InventoryDao().getSoldInventory();
	for(SaleInfo i:list){System.out.println(i.toString());}

	System.out.println("****************************INVOICE*****************************");

	List<SaleInfo> salelist=new InvoiceDao().getAllInvoiceList();
	for(SaleInfo sale:salelist) {
		System.out.println(sale.toString());
	}
	}
	
	
	
	public static void inventory() throws ClassNotFoundException, SQLException, Exception {
		
		String productId=new InventoryDao().getProductId("COM9000");
		System.out.println(productId);
		
		int productCount=new InventoryDao().getProductCount("COM9000");
		System.out.println(productCount);

		List<String> avaiablelist=new InventoryDao().getProductList("COM");
		for(String i:avaiablelist){System.out.println(i.toString());}

		
		List<ProductInfo> productList=new InventoryDao().getProductDataList();
		for(ProductInfo i:productList){System.out.println(i.getInventoryInfo());}
		
		
		List<ProductInfo> availableInventoryList=new InventoryDao().getAvailableInventory("Com");
		for(ProductInfo i:availableInventoryList){System.out.println(i.toString());}

		List<SaleInfo> soldInventoryList=new InventoryDao().getSoldInventory("com");
		for(SaleInfo i:soldInventoryList){System.out.println(i.toString());}
	}
	
	
	public static void invoces() throws ClassNotFoundException, SQLException, Exception {
		
		List<SaleInfo>  allInvoiceList=new InvoiceDao().getAllInvoiceList();
		for(SaleInfo sale:allInvoiceList) {System.out.println(sale.toString());}
	
		
		List<SaleInfo>  invoiceListCustomerDetails=new InvoiceDao().getInvoiceListCustomerDetails("Bilal");
		for(SaleInfo sale:invoiceListCustomerDetails) {System.out.println(sale.toString());}
		
		
		List<SaleInfo>  invoiceListProductDetails=new InvoiceDao().getInvoiceListProductDetails("Com");
		for(SaleInfo sale:invoiceListProductDetails) {System.out.println(sale.toString());}
		
		
		List<SaleInfo>  customerSaleList=new InvoiceDao().getCustomerSaleList();
		for(SaleInfo sale:customerSaleList) {System.out.println(sale.toString());}
		
		
		List<SaleInfo>  dealerSaleList=new InvoiceDao().getDealerSaleList();
		for(SaleInfo sale:dealerSaleList) {System.out.println(sale.toString());}
	}
	
	
	public static void main(String argsp[]) throws Exception{
				
		process();
		display();
		

		

		
		

		
	}

}
