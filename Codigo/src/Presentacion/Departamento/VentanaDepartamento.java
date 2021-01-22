package Presentacion.Departamento;

import javax.swing.JFrame;

import Presentacion.IGUI.Ventana;

public abstract class VentanaDepartamento extends JFrame implements Ventana {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static VentanaDepartamento instance = null;

	public static VentanaDepartamento getInstance() {
		if ( instance==null){
			instance = new VentanaDepartamentosImp(); 
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	}


	public abstract void initPanel();


	public abstract void initComponent();

}
