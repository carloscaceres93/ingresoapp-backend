package com.cidenet.ingreso.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UtilComponentTest {

	@Mock
	private UtilComponent utilComponent;
	
	@BeforeEach
	void init() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void validarFechaCorrectaTets() {
		LocalDate fhecha = LocalDate.now();
		when(utilComponent.validarFechaIngreso(fhecha)).thenReturn(true);
		assertTrue(utilComponent.validarFechaIngreso(fhecha));
	}
	
	@Test
	void validarFechaEsMayorTets() {
		LocalDate fhecha = LocalDate.now().plusDays(5);
		when(utilComponent.validarFechaIngreso(fhecha)).thenReturn(false);
		
		assertFalse(utilComponent.validarFechaIngreso(fhecha));
	}
	
	@Test
	void validarFechaEsMenorMasdeUnMsTets() {
		LocalDate fhecha = LocalDate.now().minusMonths(2);
		when(utilComponent.validarFechaIngreso(fhecha)).thenReturn(false);
		
		assertFalse(utilComponent.validarFechaIngreso(fhecha));
	}
}
