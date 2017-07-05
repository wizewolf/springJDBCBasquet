package com.lab2.registroDeJugadores.model.vo;

import java.awt.Image;
import java.util.Date;

public class Jugador extends AId{
	private int dni,idclub,idClubPase;
	private boolean entregado;
	private String nombre,apellido,pase;
	private Date fechaNac;
	private Image foto;
	
	public Jugador() {
		super();
	}

	public Jugador(int id, int dni, int idclub, int idClubPase, boolean entregado, String nombre, String apellido,
			String pase, Date fechaNac, Image foto) {
		super(id);
		this.dni = dni;
		this.idclub = idclub;
		this.idClubPase = idClubPase;
		this.entregado = entregado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pase = pase;
		this.fechaNac = fechaNac;
		this.foto = foto;
	}

	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getIdclub() {
		return idclub;
	}
	public void setIdclub(int idclub) {
		this.idclub = idclub;
	}
	public boolean isEntregado() {
		return entregado;
	}
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPase() {
		return pase;
	}
	public void setPase(String pase) {
		this.pase = pase;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public java.sql.Date getFechaNacSql() {
		return new java.sql.Date(fechaNac.getTime());
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}

	public int getIdClubPase() {
		return idClubPase;
	}

	public void setIdClubPase(int idClubPase) {
		this.idClubPase = idClubPase;
	}

	@Override
	public String toString(){
		return "JugadorVo [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
}
