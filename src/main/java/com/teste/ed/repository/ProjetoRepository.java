package com.teste.ed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.ed.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
	
	Projeto findById(long id);
	
}
