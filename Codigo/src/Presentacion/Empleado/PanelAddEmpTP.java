package Presentacion.Empleado;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Integracion.Departamento.TDepartamento;
import Integracion.Empleado.TTiempoParcial;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JTextArea;

public class PanelAddEmpTP extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;

	private JTextField NombreText;
	private JTextField ContrasenaText;
	private JTextField telefonoText;
	private JRadioButton activoRB;
	private JRadioButton inactivoRB;
	private JTextField sueldoText;
	private JTextField horasText;
	private JTextField departamentoTextField;
	private JButton buttonDeptDispon;
	private JTextArea listaDepartamentosDispo;

	public PanelAddEmpTP(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		NombreText = new JTextField();
		NombreText.setColumns(10);
		NombreText.setBounds(47, 62, 279, 35);
		add(NombreText);

		JLabel label = new JLabel("Nombre");
		label.setBounds(47, 49, 88, 14);
		add(label);

		ContrasenaText = new JTextField();
		ContrasenaText.setColumns(10);
		ContrasenaText.setBounds(47, 129, 279, 35);
		add(ContrasenaText);

		JLabel label_1 = new JLabel("Contrase�a");
		label_1.setBounds(47, 113, 111, 14);
		add(label_1);

		telefonoText = new JTextField();
		telefonoText.setColumns(10);
		telefonoText.setBounds(47, 319, 279, 35);
		add(telefonoText);

		JLabel label_2 = new JLabel("Tel�fono");
		label_2.setBounds(47, 304, 75, 14);
		add(label_2);

		sueldoText = new JTextField();
		sueldoText.setColumns(10);
		sueldoText.setBounds(47, 192, 279, 35);
		add(sueldoText);

		JLabel label_4 = new JLabel("Sueldo hora");
		label_4.setBounds(47, 177, 111, 14);
		add(label_4);

		horasText = new JTextField();
		horasText.setColumns(10);
		horasText.setBounds(47, 259, 279, 35);
		add(horasText);

		JLabel label_5 = new JLabel("Horas por semana");
		label_5.setBounds(47, 240, 174, 14);
		add(label_5);


		activoRB = new JRadioButton("Activo");
		activoRB.setToolTipText("Activo");
		activoRB.setBounds(49, 451, 109, 23);
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

		inactivoRB.setBounds(145, 451, 109, 23);
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


				//Controller.getInstance().ejecutar(new Contexto(Eventos.readAllEmpleado, null));

				if(Parseador.esAlfabetico(NombreText.getText()) &&  Parseador.esNumerico(telefonoText.getText()) && Parseador.comprobarNumeroPositivo(Integer.valueOf(horasText.getText())) && Parseador.comprobarNumeroPositivo(Integer.valueOf(sueldoText.getText())) && Parseador.esNumerico(departamentoTextField.getText())){
					TTiempoParcial tc = new TTiempoParcial(Integer.valueOf(telefonoText.getText()), ok, NombreText.getText(), ContrasenaText.getText(),Integer.valueOf(departamentoTextField.getText()), Integer.valueOf(sueldoText.getText()), Integer.valueOf(horasText.getText()));
					tc.setTipoEmpleado("TiempoParcial");
					Controller.getInstance().ejecutar(new Contexto(Eventos.addEmpleadoTiempoParcial, tc));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos.");
				}

			}
		});
		button.setBounds(240, 439, 88, 40);
		add(button);

		JLabel lblAadirCliente = new JLabel("A�adir empleado tiempo parcial");
		lblAadirCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAadirCliente.setBounds(47, 14, 281, 32);
		add(lblAadirCliente);

		departamentoTextField = new JTextField();
		departamentoTextField.setColumns(10);
		departamentoTextField.setBounds(47, 385, 279, 35);
		add(departamentoTextField);

		JLabel labelDepartamento = new JLabel("Departamento (ID)");
		labelDepartamento.setBounds(47, 370, 157, 14);
		add(labelDepartamento);

		listaDepartamentosDispo = new JTextArea();
		listaDepartamentosDispo.setBounds(410, 110, 221, 206);
		add(listaDepartamentosDispo);

		JLabel labelDepartamentosDisponibles = new JLabel("Departamentos disponibles");
		labelDepartamentosDisponibles.setBounds(408, 83, 223, 14);
		add(labelDepartamentosDisponibles);

		buttonDeptDispon = new JButton("Mostrar");
		buttonDeptDispon.setBackground(SystemColor.textHighlight);
		buttonDeptDispon.setBounds(490, 332, 141, 40);
		buttonDeptDispon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Controller.getInstance().ejecutar(new Contexto(Eventos.listaDepartamentos, null));
			}
		});
		add(buttonDeptDispon);

	}

	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();
	}

	public void resetCamps(){
		sueldoText.setText(null);
		NombreText.setText(null);
		ContrasenaText.setText(null);
		telefonoText.setText(null);
		activoRB.setSelected(false);
		inactivoRB.setSelected(false);
		listaDepartamentosDispo.setText(null);
	}

	public void actualizarListaDepartamentos(Contexto contexto) {
		// TODO Auto-generated method stub
		//Lista de departamentos disponibles
		@SuppressWarnings("unchecked")
		List<TDepartamento> listaDept = (List<TDepartamento>) contexto.getDatos();
		String texto = "";
		for (TDepartamento c : listaDept) {
			String s = null;
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";
			texto = texto + "ID: " + c.getIdDepartamento()+ " Nombre: "+ c.getNombre() + "\n" +"Estado: "+ s +  "\n";

		}
		listaDepartamentosDispo.setText(texto);
		listaDepartamentosDispo.setEditable(false);

	}
}
