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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author bilaliqbal
 */
public class CheckAllInvoiceController implements Initializable {

    @FXML private AnchorPane checkInvoiceAnchorpane;
    @FXML private Font x2;
    @FXML private TableView<SaleInfo> invoiceTable;
    
    @FXML private Label productSold;
    @FXML private Label totalSale;
    @FXML private Button closeButton;
   
    
 
    @FXML private TableColumn<SaleInfo, String> datetime;
    @FXML private TableColumn<SaleInfo, String> dealerDetails;
    @FXML private TableColumn<SaleInfo, String> productDetails;
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
    	    			invoicelist=new InvoiceDao().getInvoiceListProductDetails(newValue);
			        	itemdata.clear();
			        	for(SaleInfo i:invoicelist){itemdata.add(i);}
			        	invoiceTable.setItems(itemdata);
    	    	} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	    else if (newValue.length()==0){
    	    	  try {invoiceTable.setItems(getInvoiceData());} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	});
    	
    	deallerDetail.textProperty().addListener((observable, oldValue, newValue) -> {
    	    if(newValue.length()>3) {
    	    	try {
    	    			invoicelist=new InvoiceDao().getInvoiceListCustomerDetails(newValue);
			        	itemdata.clear();
			        	for(SaleInfo i:invoicelist){itemdata.add(i);}
			        	invoiceTable.setItems(itemdata);
    	    	} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	    else if(newValue.length()==0) {
    	    	  try {invoiceTable.setItems(getInvoiceData());} catch (Exception e) {e.printStackTrace();}
    	    }
    	    
    	});
    	
    }
    
    

    
    @FXML
public void clickItem(MouseEvent event){
    if (event.getClickCount() == 2) {
        String invoiceNumber=invoiceTable.getSelectionModel().getSelectedItem().getInvoiceNumber();
        String productdetails=invoiceTable.getSelectionModel().getSelectedItem().getProductDetails();
        String customerdetails=invoiceTable.getSelectionModel().getSelectedItem().getCustomerDetails();
        System.out.println(invoiceNumber + "\n"+ customerdetails+ "\n"+ productdetails);
        
        String[] arr=productdetails.split(",");
        StringBuilder list=new StringBuilder();
        if(arr.length>1){
        for(int i=0;i<arr.length;i++){
            list.append(arr[i].trim());
            list.append("\n");

        }
                DialogAlerts.makeAlert(invoiceNumber + "\n"+ customerdetails+ "\n"+ list.toString(), "");
        }
        
        else{
        
        DialogAlerts.makeAlert(invoiceNumber + "\n"+ customerdetails+ "\n"+ productdetails, "");
        }
    }
}
    
    
public ObservableList<SaleInfo> getInvoiceData() throws ClassNotFoundException, SQLException, Exception{
System.out.println("Items count: "+allInvoicelist.size());
long assets=0;
int count=0;
for(SaleInfo i:allInvoicelist){itemdata.add(i);
 count+=i.getNoOfUnits();
    assets+=i.getTotalPrice();
}

productSold.setText(count+"");
totalSale.setText(assets+"");
return itemdata;
} 

    
    public void tableColumns(){         
   datetime.setCellValueFactory(new PropertyValueFactory<>("datetime"));
   dealerDetails.setCellValueFactory(new PropertyValueFactory<>("customerDetails"));
   productDetails.setCellValueFactory(new PropertyValueFactory<>("productDetails"));
   numberOfUnits.setCellValueFactory(new PropertyValueFactory<>("noOfUnits"));
   deposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
   balance.setCellValueFactory(new PropertyValueFactory<>("balance"));
   grossTotal.setCellValueFactory(new PropertyValueFactory<>("grossTotal"));
    }

    @FXML
    private void close(ActionEvent event) {
    System.out.println("close");
    checkInvoiceAnchorpane.getChildren();
    checkInvoiceAnchorpane.setVisible(false);
    }
    
}
