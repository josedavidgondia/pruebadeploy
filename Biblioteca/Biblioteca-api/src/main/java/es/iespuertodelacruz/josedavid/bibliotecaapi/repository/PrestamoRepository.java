package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{

}
