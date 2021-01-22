package Presentacion.Factorias;

import Presentacion.Command.Command;

public abstract class FactoriaCommands {

	private static FactoriaCommands instance= null;

	public static FactoriaCommands getInstance() {
		if ( instance== null){
			instance= new FactoriaCommandsImp();
		}
		return instance;
	}	
	public abstract Command generacionCommand(int evento);
		
}