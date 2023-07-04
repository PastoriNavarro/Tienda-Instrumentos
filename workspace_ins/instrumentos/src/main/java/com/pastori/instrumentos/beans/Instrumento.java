package com.pastori.instrumentos.beans;

public class Instrumento {
	private int id;
	private String nombre;
	private int idTipo;
	private Tipo tipos;
	
	public Instrumento() {
		
	}

	public Instrumento(int id, String nombre, int idTipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idTipo = idTipo;
	}

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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Tipo getTipos() {
		return tipos;
	}

	public void setTipos(Tipo tipos) {
		this.tipos = tipos;
	}
	
	
	
	

}
