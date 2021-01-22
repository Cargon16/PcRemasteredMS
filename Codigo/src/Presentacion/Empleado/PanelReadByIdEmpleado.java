package Presentacion.Empleado;

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

import Integracion.Empleado.TEmpleado;
import Integracion.Empleado.TTiempoCompleto;
import Integracion.Empleado.TTiempoParcial;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelReadByIdEmpleado extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea textArea ;
	private JScrollPane scroll;
	private JLabel lblMostrarEmpleadoPor;
	
	public PanelReadByIdEmpleado(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Empleado");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(434, 84, 171, 42);
		add(button);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(83, 84, 339, 42);
		add(textField);
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 152, 522, 281);
		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);

		JLabel lblIntroduceElId = new JLabel("Introduce el ID");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroduceElId.setBounds(83, 61, 110, 16);
		add(lblIntroduceElId);
		
		lblMostrarEmpleadoPor = new JLabel("Mostrar empleado por ID");
		lblMostrarEmpleadoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarEmpleadoPor.setBounds(83, 25, 210, 20);
		add(lblMostrarEmpleadoPor);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(textField.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readEmpleado, textField.getText()));
					
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
		String texto="";
		TEmpleado c = (TEmpleado) contexto.getDatos();
		float sueldo;
		if (c.getActivo())
			s = "Activo";
		else
			s = "No activo";
		if(c instanceof TTiempoCompleto) sueldo = ((TTiempoCompleto)c).getSueldo();
		else sueldo = ((TTiempoParcial)c).getHorasSemana()*((TTiempoParcial)c).getSueldoHora();
		if (c instanceof TTiempoCompleto) {
			texto = texto+"ID: "+c.getIdEmpleado()+"\n" + "Nombre: "+ c.getNombre() + "\n" + "Telefono: "+ c.getTelefono() + "\n" + "Sueldo: "+ sueldo + "\n" 
					+"Estado: "+ s +  "\n" +"Departamento: "+ c.getDepartamento() +  "\n" ;
			
		}else{
			TTiempoParcial emplTP=(TTiempoParcial) c;
			texto = texto+"ID: "+c.getIdEmpleado()+"\n" + "Nombre: "+ c.getNombre() + "\n" + "Telefono: "+ c.getTelefono() + "\n" + "Sueldo: "+ sueldo + "\n" 
					+"Sueldo hora: "+emplTP.getSueldoHora()+"\n"+ "Horas semana: "+emplTP.getHorasSemana()+"\n"+"Estado: "+ s +  "\n" +"Departamento: "+ c.getDepartamento() +  "\n" ;
		}
		textArea.setText(texto);
		
	}
}
