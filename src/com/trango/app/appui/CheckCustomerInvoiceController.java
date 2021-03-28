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
public class CheckCustomerInvoiceController implements Initializable {

    @FXML private AnchorPane checkInvoiceAnchorpane;
    @FXML private Font x2;
    @FXML private Button searchButton;
    @FXML private TableView<SaleInfo> invoiceTable;
    
    @FXML private Label productSold;
    @FXML private Label totalSale;
    @FXML private Button closeButton;
    
    @FXML private TableColumn<SaleInfo, String> invoiceNumber;
    @FXML private TableColumn<SaleInfo, String> datetime;
    @FXML private TableColumn<SaleInfo, String> customerDetails;
    @FXML private TableColumn<SaleInfo, String> productDetails;
    @FXML private TableColumn<SaleInfo, Integer> unitPrice;
    @FXML private TableColumn<SaleInfo, Integer> noOfUnits;
    @FXML private TableColumn<SaleInfo, Double> subTotal;
    @FXML private TextField productDetail;
    @FXML private TextField customerDetail;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              tableColumns();
        try {invoiceTable.setItems(getInvoiceydata());} catch (Exception e) {e.printStackTrace();}
   
    }    
    
    
        
public ObservableList<SaleInfo> getInvoiceydata() throws ClassNotFoundException, SQLException, Exception{
ObservableList<SaleInfo> itemdata = FXCollections.observableArrayList();
List<SaleInfo> salelist=new InvoiceDao().getCustomerSaleList();
System.out.println("Items count: "+salelist.size());
for(SaleInfo i:salelist){itemdata.add(i);}
return itemdata;
} 

    
    public void tableColumns(){
     invoiceNumber.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("invoiceNumber"));
     datetime.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("datetime"));
     customerDetails.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("customerDetails"));
     productDetails.setCellValueFactory(new PropertyValueFactory<SaleInfo, String>("productDetails"));
     noOfUnits.setCellValueFactory(new PropertyValueFactory<SaleInfo, Integer>("noOfUnits"));
     unitPrice.setCellValueFactory(new PropertyValueFactory<SaleInfo, Integer>("unitPrice"));
     subTotal.setCellValueFactory(new PropertyValueFactory<SaleInfo, Double>("totalPrice"));
    }

    @FXML
    private void searchAction(ActionEvent event) {
    }

    @FXML
    private void close(ActionEvent event) {
        System.out.println("close");
        checkInvoiceAnchorpane.getChildren();
        checkInvoiceAnchorpane.setVisible(false);
    }
    
}
