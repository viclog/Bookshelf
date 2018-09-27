package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the EDITORIAL database table.
 * 
 */
@Entity
@NamedQuery(name="Editorial.findAll", query="SELECT e FROM Editorial e")
public class Editorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EDITORIAL")
	private long idEditorial;

	private String direccion;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to Libro
	@OneToMany(mappedBy="editorial")
	private List<Libro> libros;

	public Editorial() {
	}

	public long getIdEditorial() {
		return this.idEditorial;
	}

	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		libro.setEditorial(this);

		return libro;
	}

	public Libro removeLibro(Libro libro) {
		getLibros().remove(libro);
		libro.setEditorial(null);

		return libro;
	}

}