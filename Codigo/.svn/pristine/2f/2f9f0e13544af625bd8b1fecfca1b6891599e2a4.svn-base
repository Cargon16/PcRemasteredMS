package Presentacion.Command.Departamento;

import Integracion.Departamento.TDepartamento;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadDepartamentoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer dept = Integer.parseInt((String) contexto);
		TDepartamento i = FactoriaNegocio.getInstance().generaSADepartamento().readDepartamento(dept);
		if(i==null){
			return new Contexto(Eventos.readDepartamentoCommandError, i);
		}return new Contexto(Eventos.readDepartamentoCommand, i);
	}
}
