package Negocio.Producto;

public class TOrdenador extends TProducto {

	private String Procesador;

	private Integer RAM;

	private String Grafica;

	private Integer Capacidad;

	@Override
	public String toString() {
		return "TOrdenador [Procesador=" + Procesador + ", RAM=" + RAM + ", Grafica=" + Grafica + ", Capacidad="
				+ Capacidad + ", Fuente=" + Fuente + ", PlacaBase=" + PlacaBase + ", ID=" + ID + "]";
	}

	private Integer Fuente;

	private String PlacaBase;
	
	private Integer ID;
	
	public TOrdenador (Integer id,Float precio,int stock,String nom,String descrp, String proce, int ram, String grafic, int capa, int fuente, String placa){
		super(id,precio,stock,nom,descrp);
		this.ID=id;
		this.Procesador=proce;
		this.RAM=ram;
		this.Grafica=grafic;
		this.Capacidad=capa;
		this.Fuente=fuente;
		this.PlacaBase=placa;
	
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getProcesador() {
		return Procesador;
	}

	public void setProcesador(String procesador) {
		Procesador = procesador;
	}

	public Integer getRAM() {
		return RAM;
	}

	public void setRAM(Integer rAM) {
		RAM = rAM;
	}

	public String getGrafica() {
		return Grafica;
	}

	public void setGrafica(String grafica) {
		Grafica = grafica;
	}

	public Integer getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		Capacidad = capacidad;
	}

	public String getPlacaBase() {
		return PlacaBase;
	}

	public void setPlacaBase(String placaBase) {
		PlacaBase = placaBase;
	}

	public Integer getFuente() {
		return Fuente;
	}

	public void setFuente(Integer fuente) {
		Fuente = fuente;
	}
}