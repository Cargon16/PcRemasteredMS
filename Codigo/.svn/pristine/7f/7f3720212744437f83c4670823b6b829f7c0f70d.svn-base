package Negocio.Departamento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import Integracion.Departamento.TDepartamento;
import Negocio.Empleado.Empleado;

@Entity
@NamedQueries({
	@NamedQuery(name = "Negocio.Departamento.Departamento.readAll", query = "select obj from Departamento obj"),
	@NamedQuery(name = "Negocio.Departamento.Departamento.findBynombre", query = "select obj from Departamento obj where obj.nombre = :nombre")
	
})
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDepartamento;

	@Version
	private int version;
	
	private String nombre;
	
	private Float costeDepartamento;
	
	@OneToMany(mappedBy = "departamento")
	private List<Empleado> empleado;
	
	private Boolean activo;
	
	public Departamento(){}

	public Departamento(Integer idDepartamento, String nombre, Float costeDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.nombre = nombre;
		this.costeDepartamento = costeDepartamento;
		this.activo = true;
	}
	public Departamento(String nombre, Boolean activo) {
		super();
		this.nombre = nombre;
		this.costeDepartamento = (float)0;
		this.activo = activo;
	}
	public Departamento(TDepartamento departamento) {
		this.idDepartamento = departamento.getIdDepartamento();
		this.activo = departamento.getActivo();
		this.costeDepartamento = departamento.getCosteDept();
		this.nombre = departamento.getNombre();

	}
	
	
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Departamento(String nombre, Float costeDepartamento) {
		super();
		this.nombre = nombre;
		this.costeDepartamento = costeDepartamento;
	}
	
	
	public Integer getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Float getCosteDepartamento() {
		return costeDepartamento;
	}

	public List<Empleado> getEmpleados(){
		return this.empleado;
	}

	public void setCosteDepartamento(Float costeDepartamento) {
		this.costeDepartamento = costeDepartamento;
	}
	
	@Override
	public String toString() {
		return "TDepartamento [idDepartamento=" + idDepartamento + ", nombre=" + nombre
				+ ", costeDepartamento=" + costeDepartamento + "]";
	}



}
