package com.trango.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;

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
import com.trango.app.model.InvoiceInfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class InvoiceUtiils {

	
    
	public void saveBill(InvoiceInfo bean) {		
		File file =new File(getClass().getResource("/resources/others/INVOICE.pdf").getFile());
                
                //file =new File("/Users/bilaliqbal/NetBeansProjects/FXApplication/src/resources/others/INVOICE.pdf");
		
                System.out.println("File>"+file.getName());
                
                boolean isGenrated =false;


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
