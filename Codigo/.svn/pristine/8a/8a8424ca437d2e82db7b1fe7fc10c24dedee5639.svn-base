package Presentacion.Command.Competencia;

import java.util.ArrayList;

import Negocio.Competencia.TieneID;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class delCompetenciaEmpleadoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<String> lista = (ArrayList<String>)contexto;
		TieneID t = new TieneID(Integer.valueOf(lista.get(0)), Integer.valueOf(lista.get(1)));
		int i= FactoriaNegocio.getInstance().generaSACompetencia().deleteCompetenciaEmpleado(t);
		if(i<1){
			return new Contexto(Eventos.deleteCompetenciaEmpleadoCommandError,i);
		}else return new Contexto(Eventos.deleteCompetenciaEmpleadoCommand, i);
		
	}
}
