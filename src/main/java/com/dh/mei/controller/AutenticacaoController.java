package com.dh.mei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.mei.dto.TokenDto;
import com.dh.mei.form.LoginPayLoad;
import com.dh.mei.service.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager; //eh do spring
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody LoginPayLoad payload){
		UsernamePasswordAuthenticationToken dadosLogin = payload.converter();
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.geraToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
