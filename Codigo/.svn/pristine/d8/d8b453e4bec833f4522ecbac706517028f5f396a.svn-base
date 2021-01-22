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

public class OrdenadoresMasCompradosPorClientes implements Query {

	@Override
	public ArrayList<String> execute(Object obj) {
		int max = -1;
		int id = (Integer) obj;
		ArrayList<String> listaProductos = new ArrayList<String>();
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		if (transaction != null) {
			Connection connect = (Connection) transaction.getResource();

			if (connect != null) {
				try {
					Statement state = connect.createStatement();

					String query = "SELECT producto.Nombre AS valor, COUNT( * ) AS veces" + " from producto "
							+ "join ordenador on producto.ID = ordenador.ID "
							+ "join lineaventa on ordenador.ID = lineaventa.IDProducto "
							+ "join venta on lineaventa.IDVenta = venta.IDVenta "
							+ "where venta.IDCliente = " + id
							+ " GROUP BY producto.Nombre " + "ORDER BY veces desc;";
					ResultSet result = state.executeQuery(query);
					while (result.next()) {
						if(Integer.valueOf(result.getString("veces")) >= max){
							String p = result.getString("valor");
							listaProductos.add(p);
							max = Integer.valueOf(result.getString("veces"));
						}
					
					}

				} catch (SQLException e) {
					e.printStackTrace();
					listaProductos = null;
				}
			}
		}
		return listaProductos;

	}
}