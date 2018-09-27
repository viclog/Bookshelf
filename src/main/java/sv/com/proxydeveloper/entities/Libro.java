package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LIBROS database table.
 * 
 */
@Entity
@Table(name="LIBROS")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LIBRO")
	private long idLibro;

	@Column(name="NOMBRE_ARCHIVO")
	private String nombreArchivo;

	@Column(name="TITULO_LIBRO")
	private String tituloLibro;

	//bi-directional many-to-one association to Autor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AUTOR")
	private Autor autor;

	//bi-directional many-to-many association to BibliotecaUsuario
	@ManyToMany
	@JoinTable(
		name="LIBROS_BIBLIOTECA"
		, joinColumns={
			@JoinColumn(name="ID_LIBRO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_BIBLIOTECA")
			}
		)
	private List<BibliotecaUsuario> bibliotecaUsuarios;

	//bi-directional many-to-one association to Editorial
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_EDITORIAL")
	private Editorial editorial;

	//bi-directional many-to-many association to Genero
	@ManyToMany
	@JoinTable(
		name="LIBRO_GENERO"
		, joinColumns={
			@JoinColumn(name="ID_LIBRO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_GENERO")
			}
		)
	private List<Genero> generos;

	public Libro() {
	}

	public long getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTituloLibro() {
		return this.tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<BibliotecaUsuario> getBibliotecaUsuarios() {
		return this.bibliotecaUsuarios;
	}

	public void setBibliotecaUsuarios(List<BibliotecaUsuario> bibliotecaUsuarios) {
		this.bibliotecaUsuarios = bibliotecaUsuarios;
	}

	public Editorial getEditorial() {
		return this.editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Genero> getGeneros() {
		return this.generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

}