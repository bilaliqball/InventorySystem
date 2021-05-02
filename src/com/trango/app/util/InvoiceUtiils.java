package com.trango.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

import com.trango.app.appui.DialogAlerts;
import com.trango.app.database.ProductDao;
import com.trango.app.model.CustomerInfo;
import com.trango.app.model.InvoiceInfo;
import com.trango.app.model.ProductInfo;

import javafx.stage.FileChooser;

public class InvoiceUtiils {

	
    
	public void saveBill(InvoiceInfo bean) {		
		File file =new File(getClass().getResource("/resources/others/INVOICE.pdf").getFile());
        System.out.println("File>"+file.getName());        
        boolean isGenrated =false;
        
        boolean updated=false;
       
        try{updated=new ProductDao().removeProductFromInventory(bean.getCustomer(),bean.getProducts());}catch(Exception e) {e.printStackTrace();}

        System.out.println("Updated: "+ updated);
        

		if(! (bean == null)) {
			try{isGenrated =InvoiceGenerator.makePDF(file, bean);}catch(Exception e){e.printStackTrace();}
		}

		if(isGenrated) {
			FileChooser fileChooser = new FileChooser();
			//fileChooser.setInitialFileName("Invoice_No_"+invoice.getText()+".pdf");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
			fileChooser.getExtensionFilters().add(extFilter);
			fileChooser.setTitle("Save Invoice");
			File dest = fileChooser.showSaveDialog(null); 
			if (dest != null) {
				try {
					Files.copy(file.toPath(), dest.toPath());
				} catch (Exception ex) {
					DialogAlerts.makeAlert("File Not Found", "Falied Saving File");
                                        ex.printStackTrace();
				}
			}
		}else {
			DialogAlerts.makeAlert("File Not Found", "Falied Saving File");
		}


	}
	
	
	
	public void saveInvoice(InvoiceInfo bean) {		
		File file =new File(getClass().getResource("/resources/others/INVOICE.pdf").getFile());
        System.out.println("File>"+file.getName());        
        boolean isGenrated =false;
        
        boolean updated=false;
       
        try{updated=new ProductDao().removeProductFromInventory(bean.getCustomer(),bean.getProducts());}catch(Exception e) {e.printStackTrace();}

        System.out.println("Updated: "+ updated);
        

		if(! (bean == null)) {
			try{isGenrated =InvoiceGenerator.savePDF(file, bean);}catch(Exception e){e.printStackTrace();}
		}

		if(isGenrated) {
			
			String outputfilename="Invoice_No_"+bean.getCustomer().getCustomerDetail()+".pdf";

				try {
					Files.copy(file.toPath(), new File("C:\\Users\\bee\\Downloads\\"+outputfilename).toPath());
				} catch (Exception ex) {
					DialogAlerts.makeAlert("File Not Found", "Falied Saving File");
                                        ex.printStackTrace();
				}
			
		}


	}

    
	public void printBill(InvoiceInfo bean) {
		
		File file =new File("src/resources/INVOICE.pdf");
		boolean isGenrated =false;
	

		if(! (bean == null)) {
			isGenrated =InvoiceGenerator.makePDF(file, bean);
		}

		if(isGenrated) {

			DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
			PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
			patts.add(Sides.DUPLEX);
			PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
			PrintService myService = null;
			
			if (ps.length == 0) {
				DialogAlerts.makeAlert("Error", "Printer Not Found");
			}else {

				for (PrintService printService : ps) {
					System.out.println(printService);
					if (printService.getName().contains("Hp")) {
						myService = printService;
						break;
					}
				}
				
				if (myService == null) {
					DialogAlerts.makeAlert("Error", "Printer Not Found");
				}else {
					FileInputStream fis;
					try {
						fis = new FileInputStream(file);
						Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
						DocPrintJob printJob = myService.createPrintJob();
						printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
						fis.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} // end Print Job
			}

		}else {
			DialogAlerts.makeAlert("Error", "Printer not found");
		}

	}


	
}
