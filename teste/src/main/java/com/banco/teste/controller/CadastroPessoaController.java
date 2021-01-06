package com.banco.teste.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.teste.model.CadastroPessoa;
import com.banco.teste.service.CadastroPessoaService;

@RestController
@RequestMapping("/cadastro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CadastroPessoaController {

	@Autowired
	private CadastroPessoaService cadastroPessoaService;

	@PostMapping("/cadastro")
	public ResponseEntity<CadastroPessoa> Post(@RequestBody @Valid CadastroPessoa cadastro) {

		CadastroPessoa pessoa = cadastroPessoaService.Cadastro(cadastro);
		if (pessoa == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
	}

}
