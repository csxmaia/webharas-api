package com.webharas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webharas.model.Usuario;
import com.webharas.service.UsuarioService;

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
	
	@GetMapping("/getAll")
	@ApiOperation(value="Lista de usuarios")
	public List<Usuario> listarUsuarios(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public Usuario listarUsuario(@PathVariable(value="id") long id) {
//		System.out.println(id);
		return usuarioService.findById(id);
	}
//	new ResponseEntity("Product saved successfully", HttpStatus.OK);
	
}
