package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Operador;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.OperadorRepository;

@Service
public class OperadorService implements GenericService<Operador, Integer> {

	@Autowired
	OperadorRepository operadorRepository;

	@Override
	public Iterable<Operador> findAll() {
		// TODO Auto-generated method stub
		return operadorRepository.findAll();
	}

	@Override
	public Page<Operador> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return operadorRepository.findAll(page);
	}

	@Override
	public Optional<Operador> findById(Integer id) {
		// TODO Auto-generated method stub
		return operadorRepository.findById(id);
	}

	@Override
	public Operador save(Operador objeto) {
		// TODO Auto-generated method stub
		return operadorRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		operadorRepository.deleteById(id);
	}

	@Override
	public void delete(Operador entity) {
		// TODO Auto-generated method stub
		operadorRepository.delete(entity);
	}
	
	@Transactional(readOnly=true)
	public Operador findByNick(String nick) {
		// TODO Auto-generated method stub
		return operadorRepository.findByNick(nick);
	}
}
