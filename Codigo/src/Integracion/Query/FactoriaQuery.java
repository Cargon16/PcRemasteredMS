/**
 * 
 */
package Integracion.Query;

import Integracion.Query.Imp.MonitoresMasCompradosEnUnMes;
import Integracion.Query.Imp.OrdenadoresMasCompradosPorClientes;

public abstract class FactoriaQuery {

	private static FactoriaQuery instance;


	public static FactoriaQuery getInstance() {
		if(instance==null){
			instance = new FactoriaQueryImp();
		}
		return instance;
	}
	public abstract MonitoresMasCompradosEnUnMes generateQueryMonitoresMasCompradosEnUnMes();
	public abstract OrdenadoresMasCompradosPorClientes generateQueryOrdenadoresMasCompradosPorClientes();
}