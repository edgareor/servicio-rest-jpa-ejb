package paquete.entity;

import java.io.Serializable;

public class MensajeVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6419601449168622131L;
	private String mensaje;
	private String adicional;
	private String adicional2;

	public String getAdicional2() {
		return adicional2;
	}

	public void setAdicional2(String adicional2) {
		this.adicional2 = adicional2;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "MensajeVO [mensaje=" + mensaje + ", adicional=" + adicional + ", adicional2=" + adicional2 + "]";
	}
}
