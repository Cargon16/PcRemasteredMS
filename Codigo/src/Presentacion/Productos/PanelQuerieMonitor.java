package Presentacion.Productos;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Presentacion.Command.Contexto;
import Presentacion.IGUI.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Negocio.Parseador.Parseador;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class PanelQuerieMonitor extends JPanel implements Ventana {
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTextArea text;
	private JLabel lblMonitorMsVendido;
	private JLabel lblIntroduceElNmero;

	public PanelQuerieMonitor() {

		initComponents();
	}

	public void initComponents() {
		setLayout(null);
		setOpaque(false);
		textField = new JTextField();
		textField.setBounds(55, 119, 295, 47);
		add(textField);
		textField.setColumns(10);

		text = new JTextArea();

		JScrollPane scroll = new JScrollPane(text);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setVisible(true);
		scroll.setBounds(56, 186, 522, 150);
		add(scroll);

		text.setVisible(false);
		text.setEditable(false);
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(textField.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.queryMonitor, Integer.valueOf(textField.getText())));
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, el mes debe ser un numero");
				}
			}
		});
		btnNewButton.setBounds(383, 119, 195, 47);
		add(btnNewButton);
		
		lblMonitorMsVendido = new JLabel("MONITOR M\u00C1S VENDIDO EN UN MES");
		lblMonitorMsVendido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMonitorMsVendido.setBounds(55, 46, 334, 20);
		add(lblMonitorMsVendido);
		
		lblIntroduceElNmero = new JLabel("Introduce el n\u00FAmero del mes");
		lblIntroduceElNmero.setBounds(55, 82, 258, 20);
		add(lblIntroduceElNmero);
	}

	@Override
	public void resetCamps() {
		textField.setText(null);
		text.setText(null);
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		text.setVisible(true);
		//Contexto cnx = (Contexto) contexto.getDatos();
		@SuppressWarnings("unchecked")
		ArrayList<String> lista = (ArrayList<String>) contexto.getDatos();
		String texto = "";

		for (String c : lista) {
			texto += "Monitor: " + c + "\n";
		}
		text.setText(texto);
		
	}

}