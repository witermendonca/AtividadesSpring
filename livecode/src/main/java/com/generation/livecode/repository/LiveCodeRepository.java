package com.generation.livecode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.livecode.model.LiveCode;

@Repository
public interface LiveCodeRepository extends JpaRepository<LiveCode, Long> {
	
	/*
	 * Query Method  https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html

	 * */
	public List<LiveCode> findAllByTituloContainingIgnoreCase (String titulo);
	
	/*
	 * Query Anotation https://www.baeldung.com/spring-data-jpa-query
	 * */
	
	@Query(value = "select * from tb_live_code where qtd_participantes > :valor", nativeQuery = true)
	public List<LiveCode> maiorQue (@Param("valor") int valor);
	
}
