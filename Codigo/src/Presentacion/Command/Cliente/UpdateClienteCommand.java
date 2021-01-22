package Presentacion.Command.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class UpdateClienteCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		TCliente cliente =(TCliente) contexto;
		int i=FactoriaNegocio.getInstance().generaSACliente().updateCliente(cliente);
		if(i==-1){
			return new Contexto(Eventos.updateClienteErrorCommand, i);
			
		}return new Contexto(Eventos.updateClienteCommand, i);
	}

	
	
}