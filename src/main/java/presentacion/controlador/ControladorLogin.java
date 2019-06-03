package presentacion.controlador;

import java.awt.event.ActionEvent;

import dto.AdministradorDTO;
import dto.AdministrativoDTO;
import dto.ClienteDTO;
import dto.CoordinadorDTO;
import dto.LoginDTO;
import modelo.Administrador;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Coordinador;
import modelo.Login;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.VentanaLogin;
import presentacion.vista.administrador.VistaAdministrador;
import presentacion.vista.administrativo.VistaAdministrativo;
import presentacion.vista.cliente.VistaCliente;
import presentacion.vista.coordinador.VistaCoordinador;

public class ControladorLogin {

	private VentanaLogin ventanaLogin;
	private VistaAdministrador vistaAdministrador;
	private VistaAdministrativo vistaAdministrativo;
	private VistaCoordinador vistaCoordinador;
	
	private VistaCliente vistaCliente;
	private Login login;
	private LoginDTO usuarioLogueado;
	private AdministrativoDTO administrativoLogueado;
	private ClienteDTO clienteLogueado;
	private AdministradorDTO administradorLogueado;
	private CoordinadorDTO coordinadorLogueado;
	
	
	public ControladorLogin(VentanaLogin ventanaLogin, Login login){
		this.ventanaLogin = ventanaLogin;
		this.vistaAdministrador = VistaAdministrador.getInstance();
		this.vistaAdministrativo = new VistaAdministrativo(); //cambiar esto por getInstance()
		this.vistaCoordinador = VistaCoordinador.getInstance();
		this.vistaCliente = VistaCliente.getInstance();
		
		this.login = login;
		this.usuarioLogueado = null;
		this.administradorLogueado = null;
		this.clienteLogueado = null;
		this.coordinadorLogueado = null;
	
		this.ventanaLogin.getBtnLogin().addActionListener(log->loguearse(log));
	}
	
	public void iniciar(){
		this.ventanaLogin.mostrarVentana(true);
	}
	
	private void loguearse(ActionEvent log) {
		String usuario = ventanaLogin.getTextUsuario().getText();
		String password = new String(ventanaLogin.getPasswordField().getPassword());
		try {
			usuarioLogueado = login.getLoginByDatos(usuario, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(usuarioLogueado==null){
			this.ventanaLogin.getLblError().setVisible(true);
			System.out.println("EL USUARIO O CONTRASENA ES INCORRECTO");
		}else{
			System.out.println("SE LOGEO CORRECTAMENTE CON:"+ usuarioLogueado.getUsuario()+usuarioLogueado.getContrasena());
			if(usuarioLogueado.getRol().getIdRol()==2){
				 administrativoLogueado = obtenerAdministrativo(usuarioLogueado);
				 mostrarVentanaAdministrativo();
			}else 
				if(usuarioLogueado.getRol().getIdRol()==3) {
					coordinadorLogueado = obtenerCoordinador(usuarioLogueado);
					 mostrarVentanaCoordinador();
			}else{
				if(usuarioLogueado.getRol().getIdRol()==5){
					 clienteLogueado = obtenerCliente(usuarioLogueado);
					 mostrarVentanaCliente();
				}
				else
					if(usuarioLogueado.getRol().getIdRol()==1){
						 administradorLogueado = obtenerAdministrador(usuarioLogueado);
						 mostrarVentanaAdministrador();
					}
			}
		}
	}
	
	/*Mostrar la ventana principal del cliente*/
	private void mostrarVentanaCliente() {
		System.out.println("Se Loguea como Cliente");
		System.out.println(clienteLogueado.getNombre());
		this.ventanaLogin.setVisible(false);	
		ControladorUsuario controladorUsuario = new ControladorUsuario(vistaCliente,clienteLogueado);
		controladorUsuario.inicializar();
	}

	/*Mostrar la ventana principal del personal administrativo*/
	private void mostrarVentanaAdministrativo() {
		System.out.println("Se Loguea Como Administrativo");
		System.out.println(administrativoLogueado.getNombre());
		this.ventanaLogin.setVisible(false);
		ControladorAdministrativo controladorPrueba = new ControladorAdministrativo(vistaAdministrativo,administrativoLogueado);
		controladorPrueba.inicializar();
	}
	
	/*Mostrar la ventana principal del coordinador*/
	private void mostrarVentanaCoordinador() {
		System.out.println("Se Loguea Como Coordinador");
		System.out.println(coordinadorLogueado.getNombre());
		this.ventanaLogin.setVisible(false);
		ControladorCOOR controladorCoordinador = new ControladorCOOR(vistaCoordinador,coordinadorLogueado);
		controladorCoordinador.inicializar();
	}
	
	private void mostrarVentanaAdministrador() {
		System.out.println("Se Loguea Como Administrador");
		System.out.println(administradorLogueado.getNombre());
		this.ventanaLogin.setVisible(false);
		ControladorAdministrador controladorAdministrador = new ControladorAdministrador(vistaAdministrador);
		controladorAdministrador.inicializar();
	}
		
		
/*-----------------------METODOS BUSCADOR POR ROLES ---------------------*/
	private AdministrativoDTO obtenerAdministrativo(LoginDTO loginUsuario) {
		Administrativo administrativo = new Administrativo(new DAOSQLFactory());
		return administrativo.getByLoginId(loginUsuario.getIdDatosLogin());
	}
	
	private AdministradorDTO obtenerAdministrador(LoginDTO loginUsuario) {
		Administrador administrador = new Administrador(new DAOSQLFactory());
		return administrador.getByLoginId(loginUsuario.getIdDatosLogin());
	}
	
	private CoordinadorDTO obtenerCoordinador(LoginDTO loginUsuario) {
		Coordinador coordinador = new Coordinador(new DAOSQLFactory());
		return coordinador.getByLoginId(loginUsuario.getIdDatosLogin());
	}
	
	
	private ClienteDTO obtenerCliente(LoginDTO loginUsuario) {
		Cliente cliente = new Cliente(new DAOSQLFactory());
		return cliente.getByLoginId(loginUsuario.getIdDatosLogin());
	}
}