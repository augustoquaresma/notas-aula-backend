package br.ufra.edu.aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufra.edu.aula.model.Nota;

@Repository
public interface INotas extends JpaRepository<Nota, Long> {
	
}
