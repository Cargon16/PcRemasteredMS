package Presentacion.Departamento;

import java.awt.Font;
import java.awt.SystemColor;
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

import Integracion.Departamento.TDepartamento;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelReadByIdDepartamento extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea ;
	private JScrollPane scroll;
	private JLabel lblMostrarDepartamentoPor;
	
	public PanelReadByIdDepartamento(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Departamento");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(401, 83, 204, 42);
		add(button);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 83, 303, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 151, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("Introduce el ID");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroduceElId.setBounds(83, 60, 110, 16);
		add(lblIntroduceElId);
		
		lblMostrarDepartamentoPor = new JLabel("Mostrar departamento por ID");
		lblMostrarDepartamentoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarDepartamentoPor.setBounds(83, 24, 254, 20);
		add(lblMostrarDepartamentoPor);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(textField.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readDepartamento, textField.getText()));
					
				}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
				

			}
		});
		
	}


	@Override
	public void resetCamps() {
		textField.setText(null);
		textArea.setText(null);
		
	}


	@Override
	public void actualizar(Contexto contexto) {
		textArea.setVisible(true);
		String s = null;
		TDepartamento c = (TDepartamento) contexto.getDatos();
		if(c.getActivo())
			s= "Activo";
		else s= "No activo";
		textArea.setText("Nombre: "+ c.getNombre() + "\n" +"Estado: "+ s +  "\n" );
		
	}

}
