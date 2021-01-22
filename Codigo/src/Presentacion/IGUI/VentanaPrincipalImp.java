/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Presentacion.IGUI;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.ControllerImp;




public class VentanaPrincipalImp extends VentanaPrincipal {

	private static final long serialVersionUID = 6981657744430004392L;
	public static String[] modulos = {"Producto","Venta","Cliente","Competencia","Empleado","Departamento"};

	public VentanaPrincipalImp() {
		super();
		initComponent();
	}

	public void initComponent() {
		JPanel principal = new JPanel(new BorderLayout());
		principal.add(new JLabel("Gestion PcRemastered"),BorderLayout.PAGE_START);

		JPanel panelCentral = new JPanel(new GridLayout(modulos.length,1));

		for (int i = 0; i < modulos.length; i++) {
			final int x=i;
			JButton button = new JButton(modulos[x]);
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 switch(modulos[x]){
					case "Producto":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaProducto,null));
						break;
					case "Venta":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaVentas, null));
						break;
					case "Cliente":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaCLientes, null));
						break;
					case "Competencia":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaCompetencia, null));
						break;
					case "Empleado":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaEmpelado, null));
						break;
					case "Departamento":
						ControllerImp.getInstance().ejecutar(new Contexto(Eventos.VistaDepartamento, null));
						break;
					default:
						break;
					}
					

				}
			});
			panelCentral.add(button);
		}
		principal.add(panelCentral,BorderLayout.CENTER);
		principal.setOpaque(true);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowDim = new Dimension((int) (Main.DIM.getWidth()), (int) (Main.DIM.getHeight() * (modulos.length + 1)));
		this.setBounds(
			(int) (dimension.getWidth() / 2 - windowDim.getWidth() / 2),
			(int) (dimension.getHeight() / 2 - windowDim.getHeight() / 2),
			(int) (windowDim.getWidth()),
			(int) (windowDim.getHeight())
		);
		

		this.setContentPane(panelCentral);
		this.setTitle("Tienda PcRemastered");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void resetCamps() {

	}

	@Override
	public void actualizar(Contexto contexto) {
		initComponent();
	}


}