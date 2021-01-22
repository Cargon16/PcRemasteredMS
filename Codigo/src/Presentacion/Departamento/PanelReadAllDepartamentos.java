package Presentacion.Departamento;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Integracion.Departamento.TDepartamento;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelReadAllDepartamentos extends JPanel implements Ventana {

private static final long serialVersionUID = -5873125865419030570L;
	
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JLabel lblMostrarTodosLos;


	public PanelReadAllDepartamentos(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Ver los departamentos");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(83, 69, 210, 57);
		add(button);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 142, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		
		lblMostrarTodosLos = new JLabel("Mostrar todos los departamentos");
		lblMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodosLos.setBounds(83, 33, 290, 20);
		add(lblMostrarTodosLos);
		button.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllDepartamento, null));
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		List<TDepartamento> array = (List<TDepartamento>) contexto.getDatos();
		String texto = "";
		for (TDepartamento c : array) {
			String s = null;
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";
			texto = texto +"ID: "+ c.getIdDepartamento()+"\n" +"Nombre: "+ c.getNombre() + "\n"+"Coste departamento: "+c.getCosteDept() +"\n"+"Estado: "+ s +  "\n"+"---"+"\n";

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}
