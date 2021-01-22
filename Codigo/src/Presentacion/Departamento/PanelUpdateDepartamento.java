package Presentacion.Departamento;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Integracion.Departamento.TDepartamento;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;
import java.awt.Font;

public class PanelUpdateDepartamento extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField botonfindtext;
	
	private JLabel label_1;
	private TDepartamento c;
	private JButton botonFind;
	private JButton button;
	private JLabel lblIdDepartamento;
	private JLabel lblActualizarDepartamento;

	
	public PanelUpdateDepartamento() {
		setLayout(null);
		setOpaque(false);

		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(49, 193, 279, 35);
		add(nombre);

		label_1 = new JLabel("Nombre");
		label_1.setBounds(49, 163, 97, 16);
		add(label_1);


		button = new JButton("Actualizar");
		button.setBackground(SystemColor.textHighlight);

		button.setBounds(196, 265, 132, 43);
		// add(button);
		add(button);
		button.setVisible(false);
		botonfindtext = new JTextField();
		botonfindtext.setBounds(49, 89, 179, 35);
		add(botonfindtext);
		botonfindtext.setColumns(10);

		botonFind = new JButton("Buscar");
		botonFind.setBackground(SystemColor.textHighlight);

		botonFind.setBounds(240, 89, 88, 35);
		add(botonFind);
		
		lblIdDepartamento = new JLabel("Id Departamento");
		lblIdDepartamento.setBounds(49, 61, 145, 16);
		add(lblIdDepartamento);
		
		lblActualizarDepartamento = new JLabel("Actualizar departamento");
		lblActualizarDepartamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblActualizarDepartamento.setBounds(49, 25, 204, 20);
		add(lblActualizarDepartamento);
		botonFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(Parseador.esNumerico(botonfindtext.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.readDepartamento, botonfindtext.getText()));
				}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
				
			}
		});

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Parseador.esAlfabetico(nombre.getText())){

					
					c.setNombre(nombre.getText());
					try {
						Controller.getInstance().ejecutar(new Contexto(Eventos.updateDepartamento, (TDepartamento) c));
						
					} catch (Exception ex) {;}
				}else{
					JOptionPane.showMessageDialog(null, "Datos incorrectos, comprueba sintacticamente los datos introducidos");
				}

			}
		});

	}

	@Override
	public void actualizar(Contexto contexto) {
		try{
			c = (TDepartamento) contexto.getDatos();
			nombre.setText(c.getNombre());

			button.setVisible(true);

			repaint();
		}

		catch (Exception ex) {
			nombre.setText("");

		}

	}
	
	public void resetCamps(){
		
		nombre.setText(null);
		botonfindtext.setText(null);
		
		
	}
}
