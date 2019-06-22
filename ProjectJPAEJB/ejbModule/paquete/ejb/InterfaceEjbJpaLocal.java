package paquete.ejb;

import java.util.List;

import javax.ejb.Local;

import paquete.entity.Persona;

@Local
public interface InterfaceEjbJpaLocal {

	public List<Persona> extraerAllEJB();
	
	public List<Persona> extraerAll2EJB();
	
	public Persona extraerPorIdEJB(Persona person);
	
	public Persona extraerPorNombreEJB(Persona person);
	
	public void insertarPersonaEJB(Persona person);
	
	public void modificarPersonaEJB(Persona person);
	
	public void eliminarPersonaEJB(Persona person);
	
	public int extraerMinEJB();
	
	public int extraerMaxEJB();
	
	public long contarPersonasEJB();
}
