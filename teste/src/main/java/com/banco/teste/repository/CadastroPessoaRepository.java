package com.banco.teste.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.teste.model.CadastroPessoa;

@Repository
public interface CadastroPessoaRepository extends JpaRepository<CadastroPessoa, Long> {

	public Optional<CadastroPessoa> findByCpf(String cpf);

	public Optional<CadastroPessoa> findByEmail(String email);

}
