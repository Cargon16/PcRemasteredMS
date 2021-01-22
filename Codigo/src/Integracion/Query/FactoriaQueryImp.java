/**
 * @author Sergio Villarroel Fernández 	svillarr@ucm.es
 *
 *
 */
package Integracion.Query;

import Integracion.Query.Imp.MonitoresMasCompradosEnUnMes;
import Integracion.Query.Imp.OrdenadoresMasCompradosPorClientes;


public class FactoriaQueryImp extends FactoriaQuery {

	@Override
	public MonitoresMasCompradosEnUnMes generateQueryMonitoresMasCompradosEnUnMes() {
		// TODO Auto-generated method stub
		return new MonitoresMasCompradosEnUnMes();
	}

	@Override
	public OrdenadoresMasCompradosPorClientes generateQueryOrdenadoresMasCompradosPorClientes() {
		// TODO Auto-generated method stub
		return new OrdenadoresMasCompradosPorClientes();
	}


}