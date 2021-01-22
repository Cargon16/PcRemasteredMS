package Presentacion.Productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Negocio.Producto.TMonitor;
import Negocio.Producto.TOrdenador;
import Negocio.Producto.TProducto;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;


public class PanelReadAllProducto extends JPanel implements Ventana {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton buttonRead;
	private JTextArea text;
	private JLabel lblMostrarTodosLos;

	public PanelReadAllProducto(){
		initComponent();
	}

	public  void initComponent() {
		// TODO Auto-generated constructor stub

		setLayout(null);
		setOpaque(false);
		buttonRead = new JButton("Ver los Productos");
		buttonRead.setBackground(SystemColor.textHighlight);
		buttonRead.setBounds(204, 99, 262, 57);
		add(buttonRead);

		text=new JTextArea();

		JScrollPane scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 166, 522, 281);
		add(scroll);

		text.setVisible(false);
		text.setEditable(false);
		
		lblMostrarTodosLos = new JLabel("MOSTRAR TODOS LOS PRODUCTOS");
		lblMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodosLos.setBounds(83, 30, 303, 20);
		add(lblMostrarTodosLos);
		buttonRead.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllProducto, 1));
			}
		});
	}

	public void resetCamps(){
		text.setText(null);
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		text.setVisible(true);
		@SuppressWarnings("unchecked")
		ArrayList<TProducto> lista = (ArrayList<TProducto>) contexto.getDatos();
		String texto = "";

		for(TProducto c : lista){
			TMonitor monitor;
			TOrdenador ordenador;
			if (c instanceof TMonitor/*c.getDescripcion().contains("monitor")*/){
				monitor = (TMonitor) c;
				texto = texto + "ID: "
						+c.getID() +
						"\n" + "Nombre: " +c.getNombre() +
						"\n"+ "Descripcion: " + c.getDescripcion() +
						"\n"+ "Stock: " + c.getStock()  +
						"\n" + "Precio: " + c.getPrecio() +
						"\n" + "Dimension: " +monitor.getDimension()+
						"\n" + "Marca: "+monitor.getMarca()+
						"\n" + "Peso: "+monitor.getPeso()+
						"\n\n";
			}else if ( c instanceof TOrdenador/*c.getDescripcion().contains("ordenador")*/) {
				ordenador = (TOrdenador) c;
				texto = texto + "ID: " + c.getID() + 
						"\n" + "Nombre: " + c.getNombre() +
						"\n"+ "Descripcion: " + c.getDescripcion()+
						"\n"+ "Stock: " + c.getStock()  + 
						"\n" + "Precio: " + c.getPrecio() + 
						"\n" + "Procesador: " +ordenador.getProcesador()+
						"\n" + "RAM: " +ordenador.getRAM()+
						"\n" + "Grafica: " +ordenador.getGrafica()+
						"\n" + "Capacidad: " +ordenador.getCapacidad()+
						"\n" + "Fuente: " +ordenador.getFuente()+
						"\n" + "PlacaBase: " +ordenador.getPlacaBase()+
						"\n\n";
			}else{
				texto = texto + "ID: " + c.getID() + 
						"\n" + "Nombre: " + c.getNombre() +
						"\n"+ "Descripcion: " + c.getDescripcion()+ 
						"\n"+ "Stock: " + c.getStock()  + 
						"\n" + "Precio: " + c.getPrecio() + 
						"\n\n";
			}
		}
		text.setText(texto);

	}

}