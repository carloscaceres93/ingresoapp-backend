package com.cidenet.ingreso.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.exception.ModeloNotFoundException;
import com.cidenet.ingreso.model.Empleado;
import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.repository.IEmpleadoRepository;
import com.cidenet.ingreso.service.IEmpleadoService;
import com.cidenet.ingreso.service.IPaisService;
import com.cidenet.ingreso.util.UtilComponent;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadoServiceImpl.class);

	@Autowired
	private IEmpleadoRepository empleadoRepo;

	@Autowired
	private IPaisService paisService;
	
	@Autowired 
	private UtilComponent utilComponent;
	
	@Override
	public Empleado save(Empleado t) throws Exception {
		
		t.setEmail(this.construirEmail(t));
		return empleadoRepo.save(t);
	}

	@Override
	public Empleado modify(Empleado t) throws Exception {
		return empleadoRepo.save(t);
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		List<Empleado> empleados = empleadoRepo.findAll();
		String mensaje = "No se encontraron empleados disponibles";

//		verifica que la lista no este vacia
		if (empleados.isEmpty()) {
			LOGGER.warn(mensaje);

			throw new ModeloNotFoundException(mensaje);
		}
		return empleados;
	}

	@Override
	public Empleado findById(Integer id) throws Exception {
		Optional<Empleado> empleado = empleadoRepo.findById(id);
		String mensaje = "ERROR: El Empleado no existe en la base de datos; id: " + id;

		if (!empleado.isPresent()) {
			LOGGER.error(mensaje);
			throw new ModeloNotFoundException(mensaje);
		}
		return empleado.get();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Empleado empleado = empleadoRepo.findById(id).orElse(null);
		String mensaje = "Error al eliminar: El Empleado no existe en la base de datos id: " + id;

		if (empleado == null) {
			LOGGER.error(mensaje);
			throw new ModeloNotFoundException(mensaje);
		}
		empleadoRepo.deleteById(empleado.getId());
	}

	@Override
	public Page<Empleado> paginarlistaEmpleado(Pageable pageable) throws Exception {
		Page<Empleado> empleados = empleadoRepo.findAll(pageable);
		String mensaje = "No se encontraron empleados disponibles";

//		verifica que la lista no este vacia
		if (empleados.isEmpty()) {
			LOGGER.warn(mensaje);
			throw new ModeloNotFoundException(mensaje);
		}
		return empleados;
	}

	private String construirEmail(Empleado empleado) throws Exception {
		
		Pais pais = paisService.findById(empleado.getPais().getId());
		String dominio = pais.getDominio();
		String email = "";
		int validarEmail = 0;
		email = empleado.getPrimerNombre() + "." + empleado.getPrimerApellido();
		validarEmail = empleadoRepo.validarEmail(email);

		if (validarEmail > 0) {
			int id = validarEmail + 1;
			email += "" + id + "@" + dominio;
			return utilComponent.formatearEmail(email);
		} else {
			email += "@" + dominio;
			return utilComponent.formatearEmail(email);
		}
	}

}
