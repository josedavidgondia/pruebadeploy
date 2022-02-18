package es.iespuertodelacruz.josedavid.bibliotecaapi.controller.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.josedavid.bibliotecaapi.dto.OperadorDTO;
import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Operador;
import es.iespuertodelacruz.josedavid.bibliotecaapi.service.OperadorService;


@RestController
@RequestMapping("/api/v2/operadores")
public class OperadorREST {
	
	@Autowired
	private OperadorService operadorService;
	
	
	@GetMapping
	public Collection<OperadorDTO> getAll(
			
			//@RequestParam(required=false, name="nombre") String nombre
			){
		List l = new ArrayList<OperadorDTO>();
		//if(nombre == null) {
			for(Operador o: operadorService.findAll()) {
				l.add(new OperadorDTO(o));
			}
		/*}else {
			for(Usuarioconrol u: usuarioService.findByNameLike(nombre)) {
				l.add(new UsuarioDTO(u));
			}
		}*/
		return l;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getOperadorById(@PathVariable("id") int id) {
		
		Optional<Operador> optOperador = operadorService.findById(id);
		if(optOperador.isPresent()) {
			
			return ResponseEntity.ok(new OperadorDTO(optOperador.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PostMapping
	public ResponseEntity<?> save(@RequestBody OperadorDTO mDTO){
		Operador u = new Operador();
		u.setNick(mDTO.getNick());
		String salt = BCrypt.gensalt(10);
		String password = BCrypt.hashpw(mDTO.getPassword(), salt);
		u.setPassword(password);
		u.setRol(mDTO.getRol());
		try {
			operadorService.save(u);
			return ResponseEntity.ok().body(new OperadorDTO(u));
		}catch(Exception ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la insercion ha fallado o ya existe en la base de datos");
		}
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Operador> optA = operadorService.findById(id);
		if(optA.isPresent()) {
			operadorService.deleteById(id);
			return ResponseEntity.ok("operador borrado");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody OperadorDTO mDTO){
		Optional<Operador> optM = operadorService.findById(id);
		if(optM.isPresent()) {
			Operador u = optM.get();
			u.setNick(mDTO.getNick());
			String salt = BCrypt.gensalt(10);
			String password = BCrypt.hashpw(mDTO.getPassword(), salt);
			u.setPassword(password);
			u.setRol(mDTO.getRol());
			try {
				operadorService.save(u);
				return ResponseEntity.ok().body(new OperadorDTO(u));
			}catch(Exception ex){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la actualizacion ha fallado o ya existe en la base de datos");
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

}
