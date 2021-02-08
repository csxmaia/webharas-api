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

import com.webharas.model.Pelagem;
import com.webharas.service.PelagemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/pelagem")
@Api(value="API Pelagem")
@CrossOrigin(origins="*")
public class PelagemController {

	@Autowired
	private PelagemService pelagemService;
	
	public PelagemController(PelagemService pelagemService) {
		this.pelagemService = pelagemService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de pelagem")
	public ResponseEntity<List<Pelagem>> listarpelagems(){
		List<Pelagem> pelagens = pelagemService.findAll();
		return ResponseEntity.ok(pelagens);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="pelagem")
	public ResponseEntity<Pelagem> getpelagem(@PathVariable(value="id") long id) {
		Pelagem pelagem = pelagemService.findById(id);
		return ResponseEntity.ok(pelagem);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Pelagem")
	public ResponseEntity<String> savepelagem(@RequestBody Pelagem pelagem) {
		pelagemService.save(pelagem);
		return ResponseEntity.ok("pelagem salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Pelagem")
	public ResponseEntity<String> updatepelagem(@RequestBody Pelagem pelagem, @PathVariable(value="id") long id) {
		pelagemService.update(id, pelagem);
		return ResponseEntity.ok("pelagem atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Pelagem")
	public ResponseEntity<String> deletepelagem(@PathVariable(value="id") long id) {
		pelagemService.delete(id);
		return ResponseEntity.ok("Pelagem deletado com sucesso");
	}
}
