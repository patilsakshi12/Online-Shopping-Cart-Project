package com.shopping.connectivity;
import com.shopping.model.*;
import java.util.List;

public interface ProductConnectivity {
 public List<Products> getAllProduct();

public boolean addProduct(Products p);

public Products getProductById(int id);

public boolean updateProduct(Products p);

public boolean deleteProduct(int id);
}
