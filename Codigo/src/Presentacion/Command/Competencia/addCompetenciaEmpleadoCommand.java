package Presentacion.Command.Competencia;

import java.util.ArrayList;

import Negocio.Competencia.TieneID;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class addCompetenciaEmpleadoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<String> lista = (ArrayList<String>)contexto;
		TieneID t = new TieneID(Integer.valueOf(lista.get(0)), Integer.valueOf(lista.get(1)));
		int i= FactoriaNegocio.getInstance().generaSACompetencia().addCompetenciaEmpleado(t,Integer.valueOf(lista.get(2)) );
		if(i<1){
			return new Contexto(Eventos.addCompetenciaCommandError,i);
		}else return new Contexto(Eventos.addCompetenciaEmpleadoCommand, i);
		
	}
}
