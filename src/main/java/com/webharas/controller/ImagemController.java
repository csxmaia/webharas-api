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

import com.webharas.model.Imagem;
import com.webharas.service.ImagemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/imagem")
@Api(value="API Imagem")
@CrossOrigin(origins="*")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;

	public ImagemController(ImagemService imagemService) {
		this.imagemService = imagemService;
	}

	@GetMapping()
	@ApiOperation(value="Lista de Imagem")
	public ResponseEntity<List<Imagem>> listarImagens(){
		List<Imagem> imagens = imagemService.findAll();
		return ResponseEntity.ok(imagens);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Imagem")
	public ResponseEntity<Imagem> getImagem(@PathVariable(value="id") long id){
		Imagem imagem = imagemService.findById(id);
		return ResponseEntity.ok(imagem);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Imagem")
	public ResponseEntity<String> saveImagem(@RequestBody Imagem imagem){
		imagemService.save(imagem);
		return ResponseEntity.ok("Imagem Salva com Sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Imagem")	
	public ResponseEntity<String> updateImagem(@RequestBody Imagem imagem, @PathVariable(value="id") long id){
		imagemService.update(id, imagem);
		return ResponseEntity.ok("Imagem Atualizada com Sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Imagem")
	public ResponseEntity<String> deleteImagem(@PathVariable(value="id") long id){
		imagemService.delete(id);
		return ResponseEntity.ok("Imagem Deletada com Sucesso");
	}


}
