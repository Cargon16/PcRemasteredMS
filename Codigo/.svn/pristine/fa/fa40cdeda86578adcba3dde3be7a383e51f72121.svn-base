package Presentacion.Departamento;

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

import Integracion.Departamento.TDepartamento;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelAddDepartamento extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;
	private JTextField Nombre;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	
	public PanelAddDepartamento(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		Nombre = new JTextField();
		Nombre.setColumns(10);
		Nombre.setBounds(37, 96, 205, 40);
		add(Nombre);

		JLabel label = new JLabel("Nombre");
		label.setBounds(37, 77, 75, 14);
		add(label);

		JLabel label_2 = new JLabel("Estado");
		label_2.setBounds(37, 165, 75, 14);
		add(label_2);

		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(37, 191, 109, 23);
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

		inactivoRB.setBounds(153, 191, 109, 23);
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
					TDepartamento t = new TDepartamento(Nombre.getText(), ok);
					Controller.getInstance().ejecutar(new Contexto(Eventos.crearDepartamento, t));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}
				
			}
		});
		button.setBounds(110, 241, 132, 40);
		add(button);

		JLabel lblAadirCliente = new JLabel("Añadir departamento");
		lblAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirCliente.setBounds(37, 16, 205, 32);
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
