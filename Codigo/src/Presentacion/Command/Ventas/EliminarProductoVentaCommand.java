package Presentacion.Command.Ventas;

import java.util.ArrayList;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVenta;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class EliminarProductoVentaCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> lista = (ArrayList<Object>) contexto;
		TVenta i = FactoriaNegocio.getInstance().generaSAVenta().eliminarProductoVenta((TVenta)lista.get(0), (Integer)lista.get(1));
		if ( i == null){
				return new Contexto(Eventos.deleteProductoVentaCommandError, i);
		}return new Contexto(Eventos.deleteProductoVentaCommand, i);
	}

}
