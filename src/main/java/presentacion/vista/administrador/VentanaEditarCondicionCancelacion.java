package presentacion.vista.administrador;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class VentanaEditarCondicionCancelacion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDiaInicio;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private static VentanaEditarCondicionCancelacion INSTANCE;
	private JLabel lblArs;
	private JTextField txtDiaFin;
	private JTextField txtPorcentaje;
	private JComboBox comboBoxEstados;
	private JLabel lblEstadoDelPasaje;

	public static VentanaEditarCondicionCancelacion getInstance(){
		if(INSTANCE == null)
			return new VentanaEditarCondicionCancelacion();
		else
			return INSTANCE;
	}
	
	public VentanaEditarCondicionCancelacion() {
		setTitle("Modificar Regimen de Puntos");
		setResizable(false);;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 325);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(96, 163, 188));
		panel.setBounds(0, 0, 448, 53);
		contentPane.add(panel);
		
		JLabel lblAgregarPunto = new JLabel("Retencion de la empreza");
		lblAgregarPunto.setForeground(Color.WHITE);
		lblAgregarPunto.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAgregarPunto.setBounds(27, 0, 411, 53);
		panel.add(lblAgregarPunto);
		
		JLabel lblCANTPUNTOS = new JLabel("Desde :");
		lblCANTPUNTOS.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCANTPUNTOS.setBounds(20, 98, 85, 14);
		contentPane.add(lblCANTPUNTOS);
		
		txtDiaInicio = new JTextField();
		txtDiaInicio.setBounds(97, 95, 85, 20);
		contentPane.add(txtDiaInicio);
		txtDiaInicio.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBackground(new Color(192, 57, 43));
		btnCancelar.setBounds(237, 243, 131, 42);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setBackground(new Color(5, 196, 107));
		btnAceptar.setBounds(45, 243, 131, 42);
		contentPane.add(btnAceptar);
		
		lblArs = new JLabel("Hasta :");
		lblArs.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblArs.setBounds(227, 98, 46, 14);
		contentPane.add(lblArs);
		
		txtDiaFin = new JTextField();
		txtDiaFin.setBounds(282, 95, 86, 20);
		contentPane.add(txtDiaFin);
		txtDiaFin.setColumns(10);
		
		txtPorcentaje = new JTextField();
		txtPorcentaje.setColumns(10);
		txtPorcentaje.setBounds(282, 186, 86, 20);
		contentPane.add(txtPorcentaje);
		
		comboBoxEstados = new JComboBox();
		comboBoxEstados.addItem("reservado");
		comboBoxEstados.addItem("vendido");
		comboBoxEstados.setBounds(283, 136, 85, 20);
		contentPane.add(comboBoxEstados);
		
		lblEstadoDelPasaje = new JLabel("Estado del pasaje:");
		lblEstadoDelPasaje.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEstadoDelPasaje.setBounds(158, 139, 115, 14);
		contentPane.add(lblEstadoDelPasaje);
		
		JLabel label = new JLabel("[Desde - Hasta] Rango entre dias de la cancelacion del pasaje");
		label.setBounds(31, 64, 427, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Porcentaje de retención:     %\r\n");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_1.setBounds(107, 189, 166, 14);
		contentPane.add(label_1);
	}
	
	
	public JTextField getTxtDiaInicio() {
		return txtDiaInicio;
	}

	public JLabel getLblArs() {
		return lblArs;
	}

	public void setLblArs(JLabel lblArs) {
		this.lblArs = lblArs;
	}

	public JTextField getTxtDiaFin() {
		return txtDiaFin;
	}

	public void setTxtDiaFin(JTextField textFin) {
		this.txtDiaFin = textFin;
	}

	public JTextField getTxtPorcentaje() {
		return txtPorcentaje;
	}

	public void setTxtPorcentaje(JTextField porcentaje) {
		this.txtPorcentaje = porcentaje;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public void mostrarVentana(){
		this.setVisible(true);
	}

	public void cerrarVentana(){
		this.setVisible(false);
	}
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnModificar) {
		this.btnAceptar = btnModificar;
	}
	
	public void setTxtDiaInicio(JTextField txtcantPuntos) {
		this.txtDiaInicio = txtcantPuntos;
	}

	public JComboBox getComboBoxEstados() {
		return comboBoxEstados;
	}

	public void setComboBoxEstados(JComboBox comboBoxEstados) {
		this.comboBoxEstados = comboBoxEstados;
	}

	public void limpiarCampos(){
		this.txtDiaInicio.setText(null);
		this.txtDiaFin.setText(null);
		this.txtPorcentaje.setText(null);
	}
}
