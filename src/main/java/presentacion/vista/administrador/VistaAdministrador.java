package presentacion.vista.administrador;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.conexion.Conexion;
import presentacion.vista.administrativo.VistaAdministrativo;
import java.awt.Component;
import javax.swing.Box;

public class VistaAdministrador extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelTransporte panelTransporte;
	private VentanaPanelGeneral panelGeneral;
	private PanelFormaPago panelFormaPago;
	private PanelEmpleados panelEmpleados;
	private PanelCondiciones panelCondiciones;
	private PanelLocales panelLocales;
	private PanelViajes panelViajes;
	
	private JMenuItem itemAgregarCuenta;
	private JMenuItem itemEditarCuenta;
	private JMenuItem itemEliminarCuenta;
	private JMenuItem itemActivarCuenta;
	private JMenuItem itemVisualizarTransportes;
	private JMenuItem itemAgregarTransporte;
	private JMenuItem itemEditarTransporte;
	private JMenuItem itemEliminarTransporte;
	private JMenuItem itemVisualizarFormaPago;
	private JMenuItem itemAgregarFormaPago;
	private JMenuItem itemEditarFormaPago;
	private JMenuItem itemEliminarFormaPago;
	private JMenuItem itemPais;
	private JMenuItem itemProvincia;
	private JMenuItem itemCiudad;
	private JMenuItem itemAgregarViaje;
	private JMenuItem itemEliminarPais;
	private JMenuItem itemEliminarCiudad;
	private JMenuItem itemEliminarProvincia;
	
	private JMenuItem itemVisualizarLocales;
	private JMenuItem itemAgregarLocales;
	private JMenuItem itemEditarLocal;
	private JMenuItem itemEliminarLocal;

	private JMenuItem itemBackup;
	private JMenuItem itemRestore;
	
	private static VistaAdministrador INSTANCE;
	private JMenuItem itemEditarViaje;
	private JMenuItem itemVisualizarViajes;
	private Component horizontalGlue;
	private JMenu menuUsuarioLogueado;
	private JMenuItem itemCambiarContrasenia;
	private JMenu menuCancelacion;
	private JMenuItem itemVisualizarCondicion;
	private JMenuItem itemAgregarCondicion;
	private JMenuItem itemEditarCondicion;
	private JMenuItem itemEliminarCondicion;
	private JMenuItem itemVisualizarCuentas;
	
	public static VistaAdministrador getInstance(){
		if(INSTANCE == null) {
			INSTANCE = new VistaAdministrador();
			return INSTANCE;
		}
		else {
			return INSTANCE;
		}
	}

	public void setPanelViajes(PanelViajes panelViajes) {
		this.panelViajes = panelViajes;
	}

	public VistaAdministrador() {
		super();
		setTitle("Administrador");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	
		setBounds(0, 0, 1366, 730);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConfiguraciones = new JMenu("Configuraciones");
		mnConfiguraciones.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnConfiguraciones);
		
		itemBackup = new JMenuItem("Backup");
		itemBackup.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConfiguraciones.add(itemBackup);
		
		itemRestore = new JMenuItem("Restore");
		itemRestore.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConfiguraciones.add(itemRestore);
		
		JMenu menuCuentas = new JMenu("Cuentas");
		menuCuentas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuCuentas);
		
		itemVisualizarCuentas = new JMenuItem("Visualizar Cuentas");
		itemVisualizarCuentas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCuentas.add(itemVisualizarCuentas);
		
		itemAgregarCuenta = new JMenuItem("Agregar Cuenta");
		itemAgregarCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCuentas.add(itemAgregarCuenta);

		itemEditarCuenta = new JMenuItem("Editar Cuenta");
		itemEditarCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCuentas.add(itemEditarCuenta);

		itemActivarCuenta = new JMenuItem("Activar Cuenta");
		itemActivarCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCuentas.add(itemActivarCuenta);

		itemEliminarCuenta = new JMenuItem("Desactivar Cuenta");
		itemEliminarCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCuentas.add(itemEliminarCuenta);
		
		JMenu menuViajes = new JMenu("Viajes");
		menuViajes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuViajes);
		
		itemVisualizarViajes = new JMenuItem("Visualizar viajes");
		itemVisualizarViajes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuViajes.add(itemVisualizarViajes);
		
		itemAgregarViaje = new JMenuItem("Agregar viaje");
		itemAgregarViaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuViajes.add(itemAgregarViaje);
		
		itemEditarViaje = new JMenuItem("Editar viaje");
		itemEditarViaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuViajes.add(itemEditarViaje);
		
		JMenu mnDestinos = new JMenu("Destinos");
		mnDestinos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(mnDestinos);
		
		itemPais = new JMenuItem("Menú de países");
		itemPais.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnDestinos.add(itemPais);
		
		itemProvincia = new JMenuItem("Menú de provincias");
		itemProvincia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnDestinos.add(itemProvincia);
		
		itemCiudad = new JMenuItem("Menú de ciudades");
		itemCiudad.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnDestinos.add(itemCiudad);
		
		
		JMenu menuTransporte = new JMenu("Transportes");
		menuTransporte.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuTransporte);
		
		itemVisualizarTransportes = new JMenuItem("Visualizar transportes");
		itemVisualizarTransportes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuTransporte.add(itemVisualizarTransportes);
		
		itemAgregarTransporte = new JMenuItem("Agregar transporte");
		itemAgregarTransporte.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuTransporte.add(itemAgregarTransporte);
		
		itemEditarTransporte = new JMenuItem("Editar transporte");
		itemEditarTransporte.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuTransporte.add(itemEditarTransporte);
		
		itemEliminarTransporte = new JMenuItem("Eliminar transporte");
		itemEliminarTransporte.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuTransporte.add(itemEliminarTransporte);
		
		
		panelCondiciones = new PanelCondiciones();
		panelCondiciones.getTablaCondiciones().setSize(1114, 900);
		panelCondiciones.setSize(1352, 700);
		panelCondiciones.setLocation(0, 0);
		getContentPane().add(panelCondiciones);
		panelCondiciones.setVisible(false);

		panelTransporte = new PanelTransporte();
		panelTransporte.getTablaTransportes().setSize(1114, 900);
		panelTransporte.setSize(1352, 700);
		panelTransporte.setLocation(0, 0);
		getContentPane().add(panelTransporte);
		panelTransporte.setVisible(false);
		
		panelEmpleados = new PanelEmpleados();
		panelEmpleados.getTablaEmpleados().setSize(1114, 900);
		panelEmpleados.setSize(1352, 700);
		panelEmpleados.setLocation(0, 0);
		getContentPane().add(panelEmpleados);
		panelEmpleados.setVisible(false);
		
		panelViajes = new PanelViajes();
		panelViajes.getTablaViajes().setSize(1114, 900);
		panelViajes.setSize(1352, 700);
		panelViajes.setLocation(0, 0);
		getContentPane().add(panelViajes);
		panelViajes.setVisible(false);
		
		
	//--------------------FormaPago-----------------------------------//	
		
		JMenu menuFormaPago = new JMenu("Formas de pago");
		menuFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFormaPago);
		
		itemVisualizarFormaPago = new JMenuItem("Visualizar formas de pago");
		itemVisualizarFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFormaPago.add(itemVisualizarFormaPago);
		
	    itemAgregarFormaPago = new JMenuItem("Agregar forma de pago");
		itemAgregarFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFormaPago.add(itemAgregarFormaPago);
		
		itemEditarFormaPago = new JMenuItem("Editar forma de pago");
		itemEditarFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFormaPago.add(itemEditarFormaPago);
		
		itemEliminarFormaPago = new JMenuItem("Eliminar forma de pago");
		itemEliminarFormaPago.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFormaPago.add(itemEliminarFormaPago);
		
		
				
		panelFormaPago = new PanelFormaPago();
		panelFormaPago.getTablaFormaPago().setSize(1114, 900);
		panelFormaPago.setSize(1352, 700);
		panelFormaPago.setLocation(0, 0);
		getContentPane().add(panelFormaPago);
		panelFormaPago.setVisible(false);
		
		//Locales
		
		JMenu menuLocales = new JMenu("Locales");
		menuLocales.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuLocales);
		
		itemVisualizarLocales = new JMenuItem("Visualizar locales");
		itemVisualizarLocales.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuLocales.add(itemVisualizarLocales);
		
		itemAgregarLocales = new JMenuItem("Agregar local");
		itemAgregarLocales.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuLocales.add(itemAgregarLocales);
		
		menuCancelacion = new JMenu("Condiciones");
		menuCancelacion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuCancelacion);
		
		itemVisualizarCondicion = new JMenuItem("Visualizar condiciones");
		itemVisualizarCondicion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCancelacion.add(itemVisualizarCondicion);
		
		itemAgregarCondicion = new JMenuItem("Agregar condición");
		itemAgregarCondicion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCancelacion.add(itemAgregarCondicion);
		
		itemEditarCondicion = new JMenuItem("Editar condición");
		itemEditarCondicion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCancelacion.add(itemEditarCondicion);
		
		itemEliminarCondicion = new JMenuItem("Eliminar condición");
		itemEliminarCondicion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuCancelacion.add(itemEliminarCondicion);
		
		horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		menuUsuarioLogueado = new JMenu(" ");
		menuUsuarioLogueado.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuUsuarioLogueado);
		
		itemCambiarContrasenia = new JMenuItem("Cambiar contraseña");
		itemCambiarContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuUsuarioLogueado.add(itemCambiarContrasenia);
		
		itemEditarLocal = new JMenuItem("Editar local");
		itemEditarLocal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuLocales.add(itemEditarLocal);
		
		itemEliminarLocal = new JMenuItem("Eliminar local");
		itemEliminarLocal.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuLocales.add(itemEliminarLocal);
		
		panelLocales = new PanelLocales();
		panelLocales.getTablaLocales().setLocation(11, 122);
		panelLocales.getTablaLocales().setSize(1319, 0);
		panelLocales.setSize(1352, 700);
		panelLocales.setLocation(0, 0);
		getContentPane().add(panelLocales);
		panelLocales.setVisible(false);
		
		JLabel labelMarcaDeAgua = new JLabel("");
		labelMarcaDeAgua.setIcon(new ImageIcon(VistaAdministrativo.class.getResource("/recursos/marcaAgua.png")));
		labelMarcaDeAgua.setBounds(47, 0, 1313, 674);
		getContentPane().add(labelMarcaDeAgua);
		this.setVisible(false);
	}
	
	public JMenu getMenuUsuarioLogueado() {
		return menuUsuarioLogueado;
	}

	public JMenuItem getItemCambiarContrasenia() {
		return itemCambiarContrasenia;
	}

	public PanelLocales getPanelLocales() {
		return panelLocales;
	}

	public void setPanelLocales(PanelLocales panelLocales) {
		this.panelLocales = panelLocales;
	}

	public JMenuItem getItemVisualizarLocales() {
		return itemVisualizarLocales;
	}

	public void setItemVisualizarLocales(JMenuItem itemVisualizarLocales) {
		this.itemVisualizarLocales = itemVisualizarLocales;
	}

	public JMenuItem getItemAgregarLocal() {
		return itemAgregarLocales;
	}

	public void setItemAgregarLocal(JMenuItem itemAgregarLocal) {
		this.itemAgregarLocales = itemAgregarLocal;
	}


	public JMenuItem getItemVisualizarCuentas() {
		return itemVisualizarCuentas;
	}

	public void setItemVisualizarCuentas(JMenuItem itemVisualizarCuentas) {
		this.itemVisualizarCuentas = itemVisualizarCuentas;
	}
	
	public JMenuItem getItemEditarLocal() {
		return itemEditarLocal;
	}

	public void setItemEditarLocal(JMenuItem itemEditarLocal) {
		this.itemEditarLocal = itemEditarLocal;
	}

	public JMenuItem getItemEliminarLocal() {
		return itemEliminarLocal;
	}

	public void setItemEliminarLocal(JMenuItem itemEliminarLocal) {
		this.itemEliminarLocal = itemEliminarLocal;
	}
	public JMenuItem getItemBackup() {
		return itemBackup;
	}

	public void setItemBackup(JMenuItem itemBackup) {
		this.itemBackup = itemBackup;
	}

	public JMenuItem getItemRestore() {
		return itemRestore;
	}

	public void setItemRestore(JMenuItem itemRestore) {
		this.itemRestore = itemRestore;
	}

	public PanelEmpleados getPanelEmpleados() {
		return panelEmpleados;
	}
	
	public PanelViajes getPanelViajes(){
		return this.panelViajes;
	}
	
	public void setItemAgregarCuenta(JMenuItem itemAgregarCuenta) {
		this.itemAgregarCuenta = itemAgregarCuenta;
	}
	public JMenuItem getItemAgregarCuenta() {
		return itemAgregarCuenta;
	}
	//-------------------------FormaPago-----------------------------------//
	
	public PanelFormaPago getPanelFormaPago() {
		return panelFormaPago;
	}

	public void setPanelFormaPago(PanelFormaPago panelFormaPago) {
		this.panelFormaPago = panelFormaPago;
	}

	public JMenuItem getItemVisualizarFormaPago() {
		return itemVisualizarFormaPago;
	}

	public void setItemVisualizarFormaPago(JMenuItem itemVisualizarFormaPago) {
		this.itemVisualizarFormaPago = itemVisualizarFormaPago;
	}

	public JMenuItem getItemAgregarFormaPago() {
		return itemAgregarFormaPago;
	}

	public void setItemAgregarFormaPago(JMenuItem itemAgregarFormaPago) {
		this.itemAgregarFormaPago = itemAgregarFormaPago;
	}

	public JMenuItem getItemEditarFormaPago() {
		return itemEditarFormaPago;
	}

	public void setItemEditarFormaPago(JMenuItem itemEditarFormaPago) {
		this.itemEditarFormaPago = itemEditarFormaPago;
	}

	public JMenuItem getItemEliminarFormaPago() {
		return itemEliminarFormaPago;
	}

	public void setItemEliminarFormaPago(JMenuItem itemEliminarFormaPago) {
		this.itemEliminarFormaPago = itemEliminarFormaPago;
	}
