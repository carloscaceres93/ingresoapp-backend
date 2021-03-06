package com.cidenet.ingreso.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.exception.ModeloNotFoundException;
import com.cidenet.ingreso.model.Detalle;
import com.cidenet.ingreso.repository.IDetalleRepository;
import com.cidenet.ingreso.service.IDetalleService;
import com.cidenet.ingreso.util.Constantes;

@Service
public class DetalleServiceImpl implements IDetalleService {

	@Autowired
	private IDetalleRepository detalleRepo;

	@Override
	public List<Detalle> findAllArea() throws Exception {
		List<Detalle> areas = detalleRepo.findByIdMaestro(Constantes.MAESTRO.AREA);

		if (areas.isEmpty()) {
			throw new ModeloNotFoundException("No se encontraron areas disponibles");
		}
		return areas;
	}

	@Override
	public List<Detalle> findAllTipoIdentificacion() throws Exception {
		List<Detalle> tiposIdentificacion = detalleRepo.findByIdMaestro(Constantes.MAESTRO.TIPO_IDENTIFICACION);

		if (tiposIdentificacion.isEmpty()) {
			throw new ModeloNotFoundException("No se encontraron tipos de identificacion disponibles");
		}
		return tiposIdentificacion;
	}

	@Override
	public Detalle findById(Integer id) throws Exception {
		Optional<Detalle> detalle = detalleRepo.findById(id);
		if(!detalle.isPresent()) {
			throw new ModeloNotFoundException("NO existe el elemento; id:" + id);
		}
		return detalleRepo.findById(id).orElse(null);
	}

}
