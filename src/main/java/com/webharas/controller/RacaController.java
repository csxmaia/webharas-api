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

import com.webharas.model.Raca;
import com.webharas.service.RacaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/raca")
@Api(value="API Raca")
@CrossOrigin(origins="*")
public class RacaController {

	
	@Autowired
	private RacaService racaService;
	
	public RacaController(RacaService racaService) {
		this.racaService = racaService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Raça")
	public ResponseEntity<List<Raca>> listarracas(){
		List<Raca> racas = racaService.findAll();
		return ResponseEntity.ok(racas);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="raca")
	public ResponseEntity<Raca> getraca(@PathVariable(value="id") long id) {
		Raca raca = racaService.findById(id);
		return ResponseEntity.ok(raca);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Raça")
	public ResponseEntity<String> saveraca(@RequestBody Raca raca) {
		racaService.save(raca);
		return ResponseEntity.ok("Raça salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Raça")
	public ResponseEntity<String> updateraca(@RequestBody Raca raca, @PathVariable(value="id") long id) {
		racaService.update(id, raca);
		return ResponseEntity.ok("Raça atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Raça")
	public ResponseEntity<String> deleteraca(@PathVariable(value="id") long id) {
		racaService.delete(id);
		return ResponseEntity.ok("Raça deletado com sucesso");
	}
}
