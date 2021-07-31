package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(catalog = "cidenet:db")
public class Maestro {

	@Id
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(length = 50, nullable = false)
	private String descripcion;

	public interface ID {
		int ESTADO = 1;
		int TIPO_IDENTIFICACION = 2;
		int AREA = 3;
	}

	public Maestro(Integer id) {
		super();
		this.id = id;
	}
}
