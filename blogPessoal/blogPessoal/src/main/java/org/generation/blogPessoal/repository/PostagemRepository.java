package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//anotação para indicar que essa classe é um repositorio 
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	//contratos//findALL = seleciona tudo//byID = seleciona o dado pelo id//save = para salvar//delete = para deletar 
	
	//contruir consulta pelo titulo //retornar uma lista List, list de <Postagem>
	// metodo, findAll = buscar todos pelo ByTitulo = nome do atributo da entidade, Containing = trazer o que tiver dentro da variavel 
	//IgnoreCase = trazer tudo sem levar em consideração M e m .
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
