package Negocio.Competencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Integracion.Competencia.TCompetencia;
import Integracion.Empleado.TEmpleado;
import Integracion.Empleado.TTiempoCompleto;
import Integracion.Empleado.TTiempoParcial;
import Negocio.Empleado.Empleado;
import Negocio.Empleado.TiempoCompleto;
import Negocio.Empleado.TiempoParcial;
import Negocio.Parseador.Parseador;

public class SACompetenciaImpl implements SACompetencia {

	@Override
	public Integer crearCompetencia(TCompetencia comp) {
		int id = -1;
		if(comp != null) {
			Competencia competencia = new Competencia(comp);
			String nombre = competencia.getNombre();
			boolean cond1 = Parseador.esAlfabetico(nombre);
			if(cond1) {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
				try {
					EntityManager entitymanager = emfactory.createEntityManager();
					EntityTransaction entitytransaction = entitymanager.getTransaction();
					entitytransaction.begin();
					TypedQuery<Competencia> query = entitymanager.createNamedQuery("Negocio.Competencia.Competencia.readByName", Competencia.class).setParameter("nombre", nombre);
					List<Competencia> lista = query.getResultList();
					if(lista.isEmpty()) {
						//competencia.setActiva(true);
						entitymanager.persist(competencia);
						entitytransaction.commit();
						id = competencia.getIdCompetencia();
					}
					else {
						Competencia competenciaResult = lista.get(0);
						boolean activo = competenciaResult.isActiva();
						if(activo) {
							id = -3;
							entitytransaction.rollback();
						}
						else {//Se reactiva
							competenciaResult.setActiva(competencia.isActiva());
							entitytransaction.commit();
							id = 100;
							//id = competenciaResult.getIdCompetencia(); 
						}
					}
					entitymanager.close();
					emfactory.close();
				} catch(PersistenceException ex) {
					id = -100;
				}
			}
			else
				id = -2;
			
		}
		return id;	
	}

	@Override
	public Integer borrarCompetencia(Integer idCompetencia) {
		int retorno = -2;
		if (idCompetencia != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, idCompetencia);
			if (competencia != null) {
				if (competencia.isActiva()) {
					TypedQuery<Tiene> consulta = entityManager.createNamedQuery("Negocio.Competencia.Tiene.readByCompetencia", Tiene.class);
					consulta.setParameter("competencia", competencia);
					if (consulta.getResultList().isEmpty()) {
						competencia.setActiva(false);
						entityTransaction.commit();
						retorno = idCompetencia;
					} else {
						boolean empleadoActivo = false;
						for (Tiene t : consulta.getResultList()) {
							entityManager.lock(t, LockModeType.OPTIMISTIC);
							if (t.getActivo()) {
								empleadoActivo = true;
							}
						}
						if (!empleadoActivo) {
							competencia.setActiva(false);
							entityTransaction.commit();
							retorno = idCompetencia;
						} else
							entityTransaction.rollback();
					}
				} else{
					entityTransaction.rollback();
					retorno = -1;
				}
			} else
				entityTransaction.rollback();
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	@Override
	public List<TEmpleado> mostrarTodosLosEmpleadosQuePoseenCompetencia(Integer id) {
		List<TEmpleado> retorno = new ArrayList<>();
		if (id != null && Parseador.comprobarNumeroPositivo(id)) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, id);
			if (competencia != null && competencia.isActiva()) {
				TypedQuery<Tiene> consulta = entityManager
						.createNamedQuery("Negocio.Competencia.Tiene.readByCompetencia", Tiene.class);
				consulta.setParameter("competencia", competencia);
				if (!consulta.getResultList().isEmpty()) {
					for (Tiene t : consulta.getResultList()) {
						entityManager.lock(t, LockModeType.OPTIMISTIC);
						Empleado e = t.getEmpleado();
						TEmpleado temp;
						if(e.getTipoEmpleado().equals("TiempoCompleto")) temp = new TTiempoCompleto(e.getIdEmpleado(), e.getTelefono(), e.getActivo(), e.getNombre(), e.getPassword(),((TiempoCompleto)e).getSueldo());
						else temp = new TTiempoParcial(e.getIdEmpleado(), e.getTelefono(), e.getActivo(), e.getNombre(), e.getPassword(),((TiempoParcial)e).getSueldoHora(), ((TiempoParcial)e).getHorasSemana());
						retorno.add(temp);
					}
					entityTransaction.commit();
				} else{
					retorno = null;
					entityTransaction.rollback();
				}
					

			} else {
				entityTransaction.rollback();
			}
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	@Override
	public TCompetencia readCompetencia(Integer idCompetencia) {
		Competencia competencia = null;
		TCompetencia c = null;
		boolean cond = Parseador.comprobarNumeroPositivo(idCompetencia);
		if(cond) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			try {
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				
				competencia = entitymanager.find(Competencia.class, idCompetencia);
				
				if(competencia == null)
					entitytransaction.rollback();
				else{
					c = new TCompetencia(competencia.getIdCompetencia(), competencia.getNombre(), competencia.isActiva());
					entitytransaction.commit();
				}
					
				
				entitymanager.close();
				emfactory.close();
			} catch(PersistenceException ex) {}
		}
		
		return c;
	}

