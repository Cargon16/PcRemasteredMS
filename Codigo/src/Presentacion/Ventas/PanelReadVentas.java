/**
 * 
 */
package Presentacion.Ventas;

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
import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;
import javax.swing.SwingConstants;


public class PanelReadVentas extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea ;
	private JScrollPane scroll;
	private JLabel lblLeerVenta;
	
	
	public PanelReadVentas(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Venta");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(434, 90, 171, 42);
		add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 90, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setVisible(true);
	    scroll.setBounds(83, 158, 522, 158);
	    add(scroll);
	    textArea.setVisible(false);
	    textArea.setEditable(false);
	    
	    
	    JLabel lblIntroduceElId = new JLabel("Introduce el ID");
	    lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblIntroduceElId.setBounds(83, 67, 110, 16);
	    add(lblIntroduceElId);
	    
	    lblLeerVenta = new JLabel("Leer Venta");
	    lblLeerVenta.setHorizontalAlignment(SwingConstants.CENTER);
	    lblLeerVenta.setFont(new Font("Tahoma", Font.BOLD, 17));
	    lblLeerVenta.setBounds(83, 13, 91, 38);
	    add(lblLeerVenta);
	    
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	if(Parseador.esNumerico(textField.getText())){
	    		Controller.getInstance().ejecutar(new Contexto(Eventos.readVenta, Integer.valueOf(textField.getText())));
	    	}else{
    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
    		}
	    		
	    	}
	    });
	
	}
	

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		
		textArea.setVisible(true);
		TVentaDetalles c = (TVentaDetalles) contexto.getDatos();
		textArea.setText("ID: " + c.getVenta().getIDVenta() + "\n"+ "Cliente: " + c.getCliente().getNombre() + "\n" + "Importe: " + c.getVenta().getPrecioTotal()
		+ "\n"+ "Fecha: " + c.getVenta().getFecha() +"\n"+"Pagado: "+ c.getVenta().getPagado()+ "\n\n");
		
	}
	
	public void resetCamps(){
		textField.setText(null);
		textArea.setText(null);
		
	}
}