package Presentacion.Productos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Negocio.Parseador.Parseador;
import Negocio.Producto.TMonitor;
import Negocio.Producto.TOrdenador;
import Negocio.Producto.TProducto;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;


public class PanelReadByIdProducto extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea ;
	private JScrollPane scroll;
	private JLabel lblMostrarProducto;
	
	
	
	public PanelReadByIdProducto(){

		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Producto");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(434, 108, 171, 42);
		add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 108, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setVisible(true);
	    scroll.setBounds(83, 173, 522, 281);
	    add(scroll);
	    textArea.setVisible(false);
	    textArea.setEditable(false);
	    
	    
	    JLabel lblIntroduceElId = new JLabel("Introduce el ID");
	    lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblIntroduceElId.setBounds(83, 76, 110, 16);
	    add(lblIntroduceElId);
	    
	    lblMostrarProducto = new JLabel("MOSTRAR PRODUCTO ");
	    lblMostrarProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblMostrarProducto.setBounds(83, 28, 186, 20);
	    add(lblMostrarProducto);
	    
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	
	    		if(Parseador.esNumerico(textField.getText())){
		    		Controller.getInstance().ejecutar(new Contexto(Eventos.readProducto,Integer.valueOf(textField.getText())));
	    		}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
	    		
	    	
	    	}
	    });
	
	}
	
	public void resetCamps(){
		textField.setText(null);
		textArea.setText(null);
		
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		textArea.setVisible(true);
		TProducto c = (TProducto) contexto.getDatos();
		String texto = "";
		//textArea.setText("Nombre: " + p.getNombre() + "\n" + "Descripcion: "+p.getDescripcion()+ "\n" + "Stock: "+p.getStock() + "\n" + "Precio: "+p.getPrecio()+"\n" );
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
		textArea.setText(texto);
	}
}