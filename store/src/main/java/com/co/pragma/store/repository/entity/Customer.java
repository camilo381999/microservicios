package com.co.pragma.store.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El numero de documento no puede ser vacio")
	@Size(min = 8, max = 8, message = "El numero de documento debe tener al menos 8 digitos")
	@Column(name = "number_id", unique = true, length = 8, nullable = false)
	private String numberID;

	@NotEmpty(message = "El nombre no puede ser vacio")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty(message = "El apellido no puede ser vacio")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotEmpty(message = "El nombrcorreo no puede ser vacio")
	@Email(message = "no es una direccion valida")
	@Column(unique = true, nullable = false)
	private String email;

	@Column(name = "photo_url")
	private String photoUrl;

	@NotNull(message = "La region es un campo obligatorio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Region region;
	
	private String state;

}
