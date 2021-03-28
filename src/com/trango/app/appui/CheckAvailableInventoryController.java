/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;

import com.trango.app.database.InventoryDao;
import com.trango.app.model.ProductInfo;
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
public class CheckAvailableInventoryController implements Initializable {

    @FXML private Font x2;
    @FXML private Button searchButton;
    @FXML private TableView<ProductInfo> inventoryTable;
   
    @FXML private TableColumn<ProductInfo, String> nameColumn;
    @FXML private TableColumn<ProductInfo, String> typeColumn;
    @FXML private TableColumn<ProductInfo, String> categoryColumn;
    @FXML private TableColumn<ProductInfo, String> unitPriceColumn;
    @FXML private TableColumn<ProductInfo, String> quantityColumn;
    @FXML private TableColumn<ProductInfo, String> totalColumn;
    @FXML private TextField productName;
    @FXML private TextField productCategory;
    @FXML private Button closeButton;
    @FXML private Label totalProducts;
    @FXML private Label totalAssets;
    @FXML private AnchorPane checkInventoryAnchorpane;
    
    public ObservableList<ProductInfo> itemdata;
    
    List<ProductInfo> completeAvailableProductlist;
    List<ProductInfo> searchedAvailableProductlist;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	itemdata = FXCollections.observableArrayList();
    	try {
			completeAvailableProductlist=new InventoryDao().getAvailableInventory();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
    	

        tableColumns();
        try {inventoryTable.setItems(getRemainingInventorydata());} catch (Exception e) {e.printStackTrace();}
    }    

    
    
    public void init() {
    	productName.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if(newValue.length()>3) {
    	    	try {
    	    			searchedAvailableProductlist=new InventoryDao().getAvailableInventory(newValue);
			        	itemdata.clear();
			        	for(ProductInfo i:searchedAvailableProductlist){itemdata.add(i);}
			        	inventoryTable.setItems(itemdata);
    	    	} catch (Exception e) {
				
					e.printStackTrace();
				}
    	    }
    	    
    	    else {
    	    	
    	    	  try {inventoryTable.setItems(getRemainingInventorydata());} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	});
    	
    }
    	public void tableColumns() {           
nameColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productName"));
typeColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productType"));
categoryColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("productCategory"));
unitPriceColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("unitPrice"));
quantityColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("noOfUnits"));
totalColumn.setCellValueFactory(new PropertyValueFactory<ProductInfo, String>("totalPrice"));		
	}
    
        
public ObservableList<ProductInfo> getRemainingInventorydata() throws ClassNotFoundException, SQLException, Exception{
System.out.println("Items count: "+completeAvailableProductlist.size());
for(ProductInfo i:completeAvailableProductlist){itemdata.add(i);}
return itemdata;
}  
        
    @FXML
    private void searchAction(ActionEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
    System.out.println("close");
    checkInventoryAnchorpane.getChildren();
    checkInventoryAnchorpane.setVisible(false);
    }
    
}
