package com.cidenet.ingreso.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.ingreso.exception.ModeloNotFoundException;
import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.repository.IPaisRepository;
import com.cidenet.ingreso.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaisServiceImpl.class);

	@Autowired
	private IPaisRepository paisRepo;

	@Override
	public Pais save(Pais t) throws Exception {
		
		Pais pais = this.findById(t.getId());

//		verifica que no exista el pais en DB
		if (pais.getId() != null) {
			LOGGER.error("Error al registrar: El Pais ya existe en la base de datos id: " + pais.getId());
			throw new ModeloNotFoundException(
					"Error al registrar: El Pais ya existe en la base de datos id: " + pais.getId());
		}
		return paisRepo.save(pais);
	}

	@Override
	public Pais modify(Pais t) throws Exception {
		return paisRepo.save(t);
	}

	@Override
	public List<Pais> findAll() throws Exception {
		List<Pais> paises = paisRepo.findAll();

//		verifica que la lista no este vacia
		if (paises.isEmpty()) {
			LOGGER.warn("No se encontraron paises disponibles");

			throw new ModeloNotFoundException("No se encontraron paises disponibles");
		}
		return paises;
	}

	@Override
	public Pais findById(Integer id) throws Exception {
		Optional<Pais> pais  = paisRepo.findById(id);
		
		if(!pais.isPresent()) {
			LOGGER.error("ERROR: El Pais no existe en la base de datos; id: "  + id);
			throw new ModeloNotFoundException("ERROR: El Pais no existe en la base de datos; id: "  + id);
			
		}
		
		return pais.get();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Pais pais = this.findById(id);

		if (pais == null) {
			LOGGER.error("Error al eliminar: El Pais no existe en la base de datos id: " + id);
			
			throw new ModeloNotFoundException("Error al Eliminar: El Pais no existe en la base de datos id: " + id);
		}
		paisRepo.deleteById(pais.getId());

	}

}
