package com.co.pragma.serviceProduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.pragma.serviceProduct.entity.Category;
import com.co.pragma.serviceProduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByCategoria(Category categoria);
	
}
