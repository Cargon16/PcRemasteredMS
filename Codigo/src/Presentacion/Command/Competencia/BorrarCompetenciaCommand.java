package Presentacion.Command.Competencia;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class BorrarCompetenciaCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer competencia=Integer.parseInt((String) contexto);
		int i= FactoriaNegocio.getInstance().generaSACompetencia().borrarCompetencia(competencia);
		if(i<1){
			return new Contexto(Eventos.borrarCompetenciaCommandError,i);
		}else return new Contexto(Eventos.borrarCompetenciaCommand, i);
		
	}

}
