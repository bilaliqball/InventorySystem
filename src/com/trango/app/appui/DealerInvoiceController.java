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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;


/**
 * FXML Controller class
 *
 * @author bilaliqbal
 */
public class DealerInvoiceController implements Initializable {




   ObservableList<String> batteryType = FXCollections.observableArrayList("AGS","FB","OSAKA","PHONEX","OTHER");
   
   private static DecimalFormat df = new DecimalFormat(".##");
   
    @FXML private AnchorPane dealerInvoiceAnchorpane;
    @FXML private Font x2;
    @FXML private Label dateLabel;
    @FXML private Button addProductButton;
   
    @FXML private TableView<ProductInfo> invoiceTable;
    @FXML private TableColumn<ProductInfo, String> productIdCol;
    @FXML private TableColumn<ProductInfo, String> productDetailsCol;
    @FXML private TableColumn<ProductInfo, String> productBrandCol;
    @FXML private TableColumn<ProductInfo, Double> discountRateCol;
    @FXML private TableColumn<ProductInfo, Double> unitPriceCol;
    @FXML private TableColumn<ProductInfo, Integer> noOfUnitsCol;
    @FXML private TableColumn<ProductInfo, Double> totalPriceCol;
    
    
    @FXML private Button printInvoiceButton;
    @FXML private ChoiceBox<String> productBrand;

    @FXML private TextField unitPrice;
    @FXML private TextField discountRate;
    @FXML private TextField noOfUnits;
    @FXML private Button removeProductButton;
    @FXML private TextField customerName;
    @FXML private TextField customerContact;
    @FXML private TextArea customerAddress;
    @FXML private Label grossTotal;
    @FXML private Button closeButton;
    @FXML private TextField invoiceNumber;
    @FXML private Label totalDiscount;
    @FXML private Label totalTax;
    @FXML private Label subTotal;
    @FXML private ComboBox<String> productName;
    @FXML private Label remainingProducts;
    

 @Override
public void initialize(URL url, ResourceBundle rb) {
     
          invoiceNumber.setText(Utils.generateRandomString());
		productBrand.setItems(batteryType);
      
		addProductButton.setCursor(Cursor.HAND);
		tableColumns();
		onlyNumericTextField();
		//productTotalChange();
		//percentChange();
		//setTotalPrice();
          
         fetchDataFromDB();       
                
         
         init();



}    

HashMap<String,Integer> productmap=null;
List<String> productlist=null;

public void fetchDataFromDB(){
productmap=new HashMap<>();
productlist=new ArrayList<>();
       try {
           List<ProductInfo> list=new InventoryDao().getProductDataList();
           for(ProductInfo i:list){
               System.out.println(i.getInventoryInfo());
               productmap.put(i.getProductName(),i.getNoOfUnits());
               productlist.add(i.getProductName());
           }      } catch (Exception ex) {

       }

}


public void init(){
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





     
productName.getItems().addAll(productlist);
productName.setEditable(true);
productName.setVisible(true);}
	@FXML
    private void close(ActionEvent event) {
        System.out.println("close");
        dealerInvoiceAnchorpane.getChildren();
        dealerInvoiceAnchorpane.setVisible(false);
    }


