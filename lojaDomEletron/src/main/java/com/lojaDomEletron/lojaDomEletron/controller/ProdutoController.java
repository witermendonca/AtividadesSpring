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

	@GetMapping("preco/{precoIn}/{precoFim}")
	public ResponseEntity<List<Produto>> getByPreco(@PathVariable BigDecimal precoIn,
			@PathVariable BigDecimal precoFim) {

		return ResponseEntity.ok(repository.findByPrecoBetween(precoIn, precoFim));
	}

	@GetMapping("porCategoria/{categoriaId}/{preco}")
	public ResponseEntity<List<Produto>> getByCategoriaIdAndPreco(@PathVariable long categoriaId,

			@PathVariable BigDecimal preco) {

		return ResponseEntity.ok(repository.findByCategoriaProdutoIdAndPrecoLessThanEqual(categoriaId, preco));

	}

	@GetMapping("/porTipoDes/{descricao}/{valor}")
	public ResponseEntity<List<Produto>> getByDesPreco(@PathVariable String descricao, @PathVariable BigDecimal valor) {
		return ResponseEntity.ok(repository.findByDesPreco(descricao, valor));
	}

	@GetMapping("/porTipoId/{id}/{valor}")
	public ResponseEntity<List<Produto>> getByDesPreco(@PathVariable long id, @PathVariable BigDecimal valor) {
		return ResponseEntity.ok(repository.findByIdPreco(id, valor));
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
