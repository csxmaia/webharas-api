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

import com.webharas.model.Cidade;
import com.webharas.service.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/cidade")
@Api(value="API Cidade")
@CrossOrigin(origins="*")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;
	
	public CidadeController(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de cidade")
	public ResponseEntity<List<Cidade>> listarCidades(){
		List<Cidade> cidades = cidadeService.findAll();
		return ResponseEntity.ok(cidades);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Cidade")
	public ResponseEntity<Cidade> getCidade(@PathVariable(value="id") long id) {
		Cidade cidade = cidadeService.findById(id);
		return ResponseEntity.ok(cidade);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Cidade")
	public ResponseEntity<String> saveCidade(@RequestBody Cidade cidade) {
		cidadeService.save(cidade);
		return ResponseEntity.ok("Cidade salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Cidade")
	public ResponseEntity<String> updateCidade(@RequestBody Cidade cidade, @PathVariable(value="id") long id) {
		cidadeService.update(id, cidade);
		return ResponseEntity.ok("Cidade atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Cidade")
	public ResponseEntity<String> deleteCidade(@PathVariable(value="id") long id) {
		cidadeService.delete(id);
		return ResponseEntity.ok("Cidade deletado com sucesso");
	}
	
}
