package modelo;

import java.util.List;

import persistencia.dao.interfaz.AdministradorDAO;
import persistencia.dao.interfaz.AdministrativoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import dto.AdministradorDTO;
import dto.AdministrativoDTO;

public class Administrador {
	
private AdministradorDAO administrador;
	
	public Administrador(DAOAbstractFactory metodo_persistencia){
		this.administrador = metodo_persistencia.createAdministradorDAO();
	}
	
	public void agregarAdministrador(AdministradorDTO nuevoAdministrador){
		this.administrador.insert(nuevoAdministrador);
	}
	
	public List<AdministradorDTO> obtenerAdministradores(){
		return this.administrador.readAll();		
	}

	public AdministradorDTO getByLoginId(int idLogin) {
		return this.administrador.getByLoginId(idLogin);
	}
}