package Integracion.Competencia;

public class TCompetencia {

	private Integer idCompetencia;
	private String nombre;
	private boolean activa;
	

	public TCompetencia(Integer idCompetencia, String nombre) {
		this.idCompetencia = idCompetencia;
		this.nombre = nombre;
		this.activa = true;
	}
	public TCompetencia(Integer idCompetencia, String nombre, boolean activo) {
		this.idCompetencia = idCompetencia;
		this.nombre = nombre;
		this.activa = activo;
	}

	public TCompetencia(String text, boolean ok) {
		this.nombre = text;
		this.activa = ok;
	}
	
	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
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
}
