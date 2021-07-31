package com.cidenet.ingreso.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cidenet.ingreso.model.Empleado;

public interface IEmpleadoService extends ICRUDService<Empleado, Integer> {

	Page<Empleado> paginarlistaEmpleado(Pageable pageable) throws Exception;
}
