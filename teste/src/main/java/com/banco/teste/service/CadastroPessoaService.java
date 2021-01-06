package com.banco.teste.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.teste.model.CadastroPessoa;
import com.banco.teste.repository.CadastroPessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired
	private CadastroPessoaRepository repository;

	public CadastroPessoa Cadastro(CadastroPessoa cadastro) {

		Optional<CadastroPessoa> cpfExistente = repository.findByCpf(cadastro.getCpf());
		
		Optional<CadastroPessoa> emailExistente = repository.findByEmail(cadastro.getEmail());

		if (cpfExistente.isPresent() || emailExistente.isPresent()) {
			return null;
		}

		return repository.save(cadastro);
	}
}
