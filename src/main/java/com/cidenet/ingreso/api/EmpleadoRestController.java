package com.cidenet.ingreso.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.cidenet.ingreso.model.Empleado;
import com.cidenet.ingreso.service.IEmpleadoService;

@RestController
@RequestMapping("api/empleados")
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadosService;

	@GetMapping
	public ResponseEntity<List<Empleado>> findAll() throws Exception {
		List<Empleado> empleados = empleadosService.findAll();
		return new ResponseEntity<List<Empleado>>(empleados, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public EntityModel<Empleado> findById(@PathVariable("id") Integer id) throws Exception {
		Empleado obj = empleadosService.findById(id);

		EntityModel<Empleado> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
		recurso.add(link.withRel("empleado-recurso"));

		return recurso;
	}

	@PostMapping
	public ResponseEntity<Empleado> save(@Valid @RequestBody Empleado empleado) throws Exception {
		
		System.out.println(empleado.toString());
		Empleado obj = empleadosService.save(empleado);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Empleado> modify(@Valid @RequestBody Empleado empleado) throws Exception {
		Empleado obj = empleadosService.modify(empleado);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		empleadosService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Empleado>> listarPageable(Pageable pageable) throws Exception{
		Page<Empleado> pacientes = empleadosService.paginarlistaEmpleado(pageable);
		return new ResponseEntity<Page<Empleado>>(pacientes, HttpStatus.OK);
	}
	
}
