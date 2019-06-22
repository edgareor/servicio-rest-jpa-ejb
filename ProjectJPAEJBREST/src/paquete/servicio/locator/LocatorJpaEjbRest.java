package paquete.servicio.locator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import paquete.ejb.InterfaceEjbJpaRemote;

public class LocatorJpaEjbRest {
	
	private InterfaceEjbJpaRemote ejb;
	
	public InterfaceEjbJpaRemote getEjb(){
	
		try {
		
		if (ejb==null) {
			Context jndi = new InitialContext();
			ejb = (InterfaceEjbJpaRemote) jndi.lookup("paquete.ejb.EjbJpa#paquete.ejb.InterfaceEjbJpaRemote");  // El EJB debe tener definido el atributo mappedName="beans.BussinesEJB"
		}
	
		return ejb;
	
		} catch(NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
