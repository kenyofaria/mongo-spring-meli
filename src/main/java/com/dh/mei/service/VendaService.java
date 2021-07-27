package com.dh.mei.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dh.mei.model.Anuncio;
import com.dh.mei.model.Venda;
import com.dh.mei.repository.AnuncioRepository;
import com.dh.mei.repository.VendaRepository;

@Service
public class VendaService {

	private AnuncioRepository anuncioRepository;
	private VendaRepository vendaRepository;
	
	@Autowired
	public VendaService(AnuncioRepository anuncioRepository, VendaRepository vendaRepository) {
		this.anuncioRepository = anuncioRepository;
		this.vendaRepository = vendaRepository;
	}
	
	//@CacheEvict(value="listaVendasCompleta", allEntries = true)
	public void realizaVenda(Venda venda) {
		vendaRepository.save(venda);
		atualizaEstoque(venda);
	}
	
	private void atualizaEstoque(Venda venda) {
		venda.getAnuncios().forEach(a -> {
			Anuncio anuncio = anuncioRepository.findByCodigo(a.getAnuncio().getCodigo());
			anuncio.decrementaQuantidadeDisponivel(a.getQuantidade());
			anuncioRepository.save(anuncio);
		});
	}
	
	public List<Venda> listagem(LocalDate dataInicial, LocalDate dataFinal){
		return vendaRepository.findByDataVendaBetween(dataInicial, dataFinal);
	}
	
	//@Cacheable(value="listaVendasCompleta")
	public Page<Venda> listagem(Pageable pageable){
		return vendaRepository.findAll(pageable);
	}
}
