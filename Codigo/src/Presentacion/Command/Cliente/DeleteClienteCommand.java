package Presentacion.Command.Cliente;


import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class DeleteClienteCommand implements Command {

	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer cliente=Integer.parseInt((String) contexto);
		int i= FactoriaNegocio.getInstance().generaSACliente().borrarCliente(cliente);
		if(i<1){
			return new Contexto(Eventos.deleteClienteErrorCommand,i);
		}else return new Contexto(Eventos.deleteClienteCommand, i);
		
	}
}