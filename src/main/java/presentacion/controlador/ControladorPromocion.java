package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import dto.PromocionDTO;
import dto.ViajeDTO;
import dto.Viaje_PromocionDTO;
import modelo.ModeloPromocion;
import modelo.ModeloViaje;
import modelo.ModeloViaje_Promocion;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.vista.administrativo.PanelPromocion;
import presentacion.vista.administrativo.VentanaEditarPromocion;
import presentacion.vista.administrativo.VentanaRegistrarPromocion;
import presentacion.vista.administrativo.VentanaTablaViajes;

public class ControladorPromocion {
	private VentanaTablaViajes ventanaTablaViajes;
	private List<ViajeDTO> viajes_en_tabla;
	private ModeloPromocion modeloPromocion;
	private ModeloViaje modeloViaje;
	private ModeloViaje_Promocion modeloViaje_Promocion;
	private VentanaRegistrarPromocion ventanaPromocion;
	private VentanaEditarPromocion ventanaEditarPromocion;
	private PanelPromocion panelPromocion;
	private PromocionDTO promocionSeleccionada;
	
	//DATOS PROMOCION:
	private List<ViajeDTO> viajes;
	private int porcentaje;
	private int stock;
	private java.sql.Date fechaVencimiento; 
	private String estado;		
	
	private PromocionDTO promocionRegistrada;

	public ControladorPromocion(VentanaRegistrarPromocion ventanaPromocion, ModeloPromocion promocion, List<PromocionDTO> promociones_en_tabla){

		//DATOS PROMOCION:
		this.viajes = new ArrayList<ViajeDTO>();
		this.fechaVencimiento = null;	
		this.estado = null;
		
		this.ventanaPromocion = ventanaPromocion;
		this.ventanaEditarPromocion = VentanaEditarPromocion.getInstance();
		this.ventanaTablaViajes = VentanaTablaViajes.getInstance();		
		this.modeloPromocion = new ModeloPromocion(new DAOSQLFactory());
		this.modeloViaje = new ModeloViaje(new DAOSQLFactory());
		this.modeloViaje_Promocion = new ModeloViaje_Promocion(new DAOSQLFactory());

		this.ventanaPromocion.getBtnRegistrar().addActionListener(rc->registrarPromocion(rc));
		this.ventanaPromocion.getBtnAsociarViaje().addActionListener(r->mostrarViajes(r));
		this.ventanaPromocion.getBtnCancelar().addActionListener(cv->cerrarVentanaPromocion(cv));
		
		this.ventanaEditarPromocion.getBtnEditar().addActionListener(e->editarPromocion(e));
		this.ventanaEditarPromocion.getBtnAsociarViaje().addActionListener(e->mostrarViajesEditarPromo(e));
		this.ventanaEditarPromocion.getBtnCancelar().addActionListener(e->cerrarVentanaEditarPromocion(e));

		this.ventanaTablaViajes.getBtnAtras().addActionListener(vc->volverVentanaAgregarPromocion(vc));
		this.ventanaTablaViajes.getBtnConfirmar().addActionListener(ce->asociarViajeEnPromocion(ce));
	}
	
	public void iniciar(){
		llenarComboPorcentaje();
	}
	
	public void llenarComboPorcentaje() {
		String [] porcentajes = {"10","15","20","25","30","35","40","45","50","55","60","65","70"};
		this.ventanaPromocion.getComboPorcentaje().setModel(new DefaultComboBoxModel<String>(porcentajes));
		this.ventanaEditarPromocion.getComboPorcentaje().setModel(new DefaultComboBoxModel<String>(porcentajes));
	}
	
	public void registrarPromocion(ActionEvent rc){
		if(camposLlenosRegistrarPromocion()){
			this.fechaVencimiento = convertUtilToSql(this.ventanaPromocion.getDateFechaVencimiento().getDate());
			this.porcentaje = Integer.parseInt(this.ventanaPromocion.getComboPorcentaje().getSelectedItem().toString());
			this.stock = Integer.parseInt(this.ventanaPromocion.getTxtStock().getText());
			this.estado = "activa";
			
			this.promocionRegistrada = new PromocionDTO(0,porcentaje,stock,fechaVencimiento,estado);
			modeloPromocion.agregarPromocion(promocionRegistrada);
			this.ventanaPromocion.limpiarCampos();
			this.ventanaPromocion.cerrarVentana();
			
			for(ViajeDTO v : viajes) {
				Viaje_PromocionDTO viaje_promocionDTO = new Viaje_PromocionDTO(0,v.getIdViaje(),modeloPromocion.obtenerPromocion().size());
				modeloViaje_Promocion.agregarViajePromocion(viaje_promocionDTO);
			}
		}
	}
	
	public void editarPromocion(ActionEvent e) {
		if(camposLlenosEditarPromocion()) {
			java.sql.Date fechaVencimiento = convertUtilToSql(this.ventanaEditarPromocion.getDateFechaVencimiento().getDate());
			Integer porcentaje = Integer.parseInt(this.ventanaEditarPromocion.getComboPorcentaje().getSelectedItem().toString());
			Integer stock = Integer.parseInt(this.ventanaEditarPromocion.getTxtStock().getText());
			
			PromocionDTO nuevaPromocion = new PromocionDTO(promocionSeleccionada.getIdPromocion(),
					porcentaje,
					stock,
					fechaVencimiento,
					promocionSeleccionada.getEstado());			
			
			modeloPromocion.editarPromocion(nuevaPromocion);
			
			this.ventanaEditarPromocion.limpiarCampos();
			this.ventanaEditarPromocion.cerrarVentana();
		}
		else {
			System.out.println("faltan datos");
		}
	}
	
