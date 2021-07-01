package com.co.pragma.shoppingservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
	
	private Long id;
	private String name;
	private String descripcion;
	private double stock;
	private double precio;
	private String estado;
	private Category categoria;
}
