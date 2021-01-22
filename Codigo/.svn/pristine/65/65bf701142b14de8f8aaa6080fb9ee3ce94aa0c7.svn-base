package Presentacion.Command.Ventas;



import Negocio.FactoriaNegocio.FactoriaNegocio;
import Presentacion.Command.Command;
import Presentacion.Command.Contexto;
import Presentacion.Command.Eventos;

public class PagoProductoVentaCommand implements Command{
	@Override
	public Contexto ejecutar(Object contexto) {
		Integer venta = (Integer) contexto;
		Integer ret = FactoriaNegocio.getInstance().generaSAVenta().pagarVenta(venta);
		if(ret < 0){
			return new Contexto(Eventos.pagoProductoVentaCommandError, ret);
		}else return new Contexto(Eventos.createVentaCommand, ret);
	}
	
}
