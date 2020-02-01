package br.com.viniciuspontes.scrud.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciuspontes.scrud.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	public Page<Estado> findByNomeContaining(String nome, Pageable pageable);
}
