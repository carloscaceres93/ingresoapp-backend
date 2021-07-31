package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(catalog = "cidenet_db")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20, nullable = false)
	private String nombre;

	@Column(length = 2, nullable = false)
	private String abreviatura;

	@Column(length = 20, nullable = false)
	private String dominio;

	public Pais(Integer id, String nombre, String abreviatura, String dominio) {
		this.id = id;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.dominio = dominio;
	}

}
