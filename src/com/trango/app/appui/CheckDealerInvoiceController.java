/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.appui;

import com.trango.app.database.InvoiceDao;
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
public class CheckDealerInvoiceController implements Initializable {

    @FXML private AnchorPane checkInvoiceAnchorpane;
    @FXML private Font x2;
    @FXML private Button searchButton;
    @FXML private TableView<SaleInfo> invoiceTable;
    
    @FXML private Label productSold;
    @FXML private Label totalSale;
    @FXML private Button closeButton;
   
    
    @FXML private TableColumn<SaleInfo, String> invoceId;
    @FXML private TableColumn<SaleInfo, String> datetime;
    @FXML private TableColumn<SaleInfo, String> dealerDetails;
    @FXML private TableColumn<SaleInfo, String> productDetails;
    @FXML private TableColumn<SaleInfo, Integer> productQuantity;
    @FXML private TableColumn<SaleInfo, Integer> numberOfUnits;
    @FXML private TableColumn<SaleInfo, Double> deposit;
    @FXML private TableColumn<SaleInfo, Double> balance;
    @FXML private TableColumn<SaleInfo, Double> grossTotal;
    
    
    @FXML private TextField productDetail;
    @FXML private TextField deallerDetail;
    
    ObservableList<SaleInfo> itemdata ;
    List<SaleInfo> allInvoicelist;
    List<SaleInfo> invoicelist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	try {
    	itemdata = FXCollections.observableArrayList();
		allInvoicelist=new InvoiceDao().getAllInvoiceList();} catch (Exception e1) {e1.printStackTrace();} 
        tableColumns();init();
        
        try {invoiceTable.setItems(getInvoiceData());} catch (Exception e) {e.printStackTrace();}
    }    

    
    
    
    public void init() {
    	productDetail.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if(newValue.length()>3) {
    	    	try {
    	    			invoicelist=new InvoiceDao().getInvoiceListProduct(newValue);
			        	itemdata.clear();
			        	for(SaleInfo i:invoicelist){itemdata.add(i);}
			        	invoiceTable.setItems(itemdata);
    	    	} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	    else {
    	    	  try {invoiceTable.setItems(getInvoiceData());} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	});
    	
    	deallerDetail.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if(newValue.length()>3) {
    	    	try {
    	    			invoicelist=new InvoiceDao().getInvoiceListCustomer(newValue);
			        	itemdata.clear();
			        	for(SaleInfo i:invoicelist){itemdata.add(i);}
			        	invoiceTable.setItems(itemdata);
    	    	} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	    else {
    	    	  try {invoiceTable.setItems(getInvoiceData());} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	});
    	
    }
    
    
    
    @FXML
    private void searchAction(ActionEvent event) {
    }
    
    
    
    
public ObservableList<SaleInfo> getInvoiceData() throws ClassNotFoundException, SQLException, Exception{
System.out.println("Items count: "+allInvoicelist.size());
for(SaleInfo i:allInvoicelist){itemdata.add(i);}
return itemdata;
} 

    
    public void tableColumns(){         
   invoceId.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("invoiceNumber"));
   datetime.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("datetime"));
   dealerDetails.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("customerDetails"));
   productDetails.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("productDetails"));
   productQuantity.setCellValueFactory(new PropertyValueFactory<SaleInfo, Integer>("productCount"));
   numberOfUnits.setCellValueFactory(new PropertyValueFactory<SaleInfo, Integer>("noOfUnits"));
   deposit.setCellValueFactory(new PropertyValueFactory<SaleInfo, Double>("deposit"));
   balance.setCellValueFactory(new PropertyValueFactory<SaleInfo, Double>("balance"));
   grossTotal.setCellValueFactory(new PropertyValueFactory<SaleInfo, Double>("grossTotal"));
    }

    @FXML
    private void close(ActionEvent event) {
    System.out.println("close");
    checkInvoiceAnchorpane.getChildren();
    checkInvoiceAnchorpane.setVisible(false);
    }
    
}
