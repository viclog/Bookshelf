package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AUTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Autor.findAll", query="SELECT a FROM Autor a")
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_AUTOR")
	private long idAutor;

	private String apellido;

	private String estado;

	private String nacionalidad;

	private String nombre;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="autor")
	private List<Libro> libros;

	public Autor() {
	}

	public long getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Libro addLibro(Libro libro) {
		getLibros().add(libro);
		libro.setAutor(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setAutor(null);

		return libro;
	}

}