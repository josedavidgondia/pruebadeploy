package es.iespuertodelacruz.josedavid.bibliotecaapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Prestamo;
import es.iespuertodelacruz.josedavid.bibliotecaapi.repository.PrestamoRepository;

@Service
public class PrestamoService implements GenericService<Prestamo, Integer>{

	@Autowired
	PrestamoRepository prestamoRepository;

	@Override
	public Iterable<Prestamo> findAll() {
		// TODO Auto-generated method stub
		return prestamoRepository.findAll();
	}

	@Override
	public Page<Prestamo> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return prestamoRepository.findAll(page);
	}

	@Override
	public Optional<Prestamo> findById(Integer id) {
		// TODO Auto-generated method stub
		return prestamoRepository.findById(id);
	}

	@Override
	public Prestamo save(Prestamo objeto) {
		// TODO Auto-generated method stub
		return prestamoRepository.save(objeto);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		prestamoRepository.deleteById(id);
	}

	@Override
	public void delete(Prestamo entity) {
		// TODO Auto-generated method stub
		prestamoRepository.delete(entity);
	}
}
