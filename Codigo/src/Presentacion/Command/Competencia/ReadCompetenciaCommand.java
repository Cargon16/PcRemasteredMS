package Presentacion.Command.Competencia;

import Integracion.Competencia.TCompetencia;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadCompetenciaCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer competencia=Integer.parseInt((String) contexto);
		TCompetencia i = FactoriaNegocio.getInstance().generaSACompetencia().readCompetencia(competencia);
		if(i==null){
			return new Contexto(Eventos.readCompetenciaCommandError, i);
		}return new Contexto(Eventos.readCompetenciaCommand, i);
	}

}
