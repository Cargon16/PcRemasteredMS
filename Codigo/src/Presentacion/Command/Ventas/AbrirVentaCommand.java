package Presentacion.Command.Ventas;


import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVenta;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class AbrirVentaCommand implements Command{

	@Override
	public Contexto ejecutar(Object contexto) {
		Integer cliente = (Integer) contexto;
		TVenta venta = FactoriaNegocio.getInstance().generaSAVenta().crearVenta(cliente);
		if(venta == null){
			return new Contexto(Eventos.abrirVentaCommandError, null);
		}else return new Contexto(Eventos.abrirVentaCommand, venta);
	}

	
}
