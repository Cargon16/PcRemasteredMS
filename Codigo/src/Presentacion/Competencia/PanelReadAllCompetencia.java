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

import Integracion.Competencia.TCompetencia;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelReadAllCompetencia extends JPanel implements Ventana {

	private static final long serialVersionUID = -5873125865419030570L;
	
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JLabel lblMostrarTodasLas;


	public PanelReadAllCompetencia(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Ver las competencias");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(82, 78, 189, 52);
		add(button);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(82, 146, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		
		lblMostrarTodasLas = new JLabel("Mostrar todas las competencias");
		lblMostrarTodasLas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodasLas.setBounds(82, 30, 277, 20);
		add(lblMostrarTodasLas);
		button.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllCompetencia, null));
			}

		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		@SuppressWarnings("unchecked")
		List<TCompetencia> array = (List<TCompetencia>) contexto.getDatos();
		String texto = "";
		for (TCompetencia c : array) {
			String s = null;
			if (c.isActiva())
				s = "Activo";
			else
				s = "No activo";
			texto = texto +"ID: "+ c.getIdCompetencia() +  "\n" +"Nombre: "+ c.getNombre() + "\n" +"Estado: "+ s +  "\n";

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}

}
