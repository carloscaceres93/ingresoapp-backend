package com.cidenet.ingreso.service;

import java.util.List;

import com.cidenet.ingreso.model.Detalle;

public interface IDetalleService extends ICRUDService<Detalle, Integer> {

	List<Detalle> findByIdMestro(Integer idMaestro);
}