	public void onlyNumericTextField() {   
            	customerContact.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				customerContact.setText(oldValue);
			}
		});
            
            
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
		
		
	}

	public void onChangepType(ActionEvent event) {
                System.out.println( productBrand.getValue());
				
	}

	public void productTotalChange() {
		noOfUnits.textProperty().addListener((observable, oldValue, newValue) -> {
			setProductTotalPrice();
		});
		unitPrice.textProperty().addListener((observable, oldValue, newValue) -> {
			setProductTotalPrice();
		});	
	}

	

	public void tableColumns() {
productIdCol.setCellValueFactory(new PropertyValueFactory<>("productId"));
productDetailsCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
productBrandCol.setCellValueFactory(new PropertyValueFactory<>("productType"));
discountRateCol.setCellValueFactory(new PropertyValueFactory<>("discount"));
unitPriceCol.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
noOfUnitsCol.setCellValueFactory(new PropertyValueFactory<>("noOfUnits"));
totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));	

        
        }

	public void eventProductDelete(ActionEvent event) {
		ObservableList<ProductInfo> selectedProduct,allProduct;
		allProduct = invoiceTable.getItems();
		selectedProduct = invoiceTable.getSelectionModel().getSelectedItems();
		selectedProduct.forEach(allProduct::remove);
		setPrice();
	}


	public void clearProduct(ActionEvent event) {
            productBrand.getSelectionModel().clearSelection();
            //productName.clear();
            unitPrice.clear();
            noOfUnits.clear();
	}

	public void setPrice() {
		double totalPrice = 0 ;
		for (ProductInfo item : invoiceTable.getItems()) {
			totalPrice = totalPrice + item.getTotalPrice();
		}
		subTotal.setText(totalPrice+"");
		grossTotal.setText(totalPrice+"");
	}
	public void percentChange() {
//		discountRate.textProperty().addListener((observable, oldValue, newValue) -> {
//			discountTextfield.setText(percentageTotal(newValue));
//			setTotalPrice();
//		});
	
	}

	public void setProductTotalPrice() {
		try {
			double unitPriceValue = Double.parseDouble(unitPrice.getText());
			double noUnitsValue = Double.parseDouble(noOfUnits.getText());	
			grossTotal.setText(df.format((unitPriceValue * noUnitsValue)));
		} catch (Exception e) {}
	}

	public String percentageTotal(String value) {
		double result;
		double subTotalValue;
		try {
			subTotalValue = Double.parseDouble(grossTotal.getText());
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
		double subTotalValue =Double.parseDouble(grossTotal.getText());
		double discountTotalValue =Double.parseDouble(discountRate.getText());
		
		grossTotal.setText(df.format((subTotalValue - discountTotalValue)));
	}

	public void newBill(ActionEvent event) {
		invoiceNumber.setText("XE4290");
                customerName.clear();
                customerContact.clear();
                customerAddress.clear();
            
		clearProduct(event);
		for ( int i = 0; i<invoiceTable.getItems().size(); i++) {
			invoiceTable.getItems().clear();
		}
	
	subTotal.setText("0.0");
                grossTotal.setText("0.0");

	}


 
        
        

    @FXML
    private void printInvoiceAction(ActionEvent event) {

		String valid = "OK";
        
        //valid=ValidationFields.validateBilling(productTable, customerTextfield, contactField, addressField);

        InvoiceInfo bean=null;
if(valid.equals("OK")) {
            
                        
	bean = Validator.getBillingData(invoiceTable, new TextField("1234"), customerName, customerContact, customerAddress,
                        new TextField(subTotal.getText()), new TextField(discountRate.getText()), new TextField(discountRate.getText()), new TextField(discountRate.getText()), new TextField(discountRate.getText()), new TextField(grossTotal.getText()));
	new InvoiceUtiils().saveBill(bean);

}else {
	DialogAlerts.makeAlert("Empty", valid);
}
		
	
    }




    @FXML
    private void addInventoryAction(ActionEvent event) throws Exception {
        String productname=productName.getEditor().getText();;
        String unitprice= unitPrice.getText();
        String discountrate= discountRate.getText();
        String noOfunits=noOfUnits.getText();
        String producttype= "Battery";
        String productbrand=productBrand.getSelectionModel().getSelectedItem();
           
        
        String validProduct=Validator.validateProduct(producttype, productbrand, productname, discountrate, unitprice, noOfunits);
        
        
           System.out.println(">>Valid: "+validProduct);
                
                if(validProduct.equals("OK")) {
	      String productid=Utils.getProductId(productname);
              double totalprice=(Double.parseDouble(unitprice))*(Integer.parseInt(noOfunits));
           
           ProductInfo item=new ProductInfo(
                   productid, 
                   productname,
                   producttype,
                   productbrand, 
                   Double.parseDouble(discountrate), 
                   Double.parseDouble(unitprice), 
                   Integer.parseInt(noOfunits), 
                   totalprice);
	
			
                        invoiceTable.getItems().add(item);
			clearProduct(event);
		
		setPrice();
		}else {
			DialogAlerts.makeAlert( validProduct,"Error!");						
		}
		setPrice();
        
        
      

	
    }


    @FXML
    private void removeInventoryAction(ActionEvent event) {
        clearProduct(event);
    }
    
}
