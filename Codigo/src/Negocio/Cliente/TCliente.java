package Negocio.Cliente;


public class TCliente {

	private Integer IDCliente;

	private String Nombre;

	private String Direccion;

	private Integer Telefono;

	private String DNI;

	private Boolean Activo;
	
	public TCliente (int id, String nom, String dir, int tele, String dni, Boolean act){
		this.IDCliente=id;
		this.Nombre=nom;
		this.Direccion=dir;
		this.Telefono=tele;
		this.DNI=dni;
		this.Activo=act;

	}
	
	public TCliente (String nom, String dir, int tele, String dni, Boolean activo) {
		this.Nombre=nom;
		this.Direccion=dir;
		this.Telefono=tele;
		this.DNI=dni;
		this.Activo=activo;
	}
	
	


	public TCliente() {
	}

	public Integer getIDCliente() {
		
		return IDCliente;

	}

	public String getNombre() {
	
		return Nombre;
	}

	public String getDireccion() {
		
		return Direccion;
	}

	public Integer getTelefono() {
	
		return Telefono;

	}

	public String getDNI() {
		
		return DNI;
	}

	public Boolean getActivo() {
		
		return Activo;
	}

	public void setIDCliente(Integer id) {
		
		this.IDCliente=id;
	}

	public void setNombre(String nom) {
	
		this.Nombre=nom;
	}


	public void setDireccion(String dir) {
		
		this.Direccion=dir;
	}


	public void setTelefono(Integer tel) {

		this.Telefono=tel;
	}

	public void setDNI(String dni) {
		
		this.DNI=dni;
	}

	public void setActivo(Boolean acti) {
		
		this.Activo=acti;
	}

}