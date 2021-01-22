package Test;

import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.SADepartamentoImpl;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.SAEmpleadoImpl;

import static org.junit.Assert.*;

import org.junit.Test;

import Integracion.Departamento.TDepartamento;
import Integracion.Empleado.TEmpleado;
import Integracion.Empleado.TTiempoCompleto;

public class TestEmpleados {

	TEmpleado empCom;
	TEmpleado empPar;
	TDepartamento dep;
	SAEmpleado saE = new SAEmpleadoImpl();
	SADepartamento saD = new SADepartamentoImpl();
	
	@Test
	public void testCreatePassed() {
		//Tiempo Completo
		//creamos un empleado
		empCom = new TTiempoCompleto(123456789, true, "tiempoCompletoCr", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
		
		//tenemos que crear tambien un departamento, lo creamos 
		dep = new TDepartamento("departamentoCr", true);

		// lo creamos
		int codigoDep = saD.crearDepartamento(dep);

		// comprobamos que se ha subido (lo leemos)
		TDepartamento comprobar = saD.readDepartamento(codigoDep);
		assertEquals(comprobar.getNombre(), dep.getNombre());
		
		//asociamos el departamento al empleado
		empCom.setDepartamento(codigoDep);
		
		//probamos a subirlo
		
		int codigoEmp = saE.crearEmpleado(empCom);
		
		TEmpleado empComLeido = saE.readEmpleado(codigoEmp);
		
		assertEquals(empComLeido.getNombre(), empCom.getNombre()); //comprobamos que existia y estaba en bbdd
	
		saE.borrarEmpleado(codigoEmp);
		saD.borrarDepartamento(codigoDep); // para dejar la bbdd como estaba
	}
	
	@Test
	public void testCreateFailed() {
		//tenemos varios casos de error (el id indica el caso de error):
		// -1 --> empleado es null
		// -4 --> el departamento asociado al empleado no existe(o está inactivo)
		
		// -1:
		empCom = null;
		int codigoError = saE.crearEmpleado(empCom);
		assertEquals(codigoError, -1);
		
		//-4:
		//creamos primero un empleado
		empCom = new TTiempoCompleto(123456789, true, "tiempoCompletoCF", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
		
		//le asociamos departamento que no existe
		empCom.setDepartamento(-1);
		//probamos a subirlo
		
		codigoError = saE.crearEmpleado(empCom);
		assertEquals(codigoError, -4);
	}
	
	@Test
	public void testDeletePassed() {
		//Tiempo Completo
		//creamos un empleado
		empCom =new TTiempoCompleto(123456789, true, "tiempoCompletoD", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
		
		//tenemos que crear tambien un departamento, lo creamos 
		dep = new TDepartamento("departamentoDel", true);

		// lo creamos
		int codigoDep = saD.crearDepartamento(dep);

		// comprobamos que se ha subido (lo leemos)
		TDepartamento comprobar = saD.readDepartamento(codigoDep);
		assertEquals(comprobar.getNombre(), dep.getNombre());
				
		//asociamos el departamento al empleado
		empCom.setDepartamento(codigoDep);
				
		//probamos a subirlo
		
		int codigoEmp = saE.crearEmpleado(empCom);
				
		TEmpleado empComLeido = saE.readEmpleado(codigoEmp);
				
		assertEquals(empComLeido.getNombre(), empCom.getNombre()); //comprobamos que existia y estaba en bbdd
		
		//pasamos ahora a eliminarlo
		
		int codigo = saE.borrarEmpleado(codigoEmp);
		empComLeido = saE.readEmpleado(codigo);
		assertEquals(empComLeido.getActivo(), false);//comprobamos que esta eliminado (activo a false)
		
		
		saD.borrarDepartamento(codigoDep); // para dejar la bbdd como estaba
	}
	
	@Test
	public void testDeleteFailed() {
		//para que falle, o el empleado no existe o ya esta inactivo
		//probemos las dos
		assertEquals(saE.readEmpleado(-1), null); //comprobamos que no existe empleado con id -1
		
		//probamos a eliminar el empleado con id -1
		int codigoError = saE.borrarEmpleado(-1);
		assertEquals(codigoError, -1); //el codigo de error es -1, no estoy comparando ids
		
		//probamos ahora a eliminar un empleado ya eliminado
		//creamos un empleado
		empCom =new TTiempoCompleto(123456789, true, "tiempoCompletoDF", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
						
		//tenemos que crear tambien un departamento, lo creamos 
		dep = new TDepartamento("departamentoDelF", true);

		// lo creamos
		int codigoDep = saD.crearDepartamento(dep);

		// comprobamos que se ha subido (lo leemos)
		TDepartamento comprobar = saD.readDepartamento(codigoDep);
		assertEquals(comprobar.getNombre(), dep.getNombre());
						
		//asociamos el departamento al empleado
		empCom.setDepartamento(codigoDep);
						
		//probamos a subirlo
				
		int codigoEmp = saE.crearEmpleado(empCom);
						
		TEmpleado empComLeido = saE.readEmpleado(codigoEmp);
						
		assertEquals(empComLeido.getNombre(), empCom.getNombre()); //comprobamos que existia y estaba en bbdd
				
		//pasamos ahora a eliminarlo
				
		int codigo = saE.borrarEmpleado(codigoEmp);
		empComLeido = saE.readEmpleado(codigo);
		assertEquals(empComLeido.getActivo(), false);//comprobamos que esta eliminado (activo a false)
		
		//probamos ahora a eliminarlo de nuevo
		
		codigoError = saE.borrarEmpleado(codigoEmp);
		assertEquals(codigoError, -1);
				
		saD.borrarDepartamento(codigoDep); // para dejar la bbdd como estaba
	
	}
	
	@Test
	public void testUpdatePassed() {
		//creamos primero un empleado, y luego lo actualizamos
		empCom =new TTiempoCompleto(123456789, true, "tiempoCompletoU", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
						
		//tenemos que crear tambien un departamento, lo creamos 
		dep = new TDepartamento("departamentoUpdate", true);

		// lo creamos
		int codigoDep = saD.crearDepartamento(dep);

		// comprobamos que se ha subido (lo leemos)
		TDepartamento comprobar = saD.readDepartamento(codigoDep);
		assertEquals(comprobar.getNombre(), dep.getNombre());
						
		//asociamos el departamento al empleado
		empCom.setDepartamento(codigoDep);
						
		//probamos a subirlo
				
		int codigoEmp = saE.crearEmpleado(empCom);
						
		TEmpleado empComLeido = saE.readEmpleado(codigoEmp);
						
		assertEquals(empComLeido.getNombre(), empCom.getNombre()); //comprobamos que existia y estaba en bbdd
		
		//pasamos ahora a actualizarlo
		
		empComLeido.setNombre("cambiado");
		empComLeido.setTipoEmpleado("TiempoCompleto");
		int codigo = saE.updateEmpleado(empComLeido);
		TEmpleado empLeido = saE.readEmpleado(codigo);
		assertEquals(empLeido.getNombre(), "cambiado");
		
		empLeido.setNombre("tiempoCompletoU");
		empLeido.setTipoEmpleado("TiempoCompleto");
		saE.updateEmpleado(empLeido); //para que no cree constantemente empleados nuevos cada vez que generamos junit, ya que asi reactiva el mismo siempre.
		
		saE.borrarEmpleado(codigoEmp);
		saD.borrarDepartamento(codigoDep); // para dejar la bbdd como estaba
	}
	
	@Test
	public void testUpdateFailed() {
		//para que falle, o el empleado no existe, o el nuevo departamento a asociar tampoco existe
		
		//primero intentamos actualizar un empleado null
		
		empCom = null;
		int codigoError = saE.updateEmpleado(empCom);
		assertEquals(codigoError, -1); //comprobamos que devuelve el codigo de error 
		
		//probamos ahora a intentar actualizar con un departamento que no existe
		//creamos primero un empleado, y luego lo actualizamos
		empCom =new TTiempoCompleto(123456789, true, "tiempoCompletoUF", "password", null, 100);
		empCom.setTipoEmpleado("TiempoCompleto");
								
		//tenemos que crear tambien un departamento, lo creamos 
		dep = new TDepartamento("departamentoUpdatefail", true);

		// lo creamos
		int codigoDep = saD.crearDepartamento(dep);

		// comprobamos que se ha subido (lo leemos)
		TDepartamento comprobar = saD.readDepartamento(codigoDep);
		assertEquals(comprobar.getNombre(), dep.getNombre());
								
		//asociamos el departamento al empleado
		empCom.setDepartamento(codigoDep);
								
		//probamos a subirlo
						
		int codigoEmp = saE.crearEmpleado(empCom);
								
		TEmpleado empComLeido = saE.readEmpleado(codigoEmp);
								
		assertEquals(empComLeido.getNombre(), empCom.getNombre()); //comprobamos que existia y estaba en bbdd
		
		//pasamos ahora a intentar actualizar con un departamento no existente
		assertEquals(saD.readDepartamento(-1), null); //comprobamos que no existe
		
		dep.setIdDepartamento(-1);
		empComLeido.setDepartamento(-1);//le asociamos el departamento no existente
		codigoError = saE.updateEmpleado(empComLeido);
		assertEquals(codigoError, -1); //comprobamos que devuelve el error
		
		
		
		saE.borrarEmpleado(codigoEmp);
		saD.borrarDepartamento(codigoDep); // para dejar la bbdd como estaba
	}
	
}
