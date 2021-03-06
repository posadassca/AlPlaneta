package presentacion.vista.administrativo;

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

import persistencia.conexion.Conexion;
import java.awt.Component;
import javax.swing.Box;

public class VistaAdministrativo{
	
	private JFrame frame;
	private PanelCliente panelCliente;
	private PanelPasaje panelPasaje;
	private PanelEvento panelEvento;
	private PanelPromocion panelPromocion;

	private JMenuBar menuBar;
	private JMenu menuClientes;
	private JMenuItem itemVisualizarClientes;
	private JMenuItem itemRegistrarCliente;
	private JMenuItem itemEditarCliente;
	private JMenuItem itemActivarCliente;
	private JMenuItem itemDesactivarClientes;
	
	private JMenuItem itemVisualizarPasajes;
	private JMenuItem itemAgregarPasaje;
	private JMenuItem itemEditarPasaje ;
	private JMenuItem itemCancelarPasaje;
	
	private JMenu menuEventos;
	private JMenuItem itemAgregarEvento;
	private JMenuItem itemEditarEvento;
	private JMenuItem itemVisualizarEvento;
	 
	private JMenu menuPromociones;
	private JMenuItem itemAgregarPromocion;
	private JMenuItem itemEditarEstadoPromocion;
	private JMenuItem itemEditarPromocion;
	private JMenuItem itemVisualizarPromociones;
	
	private static VistaAdministrativo vistaAdministrativo;
	private JMenuItem itemRestablecerContrasena;
	private Component horizontalGlue;
	private JMenu menuUsuarioLogueado;
	private JMenuItem itemCambiarContrasenia;

	public static VistaAdministrativo getInstance(){
		if(vistaAdministrativo == null){	
			vistaAdministrativo = new VistaAdministrativo();
			return vistaAdministrativo;
		}else{
			return vistaAdministrativo;
		}
	}

	private VistaAdministrativo() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setTitle("Al Planeta Project");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setBounds(0, 0, 1366, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		panelCliente = new PanelCliente();
		panelCliente.getTablaClientes().setSize(1114, 900);
		panelCliente.setSize(1352, 700);
		panelCliente.setLocation(0, 0);
		frame.getContentPane().add(panelCliente);
		panelCliente.setVisible(false);
//		panelCliente.getBtnRecargarTabla().setVisible(true);
		
		panelPasaje = new PanelPasaje();
		panelPasaje.getTablaReservas().setSize(1114, 900);
		panelPasaje.setSize(1352, 700);
		panelPasaje.setLocation(0, 0);
		frame.getContentPane().add(panelPasaje);
		panelPasaje.setVisible(false);
		
		panelEvento = new PanelEvento();
		panelEvento.getTablaEventos().setSize(1114, 900);
		panelEvento.setSize(1352, 700);
		panelEvento.setLocation(0, 0);
		frame.getContentPane().add(panelEvento);
		panelEvento.setVisible(false);
		
		panelPromocion = new PanelPromocion();
		panelPromocion.getTablaPromocion().setSize(1114, 900);
		panelPromocion.setSize(1352, 700);
		panelPromocion.setLocation(0, 0);
		frame.getContentPane().add(panelPromocion);
		panelPromocion.setVisible(false);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		frame.setJMenuBar(menuBar);
		
		menuClientes = new JMenu("Clientes");
		menuClientes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuClientes);
		
