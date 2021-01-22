package Presentacion.Empleado;

import javax.swing.JFrame;

import Presentacion.IGUI.Ventana;

public abstract class VentanaEmpleados extends JFrame implements Ventana{

private static final long serialVersionUID = 1L;
	
private static VentanaEmpleados instance = null;
	
	public static VentanaEmpleados getInstance() {
		if ( instance==null){
			instance = new VentanaEmpleadosImp();
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	}
	
	public abstract void initPanel();


	public abstract void initComponent();

}
