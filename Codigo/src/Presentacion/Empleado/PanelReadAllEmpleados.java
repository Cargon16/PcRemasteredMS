package Presentacion.Empleado;

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
import Integracion.Empleado.TTiempoCompleto;
import Integracion.Empleado.TTiempoParcial;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelReadAllEmpleados extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JButton button;
	private JTextArea textArea;
	private JScrollPane scroll;
	private JLabel lblMostrarTodosLos;


	public PanelReadAllEmpleados(){
		initComponent();
	}

	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Ver los empleados");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(83, 63, 262, 57);
		add(button);

		textArea = new JTextArea();

		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(83, 136, 522, 281);

		add(scroll);
		textArea.setVisible(false);
		textArea.setEditable(false);
		
		lblMostrarTodosLos = new JLabel("Mostrar todos los empleados");
		lblMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMostrarTodosLos.setBounds(83, 27, 243, 20);
		add(lblMostrarTodosLos);
		button.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				
				Controller.getInstance().ejecutar(new Contexto(Eventos.readAllEmpleado, null));
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
			float sueldo;
			String s = null;
			if (c.getActivo())
				s = "Activo";
			else
				s = "No activo";
			if(c instanceof TTiempoCompleto) sueldo = ((TTiempoCompleto)c).getSueldo();
			else sueldo = ((TTiempoParcial)c).getHorasSemana()*((TTiempoParcial)c).getSueldoHora();
			
			if (c instanceof TTiempoCompleto) {
				texto = texto+"ID: "+c.getIdEmpleado()+"\n" + "Nombre: "+ c.getNombre() + "\n" + "Telefono: "+ c.getTelefono() + "\n" + "Sueldo: "+ sueldo + "\n" 
						+"Estado: "+ s +  "\n" +"Departamento: "+ c.getDepartamento() +  "\n"+"---"+"\n" ;
				
			}else{
				TTiempoParcial emplTP=(TTiempoParcial) c;
				texto = texto+"ID: "+c.getIdEmpleado()+"\n" + "Nombre: "+ c.getNombre() + "\n" + "Telefono: "+ c.getTelefono() + "\n" + "Sueldo: "+ sueldo + "\n" 
						+"Sueldo hora: "+emplTP.getSueldoHora()+"\n"+ "Horas semana: "+emplTP.getHorasSemana()+"\n"+"Estado: "+ s +  "\n" +"Departamento: "+ c.getDepartamento() +  "\n"+"---"+"\n" ;
			}
			

		}
		textArea.setText(texto);

	}

	public void resetCamps(){
		textArea.setText(null);
	}
}
