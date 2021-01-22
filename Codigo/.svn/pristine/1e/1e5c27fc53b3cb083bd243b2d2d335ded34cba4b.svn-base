package Presentacion.Command.Empleado;

import Integracion.Empleado.TEmpleado;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadEmpleadoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer e = Integer.parseInt((String) contexto);
		TEmpleado i = FactoriaNegocio.getInstance().generaSAEmpleado().readEmpleado(e);
		if(i==null){
			return new Contexto(Eventos.readEmpleadoCommandError, i);
		}return new Contexto(Eventos.readEmpleadoCommand, i);
	}

}
