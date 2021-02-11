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

import com.webharas.DTO.UsuarioLoginRequestDTO;
import com.webharas.model.Usuario;
import com.webharas.service.UsuarioService;

import com.webharas.model.exceptions.FailedAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/usuario")
@Api(value="API Usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Usuario")
	public ResponseEntity<String> doLogin(@RequestBody UsuarioLoginRequestDTO usuario) throws FailedAuth {
		try {
			String user = usuarioService.login(usuario);	
			return ResponseEntity.ok("Login realizado "+user);
		}catch (Exception e) {
            throw new FailedAuth();
		}
	}
	
	@GetMapping()
	@ApiOperation(value="Lista de Usuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios = usuarioService.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Usuario")
	public ResponseEntity<Usuario> listarUsuario(@PathVariable(value="id") long id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Salvar Usuario")
	public ResponseEntity<String> saveUsuario(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return ResponseEntity.ok("Usuario salvo com sucesso");
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Alterar Usuario")
	public ResponseEntity<String> updateUsuario(@RequestBody Usuario usuario, @PathVariable(value="id") long id) {
		usuarioService.update(id, usuario);
		return ResponseEntity.ok("Usuario atualizado com sucesso");
	}
	
	@DeleteMapping(path = "/{id}")
	@ApiOperation(value="Deletar Usuario")
	public ResponseEntity<String> deleteUsuario(@PathVariable(value="id") long id) {
		usuarioService.delete(id);
		return ResponseEntity.ok("Usuario deletado com sucesso");
	}
	
}
