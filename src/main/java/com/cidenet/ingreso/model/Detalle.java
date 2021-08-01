package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(catalog = "cidenet_db")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@NotNull
	@Column(length = 50, nullable = false)
	private String descripcion;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_maestro", nullable = false)
	private Maestro maestro;

	public Detalle(Integer id, String nombre, String descripcion, Maestro maestro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.maestro = maestro;
	}
	
	
}
