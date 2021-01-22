package Presentacion.Command;

public class Contexto {
	
	private Object datos;
	private int evento;
	
	public Contexto(int evento, Object datos) {
		
		this.datos = datos;
		this.evento = evento;
	}

	public Contexto() {
	}

	public Object getDatos() {
		return datos;
	}

	public void setDatos(Object datos) {
		this.datos = datos;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

}