package com.teste.ed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.ed.model.Pessoa;
import com.teste.ed.repository.PessoaRepository;

@RestController
@RequestMapping(value="/api")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}
	
	@GetMapping("/pessoa/{id}")
	public Pessoa listaUserUnico(@PathVariable(value="id") long id) {
		return pessoaRepository.findById(id);
	}
	
	@PostMapping("/pessoa")
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/pessoa")
	public void deletePessoa(@RequestBody Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
	@PutMapping("/pessoa")
	public void updatePessoa(@RequestBody Pessoa pessoa) { 
		pessoaRepository.save(pessoa);
	}
}
