package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Libro;


public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
