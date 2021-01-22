package Integracion.Empleado;

public class TTiempoParcial extends TEmpleado{

	private Integer sueldo_hora;

	private Integer horas_semana;


	public TTiempoParcial(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer sueldo_hora, Integer horas_semana) {
		super(id, telefono, activo, nombre, password);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}

	public TTiempoParcial(Integer telefono, Boolean activo, String nombre, String password, Integer departamento, Integer sueldo_hora, Integer horas_semana) {
		super(telefono, activo, nombre, password, departamento);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}
	public TTiempoParcial(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer departamento, Integer sueldo_hora, Integer horas_semana) {
		super(id, telefono, activo, nombre, password, departamento);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}
	
	
	public TTiempoParcial(TTiempoParcial empleado){
		super(empleado.getTelefono(), empleado.getActivo(), empleado.getNombre(), empleado.getPassword(), empleado.getDepartamento());
		this.horas_semana = empleado.getHorasSemana();
		this.sueldo_hora = empleado.getSueldoHora();
	}

	public Integer getSueldoHora() {
		return this.sueldo_hora;
	}

	public Integer getHorasSemana() {
		return this.horas_semana;
	}

	public void setSueldoHora(Integer sueldo_hora) {
		this.sueldo_hora = sueldo_hora;
	}

	public void setHorasSemana(Integer horas_semana) {
		this.horas_semana = horas_semana;
	}

}
