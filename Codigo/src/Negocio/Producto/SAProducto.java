package Negocio.Producto;

import java.util.ArrayList;

public interface SAProducto {
	

	public Integer BorrarProducto(Integer ID);

	public Integer UpdateProducto(TProducto producto);

	public TProducto readProducto(Integer ID);

	public ArrayList<TProducto> readAllProducto();

	public Integer CrearProducto(TProducto producto);
	
	public TProducto leerProductoPorNombre(String nombre);

	public ArrayList<String> monitoresMasVendidosEnMes(Integer mes);

}