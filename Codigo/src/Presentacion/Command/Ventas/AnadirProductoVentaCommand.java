package Presentacion.Command.Ventas;

import java.util.ArrayList;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVenta;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class AnadirProductoVentaCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		@SuppressWarnings("unchecked")
		ArrayList<Object> lista =(ArrayList<Object>) contexto;
		TVenta venta = FactoriaNegocio.getInstance().generaSAVenta().addProductoVenta((TVenta)lista.get(1), (Integer)lista.get(0),(Integer)lista.get(2));
		if(venta ==null){
			return new Contexto(Eventos.addProductoVentaCommandError, null);
		}else return new Contexto(Eventos.addProductoVentaCommand, venta);
	}

}
