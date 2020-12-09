package com.farmacia.drogariaG.controller;

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

import com.farmacia.drogariaG.model.Categoria;
import com.farmacia.drogariaG.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getALL(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetByID(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria postagem){
			
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
			
		}
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria postagem){
			
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
			
		}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
	}
	
	
}
