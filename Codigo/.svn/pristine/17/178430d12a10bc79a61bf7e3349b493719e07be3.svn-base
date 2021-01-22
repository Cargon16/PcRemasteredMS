/**
 * 
 */
package Integracion.Query.Imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Query.Query;
import Integracion.TransactionManager.Transaction;
import Integracion.TransactionManager.TransactionManager;

public class MonitoresMasCompradosEnUnMes implements Query {

	@Override
	public ArrayList<String> execute(Object dato) {

		int mes = (Integer) dato;
		ArrayList<String> listaProductos = new ArrayList<String>();
		int max = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if (transaction != null) {
			Connection connect = (Connection) transaction.getResource();

			if (connect != null) {
				try {
					Statement state = connect.createStatement();
					String query = "SELECT producto.Nombre AS valor, COUNT( * ) AS veces" + " from producto"
							+ " join monitor on producto.ID = monitor.ID "
							+ "join lineaventa on monitor.ID = lineaventa.IDProducto "
							+ "join venta on lineaventa.IDVenta = venta.IDVenta " + "where month(venta.Fecha) = " + mes
							+ " GROUP BY producto.Nombre order by veces desc;";
					ResultSet result = state.executeQuery(query);
					while (result.next()) {
						if (Integer.valueOf(result.getString("veces")) >= max) {
							listaProductos.add(result.getString("valor"));
							max = Integer.valueOf(result.getString("veces"));
						}
					}

				} catch (SQLException e) {
					listaProductos = null;
				}
			}
		}
		return listaProductos;

	}

}