package paquete.ejb;

import java.util.List;

import javax.ejb.Stateless;

import paquete.dao.PersonaDAOImpl;
import paquete.dao.PersonasDAO;
import paquete.entity.Persona;

@Stateless(name="EjbJpa", mappedName="paquete.ejb.EjbJpa")
public class EjbJpa implements InterfaceEjbJpaRemote, InterfaceEjbJpaLocal{
	
	PersonasDAO perDAO = new PersonaDAOImpl();
	
	@Override
	public List<Persona> extraerAllEJB() {
		return perDAO.extraerAll();
	}

	@Override
	public Persona extraerPorIdEJB(Persona person) {
		return perDAO.extraerPorId(person);
	}

	@Override
	public Persona extraerPorNombreEJB(Persona person) {
		return perDAO.extraerPorNombre(person);
	}

	@Override
	public void insertarPersonaEJB(Persona person) {
		perDAO.insertarPersona(person);
	}

	@Override
	public void modificarPersonaEJB(Persona person) {
		perDAO.modificarPersona(person);
	}

	@Override
	public void eliminarPersonaEJB(Persona person) {
		perDAO.eliminarPersona(person);
	}

	@Override
	public List<Persona> extraerAll2EJB() {
		return perDAO.extraerAll2();
	}

	@Override
	public int extraerMinEJB() {
		return perDAO.extraerMin();
	}

	@Override
	public int extraerMaxEJB() {
		return perDAO.extraerMax();
	}

	@Override
	public long contarPersonasEJB() {
		return perDAO.contarPersonas();
	}

}
