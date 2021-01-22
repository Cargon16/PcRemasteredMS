package Presentacion.Clientes;

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
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelUpdateClientes extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;
	private JTextField dni;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField direccion;
	private JTextField botonfindtext;
	private JLabel label ;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblDireccion;
	private TCliente c;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	private JButton botonFind;
	private JButton button;
	private JLabel lblActualizarCliente;
	private JLabel lblIdDelCliente;

	/**
	 * Create the panel.
	 */
	public PanelUpdateClientes() {
		setLayout(null);
		setOpaque(false);
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(49, 117, 279, 57);
		add(dni);

		label = new JLabel("DNI");
		label.setBounds(350, 138, 46, 14);
		add(label);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(49, 185, 279, 57);
		add(nombre);

		label_1 = new JLabel("Nombre");
		label_1.setBounds(350, 206, 97, 14);
		add(label_1);

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(49, 254, 279, 57);
		add(telefono);

		label_2= new JLabel("Telefono");
		label_2.setBounds(350, 275, 75, 14);
		add(label_2);

		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(49, 322, 279, 57);
		add(direccion);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(350, 343, 75, 14);
		add(lblDireccion);


		button = new JButton("Actualizar");
		button.setBackground(SystemColor.textHighlight);

		button.setBounds(461, 379, 132, 43);
		// add(button);
		add(button);
		button.setVisible(false);
		botonfindtext = new JTextField();
		botonfindtext.setBounds(49, 86, 279, 20);
		add(botonfindtext);
		botonfindtext.setColumns(10);

		botonFind = new JButton("Buscar");
		botonFind.setBackground(SystemColor.textHighlight);

		botonFind.setBounds(371, 85, 222, 23);
		add(botonFind);

		activoRB = new JRadioButton("Activo");
		inactivoRB = new JRadioButton("Inactivo");
		activoRB.setVisible(false);
		inactivoRB.setVisible(false);
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(94, 389, 109, 23);
		activoRB.setOpaque(false);
		botonFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(Parseador.esNumerico(botonfindtext.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readCliente, botonfindtext.getText()));
				}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
				
			}
		});

		activoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(false);
				activoRB.setSelected(true);
			}
		});
		add(activoRB);

		inactivoRB.setBounds(205, 389, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		
		lblActualizarCliente = new JLabel("ACTUALIZAR CLIENTE");
		lblActualizarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarCliente.setBounds(176, 11, 315, 32);
		add(lblActualizarCliente);
		
		lblIdDelCliente = new JLabel("Introduce el ID del cliente ");
		lblIdDelCliente.setBounds(49, 57, 202, 20);
		add(lblIdDelCliente);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Parseador.esAlfabetico(nombre.getText()) && Parseador.esNumerico(telefono.getText()) && Parseador.ComprobarDNI(dni.getText()) && Parseador.ComprobarTelefono(Integer.valueOf(telefono.getText()))){

					boolean ok = false;
					if (activoRB.isSelected())
						ok = true;
					c.setDNI(dni.getText());
					c.setNombre(nombre.getText());
					c.setTelefono(Integer.valueOf(telefono.getText()));
					c.setDireccion(direccion.getText());
					c.setActivo(ok);
					try {
						Controller.getInstance().ejecutar(new Contexto(Eventos.updateCliente, (TCliente) c));
						
					} catch (Exception ex) {;}
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos");
				}

			}
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		try{
			c = (TCliente) contexto.getDatos();
			dni.setText(c.getDNI());
			nombre.setText(c.getNombre());
			telefono.setText(c.getTelefono().toString());
			direccion.setText(c.getDireccion().toString());
			inactivoRB.setSelected(false);
			activoRB.setSelected(false);
			if (c.getActivo())
				activoRB.setSelected(true);
			else
				inactivoRB.setSelected(true);
			activoRB.setVisible(true);
			inactivoRB.setVisible(true);

			button.setVisible(true);

			repaint();
		}

		catch (Exception ex) {
			dni.setText("");
			nombre.setText("");
			telefono.setText("");

		}

	}
	
	public void resetCamps(){
		
		dni.setText(null);
		nombre.setText(null);
		telefono.setText(null);
		direccion.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
		botonfindtext.setText(null);
		
		
	}

}
