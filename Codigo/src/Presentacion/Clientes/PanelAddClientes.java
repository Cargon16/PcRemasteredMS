package Presentacion.Clientes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Negocio.Cliente.TCliente;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;


public class PanelAddClientes extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	private JTextField dniText;
	private JTextField nombreText;
	private JTextField telefonoText;
	private JTextField direccionText;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	
	public PanelAddClientes(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		dniText = new JTextField();
		dniText.setColumns(10);
		dniText.setBounds(202, 80, 279, 57);
		add(dniText);

		JLabel label = new JLabel("DNI");
		label.setBounds(130, 101, 46, 14);
		add(label);

		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(202, 148, 279, 57);
		add(nombreText);

		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(117, 169, 75, 14);
		add(label_1);

		telefonoText = new JTextField();
		telefonoText.setColumns(10);
		telefonoText.setBounds(202, 216, 279, 57);
		add(telefonoText);

		JLabel label_2 = new JLabel("Telefono");
		label_2.setBounds(117, 237, 75, 14);
		add(label_2);


		direccionText = new JTextField();
		direccionText.setColumns(10);
		direccionText.setBounds(202, 284, 279, 57);
		add(direccionText);

		JLabel labelDIreccion = new JLabel("Direccion");
		labelDIreccion.setBounds(117, 305, 75, 14);
		add(labelDIreccion);

		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(239, 348, 109, 23);
		activoRB.setOpaque(false);
		inactivoRB = new JRadioButton("Inactivo");
		activoRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(false);
				activoRB.setSelected(true);
			}
		});
		add(activoRB);

		inactivoRB.setBounds(362, 348, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});
		JButton button = new JButton("Anadir");
		button.setBackground(SystemColor.textHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false ;
				if(activoRB.isSelected()) 
					ok = true;
				
				if(Parseador.ComprobarDNI(dniText.getText()) && Parseador.esAlfabetico(nombreText.getText()) &&  Parseador.esNumerico(telefonoText.getText()) && Parseador.ComprobarTelefono(Integer.valueOf(telefonoText.getText()))){
					TCliente cliente = new TCliente(nombreText.getText(), direccionText.getText(),Integer.valueOf(telefonoText.getText()),dniText.getText(), ok);
					Controller.getInstance().ejecutar(new Contexto(Eventos.createCliente, cliente));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}
				
			}
		});
		button.setBounds(285, 380, 132, 40);
		add(button);

		JLabel lblAadirCliente = new JLabel("A\u00D1ADIR CLIENTE");
		lblAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirCliente.setBounds(255, 11, 162, 32);
		add(lblAadirCliente);



	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		direccionText.setText(null);
		dniText.setText(null);
		nombreText.setText(null);
		telefonoText.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
	}
}	

