package Presentacion.Command.Ventas;


import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Venta.TVenta;
import Negocio.Venta.TVentaDetalles;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class ProcesarCompraCommand implements Command{

	public Contexto ejecutar(Object contexto) {
		TVenta venta= (TVenta) contexto;
		int i = FactoriaNegocio.getInstance().generaSAVenta().cerrarVenta(venta);
		if ( i < 0){
			return new Contexto(Eventos.procesarVentaCommandError, null);
		}
		else{
			TVentaDetalles v = FactoriaNegocio.getInstance().generaSAVenta().leerVenta(i);
			return new Contexto(Eventos.procesarVentaCommand, v);
		}
	}
}
