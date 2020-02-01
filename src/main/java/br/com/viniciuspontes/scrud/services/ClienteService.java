package br.com.viniciuspontes.scrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.viniciuspontes.scrud.domain.Cliente;
import br.com.viniciuspontes.scrud.repositories.ClienteRepository;
import br.com.viniciuspontes.scrud.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Page<Cliente> pesquisar(String nome, Pageable pageable) {
		return clienteRepository.findByNomeContaining(nome, pageable);
	}
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente find(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return clienteRepository.save(obj);
	}
	
	public Cliente update(Cliente cliente) {
		find(cliente.getId());
		return clienteRepository.save(cliente);
	}

	public void delete(Integer id) {
		find(id);
		clienteRepository.deleteById(id);		
	}
		
}



