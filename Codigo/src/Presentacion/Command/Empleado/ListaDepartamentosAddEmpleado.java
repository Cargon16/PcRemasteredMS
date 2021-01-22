package Presentacion.Command.Empleado;

import java.util.List;

import Integracion.Departamento.TDepartamento;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ListaDepartamentosAddEmpleado implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		List<TDepartamento> i = FactoriaNegocio.getInstance().generaSADepartamento().readAllDepartamentos();
		if(i==null){
			return new Contexto(Eventos.listaDepartamentosCommandError, i);
			
		}else return new Contexto(Eventos.listaDepartamentosCommand, i);
	}

}
