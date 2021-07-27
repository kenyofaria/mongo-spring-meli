package com.dh.mei.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dh.mei.security.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	Optional<Usuario> findByLogin(String login);
}
