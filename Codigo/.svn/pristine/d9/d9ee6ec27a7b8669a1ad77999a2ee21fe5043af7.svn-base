package Presentacion.Competencia;

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

public class PanelDeleteCompetencia extends JPanel implements Ventana {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton btnNewButton;


	public PanelDeleteCompetencia(){
		initComponent();
	}

	public void initComponent(){
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setBounds(57, 95, 194, 42);
		add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Eliminar");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(Parseador.esNumerico(textField.getText())){
						Controller.getInstance().ejecutar(new Contexto(Eventos.borrarCompetencia, textField.getText()));
					}else{
						JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
					}



				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}	
		});
		btnNewButton.setBounds(254, 95, 125, 42);
		add(btnNewButton);

		JLabel lblIntroduceElId = new JLabel("Introduce el Id para eliminar esa competencia");
		lblIntroduceElId.setBounds(57, 66, 324, 16);
		add(lblIntroduceElId);

		JLabel lblEliminarCliente = new JLabel("Eliminar Competencia");
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEliminarCliente.setBounds(57, 28, 194, 35);
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
