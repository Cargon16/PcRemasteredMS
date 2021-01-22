package Presentacion.Command.Departamento;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class DeleteDepartamentoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer dept = Integer.parseInt((String) contexto);
		int i= FactoriaNegocio.getInstance().generaSADepartamento().borrarDepartamento(dept);
		if(i<1){
			return new Contexto(Eventos.borrarDepartamentoCommandError,i);
		}else return new Contexto(Eventos.borrarDepartamentoCommand, i);
		
	}

}
