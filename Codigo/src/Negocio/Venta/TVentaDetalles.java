package Negocio.Venta;

import Negocio.Cliente.TCliente;

public class TVentaDetalles {
	private TCliente c;
	private TVenta v;

	public TVentaDetalles(TCliente c, TVenta v) {
	        this.c = c;
	        this.v = v;
	    }

	public TCliente getCliente() {
		return c;
	}

	public TVenta getVenta() {
		return v;
	}

}
