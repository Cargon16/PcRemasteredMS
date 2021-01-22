/**
 * 
 */
package Presentacion.Clientes;

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

import Negocio.Cliente.TCliente;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;

public class PanelReadByIdClientes extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea ;
	private JScrollPane scroll;
	private JLabel lblLeerCliente;
	

	public PanelReadByIdClientes(){
		initComponent();
	}
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Cliente");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(434, 68, 171, 42);
		add(button);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 68, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 161, 522, 108);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("Introduce el ID");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroduceElId.setBounds(83, 45, 110, 16);
		add(lblIntroduceElId);
		
		lblLeerCliente = new JLabel("MOSTRAR CLIENTE");
		lblLeerCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLeerCliente.setBounds(265, 11, 162, 32);
		add(lblLeerCliente);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(textField.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readCliente, textField.getText()));
					
				}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
				

			}
		});

	}
	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		String s = null;
		TCliente c = (TCliente) contexto.getDatos();
		if(c.getActivo())
			s= "Activo";
		else s= "No activo";
		textArea.setText("DNI: "+ c.getDNI() + "\n" + "Nombre: " +c.getNombre() +"\n" + "Numero de telefono: "+c.getTelefono() + "\n" + "Direccion: " + c.getDireccion()+ "\n" +"Estado: "+s+  "\n" );

	}
	
	public void resetCamps(){
		textField.setText(null);
		textArea.setText(null);
		
		
		
	}
}