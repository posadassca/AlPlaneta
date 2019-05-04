package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public ClienteDAO createClienteDAO();
	
	public AdministradorDAO createAdministradorDAO();
	
	public AdministrativoDAO createAdministrativoDAO();
	
	public PasajeDAO createPasajeDAO();

	public CiudadDAO createCiudadDAO();

	public PasajeroDAO createPasajeroDAO();

	public MedioContactoDAO createMedioContactoDAO();

	public PagoDAO createPagoDAO();

	public TransporteDAO createTransporteDAO();

	public ViajeDAO createViajeDAO();
	
//	public CoordinadorDAO createCoordinadorDAO();


}
