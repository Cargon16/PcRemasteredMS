package Presentacion.Competencia;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integracion.Empleado.TEmpleado;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class PanelMostrarTodosEmpleadosPoseenCompetencia extends JPanel implements Ventana {
private static final long serialVersionUID = -5873125865419032570L;
	
	private JButton btnVerEmpleados;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JTextField fieldID;
	private JLabel lblMostrarTodosLos;


	public PanelMostrarTodosEmpleadosPoseenCompetencia(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		btnVerEmpleados = new JButton("Ver empleados ");
		btnVerEmpleados.setBackground(SystemColor.textHighlight);
		btnVerEmpleados.setBounds(208, 376, 262, 57);
		add(btnVerEmpleados);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(81, 106, 522, 254);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		
		fieldID = new JTextField();
		fieldID.setBounds(81, 73, 224, 20);
		add(fieldID);
		fieldID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduce ID de la competencia");
		lblNewLabel.setBounds(83, 54, 222, 14);
		add(lblNewLabel);
		
		lblMostrarTodosLos = new JLabel("Mostrar todos los empleados que poseen una competencia");
		lblMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodosLos.setBounds(81, 16, 475, 20);
		add(lblMostrarTodosLos);
		btnVerEmpleados.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(fieldID.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.mostrarEmpleadosQuePoseenCompetencia, Integer.valueOf(fieldID.getText())));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID debe ser un numero");
				}
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		List<TEmpleado> array = (List<TEmpleado>) contexto.getDatos();
		String texto = "";
		for (TEmpleado c : array) {
			String s = null;
			if (c.isActiva())
				s = "Activo";
			else
				s = "No activo";
			texto = texto +"ID: "+ c.getIdEmpleado() +  "\n" +"Nombre: "+ c.getNombre() + "\n" + "Password: " +c.getPassword() + "\n" +"Estado: "+ s +  "\n";

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}
