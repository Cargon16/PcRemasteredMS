package Presentacion.Competencia;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Integracion.Competencia.TCompetencia;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelAddCompetencia extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	private JTextField Nombre;
	
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	
	public PanelAddCompetencia(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(109, 80, 279, 57);
		add(Nombre);

		JLabel label = new JLabel("Nombre");
		label.setBounds(37, 101, 57, 14);
		add(label);


		JLabel label_2 = new JLabel("Estado");
		label_2.setBounds(37, 171, 75, 14);
		add(label_2);

		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(123, 167, 109, 23);
		activoRB.setOpaque(false);
		inactivoRB = new JRadioButton("Inactivo");
		activoRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(false);
				activoRB.setSelected(true);
			}
		});
		add(activoRB);

		inactivoRB.setBounds(255, 167, 109, 23);
		inactivoRB.setOpaque(false);
		add(inactivoRB);
		inactivoRB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inactivoRB.setSelected(true);
				activoRB.setSelected(false);
			}
		});
		JButton button = new JButton("Anadir");
		button.setBackground(SystemColor.textHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ok = false ;
				if(activoRB.isSelected()) 
					ok = true;
				
				if(Parseador.esAlfabetico(Nombre.getText())){
					TCompetencia c = new TCompetencia( Nombre.getText(), ok);
					Controller.getInstance().ejecutar(new Contexto(Eventos.crearCompetencia, c));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}
				
			}
		});
		button.setBounds(256, 219, 132, 40);
		add(button);

		JLabel lblAadirCliente = new JLabel("A�adir competencia");
		lblAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirCliente.setBounds(37, 13, 162, 32);
		add(lblAadirCliente);



	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}
	
	public void resetCamps(){
		Nombre.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
	}

}
