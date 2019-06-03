package persistencia.dao.interfaz;

import java.util.List;

import dto.PasajeDTO;

public interface PasajeDAO {

	public List<PasajeDTO> readAll();

	boolean update(PasajeDTO pasaje_editar);

	boolean delete(PasajeDTO reserva_a_eliminar);

	boolean insert(PasajeDTO reserva);

	public PasajeDTO getPasajeById(int idPasaje);

	public PasajeDTO getUltimoRegistroPasaje();
}

