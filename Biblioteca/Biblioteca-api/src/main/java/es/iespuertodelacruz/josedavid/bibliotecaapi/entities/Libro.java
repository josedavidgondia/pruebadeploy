package es.iespuertodelacruz.josedavid.bibliotecaapi.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int libroid;

	private String editorial;

	private String titulo;

	//bi-directional many-to-one association to Ejemplar
	@OneToMany(mappedBy="libro")
	private List<Ejemplar> ejemplares;

	//bi-directional many-to-many association to Autor
	@ManyToMany(mappedBy="libros")
	private List<Autor> autores;

	public Libro() {
	}

	public int getLibroid() {
		return this.libroid;
	}

	public void setLibroid(int libroid) {
		this.libroid = libroid;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Ejemplar> getEjemplares() {
		return this.ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Ejemplar addEjemplare(Ejemplar ejemplare) {
		getEjemplares().add(ejemplare);
		ejemplare.setLibro(this);

		return ejemplare;
	}

	public Ejemplar removeEjemplare(Ejemplar ejemplare) {
		getEjemplares().remove(ejemplare);
		ejemplare.setLibro(null);

		return ejemplare;
	}

	public List<Autor> getAutores() {
		return this.autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}