package com.dh.mei.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dh.mei.repository.UsuarioRepository;
import com.dh.mei.security.AutenticacaoService;
import com.dh.mei.security.AutenticacaoViaTokenFilter;
import com.dh.mei.service.TokenService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private AutenticacaoService autenticacaoService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//configuracoes de autenticacao (controle de acesso, login)
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//configurações de autorização
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/anuncios").permitAll()
		.antMatchers(HttpMethod.GET, "/categorias").permitAll()
		.antMatchers(HttpMethod.GET, "/usuarios/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
		//.and().formLogin();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//configurações de recursos estaticos (js, css, imagens, etc)
	}
	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
//	}
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
