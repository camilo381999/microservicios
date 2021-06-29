package com.co.pragma.store.service;

import java.util.List;

import com.co.pragma.store.repository.entity.Customer;
import com.co.pragma.store.repository.entity.Region;

public interface CustomerService {

	public List<Customer> findCustomerAll();

	public List<Customer> findCustomerByRegion(Region region);

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public Customer getCustomer(Long id);
}
