package Presentacion.Clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Negocio.Cliente.TCliente;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


public class PanelReadAllClientes extends JPanel implements Ventana {
	
	private static final long serialVersionUID = 1L;
	private JButton btnMostrarLosClientes;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JLabel lblMostrarTodosLos;


	public PanelReadAllClientes(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnMostrarLosClientes = new JButton("Mostrar los clientes");
		btnMostrarLosClientes.setBackground(SystemColor.textHighlight);
		btnMostrarLosClientes.setBounds(205, 54, 262, 57);
		add(btnMostrarLosClientes);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(82, 132, 521, 253);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		
		lblMostrarTodosLos = new JLabel("MOSTRAR TODOS LOS CLIENTES");
		lblMostrarTodosLos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodosLos.setBounds(174, 11, 335, 32);
		add(lblMostrarTodosLos);
		btnMostrarLosClientes.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllCliente, null));
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		ArrayList<TCliente> array = (ArrayList<TCliente>) contexto.getDatos();
		String texto = "";
		for (TCliente c : array) {
			String s = null;
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";
			texto = texto + "ID: " + c.getIDCliente() + "\n" + "DNI: " + c.getDNI() + "\n"
					+ "Nombre: " + c.getNombre() + "\n" + "Numero de Telefono: " + c.getTelefono() + "\n" +
					"Direccion: " + c.getDireccion() + "\n" + "Estado: " + s + "\n\n";

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}