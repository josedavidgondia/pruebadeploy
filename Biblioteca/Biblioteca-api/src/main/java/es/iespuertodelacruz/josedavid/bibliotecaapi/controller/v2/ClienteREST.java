package es.iespuertodelacruz.josedavid.bibliotecaapi.controller.v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.josedavid.bibliotecaapi.dto.ClienteDTO;
import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Cliente;
import es.iespuertodelacruz.josedavid.bibliotecaapi.service.ClienteService;

@RestController
@RequestMapping("/api/v2/clientes")
public class ClienteREST {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public Collection<ClienteDTO> getAll(
			
			//@RequestParam(required=false, name="nombre") String nombre
			){
		List l = new ArrayList<ClienteDTO>();
		//if(nombre == null) {
			for(Cliente o: clienteService.findAll()) {
				l.add(new ClienteDTO(o));
			}
		/*}else {
			for(Usuarioconrol u: usuarioService.findByNameLike(nombre)) {
				l.add(new UsuarioDTO(u));
			}
		}*/
		return l;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable("id") int id) {
		
		Optional<Cliente> optCliente = clienteService.findById(id);
		if(optCliente.isPresent()) {
			
			return ResponseEntity.ok(new ClienteDTO(optCliente.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	

	@PostMapping
	public ResponseEntity<?> save(@RequestBody ClienteDTO mDTO){
		Cliente u = new Cliente();
		u.setNombre(mDTO.getNombre());
		u.setApellidos(mDTO.getApellidos());
		u.setDireccion(mDTO.getDireccion());
		u.setPrestamos(mDTO.getPrestamos());
		
		try {
			clienteService.save(u);
			return ResponseEntity.ok().body(new ClienteDTO(u));
		}catch(Exception ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la insercion ha fallado o ya existe en la base de datos");
		}
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Cliente> optA = clienteService.findById(id);
		if(optA.isPresent()) {
			clienteService.deleteById(id);
			return ResponseEntity.ok("operador borrado");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ClienteDTO mDTO){
		Optional<Cliente> optM = clienteService.findById(id);
		if(optM.isPresent()) {
			Cliente u = optM.get();
			u.setNombre(mDTO.getNombre());
			u.setApellidos(mDTO.getApellidos());
			u.setDireccion(mDTO.getDireccion());
			u.setPrestamos(mDTO.getPrestamos());
			try {
				clienteService.save(u);
				return ResponseEntity.ok().body(new ClienteDTO(u));
			}catch(Exception ex){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la actualizacion ha fallado o ya existe en la base de datos");
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el id del registro no existe");
		}
	}

}
