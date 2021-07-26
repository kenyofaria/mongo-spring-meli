package com.dh.mei.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dh.mei.model.Anuncio;

public interface AnuncioRepository extends MongoRepository<Anuncio, String>{


	Anuncio findByCodigo(String codigo);
	
}
