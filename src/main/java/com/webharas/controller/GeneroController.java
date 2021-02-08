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

import com.webharas.model.Genero;
import com.webharas.service.GeneroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/genero")
@Api(value="API Genero")
@CrossOrigin(origins="*")
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	public GeneroController(GeneroService generoService) {
		this.generoService = generoService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Genero")
	public ResponseEntity<List<Genero>> listargeneros(){
		List<Genero> generos = generoService.findAll();
		return ResponseEntity.ok(generos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="genero")
	public ResponseEntity<Genero> getgenero(@PathVariable(value="id") long id) {
		Genero genero = generoService.findById(id);
		return ResponseEntity.ok(genero);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Genero")
	public ResponseEntity<String> savegenero(@RequestBody Genero genero) {
		generoService.save(genero);
		return ResponseEntity.ok("genero salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Genero")
	public ResponseEntity<String> updategenero(@RequestBody Genero genero, @PathVariable(value="id") long id) {
		generoService.update(id, genero);
		return ResponseEntity.ok("genero atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Genero")
	public ResponseEntity<String> deletegenero(@PathVariable(value="id") long id) {
		generoService.delete(id);
		return ResponseEntity.ok("genero deletado com sucesso");
	}

}
