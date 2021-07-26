package com.dh.mei.form;

import com.dh.mei.model.Categoria;

public class CategoriaForm {

	
	private String codigo;
	private String nome;
	private String parent;
	
	public CategoriaForm(String codigo, String nome, String parent) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setParent(parent);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public Categoria converte(CategoriaForm form) {
		return new Categoria(form.codigo, form.nome);
	}
	
}
