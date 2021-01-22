package Presentacion.IGUI;

import java.awt.Dimension;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;
import Presentacion.Controlador.ControllerImp;

public class Main {

	static VentanaPrincipal ventanaPrincipal;
	public static Dimension DIM = new Dimension(700, 80);
	public static void main(String[] args) {
		

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {

					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

				} catch (ClassNotFoundException e) {

					e.printStackTrace();

				} catch (InstantiationException e) {

					e.printStackTrace();

				} catch (IllegalAccessException e) {

					e.printStackTrace();

				} catch (UnsupportedLookAndFeelException e) {

					e.printStackTrace();

				}

				ControllerImp.getInstance().ejecutar(new Contexto(Eventos.GUI, null));
				

			}

		});
	}

}
