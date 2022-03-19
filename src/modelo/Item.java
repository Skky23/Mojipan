package modelo;

public class Item {
	
	int id;
	String nombre;
	int cantidadDisponible;
	int precioUnidad;
	int costoUnidad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCantidad() {
		return cantidadDisponible;
	}
	public void setCantidad(int cantidad) {
		this.cantidadDisponible = cantidad;
	}
	public int getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(int precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public int getCostoUnidad() {
		return costoUnidad;
	}
	public void setCostoUnidad(int costoUnidad) {
		this.costoUnidad = costoUnidad;
	}
}
