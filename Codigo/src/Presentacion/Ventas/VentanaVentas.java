/**
 * 
 */
package Presentacion.Ventas;

import javax.swing.JFrame;

import Presentacion.IGUI.Ventana;
import Presentacion.IGUI.Ventana;

public abstract class VentanaVentas extends JFrame implements Ventana{

private static final long serialVersionUID = 1L;
	
	private static VentanaVentas instance = null;

	
	public static VentanaVentas getInstance() {
		if ( instance==null){
			instance = new VentanaVentasImp();
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	
	}


}