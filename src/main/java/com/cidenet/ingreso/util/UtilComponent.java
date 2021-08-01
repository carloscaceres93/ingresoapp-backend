package com.cidenet.ingreso.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class UtilComponent {

	public Boolean validarFechaIngreso(LocalDate fecha) {
		LocalDate fechaActual = LocalDate.now();

		if (fecha.isBefore((fechaActual.minusMonths(1)))) {
			return false;

		} else if (fecha.isAfter(fechaActual)) {
			return false;

		} else {
			return true;
		}
	}

	public String formatearEmail(String email) {
		String emailFormat = email.replace(" ", "");
		email = emailFormat.toLowerCase();

		return email;
	}
}
