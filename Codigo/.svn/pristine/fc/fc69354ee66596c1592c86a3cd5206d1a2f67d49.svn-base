package Presentacion.Command.Cliente;

import Negocio.Cliente.TCliente;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ReadClienteCommand implements Command {

	@Override
	public Contexto ejecutar(Object contexto) {
		// TODO Auto-generated method stub
		Integer cliente=Integer.parseInt((String) contexto);
		TCliente i = FactoriaNegocio.getInstance().generaSACliente().readCliente(cliente);
		if(i==null){
			return new Contexto(Eventos.readClienteErrorCommand, i);
		}return new Contexto(Eventos.readClienteCommand, i);
	}
}