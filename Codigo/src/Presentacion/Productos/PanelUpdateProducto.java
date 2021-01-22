package Presentacion.Productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Parseador.Parseador;
import Negocio.Producto.TProducto;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;
import java.awt.Font;


public class PanelUpdateProducto extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField descripcion;
	private JTextField stock;
	private JTextField precio;
	private TProducto producto;
	private JTextField campoFindId;
	private JLabel labelNombre;
	private JLabel labelDescripcion;
	private JLabel labelStock;
	private JLabel labelPrecio;
	private JButton buttonActualizar;
	private JButton botonBuscar;
	


	public PanelUpdateProducto(){

		initComponent();
	}

	public void initComponent() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setOpaque(false);
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(147, 144, 279, 57);
		add(nombre);
		nombre.setEnabled(false);

		labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(38, 165, 101, 14);
		add(labelNombre);

		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(147, 212, 279, 57);
		add(descripcion);
		descripcion.setEnabled(false);

		labelDescripcion = new JLabel("Descripcion");
		labelDescripcion.setBounds(38, 233, 81, 14);
		add(labelDescripcion);

		stock = new JTextField();
		stock.setColumns(10);
		stock.setBounds(147, 285, 279, 57);
		add(stock);
		stock.setEnabled(false);

		labelStock = new JLabel("Stock");
		labelStock.setBounds(38, 306, 75, 14);
		add(labelStock);;

		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(147, 358, 279, 57);
		add(precio);
		precio.setEnabled(false);

		labelPrecio = new JLabel("Precio");
		labelPrecio.setBounds(38, 379, 75, 14);
		add(labelPrecio);

		buttonActualizar = new JButton("Actualizar");
		buttonActualizar.setBackground(SystemColor.textHighlight);
		buttonActualizar.setBounds(294, 438, 132, 43);
		add(buttonActualizar);
		buttonActualizar.setEnabled(false);

		campoFindId = new JTextField();
		campoFindId.setBounds(45, 97, 208, 23);
		campoFindId.setColumns(10);
		add(campoFindId);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setBackground(SystemColor.textHighlight);
		botonBuscar.setBounds(268, 96, 158, 23);
		add(botonBuscar);
		
		JLabel lblActualizarProducto = new JLabel("ACTUALIZAR PRODUCTO");
		lblActualizarProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarProducto.setBounds(45, 30, 222, 20);
		add(lblActualizarProducto);
		
		JLabel lblIntroduceElId = new JLabel("Introduce el id del producto");
		lblIntroduceElId.setBounds(45, 66, 208, 20);
		add(lblIntroduceElId);


		botonBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				nombre.setEnabled(true);
				descripcion.setEnabled(true);
				precio.setEnabled(true);
				stock.setEnabled(true);
				buttonActualizar.setEnabled(true);
				
				if(Parseador.esNumerico(campoFindId.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readProducto, Integer.valueOf(campoFindId.getText())));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
				}
			}
		});

		buttonActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(Parseador.esAlfabetico(nombre.getText()) && Parseador.esNumericoFloat(precio.getText()) && Parseador.esNumerico(stock.getText())){


						producto.setNombre(nombre.getText());
						producto.setDescripcion(descripcion.getText());
						producto.setStock(Integer.valueOf(stock.getText()));
						producto.setPrecio(Float.valueOf(precio.getText()));
						Controller.getInstance().ejecutar(new Contexto(Eventos.updateProducto, producto));
					}else{
						JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos");
					}
				} catch (Exception ex) {;}
			}
		});
	}

	public void resetCamps(){
		nombre.setText(null);
		descripcion.setText(null);
		stock.setText(null);
		precio.setText(null);
		campoFindId.setText(null);


	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		try{
			if(contexto.getDatos()!=null){
				producto = (TProducto) contexto.getDatos();
				nombre.setText(producto.getNombre());
				descripcion.setText(producto.getDescripcion());
				stock.setText(Integer.toString( producto.getStock()));
				precio.setText(Float.toString(producto.getPrecio()));
				buttonActualizar.setVisible(true);
			}
			repaint();
		}catch( Exception ex){
			nombre.setText("");
			descripcion.setText("");
			stock.setText("");
			precio.setText("");
		}
	}
}