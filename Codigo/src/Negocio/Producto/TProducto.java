package Negocio.Producto;

public class TProducto {
	
	@Override
	public String toString() {
		return "TProducto [ID=" + ID + ", Precio=" + Precio + ", Stock=" + Stock + ", Nombre=" + Nombre
				+ ", Descripcion=" + Descripcion + "]";
	}

	private Integer ID;
	
	private Float Precio;
	
	private Integer Stock;
	
	private String Nombre;
	
	private String Descripcion;

	
	public TProducto (Integer id, Float precio, Integer stock, String nom, String descrip){
		this.ID=id;
		this.Precio=precio;
		this.Stock=stock;
		this.Nombre=nom;
		this.Descripcion=descrip;
	}
	
	public TProducto() {
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Float getPrecio() {
		return Precio;
	}

	public void setPrecio(Float precio) {
		Precio = precio;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	
	
}