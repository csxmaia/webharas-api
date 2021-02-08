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

import com.webharas.model.Habilidade;
import com.webharas.service.HabilidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/habilidade")
@Api(value="API Habilidade")
@CrossOrigin(origins="*")
public class HabilidadeController {
	
	
	@Autowired
	private HabilidadeService habilidadeservice;
	
	public HabilidadeController(HabilidadeService habilidadeservice) {
		this.habilidadeservice = habilidadeservice;
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Habilidade")
	public ResponseEntity<List<Habilidade>> listarHabilidades(){
		List<Habilidade> habilidades = habilidadeservice.findAll();
		return ResponseEntity.ok(habilidades);
	}

	@GetMapping("/{id}")
	@ApiOperation(value="Habilidades")
	public ResponseEntity<Habilidade> gethabilidade(@PathVariable(value="id") long id) {
		Habilidade habilidade = habilidadeservice.findById(id);
		return ResponseEntity.ok(habilidade);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Habilidade")
	public ResponseEntity<String> saveHabilidade(@RequestBody Habilidade habilidade) {
		habilidadeservice.save(habilidade);
		return ResponseEntity.ok("habilidade salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar habilidade")
	public ResponseEntity<String> updatehabilidade(@RequestBody Habilidade habilidade, @PathVariable(value="id") long id) {
		habilidadeservice.update(id, habilidade);
		return ResponseEntity.ok("habilidade atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar habilidade")
	public ResponseEntity<String> deletehabilidade(@PathVariable(value="id") long id) {
		habilidadeservice.delete(id);
		return ResponseEntity.ok("habilidade deletado com sucesso");
	}

}
