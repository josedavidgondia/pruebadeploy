package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Libro;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.LibroRepository;

@Service
public class LibroService implements GenericService<Libro, Integer>{

	@Autowired
	LibroRepository libroRepository;

	@Override
	public Iterable<Libro> findAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();
	}

	@Override
	public Page<Libro> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return libroRepository.findAll(page);
	}

	@Override
	public Optional<Libro> findById(Integer id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id);
	}

	@Override
	public Libro save(Libro objeto) {
		// TODO Auto-generated method stub
		return libroRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}

	@Override
	public void delete(Libro entity) {
		// TODO Auto-generated method stub
		libroRepository.delete(entity);
	}
}