//-------------------------Transporte-----------------------------------//
	public void setPanelTransporte(PanelTransporte panelTransporte) {
		this.panelTransporte = panelTransporte;
	}

	public void setItemVisualizarTransportes(JMenuItem itemVisualizarTransportes) {
		this.itemVisualizarTransportes = itemVisualizarTransportes;
	}

	public void setItemAgregarTransporte(JMenuItem itemAgregarTransporte) {
		this.itemAgregarTransporte = itemAgregarTransporte;
	}

	public void setItemEditarTransporte(JMenuItem itemEditarTransporte) {
		this.itemEditarTransporte = itemEditarTransporte;
	}

	public void setItemEliminarTransporte(JMenuItem itemEliminarTransporte) {
		this.itemEliminarTransporte = itemEliminarTransporte;
	}
	

	public JMenuItem getItemEditarTransporte() {
		return itemEditarTransporte;
	}

	public PanelTransporte getPanelTransporte() {
		return panelTransporte;
	}

	public JMenuItem getItemVisualizarTransportes() {
		return itemVisualizarTransportes;
	}
	
	public JMenuItem getItemAgregarTransporte() {
		return itemAgregarTransporte;
	}
	public JMenuItem getItemEliminarTransporte() {
		return itemEliminarTransporte;
	}
	public void mostrarVentana(boolean visibilidad){
		this.setVisible(visibilidad);
	}
	
	public JMenuItem getItemPais() {
		return itemPais;
	}

	public void setItemPais(JMenuItem itemPais) {
		this.itemPais = itemPais;
	}

	public JMenuItem getItemProvincia() {
		return itemProvincia;
	}

	public void setItemProvincia(JMenuItem itemProvincia) {
		this.itemProvincia = itemProvincia;
	}

	public JMenuItem getItemCiudad() {
		return itemCiudad;
	}

	public void setItemCiudad(JMenuItem itemCiudad) {
		this.itemCiudad = itemCiudad;
	}

	public JMenuItem getItemAgregarViaje() {
		return itemAgregarViaje;
	}

	public void setItemAgregarViaje(JMenuItem itemAgregarViaje) {
		this.itemAgregarViaje = itemAgregarViaje;
	}

	public JMenuItem getItemEliminarPais() {
		return itemEliminarPais;
	}

	public void setItemEliminarPais(JMenuItem itemEliminarPais) {
		this.itemEliminarPais = itemEliminarPais;
	}

	public JMenuItem getItemEliminarCiudad() {
		return itemEliminarCiudad;
	}

	public void setItemEliminarCiudad(JMenuItem itemEliminarCiudad) {
		this.itemEliminarCiudad = itemEliminarCiudad;
	}

	public JMenuItem getItemEliminarProvincia() {
		return itemEliminarProvincia;
	}

	public void setItemEliminarProvincia(JMenuItem itemEliminarProvincia) {
		this.itemEliminarProvincia = itemEliminarProvincia;
	}

	public VentanaPanelGeneral getPanelGeneral() {
		return panelGeneral;
	}

	public void setPanelGeneral(VentanaPanelGeneral panelGeneral) {
		this.panelGeneral = panelGeneral;
	}

	public JMenuItem getItemEditarCuenta() {
		return itemEditarCuenta;
	}

	public void setItemEditarCuenta(JMenuItem itemEditarCuenta) {
		this.itemEditarCuenta = itemEditarCuenta;
	}

	public JMenuItem getItemEliminarCuenta() {
		return itemEliminarCuenta;
	}

	public void setItemEliminarCuenta(JMenuItem itemEliminarCuenta) {
		this.itemEliminarCuenta = itemEliminarCuenta;
	}
	
	public JMenuItem getItemActivarCuenta() {
		return itemActivarCuenta;
	}
	
	public void setItemActivarCuenta(JMenuItem itemActivarCuenta) {
		this.itemActivarCuenta = itemActivarCuenta;
	}
	
	
	public JMenuItem getItemEditarViaje() {
		return itemEditarViaje;
	}

	public void setItemEditarViaje(JMenuItem itemEditarViaje) {
		this.itemEditarViaje = itemEditarViaje;
	}
	
	

	public JMenuItem getItemVisualizarViajes() {
		return itemVisualizarViajes;
	}

	public void setItemVisualizarViajes(JMenuItem itemVisualizarViajes) {
		this.itemVisualizarViajes = itemVisualizarViajes;
	}

	public PanelCondiciones getPanelCondiciones() {
		return panelCondiciones;
	}

	public void setPanelCondiciones(PanelCondiciones panelCondiciones) {
		this.panelCondiciones = panelCondiciones;
	}


	public void mostrarVentana(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(
						null, "¿Estás seguro que quieres salir del programa?", 
						"Salir", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		setVisible(true);
	}

	public JMenu getMenuCancelacion() {
		return menuCancelacion;
	}

	public void setMenuCancelacion(JMenu menuCancelacion) {
		this.menuCancelacion = menuCancelacion;
	}

	public JMenuItem getItemVizualizarCondicion() {
		return itemVisualizarCondicion;
	}

	public void setItemVizualizarCondicion(JMenuItem itemVizualizarCondicion) {
		this.itemVisualizarCondicion = itemVizualizarCondicion;
	}

	public JMenuItem getItemAgregarCondicion() {
		return itemAgregarCondicion;
	}

	public void setItemAgregarCondicion(JMenuItem itemAgregarCondicion) {
		this.itemAgregarCondicion = itemAgregarCondicion;
	}

	public JMenuItem getItemEliminarCondicion() {
		return itemEliminarCondicion;
	}

	public void setItemEliminarCondicion(JMenuItem itemEliminarCondicion) {
		this.itemEliminarCondicion = itemEliminarCondicion;
	}

	public JMenuItem getItemEditarCondicion() {
		return itemEditarCondicion;
	}

	public void setItemEditarCondicion(JMenuItem itemEditarCondicion) {
		this.itemEditarCondicion = itemEditarCondicion;
	}
	
}