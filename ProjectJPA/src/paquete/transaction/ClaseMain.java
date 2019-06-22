package paquete.transaction;

import java.util.List;

import paquete.dao.PersonaDAOImpl;
import paquete.dao.PersonasDAO;
import paquete.entity.Persona;

public class ClaseMain{

	public static void main (String [] args) {
        
        PersonasDAO perDAO = new PersonaDAOImpl();
      
        /**********   EXTRAER TODO NAMEDQUERY   **********/

        //List<Persona> perOut3 = perDAO.extraerAll();
        //for (Persona per : perOut3) {
        //    System.out.println();
        //    System.out.println(per);
        //}
        
        /**********   EXTRAER TODO QUERY   **********/

        List<Persona> perOut2 = perDAO.extraerAll2();
        for (Persona per : perOut2) {
            System.out.println();
            System.out.println(per);
        }
        
        /**********   EXTRAER POR ID   **********/

        //Persona persona2 = new Persona(5);
        //Persona perOut = perDAO.extraerPorId(persona2);
        //System.out.println();
        //System.out.println(perOut);
        
        /**********   EXTRAER POR NOMBRE   **********/

        //Persona persona4 = new Persona();
        //persona4.setNombre("emilio");
        //Persona perOut2 = perDAO.extraerPorNombre(persona4);
        //System.out.println();
        //System.out.println(perOut2);
        
        /**********   INSERTAR   **********/
        
        //System.out.println();
        //Persona persona1 = new Persona();
        //persona1.setApellidoPersona("PRueba");
        //persona1.setNombrePersona("Prueba");
        //persona1.setRutPersona("Prueba1");
        //perDAO.insertarPersona(persona1);
        
        /**********   MODIFICAR   **********/
        /*
        System.out.println();
        Persona persona5 = new Persona();
        persona5.setIdPersona(44);
        persona5.setNombrePersona("Margarita");
        persona5.setApellidoPersona("Espinoza");
        persona5.setRutPersona("34774568-4");
        perDAO.modificarPersona(persona5);
        */
        /**********   ELIMINAR   **********/
        
        //Persona persona3 = new Persona(35);
        //System.out.println();
        //perDAO.eliminarPersona(persona3);
        
        /**********   EXTRAER MIN ID   **********/
        
        //System.out.println();
        //System.out.println("Extraer ID Min:");
        //int per1 = perDAO.extraerMin();
        //System.out.println(per1);
        
        /**********   EXTRAER MAX ID   **********/
        /*
        System.out.println();
        System.out.println("Extraer ID Max:");
        int per2 = perDAO.extraerMax();
        System.out.println(per2);
        */
        /**********   CONTAR PERSONAS   **********/
        
        //System.out.println();
        //long per = perDAO.contarPersonas();
        //System.out.println(per);
        
        /**********   STORE PROCEDURE   **********/
        /*
        System.out.println();
        String per = perDAO.extraerByRut("26291417-8");
        System.out.println(per);
        */
	}
}