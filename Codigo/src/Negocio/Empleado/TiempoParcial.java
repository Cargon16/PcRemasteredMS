package Negocio.Empleado;

import java.io.Serializable;

import javax.persistence.Entity;

import Integracion.Empleado.TTiempoParcial;
import Negocio.Departamento.Departamento;

@Entity
public class TiempoParcial extends Empleado implements Serializable {

	@Override
	public String toString() {
		return "TiempoParcial [sueldo_hora=" + sueldo_hora + ", horas_semana=" + horas_semana + "]";
	}

	private static final long serialVersionUID = 1L;

	private Integer sueldo_hora;

	private Integer horas_semana;

	public TiempoParcial(){}

	public TiempoParcial(Integer id, Integer telefono, Boolean activo, String nombre, String password, Integer sueldo_hora, Integer horas_semana) {
		super(id, telefono, activo, nombre, password);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}

	public TiempoParcial(Integer telefono, Boolean activo, String nombre, String password, Departamento departamento, Integer sueldo_hora, Integer horas_semana) {
		super(telefono, activo, nombre, password, departamento);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}
	public TiempoParcial(Integer id, Integer telefono, Boolean activo, String nombre, String password, Departamento departamento, Integer sueldo_hora, Integer horas_semana) {
		super(id, telefono, activo, nombre, password, departamento);
		this.sueldo_hora = sueldo_hora;
		this.horas_semana = horas_semana;
	}
	
	
	public TiempoParcial(TTiempoParcial empleado){
		super(empleado.getTelefono(), empleado.getActivo(), empleado.getNombre(), empleado.getPassword(), null);
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

	@Override
	public int calcularNomina() {
		return this.horas_semana * this.sueldo_hora;
	}


}
