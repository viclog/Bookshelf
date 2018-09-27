package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BIBLIOTECA_USUARIO database table.
 * 
 */
@Entity
@Table(name="BIBLIOTECA_USUARIO")
@NamedQuery(name="BibliotecaUsuario.findAll", query="SELECT b FROM BibliotecaUsuario b")
public class BibliotecaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_BIBLIOTECA")
	private long idBiblioteca;

	@Column(name="NOMBRE_BIBLIOTECA")
	private String nombreBiblioteca;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	//bi-directional many-to-many association to Libro
	@ManyToMany(mappedBy="bibliotecaUsuarios")
	private List<Libro> libros;

	public BibliotecaUsuario() {
	}

	public long getIdBiblioteca() {
		return this.idBiblioteca;
	}

	public void setIdBiblioteca(long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	public String getNombreBiblioteca() {
		return this.nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}