package paquete.servicio.delegate;

import java.util.List;

import paquete.entity.Persona;
import paquete.servicio.locator.LocatorJpaEjbRest;

public class DelegateJpaEjbRest {
	
	private LocatorJpaEjbRest locator = new LocatorJpaEjbRest();
	
	public List<Persona> extraerAllEJBDelegate(){
		return locator.getEjb().extraerAllEJB();
	}
	
	public Persona extraerPorIdEJBDelegate(Persona person) {
		return locator.getEjb().extraerPorIdEJB(person);
	}

	public Persona extraerPorNombreEJBDelegate(Persona person) {
		return locator.getEjb().extraerPorNombreEJB(person);
	}

	public void insertarPersonaEJBDelegate(Persona person) {
		locator.getEjb().insertarPersonaEJB(person);
	}

	public void modificarPersonaEJBDelegate(Persona person) {
		locator.getEjb().modificarPersonaEJB(person);
	}

	public void eliminarPersonaEJBDelegate(Persona person) {
		locator.getEjb().eliminarPersonaEJB(person);
	}

	public List<Persona> extraerAll2EJBDelegate() {
		return locator.getEjb().extraerAll2EJB();
	}

	public int extraerMinEJBDelegate() {
		return locator.getEjb().extraerMinEJB();
	}

	public int extraerMaxEJBDelegate() {
		return locator.getEjb().extraerMaxEJB();
	}

	public long contarPersonasEJBDelegate() {
		return locator.getEjb().contarPersonasEJB();
	}

}
