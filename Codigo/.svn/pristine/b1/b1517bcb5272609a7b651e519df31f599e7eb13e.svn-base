package Presentacion.Command.Producto;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadByIdProductosCommand implements Command {
		
	@Override
	public Contexto ejecutar(Object contexto) {
		TProducto i= FactoriaNegocio.getInstance().generaSAProducto().readProducto((Integer) contexto);
		if(i==null){
			return new Contexto(Eventos.readByIdProductosCommandError, i);
		}else return new Contexto(Eventos.readByIdProductosCommand, i);
	}
}