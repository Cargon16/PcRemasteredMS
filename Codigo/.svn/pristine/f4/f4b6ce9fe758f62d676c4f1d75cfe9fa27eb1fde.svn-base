package Presentacion.Command.Empleado;

import Integracion.Empleado.TTiempoCompleto;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class AddEmpleadoTiempoCompletoCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		TTiempoCompleto d = (TTiempoCompleto) contexto;
		int i= FactoriaNegocio.getInstance().generaSAEmpleado().crearEmpleado(d);
		if(i<1){
			return new Contexto(Eventos.addEmpleadoTiempoCompletoCommandError,i);
		}else return new Contexto(Eventos.addEmpleadoTiempoCompletoCommand, i);
		
	}

}
