/**
 * 
 */
package Presentacion.Ventas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Parseador.Parseador;
import Negocio.Venta.TVenta;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.IGUI.*;
import Presentacion.Controlador.*;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelAbrirVentas  extends JPanel implements Ventana{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField iDClienteText;
	private JTextField idModeloText;
	private JTextField cantidadText;
	private TVenta venta;
	
	JButton btnConfirmar;
	JButton botonAbrir;
	JButton botonEliminar;
	JButton botonAñadir;
	private JLabel lblAbrirVenta;
	final JLabel lblCantidad;
	final JLabel lblIdDeModelo;
	
	public PanelAbrirVentas (){
		setLayout(null);
		setOpaque(false);
		iDClienteText = new JTextField();
		iDClienteText.setColumns(10);
		iDClienteText.setBounds(49, 101, 279, 57);
		add(iDClienteText);

		JLabel lblIdDeCliente = new JLabel("ID de Cliente para asociar la venta");
		lblIdDeCliente.setBounds(49, 80, 242, 14);
		add(lblIdDeCliente);

		btnConfirmar = new JButton("Cerrar Venta");

		btnConfirmar.setBounds(462, 309, 132, 49);
		add(btnConfirmar);

		botonAbrir = new JButton("Abrir Venta");

		botonAbrir.setBounds(462, 101, 132, 49);
		add(botonAbrir);

		botonAñadir = new JButton("Añadir producto");
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(idModeloText.getText().isEmpty() || cantidadText.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba que los campos no estan vacios.");
				}else{

					ArrayList<Object> lista = new ArrayList<Object>();
					lista.add(Integer.valueOf(idModeloText.getText()));
					lista.add(venta);
					lista.add(Integer.valueOf(cantidadText.getText()));
					
					Controller.getInstance().ejecutar(new Contexto(Eventos.addProductoVenta, lista));

				}



			}}
				);
		botonAñadir.setBounds(462, 177, 132, 49);
		add(botonAñadir);

		botonEliminar = new JButton("Eliminar producto");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Object> lista = new ArrayList<Object>();
				lista.add(venta);
				lista.add(Integer.valueOf(idModeloText.getText()));

				Controller.getInstance().ejecutar(new Contexto(Eventos.deleteProductoVenta, lista));
			}
		});
		botonEliminar.setBounds(462, 242, 132, 49);
		add(botonEliminar);

		idModeloText = new JTextField();
		idModeloText.setBounds(49, 203, 279, 57);
		add(idModeloText);
		idModeloText.setColumns(10);

		cantidadText = new JTextField();
		cantidadText.setBounds(49, 305, 279, 57);
		add(cantidadText);
		cantidadText.setColumns(10);

		lblIdDeModelo = new JLabel("ID de producto");
		lblIdDeModelo.setBounds(49, 187, 147, 14);
		add(lblIdDeModelo);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(49, 287, 75, 14);
		add(lblCantidad);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Controller.getInstance().ejecutar(new Contexto(Eventos.procesarVenta, venta));
				
				iDClienteText.setEnabled(true);
				botonAbrir.setEnabled(true);
				botonAñadir.setEnabled(false);
				botonEliminar.setEnabled(false);
				btnConfirmar.setEnabled(false);
				idModeloText.setVisible(false);
				cantidadText.setVisible(false);
				lblCantidad.setVisible(false);
				lblIdDeModelo.setVisible(false);
				iDClienteText.setText("");
				idModeloText.setText("");
				cantidadText.setText("");


			}
		});
		botonAñadir.setEnabled(false);
		botonEliminar.setEnabled(false);
		btnConfirmar.setEnabled(false);
		
		lblAbrirVenta = new JLabel("Abrir Venta");
		lblAbrirVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbrirVenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAbrirVenta.setBounds(49, 16, 104, 38);
		add(lblAbrirVenta);
		idModeloText.setVisible(false);
		cantidadText.setVisible(false);
		lblCantidad.setVisible(false);
		lblIdDeModelo.setVisible(false);

		botonAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iDClienteText.getText().isEmpty() || !Parseador.esNumerico(iDClienteText.getText())){
					JOptionPane.showMessageDialog(null, "Datos incorrectos, ID usuario vacio o no existe.");
				}else{
					
					Controller.getInstance().ejecutar(new Contexto(Eventos.abrirVenta, Integer.valueOf(iDClienteText.getText())));

				
				}


			}
		});
		


	}

	@Override
	public void resetCamps() {
		// TODO Auto-generated method stub
		this.cantidadText.setText(null);
		this.iDClienteText.setText(null);
		this.idModeloText.setText(null);
		botonAñadir.setEnabled(false);
		botonEliminar.setEnabled(false);
		btnConfirmar.setEnabled(false);
		botonAñadir.setEnabled(false);
		botonEliminar.setEnabled(false);
		btnConfirmar.setEnabled(false);
		idModeloText.setVisible(false);
		cantidadText.setVisible(false);

	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		venta = (TVenta) contexto.getDatos();
	
	}
	
	public void actualizarPantalla(){
		
		iDClienteText.setEnabled(true);
		idModeloText.setVisible(true);
		cantidadText.setVisible(true);
		botonAbrir.setEnabled(true);
		botonAñadir.setEnabled(true);
		botonEliminar.setEnabled(true);
		btnConfirmar.setEnabled(true);
		lblCantidad.setVisible(true);
		lblIdDeModelo.setVisible(true);
		
	}
}