package es.iespuertodelacruz.josedavid.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Operador;

public interface OperadorRepository extends JpaRepository<Operador, Integer>{

	@Query("SELECT t FROM Operador t where t.nick = :nick")
	Operador findByNick(@Param("nick") String nick);
}
