package paquete.servicio.rest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import paquete.entity.MensajeVO;
import paquete.entity.Persona;
import paquete.servicio.delegate.DelegateJpaEjbRest;

@Path("/personas")
public class ServicioRestJPAEJB {
	
 	private static Logger logger = Logger.getLogger(ServicioRestJPAEJB.class);
 	
	  @POST
	  @Path("/extrae-mensaje")
	  @Consumes("application/json; charset=utf-8")
	  @Produces("application/json; charset=utf-8")
	  	public MensajeVO imprimeMensaje(MensajeVO obj) throws Exception {
		  System.out.println(obj);
		  return obj;
	  }
	
	  @GET
	  @Path("/timenow")
	  @Produces({"application/json"})
	  	public JsonObject getStatus() throws Exception {
		  
		Date fecha = new Date ();
		logger.info("Instanciar objeto Date");
		Locale currentLocale = new Locale("EN");
		logger.info("Instancias Locale Idioma Ingles");
		DateFormat formato = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, currentLocale);
		logger.info("Crear formato de hora");
		String output = formato.format(fecha);
		logger.info("Asignar Formato a Hora");
		
		JsonObject object = Json.createObjectBuilder().add("getStatus",output).build();
		logger.info("creando objeto JSON como respuesta");
	    return object;
	  }
	  
		@GET
		@Path("/all")
		@Produces({"application/json"})
		public List<Persona> extraerAll() {
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			logger.info("Instanciar EJB para llamar sus metodos");
			List<Persona> objOut = obj.extraerAllEJBDelegate();
			logger.info("Llamada a metodo extraer todos y retornar la lista");
			return objOut;
		}
		
		@GET
		@Path("/{id}")
		@Produces({"application/xml"})
		public Response extraerPorId(@PathParam("id") int id) {
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			
			Persona per = new Persona();
			per.setIdPersona(id);
			
			Persona objOut = obj.extraerPorIdEJBDelegate(per);
			
			if (objOut != null) {
				return Response.ok().entity(objOut).build();
			} else {
				return Response.status(404).build();
			}
		}
		
		@POST
		@Path("/persona")
		@Consumes({"application/json"})
		@Produces({"application/json"})
		public Response insert(Persona person) { 
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			
			if(person.getIdPersona()==0) {
				long var = obj.contarPersonasEJBDelegate();
				String var2 = String.valueOf(var);
				int var3 = Integer.valueOf(var2);
				person.setIdPersona(var3+1);
			}
			
			obj.insertarPersonaEJBDelegate(person); 
			
			JsonObject object = Json.createObjectBuilder().add("Respuesta ", " Objeto Ingresado Correctamente").build();
			
			return Response.ok().entity(object).build();
		}
		
		@PUT
		@Path("/persona")
		@Consumes({"application/json"})
		@Produces({"application/json"})
		public Response update(Persona person) { 
			
			int id = person.getIdPersona();
			
			if (id==0) {
				
				JsonObject object = Json.createObjectBuilder().add("Respuesta: ", " Error, debe ingresar un ID valido para actualizar").build();
				
				return Response.status(404).entity(object).build();
				
			} else {
	
				DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			
				obj.modificarPersonaEJBDelegate(person); 
				
				JsonObject object = Json.createObjectBuilder().add("Respuesta: ", " Objeto Modificado Correctamente").build();
			
				return Response.ok().entity(object).build();
			}	
		}
		
		@DELETE
		@Path("/persona")
		@Consumes({"application/json"})
		@Produces({"application/json"})
		public Response delete(Persona person) { 
			
			int id = person.getIdPersona();
			
			if (id==0) {
				
				JsonObject object = Json.createObjectBuilder().add("Respuesta: ", " Error, debe ingresar un ID valido para borrar").build();
				
				return Response.status(404).entity(object).build();
			
			} else {
				
				DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
				obj.eliminarPersonaEJBDelegate(person); 
			
				JsonObject object = Json.createObjectBuilder().add("Respuesta ", " Objeto Eliminado Correctamente").build();
			
				return Response.ok().entity(object).build();
			}
		}
		
		@GET
		@Path("/minimo")
		@Produces({"application/json"})
		public Response extraerMinimo() {
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			int objOut = obj.extraerMinEJBDelegate();
			
			JsonObject object = Json.createObjectBuilder().add("Respuesta ", objOut).build();
			
			return Response.ok().entity(object).build();
		}
		
		@GET
		@Path("/maximo")
		@Produces({"application/json"})
		public Response extraerMaximo() {
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			int objOut = obj.extraerMaxEJBDelegate();
			
			JsonObject object = Json.createObjectBuilder().add("Respuesta ", objOut).build();
			
			return Response.ok().entity(object).build();
		}
		
		@GET
		@Path("/contar")
		@Produces({"application/json"})
		public Response contar() {
			
			DelegateJpaEjbRest obj = new DelegateJpaEjbRest();
			long objOut = obj.contarPersonasEJBDelegate();
			
			JsonObject object = Json.createObjectBuilder().add("Respuesta ", objOut).build();
			
			return Response.ok().entity(object).build();
		}

}
