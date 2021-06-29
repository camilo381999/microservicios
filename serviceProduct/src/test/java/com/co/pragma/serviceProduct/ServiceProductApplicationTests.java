package com.co.pragma.serviceProduct;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.co.pragma.serviceProduct.entity.Category;
import com.co.pragma.serviceProduct.entity.Product;
import com.co.pragma.serviceProduct.repository.ProductRepository;

@SpringBootTest
class ServiceProductApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void whenFindByCategory_ReturnListProducts() {
		Product product01=Product.builder()
				.name("computer")
				.categoria(Category.builder().id(1L).build())
				.descripcion("")
				.stock(Double.parseDouble("10"))
				.precio(Double.parseDouble("20580.99"))
				.estado("Creado")
				.fechaCreacion(new Date()).build();
		
		productRepository.save(product01);
		
		List<Product> founds= productRepository.findByCategoria(product01.getCategoria());
		
		Assertions.assertThat(founds.size()).isEqualTo(3);
	}

}
