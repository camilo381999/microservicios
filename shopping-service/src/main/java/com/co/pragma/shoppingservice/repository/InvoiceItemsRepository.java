package com.co.pragma.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.pragma.shoppingservice.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
	
}
