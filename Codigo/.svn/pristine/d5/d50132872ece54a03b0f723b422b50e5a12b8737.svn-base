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
import Negocio.Producto.TMonitor;
import Negocio.Producto.TProducto;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;


public class PanelAddMonitor extends JPanel implements Ventana {
	
	private static final long serialVersionUID = 1L;
	private JTextField nombreText;
	private JTextField descripcionText;
	private JTextField stockText;
	private JTextField precioText;
	private JTextField dimensionText;
	private JTextField marcaText;
	private JTextField pesoText;
	
	public PanelAddMonitor(){
	
		initComponent();
	}
	
	
	public void initComponent(){
		
		setLayout(null);
		setOpaque(false);

		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(127, 70, 229, 30);
		add(nombreText);

		JLabel labelNombre = new JLabel("Nombre ");
		labelNombre.setBounds(37, 78, 75, 14);
		add(labelNombre);
		
		descripcionText = new JTextField();
		descripcionText.setColumns(10);
		descripcionText.setBounds(127, 176, 229, 30);
		add(descripcionText);

		JLabel labelDescrip = new JLabel("Descripcion ");
		labelDescrip.setBounds(37, 176, 86, 30);
		add(labelDescrip);
		
		dimensionText = new JTextField();
		add(dimensionText);
		
		pesoText = new JTextField();
		add(pesoText);
		
		marcaText = new JTextField();
		add(marcaText);
		
		stockText = new JTextField();
		stockText.setColumns(10);
		stockText.setBounds(127, 230, 229, 30);
		add(stockText);

		JLabel labelStock = new JLabel("Stock");
		labelStock.setBounds(37, 230, 75, 14);
		add(labelStock);
		
		precioText = new JTextField();
		precioText.setColumns(10);
		precioText.setBounds(127, 121, 229, 30);
		add(precioText);

		JLabel labelPrecio = new JLabel("Precio");
		labelPrecio.setBounds(37, 129, 75, 14);
		add(labelPrecio);
		
		JButton buttonAnadir = new JButton("Añadir");
		buttonAnadir.setBackground(SystemColor.textHighlight);
		
		buttonAnadir.setBounds(224, 434, 132, 40);
		add(buttonAnadir);
		
		
		JLabel lblAadirProducto = new JLabel("A\u00D1ADIR MONITOR");
		lblAadirProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirProducto.setBounds(37, 13, 273, 32);
		add(lblAadirProducto);
		
		dimensionText = new JTextField();
		dimensionText.setColumns(10);
		dimensionText.setBounds(127, 285, 229, 30);
		add(dimensionText);
		
		marcaText = new JTextField();
		marcaText.setColumns(10);
		marcaText.setBounds(127, 331, 229, 30);
		add(marcaText);
		
		JLabel lblDimension = new JLabel("Dimension");
		lblDimension.setBounds(37, 293, 75, 14);
		add(lblDimension);
		
		JLabel lblModelo = new JLabel("Marca");
		lblModelo.setBounds(37, 339, 75, 14);
		add(lblModelo);
		
		pesoText = new JTextField();
		pesoText.setColumns(10);
		pesoText.setBounds(127, 382, 229, 30);
		add(pesoText);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(37, 390, 75, 14);
		add(lblPeso);
		
		buttonAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Parseador.esAlfabetico(marcaText.getText()) && Parseador.esNumerico(dimensionText.getText()) && Parseador.esNumerico(pesoText.getText()) && Parseador.esAlfabetico(nombreText.getText()) && Parseador.esNumerico(stockText.getText()) && Parseador.esNumericoFloat(precioText.getText())){
					
					TProducto producto = new TMonitor((Integer) null, Float.valueOf(precioText.getText()),Integer.valueOf(stockText.getText()), nombreText.getText(), descripcionText.getText(),Integer.valueOf(dimensionText.getText()),marcaText.getText(),Integer.valueOf(pesoText.getText()));
					Controller.getInstance().ejecutar(new Contexto(Eventos.createProducto, producto));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}
	
			}
		});
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