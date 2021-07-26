package com.dh.mei.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vendas")
public class ItemVenda {
	
	@Field("anuncio")
	private Anuncio anuncio;
	
	private int quantidade;
	
	public ItemVenda() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemVenda(Anuncio anuncio, int quantidade) {
		super();
		this.anuncio = anuncio;
		this.quantidade = quantidade;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void decrementaQuantidade(int valor) {
		this.quantidade -= valor;
	}
	
	
}
