package com.shopping.logic;
import com.shopping.connectivity.*;
import com.shopping.database.*;
import java.util.List;

import com.shopping.model.*;
public class ProductBussinessLogic {

	public List<Products> getProducts() {
		// TODO Auto-generated method stub
		ProductConnectivity ref=new ProductDatabase();
		return ref.getAllProduct();
	}
	
	public List<Products> searchProducts(String keyword){
		SearchConnectivity ref=new SearchDatabase();
		return ref.searchByProducts(keyword);
		
	}

	public boolean addProduct(Products p) {
		// TODO Auto-generated method stub
		 ProductConnectivity ref =
		            new ProductDatabase();

		    return ref.addProduct(p);
	}

	public Products getProductById(int id) {

	    ProductConnectivity dao = new ProductDatabase();

	    return dao.getProductById(id);
	}

	public boolean updateProduct(Products p) {
		// TODO Auto-generated method stub
		  ProductConnectivity dao = new ProductDatabase();
		  return dao.updateProduct(p);
	}

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		 ProductConnectivity dao = new ProductDatabase();
		return dao.deleteProduct(id);
	}
}
