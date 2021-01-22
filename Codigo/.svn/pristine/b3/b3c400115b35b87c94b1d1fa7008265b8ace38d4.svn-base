package Presentacion.Clientes;

import javax.swing.JFrame;

import Presentacion.IGUI.Ventana;

public abstract class VentanaClientes extends JFrame implements Ventana{
	private static final long serialVersionUID = 1L;
	
	private static VentanaClientes instance = null;

	
	public static VentanaClientes getInstance() {
		if ( instance==null){
			instance = new VentanaClientesImp();
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	}


	public abstract void initPanel();


	public abstract void initComponent();
	
}