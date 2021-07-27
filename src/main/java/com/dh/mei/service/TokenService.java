package com.dh.mei.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.dh.mei.security.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${token.expiration}")
	private String expiracao;
	
	@Value("${token.secret}")
	private String secret;

	public String geraToken(Authentication authenticate) {
		Usuario usuarioLogado = (Usuario) authenticate.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiracao));
		
		return Jwts.builder()
				.setIssuer("Bootcamp Meli")
				.setSubject(usuarioLogado.getLogin())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public String getLoginUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return body.getSubject();
	}
}
