package persistencia.dao.interfaz;

public interface DAOAbstractFactory {
	
	public ClienteDAO createClienteDAO();
	
	public AdministradorDAO createAdministradorDAO();
	
	public ContadorDAO createContadorDAO();
	
	public AdministrativoDAO createAdministrativoDAO();
	
	public PasajeDAO createPasajeDAO();
	
	public PuntoDAO createPuntoDAO();

	public CiudadDAO createCiudadDAO();

	public PasajeroDAO createPasajeroDAO();

	public MedioContactoDAO createMedioContactoDAO();

	public PagoDAO createPagoDAO();

	public TransporteDAO createTransporteDAO();

	public ViajeDAO createViajeDAO();

	public LoginDAO createLoginDAO();

	public RolDAO createRolDAO();
	
	public ProvinciaDAO createProvinciaDAO();

	public PaisDAO createPaisDAO();

	public FormaPagoDAO createFormaPagoDAO();

	public Pasaje_PasajerosDAO createPasaje_PasajerosDAO();

	public EstadoPasajeDAO createEstadoPasajeDAO();
	
	public CoordinadorDAO createCoordinadorDAO();
	
	public RegimenPuntoDAO createRegimenPuntoDAO();

	public EstadoEventoDAO createEstadoEventoDAO();
	
	public EventoDAO createEventoDAO();

	public Pagos_PasajeDAO createPagos_PasajeDAO();

	public PromocionDAO createPromocionDAO();
	
	public Viaje_PromocionDAO createViaje_PromocionDAO();
	
	public LocalDAO createLocalDAO();

	public CondicionDeCancelacionDAO createCondicionDeCancelacionDAO();
	
	public TarjetaDAO createTarjetaDAO();
	
	public SueldoDAO createSueldoDAO();

	public Sueldos_EmpleadosDAO createSueldoEmpleadoDAO();

	public ServicioDAO createServicioDAO();

	public EgresoDAO createEgresoDAO();
}
