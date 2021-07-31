package com.cidenet.ingreso.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class UtilComponent {

	public LocalDateTime formatearFechaHora(LocalDateTime fechaHora) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY HH:mm:ss");
		String dateTimest = now.format(formatter);
		fechaHora = LocalDateTime.parse(dateTimest, formatter);

		return fechaHora;
	}

	public LocalDate formatearFecha(LocalDate fecha) {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
		String dateTimeStr = now.format(formatter);
		fecha = LocalDate.parse(dateTimeStr, formatter);

		return fecha;
	}

	public Boolean validarFechaIngreso(LocalDate fecha) {
		Boolean validar = null;

		LocalDate fechaActual = LocalDate.now();

		if (fecha.isBefore((fechaActual.minusMonths(1))) && fecha.isAfter(fechaActual)) {
			validar = false;

		} else {
			validar = true;
		}

		return validar;
	}

	public String formatearEmail(String email) {
		email.toLowerCase();
		email.trim();
		
		return email;
	}
}
