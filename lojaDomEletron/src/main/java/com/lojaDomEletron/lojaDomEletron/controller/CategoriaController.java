package com.lojaDomEletron.lojaDomEletron.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojaDomEletron.lojaDomEletron.model.Categoria;
import com.lojaDomEletron.lojaDomEletron.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	public CategoriaRepository repository;

	@GetMapping
	private ResponseEntity<List<Categoria>> getAll() {

		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetByID(@PathVariable long id) {

		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String descricao) {

		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));

	}

	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));

	}

	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {

		long c = categoria.getId();
		for (Categoria item : repository.findAll()) {
			if (c == item.getId()) {
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

		repository.deleteById(id);
	}

}
