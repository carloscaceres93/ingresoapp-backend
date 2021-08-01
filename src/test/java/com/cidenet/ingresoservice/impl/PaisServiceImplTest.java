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
import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.repository.IPaisRepository;
import com.cidenet.ingreso.service.impl.PaisServiceImpl;

public class PaisServiceImplTest {
	
	private Pais pais;
	
	@Mock
	private IPaisRepository paisRepository;

	@InjectMocks
	private PaisServiceImpl paisService;
	
	@BeforeEach
	void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		pais = new Pais( 3,"Colombia", "CO", "cidenet.com.co");
	}
	
	@Test
	void validarNoExistePaisTest() {
		when(paisRepository.save(pais)).thenReturn(new Pais());
		when(paisRepository.findById(pais.getId())).thenReturn(Optional.empty());
		
		assertThrows(ModeloNotFoundException.class, () ->{
			paisService.findById(pais.getId());
		});
	}
	
	@Test
	void validarGuardarPaisTest() {
		pais.setId(null);
		when(paisRepository.save(pais)).thenReturn(new Pais());
		assertTrue(pais.getId() ==  null);
	}
	
	@Test
	void validarActualizarPaisTest() {
		when(paisRepository.save(pais)).thenReturn(new Pais());
		assertTrue(pais.getId() >0);
	}
	
	@Test
	void validarEliminarPaisTest() throws Exception {
		when(paisRepository.findById(pais.getId())).thenReturn(Optional.of(pais));
		paisService.delete(pais.getId());
	}
	
	@Test
	void validarListarTodoPaisTest() throws Exception {
		List<Pais> paises = new ArrayList<>();
		paises.add(pais);
		when(paisRepository.findAll()).thenReturn(paises);
		
		assertTrue(!paises.isEmpty());
	}
	
	@Test
	void validarNoHayElementosPaisTest() throws Exception {
		List<Pais> paises = new ArrayList<>();
		when(paisRepository.findAll()).thenReturn(paises);
		
		assertThrows(ModeloNotFoundException.class, ()->{
			paisService.findAll();
		});
	}
}
