package es.iespuertodelacruz.josedavid.bibliotecaapi.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operadores database table.
 * 
 */
@Entity
@Table(name="operadores")
@NamedQuery(name="Operador.findAll", query="SELECT o FROM Operador o")
public class Operador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int operadorid;

	private String nick;

	private String password;

	private String rol;

	public Operador() {
	}

	public int getOperadorid() {
		return this.operadorid;
	}

	public void setOperadorid(int operadorid) {
		this.operadorid = operadorid;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}