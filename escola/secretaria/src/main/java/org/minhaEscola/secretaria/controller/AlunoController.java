package org.minhaEscola.secretaria.controller;

import java.util.List;

import org.minhaEscola.secretaria.model.Aluno;
import org.minhaEscola.secretaria.repository.AlunoRepository;
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
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

	@Autowired
	private AlunoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> GetALL(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> GetByID(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Aluno> post (@RequestBody Aluno postagem){
			
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
			
		}
	@PutMapping
	public ResponseEntity<Aluno> put (@RequestBody Aluno aluno){
			
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
			
		}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id) {
		
		repository.deleteById(id);
	}
	
}
