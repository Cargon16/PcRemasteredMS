package Presentacion.Productos;

import java.awt.Font;
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


public class PanelAddProducto extends JPanel implements Ventana {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JTextField nombreText;
	private JTextField descripcionText;
	private JTextField stockText;
	private JTextField precioText;
	
	public PanelAddProducto(){
	
		initComponent();
	}
	
	
	public void initComponent(){
		
		setLayout(null);
		setOpaque(false);

		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(123, 114, 229, 30);
		add(nombreText);

		JLabel labelNombre = new JLabel("Nombre ");
		labelNombre.setBounds(37, 122, 75, 14);
		add(labelNombre);
		
		descripcionText = new JTextField();
		descripcionText.setColumns(10);
		descripcionText.setBounds(123, 229, 229, 30);
		add(descripcionText);

		JLabel labelDescrip = new JLabel("Descripcion ");
		labelDescrip.setBounds(37, 216, 279, 57);
		add(labelDescrip);
		
		stockText = new JTextField();
		stockText.setColumns(10);
		stockText.setBounds(123, 289, 229, 30);
		add(stockText);

		JLabel labelStock = new JLabel("Stock");
		labelStock.setBounds(37, 297, 75, 14);
		add(labelStock);
		
		precioText = new JTextField();
		precioText.setColumns(10);
		precioText.setBounds(123, 166, 229, 30);
		add(precioText);

		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setBounds(37, 174, 75, 14);
		add(labelPrecio);
		
		JButton buttonAnadir = new JButton("Añadir");
		buttonAnadir.setBackground(SystemColor.textHighlight);
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Parseador.esAlfabetico(nombreText.getText()) && Parseador.esNumerico(stockText.getText()) && Parseador.esNumericoFloat(precioText.getText())){
					TProducto producto = new TProducto(null, Float.valueOf(precioText.getText()),Integer.valueOf(stockText.getText()), nombreText.getText(), descripcionText.getText());
					Controller.getInstance().ejecutar(new Contexto(Eventos.createProducto, producto));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}
	
			}
		});
		buttonAnadir.setBounds(220, 374, 132, 40);
		add(buttonAnadir);
		
		
		JLabel lblAadirProducto = new JLabel("A\u00D1ADIR PRODUCTO");
		lblAadirProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirProducto.setBounds(37, 13, 273, 32);
		add(lblAadirProducto);
		
	}

	public void resetCamps(){
		nombreText.setText(null);
		descripcionText.setText(null);
		stockText.setText(null);
		precioText.setText(null);
		
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		this.revalidate();
		this.repaint();
		
	}
	
	

}