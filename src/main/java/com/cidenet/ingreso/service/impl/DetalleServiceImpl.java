package com.cidenet.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.model.Detalle;
import com.cidenet.ingreso.model.Maestro;
import com.cidenet.ingreso.repository.IDetalleRepository;
import com.cidenet.ingreso.service.IDetalleService;

@Service
public class DetalleServiceImpl implements IDetalleService {

	@Autowired
	private IDetalleRepository detalleRepo;

	@Override
	public List<Detalle> findAllArea() {
		return detalleRepo.findByIdMaestro(Maestro.ID.AREA);
	}

	@Override
	public List<Detalle> findAllTipoDocumento() {
		return detalleRepo.findByIdMaestro(Maestro.ID.TIPO_IDENTIFICACION);
	}

}
