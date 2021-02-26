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

import com.teste.ed.model.Projeto;
import com.teste.ed.repository.ProjetoRepository;

@RestController
@RequestMapping(value="/api")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping("/projetos")
	public List<Projeto> listar() {
		return projetoRepository.findAll();
	}
	
	@GetMapping("/projeto/{id}")
	public Projeto listaUserUnico(@PathVariable(value="id") long id) {
		return projetoRepository.findById(id);
	}
	
	@PostMapping("/projeto")
	@ResponseStatus(HttpStatus.CREATED)
	public Projeto adicionar(@RequestBody Projeto projeto) {
		return projetoRepository.save(projeto);
	}
	
	@DeleteMapping("/projeto")
	public void deleteProjeto(@RequestBody Projeto projeto) {
		projetoRepository.delete(projeto);
	}
	
	@PutMapping("/projeto")
	public void updateProjeto(@RequestBody Projeto projeto) { 
		projetoRepository.save(projeto);
	}
}
