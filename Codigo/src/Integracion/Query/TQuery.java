package Integracion.Query;

import java.sql.Date;

public class TQuery {
	 private int numVenta;
	 private Date fecha;
	 
	 
	 public TQuery(int numVenta, Date fecha) {
	  super();
	  this.numVenta = numVenta;
	  this.fecha = fecha;
	 }
	 public int getNumVenta() {
	  return numVenta;
	 }
	 public void setNumVenta(int numVenta) {
	  this.numVenta = numVenta;
	 }
	 public Date getFecha() {
	  return fecha;
	 }
	 public void setFecha(Date fecha) {
	  this.fecha = fecha;
	 }
}
