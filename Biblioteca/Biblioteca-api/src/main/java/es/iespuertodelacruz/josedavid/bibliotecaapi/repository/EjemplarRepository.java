package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer>{

}
