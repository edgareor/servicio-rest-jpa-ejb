package paquete.dao;

import java.util.List;

import paquete.entity.*;

public interface PersonasDAO {
	
	public List<Persona> extraerAll();
	
	public List<Persona> extraerAll2();
	
	public Persona extraerPorId(Persona person);
	
	public Persona extraerPorNombre(Persona person);
	
	public void insertarPersona(Persona person);
	
	public void modificarPersona(Persona person);
	
	public void eliminarPersona(Persona person);
	
	public int extraerMin();
	
	public int extraerMax();
	
	public long contarPersonas();
	
	public String extraerByRut(String rutin);

}
