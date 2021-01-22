package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.junit.Test;

import Integracion.TransactionManager.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Cliente.TCliente;
import Negocio.FactoriaNegocio.FactoriaNegocio;
import Negocio.Producto.TProducto;
import Negocio.Venta.LineaVenta;
import Negocio.Venta.TVenta;
import Negocio.Venta.TVentaDetalles;

public class TestVentas {

	TVenta venta = new TVenta();
	TCliente cliente = new TCliente();
	TProducto producto = new TProducto();
	TProducto producto2 = new TProducto();
	LineaVenta lineaVenta = new LineaVenta();
	LineaVenta lineaVenta2 = new LineaVenta();


	TestClientes testClientes = new TestClientes();
	TestProductos testProductos = new TestProductos();




	public static void deleteFromTests(int idVenta, int idCliente, int idProducto) { //metodo para poder borrar fisicamente de la BBDD, SOLO USADO AQUI PARA TESTS (no hacemos las comprobaciones del negocio pq siempre sabemos que va a funcionar)

		TransactionManager transactionManager = TransactionManager.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();

			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String queryVentas = "DELETE FROM Venta WHERE IDVenta = " +  idVenta + " AND IDCliente = " + idCliente + ";";
					state.executeQuery(queryVentas);
					String queryLineaVentas = "DELETE FROM LineaVenta WHERE IDVenta = " + idVenta + " AND IDProducto = " + idProducto+ ";";
					state.execute(queryLineaVentas);


				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		TransactionManager.getInstance().getTransaction().Commit();
		TransactionManager.getInstance().deleteTransaction();
	}

	@Test
	public void testCerrarVentaPassed() { //crear venta no hace mas que crear la ventana de venta, luego cerrar aplica cambios a la bbdd

		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		//tenemos que crear primero tanto un cliente, como un producto, y una linea de ventas

		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(1);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(true);
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);

		//procedemos ahora a cerrar la venta

