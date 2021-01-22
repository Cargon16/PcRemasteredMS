package Presentacion.Productos;

import javax.swing.JFrame;

import Presentacion.IGUI.Ventana;



public abstract class VentanaProducto extends JFrame implements Ventana {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static VentanaProducto instance = null;

	
	public static VentanaProducto getInstance() {
		// begin-user-code
		if(instance==null){
			instance = new VentanaProductosImp();
			
		}
		return instance;
		// end-user-code
	}

	public static void setInstance() {
		
		instance = null;
		
	}
}