	private void mostrarViajes(ActionEvent r) {
		ventanaPromocion.setVisible(false);
		ventanaTablaViajes.setVisible(true);
		llenarTablaViajes(modeloViaje.obtenerViajes());
	}
	
	
	private void mostrarViajesEditarPromo(ActionEvent r) {
		ventanaPromocion.setVisible(false);
		ventanaTablaViajes.setVisible(true);
		ventanaTablaViajes.getBtnAtras().setVisible(false);
		ventanaTablaViajes.getBtnConfirmar().setVisible(false);
		llenarTablaViajes(modeloViaje_Promocion.obtenerViajesEnPromo(promocionSeleccionada.getIdPromocion()));
	}
	
	private void llenarTablaViajes(List<ViajeDTO> tabla){
		this.ventanaTablaViajes.getModelViajes().setRowCount(0); //Para vaciar la tabla
		this.ventanaTablaViajes.getModelViajes().setColumnCount(0);
		this.ventanaTablaViajes.getModelViajes().setColumnIdentifiers(this.ventanaTablaViajes.getNombreColumnas());
			
		this.viajes_en_tabla = modeloViaje.obtenerViajes();
		
		for (int i = 0; i < tabla.size(); i++){

			Object[] fila = {
					tabla.get(i).getCiudadOrigen().getNombre(),
					tabla.get(i).getCiudadDestino().getNombre(),
					tabla.get(i).getFechaSalida(),
					tabla.get(i).getFechaLlegada(),
					tabla.get(i).getHoraSalida(),
					tabla.get(i).getHorasEstimadas(),
					tabla.get(i).getCapacidad(),
					tabla.get(i).getTransporte().getNombre(),
					tabla.get(i).getPrecio()
			};
			this.ventanaTablaViajes.getModelViajes().addRow(fila);
		}		
	}
	
	public void darBajaPromocion(int filaSeleccionada){
		for(PromocionDTO x : modeloPromocion.obtenerPromocion()) {
			if(x.getIdPromocion() == filaSeleccionada+1){
				if(x.getEstado().equals("inactiva")) {
					x.setEstado("activa");
					modeloPromocion.editarEstadoPromocion(x);
				}
				if(x.getEstado().equals("activa")) {
					x.setEstado("inactiva");
					modeloPromocion.editarEstadoPromocion(x);
				}
			}
		}
	}
	
	private boolean camposLlenosRegistrarPromocion(){
		if (ventanaPromocion.getDateFechaVencimiento().getDate() == null || ventanaPromocion.getTxtStock().getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Debe cargar todos los campos", "Mensaje", JOptionPane.ERROR_MESSAGE);
				return false;
		}
			return true;
	}
	
	private boolean camposLlenosEditarPromocion(){
		if (ventanaEditarPromocion.getDateFechaVencimiento().getDate() == null || ventanaEditarPromocion.getTxtStock().getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Debe cargar todos los campos", "Mensaje", JOptionPane.ERROR_MESSAGE);
				return false;
		}
			return true;
	}
	
	private void cerrarVentanaPromocion(ActionEvent cv) {
		this.ventanaPromocion.limpiarCampos();
		this.ventanaPromocion.cerrarVentana();
	}
	
	private void cerrarVentanaEditarPromocion(ActionEvent cv) {
		this.ventanaEditarPromocion.limpiarCampos();
		this.ventanaEditarPromocion.cerrarVentana();
	}
	
	private void volverVentanaAgregarPromocion(ActionEvent vc) {
		this.ventanaTablaViajes.mostrarVentana(false);
		this.ventanaPromocion.mostrarVentana();
	}
	
	/*private void cancelarEditarEvento(ActionEvent vc) {
		this.ventanaEditarEvento.mostrarVentana(false);
	}*/
	
	private void asociarViajeEnPromocion(ActionEvent ce) {
		int [] filasSeleccionadas = this.ventanaTablaViajes.getTablaViajes().getSelectedRows();
		if(filasSeleccionadas.length > 0) {
			for(int i=0; i<filasSeleccionadas.length; i++) {
				this.ventanaTablaViajes.mostrarVentana(false);
				viajes.add(viajes_en_tabla.get(filasSeleccionadas[i]));
				this.ventanaPromocion.mostrarVentana();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "No ha seleccionado una fila", "Mensaje", JOptionPane.ERROR_MESSAGE);
		}
//		int filaSeleccionada = this.ventanaTablaViajes.getTablaViajes().getSelectedRow();
//		if (filaSeleccionada != -1){
//			this.ventanaTablaViajes.mostrarVentana(false);
//			viaje = viajes_en_tabla.get(filaSeleccionada);
//			this.ventanaPromocion.mostrarVentana();
//			//this.ventanaPromocion.getTxtIdViaje().setText(viaje.getIdViaje()+"");
//		}
//		else{
//			JOptionPane.showMessageDialog(null, "No ha seleccionado una fila", "Mensaje", JOptionPane.ERROR_MESSAGE);
//		}
	}
		
	private java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

	public PanelPromocion getPanelPromocion() {
		return panelPromocion;
	}

	public void setPanelPromocion(PanelPromocion panelPromocion) {
		this.panelPromocion = panelPromocion;
	}
	
	public void setPromocionSeleccionada(PromocionDTO promo) {
		this.promocionSeleccionada = promo;
	}
	
}