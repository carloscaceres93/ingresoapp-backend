package com.cidenet.ingresoservice.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cidenet.ingreso.exception.ModeloNotFoundException;
import com.cidenet.ingreso.model.Detalle;
import com.cidenet.ingreso.model.Maestro;
import com.cidenet.ingreso.repository.IDetalleRepository;
import com.cidenet.ingreso.service.impl.DetalleServiceImpl;

public class DetalleServiceImplTest {
	
	private Detalle detalle;
	private Maestro maestro;
	
	@Mock
	private IDetalleRepository detalleRepository;

	@InjectMocks
	private DetalleServiceImpl detalleService;
	
	@BeforeEach
	void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		
		 this.maestro = new Maestro(1, "preuba", "datos de prueba");
		this.detalle = new Detalle(1, "detalle prueba", "datos de prueba", maestro);
	}
	
	
	@Test
	void validarListarPorMaestroTest() throws Exception {
		List<Detalle> detalles = new ArrayList<>();
		detalles.add(detalle);
		when(detalleRepository.findByIdMaestro(maestro.getId())).thenReturn(detalles);
		
		assertTrue(!detalles.isEmpty());
	}
	
	@Test
	void validarNoHayElementosTest() throws Exception {
		List<Detalle> detalles = new ArrayList<>();
		when(detalleRepository.findByIdMaestro(maestro.getId())).thenReturn(detalles);
		
		assertThrows(ModeloNotFoundException.class, ()->{
			detalleService.findAllArea();
			detalleService.findAllTipoIdentificacion();
		});
	}
	
	@Test
	void validarErrorNoExisteIdDetalleTest() {
		detalle.setId(null);
		when(detalleRepository.findById(maestro.getId())).thenReturn(Optional.empty());
		
		assertThrows(ModeloNotFoundException.class, ()->{
			detalleService.findById(detalle.getId());
		});
	}
	
	@Test
	void validarlistarIdDetalleTest() {
		when(detalleRepository.findById(maestro.getId())).thenReturn(Optional.of(detalle));
		assertTrue(detalle != null);
	}
}
