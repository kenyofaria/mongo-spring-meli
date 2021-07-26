package com.dh.mei.form;

import java.time.LocalDate;
import java.util.List;

import com.dh.mei.model.ItemVenda;
import com.dh.mei.model.Venda;
import com.dh.mei.repository.AnuncioRepository;

public class VendaPayload {

	
	private List<ItemVendaPayload> anuncios;

	public List<ItemVendaPayload> getAnuncios() {
		return anuncios;
	}
	
	public VendaPayload() {
		
	}
	
	public Venda convertToModel(AnuncioRepository anuncioRepository) {
		Venda venda = new Venda(LocalDate.now());
		this.anuncios.forEach(item -> {
			ItemVenda itemVenda = item.converteToModel(anuncioRepository);
			venda.addAnuncio(itemVenda, item.getQuantidade());
		});
		
		return venda;
	}
	
}
