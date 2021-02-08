package com.webharas.controller;

import java.util.List;

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

import com.webharas.model.Haras;
import com.webharas.service.HarasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/haras")
@Api(value="API Haras")
@CrossOrigin(origins="*")
public class HarasController {
	
	@Autowired
	private HarasService harasService;
	
	public HarasController (HarasService harasService) {
		this.harasService = harasService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Haras")
	public ResponseEntity<List<Haras>> listarharass(){
		List<Haras> haras = harasService.findAll();
		return ResponseEntity.ok(haras);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="haras")
	public ResponseEntity<Haras> getharas(@PathVariable(value="id") long id) {
		Haras haras = harasService.findById(id);
		return ResponseEntity.ok(haras);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar haras")
	public ResponseEntity<String> saveharas(@RequestBody Haras haras) {
		harasService.save(haras);
		return ResponseEntity.ok("haras salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Haras")
	public ResponseEntity<String> updateharas(@RequestBody Haras haras, @PathVariable(value="id") long id) {
		harasService.update(id, haras);
		return ResponseEntity.ok("haras atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Haras")
	public ResponseEntity<String> deleteharas(@PathVariable(value="id") long id) {
		harasService.delete(id);
		return ResponseEntity.ok("haras deletado com sucesso");
	}
 
}
