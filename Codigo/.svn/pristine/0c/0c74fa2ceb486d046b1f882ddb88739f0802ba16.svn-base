/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Presentacion.Dispatcher;

import Presentacion.Command.Contexto;

public abstract class Dispatcher {

	private static Dispatcher instance;

	public static Dispatcher getInstancer() {
		if (instance == null) {
			instance = new DispatcherImp();
		}
		return instance;
	}

	public abstract void generarVista(Contexto contexto);

}
