/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Presentacion.Command.Producto;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class DeleteProductosCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		int i= FactoriaNegocio.getInstance().generaSAProducto().BorrarProducto(Integer.parseInt((String) contexto));
		if(i == -1){
			return new Contexto(Eventos.readProductoCommandError, i);
		}
		else if(i == -2){
			return new Contexto(Eventos.deleteProductoCommandError, i);
		}else return new Contexto(Eventos.deleteProductoCommand, i);

	}
}