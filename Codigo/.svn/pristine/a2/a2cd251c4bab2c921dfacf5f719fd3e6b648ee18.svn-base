package Presentacion.Command.Competencia;

import java.util.List;

import Integracion.Competencia.TCompetencia;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadAllCompetenciaCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		List<TCompetencia> i = FactoriaNegocio.getInstance().generaSACompetencia().readAllCompetencias();
		if(i==null || i.isEmpty()){
			return new Contexto(Eventos.readAllCompetenciaCommandError, i);
			
		}else return new Contexto(Eventos.readAllCompetenciaCommand, i);
	}

}
