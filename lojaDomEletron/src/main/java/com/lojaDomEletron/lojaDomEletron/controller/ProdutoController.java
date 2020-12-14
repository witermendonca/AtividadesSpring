package com.lojaDomEletron.lojaDomEletron.controller;

import java.math.BigDecimal;
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

import com.lojaDomEletron.lojaDomEletron.model.Produto;
import com.lojaDomEletron.lojaDomEletron.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	private ResponseEntity<List<Produto>> getAll() {

		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getByID(@PathVariable long id) {

		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {

		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));

	}

	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Produto>> getByMarca(@PathVariable String marca) {

		return ResponseEntity.ok(repository.findAllByMarcaContainingIgnoreCase(marca));

	}

	@GetMapping("preco/{valorIn}/{valorFim}")
	public ResponseEntity<List<Produto>> getAllRange(@PathVariable BigDecimal valorIn,
			@PathVariable BigDecimal valorFim) {
		return ResponseEntity.ok(repository.RangePreco(valorIn, valorFim));
	}

	@GetMapping("porCategoria/{tipoId}/{valor}")
	public ResponseEntity<List<Produto>> getAllRange(@PathVariable long tipoId, @PathVariable BigDecimal valor) {
		return ResponseEntity.ok(repository.RangeTipoPreco(tipoId, valor));
		
	}

	@PostMapping
	public ResponseEntity<Produto> post(@RequestBody Produto produto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));

	}

	@PutMapping
	public ResponseEntity<Produto> put(@RequestBody Produto produto) {

		long p = produto.getId();
		for (Produto item : repository.findAll()) {
			if (p == item.getId()) {
				return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {

		repository.deleteById(id);
	}
}
