package modelo;

import java.util.List;

import dto.CiudadDTO;
import persistencia.dao.interfaz.CiudadDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;

public class Ciudad {

	private CiudadDAO ciudad;
	
	public Ciudad(DAOAbstractFactory metodo_persistencia){
		this.ciudad = metodo_persistencia.createCiudadDAO();
	}
	
	public void agregarCiudad(CiudadDTO ciudad){
		this.ciudad.insert(ciudad);
	}
	
	public void borrarPersona(CiudadDTO ciudad){
		this.ciudad.delete(ciudad);
	}
	
	public void modificarPersona(CiudadDTO ciudad){
		this.ciudad.update(ciudad);
	}
	
	public List<CiudadDTO> obtenerCiudades() throws Exception{
		return this.ciudad.readAll();		
	}

	public void borrarCiudad(CiudadDTO ciudadDelete) throws Exception {
		this.ciudad.delete(ciudadDelete);
	}

	public void editarCiudad(CiudadDTO ciudadUpdate) throws Exception {
		this.ciudad.update(ciudadUpdate);
	}
}