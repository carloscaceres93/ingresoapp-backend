package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(catalog = "cidenet_db")
public class Maestro {

	@Id
	private Integer id;

	@NotNull
	@Column(length = 50, nullable = false)
	private String nombre;

	@NotNull
	@Column(length = 50, nullable = false)
	private String descripcion;

	public Maestro(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
}
