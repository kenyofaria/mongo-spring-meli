package com.dh.mei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.mei.form.CategoriaForm;
import com.dh.mei.model.Categoria;
import com.dh.mei.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	public void cadastra(@RequestBody CategoriaForm form) {
		Categoria categoria = new Categoria();
		categoria = form.converte(form);
		if(form.getParent()!=null) {
			Categoria parent = categoriaRepository.findByCodigo(form.getParent());
			categoria.setParent(parent);
		}

		categoriaRepository.save(categoria);
	}
	
	@GetMapping
	public List<Categoria> listagem(){
		return categoriaRepository.findAll();
	}
}
