package br.com.viniciuspontes.scrud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.viniciuspontes.scrud.domain.Cliente;
import br.com.viniciuspontes.scrud.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;
	
	//Método para pesquisar todos os clientes com paginador
	@GetMapping()
	public Page<Cliente> pesquisar(@RequestParam(required = false, 
	       defaultValue = "") String nome, Pageable pageable) {
		return clienteService.pesquisar(nome, pageable);
	}
	//Método para pesquisar todos os clientes
	@GetMapping("/todos")
	public List<Cliente> listar() {
		return clienteService.listarTodos();
	}

	//Método para pesquisar um cliente por Id
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = clienteService.find(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	//Método para cadastrar um novo cliente
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Cliente obj) {
		obj = clienteService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Método para alterar um novo cliente
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
		cliente.setId(id);
		cliente = clienteService.update(cliente);
		return ResponseEntity.noContent().build();
	}
	
	//Método para excluir um cliente
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
