package Presentacion.Command.Producto;

import java.util.ArrayList;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadAllProductosCommand implements Command {
	
	@Override
	public Contexto ejecutar(Object contexto) {
		ArrayList<TProducto> i= FactoriaNegocio.getInstance().generaSAProducto().readAllProducto();
		if(i==null || i.isEmpty()){
			return new Contexto(Eventos.readAllProductoCommandError, i);
		}else return new Contexto(Eventos.readAllProductoCommand, i);
	}
}