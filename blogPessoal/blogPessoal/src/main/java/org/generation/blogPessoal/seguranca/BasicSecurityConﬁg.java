package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Habilitar o web security com a anotação 
@EnableWebSecurity
public class BasicSecurityConﬁg extends WebSecurityConfigurerAdapter {

	// injetando dependencia
	@Autowired
	private UserDetailsService userDetailsService;

	// metodo de configuração sobre escrito, usando a tratação de erro
	// throws
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	// metodo de configuração sobre escrito, usando a tratação de erro throws,
	// permite o usuario cadastrar e logar, os demais ele tem que autenticadas,
	// usando o httpBasic para gerar o token, sessionManagement vai indicar o tipo
	// de sessão que vai utilizar a politica de não guardar sessão nenhuma com o
	// STATELESS, cors para habilitar cors, csrf desabilitado usando as
	// configurações padrão.
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}
}
