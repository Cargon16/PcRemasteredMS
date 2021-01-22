package Integracion.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.TransactionManager.Transaction;
import Integracion.TransactionManager.TransactionManager;
import Negocio.Cliente.TCliente;


public class DAOClienteImpl implements DAOCliente{

	public Integer create(TCliente client) {
		int id=-1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				
				int telefono;
				String direccion,nombre,DNI;
				boolean activo;
				
				//id = client.getIDCliente();
				telefono = client.getTelefono();
				DNI = client.getDNI();
				direccion = client.getDireccion();
				nombre = client.getNombre();
				activo = client.getActivo();
				try{
					//Statement state = connect.createStatement();
					
					String query = "INSERT INTO Cliente (Nombre, Direccion, Telefono, DNI, Activo) "
							+ "VALUES ('"
							+ nombre
							+"', '"
							+ direccion
							+"', "
							+ telefono
							+", '"
							+ DNI
							+"', "
							+ activo
							+ ");";
					PreparedStatement state = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
					state.execute();
					//ResultSet resultSet = state.executeQuery(query);
					ResultSet resultSet = state.getGeneratedKeys();
				
					if(resultSet.next()){
						id = resultSet.getInt(1);
					}
					state.close();
				}catch(SQLException e){
					e.printStackTrace();
					id = -1;
				}
			}
		}
		return id;
	}

	public TCliente readByID(Integer ID) {
		
		TCliente cliente = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String query = "SELECT * FROM cliente WHERE IDCliente=" + ID + " FOR UPDATE";
					ResultSet result = 	state.executeQuery(query);
					
					if(result.next()){
						cliente = new TCliente(
								result.getInt("IDCliente"), 
								result.getString("Nombre"), 
								result.getString("Direccion"), 
								result.getInt("Telefono"), 
								result.getString("DNI"),
								result.getBoolean("Activo"));
					}
					state.close();
				
				}catch(SQLException e){
					e.printStackTrace();
					cliente=null;
				}
				
			}
		}
		return cliente;
	}


	public ArrayList<TCliente> readAll() {
		ArrayList<TCliente> listaClientes = new ArrayList<TCliente>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					
					TCliente clientes = null;
					Statement state = connect.createStatement();
					String query = "SELECT * FROM Cliente FOR UPDATE ";
					ResultSet result = state.executeQuery(query);
					
					while(result.next()){
						clientes = new TCliente(
								result.getInt("IDCliente"), 
								result.getString("Nombre"), 
								result.getString("Direccion"), 
								result.getInt("Telefono"), 
								result.getString("DNI"),
								result.getBoolean("Activo"));
						
							listaClientes.add(clientes);
						}
					state.close();
					}catch(SQLException e){
					listaClientes = null;
				}
			}
		}
		return listaClientes;
	}


	public Integer delete(Integer ID) {
	int idCliente = -1;
	
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String query = "UPDATE Cliente SET Activo=false WHERE IDCliente =" + ID;
					state.executeQuery(query);
					idCliente = ID;
					state.close();
					
				}catch(SQLException e){
					idCliente = -1;
				}
			}
		}
		return idCliente;
	}


	public TCliente readByDNI(String DNI) {
		
		TCliente cliente = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();
			
			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					
					String query = "SELECT * FROM Cliente WHERE DNI='" + DNI +"'"+ " FOR UPDATE";

					ResultSet result = 	state.executeQuery(query);
					if(result.next()){
						cliente = new TCliente(
								result.getInt("IDCliente"), 
								result.getString("Nombre"), 
								result.getString("Direccion"), 
								result.getInt("Telefono"), 
								result.getString("DNI"),
								result.getBoolean("Activo"));

						state.close();
						}
					}catch(SQLException e){
					cliente = null;
				}
			}
		}
		return cliente;
	}

	@Override
	public Integer update(TCliente cliente) {
		int id=-1;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if(transaction !=null){
			Connection connect = (Connection) transaction.getResource();

			if(connect !=null){
				try{
					Statement state = connect.createStatement();
					String query = "UPDATE cliente SET  IDCliente=" + cliente.getIDCliente() + ", Nombre='" + cliente.getNombre()
					 + "', Direccion='" + cliente.getDireccion() + "', Telefono=" + cliente.getTelefono()
					 + ", DNI='" + cliente.getDNI() + "', Activo=" + cliente.getActivo() + " WHERE IDCliente=" + cliente.getIDCliente();
 
					state.executeQuery(query);
					id = cliente.getIDCliente();
					state.close();
				}catch(SQLException e){
					id = -1;
				}
			}
		}
		return id;
		
	}
}