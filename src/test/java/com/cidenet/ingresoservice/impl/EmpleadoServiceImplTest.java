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
import com.cidenet.ingreso.model.Empleado;
import com.cidenet.ingreso.model.Maestro;
import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.repository.IEmpleadoRepository;
import com.cidenet.ingreso.service.IPaisService;
import com.cidenet.ingreso.service.impl.EmpleadoServiceImpl;
import com.cidenet.ingreso.util.UtilComponent;

public class EmpleadoServiceImplTest {

	private Empleado empleado;
	private Detalle detalle;
	private Pais pais;
	private Maestro maestro;

	@Mock
	private IEmpleadoRepository empleadoRepository;
	
	@Mock
	private IPaisService paisService;
	
	@Mock
	private UtilComponent utilComponent;

	@InjectMocks
	private EmpleadoServiceImpl empleadoService;

	@BeforeEach
	void init() throws Exception {
		MockitoAnnotations.initMocks(this);

		this.pais = new Pais(3, "Colombia", "CO", "cidenet.com.co");
		this.maestro = new Maestro(1, "preuba", "datos de prueba");
		this.detalle = new Detalle(1, "detalle prueba", "datos de prueba", maestro);
		
		this.empleado = new Empleado(1, "CACERES", "MOLANO", "CARLOS", "HUMBERTO", pais, detalle, "123456789", 
				"carlos.caceres@cidenet.com.co", null, detalle, detalle, null, null);
	
	}

	@Test
	void validarNoExisteEmpleadoTest() {
		when(empleadoRepository.save(empleado)).thenReturn(new Empleado());
		when(empleadoRepository.findById(empleado.getId())).thenReturn(Optional.empty());

		assertThrows(ModeloNotFoundException.class, () -> {
			empleadoService.findById(empleado.getId());
		});
	}

	@Test
	void validarGuardarEmpleadoTest() {
		empleado.setId(null);
		when(empleadoRepository.save(empleado)).thenReturn(new Empleado());
		assertTrue(empleado.getId() == null);
	}

	@Test
	void validarActualizarEmpleadoTest() {
		when(empleadoRepository.save(empleado)).thenReturn(new Empleado());
		assertTrue(empleado.getId() > 0);
	}

	@Test
	void validarEliminarEmpleadoTest() throws Exception {
		when(empleadoRepository.findById(empleado.getId())).thenReturn(Optional.of(empleado));
		empleadoService.delete(empleado.getId());
	}

	@Test
	void validarListarTodoEmpleadoTest() throws Exception {
		List<Empleado> empleados = new ArrayList<>();
		empleados.add(empleado);
		when(empleadoRepository.findAll()).thenReturn(empleados);

		assertTrue(!empleados.isEmpty());
	}

	@Test
	void validarNoHayElementosEmpleadoTest() throws Exception {
		List<Empleado> empleados = new ArrayList<>();
		when(empleadoRepository.findAll()).thenReturn(empleados);

		assertThrows(ModeloNotFoundException.class, () -> {
			empleadoService.findAll();
		});
	}
	
	@Test
	void validarExisteEmailEmpleado() {
		when(empleadoRepository.validarEmail(empleado.getEmail())).thenReturn(1);
		assertTrue(empleadoRepository.validarEmail(empleado.getEmail()) > 0);
	}
	
	@Test
	void validarCadenaEmailEmpleado() {
//		 String emailEsperado = utilComponent.formatearEmail(empleado.getPrimerNombre() + "." + empleado.getPrimerApellido());
//		 empleadoService.
////		when(empleadoService.  (empleado.getEmail())).thenReturn(1);
////		assertTrue(empleadoRepository.validarEmail(empleado.getEmail()) > 0);
	}
}
