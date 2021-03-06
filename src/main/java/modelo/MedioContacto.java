package modelo;

import java.util.List;

import dto.MedioContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.MedioContactoDAO;

public class MedioContacto {

	private MedioContactoDAO medio;
	
	public MedioContacto(DAOAbstractFactory metodo_persistencia){
		this.medio = metodo_persistencia.createMedioContactoDAO();
	}
	
	public void agregarMedioContacto(MedioContactoDTO medio){
		this.medio.insert(medio);
	}
	
	public void editarMedioContacto(MedioContactoDTO medio) {
		this.medio.update(medio);
	}
	
	public List<MedioContactoDTO> obtenerMediosContacto(){
		return this.medio.readAll();		
	}
	
	public MedioContactoDTO getMedioContactoById(int idMedioContacto){
		return this.medio.getMedioContactoById(idMedioContacto);
	}
}