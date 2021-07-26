package com.dh.mei.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "anuncios")
public class Categoria {

	@Id
	private String id;
	private String codigo;
	private String nome;
	@Field(name = "parent")
	private Categoria parent;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public Categoria(String id, String codigo, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Categoria getParent() {
		return parent;
	}

	public void setParent(Categoria parent) {
		this.parent = parent;
	}
	
	
}
