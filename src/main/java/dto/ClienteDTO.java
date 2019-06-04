package dto;

import java.sql.Date;

public class ClienteDTO {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String dni;
	private Date fechaNacimiento;
	private MedioContactoDTO medioContacto;
	private LoginDTO login;
	private String mail;
	private int puntos;

	public ClienteDTO(int idCliente, String nombre, String apellido, String dni, Date fechaNacimiento, MedioContactoDTO medioContacto, LoginDTO login){
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.medioContacto = medioContacto;
		this.login = login;
		this.mail = medioContacto.getEmail();
		this.puntos = 0;
	}

	public ClienteDTO() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public MedioContactoDTO getMedioContacto() {
		return medioContacto;
	}

	public void setMedioContacto(MedioContactoDTO medioContacto) {
		this.medioContacto = medioContacto;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

	public String getMail() {
		return mail;
	}
	
}