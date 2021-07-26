package com.dh.mei.form;

import java.math.BigDecimal;

import com.dh.mei.model.Anuncio;
import com.dh.mei.model.Categoria;

public class AnuncioForm {

	
    private String codigo;
    private String descricao;
    private BigDecimal preco;
    private String codigoCategoria;
    private int quantidade;
    private int quantidadeVenda;
    
    public AnuncioForm() {
		// TODO Auto-generated constructor stub
	}
    
	public AnuncioForm(String codigo, String descricao, BigDecimal preco, String codigoCategoria) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.codigoCategoria = codigoCategoria;
	}
	public AnuncioForm(String codigo, String descricao, BigDecimal preco, String codigoCategoria, int quantidade) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.codigoCategoria = codigoCategoria;
		this.quantidade = quantidade;
	}
	public AnuncioForm(String codigo, String descricao, BigDecimal preco, String codigoCategoria, int quantidade, int quantidadeVenda) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.codigoCategoria = codigoCategoria;
		this.quantidade = quantidade;
		this.quantidadeVenda = quantidadeVenda;
	}	
	
	
	public String getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public String getCodigoCategoria() {
		return codigoCategoria;
	}
    public Anuncio converte(AnuncioForm form, Categoria categoria) {
    	return new Anuncio(form.codigo, form.descricao, form.preco ,categoria, form.quantidade);
    }
	public int getQuantidade() {
		return quantidade;
	}
    public int getQuantidadeVenda() {
		return quantidadeVenda;
	}
}
