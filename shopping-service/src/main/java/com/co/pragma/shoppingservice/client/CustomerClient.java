package com.co.pragma.shoppingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.pragma.shoppingservice.model.Customer;

@FeignClient(name = "costumer-service")
@RequestMapping("/customers")
public interface CustomerClient {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable(name="id") long id);

}