	@Override
	public List<TCompetencia> readAllCompetencias() {
		List<Competencia> lista = null;
		List<TCompetencia> l = new ArrayList<TCompetencia>();
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
				
			TypedQuery<Competencia> query = entitymanager.createNamedQuery("Negocio.Competencia.Competencia.readAll", Competencia.class);
			lista = query.getResultList();
			
			for(Competencia c: lista){
				TCompetencia comp = new TCompetencia(c.getIdCompetencia(), c.getNombre(), c.isActiva());
				l.add(comp);
			}
			entitytransaction.commit();
				
			entitymanager.close();
			emfactory.close();
		} catch(PersistenceException ex) {}
		
		return l;
	}

	@Override
	public Integer addCompetenciaEmpleado(TieneID competenciaEmpleado, Integer nivel) {
		int retorno = -2;
		
		if (competenciaEmpleado.getCompetencia() != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Competencia competencia = entityManager.find(Competencia.class, competenciaEmpleado.getCompetencia());
			Empleado emp = entityManager.find(Empleado.class, competenciaEmpleado.getEmpleado());
			if (competencia != null && emp != null) {
				if (competencia.isActiva() && emp.getActivo()) {
					Tiene t = entityManager.find(Tiene.class, competenciaEmpleado);
					if(t == null){
						entityManager.persist(competencia);
						entityManager.lock(competencia, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						entityManager.lock(emp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						Tiene aux = new Tiene(competencia, emp, nivel);
						entityManager.persist(emp);
						entityManager.persist(aux);
						entityTransaction.commit();
						retorno = 1;
					}
					else{
						entityManager.lock(emp, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
						t.setActivo(true);
						entityManager.persist(t);
						entityTransaction.commit();
						retorno = 1;
					}
					
				} else{
					entityTransaction.rollback();
					retorno = -1;
				}
			} else
				entityTransaction.rollback();
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

	@Override
	public Integer deleteCompetenciaEmpleado(TieneID competenciaEmpleado) {
		int retorno = -2;
		if (competenciaEmpleado.getCompetencia() != null) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PcRemastered");
			EntityManager entityManager = emfactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Tiene t = entityManager.find(Tiene.class, competenciaEmpleado);
			Empleado e = entityManager.find(Empleado.class, competenciaEmpleado.getEmpleado());
			if (t != null && e != null) {
				if (t.getActivo()) {
					entityManager.lock(e, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
					t.setActivo(false);
					retorno = 1;
					entityTransaction.commit();
					
				} else{
					entityTransaction.rollback();
					retorno = -1;
				}
			} else
				entityTransaction.rollback();
			entityManager.close();
			emfactory.close();
		}
		return retorno;
	}

}
