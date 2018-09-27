package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GENERO database table.
 * 
 */
@Entity
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GENERO")
	private long idGenero;

	@Column(name="NOMBRE_GENERO")
	private String nombreGenero;

	//bi-directional many-to-many association to Libro
	@ManyToMany(mappedBy="generos")
	private List<Libro> libros;

	public Genero() {
	}

	public long getIdGenero() {
		return this.idGenero;
	}

	public void setIdGenero(long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombreGenero() {
		return this.nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}