package Presentacion.Command.Vista;

import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Productos.VentanaProducto;

public class VentanaProductosCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Contexto contextoN = (Contexto) contexto;
		if(contextoN==null){
			contextoN.setDatos(null);
		}else
			VentanaProducto.getInstance().actualizar(contextoN);
		return contextoN;
	}

}
