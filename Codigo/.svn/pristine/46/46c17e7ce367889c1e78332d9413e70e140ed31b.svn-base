package Negocio.Empleado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Integracion.Empleado.TEmpleado;
import Integracion.Empleado.TTiempoCompleto;
import Integracion.Empleado.TTiempoParcial;
import Negocio.Competencia.Tiene;
import Negocio.Departamento.Departamento;
import Negocio.Parseador.Parseador;

public class SAEmpleadoImpl implements SAEmpleado {

	@Override
	public Integer crearEmpleado(TEmpleado empleado) {
		int retorno = -1;
		if (empleado != null) {
			Empleado e = null;
			if (empleado.getTipoEmpleado().equals("TiempoCompleto")) {
				e = new TiempoCompleto((TTiempoCompleto) empleado);
			} else {
				e = new TiempoParcial((TTiempoParcial) empleado);
			}
			if(e.calcularNomina() > 0){
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			TypedQuery<Empleado> consulta = entityManager.createNamedQuery("Negocio.Empleado.Empleado.findByNombre", Empleado.class);
			consulta.setParameter("nombre", e.getNombre());
			List<Empleado> existe = consulta.getResultList();
			// Se comprueba si ningun empleado con ese nombre existe
			if (existe.isEmpty()) {
				e.setActivo(empleado.getActivo());
				Departamento departamento = entityManager.find(Departamento.class, empleado.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				// Si el departamento existe y está activo
				if (departamento != null && departamento.getActivo()) {
					e.setDepartamento(departamento);
					entityManager.persist(e);
					entityTransaction.commit();
					retorno = e.getIdEmpleado();
				} else{
					retorno =-4;
					entityTransaction.rollback();
				}

			} else {
				//Si estaba inactivo, se reactiva
				Empleado empleadoAntiguo = existe.get(0);
				if (!empleadoAntiguo.getActivo() && empleadoAntiguo.getDepartamento().getActivo()) {
					empleadoAntiguo.setActivo(empleado.getActivo());
					entityTransaction.commit();
					retorno = empleadoAntiguo.getIdEmpleado();
				} else
					entityTransaction.rollback();
			}

			entityManager.close();
			emfactory.close();
			}
		}

		return retorno;
	}

	@Override
	public Integer borrarEmpleado(Integer idEmpleado) {
		int retorno = -1;
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
		EntityManager entityManager = emfactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Empleado empleado = entityManager.find(Empleado.class, idEmpleado);
		if (empleado != null) {
			entityManager.lock(empleado.getDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (empleado.getActivo()) {
				TypedQuery<Tiene> consulta = entityManager.createNamedQuery("Negocio.Competencia.Tiene.readByEmpleado",
						Tiene.class);
				consulta.setParameter("empleado", empleado);
				List<Tiene> competenciasDeEmpleado = consulta.getResultList();
				if (competenciasDeEmpleado.isEmpty()) {
					empleado.setActivo(false);
					entityTransaction.commit();
					retorno = idEmpleado;
				} else {
					for (Tiene t : competenciasDeEmpleado) {
						t.setActivo(false);
					}
					empleado.setActivo(false);
					entityTransaction.commit();
					retorno = idEmpleado;
				}
			} else
				entityTransaction.rollback();
		} else
			entityTransaction.rollback();
		entityManager.close();
		emfactory.close();

		return retorno;
	}

	@Override
	public Integer updateEmpleado(TEmpleado empleado) {
		int retorno = -1;
		if (empleado != null) {
			int idEmpleado = empleado.getIdEmpleado();
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Empleado empAntiguo = entityManager.find(Empleado.class, idEmpleado);
			int idNuevoDepartamento = empleado.getDepartamento();
			Departamento nuevoDepartamento = entityManager.find(Departamento.class, idNuevoDepartamento, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (nuevoDepartamento != null && nuevoDepartamento.getActivo()) {
				if (empleado.getTipoEmpleado().equals("TiempoParcial") && empAntiguo.getTipoEmpleado().equals("TiempoParcial")) {
					empAntiguo.setActivo(empleado.getActivo());
					empAntiguo.setDepartamento(nuevoDepartamento);
					empAntiguo.setNombre(empleado.getNombre());
					empAntiguo.setPassword(empleado.getPassword());
					empAntiguo.setTelefono(empleado.getTelefono());
					((TiempoParcial) empAntiguo).setHorasSemana(((TTiempoParcial) empleado).getHorasSemana());
					((TiempoParcial) empAntiguo).setSueldoHora(((TTiempoParcial) empleado).getSueldoHora());
					retorno = idEmpleado;
					entityTransaction.commit();

				} 
				else if (empleado.getTipoEmpleado().equals("TiempoCompleto") && empAntiguo.getTipoEmpleado().equals("TiempoCompleto")) {
					empAntiguo.setActivo(empleado.getActivo());
					empAntiguo.setDepartamento(nuevoDepartamento);
					empAntiguo.setPassword(empleado.getPassword());
					empAntiguo.setNombre(empleado.getNombre());
					empAntiguo.setTelefono(empleado.getTelefono());
					((TiempoCompleto) empAntiguo).setSueldo(((TTiempoCompleto) empleado).getSueldo());
					retorno = idEmpleado;
					entityTransaction.commit();

				} else{
					retorno = -2;
					entityTransaction.rollback();
				}
					

			} else
				entityTransaction.rollback();
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	@Override
	public TEmpleado readEmpleado(Integer idEmpleado) {
		Empleado trabajador = null;
		TEmpleado t = null;
		boolean cond = Parseador.comprobarNumeroPositivo(idEmpleado);			
		
		if(cond) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				trabajador = entitymanager.find(Empleado.class, idEmpleado);
				
				if(trabajador == null)
					entitytransaction.rollback();
				else{
					if(trabajador.getTipoEmpleado().equals("TiempoCompleto")) t = new TTiempoCompleto(trabajador.getIdEmpleado(), trabajador.getTelefono(), trabajador.getActivo(), trabajador.getNombre(), trabajador.getPassword(), trabajador.getDepartamento().getIdDepartamento(),((TiempoCompleto)trabajador).getSueldo());
					else t = new TTiempoParcial(trabajador.getIdEmpleado(), trabajador.getTelefono(), trabajador.getActivo(), trabajador.getNombre(), trabajador.getPassword(), trabajador.getDepartamento().getIdDepartamento(),((TiempoParcial)trabajador).getSueldoHora(), ((TiempoParcial)trabajador).getHorasSemana());
					entitytransaction.commit();
				}
				
				entitymanager.close();
				emfactory.close();
			}
			catch(PersistenceException ex) {}
		}
		return t;
	}

	@Override
	public List<TEmpleado> readAllEmpleados() {
		List<Empleado> lista = null;
		List<TEmpleado> l = new ArrayList<TEmpleado>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
				
			TypedQuery<Empleado> query = entitymanager.createNamedQuery("Negocio.Empleado.Empleado.readAllEmpleados", Empleado.class);
			lista = query.getResultList();
			
			for(Empleado e: lista){
				TEmpleado t;
				if(e.getTipoEmpleado().equals("TiempoCompleto")) t = new TTiempoCompleto(e.getIdEmpleado(), e.getTelefono(), e.getActivo(), e.getNombre(), e.getPassword(), e.getDepartamento().getIdDepartamento(),((TiempoCompleto)e).getSueldo());
				else t = new TTiempoParcial(e.getIdEmpleado(), e.getTelefono(), e.getActivo(), e.getNombre(), e.getPassword(), e.getDepartamento().getIdDepartamento(),((TiempoParcial)e).getSueldoHora(), ((TiempoParcial)e).getHorasSemana());
				l.add(t);
			}
			
			entitytransaction.commit();
				
			entitymanager.close();
			emfactory.close();
		} catch(PersistenceException ex) {}
		
		return l;
	}

}
