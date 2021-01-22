package Presentacion.Departamento;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Negocio.Parseador.Parseador;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.Controller;
import Presentacion.IGUI.Ventana;

public class PanelCalcularCosteDepartamento extends JPanel implements Ventana{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JButton button;
	private JTextArea costeDepartTextField;
	private JLabel lblCalcularCosteDe;
	
	public PanelCalcularCosteDepartamento(){
		initComponent();
	}
	
	public void initComponent() {
		setLayout(null);
		setOpaque(false);
		button = new JButton("Buscar Departamento");
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(351, 97, 217, 42);
		add(button);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(43, 97, 293, 42);
		add(textField);

		JLabel lblIntroduceElId = new JLabel("Introduce el ID");
		lblIntroduceElId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIntroduceElId.setBounds(46, 74, 110, 16);
		add(lblIntroduceElId);
		
		JLabel lblCosteDelDepartamento = new JLabel("Coste del departamento");
		lblCosteDelDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCosteDelDepartamento.setBounds(46, 197, 191, 16);
		add(lblCosteDelDepartamento);
		
		costeDepartTextField = new JTextArea();
		costeDepartTextField.setColumns(10);
		costeDepartTextField.setBounds(43, 229, 169, 42);
		add(costeDepartTextField);
		
		lblCalcularCosteDe = new JLabel("Calcular coste de un departamento");
		lblCalcularCosteDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCalcularCosteDe.setBounds(43, 36, 293, 20);
		add(lblCalcularCosteDe);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Parseador.esNumerico(textField.getText())){
					Controller.getInstance().ejecutar(new Contexto(Eventos.costeDepartamento, textField.getText()));
					
				}else{
	    			JOptionPane.showMessageDialog(null, "Datos incorrectos, el ID a eliminar debe ser un numero");
	    		}
				

			}
		});
		
	}


	@Override
	public void resetCamps() {
		textField.setText(null);
		costeDepartTextField.setText(null);
		
	}


	@Override
	public void actualizar(Contexto contexto) {
		costeDepartTextField.setVisible(true);
		costeDepartTextField.setEditable(false);
		
		Integer coste = (Integer) contexto.getDatos();
		if(Parseador.comprobarNumeroPositivo(coste)){
			costeDepartTextField.setText(Integer.toString(coste));
		}else{
			JOptionPane.showMessageDialog(null, "El coste es negativo");
		}		
	}
	
	public void actualizarCoste(Contexto contexto) {
	
	

		
	}
}
