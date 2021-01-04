package org.generation.blogPessoal.repository;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// metodo para buscar pelo User Name, vai ser Optional pq pode retornar um nulo.
	public Optional<Usuario> findByUsuario(String usuario);
}
