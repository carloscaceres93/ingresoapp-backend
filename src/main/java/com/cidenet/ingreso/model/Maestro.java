package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
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
}
