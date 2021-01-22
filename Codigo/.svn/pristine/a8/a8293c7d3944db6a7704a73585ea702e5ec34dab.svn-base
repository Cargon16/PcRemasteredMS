package Negocio.Venta;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

public class TVenta {

	private Integer IDVenta;
	private Date Fecha;
	private Boolean Pagado;	
	private Integer idCliente;	
	private Float precioTotal;	
	private HashMap<Integer, LineaVenta> lineaVentas;
	
	public TVenta(Integer iDVenta, Boolean pagado, Integer idCliente, Float precioTotal,Date fecha ,HashMap<Integer, LineaVenta> lineaVentas) {
		super();
		this.IDVenta = iDVenta;
		this.Pagado = pagado;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.lineaVentas = lineaVentas;
		this.Fecha=fecha;
	}
	
	public TVenta(Integer idClient2) {
		this.Pagado = false;
		this.precioTotal = (float)0;
		this.lineaVentas = new HashMap<Integer, LineaVenta>();
		this.Fecha = new Date(Calendar.getInstance().getTimeInMillis());
		this.idCliente = idClient2;
	}

	public TVenta() {
	}

	public Float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Float precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public HashMap<Integer, LineaVenta> getLineaVentas() {
		return lineaVentas;
	}

	public void setLineaVentas(HashMap<Integer, LineaVenta> lineaVentas) {
		this.lineaVentas = lineaVentas;
	}

	public Integer getIDVenta() {
		return IDVenta;
	}

	public void setIDVenta(Integer iDVenta) {
		IDVenta = iDVenta;
	}

	public Boolean getPagado() {
		return Pagado;
	}

	public void setPagado(Boolean activo) {
		Pagado = activo;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	
}