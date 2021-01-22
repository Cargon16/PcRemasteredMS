package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import Integracion.TransactionManager.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Cliente.TCliente;
import Negocio.FactoriaNegocio.FactoriaNegocio;

public class TestClientes {
	
	TCliente cliente = new TCliente();
	
	public void deleteFromTests(String DNI) { //metodo para poder borrar fisicamente de la BBDD, SOLO USADO AQUI PARA TESTS (no hacemos las comprobaciones del negocio pq siempre sabemos que va a funcionar)
	
		TransactionManager transactionManager = TransactionManager.getInstance();
		TransactionManager.getInstance().newTransaction().start();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String query = "DELETE FROM Cliente WHERE DNI =" + "'" + DNI + "'";
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
	public void testCreatedPassed() {
		
		deleteFromTests("12345678k");
		
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);
		
		Integer id = factoriaNegocio.generaSACliente().crearCliente(cliente);
		
		TCliente clienteLeido = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		assertEquals(clienteLeido.getIDCliente(), id);
		//comprobamos que todos los campos coinciden
		assertEquals(cliente.getNombre(), clienteLeido.getNombre());
		assertEquals(cliente.getDNI(), clienteLeido.getDNI());		
		assertEquals(cliente.getDireccion(), clienteLeido.getDireccion());
		assertEquals(cliente.getActivo(), clienteLeido.getActivo());
		assertEquals(cliente.getTelefono(), clienteLeido.getTelefono());		
		
		deleteFromTests("12345678k"); //el metodo delete usado es el fisico implementado en esta clase.
		
	}
	
	@Test
	public void testCreatedFailed() {
		
		deleteFromTests("12345678k");
			
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);
		
		Integer id = factoriaNegocio.generaSACliente().crearCliente(cliente); //lo añadimos a la BBDD por primera vez
		
		TCliente clienteLeido = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		
		//comprobamos que se ha subido los campos coinciden
		assertEquals(cliente.getDNI(), clienteLeido.getDNI());	
		
		//probamos ahora a resubirlo
		
		Integer idError = factoriaNegocio.generaSACliente().crearCliente(cliente); //lo añadimos a la BBDD por primera vez
		
		//comprobamos que no se ha subido y devuelve el integer de error
		assertEquals((int) idError, -2);
		
		deleteFromTests("12345678k");
	
	}
	
	@Test
	public void testDeletePassed() {
		
		deleteFromTests("12345678k");		
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);
				
		Integer id = factoriaNegocio.generaSACliente().crearCliente(cliente);
		TCliente clienteLeido = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		
		assertEquals(cliente.getNombre(), clienteLeido.getNombre());
		assertEquals(cliente.getActivo(), true); //comprobamos que se ha subido y que esta en activo
		
		int idBorrado = factoriaNegocio.generaSACliente().borrarCliente(id);
		
		assertEquals(idBorrado, (int) clienteLeido.getIDCliente()); //comprobamos que al borrar pasa id correcto
		
		TCliente clienteLeidoPostBorrar = factoriaNegocio.generaSACliente().readCliente(id); 
		
		assertEquals(clienteLeidoPostBorrar.getActivo(), false); //comprobamos que en la BBDD el cliente está en no activo
		
		deleteFromTests("12345678k");

		
	}
	@Test
	public void testDeleteFailed() {
		
		deleteFromTests("12345678k");
			
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(false);
		cliente.setTelefono(123);
		
		Integer id = factoriaNegocio.generaSACliente().crearCliente(cliente); //lo añadimos a la BBDD por primera vez
		TCliente clienteLeido = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		
		assertEquals(clienteLeido.getActivo(), false);
		
		int idEliminado = factoriaNegocio.generaSACliente().borrarCliente(clienteLeido.getIDCliente());
		
		assertEquals(idEliminado, -1); //comprobamos que ha devuelto el integer esperado de error (-2 implica que ya esta a falso en la BBDD)
		assertEquals(factoriaNegocio.generaSACliente().readCliente(clienteLeido.getIDCliente()).getActivo(), false); //comprobamos que sigue en false en la BBDD
		
		deleteFromTests("12345678k");
		
		//comprobamos ahora que no se puede eliminar uno de la BBDD si no existe
		TCliente clienteLeidoNoExistente = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		assertEquals(clienteLeidoNoExistente, null);
		//assertEquals((int) factoriaNegocio.generaSACliente().borrarCliente(clienteLeidoNoExistente.getIDCliente()), -2);
		
		
	}
	
	@Test
	public void testUpdatePassed() {
		
		deleteFromTests("12345678k");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		cliente = new TCliente();
		cliente.setNombre("nombre");
		cliente.setDNI("12345678k");
		cliente.setDireccion("direccion");
		cliente.setActivo(true);
		cliente.setTelefono(123);
		
		Integer id = factoriaNegocio.generaSACliente().crearCliente(cliente); //lo añadimos a la BBDD por primera vez
		TCliente clienteLeido = factoriaNegocio.generaSACliente().readCliente(id); //comprobamos que el metodo devuelve el id del cliente añadido
		
		clienteLeido.setNombre("cambiado");
		clienteLeido.setDireccion("cambiada");
		
		int idActualizado = factoriaNegocio.generaSACliente().updateCliente(clienteLeido);
		
		TCliente nuevoCliente = factoriaNegocio.generaSACliente().readCliente(idActualizado); 
		
		assertEquals(nuevoCliente.getNombre(), "cambiado");
		assertEquals(nuevoCliente.getDireccion(), "cambiada");
		
		deleteFromTests("12345678k");
		
	}
	
	@Test
	public void testUpdateFailed() {
		
		deleteFromTests("12345678k");
		
		FactoriaNegocio factoriaNegocio = FactoriaNegocio.getInstance();
		
		TCliente clienteNoExistente = factoriaNegocio.generaSACliente().readCliente(-2); //comprobamos que este cliente no existe en bbdd (cliente con id -2)
		assertEquals(clienteNoExistente, null);
		
		clienteNoExistente = new TCliente();
		clienteNoExistente.setIDCliente(-2); //si lo dejamos a null no funciona
		
		int idClienteNoExistenteActualizado = factoriaNegocio.generaSACliente().updateCliente(clienteNoExistente);
		assertEquals(idClienteNoExistenteActualizado, -1); //-1 implica error
	}
}
