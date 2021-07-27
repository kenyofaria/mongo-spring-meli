package com.dh.mei.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collection = "perfis")
public class Perfil implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String nome;

	public Perfil(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
	
}
