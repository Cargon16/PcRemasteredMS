package Presentacion.Command.Competencia;

import Integracion.Competencia.TCompetencia;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class CreateCompetenciaCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		TCompetencia c = (TCompetencia) contexto;
		int i= FactoriaNegocio.getInstance().generaSACompetencia().crearCompetencia(c);
		if(i<1){
			return new Contexto(Eventos.crearCompetenciaCommandError,i);
		}else return new Contexto(Eventos.crearCompetenciaCommand, i);
		
	}

}
