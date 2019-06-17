package persistencia.conexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Conexion {

	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);
	
	private Conexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			//
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alplaneta_grupo3","root","pass");
			log.info("Conexion exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}

	public static Conexion getConexion(){								
		if(instancia == null){
			instancia = new Conexion();
		}
		return instancia;
	}
		
	public Connection getSQLConexion(){
			return this.connection;
	}
		
	public void cerrarConexion(){
		try {
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e){
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}