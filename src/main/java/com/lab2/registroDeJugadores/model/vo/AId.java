package com.lab2.registroDeJugadores.model.vo;

public abstract class AId {
	public int id;

	public AId(int id) {
		this.id = id;
	}
	public AId() {
		this.id = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
