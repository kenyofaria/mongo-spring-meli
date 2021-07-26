package com.dh.mei.dto;

import java.time.LocalDate;
import java.util.List;

public class VendaDto {

	public LocalDate dataVenda;
	public List<AnuncioDto> anuncios;
	
	
	public VendaDto() {
		// TODO Auto-generated constructor stub
	}


	public VendaDto(LocalDate dataVenda, List<AnuncioDto> anuncios) {
		super();
		this.dataVenda = dataVenda;
		this.anuncios = anuncios;
	}
	
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	
	public List<AnuncioDto> getAnuncios() {
		return anuncios;
	}
	
}
