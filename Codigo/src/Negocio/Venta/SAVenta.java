package Negocio.Venta;

import java.util.ArrayList;

public interface SAVenta {
	
	public TVenta crearVenta(Integer ID);

	public Integer borrarVenta(Integer ID);

	public TVentaDetalles leerVenta(Integer ID);

	public ArrayList<TVentaDetalles> leerTodosVenta();
	
	public TVenta eliminarProductoVenta(TVenta venta, Integer IdProducto);
	
	public TVenta addProductoVenta(TVenta venta, Integer IdProducto, Integer cantidad);
	
	public Integer cerrarVenta(TVenta venta);
	
	public Integer pagarVenta(Integer idVenta);
	
}