		int idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);

		//comprobamos que se ha cerrado, y que los atributos son los correctos		
		TVentaDetalles ventaLeida = factoriaNegocio.generaSAVenta().leerVenta(idVentaCreada);

		assertEquals(ventaLeida.getCliente().getIDCliente(), idCliente);
		assertEquals(ventaLeida.getVenta().getFecha(), Date.valueOf("2019-1-1"));
		assertEquals(ventaLeida.getVenta().getPagado(), true);
		assertEquals(ventaLeida.getVenta().getLineaVentas().get(idProducto).getIDProducto(), idProducto);

		//procedemos a eliminar de la BBDD para que no la modifique(no se queden datos inutiles)
		deleteFromTests(idVentaCreada, idCliente, idProducto);		
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");

	}

	@Test
	public void testCerrarVentaFailed() {

		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		/*existen 4 casos posibles de error para cerrar venta: (el numero del caso implica el codigo de error)
				caso -1: la venta es nula(no se ha inicializado)
				caso -2: no quedan suficientes productos en stock para la cantidad requerida, o nos piden una cantidad negativa
				caso -3: el producto esta eliminado (stock a -1)
				caso -4: el cliente no existe o esta en inactivo
		 */

		//caso -1: la venta es nula

		TVenta venta = null;
		int idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);
		assertEquals(idVentaCreada, -1); //comprobamos que efectivamente devuelve -1


		//caso -2: no quedan suficientes productos en stock para la cantidad requerida
		//inicialicemos las variables para poder probarlo

		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(1); //ponemos el stock a 1 y pedimos 2 en la venta	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(2);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(true);
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);

		//probamos a cerrar la venta

		idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);
		assertEquals(idVentaCreada, -2); //comprobamos que efectivamente devuelve -2


		//caso -3: el producto esta eliminado (stock a -1)
		//borramos el producto en la bbdd para probar este caso
		factoriaNegocio.generaSAProducto().BorrarProducto(idProducto);//pone el stock a -1

		idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);
		assertEquals(idVentaCreada, -3); //comprobamos que efectivamente devuelve -3

		//caso -4: el cliente no existe o esta en inactivo
		//borramos el cliente en la bbdd para probar este caso
		factoriaNegocio.generaSACliente().borrarCliente(idCliente);
		idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);
		assertEquals(idVentaCreada, -4); //comprobamos que efectivamente devuelve -4

		//eliminamos de la bbdd
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");

	}

	@Test
	public void testDeletePassed() {

		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		//comprobemos que se puede eliminar una venta
		//inicialicemos todos los datos para crearla

		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(1);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(true); //para eliminarla se pone pagado a false
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);

		//procedemos ahora a cerrar la venta

		int idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);

		//cargamos la venta de la bbdd, para que nos de el id	
		TVentaDetalles ventaLeida = factoriaNegocio.generaSAVenta().leerVenta(idVentaCreada);

		//probamos ahora a eliminarla
		int idVentaEliminada = factoriaNegocio.generaSAVenta().borrarVenta(ventaLeida.getVenta().getIDVenta());
		assertEquals(idVentaEliminada, (int) ventaLeida.getVenta().getIDVenta()); //asi comprobamos que borrar devuelve el idVenta de la eliminada

		//comprobamos ahora que esta en bbdd con pagado a false (no activo)
		ventaLeida = factoriaNegocio.generaSAVenta().leerVenta(idVentaEliminada);
		assertEquals(ventaLeida.getVenta().getPagado(), false);

		deleteFromTests(idVentaEliminada, idCliente, idProducto);		
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");

	}

	@Test
	public void testDeleteFailed() {
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		/*existen 2 casos posibles de error para eliminar venta: (el numero del caso implica el codigo de error)
			caso -3: la venta ya estaba inactiva
			caso -4: el id de venta no es valido (no existe venta con ese id)
		 */

		//caso -1: la venta ya estaba eliminada

		//inicialicemos los datos para crear la venta
		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(1);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(false); //la ponemos como ya eliminada, para probar a borrarla de nuevo
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);		

		//procedemos ahora a cerrar la venta

		int idVentaCreada = factoriaNegocio.generaSAVenta().cerrarVenta(venta);		

		//ahora intentamos borrarla para ver que no se puede
		factoriaNegocio.generaSAVenta().borrarVenta(idVentaCreada);

		//lo leemos para ver que sigue en borrado (pagado == false)
		TVentaDetalles ventaLeida = factoriaNegocio.generaSAVenta().leerVenta(idVentaCreada);
		assertEquals(ventaLeida.getVenta().getPagado(), false);

		deleteFromTests(idVentaCreada, idCliente, idProducto);		
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");

	}

	@Test
	public void testAddProductoVentaPassed() {
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		//creemos una venta y intentamos introducir un producto en ella

		//inicializemos todo para probarlo
		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(false); //la ponemos como ya eliminada, para probar a borrarla de nuevo
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(0, lineaVenta);

		venta.setLineaVentas(lineaVentas);
		venta.setIDVenta(0);

		//vamos a probar a�adir productos a la venta

		TVenta ventaAnadida = factoriaNegocio.generaSAVenta().addProductoVenta(venta, idProducto, 2);

		ventaAnadida.getLineaVentas().get(idProducto).getIDProducto();
		assertEquals(ventaAnadida.getLineaVentas().get(idProducto).getIDProducto(), idProducto);

		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");

	}

	@Test
	public void testAddProductoVentaFailed() {
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		// puede fallar por dos casos: o que la venta sea null o el producto no exista.

		//probemos primero con una venta null

		venta = null;

		TVenta ventaAnadida = factoriaNegocio.generaSAVenta().addProductoVenta(venta, 0, 2);

		assertEquals(ventaAnadida, null);

		//probemos ahora con producto no existente

		assertEquals(factoriaNegocio.generaSAProducto().readProducto(-1), null); //el producto con id -1 no existe

		venta = new TVenta();

		ventaAnadida = factoriaNegocio.generaSAVenta().addProductoVenta(venta, -1 , 2);

		assertEquals(ventaAnadida, null);



	}

	@Test
	public void testEliminarProductoVentaPassed() {
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();

		//queremos eliminar un producto de una venta
		//creemos una venta con un producto

		//creamos un cliente

		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(1);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(true); 
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);
		
		//comprobamos que la venta tiene un producto
		
		venta.getLineaVentas().get(idProducto).getIDProducto();
		assertEquals(venta.getLineaVentas().get(idProducto).getIDProducto(), idProducto);
		
		//pasamos a eliminarla
		
		factoriaNegocio.generaSAVenta().eliminarProductoVenta(venta, idProducto);
		
		//comprobamos que la venta ha perdido el producto
		
		assertEquals(venta.getLineaVentas().get(idProducto), null);
		
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");
		
	}

	@Test
	public void testEliminarProductoVentaFailed() {
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		//para que falle, o la venta es null o el producto no existe en la lista de ventas
		
		//probemos que la venta es null
		
		venta = null;
	 
		TVenta ventaProductoEliminado = factoriaNegocio.generaSAVenta().eliminarProductoVenta(venta, 0);
	 
		assertEquals(ventaProductoEliminado, null);
	 
		//probemos ahora con producto no existente en la venta
		//creemos una venta
		
		
		//creamos un cliente
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);

		Integer idCliente = factoriaNegocio.generaSACliente().crearCliente(cliente);

		//creamos ahora un producto

		producto = new TProducto();
		producto.setNombre("nombre");
		producto.setPrecio((float) 123);
		producto.setDescripcion("descripcion");
		producto.setStock(2);	

		Integer idProducto = factoriaNegocio.generaSAProducto().CrearProducto(producto);

		//creamos ahora la linea de venta
		lineaVenta = new LineaVenta();
		lineaVenta.setIDProducto(idProducto);
		lineaVenta.setCantidad(1);
		lineaVenta.setPrecioTotal(lineaVenta.getCantidad() * producto.getPrecio());	

		//teniendo ya cliente y producto, pasamos a crear la venta

		venta = new TVenta();
		venta.setIdCliente(idCliente);
		venta.setFecha(Date.valueOf("2019-1-1"));
		venta.setPagado(true);
		venta.setPrecioTotal((float) 1);

		HashMap<Integer, LineaVenta> lineaVentas = new HashMap<Integer, LineaVenta>();
		lineaVentas.put(idProducto, lineaVenta);

		venta.setLineaVentas(lineaVentas);
		
		//probamos a eliminar un producto no existente de la venta
		
		ventaProductoEliminado = factoriaNegocio.generaSAVenta().eliminarProductoVenta(venta, -1);
		
		assertEquals(ventaProductoEliminado, null);
	 
		testClientes.deleteFromTests("12345678k");
		testProductos.deleteFromTests("nombre");
	}





}
