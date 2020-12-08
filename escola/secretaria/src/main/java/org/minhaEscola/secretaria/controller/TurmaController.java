package org.minhaEscola.secretaria.controller;

import java.util.List;


import org.minhaEscola.secretaria.model.Turma;
import org.minhaEscola.secretaria.repository.TurmaRepository;
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

@RestController
@RequestMapping("/turma")
@CrossOrigin("*")
public class TurmaController {

	@Autowired
	private TurmaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Turma>> GetALL(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> GetByID(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/turma/{turma}")
	public ResponseEntity<List<Turma>> GetByTurma(@PathVariable String turma){
	
	return ResponseEntity.ok(repository.findALLByTurmaContainingIgnoreCase(turma));
		
	}
	
	@PostMapping
	public ResponseEntity<Turma> post (@RequestBody Turma postagem){
			
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
			
		}
	@PutMapping
	public ResponseEntity<Turma> put (@RequestBody Turma postagem){
			
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
			
		}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
	}
}
