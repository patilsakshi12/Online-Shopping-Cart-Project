package com.shopping.connectivity;

import java.util.List;

import com.shopping.model.Products;

public interface SearchConnectivity {
	 public List<Products> searchByProducts(String keyword);
}
