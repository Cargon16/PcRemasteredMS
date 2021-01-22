package Negocio.FactoriaNegocio;

import Negocio.Cliente.SAClienteImp;
import Negocio.Competencia.SACompetenciaImpl;
import Negocio.Departamento.SADepartamentoImpl;
import Negocio.Empleado.SAEmpleadoImpl;
import Negocio.Producto.SAProductoImp;
import Negocio.Venta.SAVentaImp;

public abstract class FactoriaNegocio {

	private static FactoriaNegocio instance;

	public static synchronized FactoriaNegocio getInstance() {		
		if ( instance==null){
			instance= new FactoriaNegocioImp();
		}
		return instance;		
	}

	public abstract SAClienteImp generaSACliente();

	public abstract SAProductoImp generaSAProducto();

	public abstract SAVentaImp generaSAVenta();

	public abstract SACompetenciaImpl generaSACompetencia();
	
	public abstract SADepartamentoImpl generaSADepartamento();
	
	public abstract SAEmpleadoImpl generaSAEmpleado();


}