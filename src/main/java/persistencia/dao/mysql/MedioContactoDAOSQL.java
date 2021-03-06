package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AdministrativoDTO;
import dto.MedioContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.MedioContactoDAO;

public class MedioContactoDAOSQL implements MedioContactoDAO {

	private static final String insert = "INSERT INTO mediocontacto(idMedioContacto, numeroFijo, numeroCelular, email) VALUES(?, ?, ?, ?)";
	private static final String readall = "SELECT * FROM mediocontacto";
	private static final String update = "UPDATE mediocontacto SET numeroFijo=? , numeroCelular=? , email=? WHERE idMedioContacto=? ;";
	private static final String browse = "SELECT * FROM mediocontacto WHERE idMedioContacto = ?";
	
	@Override
	public boolean insert(MedioContactoDTO medioContacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);		
			statement.setInt(1, medioContacto.getIdMedioContacto());
			statement.setString(2, medioContacto.getTelefonoFijo());
			statement.setString(3, medioContacto.getTelefonoCelular());
			statement.setString(4, medioContacto.getEmail());
	
		if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<MedioContactoDTO> readAll(){
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<MedioContactoDTO> mediosContacto = new ArrayList<MedioContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				mediosContacto.add(new MedioContactoDTO(
						resultSet.getInt("idMedioContacto"), 
						resultSet.getString("numeroFijo"),
						resultSet.getString("numeroCelular"),
						resultSet.getString("email")
				)
					);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return mediosContacto;
	}	
	
	@Override
	public boolean update(MedioContactoDTO medioContacto) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, medioContacto.getTelefonoFijo());
			statement.setString(2, medioContacto.getTelefonoCelular());
			statement.setString(3, medioContacto.getEmail());
			statement.setInt(4,medioContacto.getIdMedioContacto());

			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public MedioContactoDTO getMedioContactoById(int idMedioContacto ){
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		MedioContactoDTO medioContacto;
		try{
			statement = conexion.getSQLConexion().prepareStatement(browse);
			statement.setInt(1, idMedioContacto);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				medioContacto = new MedioContactoDTO(
						resultSet.getInt("idMedioContacto"), 
						resultSet.getString("numeroFijo"),
						resultSet.getString("numeroCelular"),
						resultSet.getString("email")
				);
				return medioContacto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MedioContactoDAOSQL dao = new MedioContactoDAOSQL();
		System.out.println(dao.getMedioContactoById(1).getEmail());
	}
}