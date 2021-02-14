package com.webharas.controller;

import java.util.List;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webharas.model.Estado;
import com.webharas.model.exceptions.NotNullException;
import com.webharas.service.EstadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/estado")
@Api(value="API Estado")
@CrossOrigin(origins="*")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Estados")
	public ResponseEntity<List<Estado>> listarEstados(){
		List<Estado> estados = estadoService.findAll();
		return ResponseEntity.ok(estados);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Estado")
	public ResponseEntity<Estado> getEstado(@PathVariable(value="id") long id) {
		Estado estado = estadoService.findById(id);
		return ResponseEntity.ok(estado);
	}
		
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Estado")
	public ResponseEntity<String> saveEstado(@RequestBody Estado estado) throws NotNullException {
		try {
			estadoService.save(estado);
			return ResponseEntity.ok("Estado salvo com sucesso");
		}catch(PropertyValueException ex) {
			throw new NotNullException();
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Estado")
	public ResponseEntity<String> updateEstado(@RequestBody Estado estado, @PathVariable(value="id") long id) {
		estadoService.update(id, estado);
		return ResponseEntity.ok("Estado atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Estado")
	public ResponseEntity<String> deleteEstado(@PathVariable(value="id") long id) {
		estadoService.delete(id);
		return ResponseEntity.ok("Estado deletado com sucesso");
	}
	
}
