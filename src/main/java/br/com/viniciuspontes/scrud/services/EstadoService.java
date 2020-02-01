package br.com.viniciuspontes.scrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.viniciuspontes.scrud.domain.Estado;
import br.com.viniciuspontes.scrud.dto.EstadoDTO;
import br.com.viniciuspontes.scrud.repositories.EstadoRepository;
import br.com.viniciuspontes.scrud.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Page<Estado> pesquisar(String nome, Pageable pageable) {
		return estadoRepository.findByNomeContaining(nome, pageable);
	}
	
	public List<Estado> listarTodos() {
		return estadoRepository.findAll();
	}

	public Estado find(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nÃ£o encontrado! Id: " + id + " Tipo: " + Estado.class.getName()));
	}

	public Estado insert(Estado obj) {
		obj.setId(null);
		return estadoRepository.save(obj);
	}
	
	public Estado update(Estado obj) {
		Estado newObj = find(obj.getId());
		updateData(newObj, obj);
		return estadoRepository.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		estadoRepository.deleteById(id);		
	}
	
	public Estado fromDTO(EstadoDTO objDto) {
		return new Estado(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Estado newObj, Estado obj) {
		newObj.setNome(obj.getNome());	
	}
}

