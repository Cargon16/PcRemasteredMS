/**
 * 
 */
package Integracion.FactoriaIntegracion;

import Integracion.Cliente.DAOClienteImpl;
import Integracion.Producto.DAOProductoImp;
import Integracion.Venta.DAOVentaImp;

public abstract class FactoriaIntegracion {

	private static FactoriaIntegracion instance;
	
	public static synchronized FactoriaIntegracion getInstance() {
		
		if(instance==null ){
			instance = new FactoriaIntegracionImp();
		}
		return instance;
	}


	public abstract DAOClienteImpl crearDAOCliente();

	public abstract DAOProductoImp crearDAOProducto();

	public abstract DAOVentaImp CrearDAOVenta();
}