package Negocio.Competencia;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

import Negocio.Empleado.Empleado;

@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Competencia.Tiene.readByEmpleado", query = "select obj from Tiene obj where obj.empleado = :empleado and obj.activo = true"),
		@NamedQuery(name = "Negocio.Competencia.Tiene.readByCompetencia", query = "select obj from Tiene obj where obj.competencia = :competencia and obj.activo = true") })
public class Tiene implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private TieneID id;
	
	@Version
	private Integer version;
	
	private Boolean activo;

	private Integer nivel;

	@ManyToOne
	@JoinColumn(name="Competencia_IDCOMPETENCIA", insertable = false, updatable = false)
	private Competencia competencia;

	@ManyToOne
	@JoinColumn(name="Empleado_IDEMPLEADO",insertable = false, updatable = false)
	private Empleado empleado;

	public Tiene() {
	}

	public Tiene(Competencia competencia, Empleado empleado, Integer nivel) {
		this.competencia = competencia;
		this.empleado = empleado;
		this.nivel = nivel;
		this.activo = true;
		this.id = new TieneID(competencia.getIdCompetencia(), empleado.getIdEmpleado());
		
		
	}

	public Boolean getActivo() {

		return this.activo;
	}

	public Integer getNivel() {

		return this.nivel;
	}
	public void setID(TieneID id){
		this.id = id;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}
}