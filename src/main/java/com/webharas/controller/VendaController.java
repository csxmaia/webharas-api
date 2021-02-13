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

import com.webharas.model.Venda;
import com.webharas.model.exceptions.CavaloNaoDisponivel;
import com.webharas.model.exceptions.NotFoundException;
import com.webharas.service.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/venda")
@Api(value="API Venda")
@CrossOrigin(origins="*")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	public VendaController(VendaService vendaService) {
		this.vendaService = vendaService;
	}
	
	@PostMapping(path= "/realizar-venda", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Realizar venda")
	public ResponseEntity<String> realizarVenda(@RequestBody Venda venda) throws CavaloNaoDisponivel {
		try {
			vendaService.realizarVenda(venda);
			return ResponseEntity.ok("venda realizada com sucesso");
		}catch(NotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cavalo não encontrado", ex);
		}
		catch(CavaloNaoDisponivel ex) {
			throw new CavaloNaoDisponivel();
		}
		catch(NullPointerException ex) {
			throw new NullPointerException();
		}
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de venda")
	public ResponseEntity<List<Venda>> listarvendas(){
		List<Venda> vendas = vendaService.findAll();
		return ResponseEntity.ok(vendas);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="venda")
	public ResponseEntity<Venda> getvenda(@PathVariable(value="id") long id) {
		Venda venda = vendaService.findById(id);
		return ResponseEntity.ok(venda);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar venda")
	public ResponseEntity<String> savevenda(@RequestBody Venda venda) {
		vendaService.save(venda);
		return ResponseEntity.ok("venda salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar venda")
	public ResponseEntity<String> updatevenda(@RequestBody Venda venda, @PathVariable(value="id") long id) {
		vendaService.update(id, venda);
		return ResponseEntity.ok("venda atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar venda")
	public ResponseEntity<String> deletevenda(@PathVariable(value="id") long id) {
		vendaService.delete(id);
		return ResponseEntity.ok("venda deletado com sucesso");
		
	}

}
