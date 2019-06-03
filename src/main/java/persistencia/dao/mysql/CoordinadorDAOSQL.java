package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AdministradorDTO;
import dto.ClienteDTO;
import dto.CoordinadorDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CoordinadorDAO;

public class CoordinadorDAOSQL implements CoordinadorDAO {
	
	private static final String insert = "INSERT INTO coordinador(idCoordinador, nombre, idLogin)  VALUES (?, ?, ?)";

	private static final String readall = "SELECT * FROM coordinador";

	private static final String update = "UPDATE coordinador SET nombre = ? WHERE idCoordinador = ?";
	
	private static final String browse = "SELECT * FROM coordinador WHERE idCoordinador = ?";
	private static final String browseLogin = "SELECT * FROM coordinador WHERE idLogin = ?";


	@Override
	public boolean insert(CoordinadorDTO coordinador) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, coordinador.getIdCoordinador());
			statement.setString(2, coordinador.getNombre());
			statement.setInt(3, coordinador.getDatosLogin().getIdDatosLogin());

			if (statement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public List<CoordinadorDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();

		ArrayList<CoordinadorDTO> coordinador = new ArrayList<CoordinadorDTO>();
		LoginDAOSQL dao = new LoginDAOSQL();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				coordinador.add(
						new CoordinadorDTO(
								resultSet.getInt("idCoordinador"),
								resultSet.getString("nombre"),
								dao.getById(resultSet.getInt("idLogin"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coordinador;
	}

	@Override
	public boolean update(CoordinadorDTO coordinador) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);

			statement.setString(1, coordinador.getNombre());
			statement.setInt(2, coordinador.getIdCoordinador()); // deberia
			statement.setInt(3, coordinador.getDatosLogin().getIdDatosLogin());

			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CoordinadorDTO getByLoginId(int id) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		CoordinadorDTO dto;
		
		LoginDAOSQL dao = new LoginDAOSQL();
		try{
			statement = conexion.getSQLConexion().prepareStatement(browseLogin);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				dto = new CoordinadorDTO(
						resultSet.getInt("idCoordinador"),
						resultSet.getString("nombre"),
						dao.getById(resultSet.getInt("idLogin")));
				return dto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}

	@Override
	public CoordinadorDTO getById(int id) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		CoordinadorDTO dto;
		
		LoginDAOSQL dao = new LoginDAOSQL();
		try{
			statement = conexion.getSQLConexion().prepareStatement(browse);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				dto = new CoordinadorDTO(
						resultSet.getInt("idCoordinador"),
						resultSet.getString("nombre"),
						dao.getById(resultSet.getInt("idLogin")));
				return dto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		CoordinadorDAOSQL dao = new CoordinadorDAOSQL();
		
		List<CoordinadorDTO> list = dao.readAll();
		
		for(CoordinadorDTO elem: list){
			System.out.println(elem.getNombre());
		}
		
		System.out.println(dao.getByLoginId(3).getDatosLogin().getUsuario());
		
	}

	@Override
	public CoordinadorDTO getByMail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
