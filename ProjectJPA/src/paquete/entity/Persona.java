package paquete.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement
@Entity
@Table(name = "PERSONAS")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p ORDER BY p.idPersona")
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = -6408544422449021621L;

		@SequenceGenerator(name="SEQUENCE1", initialValue=43, allocationSize=1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQUENCE1")
		@Id
	    @Column(name = "PERSONA_ID", length = 20)
	    private int idPersona;

	    @Column(name = "NOMBRE", length = 20)
	    private String nombrePersona;

	    @Column(name = "APELLIDO", length = 20)
	    private String apellidoPersona;

	    @Column(name = "RUT", length = 20)
	    private String rutPersona;

	    public Persona() {
	    }

	    public Persona(int idPersona) {
	        this.idPersona = idPersona;
	    }
	    
	    public Integer getIdPersona() {
			return idPersona;
		}

		public void setIdPersona(Integer idPersona) {
			this.idPersona = idPersona;
		}

		public String getNombrePersona() {
			return nombrePersona;
		}

		public void setNombrePersona(String nombre) {
			this.nombrePersona = nombre;
		}

		public String getApellidoPersona() {
			return apellidoPersona;
		}

		public void setApellidoPersona(String apellidoPersona) {
			this.apellidoPersona = apellidoPersona;
		}

		public String getRutPersona() {
			return rutPersona;
		}

		public void setRutPersona(String rutPersona) {
			this.rutPersona = rutPersona;
		}

		@Override
	    public String toString() {
	        return "Persona [idPersona=" + idPersona + ", nombrePersona=" + nombrePersona
	                + ", apellidoPersona=" + apellidoPersona + ", rutPersona=" + rutPersona + "]";
	    }
	}

