/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trango.app.database;

import com.trango.app.model.ProductInfo;
import com.trango.app.model.SaleInfo;
import static com.trango.application.DBLiterals.COLUMN_CUSTOMER_DETAILS;
import static com.trango.application.DBLiterals.COLUMN_DATE_TIME;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_CATEGORY;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_ID;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_NAME;
import static com.trango.application.DBLiterals.COLUMN_NUMBER_OF_UNITS;
import static com.trango.application.DBLiterals.COLUMN_PRODUCT_DETAILS;
import static com.trango.application.DBLiterals.COLUMN_SALE_ID;
import static com.trango.application.DBLiterals.COLUMN_TOTAL_PRICE;
import static com.trango.application.DBLiterals.COLUMN_UNIT_PRICE;
import com.trango.application.ResourceManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bilaliqbal
 */
public class InventoryDao {

	public String getProductId(String productName) throws Exception {
		PreparedStatement statement;
		ResultSet rs;
		String productid = "000";
		String exitstquery = "SELECT * from inventory WHERE product_name=?";
		statement = ResourceManager.getConnection().prepareStatement(exitstquery);
		statement.setString(1, productName.trim());
		rs = statement.executeQuery();
		if (rs.next()) {
			productid = rs.getString("product_id");
		}
		return productid;
	}

