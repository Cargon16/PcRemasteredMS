package Negocio.Competencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TieneID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="Competencia_IDCOMPETENCIA")
	private int competencia;

	@Column(name="Empleado_IDEMPLEADO")
	private int empleado;
	

	public TieneID(){}
	public TieneID(Integer competencia, Integer empleado) {
		this.competencia = competencia;
		this.empleado = empleado;
	}

	public Integer getCompetencia() {
		return competencia;
	}


	public Integer getEmpleado() {
		return empleado;
	}


	public void setCompetencia(int competencia) {
		this.competencia = competencia;
	}


	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof TieneID && competencia == ((TieneID) o).getCompetencia()
				&& empleado == ((TieneID) o).getEmpleado());
	}

	@Override
	public int hashCode() {
		return competencia * 10000 + empleado;
	}
}