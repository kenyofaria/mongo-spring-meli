package com.dh.mei.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dh.mei.security.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String>{

}
