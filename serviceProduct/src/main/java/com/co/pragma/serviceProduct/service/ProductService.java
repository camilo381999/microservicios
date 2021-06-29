package com.co.pragma.serviceProduct.service;

import java.util.List;

import com.co.pragma.serviceProduct.entity.Category;
import com.co.pragma.serviceProduct.entity.Product;

public interface ProductService {
	
	public List<Product> listAllProducts();
	public Product getProduct(Long id);
	
	public Product createProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(Long id);
	public List<Product> findByCategory(Category categoria);
	public Product updateStock(Long id, Double quantity);

}
