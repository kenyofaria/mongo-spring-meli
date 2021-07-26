package com.dh.mei.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "anuncios")
public class Anuncio {

	@Id
	private String id;
	private String codigo;
	private String descricao;
	@Field(name = "categoria")
	private Categoria categoria;
	private BigDecimal preco;
	private int quantidadeDisponivel;
	
	public Anuncio() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Anuncio(String id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Anuncio(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Anuncio(String codigo, String descricao, Categoria categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
	}



	public Anuncio(String codigo, String descricao, BigDecimal preco, Categoria categoria) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.setPreco(preco);
	}

	public Anuncio(String codigo, String descricao, BigDecimal preco, Categoria categoria, int quantidadeDisponivel) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.setPreco(preco);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}



	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}



	public void setQuantidadeDisponivel(int quantidadeItens) {
		this.quantidadeDisponivel = quantidadeItens;
	}
	
	public void decrementaQuantidadeDisponivel(int valor){
		this.quantidadeDisponivel-=valor;
	}
	
}
