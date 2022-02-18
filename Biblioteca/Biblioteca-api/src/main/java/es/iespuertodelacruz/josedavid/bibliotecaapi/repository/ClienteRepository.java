package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
