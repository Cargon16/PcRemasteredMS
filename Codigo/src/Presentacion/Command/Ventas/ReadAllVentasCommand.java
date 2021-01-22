package Presentacion.Command.Ventas;

import java.util.ArrayList;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadAllVentasCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		ArrayList<TVentaDetalles> i= FactoriaNegocio.getInstance().generaSAVenta().leerTodosVenta();
		if(i==null || i.isEmpty()){
			return new Contexto(Eventos.readAllVentaCommandError, null);
		}else return new Contexto(Eventos.readAllVentaCommand, i);
	}
}
