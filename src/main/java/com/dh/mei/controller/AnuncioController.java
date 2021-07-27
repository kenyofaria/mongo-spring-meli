package com.dh.mei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.mei.form.AnuncioForm;
import com.dh.mei.model.Anuncio;
import com.dh.mei.model.Categoria;
import com.dh.mei.repository.AnuncioRepository;
import com.dh.mei.repository.CategoriaRepository;

@RestController
@RequestMapping("/anuncios")
public class AnuncioController {

	@Autowired
	private AnuncioRepository anuncioRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public void cadastra(@RequestBody AnuncioForm payLoad) {
		Categoria categoria = categoriaRepository.findByCodigo(payLoad.getCodigoCategoria());
		Anuncio anuncio = payLoad.converte(payLoad, categoria);
		anuncioRepository.save(anuncio);
	}
	

	@PostMapping("/update")
	public void atualiza(@RequestBody AnuncioForm payLoad) {
		Anuncio anuncio = anuncioRepository.findByCodigo(payLoad.getCodigo());
		anuncio.setQuantidadeDisponivel(payLoad.getQuantidade());
		anuncioRepository.save(anuncio);
	}
	
	@GetMapping
	public List<Anuncio> listagem() {
		return anuncioRepository.findAll();
	}
}
