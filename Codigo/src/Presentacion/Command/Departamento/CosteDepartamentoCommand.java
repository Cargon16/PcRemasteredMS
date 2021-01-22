package Presentacion.Command.Departamento;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Parseador.Parseador;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class CosteDepartamentoCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer dept = Integer.parseInt((String) contexto);
		Integer i = FactoriaNegocio.getInstance().generaSADepartamento().calcularCosteDepartamento(dept);
		if(!Parseador.comprobarNumeroPositivo(i)){
			return new Contexto(Eventos.costeDepartamentoCommandError, i);
		}return new Contexto(Eventos.costeDepartamentoCommand, i);
	}
}
