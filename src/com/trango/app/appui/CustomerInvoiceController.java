/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;

import com.trango.app.database.InventoryDao;
import com.trango.app.model.InvoiceInfo;
import com.trango.app.model.ProductInfo;
import com.trango.app.util.InvoiceUtiils;
import com.trango.app.util.Utils;
import com.trango.app.util.Validator;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author bilaliqbal
 */
public class CustomerInvoiceController implements Initializable {

 

    ObservableList<String> producttypelist = FXCollections.observableArrayList("Battery","UPS","OTHERS");
    ObservableList<String> productbrandlist = FXCollections.observableArrayList("AGS","FB","OSAKA", "PHONEIX", "OTHERS");
    
    private static DecimalFormat df = new DecimalFormat(".##");
    @FXML private AnchorPane customerInvoiceAnchorpane;
    
    @FXML private TextField customerName;
    @FXML private TextField customerContact;
    @FXML private TextArea customerAddress;
    
    @FXML private ComboBox<String> productType;
    @FXML private ComboBox<String> productBrand;
    
    @FXML private ComboBox<String> productName;
    @FXML private TextField serialNumber;
    @FXML private TextField unitPrice;
    @FXML private TextField noOfUnits;
    
    
    @FXML private Button addProductButton;
    @FXML private Button clearProductButton;
    @FXML private Button closeButton;
    @FXML private Button newBillButton;
    @FXML private Button saveBillButton;
    @FXML private Button printBillButton;
    @FXML private MenuItem deleteProduct;
    
    
    @FXML private TextField totalPrice;
    @FXML private Label dateLabel;
    
    @FXML private Label invoiceLabel;
    @FXML private Label refrenceLabel;
    
  
    @FXML private TableView<ProductInfo> productTable;
  
    
    
    @FXML private TableColumn<ProductInfo, String> productIdCol;
    @FXML private TableColumn<ProductInfo, String> productDetailsCol;
    @FXML private TableColumn<ProductInfo, String> serialNumberCol;
    @FXML private TableColumn<ProductInfo, Double> unitPriceCol;
    @FXML private TableColumn<ProductInfo, Integer> noOfUnitsCol;
    @FXML private TableColumn<ProductInfo, Double> totalPriceCol;
    
 
    
    @FXML private TextField subTotal;
    @FXML private TextField totalDiscount;
    @FXML private TextField grossTotal;
    @FXML private TextField discountRate;
    @FXML private TextField totalTax;
    @FXML private TextField taxRate;
    @FXML
    private Label remainingProducts;
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                invoiceLabel.setText(Utils.generateRandomString());
                dateLabel.setText(Utils.generateRandomString());
                refrenceLabel.setText(Utils.generateRandomString());
                
		productType.setItems(producttypelist);
        productBrand.setItems(productbrandlist);
		addProductButton.setCursor(Cursor.HAND);
		clearProductButton.setCursor(Cursor.HAND);
		tableColumns();
		onlyNumericTextField();
		productTotalChange();
		percentChange();
		setTotalPrice();        
        fetchDataFromDB();       
                
         
         	   productName.setOnAction(new EventHandler<ActionEvent>() {
		   @Override
           public void handle(ActionEvent e) {
               String selectedproduct=productName.getEditor().getText();
				System.out.println("Product Selected>> "+selectedproduct);
                                int count=productmap.get(selectedproduct);
                                
                                remainingProducts.setText(count+"");
                                
                               // noOfUnits.setText(count+"");
			
           }
       });
	   
	   
//	   productName.setOnKeyPressed(e -> {
//		    if (e.getCode() == KeyCode.ENTER) { 
//		   
//
//		    }
//		});
	   
         
                
productName.getItems().addAll(productlist);
productName.setEditable(true);
productName.setVisible(true);
    }    

  

