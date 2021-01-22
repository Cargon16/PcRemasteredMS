/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */

package Presentacion.Command.Vista;

import Presentacion.Ventas.PanelPago;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;

public class VentanaPagoCommand implements Command {

	@Override
	public Contexto ejecutar(Object obj) {
		// TODO Auto-generated method stub
		Contexto contexto = (Contexto) obj;
		if(contexto.getDatos()==null || contexto.getDatos() instanceof String){
			PanelPago.getInstance().setTitle((String) contexto.getDatos());
			contexto.setDatos(null);

		}
		else{
			PanelPago.getInstance().actualizar(contexto);
		}
		return contexto ;
	}

}
