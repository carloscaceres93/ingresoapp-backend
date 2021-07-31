package com.cidenet.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.model.Maestro;
import com.cidenet.ingreso.repository.IMaestroRepoitory;
import com.cidenet.ingreso.service.IMaestroService;

@Service
public class MestroServiceImpl implements IMaestroService {

	@Autowired
	private IMaestroRepoitory mestroRepo;

	@Override
	public Maestro save(Maestro t) throws Exception {
		return mestroRepo.save(t);
	}

	@Override
	public Maestro modify(Maestro t) throws Exception {
		return mestroRepo.save(t);
	}

	@Override
	public List<Maestro> findAll() throws Exception {
		return mestroRepo.findAll();
	}

	@Override
	public Maestro findById(Integer id) throws Exception {
		return mestroRepo.findById(id).orElseThrow();
	}

	@Override
	public void delete(Integer id) throws Exception {
		mestroRepo.deleteById(id);

	}

}
