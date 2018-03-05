package com.ml.ejercicio.domain;

public abstract class Cuerpo {
	
	private Posicion posicion;
	
	public Cuerpo(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	public abstract Cuerpo desplazar(long dias);
}
