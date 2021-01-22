package Negocio.Departamento;

import java.util.List;

import Integracion.Departamento.TDepartamento;


public interface SADepartamento {
	
	public Integer crearDepartamento(TDepartamento departamento);

	public Integer borrarDepartamento(Integer idDepartamento);

	public Integer updateDepartamento(TDepartamento departamento);

	public TDepartamento readDepartamento(Integer idDepartamento);

	public List<TDepartamento> readAllDepartamentos();
	
	public int calcularCosteDepartamento(int id);

	
}
