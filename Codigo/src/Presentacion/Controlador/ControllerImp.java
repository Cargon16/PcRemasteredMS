package Presentacion.Controlador;


import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Dispatcher.Dispatcher;
import Presentacion.Factorias.FactoriaCommands;

public class ControllerImp extends Controller {

	public void ejecutar(Contexto contexto) {
		
		Command comando = FactoriaCommands.getInstance().generacionCommand(contexto.getEvento()); 
		Contexto contextResultado =null;
		if(comando!=null){
			
			contextResultado = comando.ejecutar(contexto.getDatos());
			Dispatcher.getInstancer().generarVista(contextResultado);
			
		}else{
			Dispatcher.getInstancer().generarVista(contexto);
		}
									
	}
}