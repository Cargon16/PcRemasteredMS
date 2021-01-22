package Negocio.Competencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import Integracion.Competencia.TCompetencia;
import Negocio.Empleado.Empleado;

@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Competencia.Competencia.readAll", query = "select obj from Competencia obj where obj.activa = true"),
		@NamedQuery(name = "Negocio.Competencia.Competencia.readByName", query = "select obj from Competencia obj where obj.nombre = :nombre") })
public class Competencia implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCompetencia;

	@Version
	private int version;
	private String nombre;
	private boolean activa;
	
	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	@ManyToMany
	private List<Empleado> empleado;
	
	
	public Competencia(){}
	
	public Competencia(Integer idCompetencia, String nombre) {
		super();
		this.idCompetencia = idCompetencia;
		this.nombre = nombre;
	}
	
	public Competencia( String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Competencia( String text, boolean ok) {
		super();
		this.nombre = text;
		this.activa = ok;
	}

	public Competencia(TCompetencia comp) {
		this.idCompetencia = comp.getIdCompetencia();
		this.nombre = comp.getNombre();
		this.activa = comp.isActiva();
	}

	public Integer getIdCompetencia() {
		return idCompetencia;
	}
	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TCompetencia [idCompetencia=" + idCompetencia + ", version=" + version 
				+ ", nombre=" + nombre + "]";
	}
	public void addEmpleado(Empleado emp){
		this.empleado.add(emp);
	}
	public void deleteEmpleado(Empleado emp){
		this.empleado.remove(emp);
	}

}
