package com.dh.mei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.mei.repository.PerfilRepository;
import com.dh.mei.repository.UsuarioRepository;
import com.dh.mei.security.Perfil;
import com.dh.mei.security.Usuario;

@RestController
public class InicializaApi {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@GetMapping("/usuarios/init")
	public void criaUsuarios() {
		
		Perfil perfil = perfilRepository.save(new Perfil("usuario"));
		
		//$2a$10$Mh5KIkdhpxicLe7pCDJwx.GyYBjtUhtVjX5EmnCCGywRmBMRDv68W
		usuarioRepository.save(new Usuario("kenyo@mail.com", "$2a$10$Mh5KIkdhpxicLe7pCDJwx.GyYBjtUhtVjX5EmnCCGywRmBMRDv68W", perfil));
	}
	
	@GetMapping("/usuarios/list")
	public List<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}
}
