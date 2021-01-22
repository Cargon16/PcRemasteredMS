package Presentacion.Empleado;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class panelDeleteEmpleado extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;


	public panelDeleteEmpleado(){
		initComponent();
	}

	public void initComponent(){
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setBounds(57, 95, 157, 42);
		add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(Parseador.esNumerico(textField.getText())){
						Controller.getInstance().ejecutar(new Contexto(Eventos.borrarEmpleado, textField.getText()));
					}else{
						JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
					}



				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}	
		});
		btnNewButton.setBounds(218, 95, 157, 42);
		add(btnNewButton);

		JLabel lblIntroduceElId = new JLabel("Introduce el Id para eliminar ese empleado");
		lblIntroduceElId.setBounds(57, 66, 318, 16);
		add(lblIntroduceElId);

		JLabel lblEliminarCliente = new JLabel("Eliminar Empleado");
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarCliente.setBounds(57, 28, 167, 35);
		add(lblEliminarCliente);
	}
	@Override
	public void actualizar(Contexto contexto) {
		this.revalidate();
		this.repaint();

	}

	public void resetCamps(){
		textField.setText(null);

	}

}
