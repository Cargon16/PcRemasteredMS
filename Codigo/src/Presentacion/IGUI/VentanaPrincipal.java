package Presentacion.IGUI;

import javax.swing.JFrame;

import Presentacion.Command.Contexto;

public abstract class VentanaPrincipal extends JFrame implements Ventana {

	private static final long serialVersionUID = 1L;
	private static VentanaPrincipal instance;


	public static VentanaPrincipal getInstance() {
		if(instance==null)
			instance = new VentanaPrincipalImp();
		return instance;
	}


	public abstract void actualizar(Contexto contexto);
	
	public abstract void initComponent();
}