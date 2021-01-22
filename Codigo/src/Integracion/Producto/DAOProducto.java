/**
 * 
 */
package Integracion.Producto;
import java.util.ArrayList;

import Negocio.Producto.TProducto;


public interface DAOProducto {
	public Integer create(TProducto producto);

	public ArrayList<TProducto> readAll();
	
	public Integer delete(Integer idProducto);
	
	public Integer update(TProducto producto);

	public TProducto readByID(Integer ID);

	public TProducto readByNombre(String nombre);
}