package com.cidenet.ingreso.service;

import java.util.List;

import com.cidenet.ingreso.model.Detalle;

public interface IDetalleService {

	List<Detalle> findAllArea();

	List<Detalle> findAllTipoDocumento();

}
