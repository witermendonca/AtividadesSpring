package com.lojaDomEletron.lojaDomEletron.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaDomEletron.lojaDomEletron.model.TipoEletro;

@Repository
public interface TipoEletroRepository extends JpaRepository<TipoEletro, Long> {

	public List<TipoEletro> findAllByDescricaoContainingIgnoreCase (String descricao);
}
