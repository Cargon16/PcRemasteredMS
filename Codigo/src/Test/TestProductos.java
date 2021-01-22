package Test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Integracion.TransactionManager.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;

public class TestProductos {

	TProducto producto = new TProducto();
	
	public void deleteFromTests(String nombre) { //metodo para poder borrar fisicamente de la BBDD, SOLO USADO AQUI PARA TESTS (no hacemos las comprobaciones del negocio pq siempre sabemos que va a funcionar)
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String query = "DELETE FROM producto WHERE Nombre =" + "'" + nombre + "'";
					state.executeQuery(query);
				
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		TransactionManager.getInstance().getTransaction().Commit();
		TransactionManager.getInstance().deleteTransaction();
	}
	
	@Test
	public void testCreatePassed() {
		deleteFromTests("nombre");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	
		
		Integer id = factoriaNegocio.generaSAProducto().CrearProducto(producto);
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(id);
		assertEquals(id, productoLeido.getID());
		assertEquals(productoLeido.getNombre(), producto.getNombre());
		
		deleteFromTests("nombre");
			
	}
	
	@Test
	public void testCreateFailed() {
		deleteFromTests("nombre");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	
		
		Integer id = factoriaNegocio.generaSAProducto().CrearProducto(producto);
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(id);
		assertEquals(id, productoLeido.getID());
		assertEquals(productoLeido.getNombre(), producto.getNombre());
		
		deleteFromTests("nombre");
	}
	
	@Test
	public void testUpdatePassed() {
		deleteFromTests("nombre");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	
		
		Integer id = factoriaNegocio.generaSAProducto().CrearProducto(producto);
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(id);
		assertEquals(id, productoLeido.getID());
		assertEquals(productoLeido.getNombre(), producto.getNombre());
		
		productoLeido.setNombre("cambiado");
		
		int idProductoCambiado = factoriaNegocio.generaSAProducto().UpdateProducto(productoLeido);
		
		TProducto productoLeidoActualizado = factoriaNegocio.generaSAProducto().readProducto(idProductoCambiado);
		
		assertEquals(productoLeidoActualizado.getNombre(), "cambiado"); //comprobamos que leyendo de bbdd el cambio se ha hecho
		
		deleteFromTests("cambiado");
	}
	
	@Test
	public void testUpdateFailed() {
		
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(-1); //comprobamos que no existe producto con id -1
		assertEquals(productoLeido, null);
		
		productoLeido = new TProducto();
		productoLeido.setID(-1); //le ponemos id a -1, para ver si actualiza un dato en bbdd o devuelve el int de error, -1
		
		int idProductoNoActualizado = factoriaNegocio.generaSAProducto().UpdateProducto(productoLeido);
		
		assertEquals(idProductoNoActualizado, -1); //-1 implica error
		
	}
	
	@Test
	public void testDeletePassed() {
		deleteFromTests("nombre");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	
		
		Integer id = factoriaNegocio.generaSAProducto().CrearProducto(producto);
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(id);
		assertEquals(id, productoLeido.getID());
		assertEquals(productoLeido.getNombre(), producto.getNombre());
		
		int idProductoEliminado = factoriaNegocio.generaSAProducto().BorrarProducto(productoLeido.getID());
		
		TProducto productoLeidoEliminado =  factoriaNegocio.generaSAProducto().readProducto(idProductoEliminado);
		
		assertEquals((int )productoLeidoEliminado.getStock(), (int) -1); //para eliminar se pone el stock a -1
		
		deleteFromTests("nombre");
	}
	
	@Test
	public void testDeleteFailed() {
		
		deleteFromTests("nombre");
		
		//puede fallar por dos razones: o no existe el producto(devuelve -2), o ya esta eliminado (stock a -1) (devuelve -1)
		
		//caso 1: no existe
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		TProducto productoLeido = factoriaNegocio.generaSAProducto().readProducto(-1); //comprobamos que no existe producto con id -1
		assertEquals(productoLeido, null); 
		
		productoLeido = new TProducto();
		productoLeido.setID(-1); //le ponemos id a -1, para ver si actualiza un dato en bbdd o devuelve el int de error, -1
		
		int idProductoNoEliminado = factoriaNegocio.generaSAProducto().BorrarProducto(productoLeido.getID());
		
		assertEquals(idProductoNoEliminado, -2); //-2 implica que no existia
		
		//caso 2: ya esta eliminado
		
		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(-1);	
		
		Integer id = factoriaNegocio.generaSAProducto().CrearProducto(producto);
		
		productoLeido = factoriaNegocio.generaSAProducto().readProducto(id);
		assertEquals(id, productoLeido.getID());
		assertEquals(productoLeido.getNombre(), producto.getNombre());
		
		 idProductoNoEliminado = factoriaNegocio.generaSAProducto().BorrarProducto(productoLeido.getID());
		 
		// assertEquals(idProductoNoEliminado, -1); //-1 implica que existia, pero estaba ya a stock= -1
		
		deleteFromTests("nombre");
	}
	
	
	
}
