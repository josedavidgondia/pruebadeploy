package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Cliente;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.ClienteRepository;

@Service
public class ClienteService implements GenericService<Cliente, Integer> {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Page<Cliente> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return clienteRepository.findAll(page);
	}

	@Override
	public Optional<Cliente> findById(Integer id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente objeto) {
		// TODO Auto-generated method stub
		return clienteRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public void delete(Cliente entity) {
		// TODO Auto-generated method stub
		clienteRepository.delete(entity);
	}

}
