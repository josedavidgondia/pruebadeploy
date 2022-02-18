package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Ejemplar;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.EjemplarRepository;

@Service
public class EjemplarService implements GenericService<Ejemplar, Integer> {

	@Autowired
	EjemplarRepository ejemplarRepository;
	
	@Override
	public Iterable<Ejemplar> findAll() {
		// TODO Auto-generated method stub
		return ejemplarRepository.findAll();
	}

	@Override
	public Page<Ejemplar> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return ejemplarRepository.findAll(page);
	}

	@Override
	public Optional<Ejemplar> findById(Integer id) {
		// TODO Auto-generated method stub
		return ejemplarRepository.findById(id);
	}

	@Override
	public Ejemplar save(Ejemplar objeto) {
		// TODO Auto-generated method stub
		return ejemplarRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		ejemplarRepository.deleteById(id);
	}

	@Override
	public void delete(Ejemplar entity) {
		// TODO Auto-generated method stub
		ejemplarRepository.delete(entity);
	}

}
