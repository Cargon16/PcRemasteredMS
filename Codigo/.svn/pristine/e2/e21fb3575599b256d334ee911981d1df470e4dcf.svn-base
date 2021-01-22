package Presentacion.Command.Ventas;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVenta;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class CreateVentasCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		Integer cliente = (Integer) contexto;
		TVenta v = FactoriaNegocio.getInstance().generaSAVenta().crearVenta(cliente);
		if ( v == null ){
			return new Contexto(Eventos.createVentaCommandError, v);
		}else return new Contexto(Eventos.createVentaCommand, v);
	}

}