	public int getProductCount(String productname) throws Exception {
		int productCount = 0;
		try {
			PreparedStatement statement;
			String sql = "select * from INVENTORY where product_name=?";
			statement = ResourceManager.getConnection().prepareStatement(sql);
			statement.setString(1, productname);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				productCount = rs.getInt("no_of_units");

			}
			return productCount;
		} catch (SQLException ex) {

		}
		return 0;
	}

	public List<String> getProductList(String keyword) throws Exception {

		List<String> productnameList = new ArrayList<>();
		try {
			PreparedStatement statement;
			String sql = "select * from INVENTORY where product_details  like?";
			statement = ResourceManager.getConnection().prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				productnameList.add(rs.getString("product_name"));
				System.out.println(rs.getString("product_details"));

			}

		} catch (SQLException ex) {

		}
		return productnameList;
	}

	public List<ProductInfo> getProductDataList() throws Exception {
		List<ProductInfo> productlist = new ArrayList<>();

		try {
			PreparedStatement statement;
			String sql = "select * from INVENTORY";
			statement = ResourceManager.getConnection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				productlist.add(new ProductInfo(rs.getString("product_id"), rs.getString("product_name"),rs.getString("product_type"), rs.getInt("no_of_units")));

			}

		} catch (SQLException ex) {

		}
		return productlist;
	}

	
	
	public List<ProductInfo> getAvailableInventory() throws ClassNotFoundException, SQLException, Exception {
		List<ProductInfo> availableInventory = new ArrayList<>();

		String productid = null;
		String productname = null;
		String productcategory = null;


		double unitprice;
		int noofunits;
		double totalprice;



		String sql = "SELECT * FROM INVENTORY";
	




		ProductInfo product;
		Statement statement = null;

	

		try {
			statement = ResourceManager.getConnection().createStatement();
			ResultSet resultset = statement.executeQuery(sql);

			while (resultset.next()) {
				productid = resultset.getString(COLUMN_PRODUCT_ID);
				productname = resultset.getString(COLUMN_PRODUCT_NAME);
				productcategory = resultset.getString(COLUMN_PRODUCT_CATEGORY);
				unitprice = resultset.getDouble(COLUMN_UNIT_PRICE);
				noofunits = resultset.getInt(COLUMN_NUMBER_OF_UNITS);
				totalprice = resultset.getDouble(COLUMN_TOTAL_PRICE);
				product = new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits,totalprice);
				availableInventory.add(product);
				


			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			statement.close();

		}

		return availableInventory;
	}

	public List<ProductInfo> getAvailableInventory(String keyword) throws ClassNotFoundException, SQLException, Exception {
		List<ProductInfo> availableInventory = new ArrayList<>();

		String productid = null;
		String productname = null;
		String productcategory = null;


		double unitprice;
		int noofunits;
		double totalprice;


		String sql = "SELECT * FROM INVENTORY where product_details like ?";


		ProductInfo product;
		PreparedStatement statement = null;

		try {
			statement = ResourceManager.getConnection().prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				productid = resultset.getString(COLUMN_PRODUCT_ID);
				productname = resultset.getString(COLUMN_PRODUCT_NAME);
				productcategory = resultset.getString(COLUMN_PRODUCT_CATEGORY);
				unitprice = resultset.getDouble(COLUMN_UNIT_PRICE);
				noofunits = resultset.getInt(COLUMN_NUMBER_OF_UNITS);
				totalprice = resultset.getDouble(COLUMN_TOTAL_PRICE);
		

				product = new ProductInfo(productid, productname, "Battery", productcategory, 0, unitprice, noofunits,totalprice);
				availableInventory.add(product);
	

			}
	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			statement.close();

		}

		return availableInventory;
	}

	public List<SaleInfo> getSoldInventory() throws ClassNotFoundException, SQLException, Exception {
		String productid = "";
                String saleid="";
		String productDetails = "";
                String customerDetails="";
		String productcategory = "";
		double unitprice;
		int noofunits;
		double totalprice;

		String datetime = "";

		List<SaleInfo> soldInventory = new ArrayList<>();

		String sql = "SELECT * FROM SALE";


		Statement statement = null;
		SaleInfo soldItem;
		try {

			statement = ResourceManager.getConnection().createStatement();
			ResultSet resultset = statement.executeQuery(sql);

			while (resultset.next()) {
				productid = resultset.getString(COLUMN_PRODUCT_ID);
                                saleid=resultset.getString(COLUMN_SALE_ID);
				productDetails = resultset.getString(COLUMN_PRODUCT_DETAILS);
                                customerDetails = resultset.getString(COLUMN_CUSTOMER_DETAILS);
				productcategory = resultset.getString(COLUMN_PRODUCT_CATEGORY);
				unitprice = resultset.getDouble(COLUMN_UNIT_PRICE);
				noofunits = resultset.getInt(COLUMN_NUMBER_OF_UNITS);
				totalprice = resultset.getDouble(COLUMN_TOTAL_PRICE);
				datetime = resultset.getString(COLUMN_DATE_TIME);
                                
                                
                                

       


				
				try{
					soldItem = new SaleInfo(productid, productDetails, customerDetails, productcategory,datetime, 0, unitprice, noofunits,totalprice);
					soldInventory.add(soldItem);
				}
				catch(Exception e) {e.printStackTrace();}
	
				
				//System.out.println(product.toString());

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			statement.close();

		}

		return soldInventory;
	}

	public List<SaleInfo> getSoldInventory(String keyword) throws ClassNotFoundException, SQLException, Exception {
		String productid = null;
		String productname = null;
		String productcategory = null;
                String customerDetails="";
		String productDetails = "";

		double unitprice;
		int noofunits;
		double totalprice;

		String datetime = null;

		List<SaleInfo> soldInventory = new ArrayList<>();

		String sql = "SELECT * FROM SALE where product_name like ?";

		PreparedStatement statement = null;
		SaleInfo soldItem;
		try {

			statement = ResourceManager.getConnection().prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				productid = resultset.getString(COLUMN_PRODUCT_ID);
				productDetails = resultset.getString(COLUMN_PRODUCT_NAME);
                                customerDetails = resultset.getString(COLUMN_PRODUCT_NAME);
				productcategory = resultset.getString(COLUMN_PRODUCT_CATEGORY);
				unitprice = resultset.getDouble(COLUMN_UNIT_PRICE);
				noofunits = resultset.getInt(COLUMN_NUMBER_OF_UNITS);
				totalprice = resultset.getDouble(COLUMN_TOTAL_PRICE);
				datetime = resultset.getString(COLUMN_DATE_TIME);

				soldItem = new SaleInfo(productid, productDetails, "Battery", productcategory,datetime, 0, unitprice, noofunits,totalprice);
					soldInventory.add(soldItem);


			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			statement.close();

		}

		return soldInventory;
	}

}
