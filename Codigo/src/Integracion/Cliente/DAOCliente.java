/**
 * 
 */
package Integracion.Cliente;

import java.util.ArrayList;

import Negocio.Cliente.TCliente;

public interface DAOCliente {

	public Integer create(TCliente client);

	public TCliente readByID(Integer ID);

	public ArrayList<TCliente> readAll();

	public Integer delete(Integer ID);

	public TCliente readByDNI(String DNI);
	
	public Integer update(TCliente cliente);
}