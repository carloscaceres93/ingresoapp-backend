package com.cidenet.ingreso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidenet.ingreso.model.Detalle;

public interface IDetalleRepository extends IGenericRepository<Detalle, Integer>{

	@Query("FROM Detalle d WHERE d.maestro.id = :idMaestro")
	List<Detalle> findByIdMaestro(@Param("idMaestro") Integer idMestro);
}
