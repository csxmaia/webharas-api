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

import com.webharas.model.TelefoneContatoHaras;
import com.webharas.model.Usuario;
import com.webharas.service.TelefoneContatoHarasService;
import com.webharas.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/telefonecontatoharas")
@Api(value="API Telefone Contato Haras")
@CrossOrigin(origins="*")
public class TelefoneContatoHarasController {

	@Autowired
	private TelefoneContatoHarasService telefoneContatoHarasService;
	
	public TelefoneContatoHarasController(TelefoneContatoHarasService telefoneContatoHarasService) {
		this.telefoneContatoHarasService = telefoneContatoHarasService;
	}
	
	@PostMapping(path="/return", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Telefone e retornar ID")
	public ResponseEntity<TelefoneContatoHaras> saveTelefoneContatoHarasReturnId(@RequestBody TelefoneContatoHaras telefoneContatoHaras) {
		TelefoneContatoHaras telefone = telefoneContatoHarasService.save(telefoneContatoHaras);
		return ResponseEntity.ok(telefone);
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Telefone Contato Haras")
	public ResponseEntity<List<TelefoneContatoHaras>> listarTelefoneContatoHaras(){
		List<TelefoneContatoHaras> telefoneContatoHaras = telefoneContatoHarasService.findAll();
		return ResponseEntity.ok(telefoneContatoHaras);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Telefone Contato Haras")
	public ResponseEntity<TelefoneContatoHaras> listarTelefoneContatoHaras(@PathVariable(value="id") long id) {
		TelefoneContatoHaras telefoneContatoHaras = telefoneContatoHarasService.findById(id);
		return ResponseEntity.ok(telefoneContatoHaras);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Telefone Contato Haras")
	public ResponseEntity<String> saveTelefoneContatoHaras(@RequestBody TelefoneContatoHaras telefoneContatoHaras) {
		telefoneContatoHarasService.save(telefoneContatoHaras);
		return ResponseEntity.ok("Telefone Contato Haras salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Telefone Contato Haras")
	public ResponseEntity<String> updateTelefoneContatoHaras(@RequestBody TelefoneContatoHaras telefoneContatoHaras, @PathVariable(value="id") long id) {
		telefoneContatoHarasService.update(id, telefoneContatoHaras);
		return ResponseEntity.ok("Telefone Contato Haras atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Telefone Contato Haras")
	public ResponseEntity<String> deleteTelefoneContatoHaras(@PathVariable(value="id") long id) {
		telefoneContatoHarasService.delete(id);
		return ResponseEntity.ok("Telefone Contato Haras deletado com sucesso");
	}
	
}
