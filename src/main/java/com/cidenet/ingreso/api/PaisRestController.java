package com.cidenet.ingreso.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cidenet.ingreso.model.Pais;
import com.cidenet.ingreso.service.IPaisService;

@RestController
@RequestMapping("api/paises")
public class PaisRestController {

	@Autowired
	private IPaisService paisService;

	@GetMapping
	public ResponseEntity<List<Pais>> findAll() throws Exception {
		List<Pais> paises = paisService.findAll();
		return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public EntityModel<Pais> findById(@PathVariable("id") Integer id) throws Exception {
		Pais obj = paisService.findById(id);

		EntityModel<Pais> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
		recurso.add(link.withRel("pais-recurso"));

		return recurso;
	}

	@PostMapping
	public ResponseEntity<Pais> save(@Valid @RequestBody Pais pais) throws Exception {
		Pais obj = paisService.save(pais);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Pais> modify(@Valid @RequestBody Pais pais) throws Exception {
		Pais obj = paisService.save(pais);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		paisService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
