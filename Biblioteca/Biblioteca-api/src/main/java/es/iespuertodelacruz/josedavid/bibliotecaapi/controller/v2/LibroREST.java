package es.iespuertodelacruz.josedavid.bibliotecaapi.controller.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.josedavid.bibliotecaapi.service.LibroService;

@RestController
@RequestMapping("/api/v2/libros")
public class LibroREST {

	@Autowired
	private LibroService libroService;
}
