package com.cidenet.ingreso.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(catalog = "cidenet_db")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20, nullable = false)
	private String primerApellido;

	@Column(length = 20, nullable = false)
	private String segundoApellido;

	@Column(length = 20, nullable = false)
	private String primerNombre;

	@Column(length = 50, nullable = false)
	private String otroNombre;

	@ManyToOne
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	@ManyToOne
	@JoinColumn(name = "id_tipo_identificacion", nullable = false)
	private Detalle tipoIdentificacion;

	@Column(length = 20, nullable = false)
	private String numeroIdentificacion;

	@Email
	@Column(length = 300, nullable = false)
	private String email;

	@JsonFormat(pattern = "DD/MM/YYYY")
	@Column(nullable = false)
	private LocalDate fechaIngreso;

	@ManyToOne
	@JoinColumn(name = "id_area", nullable = false)
	private Detalle area;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Detalle estado;

	@JsonFormat(pattern = "DD/MM/YYYY HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime fechaHoraRegistro;

	@JsonFormat(pattern = "DD/MM/YYYY HH:mm:ss")
	@Column(nullable = false)
	private LocalDateTime fechaHoraEdicion;

	public Empleado(Integer id, String primerApellido, String segundoApellido, String primerNombre, String otroNombre,
			Pais pais, Detalle tipoIdentificacion, String numeroIdentificacion, @Email String email,
			LocalDate fechaIngreso, Detalle area, Detalle estado, LocalDateTime fechaHoraRegistro,
			LocalDateTime fechaHoraEdicion) {
		super();
		this.id = id;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.primerNombre = primerNombre;
		this.otroNombre = otroNombre;
		this.pais = pais;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.email = email;
		this.fechaIngreso = fechaIngreso;
		this.area = area;
		this.estado = estado;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.fechaHoraEdicion = fechaHoraEdicion;
	}

}
