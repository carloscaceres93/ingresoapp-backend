package com.cidenet.ingreso.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cidenet.ingreso.model.Empleado;

public interface IEmpleadoRepository extends IGenericRepository<Empleado, Integer>{

	@Query(value = "SELECT COUNT(e.id) FROM empleado e WHERE e.email LIKE CONCAT(:nombres,'%')", nativeQuery = true)
	Integer validarEmail(@Param("nombres") String nombres);
}
