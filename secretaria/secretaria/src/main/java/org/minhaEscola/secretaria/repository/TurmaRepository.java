package org.minhaEscola.secretaria.repository;

import java.util.List;

import org.minhaEscola.secretaria.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	public List<Turma> findALLByTurmaContainingIgnoreCase (String turma);

}
