package Presentacion.Command.Ventas;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadVentasCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		Integer venta = (Integer) contexto;
		TVentaDetalles i= FactoriaNegocio.getInstance().generaSAVenta().leerVenta(venta);
		if(i==null){
			return new Contexto(Eventos.readVentaCommandError, i);
		}else return new Contexto(Eventos.readVentaCommand, i);
	}
}
