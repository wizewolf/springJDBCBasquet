package com.lab2.registroDeJugadores.model.vo;

public class Club extends AId {
	private String nombre,direccion;

	public Club(int id,String nombre, String direccion) {
		super(id);
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Club() {
		super();
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
