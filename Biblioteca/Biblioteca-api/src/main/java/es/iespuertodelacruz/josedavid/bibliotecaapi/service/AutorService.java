package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Autor;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.AutorRepository;

@Service
public class AutorService implements GenericService<Autor, Integer>{

	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public Iterable<Autor> findAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

	@Override
	public Page<Autor> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return autorRepository.findAll(page);
	}

	@Override
	public Optional<Autor> findById(Integer id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id);
	}

	@Override
	public Autor save(Autor objeto) {
		// TODO Auto-generated method stub
		return autorRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public void delete(Autor entity) {
		// TODO Auto-generated method stub
		autorRepository.delete(entity);
	}

}
