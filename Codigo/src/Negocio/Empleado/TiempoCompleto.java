package Negocio.Empleado;

import java.io.Serializable;

import javax.persistence.Entity;

import Integracion.Empleado.TTiempoCompleto;
import Negocio.Departamento.Departamento;
@Entity
public class TiempoCompleto extends Empleado implements Serializable {

	@Override
	public String toString() {
		return "TiempoCompleto [sueldo=" + sueldo + "]";
	}

	private static final long serialVersionUID = 1L;

	private Integer sueldo;

	public TiempoCompleto(){}
	
	public TiempoCompleto(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer sueldo) {
		super(id, telefono, activo, nombre, password);
		this.sueldo = sueldo;
	}

	public TiempoCompleto(Integer telefono, Boolean activo, String nombre, String password, Departamento departamento, Integer sueldo) {
		super(telefono, activo, nombre, password, departamento);
		this.sueldo = sueldo;
	}
	public TiempoCompleto(Integer id, Integer telefono, Boolean activo, String nombre, String password, Departamento departamento, Integer sueldo) {
		super(id, telefono, activo, nombre, password, departamento);
		this.sueldo = sueldo;
	}

	public TiempoCompleto(TiempoCompleto empleado) {
		super(empleado.getTelefono(), empleado.getActivo(), empleado.getNombre(), empleado.getPassword(), empleado.getDepartamento());
		this.sueldo = empleado.getSueldo();
		this.setTipoEmpleado("Permanente");
	}

	public TiempoCompleto(TTiempoCompleto empleado) {
		super(empleado.getTelefono(), empleado.getActivo(), empleado.getNombre(), empleado.getPassword(), null);
		this.sueldo = empleado.getSueldo();
		this.setTipoEmpleado("Permanente");
	}

	public Integer getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int calcularNomina() {
		// TODO Auto-generated method stub
		int prima = (int) (0.1 *this.sueldo);
		return sueldo + prima;
	}

}
