package Presentacion.Command.Empleado;

import Integracion.Empleado.TTiempoParcial;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class AddEmpleadoTiempoParcialCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		TTiempoParcial d = (TTiempoParcial) contexto;
		int i= FactoriaNegocio.getInstance().generaSAEmpleado().crearEmpleado(d);
		if(i<1){
			return new Contexto(Eventos.addEmpleadoTiempoParcialCommandError,i);
		}else return new Contexto(Eventos.addEmpleadoTiempoParcialCommand, i);
		
	}

}
