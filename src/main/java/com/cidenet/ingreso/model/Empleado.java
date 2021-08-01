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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(catalog = "cidenet_db")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "El  'PRIMER APELLIDO' no puede estar vacío")
	@Pattern(regexp = "^[A-Z ]+$", message = "El  'PRIMER APELLIDO' solo admite letras mayúsculas, no puede contener acentos o carateres especiales")
	@Size(max = 20, message = "EL 'PRIMER APELLIDO' debe contener entre 4 y 20 letras")
	@Column(length = 20, nullable = false)
	private String primerApellido;

	@Pattern(regexp = "^[A-Z ]+$", message = "El  'SEGUNDO APELLIDO' solo admite letras mayúsculas, no puede contener acentos o carateres especiales")
	@Size(max = 20, message = "EL 'SEGUNDO APELLIDO' debe contener entre 4 y 20 letras")
	@Column(length = 20)
	private String segundoApellido;

	@NotNull(message = "El  'PRIMER NOMBRE' no puede estar vacío")
	@Pattern(regexp = "^[A-Z]+$", message = "el  'PRIMER NOMBRE' solo admite letras mayúsculas, no puede contener acentos, espacios o carateres especiales")
	@Size(max = 20, message = "EL 'PRIMER NOMBRE' debe contener entre 4 y 20 letras")
	@Column(length = 20, nullable = false)
	private String primerNombre;

	
	@Pattern(regexp="^[A-Z ]+$",message="el campo 'OTRO NOMBRE' solo admite letras mayusculas, no puede contener asentos o carateres especiales")
	@Size(max = 50,message = "EL campo 'OTRO NOMBRE' debe contener entre 4 y 20 letras")
	@Column(length = 50)
	private String otroNombre;

	@NotNull(message = "El campo 'PAIS' no puede estar vacío")
	@ManyToOne
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	@NotNull(message = "El campo 'TIPO IDENTIFICACION' no puede estar vacío")
	@ManyToOne
	@JoinColumn(name = "id_tipo_identificacion", nullable = false)
	private Detalle tipoIdentificacion;

	@NotNull(message = "El campo 'IDENTIFICACION' no puede estar vacío")
	@Pattern(regexp="^[a-zA-Z0-9-]+$",message="El campo 'NUMERO IDENTIFICACION' solo admite caracteres alfanuméricos y guion (-)")
	@Column(length = 20, nullable = false, unique = true)
	private String numeroIdentificacion;
	
	@Email(message = "el campo 'EMAIL' debe ser una dirección válida")
	@Column(length = 300, nullable = false, unique = true)
	private String email;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column
	private LocalDate fechaIngreso;

	@NotNull(message = "El campo 'AREA' no puede estar vacío")
	@ManyToOne
	@JoinColumn(name = "id_area", nullable = false)
	private Detalle area;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Detalle estado;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column
	private LocalDateTime fechaHoraRegistro;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column
	private LocalDateTime fechaHoraEdicion;

}
