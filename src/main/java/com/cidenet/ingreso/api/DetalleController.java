package com.cidenet.ingreso.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.ingreso.model.Detalle;
import com.cidenet.ingreso.service.IDetalleService;

@RestController
@RequestMapping("api/detalle")
public class DetalleController {

	@Autowired
	private IDetalleService detalleService;

	@GetMapping("/areas")
	public ResponseEntity<List<Detalle>> findAllArea() throws Exception {
		List<Detalle> areas = detalleService.findAllArea();
		return new ResponseEntity<List<Detalle>>(areas, HttpStatus.OK);
	}

	@GetMapping("/tipos-identificacion")
	public ResponseEntity<List<Detalle>> findAllTipoIdentificacion() throws Exception {
		List<Detalle> areas = detalleService.findAllTipoIdentificacion();
		return new ResponseEntity<List<Detalle>>(areas, HttpStatus.OK);
	}
	
}
