package es.iespuertodelacruz.josedavid.bibliotecaapi.dto;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Cliente;
import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Prestamo;

@Component
public class ClienteDTO {

	private int clienteid;

	private String apellidos;

	private String direccion;

	private String nombre;

	//TODO cambiar a DTO
	@JsonIgnore
	private List<Prestamo> prestamos;

	public ClienteDTO() {
	}

	public ClienteDTO(Cliente cliente) {
		this.clienteid = cliente.getClienteid();
		this.apellidos = cliente.getApellidos();
		this.direccion = cliente.getDireccion();
		this.nombre = cliente.getNombre();
		this.prestamos = cliente.getPrestamos();
	}

	public int getClienteid() {
		return clienteid;
	}

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	
	
	
	
	
}
