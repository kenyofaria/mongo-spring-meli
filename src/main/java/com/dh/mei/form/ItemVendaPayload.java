package com.dh.mei.form;

import com.dh.mei.model.Anuncio;
import com.dh.mei.model.ItemVenda;
import com.dh.mei.repository.AnuncioRepository;

public class ItemVendaPayload {

	private String codigo;
	private int quantidade;
	
	
	public ItemVendaPayload(String codigoAnuncio, int quantidade) {
		super();
		this.codigo = codigoAnuncio;
		this.quantidade = quantidade;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public ItemVenda converteToModel(AnuncioRepository repository) {
		Anuncio anuncio = repository.findByCodigo(this.codigo);
		return new ItemVenda(anuncio, this.quantidade);
	}
}
