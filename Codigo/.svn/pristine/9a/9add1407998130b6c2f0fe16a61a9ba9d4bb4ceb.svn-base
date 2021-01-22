package Presentacion.Command.Empleado;

import java.util.List;

import Integracion.Empleado.TEmpleado;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadAllEmpleadoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		List<TEmpleado> i = FactoriaNegocio.getInstance().generaSAEmpleado().readAllEmpleados();
		if(i==null || i.isEmpty()){
			return new Contexto(Eventos.readAllEmpleadoCommandError, i);
			
		}else return new Contexto(Eventos.readAllEmpleadoCommand, i);
	}

}