		itemVisualizarClientes = new JMenuItem("Visualizar clientes");
		itemVisualizarClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemVisualizarClientes);

		itemRegistrarCliente = new JMenuItem("Registrar cliente");
		itemRegistrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemRegistrarCliente);

		itemEditarCliente = new JMenuItem("Editar cliente");
		itemEditarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemEditarCliente);

		itemActivarCliente = new JMenuItem("Activar cliente");
		itemActivarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemActivarCliente);

		itemDesactivarClientes = new JMenuItem("Desactivar cliente");
		itemDesactivarClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemDesactivarClientes);
		
		itemRestablecerContrasena = new JMenuItem("Restablecer contraseña");
		itemRestablecerContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuClientes.add(itemRestablecerContrasena);
		
		JMenu menuPasajes = new JMenu("Pasajes");
		menuPasajes.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuPasajes);
		
		itemVisualizarPasajes = new JMenuItem("Visualizar pasajes");
		itemVisualizarPasajes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPasajes.add(itemVisualizarPasajes);
		
		itemAgregarPasaje = new JMenuItem("Agregar pasaje");
		itemAgregarPasaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPasajes.add(itemAgregarPasaje);
		
		itemEditarPasaje = new JMenuItem("Editar pasaje");
		itemEditarPasaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPasajes.add(itemEditarPasaje);
		
		itemCancelarPasaje = new JMenuItem("Cancelar pasaje");
		itemCancelarPasaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPasajes.add(itemCancelarPasaje);
		
		menuEventos = new JMenu("Eventos");
		menuEventos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuEventos);
		
		itemVisualizarEvento = new JMenuItem("Visualizar eventos");
		itemVisualizarEvento.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuEventos.add(itemVisualizarEvento);

		itemAgregarEvento = new JMenuItem("Agregar evento");
		itemAgregarEvento.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuEventos.add(itemAgregarEvento);
		
		itemEditarEvento = new JMenuItem("Editar evento");
		itemEditarEvento.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuEventos.add(itemEditarEvento);
		
		
		menuPromociones = new JMenu("Promociones");
		menuPromociones.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuPromociones);
		
		itemVisualizarPromociones = new JMenuItem("Visualizar promociones");
		itemVisualizarPromociones.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPromociones.add(itemVisualizarPromociones);

		itemAgregarPromocion = new JMenuItem("Agregar promoción");
		itemAgregarPromocion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPromociones.add(itemAgregarPromocion);
		
		itemEditarPromocion = new JMenuItem("Editar promoción");
		itemEditarPromocion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPromociones.add(itemEditarPromocion);
		
		
		itemEditarEstadoPromocion = new JMenuItem("Modificar estado");
		itemEditarEstadoPromocion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuPromociones.add(itemEditarEstadoPromocion);
		
		horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		menuUsuarioLogueado = new JMenu(" ");
		menuUsuarioLogueado.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuUsuarioLogueado);
		
		itemCambiarContrasenia = new JMenuItem("Cambiar contraseña");
		itemCambiarContrasenia.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuUsuarioLogueado.add(itemCambiarContrasenia);
	
		JLabel labelMarcaDeAgua = new JLabel("");
		labelMarcaDeAgua.setIcon(new ImageIcon(VistaAdministrativo.class.getResource("/recursos/marcaAgua.png")));
		labelMarcaDeAgua.setBounds(47, 0, 1313, 674);
		frame.getContentPane().add(labelMarcaDeAgua);
	}
	
	public JMenu getMenuUsuarioLogueado() {
		return menuUsuarioLogueado;
	}

	public JMenuItem getItemCambiarContrasenia() {
		return itemCambiarContrasenia;
	}



	public JFrame getFrame() {
		return frame;
	}

	public PanelPasaje getPanelPasaje() {
		return panelPasaje;
	}
	
	public JMenuItem getItemVisualizarClientes() {
		return itemVisualizarClientes;
	}

	public JMenuItem getItemRegistrarCliente() {
		return itemRegistrarCliente;
	}
	
	public JMenuItem getItemEditarCliente() {
		return itemEditarCliente;
	}
	
	public JMenuItem getItemActivarCliente() {
		return itemActivarCliente;
	}
	
	public JMenuItem getItemDesactivarCliente() {
		return itemDesactivarClientes;
	}
	
	public JMenuItem getItemAgregarPasaje() {
		return itemAgregarPasaje;
	}

	public JMenuItem getItemVisualizarPasajes() {
		return itemVisualizarPasajes;
	}
	
	public JMenuItem getItemEditarPasaje() {
		return itemEditarPasaje;
	}

	public JMenuItem getItemCancelarPasaje() {
		return itemCancelarPasaje;
	}

	
	public PanelCliente getPanelCliente() {
		return panelCliente;
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
	public JMenu getMenuClientes() {
		return menuClientes;
	}
	

	public PanelEvento getPanelEvento() {
		return panelEvento;
	}

	public JMenu getMenuEventos() {
		return menuEventos;
	}

	public JMenuItem getItemAgregarEvento() {
		return itemAgregarEvento;
	}

	public JMenuItem getItemEditarEvento() {
		return itemEditarEvento;
	}
	
	public PanelPromocion getPanelPromocion() {
		return panelPromocion;
	}

	public JMenu getMenuPromociones() {
		return menuPromociones;
	}

	public JMenuItem getItemAgregarPromocion() {
		return itemAgregarPromocion;
	}

	public JMenuItem getItemEditarEstadoPromocion() {
		return itemEditarEstadoPromocion;
	}
	
	public JMenuItem getItemVisualizarPromociones() {
		return itemVisualizarPromociones;
	}

	public JMenuItem getItemRestablecerContrasena() {
		return itemRestablecerContrasena;
	}

	public void setItemRestablecerContrasena(JMenuItem itemRestablecerContrasena) {
		this.itemRestablecerContrasena = itemRestablecerContrasena;
	}

	public void mostrarVentana(){
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter(){
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
		this.frame.setVisible(true);
	}

	public JMenuItem getItemVisualizarEventos() {
		return itemVisualizarEvento;
	}

	public JMenuItem getItemEditarPromocion() {
		return itemEditarPromocion;
	}
}