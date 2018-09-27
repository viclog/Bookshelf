package sv.com.proxydeveloper.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USUARIO")
	private long idUsuario;

	private String apellidos;

	private String contrasena;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date inscripcion;

	@Column(name="NOMBRE_US")
	private String nombreUs;

	private String nombres;

	private BigDecimal suscripcion;

	//bi-directional many-to-one association to BibliotecaUsuario
	@OneToMany(mappedBy="usuario")
	private List<BibliotecaUsuario> bibliotecaUsuarios;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getInscripcion() {
		return this.inscripcion;
	}

	public void setInscripcion(Date inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getNombreUs() {
		return this.nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public BigDecimal getSuscripcion() {
		return this.suscripcion;
	}

	public void setSuscripcion(BigDecimal suscripcion) {
		this.suscripcion = suscripcion;
	}

	public List<BibliotecaUsuario> getBibliotecaUsuarios() {
		return this.bibliotecaUsuarios;
	}

	public void setBibliotecaUsuarios(List<BibliotecaUsuario> bibliotecaUsuarios) {
		this.bibliotecaUsuarios = bibliotecaUsuarios;
	}

	public BibliotecaUsuario addBibliotecaUsuario(BibliotecaUsuario bibliotecaUsuario) {
		getBibliotecaUsuarios().add(bibliotecaUsuario);
		bibliotecaUsuario.setUsuario(this);

		return bibliotecaUsuario;
	}

	public BibliotecaUsuario removeBibliotecaUsuario(BibliotecaUsuario bibliotecaUsuario) {
		getBibliotecaUsuarios().remove(bibliotecaUsuario);
		bibliotecaUsuario.setUsuario(null);

		return bibliotecaUsuario;
	}

}