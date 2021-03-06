package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AdministradorDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.AdministradorDAO;

public class AdministradorDAOSQL implements AdministradorDAO {

	private static final String insert = "INSERT INTO administrador(nombre, apellido, dni, idLogin, mail, idLocal)" + " VALUES (?, ?, ?, ?, ?, ?)";
	private static final String readall = "SELECT * FROM administrador";
	private static final String update = "UPDATE administrador SET nombre = ?, apellido = ?, dni = ? WHERE idAdministrador = ?";
	private static final String updateMail = "UPDATE administrador SET mail = ? WHERE idAdministrador = ?";
	private static final String browse = "SELECT * FROM administrador WHERE idAdministrador = ?";
	private static final String browseLogin = "SELECT * FROM administrador WHERE idLogin = ?";
	private static final String browseByMail = "SELECT * FROM administrador WHERE mail = ?";
	private static final String delete = "DELETE FROM administrador WHERE idAdministrador = ?";

	@Override
	public boolean insert(AdministradorDTO administrador) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setString(1, administrador.getNombre());
			statement.setString(2, administrador.getApellido());
			statement.setString(3, administrador.getDni());
			statement.setInt(4, administrador.getDatosLogin().getIdDatosLogin());
			statement.setString(5, administrador.getMail());
			statement.setInt(6, administrador.getLocal().getIdLocal());

			if (statement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}
	@Override
	public List<AdministradorDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Conexion conexion = Conexion.getConexion();

		ArrayList<AdministradorDTO> administrador = new ArrayList<AdministradorDTO>();
		LoginDAOSQL login = new LoginDAOSQL();
		LocalDAOSQL local = new LocalDAOSQL();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				administrador.add(
						new AdministradorDTO(
								resultSet.getInt("idAdministrador"),
								resultSet.getString("nombre"),
								resultSet.getString("apellido"),
								resultSet.getString("dni"),
								login.getById(resultSet.getInt("idLogin")),
								resultSet.getString("mail" ),
								local.getById(resultSet.getInt("idLocal"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administrador;
	}

	@Override
	public boolean update(AdministradorDTO administrador) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(update);

			statement.setString(1, administrador.getNombre());
			statement.setString(2, administrador.getApellido());
			statement.setString(3, administrador.getDni());
			statement.setInt(4, administrador.getIdAdministrador()); 

			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateMail(AdministradorDTO administrador) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(updateMail);

			statement.setString(1, administrador.getMail());
			statement.setInt(2, administrador.getIdAdministrador()); // deberia

			chequeoUpdate = statement.executeUpdate();
			if (chequeoUpdate > 0) // Si se ejecutó devuelvo true
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public AdministradorDTO getById(int id ){
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		AdministradorDTO dto;
		
		LoginDAOSQL login = new LoginDAOSQL();
		LocalDAOSQL local = new LocalDAOSQL();
		try{
			statement = conexion.getSQLConexion().prepareStatement(browse);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				dto = new AdministradorDTO(
						resultSet.getInt("idAdministrador"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido"),
						resultSet.getString("dni"),
						login.getById(resultSet.getInt("idLogin")),
						resultSet.getString("mail"),
						local.getById(resultSet.getInt("idLocal")));
				return dto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public AdministradorDTO getByLoginId(int id ){
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		AdministradorDTO dto;
		
		LoginDAOSQL login = new LoginDAOSQL();
		LocalDAOSQL local = new LocalDAOSQL();
		try{
			statement = conexion.getSQLConexion().prepareStatement(browseLogin);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				dto = new AdministradorDTO(
						resultSet.getInt("idAdministrador"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido"),
						resultSet.getString("dni"),
						login.getById(resultSet.getInt("idLogin")),
						resultSet.getString("mail"),
						local.getById(resultSet.getInt("idLocal")));
				return dto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}
	
	public AdministradorDTO getByMail(String mail ){
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		AdministradorDTO dto;
		
		LoginDAOSQL login = new LoginDAOSQL();
		LocalDAOSQL local = new LocalDAOSQL();
		try{
			statement = conexion.getSQLConexion().prepareStatement(browseByMail);
			statement.setString(1, mail);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				dto = new AdministradorDTO(
						resultSet.getInt("idAdministrador"),
						resultSet.getString("nombre"),
						resultSet.getString("apellido"),
						resultSet.getString("dni"),
						login.getById(resultSet.getInt("idLogin")),
						resultSet.getString("mail"),
						local.getById(resultSet.getInt("idLocal")));
				return dto;
			}
			
		}catch (SQLException e){
			 e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean delete( int idAdministrador ) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, idAdministrador);
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		AdministradorDAOSQL dao = new AdministradorDAOSQL();
		
		List<AdministradorDTO> list = dao.readAll();
		
		AdministradorDTO adm = dao.getByMail("nico@gmail.com");
		if(adm!=null)
			System.out.println(adm.getNombre());
		else
			System.out.println("no existe");
//		
//		
//		for(AdministradorDTO elem: list){
//			System.out.println(elem.getNombre());
//		}
//		System.out.println(dao.getByLoginId(2).getNombre());
//		System.out.println(dao.getByLoginId(5).getNombre());
	}

	
}
