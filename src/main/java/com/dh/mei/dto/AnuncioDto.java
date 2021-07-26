package com.dh.mei.dto;

import java.util.ArrayList;
import java.util.List;

import com.dh.mei.model.Anuncio;
import com.dh.mei.model.ItemVenda;

public class AnuncioDto {

	
	private String codigo;
	private String descricao;
	
	public AnuncioDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public AnuncioDto(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}


	public String getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static AnuncioDto converter(Anuncio model) {
		return new AnuncioDto(model.getCodigo(), model.getDescricao());
	}
	public static List<AnuncioDto> converter(List<ItemVenda> listaModel) {
		List<AnuncioDto> listaDto = new ArrayList<>();
		listaModel.forEach(m -> listaDto.add(new AnuncioDto(m.getAnuncio().getCodigo(), m.getAnuncio().getDescricao())));
		return listaDto;
	}
}
