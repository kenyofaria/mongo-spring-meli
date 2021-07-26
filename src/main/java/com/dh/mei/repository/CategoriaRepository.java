package com.dh.mei.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dh.mei.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String>{

	Categoria findByCodigo(String codigo);
}
