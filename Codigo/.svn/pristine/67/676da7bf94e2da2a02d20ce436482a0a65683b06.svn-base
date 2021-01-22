package Presentacion.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class PanelReadAllVentas extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	
	private JButton buttonRead;
	private JTextArea text;
	private JLabel lblLeerVentas;
	
	public PanelReadAllVentas(){
		initComponent();
	}
	
	public  void initComponent() {
		
		setLayout(null);
		setOpaque(false);
		buttonRead = new JButton("Ver las Ventas");
		buttonRead.setBackground(SystemColor.textHighlight);
		buttonRead.setBounds(43, 70, 190, 43);
		add(buttonRead);
		
		text=new JTextArea();
		
		JScrollPane scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(43, 129, 595, 297);
		add(scroll);
		
		text.setVisible(false);
		text.setEditable(false);
		
		lblLeerVentas = new JLabel("Mostrar todas las Ventas");
		lblLeerVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeerVentas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblLeerVentas.setBounds(43, 16, 211, 38);
		add(lblLeerVentas);
		buttonRead.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllVenta, 1));
				
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
		ArrayList<TVentaDetalles> lista = (ArrayList<TVentaDetalles>) contexto.getDatos();
		String texto = "";
		for(TVentaDetalles c : lista){
			texto = texto + "ID venta: " + c.getVenta().getIDVenta() + "\n" + "Cliente: "+ c.getCliente().getNombre() + "\n" + "Importe: " + c.getVenta().getPrecioTotal()
			+ "\n"+ "Fecha: " + c.getVenta().getFecha() + "\n"+"Pagado: "+c.getVenta().getPagado() +"\n\n";
		}
		text.setText(texto);
	}
}