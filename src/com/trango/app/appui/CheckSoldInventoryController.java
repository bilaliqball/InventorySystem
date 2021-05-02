/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;

import com.trango.app.database.InventoryDao;
import com.trango.app.model.SaleInfo;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author bilaliqbal
 */
public class CheckSoldInventoryController implements Initializable {

    @FXML private Font x2;
    @FXML private TableView<SaleInfo> inventoryTable;
    @FXML private TableColumn<SaleInfo, String> prodcutDetailColumn;
    @FXML private TableColumn<SaleInfo, String> customerDetailColumn;
    @FXML private TableColumn<SaleInfo, String> categoryColumn;
    @FXML private TableColumn<SaleInfo, String> unitPriceColumn;
    @FXML private TableColumn<SaleInfo, String> quantityColumn;
    @FXML private TableColumn<SaleInfo, String> totalColumn;

    @FXML private Button closeButton;
    @FXML private Label totalProducts;
    @FXML private Label totalAssets;
    @FXML private AnchorPane checkInventoryAnchorpane;


    List<SaleInfo> completeSoldProductList;
    List<SaleInfo> searchedSoldProductList;
    public ObservableList<SaleInfo> itemdata;
  
    @FXML private TextField productDetails;
    @FXML private TextField customerDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

     	itemdata = FXCollections.observableArrayList();
    	try {completeSoldProductList=new InventoryDao().getSoldInventory();} catch (Exception e1) {e1.printStackTrace();}
        tableColumns();init();
        try {inventoryTable.setItems(getSoldInventorydata());} catch (Exception e) {e.printStackTrace();}
    }    

    
    
    
    public void init() {
    	productDetails.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if(newValue.length()>2) {
    	    	System.out.println(newValue);
    	    	try {
    	    		searchedSoldProductList=new InventoryDao().getSoldInventory(newValue);
			        itemdata.clear();
			        for(SaleInfo i:searchedSoldProductList){itemdata.add(i);}
			        inventoryTable.setItems(itemdata);
				} 
    	    	catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	    else if(newValue.length()==0) {
    	    	  try {inventoryTable.setItems(getSoldInventorydata());} catch (Exception e) {e.printStackTrace();}
    	    }
    	});
    	
    }
    
    
public ObservableList<SaleInfo> getSoldInventorydata() throws ClassNotFoundException, SQLException, Exception{
System.out.println("Items count: "+completeSoldProductList.size());

long assets=0;
int count=0;

for(SaleInfo i:completeSoldProductList){
    itemdata.add(i);
    count+=i.getNoOfUnits();
    assets+=i.getTotalPrice();
}
totalProducts.setText(count+ "");
totalAssets.setText(assets+ "");
return itemdata;} 
    
    
public void tableColumns() {           
prodcutDetailColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("productDetails"));
customerDetailColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("customerDetails"));
categoryColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("datetime"));
unitPriceColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("unitPrice"));
quantityColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("noOfUnits"));
totalColumn.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("totalPrice"));		
	}
    
        
  
        

    @FXML
    private void close(ActionEvent event) {
    checkInventoryAnchorpane.getChildren();
    checkInventoryAnchorpane.setVisible(false);
    }
    
}
