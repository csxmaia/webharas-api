package com.webharas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webharas.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);
	
	Usuario findByEmail(String email);
	
}
