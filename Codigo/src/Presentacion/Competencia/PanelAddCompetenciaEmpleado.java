package Presentacion.Competencia;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelAddCompetenciaEmpleado extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textoCompetencia;
	private JButton btnNewButton;
	private JTextField nivelText;



	public PanelAddCompetenciaEmpleado(){
		initComponent();
	}

	public void initComponent(){
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setBounds(57, 101, 262, 35);
		add(textField);
		textField.setColumns(10);
		
		textoCompetencia = new JTextField();
		textoCompetencia.setBounds(57, 194, 262, 35);
		add(textoCompetencia);
		textoCompetencia.setColumns(10);

		nivelText = new JTextField();
		nivelText.setColumns(10);
		nivelText.setBounds(57, 277, 262, 35);
		add(nivelText);
		
		btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(Parseador.esNumerico(textField.getText()) && Parseador.esNumerico(nivelText.getText()) && Parseador.esNumerico(textoCompetencia.getText())){
						ArrayList<String> aux = new ArrayList<String>();
						aux.add(textoCompetencia.getText());
						aux.add(textField.getText());
						aux.add(nivelText.getText());
						Controller.getInstance().ejecutar(new Contexto(Eventos.addCompetenciaEmpleado, aux));
					}else{
						JOptionPane.showMessageDialog(null, "Datos incorrectos, recuerda que todos deben ser números");
					}



				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}	
		});
		btnNewButton.setBounds(57, 328, 262, 42);
		add(btnNewButton);

		JLabel lblIntroduceElId = new JLabel("Introduce el Id del empleado");
		lblIntroduceElId.setBounds(57, 66, 250, 16);
		add(lblIntroduceElId);

		JLabel lblEliminarCliente = new JLabel("Añadir competencia a empleado");
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarCliente.setBounds(57, 13, 302, 35);
		add(lblEliminarCliente);
		
		JLabel lblIntroduceElId_1 = new JLabel("Introduce el Id de la competencia");
		lblIntroduceElId_1.setBounds(57, 161, 250, 16);
		add(lblIntroduceElId_1);
		
		JLabel lblIntroduceElId_1_1 = new JLabel("Introduce el nivel de la competencia");
		lblIntroduceElId_1_1.setBounds(57, 245, 262, 16);
		add(lblIntroduceElId_1_1);
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();

	}

	public void resetCamps(){
		textField.setText(null);
		textoCompetencia.setText(null);

	}
}
