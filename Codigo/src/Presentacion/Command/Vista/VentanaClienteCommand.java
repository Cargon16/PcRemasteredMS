package Presentacion.Command.Vista;

import Presentacion.Clientes.VentanaClientes;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;

public class VentanaClienteCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Contexto contextoN = (Contexto) contexto;
		if(contextoN==null){
			contextoN.setDatos(null);
		}else
			VentanaClientes.getInstance().actualizar(contextoN);
		return contextoN;
	}

}
