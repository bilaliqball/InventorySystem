/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;

import com.trango.app.model.InvoiceInfo;
import com.trango.app.model.ProductInfo;
import com.trango.app.util.InvoiceUtiils;

import com.trango.app.util.Validator;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class AddInventoryController implements Initializable {

    @FXML private Font x2;
    @FXML private Label invoiceLabel;
    @FXML private Label dateLabel;
    @FXML private Label refrenceLabel;
    

    @FXML private TableColumn<ProductInfo, String> idColumn;
    @FXML private TableColumn<ProductInfo, String> nameColumn;
    @FXML private TableColumn<ProductInfo, String> typeColumn;
    @FXML private TableColumn<ProductInfo, String> categoryColumn;
    @FXML private TableColumn<ProductInfo, String> discountColumn;
    @FXML private TableColumn<ProductInfo, String> priceColumn;
    @FXML private TableColumn<ProductInfo, String> quantityColumn;
    @FXML private TableColumn<ProductInfo, String> totalColumn;
    
    @FXML private Button addProductButton;
    @FXML private Button closeButton;
    @FXML private Button printInvoiceButton;
    
    
    @FXML private TextField unitPriceTextfield;
    @FXML private TextField discountTextfield;
    @FXML private TextField quantityTextfield;
    @FXML private TextField productNameTextfield;
    @FXML private AnchorPane addInventoryAnchorpane;
    @FXML private TableView<ProductInfo> inventoryTable;
    
   @FXML private ChoiceBox<String> typeCombox;
   @FXML private ChoiceBox<String> categoryCombox;
   ObservableList<String> productType = FXCollections.observableArrayList("Battery","UPS","Other");
   ObservableList<String> batteryType = FXCollections.observableArrayList("AGS","FB","OSAKA","PHONEX");
  


 public List<ProductInfo> inventoryList;

 @Override
public void initialize(URL url, ResourceBundle rb) {
	 	inventoryList=new ArrayList<>();
        invoiceLabel.setText("XE4289");
        typeCombox.setItems(productType);
        categoryCombox.setItems(batteryType);
		addProductButton.setCursor(Cursor.HAND);
		tableColumns();
		onlyNumericTextField();

}    



   @FXML
    private void close(ActionEvent event) {
        addInventoryAnchorpane.getChildren();
        addInventoryAnchorpane.setVisible(false);
    }


	public void onlyNumericTextField() {            
		unitPriceTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				unitPriceTextfield.setText(oldValue);
			}
		});
		quantityTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9]*")){
				quantityTextfield.setText(oldValue);
			}
		});
		discountTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!newValue.matches("[0-9.]*")){
				discountTextfield.setText(oldValue);
			}
		});
		
		
	}

	public void onChangepType(ActionEvent event) {
	System.out.println( typeCombox.getValue());
    System.out.println( categoryCombox.getValue());
				
	}



	public void tableColumns() {           
		idColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productName"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productType"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productCategory"));
		discountColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("discount"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("unitPrice"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("noOfUnits"));
		totalColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("totalPrice"));		
	}

	public void eventProductDelete(ActionEvent event) {
		ObservableList<ProductInfo> selectedProduct,allProduct;
		allProduct = inventoryTable.getItems();
		selectedProduct = inventoryTable.getSelectionModel().getSelectedItems();
		selectedProduct.forEach(allProduct::remove);
	
	}


	public void clearProduct(ActionEvent event) {
            typeCombox.getSelectionModel().clearSelection();
            categoryCombox.getSelectionModel().clearSelection();
            productNameTextfield.clear();
            unitPriceTextfield.clear();
            discountTextfield.clear();
            quantityTextfield.clear();
         
		
	}


    @FXML
    private void printInvoiceAction(ActionEvent event) {
		String valid = "OK";
		 InvoiceInfo bean=null;
                
		if(valid.equals("OK")) {        
			bean = Validator.getBillingData(inventoryTable, new TextField("1234"), new TextField("Iqbal"), new TextField("03004442033"), new TextArea("Lahore"),
            new TextField("0"), new TextField("0"), new TextField("0"), new TextField("0"), new TextField("0"), new TextField("0"));
			new InvoiceUtiils().saveBill(bean);

		}
		
		else {DialogAlerts.makeAlert("Empty", valid);}
	
	
	
    }

    @FXML
    private void addProductAction(ActionEvent event) throws Exception { 
       String batteryName=productNameTextfield.getText();
       String UnitPrice= unitPriceTextfield.getText();
       String discountrate= discountTextfield.getText();
       String noOfUnits=quantityTextfield.getText();
       String productType=typeCombox.getValue().toString();
       String batteryType= categoryCombox.getValue();
       String id="1234";
       double price=Integer.parseInt(UnitPrice)*Integer.parseInt(noOfUnits);
       ProductInfo item=new ProductInfo(id, batteryName, productType, batteryType, Double.parseDouble(discountrate), Double.parseDouble(UnitPrice), Integer.parseInt(noOfUnits), price);
       inventoryList.add(item);
       inventoryTable.getItems().add(item);
	   clearProduct(event);

    }

  
    
}
