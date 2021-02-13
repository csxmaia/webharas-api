package com.webharas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import com.webharas.model.Cavalo;
import com.webharas.model.exceptions.NotFoundException;
import com.webharas.service.CavaloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/cavalo")
@Api(value="API cavalo")
@CrossOrigin(origins="*")
public class CavaloController {
	
	@Autowired
	private CavaloService cavaloService;
	
	public CavaloController(CavaloService cavaloService) {
		this.cavaloService = cavaloService;
	}
	
	@GetMapping("/avenda")
	@ApiOperation(value="Lista de Cavalo")
	public ResponseEntity<List<Cavalo>> listarCavalosAVenda(){
		List<Cavalo> cavalos = cavaloService.findAllAVenda();
		return ResponseEntity.ok(cavalos);
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Cavalo")
	public ResponseEntity<List<Cavalo>> listarcavalos(){
		List<Cavalo> cavalos = cavaloService.findAll();
		return ResponseEntity.ok(cavalos);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="cavalo")
	public ResponseEntity<Cavalo> getcavalo(@PathVariable(value="id") long id) throws NotFoundException {
		try {
			Cavalo cavalo = cavaloService.findById(id);
			return ResponseEntity.ok(cavalo);
		} catch (NotFoundException ex) {
			throw new NotFoundException();
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Cavalo")
	public ResponseEntity<String> savecavalo(@RequestBody Cavalo cavalo) {
		cavaloService.save(cavalo);
		return ResponseEntity.ok("Cavalo salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Cavalo")
	public ResponseEntity<String> updatecavalo(@RequestBody Cavalo cavalo, @PathVariable(value="id") long id) {
		cavaloService.update(id, cavalo);
		return ResponseEntity.ok("Cavalo atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Cavalo")
	public ResponseEntity<String> deletecavalo(@PathVariable(value="id") long id) {
		cavaloService.delete(id);
		return ResponseEntity.ok("Cavalo deletado com sucesso");
	}
	

}
