package Negocio.Empleado;


import java.util.List;

import Integracion.Empleado.TEmpleado;


public interface SAEmpleado {
	
	public Integer crearEmpleado(TEmpleado empleado);

	public Integer borrarEmpleado(Integer idEmpleado);

	public Integer updateEmpleado(TEmpleado empleado);

	public TEmpleado readEmpleado(Integer idEmpleado);

	public List<TEmpleado> readAllEmpleados();


}
