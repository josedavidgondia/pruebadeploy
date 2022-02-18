package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

}
