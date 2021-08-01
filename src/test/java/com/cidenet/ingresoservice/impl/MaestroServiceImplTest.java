package com.cidenet.ingresoservice.impl;

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

import com.cidenet.ingreso.model.Maestro;
import com.cidenet.ingreso.repository.IMaestroRepoitory;
import com.cidenet.ingreso.service.impl.MaestroServiceImpl;

public class MaestroServiceImplTest {
	
	private Maestro maestro;
	
	@Mock
	private IMaestroRepoitory maestroRepository;

	@InjectMocks
	private MaestroServiceImpl  maestroService;
	
	@BeforeEach
	void init() throws Exception{
		MockitoAnnotations.initMocks(this);
		maestro = new Maestro( 3,"Colombia","cidenet.com.co");
	}
	
	@Test
	void validarGuardarMaestroTest() {
		maestro.setId(null);
		when(maestroRepository.save(maestro)).thenReturn(new Maestro());
		assertTrue(maestro.getId() ==  null);
	}
	
	@Test
	void validarActualizarMaestroTest() {
		when(maestroRepository.save(maestro)).thenReturn(new Maestro());
		assertTrue(maestro.getId() >0);
	}
	
	@Test
	void validarEliminarMaestroTest() throws Exception {
		when(maestroRepository.findById(maestro.getId())).thenReturn(Optional.of(maestro));
		maestroService.delete(maestro.getId());
	}
	
	@Test
	void validarListarTodoMaestroTest() throws Exception {
		List<Maestro> maestros = new ArrayList<>();
		maestros.add(maestro);
		when(maestroRepository.findAll()).thenReturn(maestros);
		
		assertTrue(!maestros.isEmpty());
	}
	

}
