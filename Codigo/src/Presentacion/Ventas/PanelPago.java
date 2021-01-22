package Presentacion.Ventas;

import javax.swing.JDialog;

import Presentacion.IGUI.Ventana;

public abstract class PanelPago extends JDialog implements Ventana{
	public PanelPago() {
	}

private static final long serialVersionUID = 1L;
	
	private static PanelPagoImp instance = null;

	
	public static PanelPagoImp getInstance() {
		if ( instance==null){
			instance = new PanelPagoImp();
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	
	}


}