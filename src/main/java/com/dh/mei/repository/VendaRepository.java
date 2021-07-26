package com.dh.mei.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dh.mei.model.Venda;

public interface VendaRepository extends MongoRepository<Venda, Long>{

	List<Venda> findByDataVendaBetween(LocalDate dataInicial, LocalDate dataFinal);
}
