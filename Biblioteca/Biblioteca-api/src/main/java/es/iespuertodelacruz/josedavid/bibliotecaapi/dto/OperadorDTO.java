package es.iespuertodelacruz.josedavid.bibliotecaapi.dto;

import org.springframework.stereotype.Component;

import es.iespuertodelacruz.josedavid.bibliotecaapi.entities.Operador;

@Component
public class OperadorDTO {

	private int operadorid;

	private String nick;

	private String password;

	private String rol;
	
	

	public OperadorDTO() {
	}
	
	

	public OperadorDTO(Operador operador) {
		this.operadorid = operador.getOperadorid();
		this.nick = operador.getNick();
		this.password = operador.getPassword();
		this.rol = operador.getPassword();
	}



	public int getOperadorid() {
		return operadorid;
	}

	public void setOperadorid(int operadorid) {
		this.operadorid = operadorid;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
