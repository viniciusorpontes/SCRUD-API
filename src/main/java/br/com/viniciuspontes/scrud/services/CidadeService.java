package br.com.viniciuspontes.scrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.viniciuspontes.scrud.domain.Cidade;
import br.com.viniciuspontes.scrud.repositories.CidadeRepository;
import br.com.viniciuspontes.scrud.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Page<Cidade> pesquisar(String nome, Pageable pageable) {
		return cidadeRepository.findByNomeContaining(nome, pageable);
	}
	
	public List<Cidade> listarTodas() {
		return cidadeRepository.findAll();
	}

	public Cidade find(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Cidade.class.getName()));
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return cidadeRepository.save(obj);
	}
	
	public Cidade update(Cidade obj) {
		find(obj.getId());
		return cidadeRepository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		cidadeRepository.deleteById(id);		
	}
		
}

