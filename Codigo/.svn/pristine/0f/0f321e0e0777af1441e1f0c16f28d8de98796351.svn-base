package Presentacion.Competencia;

import javax.swing.JFrame;
import Presentacion.IGUI.Ventana;

public abstract class VentanaCompetencias extends JFrame implements Ventana {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VentanaCompetencias instance = null;
	
	public static VentanaCompetencias getInstance() {
		if ( instance==null){
			instance = new VentanaCompetenciasImp();
		}
		return instance;
	}


	public static void setInstance(Object object) {
		instance=null;
	}

	
	public abstract void initPanel();


	public abstract void initComponent();

}
