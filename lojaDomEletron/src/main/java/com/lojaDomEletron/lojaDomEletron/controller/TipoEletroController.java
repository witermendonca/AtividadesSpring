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

import com.lojaDomEletron.lojaDomEletron.model.TipoEletro;
import com.lojaDomEletron.lojaDomEletron.repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoEletroController {

	@Autowired
	private TipoEletroRepository repository;

	@GetMapping
	private ResponseEntity<List<TipoEletro>> getAll() {

		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> GetByID(@PathVariable long id) {

		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TipoEletro>> GetByDescricao(@PathVariable String descricao) {

		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));

	}

	@PostMapping
	public ResponseEntity<TipoEletro> post(@RequestBody TipoEletro tipo) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipo));

	}

	@PutMapping
	public ResponseEntity<TipoEletro> put(@RequestBody TipoEletro tipo) {

		long t = tipo.getId();
		for (TipoEletro item : repository.findAll()) {
			if (t == item.getId()) {
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipo));
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();


	}
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
	}

}
