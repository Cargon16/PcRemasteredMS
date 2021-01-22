/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Presentacion.Command.Producto;

import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class CreateProductosCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		int i = FactoriaNegocio.getInstance().generaSAProducto().CrearProducto((TProducto) contexto);
		if (i < 0) {
			if (i == -1) {
				return new Contexto(Eventos.createProductoErrorExisteCommand, i);
			} else
				return new Contexto(Eventos.createProductoCommandError, i);

		} else return new Contexto(Eventos.createProductoCommand, i);


	}
}