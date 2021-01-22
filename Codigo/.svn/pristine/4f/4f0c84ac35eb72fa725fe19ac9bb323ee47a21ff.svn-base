package Presentacion.Ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class panelDevolverVenta extends JPanel implements Ventana{
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	public panelDevolverVenta() {

		initComponents();
	}

	public void initComponents() {
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setBounds(25, 100, 214, 38);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Devolver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(Parseador.esNumerico(textField.getText())){
						Controller.getInstance().ejecutar(new Contexto(Eventos.deleteVenta, Integer.valueOf(textField.getText())));
					}else{
						JOptionPane.showMessageDialog(null, "El ID para la busqueda debe ser numerico");
					}
					
			
			}
		});
		btnNewButton.setBounds(254, 100, 174, 38);
		add(btnNewButton);
		
		JLabel lblDevolverVenta = new JLabel("Devolver Venta");
		lblDevolverVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevolverVenta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDevolverVenta.setBounds(25, 16, 130, 38);
		add(lblDevolverVenta);
		
		JLabel lblIntroduceElId = new JLabel("Introduce el ID de la venta");
		lblIntroduceElId.setBounds(25, 70, 189, 20);
		add(lblIntroduceElId);
	}

	@Override
	public void resetCamps() {
		// TODO Auto-generated method stub
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
	}
}
