package Presentacion.Command.Empleado;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class DeleteEmpleadoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer e = Integer.parseInt((String) contexto);
		int i= FactoriaNegocio.getInstance().generaSAEmpleado().borrarEmpleado(e);
		if(i<1){
			return new Contexto(Eventos.borrarEmpleadoCommandError,i);
		}else return new Contexto(Eventos.borrarEmpleadoCommand, i);
		
	}

}
