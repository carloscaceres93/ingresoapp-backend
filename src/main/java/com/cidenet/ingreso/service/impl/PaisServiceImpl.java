package com.cidenet.ingreso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.repository.IPaisRepository;
import com.cidenet.ingreso.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService{

	@Autowired
	private IPaisRepository paisRepo;
	
	@Override
	public Pais save(Pais t) throws Exception {
		return paisRepo.save(t);
	}

	@Override
	public Pais modify(Pais t) throws Exception {
		return paisRepo.save(t);
	}

	@Override
	public List<Pais> findAll() throws Exception {
		return paisRepo.findAll();
	}

	@Override
	public Pais findById(Integer id) throws Exception {
		return paisRepo.findById(id).orElseThrow();
	}

	@Override
	public void delete(Integer id) throws Exception {
		paisRepo.deleteById(id);
		
	}

	
	
}
