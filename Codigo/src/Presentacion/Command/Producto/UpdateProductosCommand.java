package Presentacion.Command.Producto;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class UpdateProductosCommand implements Command {
	
	@Override
	public Contexto ejecutar(Object contexto) {
	
		TProducto producto = (TProducto) contexto;
		int i= FactoriaNegocio.getInstance().generaSAProducto().UpdateProducto(producto);
		if(i == -1){
			return new Contexto(Eventos.updateProductoCommandError, i);
		}else return new Contexto(Eventos.updateProductoCommand, i);
		
	}
}