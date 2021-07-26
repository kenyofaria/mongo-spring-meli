package com.dh.mei.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "vendas")
public class Venda {

	@Id
	private String id;
	private LocalDate dataVenda;
	@Field(name = "anuncios")
	private List<ItemVenda> anuncios = new ArrayList<>();
	private BigDecimal valorTotal = new BigDecimal(0);

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(LocalDate dataVenda, List<ItemVenda> anuncios, BigDecimal valorTotal) {
		super();
		this.dataVenda = dataVenda;
		this.anuncios = anuncios;
		this.valorTotal = valorTotal;
	}

	public Venda(LocalDate dataVenda) {
		super();
		this.dataVenda = dataVenda;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<ItemVenda> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<ItemVenda> anuncios) {
		this.anuncios = anuncios;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void addAnuncio(ItemVenda item, int quantidade) {
		valorTotal = valorTotal.add(item.getAnuncio() != null ? item.getAnuncio().getPreco() : new BigDecimal(0));
		anuncios.add(item);
	}

}
