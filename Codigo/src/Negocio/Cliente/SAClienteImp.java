/**
 * 
 */
package Negocio.Cliente;

import java.util.ArrayList;

import Integracion.FactoriaIntegracion.FactoriaIntegracion;
import Integracion.TransactionManager.TransactionManager;

public class SAClienteImp implements SACliente {

	@Override
	public Integer crearCliente(TCliente cliente) {

		TransactionManager.getInstance().newTransaction().start();
		Integer retorno = -2;
		TCliente c = FactoriaIntegracion.getInstance().crearDAOCliente().readByDNI(cliente.getDNI());
		if (c == null) {
			retorno = FactoriaIntegracion.getInstance().crearDAOCliente().create(cliente);
			if (retorno != -1)
				TransactionManager.getInstance().getTransaction().Commit();
			else
				TransactionManager.getInstance().getTransaction().RollBack();
		} else {
			TransactionManager.getInstance().getTransaction().RollBack();
		}
		TransactionManager.getInstance().deleteTransaction();
		return retorno;

	}

	@Override
	public Integer borrarCliente(Integer idCliente) {


		TransactionManager.getInstance().newTransaction().start();

		Integer retorno = -1;
		TCliente clienteExiste =  FactoriaIntegracion.getInstance().crearDAOCliente().readByID(idCliente);
		if (clienteExiste == null) {
			TransactionManager.getInstance().getTransaction().RollBack();
			retorno = -2;
		} else {
			if (clienteExiste.getActivo()) {
				retorno =  FactoriaIntegracion.getInstance().crearDAOCliente().delete(idCliente);
				if (retorno != -1)
					TransactionManager.getInstance().getTransaction().Commit();
				else
					TransactionManager.getInstance().getTransaction().RollBack();
			} else
				TransactionManager.getInstance().getTransaction().RollBack();
		}
		TransactionManager.getInstance().deleteTransaction();

		return retorno;

	}

	@Override
	public Integer updateCliente(TCliente cliente) {

		TransactionManager.getInstance().newTransaction().start();
		Integer retorno = -1;
		TCliente clienteExiste =  FactoriaIntegracion.getInstance().crearDAOCliente().readByID(cliente.getIDCliente());

		if (clienteExiste == null) {
			TransactionManager.getInstance().getTransaction().RollBack();
		} else {
			retorno =  FactoriaIntegracion.getInstance().crearDAOCliente().update(cliente);
			if (retorno != -1)
				TransactionManager.getInstance().getTransaction().Commit();
			else
				TransactionManager.getInstance().getTransaction().RollBack();
		}

		TransactionManager.getInstance().deleteTransaction();

		return retorno;

	}

	@Override
	public TCliente readCliente(Integer idCliente) {

		TransactionManager.getInstance().newTransaction().start();
		TCliente retorno =  FactoriaIntegracion.getInstance().crearDAOCliente().readByID(idCliente);
		if (retorno != null){
			TransactionManager.getInstance().getTransaction().Commit();
		}else{
			TransactionManager.getInstance().getTransaction().RollBack();
		}
		TransactionManager.getInstance().deleteTransaction();

		return retorno;

	}

	@Override
	public ArrayList<TCliente> readAllClientes() {

		TransactionManager.getInstance().newTransaction().start();
		ArrayList<TCliente> retorno =  FactoriaIntegracion.getInstance().crearDAOCliente().readAll();

		if (retorno != null)
			TransactionManager.getInstance().getTransaction().Commit();
		else
			TransactionManager.getInstance().getTransaction().RollBack();

		TransactionManager.getInstance().deleteTransaction();
		return retorno;

	}
}