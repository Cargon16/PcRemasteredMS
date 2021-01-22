package Presentacion.Command.Ventas;


import Negocio.FactoriaNegocio.FactoriaNegocio;

import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;


public class DeleteVentasCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		Integer venta = (Integer) contexto;
		Integer v = FactoriaNegocio.getInstance().generaSAVenta().borrarVenta(venta);
		if ( v < 0 ){
			return new Contexto(Eventos.deleteVentaCommandError, v);
		}else return new Contexto(Eventos.deleteVentaCommand, v); 	
	}
	


}
