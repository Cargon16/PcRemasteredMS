package Presentacion.Controlador;

import Presentacion.Command.Contexto;

public abstract class Controller {

	private static ControllerImp instance;

	
	public static Controller getInstance() {
		if ( instance == null){
			instance = new ControllerImp();
		}
		return instance;
	}
	public  abstract void  ejecutar(Contexto contexto);
	
}