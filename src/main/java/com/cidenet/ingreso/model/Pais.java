package com.cidenet.ingreso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

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

	@NotNull
	@Pattern(regexp="^[A-Z ]+$",message="El 'NOMBRE' solo admite letras mayusculas, no puede contener asentos ni ñ")
	@Size(min = 4, max = 20, message = "El 'NOMBRE' de conetener entre 4 y 20 letras")
	@Column(length = 20, nullable = false)
	private String nombre;

	@NotNull
	@Pattern(regexp="^[A-Z]+$",message="La  'ABREVIATURA' solo admite letras mayusculas, no puede contener asentos, espacios ni ñ")
	@Size(max = 2, message = "La  'ABREVIATURA' debe tener minimo 2 letras")
	@Column(length = 2, nullable = false)
	private String abreviatura;

	@NotNull
	@Size(min = 7, max = 20, message = "El 'DOMINIO' debe tener entre 7 a 20 letras")
	@Column(length = 20, nullable = false)
	private String dominio;

	public Pais(Integer id, String nombre, String abreviatura, String dominio) {
		this.id = id;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.dominio = dominio;
	}

}
