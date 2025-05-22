package org.serratec.trabalhoIndividual.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.trabalhoIndividual.models.Funcionario;
import org.serratec.trabalhoIndividual.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository fr;
	
	@GetMapping
	public List<Funcionario> listarTodos(){
		return fr.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> listarId(@PathVariable Long id){
		Optional<Funcionario> funcionarioOpt = fr.findById(id);
		
		if(funcionarioOpt.isPresent()) {
			return ResponseEntity.ok(funcionarioOpt.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Funcionario> adicionar(@RequestBody @Valid Funcionario f){
		return ResponseEntity.ok(fr.save(f));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,@RequestBody @Valid Funcionario f){
		Optional<Funcionario> funcionarioOpt = fr.findById(id);
		
		if(!funcionarioOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		f.setId(id);
		return ResponseEntity.ok(fr.save(f));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Funcionario> remover(@PathVariable Long id){
		Optional<Funcionario> funcionarioOpt = fr.findById(id);
		
		if(!funcionarioOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		fr.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
