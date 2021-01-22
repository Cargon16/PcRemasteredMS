package Presentacion.Command.Departamento;

import Integracion.Departamento.TDepartamento;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class UpdateDepartamentoCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		TDepartamento dept = (TDepartamento)contexto;
		int i= FactoriaNegocio.getInstance().generaSADepartamento().updateDepartamento(dept);
		if(i<1){
			return new Contexto(Eventos.updateDepartamentoCommandError,i);
		}else return new Contexto(Eventos.updateDepartamentoCommand, i);
		
	}

}
