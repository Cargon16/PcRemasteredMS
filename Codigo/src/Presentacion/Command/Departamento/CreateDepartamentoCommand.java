package Presentacion.Command.Departamento;

import Integracion.Departamento.TDepartamento;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class CreateDepartamentoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		TDepartamento d = (TDepartamento) contexto;
		int i= FactoriaNegocio.getInstance().generaSADepartamento().crearDepartamento(d);
		if(i<1){
			return new Contexto(Eventos.crearDepartamentoCommandError,i);
		}else if(i==100){
			
			return new Contexto(Eventos.ReactivarDepartamentoCommand,i);
			
		}else return new Contexto(Eventos.crearDepartamentoCommand, i);
		
	}

}