HashMap<String,Integer> productmap=null;
List<String> productlist=null;
public void fetchDataFromDB(){
   productmap=new HashMap<>();
   productlist=new ArrayList<>();
   
    
       try {
           List<ProductInfo> list=new InventoryDao().getProductData();
           for(ProductInfo i:list){
               System.out.println(i.getInventoryInfo());
               
               productmap.put(i.getProductName(),i.getNoOfUnits());
               productlist.add(i.getProductName());
           }      } catch (Exception ex) {

       }

}

   

    @FXML
    private void close(ActionEvent event) {
        System.out.println("close");
        customerInvoiceAnchorpane.getChildren();
        customerInvoiceAnchorpane.setVisible(false);

    }



 

 

  



	public void onlyNumericTextField() {
		unitPrice.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				unitPrice.setText(oldValue);
			}
		});
		noOfUnits.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9]*")){
				noOfUnits.setText(oldValue);
			}
		});
		discountRate.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				discountRate.setText(oldValue);
			}
		});
		taxRate.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				taxRate.setText(oldValue);
			}
		});
		customerContact.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9]*")){
				customerContact.setText(oldValue);
			}
		});
	}

    @FXML
	public void onChangepType(ActionEvent event) {
		try {
			if(productType.getValue().equals("Battery")) {
				serialNumber.setPromptText("Battery Code");
			}else {
				serialNumber.setPromptText("Serial Number");
			}
		} catch (Exception e) {
			serialNumber.setPromptText("Serial Number");
		}		
	}

	public void productTotalChange() {
		unitPrice.textProperty().addListener((observable, oldValue, newValue) -> {
			setProductTotalPrice();
		});
		noOfUnits.textProperty().addListener((observable, oldValue, newValue) -> {
			setProductTotalPrice();
		});	
	}

    @FXML
	public void addProduct(ActionEvent event) {
		String valid = Validator.validateProduct(
                        productType.getSelectionModel().getSelectedItem(),
                        productBrand.getSelectionModel().getSelectedItem(),
                        productName.getEditor().getText(), 
                        serialNumber.getText(), 
                        unitPrice.getText(), 
                        noOfUnits.getText());
		
                System.out.println(">>Valid: "+valid);
                
                if(valid.equals("OK")) {
			ProductInfo bean = Validator.getProductData( productType,productName, productName, serialNumber, unitPrice, noOfUnits,totalPrice);
			productTable.getItems().add(bean);
			clearProduct(event);
		}else {
			DialogAlerts.makeAlert( valid,"Error!");						
		}
		setPrice();

	}

	public void tableColumns() {
		productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
		productDetailsCol.setCellValueFactory(new PropertyValueFactory<>("productDescription"));
		serialNumberCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
		unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
		noOfUnitsCol.setCellValueFactory(new PropertyValueFactory<>("noOfUnits"));
		totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));		
	}

    @FXML
	public void eventProductDelete(ActionEvent event) {
		ObservableList<ProductInfo> selectedProduct,allProduct;
		allProduct = productTable.getItems();
		selectedProduct = productTable.getSelectionModel().getSelectedItems();
		selectedProduct.forEach(allProduct::remove);
		setPrice();
	}


    @FXML
	public void clearProduct(ActionEvent event) {
            productType.getSelectionModel().clearSelection();
            productBrand.getSelectionModel().clearSelection();
            //productName.clear();
            serialNumber.clear();
            unitPrice.clear();
            noOfUnits.setText("1");
            totalPrice.clear();
		
	}

	public void setPrice() {
		double totalPrice = 0 ;
		for (ProductInfo item : productTable.getItems()) {
			totalPrice = totalPrice + item.getTotalPrice();
		}
		subTotal.setText(totalPrice+"");
		grossTotal.setText(totalPrice+"");
	}

	public void percentChange() {
		discountRate.textProperty().addListener((observable, oldValue, newValue) -> {
			totalDiscount.setText(percentageTotal(newValue));
			setTotalPrice();
		});
		taxRate.textProperty().addListener((observable, oldValue, newValue) -> {
			totalTax.setText(percentageTotal(newValue));
			setTotalPrice();
		});
	}

	public void setProductTotalPrice() {
		try {
			double unitPriceValue = Double.parseDouble(unitPrice.getText());
			double noUnitsValue = Double.parseDouble(noOfUnits.getText());	
			totalPrice.setText(df.format((unitPriceValue * noUnitsValue)));
		} catch (Exception e) {}
	}

	public String percentageTotal(String value) {
		double result;
		double subTotalValue;
		try {
			subTotalValue = Double.parseDouble(subTotal.getText());
			if(value.isEmpty() || value == null) {
				result=0.0;
			}else {
				result=Double.parseDouble(value);
			}	
			result = result / 100;
			return df.format(result * subTotalValue);
		} catch (Exception e) {}
		return df.format("0.00");		
	}

	public void setTotalPrice() {
		double subTotalValue =Double.parseDouble(subTotal.getText());
		double discountTotalValue =Double.parseDouble(totalDiscount.getText());
		double taxTotalValue =Double.parseDouble(totalTax.getText());	
		grossTotal.setText(df.format((subTotalValue - discountTotalValue) + taxTotalValue));
	}

    @FXML
	public void newBill(ActionEvent event) {
		invoiceLabel.setText("XE4290");
                customerName.clear();
                customerContact.clear();
                customerAddress.clear();
                
			
		clearProduct(event);
		for ( int i = 0; i<productTable.getItems().size(); i++) {
			productTable.getItems().clear();
		}
		subTotal.setText("0.0");discountRate.setText("0");totalDiscount.setText("0.0");
		taxRate.setText("0");totalTax.setText("0.0");grossTotal.setText("0.0");

	}
    @FXML
	public void saveBill(ActionEvent event) {	
    	String valid = Validator.validateCustomer( customerName.getText(), customerContact.getText(), customerAddress.getText());
        InvoiceInfo bean=null;
        if(valid.equals("OK")) {
        	bean = Validator.getBillingData(productTable, new TextField("INV1234"), customerName, customerContact, customerAddress,
			subTotal, discountRate, totalDiscount, taxRate, totalTax, grossTotal);
        	new InvoiceUtiils().saveBill(bean);
        }else {
        	DialogAlerts.makeAlert( valid,"Empty");
}


	}

    @FXML
	public void printBill(ActionEvent event) {
    	String valid = Validator.validateCustomer( customerName.getText(), customerContact.getText(), customerAddress.getText());
		
        InvoiceInfo bean=null;
if(valid.equals("OK")) {
	bean = Validator.getBillingData(productTable, new TextField("INV1234"), customerName, customerContact, customerAddress,
			subTotal, discountRate, totalDiscount, taxRate, totalTax, grossTotal);
	new InvoiceUtiils().printBill(bean);

}else {
	DialogAlerts.makeAlert( valid,"Empty");
}

	}


	

    
}
