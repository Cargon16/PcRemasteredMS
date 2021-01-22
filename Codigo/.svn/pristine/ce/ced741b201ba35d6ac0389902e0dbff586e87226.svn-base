package Negocio.Competencia;

import java.util.List;

import Integracion.Competencia.TCompetencia;
import Integracion.Empleado.TEmpleado;

public interface SACompetencia {
	
	public Integer crearCompetencia(TCompetencia competencia);

	public Integer borrarCompetencia(Integer idCompetencia);

	public List<TEmpleado> mostrarTodosLosEmpleadosQuePoseenCompetencia(Integer id);

	public TCompetencia readCompetencia(Integer idCompetencia);

	public List<TCompetencia> readAllCompetencias();
	
	public Integer addCompetenciaEmpleado(TieneID competenciaEmpleado, Integer nivel);
	
	public Integer deleteCompetenciaEmpleado(TieneID competenciaEmpleado);


}
