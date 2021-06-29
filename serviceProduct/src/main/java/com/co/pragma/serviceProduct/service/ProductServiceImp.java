package com.co.pragma.serviceProduct.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.pragma.serviceProduct.entity.Category;
import com.co.pragma.serviceProduct.entity.Product;
import com.co.pragma.serviceProduct.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {
	
	private final ProductRepository productRepository;

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product createProduct(Product product) {
		product.setEstado("Creado");
		product.setFechaCreacion(new Date());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productDB = getProduct(product.getId());
		if (null==productDB) {
			return null;
		}
		productDB.setName(product.getName());
		productDB.setDescripcion(product.getDescripcion());
		productDB.setCategoria(product.getCategoria());
		productDB.setPrecio(product.getPrecio());
		return productRepository.save(productDB);
	}

	@Override
	public Product deleteProduct(Long id) {
		Product productDB = getProduct(id);
		if (null==productDB) {
			return null;
		}
		productDB.setEstado("Eliminado");
		return productRepository.save(productDB);
	}

	@Override
	public List<Product> findByCategory(Category categoria) {
		return productRepository.findByCategoria(categoria);
	}

	@Override
	public Product updateStock(Long id, Double quantity) {
		Product productDB = getProduct(id);
		if (null==productDB) {
			return null;
		}
		Double stock=productDB.getStock()+quantity;
		productDB.setStock(stock);
		return productRepository.save(productDB);
	}

}
