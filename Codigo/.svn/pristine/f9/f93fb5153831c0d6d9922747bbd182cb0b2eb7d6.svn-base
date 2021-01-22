package Integracion.Empleado;

public class TTiempoCompleto extends TEmpleado{

	private Integer sueldo;
	
	public TTiempoCompleto(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer sueldo) {
		super(id, telefono, activo, nombre, password);
		this.sueldo = sueldo;
	}

	public TTiempoCompleto(Integer telefono, Boolean activo, String nombre, String password, Integer departamento, Integer sueldo) {
		super(telefono, activo, nombre, password, departamento);
		this.sueldo = sueldo;
	}
	public TTiempoCompleto(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer departamento, Integer sueldo) {
		super(id, telefono, activo, nombre, password, departamento);
		this.sueldo = sueldo;
	}

	public TTiempoCompleto(TTiempoCompleto empleado) {
		super(empleado.getTelefono(), empleado.getActivo(), empleado.getNombre(), empleado.getPassword(), empleado.getDepartamento());
		this.sueldo = empleado.getSueldo();
		this.setTipoEmpleado("Permanente");
	}

	public Integer getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}
}
