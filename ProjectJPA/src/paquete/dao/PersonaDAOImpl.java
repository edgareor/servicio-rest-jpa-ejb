package paquete.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import paquete.entity.Persona;

public class PersonaDAOImpl implements PersonasDAO{
	
	/* RESOURCE_LOCAL */
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManejoJPA");
    EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	/* JTA */
	
	/*
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    EntityTransaction tx = em.getTransaction();
    */
	
	@Override
	public List<Persona> extraerAll() {
		@SuppressWarnings("unchecked")
		List<Persona> list = em.createNamedQuery("Persona.findAll").getResultList();
		return list;
	}
	
	@Override
	public List<Persona> extraerAll2() {
		String consulta = "SELECT p FROM Persona p ORDER BY p.idPersona"; 
		Query query = em.createQuery(consulta);                             
		@SuppressWarnings("unchecked")
		List<Persona> list = query.getResultList();                         
		return list;
	}
	
	@Override
	public Persona extraerPorId(Persona person) {
		return em.find(Persona.class, person.getIdPersona());
	}

	@Override
	public Persona extraerPorNombre(Persona person) {
        Query query = em.createQuery("SELECT p FROM Persona p WHERE p.nombrePersona = :nombre").setParameter("nombre", person.getNombrePersona());
        return (Persona) query.getSingleResult();
	}

	@Override
	public void insertarPersona(Persona person) {
		tx.begin();                                        
		em.persist(person);
		tx.commit();
		System.out.println("Persona ingresada correctamente");
	}

	@Override
	public void modificarPersona(Persona person) {
		
		int id = person.getIdPersona();
		
		if(id==0) {
			
			System.out.println("Es necesario proporcionar un ID de persona para actualizar");
			
		} else {
			
			tx.begin();
			Persona per = em.find(Persona.class, person.getIdPersona());
			if(person.getNombrePersona()!=null) {
				if ((person.getNombrePersona().trim().isEmpty()==false)) {
					per.setNombrePersona(person.getNombrePersona());
				}
			}
			if(person.getApellidoPersona()!=null) {
				if ((person.getApellidoPersona().trim().isEmpty()==false)) {
					per.setApellidoPersona(person.getApellidoPersona());
				}
			}
			if(person.getRutPersona()!=null) {
				if ((person.getRutPersona().trim().isEmpty()==false)) {
					per.setRutPersona(person.getRutPersona());
				}
			}
			tx.commit();
			System.out.println("Persona modificada correctamente, revisar la BD");
		}
	}

	@Override
	public void eliminarPersona(Persona person) {
		tx.begin();
		Persona per = em.find(Persona.class, person.getIdPersona());
		em.remove(per);
		tx.commit();
		System.out.println("Persona Eliminada Correctamente");
	}

	@Override
	public int extraerMin(){
		Query query = em.createQuery("SELECT min(p.idPersona) FROM Persona p");
		int per = (int) query.getSingleResult();
		return per;
	}

	@Override
	public int extraerMax() {
		Query query = em.createQuery("SELECT max(p.idPersona) FROM Persona p");
		int per = (int) query.getSingleResult();
		return per;
	}

	@Override
	public long contarPersonas() {
		Query query = em.createQuery("SELECT count(p.idPersona) FROM Persona p");
		long per = (long) query.getSingleResult();
		return per;
	}

	@Override
	public String extraerByRut(String rutin) {
		StoredProcedureQuery spquery = em.createStoredProcedureQuery("EXTRAERDATES_BY_RUT", Persona.class);
		spquery.registerStoredProcedureParameter("rutin", String.class, ParameterMode.IN);
		spquery.registerStoredProcedureParameter("salida", String.class, ParameterMode.OUT);
		spquery.setParameter("rutin", rutin);
		spquery.execute();
		
		String out = (String) spquery.getOutputParameterValue("salida");
		
		return out;
	}
}
