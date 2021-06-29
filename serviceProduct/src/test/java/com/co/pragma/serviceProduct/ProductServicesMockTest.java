package com.co.pragma.serviceProduct;

import static org.mockito.Mockito.mockitoSession;

import java.util.Date;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.pragma.serviceProduct.entity.Category;
import com.co.pragma.serviceProduct.entity.Product;
import com.co.pragma.serviceProduct.repository.ProductRepository;
import com.co.pragma.serviceProduct.service.ProductService;
import com.co.pragma.serviceProduct.service.ProductServiceImp;

@SpringBootTest
public class ProductServicesMockTest {

	@Mock
	private ProductRepository productRepository;

	private ProductService productService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		productService = new ProductServiceImp(productRepository);
		
		Product computer=Product.builder()
				.id(5L)
				.name("computer")
				.categoria(Category.builder().id(1L).build())
				.precio(Double.parseDouble("205.99"))
				.stock(Double.parseDouble("10"))
				.build();
		
		Mockito.when(productRepository.findById(5L)).thenReturn(Optional.of(computer));
		Mockito.when(productRepository.save(computer)).thenReturn(computer);
	}
	
	@Test
	public void whenValidGetId_ThenThenReturnProduct() {
		Product found = productService.getProduct(5L);
		Assertions.assertThat(found.getName()).isEqualTo("computer");
	}
	
	
	public void whenValidUpdateStock_thenReturnNewStock() {
		Product newStock =  productService.updateStock(5L, Double.parseDouble("8"));
		Assertions.assertThat(newStock.getStock()).isEqualTo(13);
	}
	
}