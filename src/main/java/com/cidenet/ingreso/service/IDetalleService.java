package com.cidenet.ingreso.service;

import java.util.List;

import com.cidenet.ingreso.model.Detalle;

public interface IDetalleService {

	List<Detalle> findAllArea() throws Exception;

	List<Detalle> findAllTipoIdentificacion()throws Exception;
	
	Detalle findById(Integer id) throws Exception;

}
