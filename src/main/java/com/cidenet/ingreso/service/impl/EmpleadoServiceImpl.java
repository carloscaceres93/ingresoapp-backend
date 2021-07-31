package com.cidenet.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.model.Empleado;
import com.cidenet.ingreso.repository.IEmpleadoRepository;
import com.cidenet.ingreso.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	private IEmpleadoRepository empleadoRepo;;
	
	@Override
	public Empleado save(Empleado t) throws Exception {
		return empleadoRepo.save(t);
	}

	@Override
	public Empleado modify(Empleado t) throws Exception {
		return empleadoRepo.save(t);
	}

	@Override
	public List<Empleado> findAll() throws Exception {
		return empleadoRepo.findAll();
	}

	@Override
	public Empleado findById(Integer id) throws Exception {
		return empleadoRepo.findById(id).orElseThrow();
	}

	@Override
	public void delete(Integer id) throws Exception {
		empleadoRepo.deleteById(id);
	}

	@Override
	public Page<Empleado> paginarlistaEmpleado(Pageable pageable) throws Exception {
		return empleadoRepo.findAll(pageable);
	}

}
